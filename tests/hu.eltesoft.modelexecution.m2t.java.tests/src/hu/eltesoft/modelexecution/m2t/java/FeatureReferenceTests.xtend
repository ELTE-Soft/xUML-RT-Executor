package hu.eltesoft.modelexecution.m2t.java

import org.eclipse.uml2.uml.Class
import org.junit.Before
import org.junit.Test

class FeatureReferenceTests extends CompiledCodeCheckTestCase {

	static val UML_TEST_MODEL_PATH = "resources/model.uml";

	static val X_ID = "_WJfJQARSEeW7b7s8CAsnqQ"
	static val Y_ID = "_gh8K0ARSEeW7b7s8CAsnqQ"
	static val Z_ID = "_g54JsARSEeW7b7s8CAsnqQ"

	var Class aClass

	new() {
		super(UML_TEST_MODEL_PATH)
	}

	@Before
	override setUp() {
		super.setUp()
		aClass = namedChild(model, Class, "A")
	}

	@Test
	def testCompilingThisExpressionStatement() {
		assertCompilesTo(aClass, "this;",
			'''
				«BehaviorBodyGenerator.CONTEXT_NAME»;
			''')
	}

	@Test
	def testCompilingNameExpressionStatement() {
		assertCompilesTo(aClass, "x;",
			'''x;
				''')
	}

	@Test
	def testCompilingFeatureCallOnExplicitThis() {
		assertCompilesTo(aClass, "this.x();",
			'''
				«BehaviorBodyGenerator.CONTEXT_NAME».«X_ID»();
			''')
	}

	@Test
	def testCompilingFeatureCallOnImplicitThis() {
		assertCompilesTo(aClass, "x();",
			'''
				«BehaviorBodyGenerator.CONTEXT_NAME».«X_ID»();
			''')
	}

	@Test
	def testCompilingMultipleStatements() {
		assertCompilesTo(aClass, " this.x();  y(); z();  ",
			'''
				«BehaviorBodyGenerator.CONTEXT_NAME».«X_ID»();
				«BehaviorBodyGenerator.CONTEXT_NAME».«Y_ID»();
				«BehaviorBodyGenerator.CONTEXT_NAME».«Z_ID»();
			''')
	}
}
