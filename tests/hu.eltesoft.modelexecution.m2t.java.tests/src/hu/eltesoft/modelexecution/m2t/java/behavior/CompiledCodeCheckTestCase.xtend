package hu.eltesoft.modelexecution.m2t.java.behavior

import com.google.inject.Inject
import com.incquerylabs.uml.ralf.api.IReducedAlfParser
import com.incquerylabs.uml.ralf.scoping.IUMLContextProvider
import com.incquerylabs.uml.ralf.tests.util.TestModelUMLContextProvider
import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(ReducedAlfJUnitInjector)
abstract class CompiledCodeCheckTestCase {

	@Inject
	var IReducedAlfParser parser

	@Inject
	protected var IUMLContextProvider provider

	protected var Compiler compiler

	@Before
	def setup() {
		operation = ModelProperties.VOID_OPERATION
	}

	def setOperation(String fqn) {
		(provider as TestModelUMLContextProvider).definedOperation = fqn
	}

	protected def assertCompilesTo(CharSequence actionCode, CharSequence expectedJavaCode) {
		val results = parser.parse(actionCode.toString, provider)
		assertTrue(results.validationOK)
		assertEquals(expectedJavaCode.toString, compiler.compile(results).toString)
	}

	protected def assertCompilesToSame(CharSequence actionCode) {
		assertCompilesTo(actionCode, actionCode)
	}
}
