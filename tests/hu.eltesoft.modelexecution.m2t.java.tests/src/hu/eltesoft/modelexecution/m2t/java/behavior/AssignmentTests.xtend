package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test
import static hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations.*

class AssignmentTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testAssignToBoolVariable() {
		assertCompilesTo('''Boolean b; b = true;''', '''
			java.util.ArrayList<java.lang.Boolean> _local0 = «BOOLEAN_LITERAL»(false);
			«SET_VALUE»(_local0, «BOOLEAN_LITERAL»(true));
		''')
	}
}
