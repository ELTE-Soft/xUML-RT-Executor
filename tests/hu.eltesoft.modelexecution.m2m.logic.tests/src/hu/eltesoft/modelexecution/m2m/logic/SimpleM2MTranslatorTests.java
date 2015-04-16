package hu.eltesoft.modelexecution.m2m.logic;

import static hu.eltesoft.modelexecution.m2m.logic.Assert.assertAsSets;
import static org.junit.Assert.assertEquals;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.SimpleM2MTranslator;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.Test;

public class SimpleM2MTranslatorTests extends IncQueryBasedTestCase {	

	protected SimpleM2MTranslator translator;
	protected BasicTextChangesListener listener = new BasicTextChangesListener();

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

	protected void checkSimpleModelResult() {
		assertEquals(0, listener.deletions.size());
		assertEquals(2, listener.modifications.size());

		assertAsSets(new String[] { "A", "R1" }, listener.modifications.get(0),
				listener.modifications.get(1));		
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
		assertEquals(UML_TEST_2015_Q1_MODEL_EXPECTED_FILES.length, taskQueue.size());

		taskQueue.performAll();
		
		assertEquals(0, listener.deletions.size());
		assertEquals(UML_TEST_2015_Q1_MODEL_EXPECTED_FILES.length,
				listener.modifications.size());

		assertAsSets(UML_TEST_2015_Q1_MODEL_EXPECTED_FILES,
				listener.modifications.toArray(new String[0]));
	}

}