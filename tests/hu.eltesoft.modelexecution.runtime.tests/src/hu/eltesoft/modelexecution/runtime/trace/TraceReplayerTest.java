package hu.eltesoft.modelexecution.runtime.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.base.SignalEvent;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.mocks.DifferentDummySignal;
import hu.eltesoft.modelexecution.runtime.mocks.DummySignal;
import hu.eltesoft.modelexecution.runtime.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader.EventSource;

import java.nio.file.FileSystem;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import com.google.common.jimfs.Jimfs;

public class TraceReplayerTest {

	Mockery context = new Mockery();

	@Test
	public void testHasEvent_WithoutMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		createEvents(fileSystem, traceFileName);
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());
		assertFalse(sut.hasEvent());
		sut.close();
	}

	@Test
	public void testHasEvent_WithMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		createEvents(fileSystem, traceFileName, new TargetedEvent(
				new MockClass(null), new SignalEvent(new DummySignal())));
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());
		assertTrue(sut.hasEvent());
		sut.close();
	}

	@Test(expected = Exception.class)
	public void testDispatchEvent_WithoutMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		createEvents(fileSystem, traceFileName);

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader())) {
			sut.dispatchEvent(null);
		}
	}

	@Test(expected = TraceMessageUnexpectedException.class)
	public void testDispatchEvent_WithInternalMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		createEvents(fileSystem, traceFileName, new TargetedEvent(
				new MockClass(null), new SignalEvent(new DummySignal())));

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader())) {
			sut.dispatchEvent(null);
		}
	}

	@Test
	public void testDispatchEvent_WithExternalMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		Logger logger = context.mock(Logger.class);
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName,
				TargetedEvent.createOutsideEvent(target, event));
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());

		context.checking(new Expectations() {
			{
				oneOf(logger).messageDispatched(target, event);
			}
		});
		sut.dispatchEvent(logger);

		sut.close();
	}

	@Test
	public void testDispatchEventWithParam_WithoutMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		Logger logger = context.mock(Logger.class);
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName);
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());

		context.checking(new Expectations() {
			{
				oneOf(logger).messageDispatched(target, event);
			}
		});

		assertEquals(EventSource.Queue,
				sut.dispatchEvent(new TargetedEvent(target, event), logger));
		sut.close();
	}

	@Test
	public void testDispatchEventWithParam_WithSameInternalMessage()
			throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		Logger logger = context.mock(Logger.class);
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName,
				new TargetedEvent(target, event));
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());

		context.checking(new Expectations() {
			{
				oneOf(logger).messageDispatched(target, event);
			}
		});

		assertEquals(EventSource.Queue,
				sut.dispatchEvent(new TargetedEvent(target, event), logger));
		sut.close();
	}

	@Test(expected = TraceMessageMismatchException.class)
	public void testDispatchEventWithParam_WithDifferentInternalMessage()
			throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		Logger logger = context.mock(Logger.class);
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName,
				new TargetedEvent(target, event));

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader())) {

			context.checking(new Expectations() {
				{
					oneOf(logger).messageDispatched(target, event);
				}
			});

			Event event2 = new SignalEvent(new DifferentDummySignal(1));
			sut.dispatchEvent(new TargetedEvent(target, event2), logger);
		}
	}

	@Test
	public void testDispatchEventWithParam_WithExternalMessage()
			throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		Logger logger = context.mock(Logger.class);
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName,
				TargetedEvent.createOutsideEvent(target, event));
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());

		context.checking(new Expectations() {
			{
				oneOf(logger).messageDispatched(target, event);
			}
		});

		Event event2 = new SignalEvent(new DifferentDummySignal(1));
		assertEquals(EventSource.Trace,
				sut.dispatchEvent(new TargetedEvent(target, event2), logger));
		sut.close();
	}

	private void createEvents(FileSystem fileSystem, String filePath,
			TargetedEvent... messages) throws Exception {
		TraceWriter sut = TraceWriter.forSpecifiedFile(filePath, fileSystem);
		for (TargetedEvent message : messages) {
			sut.traceEvent(message);
		}
		sut.close();
	}
}
