package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplate
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplate
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzer
import org.eclipse.uml2.uml.Class
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

class TemplateSmokeTests extends ModelBasedTestCase {

	static val UML_TEST_MODEL_PATH = "resources/model.uml";

	var Class aClass

	new() {
		super(UML_TEST_MODEL_PATH)
	}

	@Before
	override setUp() {
		super.setUp()
		aClass = namedChild(model, Class, "A")
	}

	def makeNewReference(String name) {
		return new FakeNamedReference(name)
	}

	@Test
	def testGenerateCodeForBehavior() {
		val factory = BehaviorFactory.eINSTANCE
		val behavior = factory.createBhBehavior
		behavior.reference = makeNewReference("TestBehavior")
		behavior.alfResult = new AlfAnalyzer().analyze("this.x();", aClass)
		behavior.containerClass = makeNewReference("TestClass")
		val template = new BehaviorTemplate(behavior)

		assertProperlyGenerated(template.generate)
	}

	@Test
	def testGenerateCodeForClassWithoutStateMachine() {
		val ^class = ClassdefFactory.eINSTANCE.createClClass
		^class.reference = makeNewReference("TestClass")
		val template = new ClassTemplate(^class)

		assertProperlyGenerated(template.generate)
	}

	@Test
	def testGenerateCodeForClassWithStateMachineAndOperations() {
		val factory = ClassdefFactory.eINSTANCE
		val ^class = factory.createClClass
		^class.reference = makeNewReference("TestClass")
		^class.region = makeNewReference("TestRegion")

		val operation = factory.createClOperation
		operation.reference = makeNewReference("testOperation")
		operation.method = makeNewReference("TestBehavior")
		^class.operations.add(operation)

		val reception = factory.createClReception
		reception.reference = makeNewReference("TestReception")
		reception.signal = makeNewReference("TestSignal")
		^class.receptions.add(reception)

		val template = new ClassTemplate(^class)

		assertProperlyGenerated(template.generate)
	}

	@Test
	def testGenerateCodeForRegion() {
		val factory = RegionFactory.eINSTANCE
		val region = factory.createRgRegion
		region.reference = makeNewReference("TestRegion")
		region.containerClass = makeNewReference("TestClass")

		val initState = factory.createRgInitialPseudostate
		initState.reference = makeNewReference("InitState")
		region.initialPseudostate = initState

		val firstState = factory.createRgState
		firstState.reference = makeNewReference("FirstState")
		firstState.entry = makeNewReference("FirstStateEntry")
		region.states.add(firstState)

		val secondState = factory.createRgState
		secondState.reference = makeNewReference("SecondState")
		secondState.exit = makeNewReference("SecondStateExit")
		region.states.add(secondState)

		val initTransition = factory.createRgTransition
		initTransition.reference = new Reference(initTransition)
		initTransition.target = firstState
		initTransition.effect = makeNewReference("InitEffect")
		initState.initialTransition = initTransition

		val firstTransition = factory.createRgTransition
		firstTransition.reference = new Reference(firstTransition)
		firstTransition.target = secondState
		firstTransition.message = makeNewReference("ToSecondSignal")
		firstTransition.event = makeNewReference("ToSecondSignalEvent")
		firstState.transitions.add(firstTransition)

		val secondTransition = factory.createRgTransition
		secondTransition.reference = new Reference(secondTransition)
		secondTransition.target = firstState
		secondTransition.message = makeNewReference("ToFirstSignal")
		secondTransition.event = makeNewReference("ToFirstSignalEvent")
		secondState.transitions.add(secondTransition)

		val template = new RegionTemplate(region)

		assertProperlyGenerated(template.generate)
	}

	@Test
	def testGenerateCodeForSignal() {
		val signal = SignalFactory.eINSTANCE.createSgSignal
		signal.reference = makeNewReference("TestSignal")
		val template = new SignalTemplate(signal)

		assertProperlyGenerated(template.generate)
	}

	private def assertProperlyGenerated(SourceMappedText result) {
		assertNotNull(result.smap)
		assertNotNull(result.text)
		assertTrue(result.text.length > 0)
	}

}
