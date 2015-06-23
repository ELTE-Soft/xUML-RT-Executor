package hu.eltesoft.modelexecution.m2t.java

import org.eclipse.uml2.uml.Class
import org.junit.Before
import org.junit.Test

class ExternalEntityTests extends CompiledCodeCheckTestCase {

	static val UML_TEST_MODEL_PATH = "resources/model.uml";

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
	def testCompilingExternalEntityInvocationWithoutParameter() {
		assertCompilesTo(aClass, "E::Op1();",
			'''
				«BehaviorBodyGenerator.CONTEXT_NAME».getRuntime().getExternalEntity(E.class)
					.Op1();
			''')
	}

	@Test
	def testCompilingExternalEntityInvocationWithParameter() {
		assertCompilesTo(aClass, "E::Op2(this);",
			'''
				«BehaviorBodyGenerator.CONTEXT_NAME».getRuntime().getExternalEntity(E.class)
					.Op2(new A(«BehaviorBodyGenerator.CONTEXT_NAME»));
			''')
	}
}
