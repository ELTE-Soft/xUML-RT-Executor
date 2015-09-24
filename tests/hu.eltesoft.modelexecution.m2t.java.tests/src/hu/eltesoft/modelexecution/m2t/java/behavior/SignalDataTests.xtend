package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*
import hu.eltesoft.modelexecution.m2t.java.ModelProperties

class SignalDataTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	// FIXME: I really don't know why the parser is unable to type the signal data here...
	// See tests in project ralf-feature-tests under user folder of kmate

	@Test
	def testSignalDataInStateEntry() {
		behavior = ModelProperties.STATE_ENTRY
		assertCompilesTo('''sigdata.aString;''', empty())
	}

	@Test
	def testSignalDataInStateExit() {
		behavior = ModelProperties.STATE_EXIT
		assertCompilesTo('''sigdata.aBool;''', empty())
	}

	@Test
	def testSignalDataInTransitionEffect() {
		behavior = ModelProperties.TRANSITION_EFFECT
		assertCompilesTo('''sigdata.aBool;''', empty())
	}
}
