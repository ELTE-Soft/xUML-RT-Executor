package hu.eltesoft.modelexecution.m2m.logic.tests;

import static org.junit.Assert.assertEquals;
import hu.eltesoft.modelexecution.m2m.logic.Translator;

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

	protected Translator translator;

	private void initTranslator(String path) {
		translator = Translator.createIncremental(loadResource(path));
	}

	protected void initialize(String path) {
		initTranslator(path);
		translator.fullBuild().forEach(t -> t.perform(listener));
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

		translator.incrementalBuild().forEach(t -> t.perform(listener));

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

		translator.incrementalBuild().forEach(t -> t.perform(listener));

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

		translator.incrementalBuild().forEach(t -> t.perform(listener));

		assertEquals(2, listener.deletions.size());
		assertEquals(2, listener.modifications.size());
		assertAsSets(new String[] { "RenamedRegion1", "Region1" },
				listener.deletions.get(0), listener.deletions.get(1));
		assertAsSets(new String[] { "Region1", "Class1" },
				listener.modifications.get(0), listener.modifications.get(1));
	}
}
