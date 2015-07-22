package hu.eltesoft.modelexecution.m2m.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Signal;
import org.junit.Test;

import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

public class IncrementalResourceTranslatorTests extends ResourceTranslatorTests {

	@Override
	protected ResourceTranslator createTranslator() {
		return ResourceTranslator.createIncremental(resource);
	}

	@Test
	public void testIncrementalBuildWithoutChanges() {
		List<SourceCodeTask> queue = translator.incrementalTranslation();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testIncrementalBuildAfterClassAdded() {
		Class newClass = model.createOwnedClass("TestClass", false);
		String classRootName = NamedReference.getIdentifier(newClass);

		List<SourceCodeTask> queue = translator.incrementalTranslation();
		assertEquals(1, queue.size());

		SourceCodeChangeListener listener = mock(SourceCodeChangeListener.class);

		queue.forEach(t -> t.perform(listener));

		verify(listener).sourceCodeChanged(eq(classRootName), any(SourceMappedText.class), any(DebugSymbols.class));
	}

	@Test
	public void testIncrementalBuildAfterMethodRemoved() {
		Class class1 = namedChild(model, Class.class, "Class1");
		String classRootName = NamedReference.getIdentifier(class1);

		Behavior method1 = namedChild(class1, Behavior.class, "Method1");
		String behaviorRootName = NamedReference.getIdentifier(method1);
		method1.destroy();

		List<SourceCodeTask> queue = translator.incrementalTranslation();
		assertEquals(2, queue.size());

		SourceCodeChangeListener listener = mock(SourceCodeChangeListener.class);

		queue.forEach(t -> t.perform(listener));

		verify(listener).sourceCodeDeleted(eq(behaviorRootName));
		verify(listener).sourceCodeChanged(eq(classRootName), any(SourceMappedText.class), any(DebugSymbols.class));
	}

	@Test
	public void testIncrementalBuildAfterSignalRemoved() {
		Signal signal1 = namedChild(model, Signal.class, "Signal1");
		String signalRootName = NamedReference.getIdentifier(signal1);
		signal1.destroy();

		List<SourceCodeTask> queue = translator.incrementalTranslation();
		assertEquals(1, queue.size());

		SourceCodeChangeListener listener = mock(SourceCodeChangeListener.class);

		queue.forEach(t -> t.perform(listener));

		verify(listener).sourceCodeDeleted(eq(signalRootName));
	}
}
