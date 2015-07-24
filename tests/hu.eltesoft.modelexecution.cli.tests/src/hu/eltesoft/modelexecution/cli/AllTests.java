package hu.eltesoft.modelexecution.cli;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArgumentsTests.class, ResourceBundleTests.class })
public class AllTests {
}