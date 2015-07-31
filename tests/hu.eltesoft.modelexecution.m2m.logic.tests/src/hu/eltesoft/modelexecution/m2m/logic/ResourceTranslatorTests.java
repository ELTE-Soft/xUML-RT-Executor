package hu.eltesoft.modelexecution.m2m.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;
import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase;

public abstract class ResourceTranslatorTests extends ModelBasedTestCase {

	protected static final String UML_TEST_MODEL_PATH = "resources/2015_q1_model.uml";

	public ResourceTranslatorTests() {
		super(UML_TEST_MODEL_PATH);
	}

	protected ResourceTranslator translator;

	@Override
	public void setUp() {
		super.setUp();
		translator = createTranslator();
	};

	protected abstract ResourceTranslator createTranslator();

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
		List<SourceCodeTask> queue = translator.fullTranslation();
		// 9 = 5 behaviors, a class specification, a class implementation, a
		// region, and a signal
		assertEquals(9, queue.size());
	}

	@Test
	public void testIncrementalBuildAfterUpgrade() {
		Resource newResource = loadResource(modelPath);
		translator.toIncremental(newResource);
		List<SourceCodeTask> queue = translator.incrementalTranslation();
		assertTrue(queue.isEmpty());
	}

	@Test(expected = IllegalStateException.class)
	public void testFullBuildAfterDisposeFails() {
		translator.dispose();
		translator.fullTranslation();
	}

	@Test(expected = IllegalStateException.class)
	public void testIncrementalBuildAfterDisposeFails() {
		translator.dispose();
		translator.incrementalTranslation();
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
