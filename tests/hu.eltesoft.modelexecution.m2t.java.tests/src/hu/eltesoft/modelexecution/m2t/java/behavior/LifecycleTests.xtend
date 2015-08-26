package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test
import static hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations.*

class LifecycleTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testDefaultConstructor() {
		assertCompilesTo('''new A();''', '''«WRAP»(_aeMPwMc1EeSnK7LttAdTLw.create(«CompilerBase.CONTEXT_NAME».getRuntime(), null));''')
	}

	@Test
	def testCustomConstructorNoParams() {
		assertCompilesTo('''new B();''', '''«WRAP»(_9SdsIEDoEeWCNoKXHvCpUQ.create(«CompilerBase.CONTEXT_NAME».getRuntime(), i -> i._LAXgUEHKEeWzwYgcaM4qwA()));''')
	}

	@Test
	def testCustomConstructorInParams() {
		assertCompilesTo('''new C(pInString => "world", pInBool => false);''', '''«WRAP»(_5FoZEEHJEeWzwYgcaM4qwA.create(«CompilerBase.CONTEXT_NAME».getRuntime(), i -> i._7BAgoEHJEeWzwYgcaM4qwA(«BOOLEAN_LITERAL»(false), «STRING_LITERAL»("world"))));''')
		assertCompilesTo('''new C(pInBool => false, pInString => "world");''', '''«WRAP»(_5FoZEEHJEeWzwYgcaM4qwA.create(«CompilerBase.CONTEXT_NAME».getRuntime(), i -> i._7BAgoEHJEeWzwYgcaM4qwA(«BOOLEAN_LITERAL»(false), «STRING_LITERAL»("world"))));''')
	}

	@Test
	def testSignalConstructorNoParams() {
		assertCompilesTo('''new S();''', '''«WRAP»(new _47IQsEGyEeWzwYgcaM4qwA());''')
	}

	@Test
	def testSignalConstructorPropertyParams() {
		assertCompilesTo('''new SParams(aBool => true, aString => "hello");''', '''«WRAP»(new _MR4rMEHNEeWzwYgcaM4qwA(«BOOLEAN_LITERAL»(true), «STRING_LITERAL»("hello")));''')
		assertCompilesTo('''new SParams(aString => "hello", aBool => true);''', '''«WRAP»(new _MR4rMEHNEeWzwYgcaM4qwA(«BOOLEAN_LITERAL»(true), «STRING_LITERAL»("hello")));''')
	}

	@Test
	def testDeleteExpression() {
		assertCompilesTo(
			"A a = new A(); delete a;", '''
				java.util.ArrayList<_aeMPwMc1EeSnK7LttAdTLw> _local0 = «WRAP»(_aeMPwMc1EeSnK7LttAdTLw.create(«CompilerBase.CONTEXT_NAME».getRuntime(), null));
				«UNWRAP»(_local0).dispose();
			''')
	}
}
