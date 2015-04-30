package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;

public interface Generator<S extends EObject, R extends ModelRoot> {

	R generateTranslationModel(S source) throws GenerationException;

	void generateText(R root);

	void addMatchUpdateListeners(AdvancedIncQueryEngine advancedEngine,
			ChangeRegistry changeRegistry);

}
