package hu.eltesoft.modelexecution.runtime;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import hu.eltesoft.modelexecution.runtime.base.Event;
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

		BaseRuntime sut = new BaseRuntime(getClass().getClassLoader());
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
		when(readerMock.dispatchEvent(any(TargetedEvent.class), same(loggerMock)))
				.thenAnswer(new Answer<EventSource>() {

					@Override
					public EventSource answer(InvocationOnMock invocation) throws Throwable {
						// simply dispatch the event to the target object
						TargetedEvent event = (TargetedEvent) invocation.getArguments()[0];
						event.getTarget().receive(event.getEvent());
						return EventSource.Queue;
					}
				});

		BaseRuntime sut = new BaseRuntime(getClass().getClassLoader());
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
}
