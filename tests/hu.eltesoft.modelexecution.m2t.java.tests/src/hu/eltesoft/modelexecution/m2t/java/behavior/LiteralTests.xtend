package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test
import static hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations.*

class LiteralTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testNull() {
		assertCompilesTo('''null;''', '''«NULL_VALUE»();''')
	}

	@Test
	def testThis() {
		assertCompilesTo('''this;''', '''«WRAP»(«CompilerBase.CONTEXT_NAME»);''')
	}

	@Test
	def testBooleanFalse() {
		assertCompilesTo('''false;''', '''«BOOLEAN_LITERAL»(false);''')
	}

	@Test
	def testBooleanTrue() {
		assertCompilesTo('''true;''', '''«BOOLEAN_LITERAL»(true);''')
	}

	@Test
	def testNaturalDecimalHundred() {
		assertCompilesTo('''100;''', '''«INTEGER_LITERAL»("100", 10);''')
	}

	@Test
	def testNaturalHexadecimalHundred() {
		assertCompilesTo('''0x64;''', '''«INTEGER_LITERAL»("64", 16);''')
		assertCompilesTo('''0X64;''', '''«INTEGER_LITERAL»("64", 16);''')
	}

	@Test
	def testNaturalOctalHundred() {
		assertCompilesTo('''0144;''', '''«INTEGER_LITERAL»("144", 8);''')
	}

	@Test
	def testNaturalBinaryHundred() {
		assertCompilesTo('''0b1100100;''', '''«INTEGER_LITERAL»("1100100", 2);''')
		assertCompilesTo('''0B1100100;''', '''«INTEGER_LITERAL»("1100100", 2);''')
	}

	@Test
	def testNaturalZero() {
		assertCompilesTo('''0;''', '''«INTEGER_LITERAL»("0", 10);''')
	}

	@Test
	def testNaturalUnderscoreSeparator() {
		assertCompilesTo('''1_000_000_000;''', '''«INTEGER_LITERAL»("1000000000", 10);''')
	}

	@Test
	def testRealZero() {
		assertCompilesTo('''0.0;''', '''«REAL_LITERAL»(0.0);''')
	}

	@Test
	def testRealTruncatedPi() {
		assertCompilesTo('''3.14159265;''', '''«REAL_LITERAL»(3.14159265);''')
	}

	@Test
	def testEscapedString() {
		assertCompilesTo('''"hello\b\t\n\f\r\"'\\world";''', '''«STRING_LITERAL»("hello\b\t\n\f\r\"'\\world");''')
	}
}
