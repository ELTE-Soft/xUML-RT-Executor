package hu.eltesoft.modelexecution.validation;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import hu.eltesoft.modelexecution.validation.ValidationError.Severity;

public class Validator {

	private static final String SEVERITY_ATTRIBUTE = "severity";
	private static final String MESSAGE_ATTRIBUTE = "message";
	private static final String MARKED_ELEMENTS_ATTRIBUTE = "mark";

	private static final String VIOLATION_ANNOTATION = "Violation";

	private IncQueryEngine engine;

	private Map<IncQueryMatcher<? extends IPatternMatch>, IMatchUpdateListener<IPatternMatch>> updateListeners = new HashMap<>();
	private Multimap<Pair<IncQueryMatcher<? extends IPatternMatch>, URI>, ValidationError> validationErrors = HashMultimap
			.create();

	private ModelSet modelSet;
	private boolean incremental;

	private static Set<BaseGeneratedPatternGroup> queries = new HashSet<>();

	static {
		try {
			queries.add(General.instance());
			queries.add(Structure.instance());
			queries.add(ClassValidation.instance());
			queries.add(StateMachine.instance());
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	private void prepare() throws IncQueryException {
		for (BaseGeneratedPatternGroup group : queries) {
			group.prepare(engine);
		}
	}

	private static Set<IQuerySpecification<?>> getSpecifications() {
		Set<IQuerySpecification<?>> ret = new HashSet<>();
		for (BaseGeneratedPatternGroup group : queries) {
			ret.addAll(group.getSpecifications());
		}
		return ret;
	}

	public static Validator create(Validator previous, ModelSet modelSet, IncQueryEngine engine) {
		if (previous != null) {
			if (!previous.incremental) {
				return previous;
			}
			previous.dispose();
		}
		return new Validator(modelSet, engine, false);
	}

	public static Validator createIncremental(Validator previous, ModelSet modelSet, IncQueryEngine engine) {
		if (previous != null) {
			if (previous.incremental) {
				return previous;
			}
			previous.dispose();
		}
		return new Validator(modelSet, engine, true);
	}

	private Validator(ModelSet modelSet, IncQueryEngine engine, boolean incremental) {
		this.modelSet = modelSet;
		this.engine = engine;
		this.incremental = incremental;
		try {
			prepare();
			if (incremental) {
				// This is a hotfix, because translator registry does not work
				// as expected. Translators can become struck, because model
				// sets are not equals.
				doClear();

				setupListeners();
			}
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	public void dispose() {
		clear();
		AdvancedIncQueryEngine advEngine = AdvancedIncQueryEngine.from(engine);
		for (Entry<IncQueryMatcher<? extends IPatternMatch>, IMatchUpdateListener<IPatternMatch>> entry : updateListeners
				.entrySet()) {
			advEngine.removeMatchUpdateListener(entry.getKey(), entry.getValue());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setupListeners() {
		AdvancedIncQueryEngine advEngine = AdvancedIncQueryEngine.from(engine);
		try {
			for (IQuerySpecification<?> query : getSpecifications()) {
				PAnnotation constraintAnnot = query.getFirstAnnotationByName(VIOLATION_ANNOTATION);
				IMatchUpdateListener<IPatternMatch> listener = null;
				IncQueryMatcher<? extends IPatternMatch> matcher = query.getMatcher(engine);
				if (constraintAnnot != null) {
					listener = new ViolationPatternListener(matcher, constraintAnnot);
					advEngine.addMatchUpdateListener(matcher, listener, true);
					updateListeners.put(matcher, listener);
				}
			}
		} catch (IncQueryException e) {
			e.printStackTrace();
		}

	}

	public void validate() {
		if (incremental) {
			return;
		}
		try {
			for (IQuerySpecification<?> query : getSpecifications()) {
				PAnnotation constraintAnnot = query.getFirstAnnotationByName(VIOLATION_ANNOTATION);
				if (constraintAnnot != null) {
					checkQuery(query, constraintAnnot);
					checkViolationConstraint(query, constraintAnnot);
				}
			}
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	private void checkQuery(IQuerySpecification<?> query, PAnnotation constraintAnnot) {
		@SuppressWarnings("unchecked")
		Collection<String> marked = (Collection<String>) constraintAnnot.getFirstValue(MARKED_ELEMENTS_ATTRIBUTE);
		for (String mark : marked) {
			if (!query.getParameterNames().contains(mark)) {
				throw new RuntimeException(
						"Key is not part of the parameters in query '" + query.getFullyQualifiedName() + "'");
			}
		}
	}

	private void checkViolationConstraint(IQuerySpecification<?> query, PAnnotation constraintAnnot)
			throws IncQueryException {
		IncQueryMatcher<? extends IPatternMatch> matcher = query.getMatcher(engine);
		matcher.forEachMatch(m -> registerConstraintError(matcher, m, constraintAnnot));
	}

	private void registerConstraintError(IncQueryMatcher<? extends IPatternMatch> matcher, IPatternMatch match,
			PAnnotation constraintAnnot) {
		String message = (String) constraintAnnot.getFirstValue(MESSAGE_ATTRIBUTE);
		@SuppressWarnings("unchecked")
		Collection<String> marked = (Collection<String>) constraintAnnot.getFirstValue(MARKED_ELEMENTS_ATTRIBUTE);
		String severity = (String) constraintAnnot.getFirstValue(SEVERITY_ATTRIBUTE);
		List<EObject> elements = getMarked(match, marked);
		ValidationError error = new ValidationError(match, getSeverity(severity), message, elements);

		LinkedList<EObject> toMark = new LinkedList<EObject>();
		for (EObject element : elements) {
			Pair<IncQueryMatcher<? extends IPatternMatch>, URI> key = new Pair<>(matcher, EcoreUtil.getURI(element));
			if (validationErrors.get(key).isEmpty()) {
				toMark.add(element);
				validationErrors.put(key, error);
			}
		}
		error.show(toMark);
	}

	private List<EObject> getMarked(IPatternMatch match, Collection<String> marked) {
		List<EObject> elements = new LinkedList<EObject>();
		for (String mark : marked) {
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

		private PAnnotation constraintAnnot;
		private IncQueryMatcher<Match> matcher;
		private Collection<String> marked;

		@SuppressWarnings("unchecked")
		public ViolationPatternListener(IncQueryMatcher<Match> matcher, PAnnotation constraintAnnot) {
			this.matcher = matcher;
			this.constraintAnnot = constraintAnnot;
			marked = (Collection<String>) constraintAnnot.getFirstValue(MARKED_ELEMENTS_ATTRIBUTE);
		}

		@Override
		public void notifyAppearance(IPatternMatch match) {
			registerConstraintError(matcher, match, constraintAnnot);
		}

		@Override
		public void notifyDisappearance(IPatternMatch match) {
			for (String mark : marked) {
				removeValidationError(matcher, (EObject) match.get(mark));
			}
		}

		private void removeValidationError(IncQueryMatcher<? extends IPatternMatch> matcher, EObject element) {
			Pair<IncQueryMatcher<? extends IPatternMatch>, URI> pair = new Pair<>(matcher, EcoreUtil.getURI(element));
			ValidationError removed = validationErrors.get(pair).iterator().next();
			validationErrors.remove(pair, removed);
			if (validationErrors.get(pair).isEmpty() && removed != null) {
				removed.remove();
			}
		}

	}

}
