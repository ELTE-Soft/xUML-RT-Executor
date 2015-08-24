package hu.eltesoft.modelexecution.ide.debug;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.debug.MokaVariable;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.debug.jvm.StateMachnineInstanceListener;
import hu.eltesoft.modelexecution.ide.debug.jvm.RuntimeControllerClient;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineManager;
import hu.eltesoft.modelexecution.ide.debug.model.XUmlRtStateMachineInstance;
import hu.eltesoft.modelexecution.ide.debug.registry.BreakpointRegistry;
import hu.eltesoft.modelexecution.ide.debug.ui.AnimationController;
import hu.eltesoft.modelexecution.ide.debug.util.LaunchConfigReader;
import hu.eltesoft.modelexecution.ide.launch.process.IProcessWithController;

/**
 * Execution engine for Moka.
 * 
 * Communicates with the moka system by events and with the runtime by the
 * control thread.
 */
public class XUmlRtExecutionEngine extends AbstractExecutionEngine implements IExecutionEngine {

	private static final String DEFAULT_STRATUM_NAME = "xUML-rt"; //$NON-NLS-1$

	/** Synchronization, timing and cleanup of animation is performed by this class */
	private AnimationController animation;

	private BreakpointRegistry breakpoints;
	
	/** Direct control over the virtual machine running the runtime */
	private VirtualMachineManager virtualMachine;

	/** The state machine instances (threads) in the debug model */
	private final List<XUmlRtStateMachineInstance> smInstances = new LinkedList<>();
	
	private VirtualMachineHandler virtualMachineHandler;

	@Override
	public void init(EObject eObjectToExecute, String[] args, MokaDebugTarget mokaDebugTarget, int requestPort,
			int replyPort, int eventPort) throws UnknownHostException, IOException {
		super.init(eObjectToExecute, args, mokaDebugTarget, requestPort, replyPort, eventPort);

		debugTarget.setName(Messages.XUmlRtExecutionEngine_debug_model_label);

		ILaunch launch = debugTarget.getLaunch();
		LaunchConfigReader configReader = new LaunchConfigReader(launch);
		animation = new AnimationController(configReader);
		breakpoints = new BreakpointRegistry();
		virtualMachine = new VirtualMachineManager(launch);
		virtualMachine.setDefaultStratum(DEFAULT_STRATUM_NAME);
		virtualMachineHandler = new VirtualMachineHandler(this, eObjectToExecute, configReader, virtualMachine,
				animation, breakpoints);
		virtualMachine.addEventListener(virtualMachineHandler);

		setupControllerListeners(launch);
	}

	/**
	 * Sets up event handlers for changes reported by the runtime.
	 */
	protected void setupControllerListeners(ILaunch launch) {
		for (IProcess process : launch.getProcesses()) {
			if (process instanceof IProcessWithController) {
				RuntimeControllerClient runtimeController = ((IProcessWithController) process).getController();
				if (runtimeController != null) {
					runtimeController.addStateMachineInstanceListener(new StateMachnineInstanceListener() {
						@Override
						public void instanceCreated(String classId, int instanceId, String originalName) {
							XUmlRtStateMachineInstance smInstance = new XUmlRtStateMachineInstance(debugTarget, classId,
									instanceId, originalName);
							smInstances.add(smInstance);
						}

						@Override
						public void instanceDestroyed(String classId, int instanceId) {
							smInstances
									.removeIf(t -> t.getClassId().equals(classId) && t.getInstanceId() == instanceId);
						}
					});
				}
			}
		}
	}

	@Override
	public void initializeArguments(String[] args) {
		// intentionally left blank
	}

	@Override
	public void addBreakpoint(MokaBreakpoint breakpoint) {
		breakpoints.add(breakpoint);
	}

	@Override
	public void removeBreakpoint(MokaBreakpoint breakpoint) {
		breakpoints.remove(breakpoint);
	}

	@Override
	public void resume(Resume_Request request) {
		synchronized (animation) {
			// remove stack frames from all threads before resuming
			smInstances.forEach(t -> t.setStackFrames(new IStackFrame[0]));

			virtualMachineHandler.resume();
			virtualMachine.resume();

			if (DebugEvent.CLIENT_REQUEST != request.getResumeDetail()) {
				// this is a stepping request, just suspend again
				suspend(null);
			}
		}
	}

	@Override
	public void suspend(Suspend_Request request) {
		synchronized (animation) {
			// this stops at the next breakpoint in the handler
			virtualMachineHandler.waitForSuspend();

			// end the current animation immediately
			animation.fireAnimationTimer();
		}
	}

	@Override
	public void terminate(Terminate_Request request) {
		try {
			// if the machine is already terminated,
			// it will not indicate a disconnect event
			virtualMachine.terminate();
			animation.removeAllMarkers();
		} catch (DebugException e) {
			IdePlugin.logError("Error while terminating debug target", e); //$NON-NLS-1$
		}

		// clear only after the machine's event queue is surely stopped
		animation.removeAllMarkers();

		// execution engine will send out the termination event automatically
		setIsTerminated(true);
	}

	@Override
	public void disconnect() {
		// intentionally left blank
		// disconnect command is disabled by default in the Moka debug target
	}

	@Override
	public MokaThread[] getThreads() {
		return smInstances.toArray(new MokaThread[smInstances.size()]);
	}

	public XUmlRtStateMachineInstance[] getSmInstances() {
		return smInstances.toArray(new XUmlRtStateMachineInstance[smInstances.size()]);
	}

	@Override
	public IStackFrame[] getStackFrames(IThread thread) {
		// stack frames are added directly to the state machine instances
		return new IStackFrame[0];
	}

	@Override
	public IVariable[] getVariables(IDebugElement stackFrameOrValue) {
		// variables are added directly to the stack frames and values
		return new MokaVariable[0];
	}

	@Override
	public IRegisterGroup[] getRegisterGroups(IStackFrame stackFrame) {
		// register groups are not used
		return new IRegisterGroup[0];
	}
}
