package hu.eltesoft.modelexecution.validation;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

import hu.eltesoft.modelexecution.validation.ValidationError.Severity;

public class Validator {

	public final static ValidationLevels DEFAULT_VALIDATION_LEVEL = ValidationLevels.NONE;

	public enum ValidationLevels {
		NEVER_STOP, STOP_ON_ERRORS, STOP_ON_WARNINGS, NONE
	}

	private static Set<BaseGeneratedPatternGroup> queries = new HashSet<>();
	private static boolean queriesInitialized;

	private ModelSet modelSet;
	private IncQueryEngine engine;
	private boolean incremental;
	private Set<ValidationRule> rules = new HashSet<>();

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
	}

	private void prepare() throws IncQueryException {
		if (!queriesInitialized) {
			queriesInitialized = true;
			try {
				queries.add(General.instance());
				queries.add(Structure.instance());
				queries.add(ClassValidation.instance());
				queries.add(ExternalEntity.instance());
				queries.add(StateMachine.instance());
				queries.add(ParameterChecks.instance());
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}

		if (rules.isEmpty()) {
			for (BaseGeneratedPatternGroup group : queries) {
				for (IQuerySpecification<?> spec : group.getSpecifications()) {
					ValidationRule rule = ValidationRule.create(spec, modelSet, engine, incremental);
					if (rule != null) {
						rules.add(rule);
					}
				}
			}

			for (BaseGeneratedPatternGroup group : queries) {
				group.prepare(engine);
			}
		}
	}

	public void dispose() {
		for (ValidationRule rule : rules) {
			rule.dispose();
		}
	}

	public void validate() {
		try {
			prepare();
		} catch (IncQueryException e) {
			e.printStackTrace();
			return;
		}

		for (ValidationRule rule : rules) {
			rule.validate();
		}
	}

	public void clear() {
		for (ValidationRule validationRule : rules) {
			validationRule.clear();
		}
		forEachResource(modelSet, r -> r.deleteMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE));
	}

	public static void forEachResource(ModelSet modelSet, ThrowingConsumer<IResource> action) {
		IWorkspaceRoot workspace;
		try {
			workspace = ResourcesPlugin.getWorkspace().getRoot();
		} catch (IllegalStateException e) {
			// when the workspace is closed, eg. in standalone mode
			return;
		}

		for (Resource resource : modelSet.getResources()) {
			String platformString = resource.getURI().toPlatformString(true);
			if (platformString != null) {
				IResource res = workspace.findMember(platformString);
				if (res != null) {
					action.accept(res);
				}
			}
		}
	}

	public static IMarker refreshMarkers(IResource resource, ModelSet modelSet) throws CoreException {
		IMarker[] existingMarkers = resource.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
		for (IMarker existing : existingMarkers) {
			if (!existing.exists()) {
				continue;
			}
			if (null == modelSet.getEObject(URI.createURI(existing.getAttribute(EValidator.URI_ATTRIBUTE, "")), true)) {
				existing.delete();
			}
		}
		return null;
	}

	public Optional<Severity> highestProblemSeverity() {
		Set<Severity> severities = new TreeSet<Severity>(Comparator.reverseOrder());
		for (ValidationRule validationRule : rules) {
			validationRule.highestProblemSeverity().ifPresent(s -> severities.add(s));
		}
		if (severities.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(severities.iterator().next());
		}
	}

	@FunctionalInterface
	public interface ThrowingConsumer<T> extends Consumer<T> {

		@Override
		default void accept(final T elem) {
			try {
				acceptThrows(elem);
			} catch (final Exception e) {
				/* Do whatever here ... */
				System.out.println("handling an exception...");
				throw new RuntimeException(e);
			}
		}

		void acceptThrows(T elem) throws Exception;

	}

}
