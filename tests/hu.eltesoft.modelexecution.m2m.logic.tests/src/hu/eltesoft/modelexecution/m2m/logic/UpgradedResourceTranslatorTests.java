package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;

public class UpgradedResourceTranslatorTests extends IncrementalResourceTranslatorTests {

	@Override
	protected ResourceTranslator createTranslator() {
		ResourceTranslator translator = ResourceTranslator.createIncremental(resource);
		// override resource and model before upgrade
		resource = loadResource(modelPath);
		model = loadModel(resource);
		translator.toIncremental(resource);
		return translator;
	}
}
