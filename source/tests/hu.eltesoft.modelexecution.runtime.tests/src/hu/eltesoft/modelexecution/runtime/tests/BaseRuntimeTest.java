package hu.eltesoft.modelexecution.runtime.tests;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.tests.mocks.DummySignal;
import hu.eltesoft.modelexecution.runtime.tests.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.TargetedMessage;
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

		BaseRuntime sut = new BaseRuntime(getClass().getClassLoader());
		sut.setLogger(loggerMock);
		sut.setTraceWriter(tracerMock);
		sut.setTraceReader(readerMock);

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
		sut.close();
	}

	@Test
	public void testRun_eventFeeded() throws Exception {

		Logger loggerMock = context.mock(Logger.class);
		Tracer tracerMock = context.mock(Tracer.class);
		TraceReader readerMock = context.mock(TraceReader.class);

		BaseRuntime sut = new BaseRuntime(getClass().getClassLoader());
		sut.setLogger(loggerMock);
		sut.setTraceWriter(tracerMock);
		sut.setTraceReader(readerMock);

		context.checking(new Expectations() {
			{
				allowing(readerMock).hasEvent();
				will(returnValue(false));
				DummySignal event = new DummySignal();
				oneOf(loggerMock).messageQueued(with(any(MockClass.class)), with(equal(event)));
				oneOf(readerMock).dispatchEvent(with(any(TargetedMessage.class)), with(same(loggerMock)));
				will(returnValue(EventSource.Queue));
				oneOf(tracerMock).traceEvent(with(any(TargetedMessage.class)));
				oneOf(tracerMock).close();
				oneOf(readerMock).close();
				oneOf(loggerMock).close();
			}
		});

		sut.run(MockClass.class.getCanonicalName(), "feedEvent");
		sut.close();
	}

}
