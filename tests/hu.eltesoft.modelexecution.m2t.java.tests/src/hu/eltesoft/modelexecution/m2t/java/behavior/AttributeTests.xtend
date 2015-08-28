package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import org.junit.Before
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class AttributeTests extends CompiledCodeCheckTestCase {

	static extension CodeGenNode = CodeGenNode.extension

	new() {
		compiler = new OperatorCompiler()
	}

	@Before
	override setup() {
		operation = ModelProperties.ATTR_OPERATION
	}

	@Test
	def testReadingBoolProperty() {
		assertCompilesTo('''this.a;''', CompilerBase.CONTEXT_NAME -> fun("get__dxeMEEvUEeWbvJ0DeAHZOQ"))
	}

	@Test
	def testWritingBoolProperty() {
		assertCompilesTo('''this.a = true;''',
			CompilerBase.CONTEXT_NAME -> fun("set__dxeMEEvUEeWbvJ0DeAHZOQ", booleanLiteral("true")))
	}
}
