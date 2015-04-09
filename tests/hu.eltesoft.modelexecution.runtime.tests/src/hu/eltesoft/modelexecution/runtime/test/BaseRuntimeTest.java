package hu.eltesoft.modelexecution.runtime.test;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.test.mocks.DummyEvent;
import hu.eltesoft.modelexecution.runtime.test.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.TargetedEvent;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader.EventSource;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class BaseRuntimeTest {

	Mockery context = new Mockery();

	@Test
	public void testRun() throws Exception {

		Logger loggerMock = context.mock(Logger.class);
		Tracer tracerMock = context.mock(Tracer.class);
		TraceReader readerMock = context.mock(TraceReader.class);

		BaseRuntime sut = new BaseRuntimeExtension(tracerMock, readerMock, loggerMock);

		context.checking(new Expectations() {
			{
				allowing(readerMock).hasEvent();
				will(returnValue(false));
				oneOf(tracerMock).close();
				oneOf(readerMock).close();
				oneOf(loggerMock).close();
			}
		});

		sut.run(MockClass.class.getCanonicalName(), "emptyFeed");
	}

	@Test
	public void testRun_eventFeeded() throws Exception {

		Logger loggerMock = context.mock(Logger.class);
		Tracer tracerMock = context.mock(Tracer.class);
		TraceReader readerMock = context.mock(TraceReader.class);

		BaseRuntime sut = new BaseRuntime(tracerMock, readerMock, loggerMock) {
		};

		context.checking(new Expectations() {
			{
				allowing(readerMock).hasEvent();
				will(returnValue(false));
				MockClass classInstance = MockClass.getInstance();
				DummyEvent event = new DummyEvent();
				TargetedEvent te = new TargetedEvent(classInstance, event);
				oneOf(loggerMock).eventQueued(classInstance, event);
				oneOf(readerMock).dispatchEvent(te, loggerMock);
				will(returnValue(EventSource.Queue));
				oneOf(tracerMock).traceEvent(te);
				oneOf(tracerMock).close();
				oneOf(readerMock).close();
				oneOf(loggerMock).close();
			}
		});

		sut.run(MockClass.class.getCanonicalName(), "feedEvent");
	}

}
