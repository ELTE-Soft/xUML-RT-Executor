package hu.eltesoft.modelexecution.runtime.tests;

import hu.eltesoft.modelexecution.runtime.tests.trace.TraceReplayerTest;
import hu.eltesoft.modelexecution.runtime.tests.trace.TraceWriterTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BaseRuntimeTest.class, TraceWriterTest.class,
		TraceReplayerTest.class })
public class AllTests {
}
