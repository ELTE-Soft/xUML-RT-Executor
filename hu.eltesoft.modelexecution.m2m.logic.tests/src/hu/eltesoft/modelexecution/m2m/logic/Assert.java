package hu.eltesoft.modelexecution.m2m.logic;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

public interface Assert {

	@SafeVarargs
	static <E> void assertAsSets(E[] expecteds, E... actuals) {
		
		assertEquals(expecteds.length, actuals.length);
		
		Set<E> expected = new HashSet<>();
		for (E e : expecteds) {
			expected.add(e);
		}
		
		Set<E> actual = new HashSet<>();
		for (E e : actuals) {
			actual.add(e);
		}
		
		assertEquals(expected, actual);
	}
	
}
