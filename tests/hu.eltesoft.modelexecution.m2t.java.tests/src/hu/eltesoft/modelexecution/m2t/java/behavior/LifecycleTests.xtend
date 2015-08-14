package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

class LifecycleTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testDefaultConstructor() {
		assertCompilesTo("new A();", "wrap(_aeMPwMc1EeSnK7LttAdTLw.create(context.getRuntime(), null));");
	}

	@Test
	def testCustomConstructorNoParams() {
		assertCompilesTo('''new B();''', '''wrap(_9SdsIEDoEeWCNoKXHvCpUQ.create(context.getRuntime(), i -> i._LAXgUEHKEeWzwYgcaM4qwA()));''');
	}

	@Test
	def testCustomConstructorInParams() {
		assertCompilesTo('''new C(pInString => "world", pInBool => false);''', '''wrap(_5FoZEEHJEeWzwYgcaM4qwA.create(context.getRuntime(), i -> i._7BAgoEHJEeWzwYgcaM4qwA(booleanLiteral(false), stringLiteral("world"))));''');
		assertCompilesTo('''new C(pInBool => false, pInString => "world");''', '''wrap(_5FoZEEHJEeWzwYgcaM4qwA.create(context.getRuntime(), i -> i._7BAgoEHJEeWzwYgcaM4qwA(booleanLiteral(false), stringLiteral("world"))));''');
	}

	@Test
	def testSignalConstructorNoParams() {
		assertCompilesTo("new S();", "wrap(new _47IQsEGyEeWzwYgcaM4qwA());");
	}

	@Test
	def testSignalConstructorPropertyParams() {
		assertCompilesTo('''new SParams(aBool => true, aString => "hello");''', '''wrap(new _MR4rMEHNEeWzwYgcaM4qwA(booleanLiteral(true), stringLiteral("hello")));''');
		assertCompilesTo('''new SParams(aString => "hello", aBool => true);''', '''wrap(new _MR4rMEHNEeWzwYgcaM4qwA(booleanLiteral(true), stringLiteral("hello")));''');
	}

	@Test
	def testDeleteExpression() {
		assertCompilesTo("A a = new A(); delete a;", '''
			java.util.ArrayList<_aeMPwMc1EeSnK7LttAdTLw> _local0 = wrap(_aeMPwMc1EeSnK7LttAdTLw.create(context.getRuntime(), null));
			unwrap(_local0).dispose();
		''');
	}
}
