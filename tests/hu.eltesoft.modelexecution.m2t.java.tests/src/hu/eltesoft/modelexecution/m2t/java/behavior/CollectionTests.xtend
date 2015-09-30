package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.runtime.InstanceRegistry
import hu.eltesoft.modelexecution.runtime.library.CollectionOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class CollectionTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	// TODO: make this independent of the testing of instances extent 
	@Test
	def testFilteringInstances() {
		val extent = InstanceRegistry.canonicalName -> fun("getInstanceRegistry") ->
			fun("allInstances", "_VsclsEvUEeWbvJ0DeAHZOQ" -> "class");

		val propertyAccess = unwrap("_local0") -> fun("get__dxeMEEvUEeWbvJ0DeAHZOQ");

		assertCompilesTo('''D::instances().filter(d : d.a);''',
			fun(CollectionOperations.FILTER, extent, "_local0" <> " -> " <> unwrap(propertyAccess)))
	}
}
