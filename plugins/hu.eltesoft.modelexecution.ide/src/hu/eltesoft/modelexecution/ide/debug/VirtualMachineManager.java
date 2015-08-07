package hu.eltesoft.modelexecution.ide.debug;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.ITerminate;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.Field;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.IntegerValue;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StackFrame;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;
import com.sun.jdi.request.BreakpointRequest;
import com.sun.jdi.request.EventRequest;
import com.sun.jdi.request.EventRequestManager;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.VirtualMachineListener.ThreadAction;
import hu.eltesoft.modelexecution.ide.launch.process.IProcessWithVM;

@SuppressWarnings("restriction")
public class VirtualMachineManager implements ITerminate {

	private Thread eventHandlerThread;
	private VirtualMachine virtualMachine;
	private IProcessWithVM javaProcess;

	private List<VirtualMachineListener> eventListeners = new LinkedList<>();
	private boolean eventsEnabled;
	private boolean disconnectFired;

	public VirtualMachineManager(ILaunch launch) {
		javaProcess = getJavaProcess(launch);
		virtualMachine = javaProcess.getVM();
		if (virtualMachine == null) {
			IdePlugin.logError("Cannot extract virtual machine from java process");
		}

		eventHandlerThread = createEventHandlerThread();
		eventHandlerThread.start();
	}

	/**
	 * Gets the background java virtual machine that operates in debug mode.
	 */
	private IProcessWithVM getJavaProcess(ILaunch launch) {
		for (IProcess process : launch.getProcesses()) {
			if (process instanceof IProcessWithVM) {
				return (IProcessWithVM) process;
			}
		}
		return null;
	}

	public void addEventListener(VirtualMachineListener listener) {
		if (eventListeners.contains(listener)) {
			return;
		}
		eventListeners.add(listener);
		enableEvents();
	}

	private void enableEvents() {
		if (eventsEnabled) {
			return;
		}
		eventsEnabled = true;

		EventRequestManager manager = virtualMachine.eventRequestManager();
		EventRequest request = manager.createClassPrepareRequest();
		request.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		request.enable();
	}

	public void setDefaultStratum(String defaultStratumName) {
		virtualMachine.setDefaultStratum(defaultStratumName);
	}

	public void addBreakpoint(com.sun.jdi.Location location) {
		EventRequestManager manager = virtualMachine.eventRequestManager();
		BreakpointRequest request = manager.createBreakpointRequest(location);
		request.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		request.enable();
	}

	/**
	 * Starts a thread that eats all events from the virtual machine and calls
	 * the corresponding function.
	 */
	private Thread createEventHandlerThread() {
		return new Thread(new Runnable() {

			private volatile boolean running = true;

			private void stop() {
				running = false;
			}

			private boolean shouldResume;

			@Override
			public void run() {
				try {
					while (running) {
						shouldResume = false;
						EventSet events = virtualMachine.eventQueue().remove();
						events.forEach(this::dispatchEvent);
						if (shouldResume) {
							events.resume();
						}
					}
				} catch (VMDisconnectedException e) {
					// This is a workaround for a bug in JDI.
					// https://bugs.openjdk.java.net/browse/JDK-4425852
					fireVMDisconnectEvent(null);
					// stop on vm disconnect
					stop();
				} catch (Exception e) {
					IdePlugin.logError("Exception while processing VirtualMachine events", e);
				}
			}

			private void dispatchEvent(Event event) {
				if (event instanceof VMStartEvent) {
					fireVMStartEvent((VMStartEvent) event);
				} else if (event instanceof VMDisconnectEvent) {
					fireVMDisconnectEvent((VMDisconnectEvent) event);
					// stop on vm disconnect
					stop();
				} else if (event instanceof VMDeathEvent) {
					fireVMDeathEvent((VMDeathEvent) event);
				} else if (event instanceof ClassPrepareEvent) {
					fireClassPrepareEvent((ClassPrepareEvent) event);
					shouldResume = true;
				} else if (event instanceof BreakpointEvent) {
					shouldResume |= fireBreakpointEvent((BreakpointEvent) event);
				}
			}
		});
	}

	private void fireVMStartEvent(VMStartEvent event) {
		eventListeners.forEach(l -> l.handleVMStart(event));
	}

	private void fireVMDisconnectEvent(VMDisconnectEvent event) {
		// Notification of listeners is guarded as they should get this event
		// only once. However, when JDI works as is should, it will be called
		// twice: once from the event listener and once from the exception
		// handler.
		if (!disconnectFired) {
			eventListeners.forEach(l -> l.handleVMDisconnect(event));
			disconnectFired = true;

			// the java process is already terminated at this time
		}
	}

	private void fireVMDeathEvent(VMDeathEvent event) {
		eventListeners.forEach(l -> l.handleVMDeath(event));
	}

	private void fireClassPrepareEvent(ClassPrepareEvent event) {
		eventListeners.forEach(l -> l.handleClassPrepare(event));
	}

	protected boolean fireBreakpointEvent(BreakpointEvent event) {
		ThreadAction action = ThreadAction.ShouldResume;
		for (VirtualMachineListener listener : eventListeners) {
			action = action.merge(listener.handleBreakpoint(event));
		}
		return action.shouldResume();
	}

	@Override
	public boolean canTerminate() {
		return javaProcess.canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return javaProcess.isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		virtualMachine.dispose();
		// the java process may receive the termination signal multiple times,
		// because disconnect event can also send one
		javaProcess.terminate();
	}

	public void resume() {
		try {
			virtualMachine.resume();
		} catch (VMDisconnectedException e) {
			// suppress any actions after the vm is disconnected
		}
	}

	public void suspend() {
		try {
			virtualMachine.suspend();
		} catch (VMDisconnectedException e) {
			// suppress any actions after the vm is disconnected
		}
	}

	public void disconnect() {
		virtualMachine.dispose();
	}

	public String getActualSMInstance() {
		List<ThreadReference> threads = virtualMachine.allThreads();
		ThreadReference mainThread = null;
		for (ThreadReference thread : threads) {
			if (thread.name().equals("main")) {
				mainThread = thread;
			}
		}
		try {
			Field ownerField = mainThread.frames().get(0).thisObject().referenceType().fieldByName("owner");
			ObjectReference owner = (ObjectReference) mainThread.frames().get(0).thisObject().getValue(ownerField);
			List<Method> getInstanceID = owner.referenceType().methodsByName("getInstanceID");
			getInstanceID.removeIf(Method::isAbstract);
			Value result = owner.invokeMethod(mainThread, getInstanceID.get(0), new LinkedList<Value>(), 0);
			return owner.referenceType().name() + "#" + ((IntegerValue) result).intValue();
		} catch (IncompatibleThreadStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotLoadedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
