package hu.eltesoft.modelexecution.runtime;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.base.Event.Priority;
import hu.eltesoft.modelexecution.runtime.base.SignalEvent;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.mocks.DummySignal;
import hu.eltesoft.modelexecution.runtime.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.TargetedEvent;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader.EventSource;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

@RunWith(MockitoJUnitRunner.class)
public class BaseRuntimeTest {

	@Mock
	private Logger loggerMock;

	@Mock
	private Tracer tracerMock;

	@Mock
	private TraceReader readerMock;

	@Test
	public void testRun() throws Exception {
		when(readerMock.hasEvent()).thenReturn(false);

		BaseRuntime sut = BaseRuntime.getInstance();
		sut.setClassLoader(getClass().getClassLoader());
		sut.setLogger(loggerMock);
		sut.setTraceWriter(tracerMock);
		sut.setTraceReader(readerMock);
		sut.run(MockClass.class.getCanonicalName(), "emptyFeed");
		sut.close();

		verify(tracerMock).close();
		verify(readerMock).close();
		verify(loggerMock).close();
	}

	@Test
	public void testRun_eventFeeded() throws Exception {
		when(readerMock.hasEvent()).thenReturn(false);
		when(readerMock.dispatchEvent(any(TargetedEvent.class), same(loggerMock))).thenAnswer(invocation -> {
			// simply dispatch the event to the target object
			TargetedEvent event = (TargetedEvent) invocation.getArguments()[0];
			event.getTarget().receive(event.getEvent());
			return EventSource.Queue;

		});

		BaseRuntime sut = BaseRuntime.getInstance();
		sut.setClassLoader(getClass().getClassLoader());
		sut.setLogger(loggerMock);
		sut.setTraceWriter(tracerMock);
		sut.setTraceReader(readerMock);
		sut.run(MockClass.class.getCanonicalName(), "feedEvent");
		sut.close();

		Event event = new SignalEvent(new DummySignal());
		verify(loggerMock).messageQueued(any(MockClass.class), eq(event));
		verify(tracerMock).traceEvent(any(TargetedEvent.class));
		verify(tracerMock).close();
		verify(readerMock).close();
		verify(loggerMock).close();
	}

	@Test
	public void testRunWithPriorities() throws Exception {
		when(readerMock.hasEvent()).thenReturn(false);
		when(readerMock.dispatchEvent(any(TargetedEvent.class), same(loggerMock))).thenAnswer(invocation -> {
			// simply dispatch the event to the target object
			TargetedEvent event = (TargetedEvent) invocation.getArguments()[0];
			event.getTarget().receive(event.getEvent());
			loggerMock.messageDispatched(event.getTarget(), event.getEvent());
			return EventSource.Queue;
		});

		BaseRuntime sut = BaseRuntime.getInstance();
		sut.setClassLoader(getClass().getClassLoader());
		sut.setLogger(loggerMock);
		sut.setTraceWriter(tracerMock);
		sut.setTraceReader(readerMock);
		sut.run(MockClass.class.getCanonicalName(), "priorityFeed");
		sut.close();

		Event eventNormal = new SignalEvent(new DummySignal());
		Event eventHigh = new SignalEvent(new DummySignal(), Priority.HIGH);

		InOrder inOrder = Mockito.inOrder(loggerMock);
		// the normal priority event is queued earlier
		inOrder.verify(loggerMock).messageQueued(any(MockClass.class), eq(eventNormal));
		inOrder.verify(loggerMock).messageQueued(any(MockClass.class), eq(eventHigh));
		// the high priority event must be dispatched first
		inOrder.verify(loggerMock).messageDispatched(any(MockClass.class), eq(eventHigh));
		inOrder.verify(loggerMock).messageDispatched(any(MockClass.class), eq(eventNormal));

		verify(tracerMock).close();
		verify(readerMock).close();
		verify(loggerMock).close();
	}
}
