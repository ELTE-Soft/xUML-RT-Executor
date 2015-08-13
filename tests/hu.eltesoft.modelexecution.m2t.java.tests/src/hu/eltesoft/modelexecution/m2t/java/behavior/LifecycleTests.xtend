package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

class LifecycleTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testDefaultConstructor() {
		assertCompilesTo("new A();", "_aeMPwMc1EeSnK7LttAdTLw.create(context.getRuntime());");
	}

	@Test
	def testCustomConstructorNoParams() {
		assertCompilesTo('''new B();''', '''_9SdsIEDoEeWCNoKXHvCpUQ.create(context.getRuntime());''');
	}

	@Test
	def testCustomConstructorInParams() {
		assertCompilesTo('''new C(pInString => "world", pInBool => false);''', '''_5FoZEEHJEeWzwYgcaM4qwA.create(context.getRuntime(), false, "world");''');
		assertCompilesTo('''new C(pInBool => false, pInString => "world");''', '''_5FoZEEHJEeWzwYgcaM4qwA.create(context.getRuntime(), false, "world");''');
	}

	@Test
	def testSignalConstructorNoParams() {
		assertCompilesTo("new S();", "new _47IQsEGyEeWzwYgcaM4qwA();");
	}

	@Test
	def testSignalConstructorPropertyParams() {
		assertCompilesTo('''new SParams(aBool => true, aString => "hello");''', '''new _MR4rMEHNEeWzwYgcaM4qwA(true, "hello");''');
		assertCompilesTo('''new SParams(aString => "hello", aBool => true);''', '''new _MR4rMEHNEeWzwYgcaM4qwA(true, "hello");''');
	}

	@Test
	def testDeleteExpression() {
		assertCompilesTo("B b = new B(); delete b;", '''
			_9SdsIEDoEeWCNoKXHvCpUQ _local0 = _9SdsIEDoEeWCNoKXHvCpUQ.create(context.getRuntime());
			_local0.dispose();
		''');
	}
}
