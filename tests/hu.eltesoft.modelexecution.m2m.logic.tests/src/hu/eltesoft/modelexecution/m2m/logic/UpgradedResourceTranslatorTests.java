package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;

public class UpgradedResourceTranslatorTests extends IncrementalResourceTranslatorTests {

	@Override
	protected ResourceTranslator createTranslator() {
		ResourceTranslator translator = ResourceTranslator.createIncremental(modelSet);
		// override resource and model before upgrade
		modelSet = loadModelSet();
		model = loadModel(modelSet, modelPath);
		translator.toIncremental(modelSet);
		return translator;
	}
}
