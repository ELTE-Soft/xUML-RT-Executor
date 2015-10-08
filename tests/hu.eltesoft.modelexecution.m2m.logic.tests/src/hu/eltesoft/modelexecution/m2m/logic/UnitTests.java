package hu.eltesoft.modelexecution.m2m.logic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hu.eltesoft.modelexecution.m2m.logic.registry.ChangeRegistryTests;
import hu.eltesoft.modelexecution.m2m.logic.registry.RootNameStorageTest;

@RunWith(Suite.class)
@SuiteClasses({ BatchResourceTranslatorTests.class, IncrementalResourceTranslatorTests.class,
		UpgradedResourceTranslatorTests.class, ChangeRegistryTests.class, RootNameStorageTest.class })
public class UnitTests {
}
