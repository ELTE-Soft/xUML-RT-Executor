package hu.eltesoft.modelexecution.m2m.logic;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;

public class BatchResourceTranslatorTests extends ResourceTranslatorTests {

	@Override
	protected ResourceTranslator createTranslator() {
		return ResourceTranslator.create(resource);
	};

	@Test
	public void testIncrementalBuildWithoutChanges() {
		List<SourceCodeTask> queue = translator.incrementalTranslation();
		// 9 = 5 behaviors, a class specification, a class implementation, a
		// region, and a signal
		assertEquals(9, queue.size());
	}
}
