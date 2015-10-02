package hu.eltesoft.modelexecution.runtime;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hu.eltesoft.modelexecution.runtime.external.ExternalEntityRegistryTests;
import hu.eltesoft.modelexecution.runtime.library.CollectionOperationsTest;
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperationsTest;
import hu.eltesoft.modelexecution.runtime.trace.TraceReplayerTest;
import hu.eltesoft.modelexecution.runtime.trace.TraceWriterTest;

@RunWith(Suite.class)
@SuiteClasses({ BaseRuntimeTest.class, TraceWriterTest.class, TraceReplayerTest.class, JSONTest.class,
		ExternalEntityRegistryTests.class, CollectionOperationsTest.class, PrimitiveOperationsTest.class })
public class AllTests {
}
