package hu.eltesoft.modelexecution.ide.debug;

import java.util.Arrays;
import java.util.List;

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
 * the same {@linkplain ThreadReference}
 */
@SuppressWarnings("restriction")
public class JDTThread {

	private ThreadReference thread;

	public JDTThread(ThreadReference thread) {
		this.thread = thread;
	}

	public synchronized Value invokeMethod(ObjectReference instance, Method method, Value... args) throws InvocationException,
			InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
		return instance.invokeMethod(thread, method, Arrays.asList(args), 0);
	}
	
	public ObjectReference getActualThis() {
		checkUsable();
		return getExecutionPoint().thisObject();
	}
	
	public List<Value> getActualArguments() {
		checkUsable();
		return getExecutionPoint().getArgumentValues();
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
