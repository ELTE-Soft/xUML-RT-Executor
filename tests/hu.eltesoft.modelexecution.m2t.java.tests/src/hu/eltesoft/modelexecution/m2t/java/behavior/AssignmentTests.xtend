package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

class AssignmentTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testAssignToBoolVariable() {
		assertCompilesTo("Boolean b; b = true;", '''
			java.util.ArrayList<java.lang.Boolean> _local0 = booleanLiteral(false);
			setValue(_local0, booleanLiteral(true));
		''')
	}
}
