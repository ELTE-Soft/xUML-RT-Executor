package hu.eltesoft.modelexecution.m2t.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hu.eltesoft.modelexecution.m2t.java.behavior.AssignmentTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.AttributeTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.DeclarationTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.ExternalEntityTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.InvocationTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.LifecycleTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.LiteralTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.StatementCompilerTests;

@RunWith(Suite.class)
@SuiteClasses({ StepPartitioningTests.class, TemplateSmokeTests.class, AssignmentTests.class, AttributeTests.class,
		DeclarationTests.class, ExternalEntityTests.class, InvocationTests.class, LifecycleTests.class,
		LiteralTests.class, StatementCompilerTests.class })
public class AllTests {
}
