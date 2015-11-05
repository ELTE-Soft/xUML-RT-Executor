package hu.eltesoft.modelexecution.cli;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hu.eltesoft.modelexecution.ide.common.ProjectProperties;
import hu.eltesoft.modelexecution.ide.common.ProjectProperties.ValidationLevels;

@RunWith(Suite.class)
@SuiteClasses({ ExampleModelTests.class, HelpTest.class, InvalidArgumentTests.class, SystemModelTests.class })
public class IntegrationTests {
	
	public IntegrationTests() {
		// do not stop on model validation errors
		ProjectProperties.DEFAULT_VALIDATION_LEVEL = ValidationLevels.NEVER_STOP;
	}
}
