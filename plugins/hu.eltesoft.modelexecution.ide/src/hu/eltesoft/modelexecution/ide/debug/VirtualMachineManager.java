package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.VMEventListener.ThreadAction;
import hu.eltesoft.modelexecution.ide.launch.BackgroundJavaLauncher.BackgroundJavaProcess;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.ITerminate;

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
import com.sun.jdi.request.ClassPrepareRequest;
import com.sun.jdi.request.EventRequest;
import com.sun.jdi.request.EventRequestManager;

@SuppressWarnings("restriction")
public class VirtualMachineManager implements ITerminate {

	private Thread eventHandlerThread;
	private VirtualMachine virtualMachine;
	private BackgroundJavaProcess javaProcess;

	private List<VMEventListener> vmEventListeners = new LinkedList<>();

	public VirtualMachineManager(ILaunch launch) {
		javaProcess = getJavaProcess(launch);
		virtualMachine = javaProcess.getVM();

		eventHandlerThread = createEventHandlerThread();
		eventHandlerThread.start();
	}

	/**
	 * Gets the background java virtual machine that operates in debug mode.
	 */
	private BackgroundJavaProcess getJavaProcess(ILaunch launch) {
		for (IProcess process : launch.getProcesses()) {
			if (process instanceof BackgroundJavaProcess) {
				return (BackgroundJavaProcess) process;
			}
		}
		return null;
	}

	public void addVMEventListener(VMEventListener listener) {
		if (vmEventListeners.contains(listener)) {
			return;
		}
		vmEventListeners.add(listener);

		// enable class prepare requests
		EventRequestManager manager = virtualMachine.eventRequestManager();
		ClassPrepareRequest request = manager.createClassPrepareRequest();
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
					// vm is terminated
				} catch (Exception e) {
					IdePlugin.logError(
							"Exception while processing VirtualMachine events",
							e);
				}
			}

			private void dispatchEvent(Event event) {
				if (event instanceof VMStartEvent) {
					fireVMStartEvent((VMStartEvent) event);
				} else if (event instanceof VMDisconnectEvent) {
					fireVMDisconnectEvent((VMDisconnectEvent) event);
					// stop on vm disconnect (not always received)
					stop();
				} else if (event instanceof VMDeathEvent) {
					fireVMDeathEvent((VMDeathEvent) event);
					// stop on vm death (not always received)
					stop();
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
		vmEventListeners.forEach(l -> l.handleVMStart(event));
	}

	private void fireVMDisconnectEvent(VMDisconnectEvent event) {
		vmEventListeners.forEach(l -> l.handleVMDisconnect(event));
	}

	private void fireVMDeathEvent(VMDeathEvent event) {
		vmEventListeners.forEach(l -> l.handleVMDeath(event));
	}

	private void fireClassPrepareEvent(ClassPrepareEvent event) {
		vmEventListeners.forEach(l -> l.handleClassPrepare(event));
	}

	protected boolean fireBreakpointEvent(BreakpointEvent event) {
		ThreadAction action = ThreadAction.ShouldResume;
		for (VMEventListener listener : vmEventListeners) {
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
}
