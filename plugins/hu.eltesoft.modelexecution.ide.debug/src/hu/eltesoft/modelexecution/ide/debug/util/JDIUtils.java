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

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.debug.jvm.JDIThreadWrapper;

@SuppressWarnings("restriction")
public class JDIUtils {

	protected static final String TO_ARRAY_METHOD = "toArray";
	private static final String TO_STRING_METHOD = "toString";

	private JDIThreadWrapper thread;

	public JDIUtils(JDIThreadWrapper thread) {
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
			return withInfiniteTimeout(value.virtualMachine(), () -> {
				ArrayReference array = (ArrayReference) thread.invokeMethod(value, TO_ARRAY_METHOD);
				// getValues throws an exception on empty arrays
				if (array.length() > 0) {
					return array.getValues();
				} else {
					return new LinkedList<Value>();
				}
			});
		} catch (Exception e) {
			PluginLogger.logError("Error while accessing collection elements", e);
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
			return JDIUtils.withInfiniteTimeout(objectReference.virtualMachine(),
					() -> ((StringReference) thread.invokeMethod(objectReference, TO_STRING_METHOD)).value());
		} catch (InvocationException e1) {
			// exception in toString
		} catch (Exception e) {
			PluginLogger.logError("Error while invoking toString", e);
		}
		return null;
	}

	public static <T> T withInfiniteTimeout(com.sun.jdi.VirtualMachine vm, VMJob<T> action) throws Exception {
		T ret;
		if (vm instanceof org.eclipse.jdi.VirtualMachine) {
			org.eclipse.jdi.VirtualMachine jdiVM = (org.eclipse.jdi.VirtualMachine) vm;
			int timeout = jdiVM.getRequestTimeout();
			jdiVM.setRequestTimeout(Integer.MAX_VALUE);
			ret = action.exec();
			jdiVM.setRequestTimeout(timeout);
		}
		ret = action.exec();
		return ret;
	}

	@FunctionalInterface
	public interface VMJob<T> {

		T exec() throws Exception;

	}

}
