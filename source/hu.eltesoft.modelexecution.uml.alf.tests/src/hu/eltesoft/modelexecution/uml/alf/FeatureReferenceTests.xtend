package hu.eltesoft.modelexecution.uml.alf

import org.junit.Test

class FeatureReferenceTests extends CompiledCodeCheckTestCase {

	@Test
	def testCompilingThisExpressionStatement() {
		assertCompilesTo("this;", '''
		«OperationBodyCompiler.CONTEXT_NAME»;
		''')
	}

	@Test
	def testCompilingNameExpressionStatement() {
		assertCompilesTo("x;", "x;\n")
	}

	@Test
	def testCompilingFeatureCallOnExplicitThis() {
		assertCompilesTo("this.x();", '''
		«OperationBodyCompiler.CONTEXT_NAME».x();
		''')
	}

	@Test
	def testCompilingFeatureCallOnImplicitThis() {
		assertCompilesTo("x();", '''
		«OperationBodyCompiler.CONTEXT_NAME».x();
		''')
	}

	@Test
	def testCompilingMultipleStatements() {
		assertCompilesTo(" x;  y; z;  ", '''
		x;
		y;
		z;
		''')
	}
}
