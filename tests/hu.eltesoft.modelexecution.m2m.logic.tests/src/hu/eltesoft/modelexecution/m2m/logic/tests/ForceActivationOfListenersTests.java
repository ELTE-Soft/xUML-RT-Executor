package hu.eltesoft.modelexecution.m2m.logic.tests;

public class ForceActivationOfListenersTests extends
ChangeListenerM2MTranslatorIncrementalityTests {

	@Override
	protected void initialize(String path) {
		super.initialize(path);
		
		translator.activateListeners(true);
	}
	
	// includes tests inherited from ChangeListenerM2MTranslatorIncrementalityTests
	
}