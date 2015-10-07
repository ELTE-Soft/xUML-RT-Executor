package hu.eltesoft.modelexecution.cli;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExampleTests.class, HelpTest.class, InvalidArgumentsExceptionsTests.class, InvalidArgumentTests.class,
		ResourceBundleTests.class, SystemTests.class })
public class AllTests {
}