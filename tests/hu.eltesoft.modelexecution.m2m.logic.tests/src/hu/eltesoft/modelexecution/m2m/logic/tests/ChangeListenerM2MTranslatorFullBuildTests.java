package hu.eltesoft.modelexecution.m2m.logic.tests;

import hu.eltesoft.modelexecution.m2m.logic.Translator;

import org.junit.Test;

public class ChangeListenerM2MTranslatorFullBuildTests extends
		SimpleM2MTranslatorTests {

	@Override
	protected void initTranslator(String path) {
		translator = Translator.createIncremental(loadResource(path));
	}

	// includes tests inherited from SimpleM2MTranslatorTests

	@Test
	public void testingFullBuildOnSimpleModelRepeteadly() {
		initTranslator(UML_TEST_SIMPLE_MODEL_PATH);

		for (int i = 0; i < 3; ++i) {
			listener.clear();
			translator.fullBuild().forEach(t -> t.perform(listener));
		}

		checkSimpleModelResult();
	}

	@Test
	public void testingRebuildAsFirstBuild() {
		initTranslator(UML_TEST_SIMPLE_MODEL_PATH);

		Translator changeListenerTranslator = (Translator) translator;

		listener.clear();
		changeListenerTranslator.incrementalBuild().forEach(
				t -> t.perform(listener));

		checkSimpleModelResult();
	}
}
