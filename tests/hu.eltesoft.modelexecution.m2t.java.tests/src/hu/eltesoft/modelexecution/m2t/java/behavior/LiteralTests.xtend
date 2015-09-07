package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class LiteralTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testNull() {
		assertCompilesTo('''null;''', fun(PrimitiveOperations.NULL_VALUE))
	}

	@Test
	def testThis() {
		assertCompilesTo('''this;''', wrap(CompilerBase.CONTEXT_NAME))
	}

	@Test
	def testBooleanFalse() {
		assertCompilesTo('''false;''', booleanLiteral("false"))
	}

	@Test
	def testBooleanTrue() {
		assertCompilesTo('''true;''', booleanLiteral("true"))
	}

	@Test
	def testNaturalDecimalHundred() {
		assertCompilesTo('''100;''', integerLiteral("100", 10))
	}

	@Test
	def testNaturalHexadecimalHundred() {
		assertCompilesTo('''0x64;''', integerLiteral("64", 16))
		assertCompilesTo('''0X64;''', integerLiteral("64", 16))
	}

	@Test
	def testNaturalOctalHundred() {
		assertCompilesTo('''0144;''', integerLiteral("144", 8))
	}

	@Test
	def testNaturalBinaryHundred() {
		assertCompilesTo('''0b1100100;''', integerLiteral("1100100", 2))
		assertCompilesTo('''0B1100100;''', integerLiteral("1100100", 2))
	}

	@Test
	def testNaturalZero() {
		assertCompilesTo('''0;''', integerLiteral("0", 10))
	}

	@Test
	def testNaturalUnderscoreSeparator() {
		assertCompilesTo('''1_000_000_000;''', integerLiteral("1000000000", 10))
	}

	@Test
	def testRealZero() {
		assertCompilesTo('''0.0;''', realLiteral("0.0"))
	}

	@Test
	def testRealTruncatedPi() {
		assertCompilesTo('''3.14159265;''', realLiteral("3.14159265"))
	}

	@Test
	def testEscapedString() {
		assertCompilesTo('''"hello\b\t\n\f\r\"'\\world";''', stringLiteral('''hello\b\t\n\f\r\"'\\world'''))
	}
}
