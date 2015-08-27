package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test
import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode

class ArithmeticTests extends CompiledCodeCheckTestCase {

	static extension CodeGenNode = CodeGenNode.extension

	new() {
		compiler = new ArithmeticCompiler()
	}

	@Test
	def testAddIntegers() {
		assertCompilesTo('''2 + 4;''', empty)
	}
	
	@Test
	def testAddReals() {
		assertCompilesTo('''2.0 + 4.0;''', empty)
	}
	
	@Test
	def testAddIntegerToReal() {
		assertCompilesTo('''2 + 4.0;''', empty)
	}
	
	@Test
	def testAddRealToInteger() {
		assertCompilesTo('''2.0 + 4;''', empty)
	}

	@Test
	def testConcatenateStrings() {
		assertCompilesTo('''"Hello " + "world!"''', empty)
	}
}
