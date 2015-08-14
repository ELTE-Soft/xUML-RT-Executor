package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.serialize.JSONSerializable;

/**
 * A base class for UML events in the system. Events with the same source
 * (signal, operation, timer) are considered to be equal.
 */
public abstract class Event implements JSONSerializable {

}
