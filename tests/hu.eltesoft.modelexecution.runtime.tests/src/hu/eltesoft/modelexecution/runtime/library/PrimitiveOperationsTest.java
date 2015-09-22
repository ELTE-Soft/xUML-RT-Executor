package hu.eltesoft.modelexecution.runtime.library;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Test;

public class PrimitiveOperationsTest {

	@Test
	public void testSetValueLhsEmpty() throws Exception {
		ArrayList<BigInteger> rhs = new ArrayList<>();
		rhs.add(new BigInteger("42"));
		ArrayList<BigInteger> lhs = new ArrayList<>();
		ArrayList<BigInteger> ret = PrimitiveOperations.setValue(lhs, rhs);
		assertEquals(42, lhs.get(0).intValue());
		assertEquals(42, ret.get(0).intValue());
	}
	
	@Test
	public void testSetValue() throws Exception {
		ArrayList<BigInteger> rhs = new ArrayList<>();
		rhs.add(new BigInteger("42"));
		ArrayList<BigInteger> lhs = new ArrayList<>();
		lhs.add(new BigInteger("3"));
		ArrayList<BigInteger> ret = PrimitiveOperations.setValue(lhs, rhs);
		assertEquals(42, lhs.get(0).intValue());
		assertEquals(42, ret.get(0).intValue());
	}
	
	@Test
	public void testSetValue_ordered() throws Exception {
		ArrayList<BigInteger> rhs = new ArrayList<>();
		rhs.add(new BigInteger("42"));
		TreeSet<BigInteger> lhs = new TreeSet<>();
		lhs.add(new BigInteger("3"));
		ArrayList<BigInteger> ret = PrimitiveOperations.setValue(lhs, rhs);
		assertEquals(42, lhs.iterator().next().intValue());
		assertEquals(42, ret.iterator().next().intValue());
	}
	
	@Test
	public void testIntegerPrefixIncrement() throws Exception {
		ArrayList<BigInteger> val = new ArrayList<>();
		val.add(new BigInteger("42"));
		ArrayList<BigInteger> ret = PrimitiveOperations.integerPrefixIncrement(val);
		assertEquals(43, ret.get(0).intValue());
		assertEquals(43, val.get(0).intValue());
	}
	
	@Test
	public void testIntegerPrefixDecrement() throws Exception {
		ArrayList<BigInteger> val = new ArrayList<>();
		val.add(new BigInteger("42"));
		ArrayList<BigInteger> ret = PrimitiveOperations.integerPrefixDecrement(val);
		assertEquals(41, ret.get(0).intValue());
		assertEquals(41, val.get(0).intValue());
	}

	@Test
	public void testIntegerPostfixIncrement() throws Exception {
		ArrayList<BigInteger> val = new ArrayList<>();
		val.add(new BigInteger("42"));
		ArrayList<BigInteger> ret = PrimitiveOperations.integerPostfixIncrement(val);
		assertEquals(42, ret.get(0).intValue());
		assertEquals(43, val.get(0).intValue());
	}
	
	@Test
	public void testIntegerPostfixDecrement() throws Exception {
		ArrayList<BigInteger> val = new ArrayList<>();
		val.add(new BigInteger("42"));
		ArrayList<BigInteger> ret = PrimitiveOperations.integerPostfixDecrement(val);
		assertEquals(42, ret.get(0).intValue());
		assertEquals(41, val.get(0).intValue());
	}
	
	@Test
	public void testValueEquality_true() throws Exception {
		ArrayList<BigInteger> rhs = new ArrayList<>();
		rhs.add(new BigInteger("42"));
		ArrayList<BigInteger> lhs = new ArrayList<>();
		lhs.add(new BigInteger("42"));
		ArrayList<Boolean> eq = PrimitiveOperations.valueEquality(lhs, rhs);
		assertEquals(true, eq.get(0));
	}
	
	@Test
	public void testValueEquality_false() throws Exception {
		ArrayList<BigInteger> rhs = new ArrayList<>();
		rhs.add(new BigInteger("42"));
		ArrayList<BigInteger> lhs = new ArrayList<>();
		lhs.add(new BigInteger("41"));
		ArrayList<Boolean> eq = PrimitiveOperations.valueEquality(lhs, rhs);
		assertEquals(false, eq.get(0));
	}
	
	@Test
	public void testReferenceEquality_true() throws Exception {
		ArrayList<BigInteger> rhs = new ArrayList<>();
		BigInteger val = new BigInteger("42");
		rhs.add(val);
		ArrayList<BigInteger> lhs = new ArrayList<>();
		lhs.add(val);
		ArrayList<Boolean> eq = PrimitiveOperations.referenceEquality(lhs, rhs);
		assertEquals(true, eq.get(0));
	}
	
	@Test
	public void testReferenceEquality_false() throws Exception {
		ArrayList<BigInteger> rhs = new ArrayList<>();
		rhs.add(new BigInteger("42"));
		ArrayList<BigInteger> lhs = new ArrayList<>();
		lhs.add(new BigInteger("42"));
		ArrayList<Boolean> eq = PrimitiveOperations.referenceEquality(lhs, rhs);
		assertEquals(false, eq.get(0));
	}
}
