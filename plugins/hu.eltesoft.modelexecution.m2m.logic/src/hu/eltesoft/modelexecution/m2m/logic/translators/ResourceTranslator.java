package hu.eltesoft.modelexecution.m2m.logic.translators;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

import com.incquerylabs.uml.papyrus.IncQueryEngineService;

import hu.eltesoft.modelexecution.ide.common.ProjectProperties;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.UpdateSourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.CompositeReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.uml.incquery.Queries;
import hu.eltesoft.modelexecution.validation.ValidationError.Severity;
import hu.eltesoft.modelexecution.validation.Validator;
import hu.eltesoft.modelexecution.validation.Validator.ValidationLevels;

/**
 * This translator converts model resources into a set of translational models
 * and finally to templates. Collects translators for different kind of root
 * elements (UML elements that are translated into separate java files), and
 * handles the resource-specific conversion details concerning incremental
 * changes.
 */
public class ResourceTranslator {

	public static final String PATHMAP_SCHEME = "pathmap";

	public static ResourceTranslator createIncremental(ModelSet modelSet) {
		return new ResourceTranslator(modelSet, true);
	}

	public static ResourceTranslator create(ModelSet modelSet) {
		return new ResourceTranslator(modelSet, false);
	}

	private ModelSet resource;
	private boolean incremental;
	private boolean disposed;
	private AdvancedIncQueryEngine engine;
	private ReversibleTask attachListeners;

	private List<RootElementTranslator<?, ?, ?>> translators;
	private Validator validator;

	private ResourceTranslator(ModelSet modelSet, boolean incremental) {
		this.resource = modelSet;

		this.incremental = incremental;
		setupEngine();
	}

	private void setupEngine() {
		disposed = false;

		try {
			createIncQueryEngine();

			if (incremental) {
				this.validator = Validator.createIncremental(validator, resource, engine);
			} else {
				this.validator = Validator.create(validator, resource, engine);
			}

			Queries.instance().prepare(engine);
			setupTranslators();

			if (incremental) {
				attachListeners();
			}
		} catch (IncQueryException e) {
			throw new RuntimeException(e);
		}
	}

	private void createIncQueryEngine() throws IncQueryException {
		engine = AdvancedIncQueryEngine.from(IncQueryEngineService.getOrCreateEngineEvenIfModelIsClosed(resource));
	}

	private void setupTranslators() throws IncQueryException {
		translators = new LinkedList<>();
		translators.add(new AssociationTranslator(engine));
		translators.add(new AssociationClassTranslator(engine));
		translators.add(new BehaviorTranslator(engine));
		translators.add(new CallableProxyTranslator(engine));
		translators.add(new ClassTranslator(engine));
		translators.add(new ClassSpecTranslator(engine));
		translators.add(new ExternalEntityTranslator(engine));
		translators.add(new RegionTranslator(engine));
		translators.add(new SignalTranslator(engine));
	}

	private void attachListeners() {
		CompositeReversibleTask task = new CompositeReversibleTask();
		for (RootElementTranslator<?, ?, ?> translator : translators) {
			task.add(translator.addListeners());
		}
		attachListeners = task;
	}

	public void toIncremental(ModelSet resource) {
		checkDisposed();

		if (incremental) {
			if (this.resource == resource) {
				// do nothing, we are already upgraded
				return;
			}
			incremental = false;
			attachListeners.revert();
		}

		incremental = true;
		this.resource = resource;
		setupEngine();
	}

	private void checkDisposed() {
		if (disposed) {
			throw new IllegalStateException("Cannot use Translator after dispose."); //$NON-NLS-1$
		}
	}

	public void dispose() {
		if (disposed) {
			return;
		}

		if (incremental) {
			attachListeners.revert();
		}
		validator.dispose();

		disposed = true;
	}

	public List<SourceCodeTask> fullTranslation() {
		checkDisposed();

		validator.clear();
		Optional<ValidationLevels> validationLevel = getValidationLevel();
		if (validationLevel.isPresent() && !ValidationLevels.NONE.equals(validationLevel.get())) {
			validator.validate();
		}

		List<SourceCodeTask> updateTasks = new LinkedList<>();
		if (isValid()) {
			for (RootElementTranslator<?, ?, ?> translator : translators) {
				performBatchTranslation(updateTasks, translator);
			}
		}
		return updateTasks;
	}

	private void performBatchTranslation(List<SourceCodeTask> updateTasks, RootElementTranslator<?, ?, ?> translator) {
		translator.clear();
		translator.getAllTemplates().forEach((rootName, template) -> {
			updateTasks.add(new UpdateSourceCodeTask(rootName, template));
		});
	}

	public List<SourceCodeTask> incrementalTranslation() {
		checkDisposed();

		if (!incremental) {
			return fullTranslation();
		}

		List<SourceCodeTask> changes = new LinkedList<>();
		if (isValid()) {
			for (RootElementTranslator<?, ?, ?> translator : translators) {
				changes.addAll(translator.incrementalTranslation());
			}
		}
		return changes;
	}

	private boolean isValid() {
		Optional<Severity> highestProblemSeverity = validator.highestProblemSeverity();
		if (highestProblemSeverity.isPresent()) {
			Severity severity = highestProblemSeverity.get();
			Optional<ValidationLevels> validationLevel = getValidationLevel();
			ValidationLevels validLevel = validationLevel.orElse(Validator.DEFAULT_VALIDATION_LEVEL);
			switch (severity) {
			case ERROR:
				return validLevel.equals(ValidationLevels.NEVER_STOP);
			case WARNING:
				return validLevel.equals(ValidationLevels.NEVER_STOP)
						|| validLevel.equals(ValidationLevels.STOP_ON_ERRORS);
			default:
				return true;
			}
		} else {
			return true;
		}
	}

	private Optional<ValidationLevels> getValidationLevel() {
		return getProject().map(ProjectProperties::getValidationSetting);
	}

	private Optional<IProject> getProject() {
		IWorkspaceRoot workspace;
		try {
			workspace = ResourcesPlugin.getWorkspace().getRoot();
		} catch (IllegalStateException e) {
			// when the workspace is closed, eg. in standalone mode
			return Optional.empty();
		}

		for (Resource res : resource.getResources()) {
			URI locationUri = URI.create(CommonPlugin.asLocalURI(res.getURI()).toString());
			if (!locationUri.isAbsolute()) {
				// findContainersForLocationURI throws illegal argument
				// exception for relative URIs
				continue;
			}
			IContainer[] found = workspace.findContainersForLocationURI(locationUri);
			if (found.length > 0) {
				return Optional.of(found[0].getProject());
			}
		}
		return Optional.empty();
	}

}
