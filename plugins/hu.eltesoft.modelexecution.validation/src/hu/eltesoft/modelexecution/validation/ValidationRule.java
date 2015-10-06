package hu.eltesoft.modelexecution.validation;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
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

import hu.eltesoft.modelexecution.validation.ValidationError.Severity;
import hu.eltesoft.modelexecution.validation.utils.BaseValidator;

public class ValidationRule {

	private static final String SEVERITY_ATTRIBUTE = "severity";
	private static final String MESSAGE_ATTRIBUTE = "message";
	private static final String MARKED_ELEMENTS_ATTRIBUTE = "mark";
	private static final String POST_CHECK_ATTRIBUTE = "post";

	public static final Pattern KEY_PATTERN = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_]*)\\}");
	public static final String PATTERN_NAME = "PatternName";

	private static final String VIOLATION_ANNOTATION = "Violation";

	private IncQueryEngine engine;

	private IMatchUpdateListener<IPatternMatch> updateListener;
	private int numErrors;

	private boolean incremental;
	private IQuerySpecification<?> spec;
	private Collection<String> markedElements;
	private String message;
	private Severity severity;
	private IncQueryMatcher<? extends IPatternMatch> matcher;
	private BaseValidator postCheck;
	private static ModelSet modelSet;

	public static ValidationRule create(IQuerySpecification<?> spec, ModelSet modelSet, IncQueryEngine engine,
			boolean incremental) throws IncQueryException {
		ValidationRule.modelSet = modelSet;
		ValidationRule rule = new ValidationRule(spec, engine, incremental);
		if (!rule.initialize(spec)) {
			return null;
		}
		if (incremental) {
			rule.setupListener();
		}
		return rule;
	}

	private ValidationRule(IQuerySpecification<?> spec, IncQueryEngine engine, boolean incremental)
			throws IncQueryException {
		this.spec = spec;
		this.engine = engine;
		this.matcher = spec.getMatcher(engine);
		this.incremental = incremental;
	}

	@SuppressWarnings("unchecked")
	private boolean initialize(IQuerySpecification<?> query) {
		PAnnotation annot = query.getFirstAnnotationByName(VIOLATION_ANNOTATION);
		if (annot == null) {
			return false;
		}
		severity = getSeverity((String) annot.getFirstValue(SEVERITY_ATTRIBUTE));
		message = (String) annot.getFirstValue(MESSAGE_ATTRIBUTE);
		Matcher messageMatcher = KEY_PATTERN.matcher(message);
		while (messageMatcher.find()) {
			String referencedParam = messageMatcher.group(1);
			if (!query.getParameterNames().contains(referencedParam)) {
				System.err.println("Element '" + referencedParam
						+ "' referenced in the error message is not among the parameters of query '"
						+ query.getFullyQualifiedName() + "'");
				return false;
			}
		}
		markedElements = (Collection<String>) annot.getFirstValue(MARKED_ELEMENTS_ATTRIBUTE);
		for (String mark : markedElements) {
			if (!query.getParameterNames().contains(mark)) {
				System.err.println("Marked element '" + mark + "' is not among the parameters of query '"
						+ query.getFullyQualifiedName() + "'");
				return false;
			}
		}
		postCheck = getPostCheck((String) annot.getFirstValue(POST_CHECK_ATTRIBUTE));
		return true;
	}

	private BaseValidator getPostCheck(String postCheckerName) {
		if (postCheckerName != null) {
			try {
				Class<?> loadClass = getClass().getClassLoader().loadClass(postCheckerName);
				if (BaseValidator.class.isAssignableFrom(loadClass)) {
					Constructor<?> ctor = loadClass.getConstructor(Collection.class);
					return (BaseValidator) ctor.newInstance(markedElements);
				} else {
					System.err
							.println("The specified post-processor class is not an instance of PostChecker interface");
				}
			} catch (Exception e) {
				System.err.println("The post-processor '" + postCheckerName + "' cannot be initialized");
				e.printStackTrace();
			}
		}
		return new BaseValidator(markedElements);
	}

	public void dispose() {
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
		matcher.forEachMatch(m -> {
			++numErrors;
			registerConstraintError(matcher, m);
		});
	}

	private void registerConstraintError(IncQueryMatcher<? extends IPatternMatch> matcher, IPatternMatch match) {
		if (!postCheck.check(match)) {
			return;
		}
		List<EObject> elements = getMarked(match);
		ValidationError error = new ValidationError(match, severity, message, elements);
		error.show();
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

	public boolean isValid() {
		return numErrors == 0;
	}

	public class ViolationPatternListener<Match extends IPatternMatch> implements IMatchUpdateListener<IPatternMatch> {

		private IncQueryMatcher<Match> matcher;

		public ViolationPatternListener(IncQueryMatcher<Match> matcher) {
			this.matcher = matcher;
		}

		@Override
		public void notifyAppearance(IPatternMatch match) {
			++numErrors;
			registerConstraintError(matcher, match);
		}

		@Override
		public void notifyDisappearance(IPatternMatch match) {
			--numErrors;
			for (String mark : markedElements) {
				removeValidationError(matcher, (EObject) match.get(mark));
			}
		}

		private void removeValidationError(IncQueryMatcher<? extends IPatternMatch> matcher, EObject element) {
			Validator.forEachResource(modelSet, res -> {
				String patternName = matcher.getSpecification().getFullyQualifiedName();
				String uriString = EcoreUtil.getURI(element).toString();
				IMarker marker = ValidationError.getMarker(res, uriString, patternName);
				if (marker != null) {
					marker.delete();
				}
			});
		}

	}

	public void clear() {
		numErrors = 0;
	}

}
