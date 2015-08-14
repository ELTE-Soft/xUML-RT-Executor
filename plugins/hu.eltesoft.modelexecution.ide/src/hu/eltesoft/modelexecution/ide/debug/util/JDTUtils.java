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
import com.sun.jdi.Method;
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
		Method iteratorMethod = selectMethod(value.referenceType(), TO_ARRAY_METHOD);
		if (iteratorMethod != null) {
			try {
				ArrayReference arrayRef = (ArrayReference) thread.invokeMethod(value, iteratorMethod);
				if (arrayRef.length() > 0) {
					// getValues cannot be used on a reference of an empty array
					return arrayRef.getValues();
				}
			} catch (InvocationException e) {
				// error while calling toArray, fall through
			} catch (InvalidTypeException | ClassNotLoadedException | IncompatibleThreadStateException e) {
				IdePlugin.logError("Error while accessing collection elements", e);
			}
		}
		return new LinkedList<>();
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
		Method toStringMethod = selectMethod(objectReference.referenceType(), TO_STRING_METHOD);
		if (toStringMethod == null) {
			IdePlugin.logError("No toString method on value");
		} else {
			Value toStringResult;
			try {
				toStringResult = thread.invokeMethod(objectReference, toStringMethod);
			} catch (InvocationException e) {
				// exception in toString
				return null;
			}
			if (toStringResult instanceof StringReference) {
				return ((StringReference) toStringResult).value();
			} else {
				IdePlugin.logError("The result of toString is not a String");
			}
		}
		return null;
	}
	
	/**
	 * @param refType the mirror of the type where the method can be found
	 * @param name the name of the method
	 * @param argumentTypeNames the names of argument types
	 * @return the mirror referencing the (non-abstract) method
	 */
	private Method selectMethod(ReferenceType refType, String name, String... argumentTypeNames) {
		List<Method> methodsByName = refType.methodsByName(name);
		for (Method method : methodsByName) {
			if (!method.isAbstract()) {
				List<String> argumentTypes = method.argumentTypeNames();
				if (argumentTypes.size() != argumentTypeNames.length) {
					continue;
				}
				for (int i = 0; i < argumentTypeNames.length; i++) {
					if (!argumentTypeNames[i].equals(argumentTypes.get(i))) {
						continue;
					}
				}
				return method;
			}
		}
		return null;
	}

}
