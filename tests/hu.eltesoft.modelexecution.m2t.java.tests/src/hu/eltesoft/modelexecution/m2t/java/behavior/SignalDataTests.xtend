package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class SignalDataTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testSignalDataInStateEntry() {
		behavior = ModelProperties.STATE_ENTRY
		assertCompilesTo('''sigdata.aString;''',
			unwrap(
				fun(PrimitiveOperations.CAST, "_MR4rMEHNEeWzwYgcaM4qwA" -> "class", wrap(CompilerBase.SIGDATA_NAME))) ->
				fun("get__R$jTEEHNEeWzwYgcaM4qwA"))
	}

	@Test
	def testSignalDataInStateExit() {
		behavior = ModelProperties.STATE_EXIT
		assertCompilesTo('''sigdata.aBool;''',
			unwrap(
				fun(PrimitiveOperations.CAST, "_MR4rMEHNEeWzwYgcaM4qwA" -> "class", wrap(CompilerBase.SIGDATA_NAME))) ->
				fun("get__On_m8EHNEeWzwYgcaM4qwA"))
	}

	@Test
	def testSignalDataInTransitionEffect() {
		behavior = ModelProperties.TRANSITION_EFFECT
		assertCompilesTo('''sigdata.aBool;''',
			unwrap(
				fun(PrimitiveOperations.CAST, "_MR4rMEHNEeWzwYgcaM4qwA" -> "class", wrap(CompilerBase.SIGDATA_NAME))) ->
				fun("get__On_m8EHNEeWzwYgcaM4qwA"))
	}
}
