package at.jku.isse.ide.assistance

import at.jku.isse.oclx.IteratorVarDeclaration
import at.jku.isse.oclx.MethodExp
import at.jku.isse.passiveprocessengine.core.SchemaRegistry
import at.jku.isse.validation.MethodRegistry
import at.jku.isse.validation.OCLXValidator
import at.jku.isse.validation.OclxASTUtils
import at.jku.isse.validation.TypeExtractor
import com.google.inject.Inject
import java.util.Collections
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.CodeActionKind
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource

class QuickFixCodeActionService implements ICodeActionService2 {
	
	@Inject
	TypeExtractor typeExtractor
	@Inject
	EObjectAtOffsetHelper eObjectAtOffsetHelper;
	@Inject 
	MethodRegistry methodReg;
	@Inject 
	SchemaRegistry schemaReg;
	
	DuplicateVariableQuickfixer duplicateFixer = new DuplicateVariableQuickfixer();
	SyntaxErrorFixer syntaxFixer = new SyntaxErrorFixer();
	
	public static double minSimilarityThreshold = 0.8;
	
	override getCodeActions(Options options) {
		
		var document = options.document
		val params = options.codeActionParams
		val result = <CodeAction>newArrayList
		var resource = options.resource as XtextResource
		
		if (document === null) { // then resource most likely also null
					//val content = getFileContent(params.textDocument.uri)
					//System.out.println(content)
					//document = new Document(1, content)
			val lsCtx = options.languageServerAccess.doSyncRead(params.textDocument.uri, [lsCtx |  return lsCtx] )
			document = lsCtx.document
			resource = lsCtx.resource as XtextResource		
		}
		if (document !== null) {
			for (d : params.context.diagnostics) {
				val stringToRepair = document.getSubstring(d.range)
				val offset = document.getOffSet(d.range.start)
				val modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
				if (d.code.get == org.eclipse.xtext.diagnostics.Diagnostic.SYNTAX_DIAGNOSTIC) {
					var repair =  syntaxFixer.trySyntaxFix(modelElement, stringToRepair, d, resource);
					if (repair !== null) {
						result += repair
					}
				} else if (d.code.get == OCLXValidator.UNKNOWN_TYPE) {					
					var repair =  new UnknownTypeQuickfixer(schemaReg).createReplaceWithMostSimilarTypeQuickFix(modelElement, stringToRepair, d, resource);
					if (repair !== null) {
						result += repair
					}
				} else if (d.code.get == OCLXValidator.DUPLICATE_VAR_NAME) {					
					var iterDecl = modelElement.eContainer;
					if (iterDecl instanceof IteratorVarDeclaration){
						result += duplicateFixer.createQuickfix(iterDecl, d, resource);	
					}
				} else if (d.code.get == OCLXValidator.UNKNOWN_PROPERTY) {																	
					result += new UnknownPropertyQuickfixer(typeExtractor, eObjectAtOffsetHelper, d, resource).createReplaceWithSubtype(offset, stringToRepair);					
					val choices = findMostSimilarProperties(stringToRepair, resource, offset, minSimilarityThreshold)
					if (choices.size() > 0) {
						val newProp = choices.get(0)
						generateCodeActionReplaceWithMostSimilarProperty(d, resource, newProp, result)
					}			
				} else if (d.code.get == OCLXValidator.UNKNOWN_OPERATION) {
					var choices = findMostSimilarOperations(resource, offset, stringToRepair)
					if (choices.size() > 0) {
						val newOp = choices.get(0)
						generateCodeActionReplaceWithMostSimilarOperation(d, resource, newOp, result)
					}
				}
			}
		
		}
		return result.map[Either.forRight(it)]
	}

	def ILanguageServerAccess.Context process(ILanguageServerAccess.Context ctx) {
		return ctx
	}

	static def Range getRangeOfElement(EObject exp) {
		if (exp === null) return null;
		val inode = NodeModelUtils.findActualNodeFor(exp)
		val startPos = inode.offset
		val startLine = inode.startLine-1 // we need zero based lines for Range
		val endPos = inode.endOffset
		val endLine = inode.endLine-1
		return new Range(new Position(startLine, startPos), new Position(endLine, endPos))
	}

	protected def findMostSimilarProperties(String partialPropertyName, XtextResource resource, int offset, double minSimilarityThreshold) {
		var completeWithType = resolvePropertyAccessOrMethodResourceToType(resource, offset);
		if (completeWithType !== null) {
			val choices = OclxContentProposalProvider.getSimilaritySortedProperties(completeWithType.getType(), partialPropertyName, minSimilarityThreshold);
			return choices
		}
		return Collections.emptyList()
	}

	def generateCodeActionReplaceWithMostSimilarProperty(Diagnostic d, XtextResource resource, String newProp, List<CodeAction> result) {	
		result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Replace with most similar property '"+newProp+"' "
						diagnostics = #[d]
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = d.range
								newText = newProp
							])
						]
					]
	}
	
	protected def findMostSimilarOperations(XtextResource resource, int offset, String partialOpName) {
		var inputOfType = resolvePropertyAccessOrMethodResourceToType(resource, offset);
		if (inputOfType !== null) {
			val choices = OclxContentProposalProvider.getSimilaritySortedMethods(methodReg, partialOpName, inputOfType)
			//could be greatly improved by returning only operation that matches the input it is call on!!!! and also a similarity threshold!
			return choices
		}
		return Collections.emptyList()
	}
	
	def generateCodeActionReplaceWithMostSimilarOperation(Diagnostic d, XtextResource resource, String newMethod, List<CodeAction> result) {	
		result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Replace with most similar operation '"+newMethod+"' "
						diagnostics = #[d]
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = d.range
								newText = newMethod
							])
						]
					]
	}
	
	protected def resolvePropertyAccessOrMethodResourceToType(XtextResource resource, int offset) {
		val modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset)
		if (modelElement !== null) {
			val el2TypeMap = typeExtractor.extractElementToTypeMap(modelElement).get()
			if (modelElement instanceof MethodExp) {
				val prevNav = OclxASTUtils.findPrecedingOperatorFor(modelElement);
				if (prevNav !== null) {
					val completeWithType = el2TypeMap.getReturnTypeMap().get(prevNav);
					return completeWithType;
				}
			}
		}
		return null;
	}
	
	protected def addTextEdit(WorkspaceEdit edit, URI uri, TextEdit... textEdit) {		
		//map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
		//edit.changes.computeIfAbsent(uri.toString, k -> new LinkedList<>()).add(textEdit);
		edit.changes.put(uri.toString, textEdit)
	}
		
}