package hu.eltesoft.modelexecution.m2m.logic.tests;

import static hu.eltesoft.modelexecution.m2m.logic.tests.Assert.assertAsSets;
import static org.junit.Assert.assertEquals;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.SimpleM2MTranslator;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.Test;

public class SimpleM2MTranslatorTests extends IncQueryBasedTestCase{

	private static final String UML_TEST_MODEL_1_PATH = "resources/model1.uml"; 
	
	private SimpleM2MTranslator translator;
	private BasicTextChangesListener listener = new BasicTextChangesListener();
	
	private void initTranslator(String path) {
		try {
			translator = SimpleM2MTranslator.create(configureEngine(path), listener);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testingOnModel1() {
		initTranslator(UML_TEST_MODEL_1_PATH);
		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());
		
		FileUpdateTaskQueue taskQueue = translator.fullBuild();
		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());
		assertEquals(2, taskQueue.size());
		
		taskQueue.performAll();
		assertEquals(0, listener.deletions.size());
		assertEquals(2, listener.modifications.size());
				
		assertAsSets(new String[]{"A", "R1"}, listener.modifications.get(0), listener.modifications.get(1));
	}
	
}
