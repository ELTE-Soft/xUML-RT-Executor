package hu.eltesoft.modelexecution.m2t.java

import com.incquerylabs.uml.ralf.ReducedAlfSystem
import com.incquerylabs.uml.ralf.api.impl.ParsingResults
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguageFactory
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplateSmap
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplateSmap
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplateSmap
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplateSmap
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase
import org.eclipse.uml2.uml.Class
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

class TemplateSmokeTests extends ModelBasedTestCase {

	var Class aClass

	new() {
		super(ModelProperties.PATH, true)
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
		behavior.parsingResults = new ParsingResults(null, null, null) {

			override boolean validationOK() {
				true
			}

			override Statements getModel() {
				val factory = ReducedAlfLanguageFactory.eINSTANCE
				factory.createStatements
			}

			override ReducedAlfSystem getTypeSystem() {
				null
			}
		};
		behavior.containerClass = makeNewReference("TestClass")
		val template = new BehaviorTemplateSmap(behavior)

		assertProperlyGenerated(template.generate as SourceMappedText)
	}

	@Test
	def testGenerateCodeForClassWithoutStateMachine() {
		val ^class = ClassdefFactory.eINSTANCE.createClClass
		^class.reference = makeNewReference("TestClass")
		val template = new ClassTemplateSmap(^class)

		assertProperlyGenerated(template.generate as SourceMappedText)
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

		val template = new ClassTemplateSmap(^class)

		assertProperlyGenerated(template.generate as SourceMappedText)
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

		val template = new RegionTemplateSmap(region)

		assertProperlyGenerated(template.generate as SourceMappedText)
	}

	@Test
	def testGenerateCodeForSignal() {
		val signal = SignalFactory.eINSTANCE.createSgSignal
		signal.reference = makeNewReference("TestSignal")
		val template = new SignalTemplateSmap(signal)

		assertProperlyGenerated(template.generate as SourceMappedText)
	}

	private def assertProperlyGenerated(SourceMappedText result) {
		assertNotNull(result.smap)
		assertNotNull(result.text)
		assertTrue(result.text.length > 0)
	}

}
