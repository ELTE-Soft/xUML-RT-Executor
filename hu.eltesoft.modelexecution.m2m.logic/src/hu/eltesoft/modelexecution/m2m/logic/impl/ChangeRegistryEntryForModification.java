package hu.eltesoft.modelexecution.m2m.logic.impl;

import hu.eltesoft.modelexecution.m2m.logic.generators.IGenerator;
import hu.eltesoft.modelexecution.m2m.logic.interfaces.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ModelGenerationTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;

public class ChangeRegistryEntryForModification<S extends EObject, R extends ModelRoot> implements
		ChangeRegistry.ParametricEntry<S, R>, ModelGenerationTask, FileUpdateTask {

	private final IGenerator<S, R> generator;
	private S sourceObject;
	private R modelRoot;
	
	
	public ChangeRegistryEntryForModification(IGenerator<S, R> generator, S sourceObject) {
		this.generator = generator;
		this.sourceObject = sourceObject;
		this.modelRoot = null; // set after the generation of the translation model
	}
	
	@Override
	public Type getType() {
		return Type.MODIFICATION;
	}

	@Override
	public FileUpdateTask generate() {
		modelRoot = generator.generateTranslationModel(sourceObject);
		sourceObject = null;
		return this;
	}

	@Override
	public void perform() {
		generator.generateText(modelRoot);
	}

}
