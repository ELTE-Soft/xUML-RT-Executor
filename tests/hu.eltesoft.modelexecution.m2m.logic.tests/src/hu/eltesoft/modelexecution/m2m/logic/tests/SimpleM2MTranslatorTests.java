package hu.eltesoft.modelexecution.m2m.logic.tests;

import static hu.eltesoft.modelexecution.m2m.logic.tests.Assert.assertAsSets;
import static org.junit.Assert.assertEquals;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.SimpleM2MTranslator;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.Test;

public class SimpleM2MTranslatorTests extends M2MTranslatorTestsBase {

	protected SimpleM2MTranslator translator;

	protected void initTranslator(String path) {
		try {
			translator = SimpleM2MTranslator.create(configureEngine(path),
					listener);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testingFullBuildOnSimpleModel() {
		initTranslator(UML_TEST_SIMPLE_MODEL_PATH);

		listener.clear();

		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());

		FileUpdateTaskQueue taskQueue = translator.fullBuild();

		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());
		assertEquals(2, taskQueue.size());

		taskQueue.performAll();

		checkSimpleModelResult();
	}

	@Test
	public void testingFullBuildOn2015Q1Model() {
		initTranslator(UML_TEST_2015_Q1_MODEL_PATH);

		listener.clear();

		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());

		FileUpdateTaskQueue taskQueue = translator.fullBuild();

		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());
		assertEquals(UML_TEST_2015_Q1_MODEL_EXPECTED_FILES.length,
				taskQueue.size());

		taskQueue.performAll();

		assertEquals(0, listener.deletions.size());
		assertEquals(UML_TEST_2015_Q1_MODEL_EXPECTED_FILES.length,
				listener.modifications.size());

		assertAsSets(UML_TEST_2015_Q1_MODEL_EXPECTED_FILES,
				listener.modifications.toArray(new String[0]));
	}

}
