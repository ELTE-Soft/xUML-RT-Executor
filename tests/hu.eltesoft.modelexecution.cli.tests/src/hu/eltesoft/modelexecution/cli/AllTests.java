package hu.eltesoft.modelexecution.cli;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HelpTest.class, InvalidArgumentsExceptionsTests.class, InvalidArgumentTests.class,
		ResourceBundleTests.class, ValidArgumentTests.class })
public class AllTests {
}