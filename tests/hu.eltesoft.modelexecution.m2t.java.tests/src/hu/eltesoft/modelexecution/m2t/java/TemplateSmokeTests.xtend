package hu.eltesoft.modelexecution.m2t.java

class TemplateSmokeTests {
	// FIXME: correct the test code in this class according to changes in m2m metamodel
	/*
	@Test
	def testGenerateCodeForBehavior() {
		val factory = BehaviorFactory.eINSTANCE
		val behavior = factory.createBhBehavior
		behavior.name = "TestBehavior"
		behavior.alfResult = new AlfAnalyzer().analyze("this.TestReception();")
		behavior.containerClass = factory.createBhClass
		behavior.containerClass.name = "TestClass"
		val template = new BehaviorTemplate(behavior)

		assertProperlyGenerated(template.generate)
	}

	@Test
	def testGenerateCodeForClassWithoutStateMachine() {
		val ^class = ClassdefFactory.eINSTANCE.createClClass
		^class.name = "TestClass"
		val template = new ClassTemplate(^class)

		assertProperlyGenerated(template.generate)
	}

	@Test
	def testGenerateCodeForClassWithStateMachineAndOperations() {
		val factory = ClassdefFactory.eINSTANCE
		val ^class = factory.createClClass
		^class.name = "TestClass"
		^class.region = factory.createClRegion
		^class.region.name = "TestRegion"

		val operation = factory.createClOperation
		operation.name = "testOperation"
		operation.method = "TestBehavior"
		^class.operations.add(operation)

		val reception = factory.createClReception
		reception.name = "TestReception"
		reception.signal = factory.createClSignal
		reception.signal.name = "TestSignal"
		^class.receptions.add(reception)

		val template = new ClassTemplate(^class)

		assertProperlyGenerated(template.generate)
	}

	@Test
	def testGenerateCodeForRegion() {
		val factory = RegionFactory.eINSTANCE
		val region = factory.createRgRegion
		region.name = "TestRegion"
		region.containerClass = factory.createRgClass
		region.containerClass.name = "TestClass"

		val initState = factory.createRgInitialPseudostate
		initState.name = "InitState"
		initState.reference = new Reference(initState)
		region.initialPseudostate = initState

		val firstState = factory.createRgState
		firstState.name = "FirstState"
		firstState.reference = new Reference(firstState)
		firstState.entry = factory.createRgBehavior
		firstState.entry.name = "FirstStateEntry"
		region.states.add(firstState)

		val secondState = factory.createRgState
		secondState.name = "SecondState"
		secondState.reference = new Reference(secondState)
		secondState.exit = factory.createRgBehavior
		secondState.exit.name = "SecondStateExit"
		region.states.add(secondState)

		val initTransition = factory.createRgTransition
		initTransition.reference = new Reference(initTransition)
		initTransition.target = firstState
		initState.initialTransition = initTransition

		val initEffect = factory.createRgBehavior
		initEffect.name = "InitEffect"
		initTransition.effect = initEffect

		val firstTransition = factory.createRgTransition
		firstTransition.reference = new Reference(firstTransition)
		firstTransition.target = secondState
		firstTransition.message = factory.createRgMessage
		firstTransition.message.name = "ToSecondSignal"
		firstTransition.event = factory.createRgEvent
		firstTransition.event.name = "ToSecondSignalEvent"
		firstState.transitions.add(firstTransition)

		val secondTransition = factory.createRgTransition
		secondTransition.reference = new NamedReference(secondTransition)
		secondTransition.target = firstState
		secondTransition.message = factory.createRgMessage
		secondTransition.message.name = "ToFirstSignal"
		secondTransition.event = factory.createRgEvent
		secondTransition.event.name = "ToFirstSignalEvent"
		secondState.transitions.add(secondTransition)

		val template = new RegionTemplate(region)

		assertProperlyGenerated(template.generate)
	}

	@Test
	def testGenerateCodeForSignalEvent() {
		val factory = EventFactory.eINSTANCE
		val event = factory.createEvSignalEvent
		event.name = "TestEvent"
		event.signal = factory.createEvSignal
		event.signal.name = "TestSignal"
		val template = new SignalEventTemplate(event)

		assertProperlyGenerated(template.generate)
	}

	@Test
	def testGenerateCodeForSignal() {
		val signal = SignalFactory.eINSTANCE.createSgSignal
		signal.name = "TestSignal"
		val template = new SignalTemplate(signal)

		assertProperlyGenerated(template.generate)
	}

	private def assertProperlyGenerated(SourceMappedText result) {
		assertNotNull(result.smap)
		assertNotNull(result.text)
		assertTrue(result.text.length > 0)
	}
*/
}
