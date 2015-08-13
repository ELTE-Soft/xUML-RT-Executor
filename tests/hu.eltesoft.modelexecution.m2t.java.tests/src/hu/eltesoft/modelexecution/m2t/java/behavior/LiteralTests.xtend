package hu.eltesoft.modelexecution.m2t.java.behavior

import java.math.BigInteger
import org.junit.Ignore
import org.junit.Test

class LiteralTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testNull() {
		assertCompilesToSame("null;")
	}

	@Test
	def testThis() {
		assertCompilesTo("this;", '''«Compiler.CONTEXT_NAME»;''')
	}

	@Test
	def testBooleanFalse() {
		assertCompilesToSame("false;")
	}

	@Test
	def testBooleanTrue() {
		assertCompilesToSame("true;")
	}

	@Test
	def testNaturalZero() {
		assertCompilesTo("0;", "java.math.BigInteger.valueOf(0);")
	}

	@Test
	def testNaturalDecimalHundred() {
		assertCompilesTo("100;", "java.math.BigInteger.valueOf(100);")
	}

	@Test
	def testNaturalHexadecimalHundred() {
		assertCompilesTo("0x64;", "java.math.BigInteger.valueOf(0x64);")
	}

	@Test
	def testNaturalOctalHundred() {
		assertCompilesTo("0144;", "java.math.BigInteger.valueOf(0144);")
	}

	@Test
	def testNaturalBinaryHundred() {
		assertCompilesTo("0b1100100;", "java.math.BigInteger.valueOf(0b1100100);")
		assertCompilesTo("0B1100100;", "java.math.BigInteger.valueOf(0B1100100);")
	}

	@Test
	def testNaturalUnderscoreSeparator() {
		assertCompilesTo("1_000_000_000;", "java.math.BigInteger.valueOf(1_000_000_000);")
	}

	@Test
	def testRealZero() {
		assertCompilesToSame("0.0;")
	}

	@Test
	def testRealTruncatedPi() {
		assertCompilesToSame("3.14159265;")
	}

	@Test
	def testEscapedString() {
		assertCompilesToSame('''"hello\b\t\n\f\r\"'\\world";''')
	}

	@Ignore("Unlimited naturals are unsupported (yet?)")
	@Test
	def testUnboundedNatural() {
		assertCompilesTo("*;", '''«BigInteger.canonicalName».MAX_VALUE;''')
	}
}
