package hu.eltesoft.modelexecution.examples;

/**
 * An action that immediately pops up the {@linkplain ExampleModelWizard}
 */
public class StateMachineExampleAction extends WizardOpenAction {

	@Override
	public void run() {
		openWizard(StateMachineExampleWizard.WIZARD_ID);
	}

}
