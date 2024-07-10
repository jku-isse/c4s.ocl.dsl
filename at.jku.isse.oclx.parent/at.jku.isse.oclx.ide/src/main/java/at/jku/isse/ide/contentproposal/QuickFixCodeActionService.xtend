package at.jku.isse.ide.contentproposal

import at.jku.isse.oclx.PropertyAccessExp
import at.jku.isse.validation.OCLXValidator
import com.google.inject.Inject
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Collections
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.CodeActionKind
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.lsp4j.Diagnostic
import java.util.List

class QuickFixCodeActionService implements ICodeActionService2 {
	
	@Inject
	TypeExtractor typeExtractor
	@Inject
	EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	
	override getCodeActions(Options options) {
		
		var document = options.document
		val params = options.codeActionParams
		val result = <CodeAction>newArrayList
		var resource = options.resource as XtextResource
		
		for (d : params.context.diagnostics) {
			if (d.code.get == OCLXValidator.UNKNOWN_PROPERTY) {
				System.out.println(d)
				if (document === null) { // then resource mostlikely also null
					//val content = getFileContent(params.textDocument.uri)
					//System.out.println(content)
					val lsCtx = options.languageServerAccess.doSyncRead(params.textDocument.uri, [lsCtx |  return lsCtx] )
					document = lsCtx.document
					resource = lsCtx.resource as XtextResource
					//document = new Document(1, content)
					
				}
				if (document !== null) {
					//resource = extractResource(options)
					val propertyString = document.getSubstring(d.range)
					val choices = findMostSimilarProperties(propertyString, resource, d.range.start.character)
					if (choices.size() > 0) {
						val newProp = choices.get(0)
						getCodeAction(d, resource, newProp, result)
					}
				}
			}
		}
		return result.map[Either.forRight(it)]
	}
	
	

	def ILanguageServerAccess.Context process(ILanguageServerAccess.Context ctx) {
		return ctx
	}
	
	def getCodeAction(Diagnostic d, XtextResource resource, String newProp, List<CodeAction> result) {	
							result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Replace with most similar property "+newProp
						diagnostics = #[d]
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = d.range
								newText = newProp
							])
						]
					]
	}
	
//	protected def URI extractURI(Options options) {
//		if (options.URI === null) { 
//			val resource2 = parse(URI.createFileURI(options.codeActionParams.textDocument.uri))
//			return resource2.URI
//		} else {
//			return URI.createURI(options.URI)
//		}
//	}
	
	protected def addTextEdit(WorkspaceEdit edit, URI uri, TextEdit... textEdit) {
		edit.changes.put(uri.toString, textEdit)
	}
	
//	protected def getFileContent(String uriAsString) {
//		val uri = new java.net.URI(uriAsString)
//		val path = Paths.get(uri)
//		val text = Files.readString(path);
//		return text			
//	}
//	
//	protected def parse(URI uri)  {
//		val resource = new XtextResourceSet().createResource(uri)
//		resource.contents
//		//var resource //= resourceHelper.resource(text);
//		if (resource instanceof XtextResource) {
//			return resource;
//		} else
//			return null;
//	}
//
//	protected def extractResource(Options options) {
//		val resource = options.resource as XtextResource
//		if (resource === null) {
//			return parse(URI.createFileURI(options.codeActionParams.textDocument.uri))
//		} else
//			return resource
//	}

	protected def findMostSimilarProperties(String partialPropertyName, XtextResource resource, int offset) {
		val modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset)
		if (modelElement !== null) {
			val el2TypeMap = typeExtractor.extractElementToTypeMap(modelElement).get()
			if (modelElement instanceof PropertyAccessExp) {
				val prevNav = ASTUtils.findPrecedingOperatorFor(modelElement);
				if (prevNav !== null) {
					val completeWithType = el2TypeMap.getReturnTypeMap().get(prevNav);
					if (completeWithType !== null) {
						val choices = OclxContentProposalProvider.getSimilaritySortedProperties(completeWithType.getType(), partialPropertyName)
						return choices
					}
				}
			}
		}
		return Collections.emptyList()
	}
	

	
}