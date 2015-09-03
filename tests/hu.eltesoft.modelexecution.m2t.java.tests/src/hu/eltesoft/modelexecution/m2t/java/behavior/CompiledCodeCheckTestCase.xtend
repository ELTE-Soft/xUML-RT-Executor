package hu.eltesoft.modelexecution.m2t.java.behavior

import com.google.inject.Inject
import com.incquerylabs.uml.ralf.api.IReducedAlfParser
import com.incquerylabs.uml.ralf.scoping.IUMLContextProvider
import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.runner.RunWith

import static hu.eltesoft.modelexecution.test.utils.Assert.*
import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(ReducedAlfJUnitInjector)
abstract class CompiledCodeCheckTestCase {

	protected extension CodeGenNode = CodeGenNode.EXTENSION

	@Inject
	var IReducedAlfParser parser

	@Inject
	protected var IUMLContextProvider provider

	protected var CompilerBase compiler

	@Before
	def void setup() {
		operation = ModelProperties.VOID_OPERATION
	}

	def setOperation(String fqn) {
		(provider as TestModelUMLContextProvider).definedOperation = fqn
	}

	protected def assertCompilesTo(CharSequence actionCode, CodeGenNode ... expectedNodes) {
		val results = parser.parse(actionCode.toString, provider)
		if (!results.validationOK) {
			fail(results.toString)
		}
		assertStringEqualsWithoutBreaks(topLevelBlock(expectedNodes).toString, compiler.compile(results).toString)
	}
}
