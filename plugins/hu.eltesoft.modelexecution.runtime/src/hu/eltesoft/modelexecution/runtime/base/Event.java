package hu.eltesoft.modelexecution.runtime.base;

import java.util.concurrent.atomic.AtomicLong;

import hu.eltesoft.modelexecution.runtime.serialize.JSONSerializable;

/**
 * A base class for UML events in the system. Events with the same source
 * (signal, operation, timer) are considered to be equal.
 */
public abstract class Event implements JSONSerializable, Comparable<Event> {

	public enum Priority {
		HIGH, NORMAL
	}

	/**
	 * Events with high priority are delivered before normal priority events.
	 * The only high priority events now are the signal events which were
	 * explicitly sent to a `this` expression. By default, every event has a
	 * normal priority. Do not change the priority of an event after it is
	 * created! The only reason it is not final that serialization will need to
	 * write this field when an event gets reconstructed.
	 */
	protected Priority priority = Priority.NORMAL;

	private static final AtomicLong nextSequenceNumber = new AtomicLong(0);

	/**
	 * As the blocking priority queue does not enforces the ordering between
	 * elements with the same priority, we have to ensure this with a unique
	 * sequence number for each event. The sequence number is assigned on
	 * instance initialization, before any constructor call. Do not change the
	 * sequence number of an event after it is created! The only reason it is
	 * not final that serialization will need to write this field when an event
	 * gets reconstructed.
	 */
	protected long sequenceNumber;

	{
		sequenceNumber = nextSequenceNumber.getAndIncrement();
	}

	/**
	 * Compares entities by their priority. For events with the same priority,
	 * it compares their sequence numbers to ensure ordering of events with same
	 * priorities.
	 */
	@Override
	public int compareTo(Event other) {
		int result = Integer.compare(priority.ordinal(), other.priority.ordinal());
		if (0 == result) {
			return Long.compare(sequenceNumber, other.sequenceNumber);
		}
		return result;
	}
}
