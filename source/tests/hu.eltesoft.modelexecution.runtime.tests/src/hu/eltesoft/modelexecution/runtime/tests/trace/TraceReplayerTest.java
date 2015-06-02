package hu.eltesoft.modelexecution.runtime.tests.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.tests.mocks.DifferentDummyEvent;
import hu.eltesoft.modelexecution.runtime.tests.mocks.DummySignal;
import hu.eltesoft.modelexecution.runtime.tests.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.TargetedMessage;
import hu.eltesoft.modelexecution.runtime.trace.TraceMessageMismatchException;
import hu.eltesoft.modelexecution.runtime.trace.TraceMessageUnexpectedException;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader.EventSource;
import hu.eltesoft.modelexecution.runtime.trace.TraceReplayer;
import hu.eltesoft.modelexecution.runtime.trace.TraceWriter;

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
		createEvents(fileSystem, traceFileName, new TargetedMessage(
				new MockClass(null), new DummySignal()));
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
		createEvents(fileSystem, traceFileName, new TargetedMessage(
				new MockClass(null), new DummySignal()));

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
		DummySignal message = new DummySignal();
		createEvents(fileSystem, traceFileName,
				TargetedMessage.createOutsideEvent(target, message));
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());

		context.checking(new Expectations() {
			{
				oneOf(logger).messageDispatched(target, message);
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
		DummySignal message = new DummySignal();
		createEvents(fileSystem, traceFileName);
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());

		context.checking(new Expectations() {
			{
				oneOf(logger).messageDispatched(target, message);
			}
		});

		assertEquals(EventSource.Queue,
				sut.dispatchEvent(new TargetedMessage(target, message), logger));
		sut.close();
	}

	@Test
	public void testDispatchEventWithParam_WithSameInternalMessage()
			throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		Logger logger = context.mock(Logger.class);
		MockClass target = new MockClass(null);
		DummySignal message = new DummySignal();
		createEvents(fileSystem, traceFileName, new TargetedMessage(target,
				message));
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());

		context.checking(new Expectations() {
			{
				oneOf(logger).messageDispatched(target, message);
			}
		});

		assertEquals(EventSource.Queue,
				sut.dispatchEvent(new TargetedMessage(target, message), logger));
		sut.close();
	}

	@Test(expected = TraceMessageMismatchException.class)
	public void testDispatchEventWithParam_WithDifferentInternalMessage()
			throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		Logger logger = context.mock(Logger.class);
		MockClass target = new MockClass(null);
		DummySignal message = new DummySignal();
		createEvents(fileSystem, traceFileName, new TargetedMessage(target,
				message));

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader())) {

			context.checking(new Expectations() {
				{
					oneOf(logger).messageDispatched(target, message);
				}
			});

			DifferentDummyEvent message2 = new DifferentDummyEvent(1);
			sut.dispatchEvent(new TargetedMessage(target, message2), logger);
		}
	}

	@Test
	public void testDispatchEventWithParam_WithExternalMessage()
			throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		Logger logger = context.mock(Logger.class);
		MockClass target = new MockClass(null);
		DummySignal message = new DummySignal();
		createEvents(fileSystem, traceFileName,
				TargetedMessage.createOutsideEvent(target, message));
		TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem,
				getClass().getClassLoader());

		context.checking(new Expectations() {
			{
				oneOf(logger).messageDispatched(target, message);
			}
		});

		DifferentDummyEvent message2 = new DifferentDummyEvent(1);
		assertEquals(EventSource.Trace, sut.dispatchEvent(new TargetedMessage(
				target, message2), logger));
		sut.close();
	}

	private void createEvents(FileSystem fileSystem, String filePath,
			TargetedMessage... messages) throws Exception {
		TraceWriter sut = TraceWriter.forSpecifiedFile(filePath, fileSystem);
		for (TargetedMessage message : messages) {
			sut.traceEvent(message);
		}
		sut.close();
	}
}
