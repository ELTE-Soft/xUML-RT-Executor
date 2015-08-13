package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

class InvocationTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testNonStaticSelfCallNoParams() {
		assertCompilesTo("this.OpVoid();", "context._$1zHIEDoEeWCNoKXHvCpUQ();")
	}

	@Test
	def testNonStaticLocalCallNoParams() {
		assertCompilesTo("A a = new A(); a.Op();", '''
			_aeMPwMc1EeSnK7LttAdTLw _local0 = _aeMPwMc1EeSnK7LttAdTLw.create(context.getRuntime());
			_local0._oMFm4EG6EeWzwYgcaM4qwA();
		''');
	}

	@Test
	def testNonStaticSelfCallInParams() {
		assertCompilesTo('''this.OpIn(pInInt => 42, pInBool => true);''', '''context._E59jwEG_EeWzwYgcaM4qwA(true, java.math.BigInteger.valueOf(42));''')
		assertCompilesTo('''this.OpIn(pInBool => true, pInInt => 42);''', '''context._E59jwEG_EeWzwYgcaM4qwA(true, java.math.BigInteger.valueOf(42));''')
	}

	@Test
	def testStaticCallNoParams() {
		assertCompilesTo("A::OpStatic();", "_aeMPwMc1EeSnK7LttAdTLw._M0$PUEG7EeWzwYgcaM4qwA();")
	}

	@Test
	def testStaticCallInParams() {
		assertCompilesTo('''B::OpStaticIn(pInString => "hello", pInReal => 3.1415);''', '''_9SdsIEDoEeWCNoKXHvCpUQ._VlbpQEHEEeWzwYgcaM4qwA("hello", 3.1415);''')
		assertCompilesTo('''B::OpStaticIn(pInReal => 3.1415, pInString => "hello");''', '''_9SdsIEDoEeWCNoKXHvCpUQ._VlbpQEHEEeWzwYgcaM4qwA("hello", 3.1415);''')
	}
}
