package hu.eltesoft.modelexecution.m2t.java.behavior

import java.math.BigInteger
import org.junit.Ignore
import org.junit.Test

/*
 * Test compilation of literals using a wrapper expression statement (hence the semicolon at the end of every test input).
 * As reduced ALF literals are designed to be the same as Java literals, the compiler outputs the same code as its input was.
 */
class LiteralCompilerTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new LiteralCompiler()
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
		assertCompilesToSame("0;")
	}

	@Test
	def testNaturalDecimalHundred() {
		assertCompilesToSame("100;")
	}

	@Test
	def testNaturalHexadecimalHundred() {
		assertCompilesToSame("0x64;")
	}

	@Test
	def testNaturalOctalHundred() {
		assertCompilesToSame("0144;")
	}

	@Test
	def testNaturalBinaryHundred() {
		assertCompilesToSame("0b1100100;")
		assertCompilesToSame("0B1100100;")
	}

	@Test
	def testNaturalUnderscoreSeparator() {
		assertCompilesToSame("1_000_000_000;")
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

	@Ignore("Unlimited naturals are unsupported yet")
	@Test
	def testUnboundedNatural() {
		assertCompilesTo("*;", '''«BigInteger.canonicalName».MAX_VALUE;''')
	}
}
