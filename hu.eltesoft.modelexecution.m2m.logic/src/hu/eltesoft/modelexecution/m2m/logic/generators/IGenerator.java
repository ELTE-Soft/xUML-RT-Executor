package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;

public interface IGenerator<S extends EObject, R extends ModelRoot> {

	R generateTranslationModel(S source);

	void generateText(R root);

	R generateModelRoot(S source);

	void deleteText(R root);

}
