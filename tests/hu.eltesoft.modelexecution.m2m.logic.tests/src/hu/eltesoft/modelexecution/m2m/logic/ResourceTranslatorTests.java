package hu.eltesoft.modelexecution.m2m.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.junit.Test;

import hu.eltesoft.modelexecution.ide.common.ProjectProperties;
import hu.eltesoft.modelexecution.ide.common.ProjectProperties.ValidationLevels;
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

		// do not stop on model validation errors
		ProjectProperties.DEFAULT_VALIDATION_LEVEL = ValidationLevels.NEVER_STOP;
	};

	protected abstract ResourceTranslator createTranslator();

	@Test
	public void testFullBuildTaskCount() {
		assertFullBuildQueueSizeIsCorrect();
	}

	@Test
	public void testFullBuildAfterUpgradeOnSameResource() {
		translator.toIncremental(modelSet);
		assertFullBuildQueueSizeIsCorrect();
	}

	@Test
	public void testFullBuildAfterUpgradeWithNewResource() {
		ModelSet modelSet = loadModelSet();
		loadModel(modelSet, UML_TEST_MODEL_PATH);
		translator.toIncremental(modelSet);
		assertFullBuildQueueSizeIsCorrect();
	}

	protected void assertFullBuildQueueSizeIsCorrect() {
		List<SourceCodeTask> queue = translator.fullTranslation();
		// a behavior, a class specification, a class implementation, a region,
		// and two signals
		assertEquals(6, queue.size());
	}

	@Test
	public void testIncrementalBuildAfterUpgrade() {
		ModelSet modelSet = loadModelSet();
		translator.toIncremental(modelSet);
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
		ModelSet modelSet = loadModelSet();
		translator.toIncremental(modelSet);
	}

	@Test
	public void testDisposeIsIdempotent() {
		translator.dispose();
		translator.dispose();
	}
}
