package hu.eltesoft.modelexecution.m2m.logic.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.Translator;
import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

public abstract class TranslatorTests extends ModelBasedTestCase {

	protected static final String UML_TEST_MODEL_PATH = "resources/2015_q1_model.uml";

	public TranslatorTests() {
		super(UML_TEST_MODEL_PATH);
	}

	protected Translator translator;

	@Override
	public void setUp() {
		super.setUp();
		translator = createTranslator();
	};

	protected abstract Translator createTranslator();

	@Test
	public void testFullBuildTaskCount() {
		assertFullBuildQueueSizeIsCorrect();
	}

	@Test
	public void testFullBuildAfterUpgradeOnSameResource() {
		translator.toIncremental(resource);
		assertFullBuildQueueSizeIsCorrect();
	}

	@Test
	public void testFullBuildAfterUpgradeWithNewResource() {
		Resource newResource = loadResource(modelPath);
		translator.toIncremental(newResource);
		assertFullBuildQueueSizeIsCorrect();
	}

	private void assertFullBuildQueueSizeIsCorrect() {
		List<FileUpdateTask> queue = translator.fullBuild();
		// 9 = 5 behaviors, a class, a region, a signal and an event
		assertEquals(9, queue.size());
	}

	@Test
	public void testIncrementalBuildAfterUpgrade() {
		Resource newResource = loadResource(modelPath);
		translator.toIncremental(newResource);
		List<FileUpdateTask> queue = translator.incrementalBuild();
		assertTrue(queue.isEmpty());
	}

	@Test(expected = IllegalStateException.class)
	public void testFullBuildAfterDisposeFails() {
		translator.dispose();
		translator.fullBuild();
	}

	@Test(expected = IllegalStateException.class)
	public void testIncrementalBuildAfterDisposeFails() {
		translator.dispose();
		translator.incrementalBuild();
	}

	@Test(expected = IllegalStateException.class)
	public void testUpgradeAfterDisposeFails() {
		translator.dispose();
		Resource newResource = loadResource(modelPath);
		translator.toIncremental(newResource);
	}

	@Test
	public void testDisposeIsIdempotent() {
		translator.dispose();
		translator.dispose();
	}
}
