package hu.eltesoft.modelexecution.ide.debug;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.debug.MokaVariable;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.common.launch.LaunchConfig;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineManager;
import hu.eltesoft.modelexecution.ide.debug.model.StateMachineInstance;
import hu.eltesoft.modelexecution.ide.debug.model.XUMLRTDebugTarget;
import hu.eltesoft.modelexecution.ide.debug.ui.AnimationController;
import hu.eltesoft.modelexecution.ide.debug.ui.DebugViewController;
import hu.eltesoft.modelexecution.ide.debug.util.XUMLRTSourceLocator;

/**
 * Execution engine for Moka.
 * 
 * Communicates with the moka system by events and with the runtime by the
 * control thread.
 */
public class XUmlRtExecutionEngine extends AbstractExecutionEngine implements IExecutionEngine {

	private static final String DEFAULT_STRATUM_NAME = "xUML-rt"; //$NON-NLS-1$

	/**
	 * Synchronization, timing and cleanup of animation is performed by this
	 * class
	 */
	private AnimationController animation;

	private XUMLRTDebugTarget xumlrtDebugTarget;

	/** Direct control over the virtual machine running the runtime */
	private VirtualMachineManager virtualMachine;

	/** Access the state of the debug control buttons */
	private final DebugViewController debugControl = new DebugViewController();

	private ExecutionEngineVMConnection virtualMachineHandler;

	@Override
	public void init(EObject eObjectToExecute, String[] args, MokaDebugTarget mokaDebugTarget, int requestPort,
			int replyPort, int eventPort) throws UnknownHostException, IOException {
		super.init(eObjectToExecute, args, mokaDebugTarget, requestPort, replyPort, eventPort);

		debugTarget.setName(Messages.XUmlRtExecutionEngine_debug_model_label);

		ILaunch launch = debugTarget.getLaunch();

		int xumlRTDelay = LaunchConfig.getAnimationTimerMultiplier(launch.getLaunchConfiguration());
		animation = new AnimationController(xumlRTDelay);
		virtualMachine = new VirtualMachineManager(launch);
		virtualMachine.setDefaultStratum(DEFAULT_STRATUM_NAME);

		xumlrtDebugTarget = new XUMLRTDebugTarget(virtualMachine.getVMBrowser(), this,
				eObjectToExecute.eResource().getResourceSet(), launch);
		launch.addDebugTarget(xumlrtDebugTarget);
		launch.setSourceLocator(new XUMLRTSourceLocator());

		try {
			IProject project = LaunchConfig.getProject(debugTarget.getLaunch().getLaunchConfiguration());
			virtualMachineHandler = new ExecutionEngineVMConnection(xumlrtDebugTarget, project, eObjectToExecute,
					virtualMachine, animation);
		} catch (CoreException e) {
			PluginLogger.logError("Error while retrieving project", e);
		}
	}

	@Override
	public void initializeArguments(String[] args) {
		// intentionally left blank
	}

	@Override
	public void addBreakpoint(MokaBreakpoint breakpoint) {
		xumlrtDebugTarget.addBreakpoint(breakpoint);
	}

	@Override
	public void removeBreakpoint(MokaBreakpoint breakpoint) {
		xumlrtDebugTarget.removeBreakpoint(breakpoint);
	}

	@Override
	public void resume(Resume_Request request) {
		synchronized (animation) {
			if (!virtualMachine.isSuspendedAtBreakpoint()) {
				// another earlier request already resumed the virtual machine
				return;
			}

			xumlrtDebugTarget.resumed();
			EObject removed = animation.removeSuspendedMarker();
			animateElementThatWasSuspended(removed);
			virtualMachineHandler.resume();
			virtualMachine.resume();

			if (DebugEvent.CLIENT_REQUEST != request.getResumeDetail()) {
				// this is a stepping request, just suspend again
				suspend(null);
			}
		}
	}

	private void animateElementThatWasSuspended(EObject element) {
		if (element != null) {
			StateMachineInstance suspendedSMInstance = xumlrtDebugTarget.getSuspendedSMInstance();
			Object[] selectedDebugElements = debugControl.getSelectedDebugElements();
			if (Arrays.asList(selectedDebugElements).contains(suspendedSMInstance)) {
				animation.setAnimationMarker(element, suspendedSMInstance);
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
			xumlrtDebugTarget.terminated();
		} catch (DebugException e) {
			PluginLogger.logError("Error while terminating debug target", e); //$NON-NLS-1$
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
		return new MokaThread[0];
	}

	@Override
	public IStackFrame[] getStackFrames(IThread thread) {
		return new IStackFrame[0];
	}

	@Override
	public IVariable[] getVariables(IDebugElement stackFrameOrValue) {
		return new MokaVariable[0];
	}

	@Override
	public IRegisterGroup[] getRegisterGroups(IStackFrame stackFrame) {
		return new IRegisterGroup[0];
	}

	public XUMLRTDebugTarget getXUmlRtDebugTarget() {
		return xumlrtDebugTarget;
	}

	/**
	 * This override is necessary because the original method sends events to
	 * the {@link DebugPlugin} that changes the selection in the debug view.
	 */
	@Override
	protected void resume_reply(String message) {
		Resume_Request request = Marshaller.getInstance().resume_request_unmarshal(message);
		this.resume(request);
	}

	/**
	 * This override is necessary because the original method sends events to
	 * the {@link DebugPlugin} that changes the selection in the debug view.
	 */
	@Override
	protected void suspend_reply(String message) {
		Suspend_Request request = Marshaller.getInstance().suspend_request_unmarshal(message);
		this.suspend(request);
	}

}
