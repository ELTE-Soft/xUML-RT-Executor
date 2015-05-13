package hu.eltesoft.modelexecution.m2t.java

import org.junit.Test

class FeatureReferenceTests extends CompiledCodeCheckTestCase {

	@Test
	def testCompilingThisExpressionStatement() {
		assertCompilesTo("this;",
			'''
				«BehaviorBodyGenerator.CONTEXT_NAME»;
			''')
	}

	@Test
	def testCompilingNameExpressionStatement() {
		assertCompilesTo("x;",
			'''x;
				''')
	}

	@Test
	def testCompilingFeatureCallOnExplicitThis() {
		assertCompilesTo("this.x();",
			'''
				«BehaviorBodyGenerator.CONTEXT_NAME».x();
			''')
	}

	@Test
	def testCompilingFeatureCallOnImplicitThis() {
		assertCompilesTo("x();",
			'''
				«BehaviorBodyGenerator.CONTEXT_NAME».x();
			''')
	}

	@Test
	def testCompilingMultipleStatements() {
		assertCompilesTo(" x;  y; z;  ",
			'''
				x;
				y;
				z;
			''')
	}
}
