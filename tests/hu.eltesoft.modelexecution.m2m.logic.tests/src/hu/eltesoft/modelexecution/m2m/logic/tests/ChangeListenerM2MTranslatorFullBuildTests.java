package hu.eltesoft.modelexecution.m2m.logic.tests;

import hu.eltesoft.modelexecution.m2m.logic.ChangeListenerM2MTranslator;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.Test;

public class ChangeListenerM2MTranslatorFullBuildTests extends
		SimpleM2MTranslatorTests {

	@Override
	protected void initTranslator(String path) {
		try {
			translator = ChangeListenerM2MTranslator.create(
					configureEngine(path), listener);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	// includes tests inherited from SimpleM2MTranslatorTests

	@Test
	public void testingFullBuildOnSimpleModelRepeteadly() {
		initTranslator(UML_TEST_SIMPLE_MODEL_PATH);

		for (int i = 0; i < 3; ++i) {
			listener.clear();
			translator.fullBuild().performAll();
		}

		checkSimpleModelResult();

	}

	@Test
	public void testingRebuildAsFirstBuild() {
		initTranslator(UML_TEST_SIMPLE_MODEL_PATH);

		ChangeListenerM2MTranslator changeListenerTranslator = (ChangeListenerM2MTranslator) translator;

		listener.clear();
		changeListenerTranslator.rebuild().performAll();

		checkSimpleModelResult();

	}

}
