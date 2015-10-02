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
import org.eclipse.uml2.uml.Element;
import org.eclipse.xtext.xbase.lib.Pair;

public class Validator {

	private IncQueryEngine engine;

	private Map<IncQueryMatcher<? extends IPatternMatch>, IMatchUpdateListener<IPatternMatch>> updateListeners = new HashMap<>();
	private Map<Pair<IncQueryMatcher<? extends IPatternMatch>, URI>, ValidationError> validationErrors = new HashMap<>();
	private Map<Pair<IncQueryMatcher<? extends IPatternMatch>, List<Element>>, Integer> numberOfMatches = new HashMap<>();

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
				PAnnotation constraintAnnot = query.getFirstAnnotationByName("Violation");
				IMatchUpdateListener<IPatternMatch> listener = null;
				IncQueryMatcher<? extends IPatternMatch> matcher = query.getMatcher(engine);
				if (constraintAnnot != null) {
					listener = new ViolationPatternListener(matcher, constraintAnnot);

				}
				constraintAnnot = query.getFirstAnnotationByName("ExactlyOne");
				if (constraintAnnot != null) {
					listener = new ExactlyOnePatternListener(matcher, constraintAnnot);
				}
				if (listener != null) {
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
				PAnnotation constraintAnnot = query.getFirstAnnotationByName("Violation");
				if (constraintAnnot != null) {
					checkQuery(query, constraintAnnot);
					checkViolationConstraint(query, constraintAnnot);
				}
				constraintAnnot = query.getFirstAnnotationByName("ExactlyOne");
				if (constraintAnnot != null) {
					checkQuery(query, constraintAnnot);
					checkUniquenessConstraint(query, constraintAnnot);
				}
			}
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	private void checkQuery(IQuerySpecification<?> query, PAnnotation constraintAnnot) {
		String key = (String) constraintAnnot.getFirstValue("key");
		if (!query.getParameterNames().contains(key)) {
			throw new RuntimeException(
					"Key is not part of the parameters in query '" + query.getFullyQualifiedName() + "'");
		}
	}

	private void checkViolationConstraint(IQuerySpecification<?> query, PAnnotation constraintAnnot)
			throws IncQueryException {
		IncQueryMatcher<? extends IPatternMatch> matcher = query.getMatcher(engine);
		matcher.forEachMatch(m -> registerConstraintError(matcher, m, constraintAnnot));
	}

	private void checkUniquenessConstraint(IQuerySpecification<?> query, PAnnotation constraintAnnot)
			throws IncQueryException {
		IncQueryMatcher<? extends IPatternMatch> matcher = query.getMatcher(engine);
		String key = (String) constraintAnnot.getFirstValue("key");
		Map<Object, IPatternMatch> results = new HashMap<>();
		matcher.forEachMatch(m -> {
			if (results.containsKey(m.get(key))) {
				registerConstraintError(matcher, m, constraintAnnot);
			} else {
				results.put(m.get(key), m);
			}
		});
	}

	private void registerConstraintError(IncQueryMatcher<? extends IPatternMatch> matcher, IPatternMatch match,
			PAnnotation constraintAnnot) {
		String message = (String) constraintAnnot.getFirstValue("message");
		String key = (String) constraintAnnot.getFirstValue("key");
		Element element = (Element) match.get(key);
		ValidationError error = new ValidationError(match.patternName(), message, element);
		validationErrors.put(new Pair<>(matcher, EcoreUtil.getURI(element)), error);
		error.show();
	}

	private void removeValidationError(IncQueryMatcher<? extends IPatternMatch> matcher, Element element) {
		ValidationError removed = validationErrors.remove(new Pair<>(matcher, EcoreUtil.getURI(element)));
		if (removed != null) {
			removed.remove();
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
		private String key;

		public ViolationPatternListener(IncQueryMatcher<Match> matcher, PAnnotation constraintAnnot) {
			this.matcher = matcher;
			this.constraintAnnot = constraintAnnot;
			key = (String) constraintAnnot.getFirstValue("key");
		}

		@Override
		public void notifyAppearance(IPatternMatch match) {
			registerConstraintError(matcher, match, constraintAnnot);
		}

		@Override
		public void notifyDisappearance(IPatternMatch match) {
			Element element = (Element) match.get(key);
			removeValidationError(matcher, element);
		}

	}

	public class ExactlyOnePatternListener<Match extends IPatternMatch> implements IMatchUpdateListener<IPatternMatch> {

		private String key;
		private Collection<String> otherKeys;
		private IncQueryMatcher<Match> matcher;
		private PAnnotation constraintAnnot;

		@SuppressWarnings("unchecked")
		public ExactlyOnePatternListener(IncQueryMatcher<Match> matcher, PAnnotation constraintAnnot) {
			this.matcher = matcher;
			this.constraintAnnot = constraintAnnot;
			key = (String) constraintAnnot.getFirstValue("key");
			otherKeys = (Collection<String>) constraintAnnot.getFirstValue("otherKeys");
			if (otherKeys == null) {
				otherKeys = new LinkedList<>();
			}
		}

		@Override
		public void notifyAppearance(IPatternMatch match) {
			Element element = (Element) match.get(key);
			List<Element> keys = getKeyList(match, element);
			Integer val = numberOfMatches.merge(new Pair<>(matcher, keys), 1, (v, a) -> v + 1);
			checkMachNum(match, element, val);
		}

		@Override
		public void notifyDisappearance(IPatternMatch match) {
			Element element = (Element) match.get(key);
			List<Element> keys = getKeyList(match, element);
			// the mapped elements should never be null
			Integer val = numberOfMatches.merge(new Pair<>(matcher, keys), 0, (v, a) -> v - 1);
			checkMachNum(match, element, val);
		}

		private List<Element> getKeyList(IPatternMatch match, Element element) {
			List<Element> keys = new LinkedList<Element>();
			keys.add(element);
			for (String otherKey : otherKeys) {
				keys.add((Element) match.get(otherKey));
			}
			return keys;
		}

		private void checkMachNum(IPatternMatch match, Element element, Integer val) {
			if (val == 1) {
				removeValidationError(matcher, element);
			} else {
				registerConstraintError(matcher, match, constraintAnnot);
			}
		}
	}

}
