package hu.eltesoft.modelexecution.uml.alf;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExternalEntityInvocationTests.class, ReceptionInvocationTests.class, StartRuleTests.class })
public class AllTests {
}
