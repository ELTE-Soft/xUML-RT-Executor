package hu.eltesoft.modelexecution.runtime.library;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

public class CollectionOperationsTest {

	@Test
	public void testSequenceLiteral() throws Exception {
		Collection<Integer> literal = CollectionOperations.sequenceLiteral(0, 1, 2, 3, 0, 1, 2);
		assertEquals(7, literal.size());
	}
	
	@Test
	public void testSetLiteral() throws Exception {
		Collection<Integer> literal = CollectionOperations.setLiteral(0, 1, 2, 3, 0, 1, 2);
		assertEquals(4, literal.size());
	}

	@Test
	public void testBagLiteral() throws Exception {
		Collection<Integer> literal = CollectionOperations.bagLiteral(0, 1, 2, 3, 0, 1, 2);
		assertEquals(7, literal.size());
	}
}
