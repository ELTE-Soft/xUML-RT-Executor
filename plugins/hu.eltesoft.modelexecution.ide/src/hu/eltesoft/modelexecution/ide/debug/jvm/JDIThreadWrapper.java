package hu.eltesoft.modelexecution.ide.debug.jvm;

import java.util.Arrays;
import java.util.List;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassType;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.LocalVariable;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.StackFrame;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.IdePlugin;

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
	public synchronized Value invokeMethod(ObjectReference instance, Method method, Value... args)
			throws InvocationException, InvalidTypeException, ClassNotLoadedException,
			IncompatibleThreadStateException {
		return instance.invokeMethod(thread, method, Arrays.asList(args), 0);
	}

	public synchronized Value invokeMethod(ObjectReference instance, String methodName, Value... args)
			throws InvocationException, InvalidTypeException, ClassNotLoadedException,
			IncompatibleThreadStateException, NoSuchMethodException {
		List<Method> methodsByName = instance.referenceType().methodsByName(methodName);
		methodsByName.removeIf(Method::isAbstract);
		for (Method method : methodsByName) {
			try {
				return instance.invokeMethod(thread, method, Arrays.asList(args), 0);
			} catch (InvalidTypeException e) {
				// an other overloaded method must be tried
			}
		}
		throw new NoSuchMethodException("No suitable overloaded method is found");
	}

	public synchronized Value invokeStaticMethod(ClassType type, Method method, Value... args)
			throws InvocationException, InvalidTypeException, ClassNotLoadedException,
			IncompatibleThreadStateException {
		return type.invokeMethod(thread, method, Arrays.asList(args), 0);
	}
	
	public synchronized Value invokeStaticMethod(ClassType type, String methodName, Value... args)
			throws InvocationException, InvalidTypeException, ClassNotLoadedException,
			IncompatibleThreadStateException, NoSuchMethodException {
		List<Method> methodsByName = type.methodsByName(methodName);
		methodsByName.removeIf(m -> !m.isStatic());
		for (Method method : methodsByName) {
			try {
				return type.invokeMethod(thread, method, Arrays.asList(args), 0);
			} catch (InvalidTypeException e) {
				// an other overloaded method must be tried
			}
		}
		throw new NoSuchMethodException("No suitable overloaded method is found");
	}

	/**
	 * @return a reference to the this object in the top stack frame of the
	 *         thread running the runtime
	 */
	public ObjectReference getActualThis() {
		checkUsable();
		return getExecutionPoint().thisObject();
	}

	/**
	 * @return the arguments of the method call on the top stack frame of the
	 *         thread running the runtime
	 */
	public List<Value> getActualArguments() {
		checkUsable();
		return getExecutionPoint().getArgumentValues();
	}

	/**
	 * @return the local variables of the method call on the top stack frame of
	 *         the thread running the runtime
	 */
	public Value getLocalVariable(String varName) {
		checkUsable();
		try {
			LocalVariable variable = getExecutionPoint().visibleVariableByName(varName);
			if (variable == null) {
				return null;
			}
			return getExecutionPoint().getValue(variable);
		} catch (AbsentInformationException e) {
			IdePlugin.logError("Error while accessing local variable value", null);
			return null;
		}
	}

	private void checkUsable() {
		if (!isValid()) {
			throw new IllegalStateException("Thread is not suspended at a breakpoint");
		}
	}

	public boolean isValid() {
		return thread.isSuspended() && thread.isAtBreakpoint();
	}

	private StackFrame getExecutionPoint() {
		try {
			return thread.frames().get(0);
		} catch (IncompatibleThreadStateException e) {
			IdePlugin.logError("Could not ask execution point", e);
			throw new RuntimeException(e);
		}
	}

}
