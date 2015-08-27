package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class AssignmentTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testAssignToBoolVariable() {
		assertCompilesTo(
			'''Boolean b; b = true;''',
			binOp("java.util.ArrayList<java.lang.Boolean> _local0", "=", booleanLiteral("false")),
			fun(PrimitiveOperations.SET_VALUE, "_local0", booleanLiteral("true"))
		)
	}
}
