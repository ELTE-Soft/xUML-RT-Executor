package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegionMatcher
import hu.eltesoft.modelexecution.uml.incquery.EntryMatcher
import hu.eltesoft.modelexecution.uml.incquery.ExitMatcher
import hu.eltesoft.modelexecution.uml.incquery.FinalStateMatcher
import hu.eltesoft.modelexecution.uml.incquery.InitialsMatcher
import hu.eltesoft.modelexecution.uml.incquery.RegionMatch
import hu.eltesoft.modelexecution.uml.incquery.RegionMatcher
import hu.eltesoft.modelexecution.uml.incquery.StateMatcher
import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatcher
import hu.eltesoft.modelexecution.uml.incquery.TransitionMatcher
import java.util.HashMap
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Region
import org.eclipse.uml2.uml.State

class RegionTranslator extends RootElementTranslator<Region, RgRegion, RegionMatch> {

	static val FACTORY = RegionFactory.eINSTANCE
	static val PACKAGE = RegionPackage.eINSTANCE

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine)
	}

	override buildMapper(IncQueryEngine engine) {
		val rootNode = fromRoot(RegionMatcher.on(engine)) [
			val root = FACTORY.createRgRegion
			root.reference = new NamedReference(region)
			return root
		]
		rootNode.on(PACKAGE.rgRegion_ContainerClass, ContainerClassOfRegionMatcher.on(engine)) [
			new NamedReference(containerClass)
		]

		val stateMap = new HashMap<State, RgState>()

		val stateNode = rootNode.onEObject(PACKAGE.rgRegion_States, StateMatcher.on(engine)) [
			val newState = FACTORY.createRgState
			newState.reference = new NamedReference(state);
			stateMap.put(state, newState);
			return newState;
		]
		stateNode.on(PACKAGE.rgState_Entry, EntryMatcher.on(engine))[new NamedReference(entry)]
		stateNode.on(PACKAGE.rgState_Exit, ExitMatcher.on(engine))[new NamedReference(exit)]
		stateNode.on(PACKAGE.rgState_IsFinal, FinalStateMatcher.on(engine)) [
			true
		]

		// it must be done after state map is populated
		val transitionNode = stateNode.onEObject(PACKAGE.rgState_Transitions, TransitionMatcher.on(engine)) [
			val rgTransition = FACTORY.createRgTransition()
			rgTransition.reference = new Reference(transition)
			rgTransition.message = new NamedReference(signal)
			rgTransition.event = new NamedReference(event)
			rgTransition.target = stateMap.get(target)
			return rgTransition
		]
		transitionNode.on(PACKAGE.rgTransition_Effect, TransitionEffectMatcher.on(engine)) [
			new NamedReference(effect)
		]

		// it must be done after state map is populated
		rootNode.onEObject(PACKAGE.rgRegion_InitialPseudostate, InitialsMatcher.on(engine)) [
			val rgInitialPseudostate = FACTORY.createRgInitialPseudostate
			rgInitialPseudostate.reference = new NamedReference(initPseudostate)
			val rgTransition = FACTORY.createRgTransition
			rgTransition.reference = new Reference(initTransition)
			rgTransition.target = stateMap.get(firstState)
			rgInitialPseudostate.initialTransition = rgTransition
			return rgInitialPseudostate
		]

		return rootNode
	}

	override createTemplate(RgRegion region) {
		return new RegionTemplate(region)
	}
}
