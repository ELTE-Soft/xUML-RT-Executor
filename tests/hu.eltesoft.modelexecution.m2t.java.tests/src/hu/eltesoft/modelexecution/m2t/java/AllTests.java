package hu.eltesoft.modelexecution.m2t.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hu.eltesoft.modelexecution.m2t.java.behavior.AssignmentTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.AssociationTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.AttributeTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.CollectionTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.DeclarationTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.ExtentTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.ExternalEntityTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.InvocationTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.LifecycleTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.LiteralTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.OperatorTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.StatementCompilerTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeBlockTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensonsTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeSmapTests;
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeTests;

@RunWith(Suite.class)
@SuiteClasses({ StepPartitioningTests.class, TemplateSmokeTests.class, AssignmentTests.class, AssociationTests.class,
		AttributeTests.class, CollectionTests.class, DeclarationTests.class, ExtentTests.class,
		ExternalEntityTests.class, InvocationTests.class, LifecycleTests.class, LiteralTests.class, OperatorTests.class,
		StatementCompilerTests.class, CodeGenNodeBlockTests.class, CodeGenNodeExtensonsTests.class,
		CodeGenNodeSmapTests.class, CodeGenNodeTests.class })
public class AllTests {
}
