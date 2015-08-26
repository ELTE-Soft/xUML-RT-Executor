package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import org.junit.Before
import org.junit.Test

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
		assertCompilesTo("this.a;", "unwrap(wrap(context)).get__dxeMEEvUEeWbvJ0DeAHZOQ();")
	}

	@Test
	def testWritingBoolProperty() {
		assertCompilesTo("this.a = true;", "unwrap(wrap(context)).set__dxeMEEvUEeWbvJ0DeAHZOQ(booleanLiteral(true));")
	}
}
