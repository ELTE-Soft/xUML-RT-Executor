package hu.eltesoft.modelexecution.m2m.logic.tests;

public class ReactivationOfListenersTests extends
		ChangeListenerM2MTranslatorIncrementalityTests {

	@Override
	protected void initialize(String path) {
		super.initialize(path);
		
		translator.inactivateListeners();
		translator.activateListeners(false);
	}
	
	// includes tests inherited from ChangeListenerM2MTranslatorIncrementalityTests
}
