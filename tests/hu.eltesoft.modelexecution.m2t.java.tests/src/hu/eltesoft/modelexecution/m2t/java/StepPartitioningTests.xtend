package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2t.java.templates.StepPartitioning
import org.junit.Test

import static org.junit.Assert.*

class StepPartitioningTests {

	@Test
	def testWithOneState() {
		expectOnePartition(1)
	}

	@Test
	def testWithLessStatesThanAPartition() {
		expectOnePartition(StepPartitioning.PARTITION_SIZE - 1)
	}

	@Test
	def testWithSameNumberOfStatesThanAPartition() {
		expectOnePartition(StepPartitioning.PARTITION_SIZE)
	}

	def expectOnePartition(int numberOfStates) {
		val p = new StepPartitioning(numberOfStates)
		assertEquals(1, p.numberOfPartitions)
		assertEquals(0, p.firstState(0))
		assertEquals(numberOfStates, p.afterLastState(0))
		assertTrue(p.isLast(0))
	}

	@Test
	def testWithOneMoreStatesThanAPartition() {
		val numberOfStates = StepPartitioning.PARTITION_SIZE + 1
		val p = new StepPartitioning(numberOfStates)
		assertEquals(2, p.numberOfPartitions)

		assertEquals(0, p.firstState(0))
		assertEquals(StepPartitioning.PARTITION_SIZE, p.afterLastState(0))
		assertFalse(p.isLast(0))

		assertEquals(StepPartitioning.PARTITION_SIZE, p.firstState(1))
		assertEquals(numberOfStates, p.afterLastState(1))
		assertTrue(p.isLast(1))
	}

	@Test
	def testWithSixPartitions() {
		val numberOfStates = StepPartitioning.PARTITION_SIZE * 6
		val p = new StepPartitioning(numberOfStates)
		assertEquals(6, p.numberOfPartitions)

		assertEquals(0, p.firstState(0))
		assertEquals(StepPartitioning.PARTITION_SIZE, p.afterLastState(0))
		assertFalse(p.isLast(0))

		assertEquals(StepPartitioning.PARTITION_SIZE * 3, p.firstState(3))
		assertEquals(StepPartitioning.PARTITION_SIZE * 4, p.afterLastState(3))
		assertFalse(p.isLast(3))

		assertEquals(StepPartitioning.PARTITION_SIZE * 5, p.firstState(5))
		assertEquals(numberOfStates, p.afterLastState(5))
		assertTrue(p.isLast(5))
	}
}
