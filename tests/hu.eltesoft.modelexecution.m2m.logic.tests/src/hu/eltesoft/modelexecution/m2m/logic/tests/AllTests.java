package hu.eltesoft.modelexecution.m2m.logic.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BatchTranslatorTests.class, IncrementalTranslatorTests.class,
		UpgradedTranslatorTests.class })
public class AllTests {
}
