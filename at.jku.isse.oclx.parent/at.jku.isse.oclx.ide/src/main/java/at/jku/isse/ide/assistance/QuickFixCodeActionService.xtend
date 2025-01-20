package at.jku.isse.ide.assistance

import com.google.inject.Inject
import java.util.Collections
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.CodeActionKind
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import at.jku.isse.validation.OCLXValidator
import at.jku.isse.oclx.PropertyAccessExp

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
				//System.out.println(d)
				if (document === null) { // then resource most likely also null
					//val content = getFileContent(params.textDocument.uri)
					//System.out.println(content)
					//document = new Document(1, content)
					val lsCtx = options.languageServerAccess.doSyncRead(params.textDocument.uri, [lsCtx |  return lsCtx] )
					document = lsCtx.document
					resource = lsCtx.resource as XtextResource		
				}
				if (document !== null) {
					//resource = extractResource(options)
					val propertyString = document.getSubstring(d.range)
					val offset = document.getOffSet(d.range.start)
					getCodeActionReplaceWithSubtype(d, resource, offset, propertyString, result)
					val choices = findMostSimilarProperties(propertyString, resource, offset)
					if (choices.size() > 0) {
						val newProp = choices.get(0)
						getCodeActionReplaceWithMostSimilarProperty(d, resource, newProp, result)
					}
				}
			}
		}
		return result.map[Either.forRight(it)]
	}

	def ILanguageServerAccess.Context process(ILanguageServerAccess.Context ctx) {
		return ctx
	}

	def getCodeActionReplaceWithSubtype(Diagnostic d, XtextResource resource, int offset, String partialPropertyName, List<CodeAction> result) {
		val subclasses = findSubclassWithProperty(partialPropertyName, resource, offset)
		if (subclasses.isEmpty()) return
		val subclass = subclasses.get(0)

		val precIterator = findPreceedingIterator(resource, offset)
		if (precIterator == null) {
		// for simple navigation we need to add the asType() operator
		result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Access property in subtype '"+subclass.name+"' "
						diagnostics = #[d]
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = d.range
								newText = "asType(<"+subclass.name+">)."+partialPropertyName
							])
						]
					]
		} else {
		// of use in collections we need to do a select with typeOf operator
		}
	}

	protected def findSubclassWithProperty(String propertyName, XtextResource resource, int offset) {
		var completeWithType = resolveResourceToType(resource, offset)
		if (completeWithType !== null) {
			return completeWithType.type.allSubtypesRecursively.stream().filter(subtype | subtype.hasPropertyType(propertyName)).toList()
		}
		return Collections.emptyList()
	}


	protected def findPreceedingIterator(XtextResource resource, int offset) {
		val modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset)
		// is preceeding propertyAccess --> no
		// operation: only some may qualify to have another property access thereafter
		// some iterator operation
		return null
	}

	def getCodeActionReplaceWithMostSimilarProperty(Diagnostic d, XtextResource resource, String newProp, List<CodeAction> result) {	
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
	
	protected def findMostSimilarProperties(String partialPropertyName, XtextResource resource, int offset) {
		var completeWithType = resolveResourceToType(resource, offset);
		if (completeWithType !== null) {
			val choices = OclxContentProposalProvider.getSimilaritySortedProperties(completeWithType.getType(), partialPropertyName)
			return choices
		}
		return Collections.emptyList()
	}
	
	protected def resolveResourceToType(XtextResource resource, int offset) {
		val modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset)
		if (modelElement !== null) {
			val el2TypeMap = typeExtractor.extractElementToTypeMap(modelElement).get()
			if (modelElement instanceof PropertyAccessExp) {
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
		edit.changes.put(uri.toString, textEdit)
	}
	
//	protected def URI extractURI(Options options) {
//		if (options.URI === null) { 
//			val resource2 = parse(URI.createFileURI(options.codeActionParams.textDocument.uri))
//			return resource2.URI
//		} else {
//			return URI.createURI(options.URI)
//		}
//	}
	

	
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


	

	
}