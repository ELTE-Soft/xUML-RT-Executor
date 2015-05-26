package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.trace.json.JSONSerializable;

/**
 * The message is something that an event can carry. A signal, a timer or a
 * method call.
 */
public interface Message extends JSONSerializable {

}
