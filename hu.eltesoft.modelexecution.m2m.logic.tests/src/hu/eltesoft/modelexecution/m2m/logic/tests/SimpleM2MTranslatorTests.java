package hu.eltesoft.modelexecution.m2m.logic.tests;

import static hu.eltesoft.modelexecution.m2m.logic.tests.Assert.assertAsSets;
import static org.junit.Assert.assertEquals;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.SimpleM2MTranslator;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.Test;

public class SimpleM2MTranslatorTests extends IncQueryBasedTestCase {

	private static final String UML_TEST_SIMPLE_MODEL_PATH = "resources/simple_model.uml";
	private static final String UML_TEST_2015_Q1_MODEL_PATH = "resources/2015_q1_model.uml";
	private static final String[] UML_TEST_2015_Q1_MODEL_EXPECTED_FILES = {
			"Class1", "Region1", "Method1", "Entry1", "Exit1", "Effect0", "Effect1", "Signal1", "SignalEvent1" };
	private static final String PATH_TO_PRINT_GENERATED_FILES = "src_gen";
	

	private SimpleM2MTranslator translator;
	private BasicTextChangesListener listener = new BasicTextChangesListener();

	private void initTranslator(String path) {
		try {
			translator = SimpleM2MTranslator.create(configureEngine(path),
					listener);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testingOnSimpleModel() {
		initTranslator(UML_TEST_SIMPLE_MODEL_PATH);
		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());

		FileUpdateTaskQueue taskQueue = translator.fullBuild();
		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());
		assertEquals(2, taskQueue.size());

		taskQueue.performAll();
		assertEquals(0, listener.deletions.size());
		assertEquals(2, listener.modifications.size());

		assertAsSets(new String[] { "A", "R1" }, listener.modifications.get(0),
				listener.modifications.get(1));
	}

	@Test
	public void testingOn2015Q1Model() {
		initTranslator(UML_TEST_2015_Q1_MODEL_PATH);

		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());

		FileUpdateTaskQueue taskQueue = translator.fullBuild();
		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());
		assertEquals(UML_TEST_2015_Q1_MODEL_EXPECTED_FILES.length, taskQueue.size());

		taskQueue.performAll();
		assertEquals(0, listener.deletions.size());
		assertEquals(UML_TEST_2015_Q1_MODEL_EXPECTED_FILES.length,
				listener.modifications.size());

		assertAsSets(UML_TEST_2015_Q1_MODEL_EXPECTED_FILES,
				listener.modifications.toArray(new String[0]));
		
		listener.printModifiedFiles(PATH_TO_PRINT_GENERATED_FILES);
	}

}
