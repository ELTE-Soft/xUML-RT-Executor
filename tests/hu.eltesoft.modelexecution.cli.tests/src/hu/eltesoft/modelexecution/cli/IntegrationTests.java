package hu.eltesoft.modelexecution.cli;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExampleModelTests.class, HelpTest.class, InvalidArgumentTests.class, SystemModelTests.class })
public class IntegrationTests {
}
