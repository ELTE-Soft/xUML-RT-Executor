package hu.eltesoft.modelexecution.m2m.logic.tests;

import static org.junit.Assert.assertEquals;
import hu.eltesoft.modelexecution.m2m.logic.ChangeListenerM2MTranslator;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.junit.Test;

public class ChangeListenerM2MTranslatorIncrementalityTests extends
		M2MTranslatorTestsBase {

	protected ChangeListenerM2MTranslator translator;

	private void initTranslator(String path) {
		try {
			translator = ChangeListenerM2MTranslator.create(
					configureEngine(path), listener);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	protected void initialize(String path) {
		initTranslator(path);

		ChangeListenerM2MTranslator changeListenerTranslator = translator;

		changeListenerTranslator.fullBuild().performAll();
	}

	@Test
	public void testingIncrementalModification() {
		initialize(UML_TEST_SIMPLE_MODEL_PATH);

		Class a = (Class) model.getPackagedElement("A");
		StateMachine sm = (StateMachine) a.getOwnedBehavior("SM1");
		Region rg = sm.getRegion("R1");

		Pseudostate init = UMLFactory.eINSTANCE.createPseudostate();
		init.setContainer(rg);
		init.setName("init");
		init.setKind(PseudostateKind.INITIAL_LITERAL);

		State s1 = UMLFactory.eINSTANCE.createState();
		s1.setContainer(rg);
		s1.setName("S1");

		Transition t1 = UMLFactory.eINSTANCE.createTransition();
		t1.setContainer(rg);

		t1.setSource(init);
		t1.setTarget(s1);

		init.getOutgoings().add(t1);
		s1.getIncomings().add(t1);

		listener.clear();

		translator.rebuild().performAll();

		assertEquals(0, listener.deletions.size());
		assertEquals(1, listener.modifications.size());
	}

	@Test
	public void testingIncrementalDeletion() {
		initialize(UML_TEST_2015_Q1_MODEL_PATH);

		Class a = (Class) model.getPackagedElement("Class1");
		StateMachine sm = (StateMachine) a.getOwnedBehavior("StateMachine1");
		Region rg = sm.getRegion("Region1");

		rg.setName("RenamedRegion1");

		listener.clear();

		translator.rebuild().performAll();

		// nothing changes on a rename
		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());
	}

	@Test
	public void testingIncrementalDeletionUndo() {
		initialize(UML_TEST_2015_Q1_MODEL_PATH);

		Class a = (Class) model.getPackagedElement("Class1");
		StateMachine sm = (StateMachine) a.getOwnedBehavior("StateMachine1");
		Region rg = sm.getRegion("Region1");

		rg.setName("RenamedRegion1");

		rg.setName("Region1");

		listener.clear();

		translator.rebuild().performAll();

		// nothing changes on a rename
		assertEquals(0, listener.deletions.size());
		assertEquals(0, listener.modifications.size());
	}

}
