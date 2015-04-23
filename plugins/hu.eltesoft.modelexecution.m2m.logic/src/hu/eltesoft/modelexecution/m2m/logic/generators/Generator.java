package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;

public interface Generator<S extends EObject, R extends ModelRoot> {

	R generateTranslationModel(S source) throws GenerationException;

	void generateText(R root);

	/**
	 * @return a task to remove the registered match update listeners
	 */
	ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry);

}
