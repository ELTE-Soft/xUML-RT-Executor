package hu.eltesoft.modelexecution.ide.debug.jvm;

import java.util.Arrays;
import java.util.List;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassType;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.LocalVariable;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.StackFrame;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.debug.util.JDIUtils;

/**
 * Used to guarantee mutual exclusive access for multiple view components using
 * the same {@linkplain ThreadReference}. The underlying thread should not be
 * used other than through this wrapper.
 */
@SuppressWarnings("restriction")
public class JDIThreadWrapper {

	private final ThreadReference thread;
	private final VirtualMachineManager vmManager;

	private StackFrame executionPoint;

	public JDIThreadWrapper(VirtualMachineManager vmManager, ThreadReference thread) {
		this.vmManager = vmManager;
		this.thread = thread;

		try {
			executionPoint = thread.frame(0);
		} catch (IncompatibleThreadStateException e) {
			PluginLogger.logError("Could not ask execution point", e);
			throw new RuntimeException(e);
		}
	}

	public boolean isValid() {
		return vmManager.isSuspendedAtBreakpoint();
	}

	private void checkUsable() {
		if (!isValid()) {
			throw new IllegalStateException("Thread is not suspended at a breakpoint");
		}
	}

	public synchronized Value invokeMethod(ObjectReference instance, String methodName, Value... args)
			throws Exception {
		checkUsable();
		List<Method> methodsByName = instance.referenceType().methodsByName(methodName);
		methodsByName.removeIf(Method::isAbstract);
		for (Method method : methodsByName) {
			try {
				return invokeMethod(instance, method, args);
			} catch (InvalidTypeException | IllegalArgumentException e) {
				// try another overload
			}
		}
		throw noOverloadedException(methodName, args);
	}

	/**
	 * Invokes a method call on the underlying thread of the virtual machine.
	 * This method is synchronized, because the thread can only execute one
	 * method at a time.
	 */
	private synchronized Value invokeMethod(ObjectReference instance, Method method, Value... args) throws Exception {
		return JDIUtils.withInfiniteTimeout(thread.virtualMachine(),
				() -> instance.invokeMethod(thread, method, Arrays.asList(args), 0));
	}

	private NoSuchMethodException noOverloadedException(String methodName, Value... args) throws NoSuchMethodException {
		StringBuilder sb = new StringBuilder("No suitable overloaded method is found: " + methodName + "(");
		if (args.length > 0) {
			sb.append(args[0]);
		}
		for (int i = 1; i < args.length; i++) {
			sb.append("," + args[i]);
		}
		sb.append(")");
		return new NoSuchMethodException(sb.toString());
	}

	public synchronized Value invokeStaticMethod(ClassType type, String methodName, Value... args) throws Exception {
		checkUsable();
		List<Method> methodsByName = type.methodsByName(methodName);
		methodsByName.removeIf(m -> !m.isStatic());
		for (Method method : methodsByName) {
			try {
				return invokeStaticMethod(type, method, args);
			} catch (InvalidTypeException | IllegalArgumentException e) {
				// try another overload
			}
		}
		throw noOverloadedException(methodName, args);
	}

	private synchronized Value invokeStaticMethod(ClassType type, Method method, Value... args) throws Exception {
		return JDIUtils.withInfiniteTimeout(thread.virtualMachine(),
				() -> type.invokeMethod(thread, method, Arrays.asList(args), 0));
	}

	/**
	 * @return a reference to the this object in the top stack frame of the
	 *         thread running the runtime
	 */
	synchronized ObjectReference getActualThis() {
		checkUsable();
		return executionPoint.thisObject();
	}

	/**
	 * @return the arguments of the method call on the top stack frame of the
	 *         thread running the runtime
	 */
	synchronized List<Value> getActualArguments() {
		checkUsable();
		return executionPoint.getArgumentValues();
	}

	/**
	 * @return the local variables of the method call on the top stack frame of
	 *         the thread running the runtime
	 */
	synchronized Value getLocalVariable(String varName) {
		checkUsable();
		try {
			LocalVariable variable = executionPoint.visibleVariableByName(varName);
			if (variable == null) {
				return null;
			}
			return executionPoint.getValue(variable);
		} catch (AbsentInformationException e) {
			PluginLogger.logError("Error while accessing local variable value", null);
			return null;
		}
	}
}
