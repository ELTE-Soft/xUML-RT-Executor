package hu.eltesoft.modelexecution.m2m.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeChangeListener;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

import java.util.List;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class IncrementalResourceTranslatorTests extends ResourceTranslatorTests {

	private final Mockery context = new Mockery();

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
		List<SourceCodeTask> queue = translator.incrementalTranslation();
		assertEquals(1, queue.size());

		SourceCodeChangeListener listener = context
				.mock(SourceCodeChangeListener.class);
		context.checking(new Expectations() {
			{
				oneOf(listener).sourceCodeChanged(
						with(equal(NamedReference.getIdentifier(newClass))),
						with(any(SourceMappedText.class)),
						with(any(DebugSymbols.class)));
			}
		});
		queue.forEach(t -> t.perform(listener));
	}

	@Test
	public void testIncrementalBuildAfterMethodRemoved() {
		Class class1 = namedChild(model, Class.class, "Class1");
		Behavior method1 = namedChild(class1, Behavior.class, "Method1");
		String behaviorRootName = NamedReference.getIdentifier(method1);
		method1.destroy();

		List<SourceCodeTask> queue = translator.incrementalTranslation();
		assertEquals(2, queue.size());

		SourceCodeChangeListener listener = context
				.mock(SourceCodeChangeListener.class);
		context.checking(new Expectations() {
			{
				oneOf(listener)
						.sourceCodeDeleted(with(equal(behaviorRootName)));

				oneOf(listener).sourceCodeChanged(
						with(equal(NamedReference.getIdentifier(class1))),
						with(any(SourceMappedText.class)),
						with(any(DebugSymbols.class)));
			}
		});
		queue.forEach(t -> t.perform(listener));
	}

	@Test
	public void testIncrementalBuildAfterSignalRemoved() {
		SignalEvent event1 = namedChild(model, SignalEvent.class,
				"SignalEvent1");
		String eventRootName = NamedReference.getIdentifier(event1);

		Signal signal1 = namedChild(model, Signal.class, "Signal1");
		String signalRootName = NamedReference.getIdentifier(signal1);
		signal1.destroy();

		List<SourceCodeTask> queue = translator.incrementalTranslation();
		assertEquals(1, queue.size());

		SourceCodeChangeListener listener = context
				.mock(SourceCodeChangeListener.class);
		context.checking(new Expectations() {
			{
				// we expect two delete operations as the result set of the
				// corresponding query will be empty
				oneOf(listener).sourceCodeDeleted(with(equal(eventRootName)));
				oneOf(listener).sourceCodeDeleted(with(equal(signalRootName)));
			}
		});
		queue.forEach(t -> t.perform(listener));
	}
}
