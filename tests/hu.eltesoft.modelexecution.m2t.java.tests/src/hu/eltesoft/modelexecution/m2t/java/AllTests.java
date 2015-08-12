package hu.eltesoft.modelexecution.m2t.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExternalEntityTests.class, StepPartitioningTests.class,
		TemplateSmokeTests.class })
public class AllTests {
}
