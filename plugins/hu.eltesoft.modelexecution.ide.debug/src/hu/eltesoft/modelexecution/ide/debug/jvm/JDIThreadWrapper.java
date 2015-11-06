package hu.eltesoft.modelexecution.ide.debug.jvm;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassType;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InterfaceType;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.LocalVariable;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StackFrame;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.debug.util.JDIUtils;
import hu.eltesoft.modelexecution.runtime.base.StateMachineRegion;

/**
 * Used to guarantee mutual exclusive access for multiple view components using
 * the same {@linkplain ThreadReference}. The underlying thread should not be
 * used other than through this wrapper.
 */
@SuppressWarnings("restriction")
public class JDIThreadWrapper {

	private ThreadReference thread;

	public JDIThreadWrapper(ThreadReference thread) {
		this.thread = thread;
	}

	/**
	 * Invokes a method call on the underlying thread of the virtual machine.
	 * This method is synchronized, because the thread can only execute one
	 * method at a time.
	 */
	public synchronized Value invokeMethod(ObjectReference instance, Method method, Value... args) throws Exception {
		return JDIUtils.withInfiniteTimeout(thread.virtualMachine(),
				() -> instance.invokeMethod(thread, method, Arrays.asList(args), 0));
	}

	public synchronized Value invokeMethod(ObjectReference instance, String methodName, Value... args)
			throws Exception {
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

	public synchronized Value invokeStaticMethod(ClassType type, Method method, Value... args) throws Exception {
		return JDIUtils.withInfiniteTimeout(thread.virtualMachine(),
				() -> type.invokeMethod(thread, method, Arrays.asList(args), 0));
	}

	public synchronized Value invokeStaticMethod(ClassType type, String methodName, Value... args) throws Exception {
		List<Method> methodsByName = type.methodsByName(methodName);
		methodsByName.removeIf(m -> !m.isStatic());
		for (Method method : methodsByName) {
			try {
				return invokeStaticMethod(type, method, args);
			} catch (InvalidTypeException | IllegalArgumentException e) {
				// try another overload
			}
		}
		throw new NoSuchMethodException("No suitable overloaded method is found");
	}

	/**
	 * @return a reference to the this object in the top stack frame of the
	 *         thread running the runtime
	 */
	public synchronized ObjectReference getActualThis() {
		checkUsable();
		return getExecutionPoint().thisObject();
	}

	/**
	 * @return the arguments of the method call on the top stack frame of the
	 *         thread running the runtime
	 */
	public synchronized List<Value> getActualArguments() {
		checkUsable();
		return getExecutionPoint().getArgumentValues();
	}

	/**
	 * @return the local variables of the method call on the top stack frame of
	 *         the thread running the runtime
	 */
	public synchronized Value getLocalVariable(String varName) {
		checkUsable();
		try {
			LocalVariable variable = getExecutionPoint().visibleVariableByName(varName);
			if (variable == null) {
				return null;
			}
			return getExecutionPoint().getValue(variable);
		} catch (AbsentInformationException e) {
			PluginLogger.logError("Error while accessing local variable value", null);
			return null;
		}
	}

	private void checkUsable() {
		if (!isValid()) {
			throw new IllegalStateException("Thread is not suspended at a breakpoint");
		}
	}

	public boolean isValid() {
		return thread.isAtBreakpoint();
	}

	private StackFrame getExecutionPoint() {
		try {
			Optional<StackFrame> frame = thread.frames().stream().filter(this::isStepCallInStateMachine).findFirst();
			if (frame.isPresent()) {
				return frame.get();
			}
			throw new IllegalStateException("Unable to calculate current execution point");
		} catch (IncompatibleThreadStateException e) {
			PluginLogger.logError("Could not ask execution point", e);
			throw new RuntimeException(e);
		}
	}

	private boolean isStepCallInStateMachine(StackFrame frame) {
		Method method = frame.location().method();
		String methodName = method.name();
		if (!methodName.startsWith("step") && !methodName.equals("doInitialTransition")) {
			return false;
		}
		ReferenceType declaringType = method.declaringType();
		if (!(declaringType instanceof ClassType)) {
			return false;
		}
		List<InterfaceType> interfaces = ((ClassType) declaringType).interfaces();
		return interfaces.stream().anyMatch(i -> StateMachineRegion.class.getCanonicalName().equals(i.name()));
	}
}
