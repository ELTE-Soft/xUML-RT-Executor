package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import org.junit.Before
import org.junit.Test
import static hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations.*

class AttributeTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Before
	override setup() {
		operation = ModelProperties.ATTR_OPERATION
	}

	@Test
	def testReadingBoolProperty() {
		assertCompilesTo('''this.a;''', '''«UNWRAP»(«WRAP»(«CompilerBase.CONTEXT_NAME»)).get__dxeMEEvUEeWbvJ0DeAHZOQ();''')
	}

	@Test
	def testWritingBoolProperty() {
		assertCompilesTo('''this.a = true;''', '''«UNWRAP»(«WRAP»(«CompilerBase.CONTEXT_NAME»)).set__dxeMEEvUEeWbvJ0DeAHZOQ(«BOOLEAN_LITERAL»(true));''')
	}
}
