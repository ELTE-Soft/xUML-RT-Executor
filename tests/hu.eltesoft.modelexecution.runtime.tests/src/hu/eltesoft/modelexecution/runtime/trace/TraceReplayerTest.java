package hu.eltesoft.modelexecution.runtime.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.nio.file.FileSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.jimfs.Jimfs;

import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.base.SignalEvent;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.mocks.DifferentDummySignal;
import hu.eltesoft.modelexecution.runtime.mocks.DummySignal;
import hu.eltesoft.modelexecution.runtime.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader.EventSource;

@RunWith(MockitoJUnitRunner.class)
public class TraceReplayerTest {

	@Mock
	private Logger logger;

	@Test
	public void testHasEvent_WithoutMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		createEvents(fileSystem, traceFileName);

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem, getClass().getClassLoader())) {
			assertFalse(sut.hasEvent());
		}
	}

	@Test
	public void testHasEvent_WithMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		createEvents(fileSystem, traceFileName,
				new TargetedEvent(new MockClass(null), new SignalEvent(new DummySignal())));

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem, getClass().getClassLoader())) {
			assertTrue(sut.hasEvent());
		}
	}

	@Test(expected = Exception.class)
	public void testDispatchEvent_WithoutMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		createEvents(fileSystem, traceFileName);

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem, getClass().getClassLoader())) {
			sut.dispatchEvent(null);
		}
	}

	@Test(expected = TraceMessageUnexpectedException.class)
	public void testDispatchEvent_WithInternalMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		createEvents(fileSystem, traceFileName,
				new TargetedEvent(new MockClass(null), new SignalEvent(new DummySignal())));

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem, getClass().getClassLoader())) {
			sut.dispatchEvent(null);
		}
	}

	@Test
	public void testDispatchEvent_WithExternalMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName, TargetedEvent.createOutsideEvent(target, event));

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem, getClass().getClassLoader())) {
			sut.dispatchEvent(logger);
			verify(logger).messageDispatched(target, event);
		}
	}

	@Test
	public void testDispatchEventWithParam_WithoutMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName);

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem, getClass().getClassLoader())) {
			assertEquals(EventSource.Queue, sut.dispatchEvent(new TargetedEvent(target, event), logger));
			verify(logger).messageDispatched(target, event);
		}
	}

	@Test
	public void testDispatchEventWithParam_WithSameInternalMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName, new TargetedEvent(target, event));

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem, getClass().getClassLoader())) {
			assertEquals(EventSource.Queue, sut.dispatchEvent(new TargetedEvent(target, event), logger));
			verify(logger).messageDispatched(target, event);
		}
	}

	@Test(expected = TraceMessageMismatchException.class)
	public void testDispatchEventWithParam_WithDifferentInternalMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName, new TargetedEvent(target, event));

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem, getClass().getClassLoader())) {
			Event event2 = new SignalEvent(new DifferentDummySignal(1));
			sut.dispatchEvent(new TargetedEvent(target, event2), logger);

			verify(logger).messageDispatched(target, event);
		}
	}

	@Test
	public void testDispatchEventWithParam_WithExternalMessage() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String traceFileName = "trace";
		MockClass target = new MockClass(null);
		Event event = new SignalEvent(new DummySignal());
		createEvents(fileSystem, traceFileName, TargetedEvent.createOutsideEvent(target, event));

		try (TraceReplayer sut = new TraceReplayer(traceFileName, fileSystem, getClass().getClassLoader())) {
			Event event2 = new SignalEvent(new DifferentDummySignal(1));
			assertEquals(EventSource.Trace, sut.dispatchEvent(new TargetedEvent(target, event2), logger));

			verify(logger).messageDispatched(target, event);
		}
	}

	private void createEvents(FileSystem fileSystem, String filePath, TargetedEvent... messages) throws Exception {
		try (TraceWriter sut = TraceWriter.forSpecifiedFile(filePath, fileSystem)) {
			for (TargetedEvent message : messages) {
				sut.traceEvent(message);
			}
		}
	}
}
