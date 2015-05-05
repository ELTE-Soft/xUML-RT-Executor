package hu.eltesoft.modelexecution.ide.debug;

import java.util.LinkedList;
import java.util.List;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.launch.BackgroundJavaLauncher.BackgroundJavaProcess;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.ITerminate;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;

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

@SuppressWarnings("restriction")
public class WrappedVirtualMachine implements ITerminate {

	private Thread eventHandlerThread;
	private VirtualMachine virtualMachine;
	private BackgroundJavaProcess javaProcess;

	private List<VMStartEventListener> vmStartListeners = new LinkedList<>();
	private List<ClassPrepareEventListener> classPrepareListeners = new LinkedList<>();
	private List<VMDeathEventListener> vmDeathListeners = new LinkedList<>();
	private List<BreakpointEventListener> breakpointListeners = new LinkedList<>();
	private List<VMDisconnectEventListener> vmDisconnectListeners = new LinkedList<>();

	public WrappedVirtualMachine(MokaDebugTarget debugTarget) {
		eventHandlerThread = createEventHandlerThread();
		eventHandlerThread.start();

		javaProcess = getJavaProcess(debugTarget);
		virtualMachine = getVirtualMachine(debugTarget);
	}

	/**
	 * Gets the VirtualMachine object that acts as an interface to the
	 * background java virtual machine that operates in debug mode.
	 */
	private VirtualMachine getVirtualMachine(MokaDebugTarget mokaDebugTarget) {
		return getJavaProcess(mokaDebugTarget).getVM();
	}

	/**
	 * Gets the background java virtual machine that operates in debug mode.
	 */
	private BackgroundJavaProcess getJavaProcess(MokaDebugTarget mokaDebugTarget) {
		for (IProcess process : mokaDebugTarget.getLaunch().getProcesses()) {
			if (process instanceof BackgroundJavaProcess) {
				return (BackgroundJavaProcess) process;
			}
		}
		return null;
	}

	public void setDefaultStratum(String defaultStratumName) {
		virtualMachine.setDefaultStratum(defaultStratumName);
	}

	public enum ThreadContinue {
		Resume(true), RemainSuspended(false);
		private boolean resume;

		private ThreadContinue(boolean resume) {
			this.resume = resume;
		}

		public boolean getResume() {
			return resume;
		}
	}

	/**
	 * Starts a thread that eats all events from the virtual machine and calls
	 * the corresponding function.
	 */
	private Thread createEventHandlerThread() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						boolean resume = true;
						EventSet events = virtualMachine.eventQueue().remove();
						for (Event event : events) {
							if (event instanceof VMStartEvent) {
								resume &= fireVMStartEvent((VMStartEvent) event);
							} else if (event instanceof ClassPrepareEvent) {
								resume &= fireClassPrepareEvent((ClassPrepareEvent) event);
							} else if (event instanceof BreakpointEvent) {
								resume &= fireBreakpointEvent((BreakpointEvent) event);
							} else if (event instanceof VMDisconnectEvent) {
								resume &= fireVMDisconnectEvent((VMDisconnectEvent) event);
								// stop on vm disconnect (not always received)
								return;
							} else if (event instanceof VMDeathEvent) {
								resume &= fireVMDeathEvent((VMDeathEvent) event);
								// stop on vm death (not always received)
								return;
							}
						}
						if (resume) {
							events.resume();
						}
					}
				} catch (VMDisconnectedException e) {
					// vm is terminated
					return;
				} catch (Exception e) {
					IdePlugin.logError(
							"Exception while processing VirtualMachine events",
							e);
				}

			}
		});
	}

	protected boolean fireVMDeathEvent(VMDeathEvent event) {
		boolean resume = true;
		for (VMDeathEventListener listener : vmDeathListeners) {
			resume &= listener.vmDeath(event).getResume();
		}
		return resume;
	}

	protected boolean fireVMStartEvent(VMStartEvent event) {
		boolean resume = true;
		for (VMStartEventListener listener : vmStartListeners) {
			resume &= listener.vmStart(event).getResume();
		}
		return resume;
	}

	protected boolean fireVMDisconnectEvent(VMDisconnectEvent event) {
		boolean resume = true;
		for (VMDisconnectEventListener listener : vmDisconnectListeners) {
			resume &= listener.vmDisconnect(event).getResume();
		}
		return resume;
	}

	protected boolean fireBreakpointEvent(BreakpointEvent event) {
		boolean resume = true;
		for (BreakpointEventListener listener : breakpointListeners) {
			resume &= listener.breakpointHit(event).getResume();
		}
		return resume;
	}

	protected boolean fireClassPrepareEvent(ClassPrepareEvent event) {
		boolean resume = true;
		for (ClassPrepareEventListener listener : classPrepareListeners) {
			resume &= listener.classPrepare(event).getResume();
		}
		return resume;
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
		virtualMachine.resume();
	}

	public void suspend() {
		virtualMachine.suspend();
	}

	public void disconnect() {
		virtualMachine.dispose();
	}

	public void addClassPrepareListener(ClassPrepareEventListener listener) {
		ClassPrepareRequest request = virtualMachine.eventRequestManager()
				.createClassPrepareRequest();
		request.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		request.enable();
		classPrepareListeners.add(listener);
	}

	public void addBreakpointListener(com.sun.jdi.Location jdiLocation,
			BreakpointEventListener listener) {
		BreakpointRequest request = virtualMachine.eventRequestManager()
				.createBreakpointRequest(jdiLocation);
		request.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		request.enable();
		if (!breakpointListeners.contains(listener)) {
			breakpointListeners.add(listener);
		}
	}

}
