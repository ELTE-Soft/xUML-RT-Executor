package hu.eltesoft.modelexecution.runtime.test;

import hu.eltesoft.modelexecution.runtime.test.trace.InputTraceBufferTest;
import hu.eltesoft.modelexecution.runtime.test.trace.OutputTraceBufferTest;
import hu.eltesoft.modelexecution.runtime.test.trace.TraceReplayerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InputTraceBufferTest.class, OutputTraceBufferTest.class,
		TraceReplayerTest.class, BaseRuntimeTest.class })
public class AllTests {
}
