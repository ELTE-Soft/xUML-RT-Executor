package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2t.java.Template;

import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.xtext.xbase.lib.Pair;

public interface Generator<S extends EObject> {

	Pair<String, Template> getTemplate(S source) throws GenerationException;

	void runOn(Consumer<S> task);

	/**
	 * Saves the EObject identifier of the specified root UML element. This is
	 * needed to be able to reconstruct the identifier after an object is
	 * destroyed and removed from its resource.
	 */
	public void saveRootName(S root);

	/**
	 * Gets the root name of the given EObject instance, even after the
	 * connection with the Resource is lost. The entry is erased after the
	 * method call.
	 */
	public void consumeRootName(S root, Consumer<String> task);

	/**
	 * @return a task to remove the registered match update listeners
	 */
	ReversibleTask addListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry);
}
