package at.jku.isse.ide.assistance

import at.jku.isse.oclx.IteratorVarDeclaration
import at.jku.isse.passiveprocessengine.core.SchemaRegistry
import at.jku.isse.validation.MethodRegistry
import at.jku.isse.validation.OCLXValidator
import at.jku.isse.validation.TypeExtractor
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.diagnostics.Diagnostic
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
				if (d.code.get == Diagnostic.SYNTAX_DIAGNOSTIC) {
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
					result += new SimilarPropertyQuickfixer(schemaReg, typeExtractor, methodReg).createReplaceWithMostSimilarFittingPropertyQuickFix(modelElement, stringToRepair, d, resource);			
				} else if (d.code.get == OCLXValidator.UNKNOWN_OPERATION) {
					result +=  new UnknownOperationQuickfixer(schemaReg, typeExtractor, methodReg).createReplaceWithMostSimilarFittingOperationQuickFix(modelElement, stringToRepair, d, resource);
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

}