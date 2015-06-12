package hu.eltesoft.modelexecution.m2m.logic.registry;

import hu.eltesoft.modelexecution.m2m.logic.DeleteSourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.uml.NamedElement;

/**
 * A change registry to record changes in the model and perform them later.
 */
public class ChangeRegistry {

	private final Map<String, TranslationTask<?>> updateTasks = new HashMap<>();
	private final Set<String> toDelete = new HashSet<>();

	/**
	 * Registers an object update request. If another request is already present
	 * with the same <code>rootName</code>, that entry is overwritten.
	 */
	public synchronized <UML extends NamedElement> void registerUpdate(
			UML source, RootElementTranslator<UML, ?, ?> builder) {
		if (null == source.eResource()) {
			return;
		}
		String rootName = NamedReference.getIdentifier(source);
		updateTasks.put(rootName, new TranslationTask<>(source, builder));
	}

	/**
	 * Registers an object removal request. If another request is already
	 * present with the same <code>rootName</code>, that entry is overwritten.
	 * It also removes exsiting update entries for the given root name.
	 */
	public synchronized void registerDelete(String rootName) {
		updateTasks.remove(rootName);
		toDelete.add(rootName);
	}

	/**
	 * Performs model-to-model transformation according to the previously
	 * registered changes and clears this registry.
	 */
	public synchronized List<SourceCodeTask> performTranslation() {
		List<SourceCodeTask> tasks = new ArrayList<>();
		updateTasks.forEach((rootName, task) -> tasks.add(task.perform()));
		// deletes should be executed after updates, because we did not record
		// the order they arrived (modified elements can be deleted, but deleted
		// elements cannot be created again, as the root name is unique)
		toDelete.forEach(rootName -> tasks.add(new DeleteSourceCodeTask(
				rootName)));
		clear();
		return tasks;
	}

	public synchronized void clear() {
		toDelete.clear();
		updateTasks.clear();
	}
}
