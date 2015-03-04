package hu.eltesoft.modelexecution.runtime.base;

/**
 * The base class of code generated for UML signals.
 * 
 * @author nboldi
 */
public abstract class Signal {

	public abstract int signalCode();

	@Override
	public String toString() {
		return getClass().getCanonicalName() + "( signalCode: " + signalCode()
				+ " )";
	}

}
