package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2t.java.Template;

import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.xtext.xbase.lib.Pair;

public interface Generator<S extends EObject> {

	Pair<String, Template> getTemplate(S source) throws GenerationException;

	void runOn(Consumer<S> task);

	/**
	 * @return a task to remove the registered match update listeners
	 */
	ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry);
}
