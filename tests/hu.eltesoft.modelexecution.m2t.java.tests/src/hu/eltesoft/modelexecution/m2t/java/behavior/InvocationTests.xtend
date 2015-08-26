package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test
import static hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations.*

class InvocationTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testNonStaticSelfCallNoParams() {
		assertCompilesTo('''this.OpVoid();''', '''«UNWRAP»(«WRAP»(«CompilerBase.CONTEXT_NAME»))._$1zHIEDoEeWCNoKXHvCpUQ();''')
	}

	@Test
	def testNonStaticLocalCallNoParams() {
		assertCompilesTo('''A a = new A(); a.Op();''', '''
			java.util.ArrayList<_aeMPwMc1EeSnK7LttAdTLw> _local0 = «WRAP»(_aeMPwMc1EeSnK7LttAdTLw.create(null));
			«UNWRAP»(_local0)._oMFm4EG6EeWzwYgcaM4qwA();
		''');
	}

	@Test
	def testNonStaticSelfCallInParams() {
		assertCompilesTo('''this.OpIn(pInInt => 42, pInBool => true);''', '''«UNWRAP»(«WRAP»(«CompilerBase.CONTEXT_NAME»))._E59jwEG_EeWzwYgcaM4qwA(«BOOLEAN_LITERAL»(true), «INTEGER_LITERAL»("42", 10));''')
		assertCompilesTo('''this.OpIn(pInBool => true, pInInt => 42);''', '''«UNWRAP»(«WRAP»(«CompilerBase.CONTEXT_NAME»))._E59jwEG_EeWzwYgcaM4qwA(«BOOLEAN_LITERAL»(true), «INTEGER_LITERAL»("42", 10));''')
	}

	@Test
	def testStaticCallNoParams() {
		assertCompilesTo("A::OpStatic();", "_aeMPwMc1EeSnK7LttAdTLw_impl._M0$PUEG7EeWzwYgcaM4qwA();")
	}

	@Test
	def testStaticCallInParams() {
		assertCompilesTo('''B::OpStaticIn(pInString => "hello", pInReal => 3.1415);''', '''_9SdsIEDoEeWCNoKXHvCpUQ_impl._VlbpQEHEEeWzwYgcaM4qwA(«STRING_LITERAL»("hello"), «REAL_LITERAL»(3.1415));''')
		assertCompilesTo('''B::OpStaticIn(pInReal => 3.1415, pInString => "hello");''', '''_9SdsIEDoEeWCNoKXHvCpUQ_impl._VlbpQEHEEeWzwYgcaM4qwA(«STRING_LITERAL»("hello"), «REAL_LITERAL»(3.1415));''')
	}
}
