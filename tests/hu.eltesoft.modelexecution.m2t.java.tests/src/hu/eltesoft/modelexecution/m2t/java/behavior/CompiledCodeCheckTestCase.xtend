package hu.eltesoft.modelexecution.m2t.java.behavior

import com.google.inject.Inject
import com.incquerylabs.uml.ralf.api.IReducedAlfParser
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(ReducedAlfJUnitInjector)
abstract class CompiledCodeCheckTestCase {

	val UML_TEST_MODEL_PATH = "resources/model.uml"
	val UML_TEST_OPERATION_QNAME = "model::B::Op"

	@Inject
	var IReducedAlfParser parser

	val ModelBasedContextProvider provider = new ModelBasedContextProvider(UML_TEST_MODEL_PATH)

	protected var Compiler compiler

	protected def assertCompilesTo(CharSequence actionCode, CharSequence expectedJavaCode) {
		provider.definedOperation = UML_TEST_OPERATION_QNAME
		val results = parser.parse(actionCode.toString, provider)
		assertTrue(results.validationOK)
		assertEquals(expectedJavaCode.toString, compiler.compile(results).toString)
	}

	protected def assertCompilesToSame(CharSequence actionCode) {
		assertCompilesTo(actionCode, actionCode)
	}
}
