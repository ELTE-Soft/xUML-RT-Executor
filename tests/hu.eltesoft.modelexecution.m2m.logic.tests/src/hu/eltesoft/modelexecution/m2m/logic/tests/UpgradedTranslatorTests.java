package hu.eltesoft.modelexecution.m2m.logic.tests;

import hu.eltesoft.modelexecution.m2m.logic.Translator;

public class UpgradedTranslatorTests extends IncrementalTranslatorTests {

	@Override
	protected Translator createTranslator() {
		Translator translator = Translator.createIncremental(resource);
		// override resource and model before upgrade
		resource = loadResource(modelPath);
		model = loadModel(resource);
		translator.toIncremental(resource);
		return translator;
	}
}
