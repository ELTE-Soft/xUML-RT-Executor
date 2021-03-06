package hu.eltesoft.modelexecution.ide.debug.jvm;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;

import com.sun.jdi.VMDisconnectedException;
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

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.common.process.IProcessWithVM;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineListener.ThreadAction;

/**
 * Two way communication with the virtual machine running the runtime.
 */
@SuppressWarnings("restriction")
public class VirtualMachineManager {

	private final VirtualMachine virtualMachine;
	private final IProcessWithVM javaProcess;

	private final VirtualMachineBrowser vmBrowser;

	private final List<VirtualMachineListener> eventListeners = new LinkedList<>();
	private final Thread eventHandlerThread;

	private boolean eventsEnabled;
	private boolean disconnectFired;

	private volatile boolean isSuspendedAtBreakpoint = false;

	public boolean isSuspendedAtBreakpoint() {
		return isSuspendedAtBreakpoint;
	}

	public VirtualMachineManager(ILaunch launch) {
		javaProcess = getJavaProcess(launch);
		virtualMachine = javaProcess.getVM();
		if (virtualMachine == null) {
			PluginLogger.logError("Cannot extract virtual machine from java process");
		}

		vmBrowser = new VirtualMachineBrowser(this);

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
		request.setSuspendPolicy(EventRequest.SUSPEND_EVENT_THREAD);
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
					PluginLogger.logError("Exception while processing VirtualMachine events", e);
				}
			}

			private void dispatchEvent(Event event) {
				if (event instanceof VMStartEvent) {
					fireVMStartEvent((VMStartEvent) event);
					shouldResume = true;
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
					isSuspendedAtBreakpoint = true;
					shouldResume |= fireBreakpointEvent((BreakpointEvent) event);
					if (shouldResume) {
						isSuspendedAtBreakpoint = false;
						fireResumeFromBreakpointEvent();
					}
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

	private boolean fireBreakpointEvent(BreakpointEvent event) {
		ThreadAction action = ThreadAction.ShouldResume;
		for (VirtualMachineListener listener : eventListeners) {
			action = action.merge(listener.handleBreakpoint(event));
		}
		return action.shouldResume();
	}

	private void fireResumeFromBreakpointEvent() {
		eventListeners.forEach(l -> l.handleResumeFromBreakpoint());
	}

	public void terminate() throws DebugException {
		isSuspendedAtBreakpoint = false;
		virtualMachine.dispose();
		// the java process may receive the termination signal multiple times,
		// because disconnect event can also send one
		javaProcess.terminate();
	}

	public void resume() {
		try {
			isSuspendedAtBreakpoint = false;
			fireResumeFromBreakpointEvent();
			virtualMachine.resume();
		} catch (VMDisconnectedException e) {
			// suppress any actions after the vm is disconnected
		}
	}

	/**
	 * @return the connection that allows querying the state of the runtime
	 *         running in the virtual machine
	 */
	public VirtualMachineBrowser getVMBrowser() {
		return vmBrowser;
	}

	VirtualMachine getVirtualMachine() {
		return virtualMachine;
	}
}
