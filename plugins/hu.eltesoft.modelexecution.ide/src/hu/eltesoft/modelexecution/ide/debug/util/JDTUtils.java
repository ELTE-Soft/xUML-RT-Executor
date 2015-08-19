package hu.eltesoft.modelexecution.ide.debug.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.sun.jdi.ArrayReference;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassType;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InterfaceType;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StringReference;
import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.jvm.JDTThreadWrapper;

@SuppressWarnings("restriction")
public class JDTUtils {

	protected static final String TO_ARRAY_METHOD = "toArray";
	private static final String TO_STRING_METHOD = "toString";

	private JDTThreadWrapper thread;

	public JDTUtils(JDTThreadWrapper thread) {
		this.thread = thread;
	}

	/**
	 * @return true, if the type transitively implements {@linkplain Collection}
	 */
	public boolean isCollectionType(ReferenceType type) {
		if (type instanceof ClassType) {
			for (InterfaceType iface : ((ClassType) type).allInterfaces()) {
				if (iface.name().equals(Collection.class.getCanonicalName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @return the values in the container
	 * @param value
	 *            a reference to a collection in the virtual machine
	 */
	public List<Value> getCollectionValues(ObjectReference value) {
		try {
			return ((ArrayReference) thread.invokeMethod(value, TO_ARRAY_METHOD)).getValues();
		} catch (InvalidTypeException | ClassNotLoadedException | IncompatibleThreadStateException | InvocationException
				| NoSuchMethodException e) {
			IdePlugin.logError("Error while accessing collection elements", e);
			return new LinkedList<>();
		}
	}

	/**
	 * Invokes toString in the virtual machine to get the representation of the
	 * given object.
	 * 
	 * @return the textual representation of the value or null, if it couldn't
	 *         be decided
	 */
	public String invokeToString(ObjectReference objectReference)
			throws InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
		try {
			return ((StringReference) thread.invokeMethod(objectReference, TO_STRING_METHOD)).value();
		} catch (InvocationException e1) {
			// exception in toString
		} catch (NoSuchMethodException e1) {
			IdePlugin.logError("No toString method on value");
		}
		return null;
	}

}
