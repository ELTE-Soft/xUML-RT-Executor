package hu.eltesoft.modelexecution.m2m.logic.tests;

import static org.junit.Assert.assertEquals;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.Translator;

import java.util.List;

import org.junit.Test;

public class BatchTranslatorTests extends TranslatorTests {

	@Override
	protected Translator createTranslator() {
		return Translator.create(resource);
	};

	@Test
	public void testIncrementalBuildWithoutChanges() {
		List<FileUpdateTask> queue = translator.incrementalBuild();
		// 9 = 5 behaviors, a class, a region, a signal and an event
		assertEquals(9, queue.size());
	}
}
