package hu.eltesoft.modelexecution.m2m.logic.translators

import com.google.inject.Guice
import com.incquerylabs.uml.ralf.ReducedAlfLanguageRuntimeModule
import com.incquerylabs.uml.ralf.api.IReducedAlfParser
import com.incquerylabs.uml.ralf.api.impl.ReducedAlfParser
import com.incquerylabs.uml.ralf.scoping.IUMLContextProvider
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior
import hu.eltesoft.modelexecution.m2t.java.BehaviorUMLContextProvider
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplateSmap
import hu.eltesoft.modelexecution.uml.incquery.ActionCodeMatcher
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatch
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatcher
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher
import hu.eltesoft.modelexecution.uml.incquery.StaticBehaviorMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Behavior
import org.eclipse.uml2.uml.OpaqueBehavior

class BehaviorTranslator extends RootElementTranslator<Behavior, BhBehavior, BehaviorMatch> {

	static val FACTORY = BehaviorFactory.eINSTANCE
	static val PACKAGE = BehaviorPackage.eINSTANCE

	var OpaqueBehavior currentBehavior

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine);
	}

	override createMapper(IncQueryEngine engine) {
		val rootNode = fromRoot(BehaviorMatcher.on(engine)) [
			currentBehavior = behavior as OpaqueBehavior
			val root = FACTORY.createBhBehavior
			root.reference = new NamedReference(behavior)
			root.parsingResults = parse("", currentBehavior)
			return root;
		]
		return rootNode;
	}

	override initMapper(RootNode<?, ?, ?> rootNode, IncQueryEngine engine) {
		rootNode.on(PACKAGE.bhBehavior_IsStatic, StaticBehaviorMatcher.on(engine))[isStatic]

		val parameterNode = rootNode.onEObject(PACKAGE.bhBehavior_Parameters, BehaviorParameterMatcher.on(engine)) [
			val bhParameter = BASE_FACTORY.createParameter
			bhParameter.reference = new NamedReference(parameter)
			bhParameter.direction = direction.convert
			return bhParameter;
		]
		val parameterType = parameterNode.onEObject(BASE_PACKAGE.typed_Type, BehaviorParameterTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createType
			elem.baseType = type.convert
			elem.isOrdered = ordered
			elem.isUnique = unique
			return elem
		]
		parameterType.on(BASE_PACKAGE.multiplicity_LowerBound, BehaviorParameterLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		parameterType.on(BASE_PACKAGE.multiplicity_UpperBound, BehaviorParameterUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]

		val returnNode = rootNode.onEObject(PACKAGE.bhBehavior_ReturnType, BehaviorReturnTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createType
			elem.baseType = type.convert
			elem.isOrdered = ordered
			elem.isUnique = unique
			return elem
		]
		returnNode.on(
			BASE_PACKAGE.multiplicity_LowerBound,
			BehaviorReturnLowerBoundMatcher.on(engine)
		) [
			lowerBound.toInt
		]
		returnNode.on(BASE_PACKAGE.multiplicity_UpperBound, BehaviorReturnUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]

		rootNode.on(PACKAGE.bhBehavior_ParsingResults, ActionCodeMatcher.on(engine)) [
			parse(actionCode, currentBehavior)
		]

		rootNode.on(PACKAGE.bhBehavior_ContainerClass, ContainerClassOfBehaviorMatcher.on(engine)) [
			new NamedReference(containerClass)
		]
	}

	override Template createTemplate(BhBehavior behavior) {
		return new BehaviorTemplateSmap(behavior)
	}

	private def parse(String code, OpaqueBehavior behavior) {
		val provider = getProvider(behavior)
		val parser = getParser(provider)
		parser.parse(code, provider)
	}

	private def getProvider(OpaqueBehavior behavior) {
		new BehaviorUMLContextProvider(behavior)
	}

	private def getParser(IUMLContextProvider provider) {
		Guice.createInjector(new ReducedAlfLanguageRuntimeModule()) [
			bind(IUMLContextProvider).toInstance(provider)
			bind(IReducedAlfParser).toInstance(new ReducedAlfParser())
		].getInstance(IReducedAlfParser)
	}
}
