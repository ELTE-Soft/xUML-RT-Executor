package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.runtime.InstanceRegistry
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class ExtentTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testDefaultConstructor() {
		assertCompilesTo('''A::instances();''', InstanceRegistry.canonicalName -> fun("getInstanceRegistry") ->
			fun("allInstances", "_aeMPwMc1EeSnK7LttAdTLw" -> "class"))
	}
}
