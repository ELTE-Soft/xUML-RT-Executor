package hu.eltesoft.modelexecution.m2m.logic;

import org.junit.Test;

import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;

public class BatchResourceTranslatorTests extends ResourceTranslatorTests {

	@Override
	protected ResourceTranslator createTranslator() {
		return ResourceTranslator.create(modelSet);
	};

	@Test
	public void testIncrementalBuildWithoutChanges() {
		assertFullBuildQueueSizeIsCorrect();
	}
}
