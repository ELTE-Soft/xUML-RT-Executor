package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.external.ExternalEntityRegistryTests;
import hu.eltesoft.modelexecution.runtime.trace.TraceReplayerTest;
import hu.eltesoft.modelexecution.runtime.trace.TraceWriterTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BaseRuntimeTest.class, TraceWriterTest.class,
		TraceReplayerTest.class, JSONTest.class,
		ExternalEntityRegistryTests.class })
public class AllTests {
}
