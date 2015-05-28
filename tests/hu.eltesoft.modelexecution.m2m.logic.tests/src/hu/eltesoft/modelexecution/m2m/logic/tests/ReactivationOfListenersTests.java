package hu.eltesoft.modelexecution.m2m.logic.tests;

public class ReactivationOfListenersTests extends
		ChangeListenerM2MTranslatorIncrementalityTests {

	@Override
	protected void initialize(String path) {
		super.initialize(path);

		translator.dispose();
		translator.toIncremental(loadResource(path));
	}

	// includes tests inherited from
	// ChangeListenerM2MTranslatorIncrementalityTests
}
