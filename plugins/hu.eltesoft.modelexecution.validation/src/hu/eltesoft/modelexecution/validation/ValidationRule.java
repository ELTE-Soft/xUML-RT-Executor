package hu.eltesoft.modelexecution.validation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import hu.eltesoft.modelexecution.validation.ValidationError.Severity;

public class ValidationRule {

	private static final String SEVERITY_ATTRIBUTE = "severity";
	private static final String MESSAGE_ATTRIBUTE = "message";
	private static final String MARKED_ELEMENTS_ATTRIBUTE = "mark";

	private static final String VIOLATION_ANNOTATION = "Violation";

	private IncQueryEngine engine;

	private IMatchUpdateListener<IPatternMatch> updateListener;
	private Multimap<URI, ValidationError> validationErrors = HashMultimap.create();

	private ModelSet modelSet;
	private boolean incremental;
	private IQuerySpecification<?> spec;
	private Collection<String> markedElements;
	private String message;
	private Severity severity;
	private IncQueryMatcher<? extends IPatternMatch> matcher;

	public static ValidationRule create(IQuerySpecification<?> spec, ModelSet modelSet, IncQueryEngine engine,
			boolean incremental) throws IncQueryException {
		ValidationRule rule = new ValidationRule(spec, modelSet, engine, incremental);
		if (!rule.initialize(spec)) {
			return null;
		}
		return rule;
	}

	private ValidationRule(IQuerySpecification<?> spec, ModelSet modelSet, IncQueryEngine engine, boolean incremental) throws IncQueryException {
		this.spec = spec;
		this.modelSet = modelSet;
		this.engine = engine;
		this.matcher = spec.getMatcher(engine);
		this.incremental = incremental;
		if (incremental) {
			setupListener();
		}
	}

	@SuppressWarnings("unchecked")
	private boolean initialize(IQuerySpecification<?> query) {
		PAnnotation annot = query.getFirstAnnotationByName(VIOLATION_ANNOTATION);
		if (annot == null) {
			return false;
		}
		severity = getSeverity((String) annot.getFirstValue(SEVERITY_ATTRIBUTE));
		message = (String) annot.getFirstValue(MESSAGE_ATTRIBUTE);
		markedElements = (Collection<String>) annot.getFirstValue(MARKED_ELEMENTS_ATTRIBUTE);
		for (String mark : markedElements) {
			if (!query.getParameterNames().contains(mark)) {
				System.err.println("Marked element is not part of the parameters in query '"
						+ query.getFullyQualifiedName() + "'");
				return false;
			}
		}
		return true;
	}

	public void dispose() {
		clear();
		AdvancedIncQueryEngine advEngine = AdvancedIncQueryEngine.from(engine);
		advEngine.removeMatchUpdateListener(matcher, updateListener);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setupListener() {
		AdvancedIncQueryEngine advEngine = AdvancedIncQueryEngine.from(engine);
		try {
			IncQueryMatcher<? extends IPatternMatch> matcher = spec.getMatcher(engine);
			updateListener = new ViolationPatternListener(matcher);
			advEngine.addMatchUpdateListener(matcher, updateListener, true);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}

	}

	public void validate() {
		if (incremental) {
			return;
		}
		try {
			checkViolationConstraint();
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	private void checkViolationConstraint() throws IncQueryException {
		IncQueryMatcher<? extends IPatternMatch> matcher = spec.getMatcher(engine);
		matcher.forEachMatch(m -> registerConstraintError(matcher, m));
	}

	private void registerConstraintError(IncQueryMatcher<? extends IPatternMatch> matcher, IPatternMatch match) {
		List<EObject> elements = getMarked(match);
		ValidationError error = new ValidationError(match, severity, message, elements);

		LinkedList<EObject> toMark = new LinkedList<EObject>();
		for (EObject element : elements) {
			if (validationErrors.get(EcoreUtil.getURI(element)).isEmpty()) {
				toMark.add(element);
				validationErrors.put(EcoreUtil.getURI(element), error);
			}
		}
		error.show(toMark);
	}

	private List<EObject> getMarked(IPatternMatch match) {
		List<EObject> elements = new LinkedList<EObject>();
		for (String mark : markedElements) {
			elements.add((EObject) match.get(mark));
		}
		return elements;
	}

	private Severity getSeverity(String severityStr) {
		if (severityStr == null) {
			return Severity.ERROR;
		}
		switch (severityStr.toLowerCase()) {
		case "info":
			return Severity.INFO;
		case "warning":
			return Severity.WARNING;
		default:
			return Severity.ERROR;
		}
	}

	public void clear() {
		if (incremental) {
			return;
		}
		doClear();
	}

	private void doClear() {
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		validationErrors.clear();
		for (Resource resource : modelSet.getResources()) {
			String platformString = resource.getURI().toPlatformString(true);
			if (platformString != null) {
				IResource res = workspace.findMember(platformString);
				try {
					res.deleteMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean isValid() {
		return validationErrors.isEmpty();
	}

	public class ViolationPatternListener<Match extends IPatternMatch> implements IMatchUpdateListener<IPatternMatch> {

		private IncQueryMatcher<Match> matcher;

		public ViolationPatternListener(IncQueryMatcher<Match> matcher) {
			this.matcher = matcher;
		}

		@Override
		public void notifyAppearance(IPatternMatch match) {
			registerConstraintError(matcher, match);
		}

		@Override
		public void notifyDisappearance(IPatternMatch match) {
			for (String mark : markedElements) {
				removeValidationError(matcher, (EObject) match.get(mark));
			}
		}

		private void removeValidationError(IncQueryMatcher<? extends IPatternMatch> matcher, EObject element) {
			ValidationError removed = validationErrors.get(EcoreUtil.getURI(element)).iterator().next();
			validationErrors.remove(EcoreUtil.getURI(element), removed);
			if (validationErrors.get(EcoreUtil.getURI(element)).isEmpty() && removed != null) {
				removed.remove();
			}
		}

	}

}
