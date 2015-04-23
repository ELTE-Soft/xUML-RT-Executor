package hu.eltesoft.modelexecution.m2m.logic.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SimpleM2MTranslatorTests.class,
		ChangeListenerM2MTranslatorFullBuildTests.class,
		ChangeListenerM2MTranslatorIncrementalityTests.class,
		ForceActivationOfListenersTests.class,
		ReactivationOfListenersTests.class })
public class AllTests {
}
