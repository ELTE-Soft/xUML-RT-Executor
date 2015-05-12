package hu.eltesoft.modelexecution.runtime.tests.trace;

import static org.junit.Assert.*;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.tests.mocks.DifferentDummyEvent;
import hu.eltesoft.modelexecution.runtime.tests.mocks.DummySignal;
import hu.eltesoft.modelexecution.runtime.tests.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.IInputTraceBuffer;
import hu.eltesoft.modelexecution.runtime.trace.TargetedMessage;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader.EventSource;
import hu.eltesoft.modelexecution.runtime.trace.TraceReplayer;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class TraceReplayerTest {

	Mockery context;
	private Logger mockLogger;
	private IInputTraceBuffer inputBufferMock;

	@Before
	public void setup() {
		context = new Mockery();
		mockLogger = context.mock(Logger.class);
		inputBufferMock = context.mock(IInputTraceBuffer.class);
	}

	@Test
	public void testDispatchEvent() throws Exception {
		TraceReplayer sut = new TraceReplayer(inputBufferMock);
		MockClass classInstance = MockClass.getInstance();
		DummySignal eventInstance = new DummySignal();
		TargetedMessage te = new TargetedMessage(classInstance, eventInstance);

		context.checking(new Expectations() {
			{
				oneOf(inputBufferMock).hasMoreElems();
				will(returnValue(true));
				oneOf(inputBufferMock).getTracedEvent();
				will(returnValue(te));
				oneOf(mockLogger).messageDispatched(classInstance, eventInstance);
			}
		});

		sut.dispatchEvent(mockLogger);

		context.checking(new Expectations() {
			{
				oneOf(inputBufferMock).close();
			}
		});

		sut.close();
	}

	@Test
	public void testDispatchEvent_withTargetedEventNoExternals()
			throws Exception {
		TraceReplayer sut = new TraceReplayer(inputBufferMock);
		MockClass classInstance = MockClass.getInstance();
		DummySignal eventInstance = new DummySignal();
		TargetedMessage te = new TargetedMessage(classInstance, eventInstance);

		context.checking(new Expectations() {
			{
				oneOf(inputBufferMock).hasMoreElems();
				will(returnValue(false));
				oneOf(mockLogger).messageDispatched(classInstance, eventInstance);
				oneOf(inputBufferMock).close();
			}
		});

		EventSource eventSource = sut.dispatchEvent(te, mockLogger);
		assertEquals(EventSource.Queue, eventSource);
		sut.close();
	}

	@Test
	public void testDispatchEvent_withTargetedEventAndDeserializedInternal()
			throws Exception {
		TraceReplayer sut = new TraceReplayer(inputBufferMock);
		MockClass classInstance = MockClass.getInstance();
		DummySignal eventInstance1 = new DummySignal();
		DummySignal eventInstance2 = new DummySignal();
		TargetedMessage te = new TargetedMessage(classInstance, eventInstance1);
		TargetedMessage te2 = new TargetedMessage(classInstance, eventInstance2);

		context.checking(new Expectations() {
			{
				oneOf(inputBufferMock).hasMoreElems();
				will(returnValue(true));
				oneOf(inputBufferMock).getTracedEvent();
				will(returnValue(te2));
				oneOf(mockLogger)
						.messageDispatched(classInstance, eventInstance2);
				oneOf(inputBufferMock).close();
			}
		});

		EventSource eventSource1 = sut.dispatchEvent(te, mockLogger);
		assertEquals(EventSource.Queue, eventSource1);

		sut.close();
	}

	@Test
	public void testDispatchEvent_withTargetedEventAndDeserializedExternal()
			throws Exception {
		TraceReplayer sut = new TraceReplayer(inputBufferMock);
		MockClass classInstance = MockClass.getInstance();
		DummySignal eventInstance1 = new DummySignal();
		DummySignal eventInstance2 = new DummySignal();
		TargetedMessage te = new TargetedMessage(classInstance, eventInstance1);
		TargetedMessage te2 = TargetedMessage.createOutsideEvent(classInstance,
				eventInstance2);

		context.checking(new Expectations() {
			{
				oneOf(inputBufferMock).hasMoreElems();
				will(returnValue(true));
				oneOf(inputBufferMock).getTracedEvent();
				will(returnValue(te2));
				oneOf(inputBufferMock).hasMoreElems();
				will(returnValue(false));
				oneOf(mockLogger)
						.messageDispatched(classInstance, eventInstance2);
				oneOf(mockLogger)
						.messageDispatched(classInstance, eventInstance1);
				oneOf(inputBufferMock).close();
			}
		});

		EventSource eventSource1 = sut.dispatchEvent(te, mockLogger);
		assertEquals(EventSource.Trace, eventSource1);
		EventSource eventSource2 = sut.dispatchEvent(te, mockLogger);
		assertEquals(EventSource.Queue, eventSource2);

		sut.close();
	}

	@Test
	public void testDispatchEvent_withTargetedEventAndDifferentDeserializedInternal()
			throws Exception {
		TraceReplayer sut = new TraceReplayer(inputBufferMock);
		MockClass classInstance = MockClass.getInstance();
		DummySignal eventInstance1 = new DifferentDummyEvent(1);
		DummySignal eventInstance2 = new DifferentDummyEvent(2);
		TargetedMessage te1 = new TargetedMessage(classInstance, eventInstance1);
		TargetedMessage te2 = new TargetedMessage(classInstance, eventInstance2);

		context.checking(new Expectations() {
			{
				oneOf(inputBufferMock).hasMoreElems();
				will(returnValue(true));
				oneOf(inputBufferMock).getTracedEvent();
				will(returnValue(te2));
				oneOf(mockLogger)
						.messageDispatched(classInstance, eventInstance2);
				oneOf(inputBufferMock).close();
			}
		});

		try {
			sut.dispatchEvent(te1, mockLogger);
			throw new AssertionError(
					"No exception thrown for dispatch without trace.");
		} catch (RuntimeException e) {
			// expected behavior
		} finally {
			sut.close();
		}
	}

	@Test
	public void testDispatchEvent_withoutEventNoTrace() throws Exception {
		TraceReplayer sut = new TraceReplayer(inputBufferMock);

		context.checking(new Expectations() {
			{
				oneOf(inputBufferMock).hasMoreElems();
				will(returnValue(false));
				oneOf(inputBufferMock).close();
			}
		});

		try {
			sut.dispatchEvent(mockLogger);
			throw new AssertionError(
					"No exception thrown for dispatch without trace.");
		} catch (RuntimeException e) {
			// expected behavior
		} finally {
			sut.close();
		}
	}

}
