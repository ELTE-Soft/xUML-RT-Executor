package hu.eltesoft.modelexecution.ide.debug;

import java.util.Arrays;
import java.util.List;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
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
public class JDTThreadWrapper {

	private ThreadReference thread;

	public JDTThreadWrapper(ThreadReference thread) {
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
			return getExecutionPoint().getValue(getExecutionPoint().visibleVariableByName(varName));
		} catch (AbsentInformationException e) {
			return null;
		}
	}

	private void checkUsable() {
		if (!thread.isSuspended() || !thread.isAtBreakpoint()) {
			throw new IllegalStateException("Thread is not suspended at a breakpoint");
		}
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
