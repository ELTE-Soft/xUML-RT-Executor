package hu.eltesoft.modelexecution.m2m.logic.tests;

import static hu.eltesoft.modelexecution.m2m.logic.tests.Assert.assertAsSets;
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

public class ChangeListenerM2MTranslatorTests extends SimpleM2MTranslatorTests {

	@Override
	protected void initTranslator(String path) {
		try {
			translator = ChangeListenerM2MTranslator.create(
					configureEngine(path), listener);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testingFullBuildOnSimpleModelRepeteadly() {
		initTranslator(UML_TEST_SIMPLE_MODEL_PATH);

		for (int i = 0; i < 3; ++i) {
			listener.clear();
			translator.fullBuild().performAll();
		}

		checkSimpleModelResult();

	}

	@Test
	public void testingRebuildAsFirstBuild() {
		initTranslator(UML_TEST_SIMPLE_MODEL_PATH);

		ChangeListenerM2MTranslator changeListenerTranslator = (ChangeListenerM2MTranslator) translator;

		listener.clear();
		changeListenerTranslator.rebuild().performAll();

		checkSimpleModelResult();

	}

	@Test
	public void testingIncrementalModification() {
		initTranslator(UML_TEST_SIMPLE_MODEL_PATH);

		ChangeListenerM2MTranslator changeListenerTranslator = (ChangeListenerM2MTranslator) translator;

		changeListenerTranslator.fullBuild().performAll();

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

		changeListenerTranslator.rebuild().performAll();

		assertEquals(0, listener.deletions.size());
		assertEquals(1, listener.modifications.size());
	}

	@Test
	public void testingIncrementalDeletion() {
		initTranslator(UML_TEST_2015_Q1_MODEL_PATH);

		ChangeListenerM2MTranslator changeListenerTranslator = (ChangeListenerM2MTranslator) translator;

		changeListenerTranslator.fullBuild().performAll();

		Class a = (Class) model.getPackagedElement("Class1");
		StateMachine sm = (StateMachine) a.getOwnedBehavior("StateMachine1");
		Region rg = sm.getRegion("Region1");

		rg.setName("RenamedRegion1");

		listener.clear();

		changeListenerTranslator.rebuild().performAll();

		assertEquals(1, listener.deletions.size());
		assertEquals(2, listener.modifications.size());
		assertEquals("Region1", listener.deletions.get(0));
		assertAsSets(new String[] { "RenamedRegion1", "Class1" },
				listener.modifications.get(0), listener.modifications.get(1));

	}

	@Test
	public void testingIncrementalDeletionUndo() {
		initTranslator(UML_TEST_2015_Q1_MODEL_PATH);

		ChangeListenerM2MTranslator changeListenerTranslator = (ChangeListenerM2MTranslator) translator;

		changeListenerTranslator.fullBuild().performAll();

		Class a = (Class) model.getPackagedElement("Class1");
		StateMachine sm = (StateMachine) a.getOwnedBehavior("StateMachine1");
		Region rg = sm.getRegion("Region1");

		rg.setName("RenamedRegion1");

		rg.setName("Region1");

		listener.clear();

		changeListenerTranslator.rebuild().performAll();

		assertEquals(2, listener.deletions.size());
		assertEquals(2, listener.modifications.size());
		assertAsSets(new String[] { "RenamedRegion1", "Region1" },
				listener.deletions.get(0), listener.deletions.get(1));
		assertAsSets(new String[] { "Region1", "Class1" },
				listener.modifications.get(0), listener.modifications.get(1));

	}

}
