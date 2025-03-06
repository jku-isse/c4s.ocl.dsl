package at.jku.isse.ide.assistance;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionContext;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DiagnosticSeverity;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.LookAheadInfo;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2.Options;

import com.google.inject.Provider;

import at.jku.isse.oclx.Model;
import lombok.Getter;
import lombok.NonNull;

public class CodeActionExecuter {

	private final Provider<XtextResourceSet> resourceSetProvider;
	private final IResourceFactory resourceFactory;
	private final InvariantChecker invariantChecker;
	private final ICodeActionService2 repairService;
	private final String constraint;
	@Getter private String repairedOclxConstraint;
	@Getter private String repairedExpression;
	private XtextResource resource;
	@Getter private List<Issue> problems;
	@Getter private CodeAction executedCodeAction;
	
	public CodeActionExecuter(@NonNull String constraintInDSLSyntax
			, Provider<XtextResourceSet> resourceSetProvider
			, IResourceFactory resourceFactory
			, InvariantChecker invariantChecker
			, ICodeActionService2 repairService) {
		this.constraint = constraintInDSLSyntax;
		this.resourceFactory = resourceFactory;
		this.resourceSetProvider = resourceSetProvider;
		this.invariantChecker = invariantChecker;
		this.repairService = repairService;
		parse(constraint);
	}
	
	public CodeActionExecuter prepareForNextRepairIteration() {
		return new CodeActionExecuter( 
			repairedOclxConstraint != null ? repairedOclxConstraint : constraint
					, resourceSetProvider
					, resourceFactory
					, invariantChecker
					, repairService
				);
	}
	
	public void checkForIssues() {
		 IResourceValidator validator = resource.getResourceServiceProvider()
				.getResourceValidator();
		 problems = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
	}
	
	public void executeFirstExecutableRepair() { // only for those issues that have code actions, first repair selected
		executedCodeAction = null; // resetting
		problems.stream()
			.map(this::getRepairs)
			.filter(repairs -> !repairs.isEmpty())
			.map(repairs -> repairs.stream()
					.filter(repair -> repair.getKind().equals("quickfix"))
					.findAny()) 
			.filter(Optional::isPresent)
			.findFirst()
			.ifPresent(repairOpt -> executeRepair(repairOpt.get(), constraint));
	}
	
	private List<CodeAction> getRepairs(Issue issue) {
		var range = new Range(new Position(issue.getLineNumber()-1, issue.getColumn()-1)
				, new Position(issue.getLineNumberEnd()-1, issue.getColumnEnd()-1));
		
		if (issue.getCode().equals("missingType")) return Collections.emptyList(); // can't repair missing parameter/type, we try for some syntax errors		
		
		var d = new Diagnostic();
		var ctx = new CodeActionContext(List.of(d));
		d.setCode(issue.getCode());
		d.setSeverity(DiagnosticSeverity.Error);
		d.setMessage(issue.getMessage());
		d.setRange(range);

		var options = new Options();
		options.setDocument(new Document(1, constraint));
		options.setResource(resource);
		options.setCodeActionParams(new CodeActionParams(new TextDocumentIdentifier(resource.getURI().toString()), range, ctx));
		return repairService.getCodeActions(options).stream().map(either -> either.getRight()).toList();
	}	
	
	/**
	 * executing single-line repairs only for now
	 * */
	private void executeRepair(CodeAction codeAction, String constraint) {
		// we support only a single change with multiple edits for now		

		// assuming edits come in left to right order and are non-overlapping
		var edits = codeAction.getEdit().getChanges().values().iterator().next();		
		if (edits.isEmpty()) return;
						
		StringBuffer sb = new StringBuffer();				
		for (int i = 0; i < edits.size() ; i++ ) {
			var edit = edits.get(i);
			var range = edit.getRange();
			var newText = edit.getNewText();
			// TODO handling line numbers other than 0
			if (i == 0) { // special case for first edit
				sb.append(constraint.substring(0, range.getStart().getCharacter()));
			}
			sb.append(newText);
			// test to next edit pos or end of sting
			int keepUntil = getPosOfNextEditOrEoF(edits, i, constraint);
			sb.append(constraint.substring(range.getEnd().getCharacter(), keepUntil));
		}
		repairedOclxConstraint = sb.toString();
		var newConstraint = parse(repairedOclxConstraint).getConstraints().get(0).getExpression();
		repairedExpression = NodeModelUtils.findActualNodeFor(newConstraint).getText();
		executedCodeAction = codeAction;
	}
	
	private int getPosOfNextEditOrEoF(List<TextEdit> edits, int justProcessedEditPos, String constraint) {
		if (justProcessedEditPos >= edits.size()-1) // finished all edits
			return constraint.length();
		else {
			//TODO: also here eventually support line numbers not just characters
			var nextEdit = edits.get(justProcessedEditPos+1);
			return nextEdit.getRange().getStart().getCharacter();
		}
	}
	
	private Model parse(String dslString) {
		var inStream = new LazyStringInputStream(dslString);
		var resourceSet = resourceSetProvider.get();
		var uriToUse = computeUnusedUri(resourceSet, "oclx");
		Resource resource = loadResource(inStream, uriToUse, null, resourceSet);
		if (resource instanceof XtextResource xtextResource) {
			this.resource = xtextResource;
			IParseResult parseResult = xtextResource.getParseResult();
			if (parseResult != null) {
				ICompositeNode rootNode = parseResult.getRootNode();
				if (rootNode != null) {
					checkNodeModel(rootNode);
				}
			}
		}
		Model root = (Model) (resource.getContents().isEmpty() ? null : resource.getContents().get(0));
		return root;
	}
	
	private Resource loadResource(InputStream in, URI uriToUse, Map<?, ?> options, ResourceSet resourceSet) {
		Resource resource = resourceFactory.createResource(uriToUse);
		resourceSet.getResources().add(resource);
		try {
			resource.load(in, options);
			return resource;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
	
	private URI computeUnusedUri(ResourceSet resourceSet, String fileExtension) {
		String name = "__synthetic";
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			URI syntheticUri = URI.createURI(name + i + "." + fileExtension);
			if (resourceSet.getResource(syntheticUri, false) == null)
				return syntheticUri;
		}
		throw new IllegalStateException();
	}
	
	private void checkNodeModel(ICompositeNode rootNode) {
		invariantChecker.checkInvariant(rootNode);
		new LookAheadInfo(rootNode).checkConsistency();
	}
}
