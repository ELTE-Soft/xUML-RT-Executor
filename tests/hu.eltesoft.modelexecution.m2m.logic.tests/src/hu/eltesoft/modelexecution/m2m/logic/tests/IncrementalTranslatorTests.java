package hu.eltesoft.modelexecution.m2m.logic.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.Translator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

import java.util.List;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class IncrementalTranslatorTests extends TranslatorTests {

	private final Mockery context = new Mockery();

	@Override
	protected Translator createTranslator() {
		return Translator.createIncremental(resource);
	}

	@Test
	public void testIncrementalBuildWithoutChanges() {
		List<FileUpdateTask> queue = translator.incrementalBuild();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testIncrementalBuildAfterClassAdded() {
		Class newClass = model.createOwnedClass("TestClass", false);
		List<FileUpdateTask> queue = translator.incrementalBuild();
		assertEquals(1, queue.size());

		TextChangesListener listener = context.mock(TextChangesListener.class);
		context.checking(new Expectations() {
			{
				oneOf(listener).contentChanged(
						with(equal(NamedReference.getIdentifier(newClass))),
						with(any(SourceMappedText.class)),
						with(any(DebugSymbols.class)));
			}
		});
		queue.forEach(t -> t.perform(listener));
	}

	@Test
	public void testIncrementalBuildAfterOperationRemoved() {
		Class class1 = namedChild(model, Class.class, "Class1");
		Operation op1 = namedChild(class1, Operation.class, "Operation1");
		op1.destroy();

		List<FileUpdateTask> queue = translator.incrementalBuild();
		assertEquals(1, queue.size());

		TextChangesListener listener = context.mock(TextChangesListener.class);
		context.checking(new Expectations() {
			{
				oneOf(listener).contentChanged(
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

		List<FileUpdateTask> queue = translator.incrementalBuild();
		assertEquals(2, queue.size());

		TextChangesListener listener = context.mock(TextChangesListener.class);
		context.checking(new Expectations() {
			{
				// we expect two delete operations as the result set of the
				// corresponding query will be empty
				oneOf(listener).contentDeleted(with(equal(eventRootName)));
				oneOf(listener).contentDeleted(with(equal(signalRootName)));
			}
		});
		queue.forEach(t -> t.perform(listener));
	}
}
