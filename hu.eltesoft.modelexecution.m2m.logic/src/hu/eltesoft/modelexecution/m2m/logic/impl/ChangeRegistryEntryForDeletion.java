package hu.eltesoft.modelexecution.m2m.logic.impl;

import hu.eltesoft.modelexecution.m2m.logic.generators.IGenerator;
import hu.eltesoft.modelexecution.m2m.logic.interfaces.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;

public class ChangeRegistryEntryForDeletion<S extends EObject, R extends ModelRoot> implements
		ChangeRegistry.ParametricEntry<S, R>, FileUpdateTask {

	private final IGenerator<S, R> generator;
	private S sourceObject;
	private R modelRoot;
	
	public ChangeRegistryEntryForDeletion(IGenerator<S, R> generator, S sourceObject) {
		this.generator = generator;
		this.sourceObject = sourceObject;
		this.modelRoot = null; // set after the generation of the translation model
	}
	
	@Override
	public Type getType() {
		return Type.DELETION;
	}

	@Override
	public void perform() {
		generator.deleteText(modelRoot);
	}

	@Override
	public FileUpdateTask generate() {
		modelRoot = generator.generateTranslationModel(sourceObject);
		return this;
	}

}
