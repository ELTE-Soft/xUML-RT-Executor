package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.registry.BreakpointRegistry;
import hu.eltesoft.modelexecution.ide.debug.registry.ModelElementsRegistry;
import hu.eltesoft.modelexecution.ide.debug.registry.SymbolsRegistry;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.TimerTask;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Suspend_Event;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;

import com.sun.jdi.ReferenceType;
import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;

/**
 * Execution engine for Moka.
 */
@SuppressWarnings("restriction")
public class XUmlRtExecutionEngine extends AbstractExecutionEngine implements
		IExecutionEngine, VMEventListener {

	private static final String DEBUG_TARGET_NAME = "xUML-Rt Model";
	private static final String DEFAULT_STRATUM_NAME = "xUML-rt";

	private LaunchConfigReader configReader;
	private AnimationController animation;

	private ResourceSet resourceSet;
	private ModelElementsRegistry elementRegistry;

	private SymbolsRegistry symbolsRegistry;
	private LocationConverter locationConverter;

	private BreakpointRegistry breakpoints;
	private VirtualMachineManager virtualMachine;

	private boolean waitingForSuspend = false;

	@Override
	public void init(EObject eObjectToExecute, String[] args,
			MokaDebugTarget mokaDebugTarget, int requestPort, int replyPort,
			int eventPort) throws UnknownHostException, IOException {
		super.init(eObjectToExecute, args, mokaDebugTarget, requestPort,
				replyPort, eventPort);

		debugTarget.setName(DEBUG_TARGET_NAME);

		ILaunch launch = debugTarget.getLaunch();
		configReader = new LaunchConfigReader(launch);
		animation = new AnimationController(configReader);

		resourceSet = eObjectToExecute.eResource().getResourceSet();
		new FilePathResourceLocator(resourceSet);
		elementRegistry = new ModelElementsRegistry(eObjectToExecute);

		IProject project = configReader.getProject();
		String directory = ExecutableModelProperties.getDebugFilesPath(project);
		IPath debugSymbolsDir = project.getLocation().append(directory);
		symbolsRegistry = new SymbolsRegistry(debugSymbolsDir);
		locationConverter = new LocationConverter(symbolsRegistry);

		breakpoints = new BreakpointRegistry();
		virtualMachine = new VirtualMachineManager(launch);
		virtualMachine.setDefaultStratum(DEFAULT_STRATUM_NAME);
		virtualMachine.addVMEventListener(this);
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
	public void handleVMStart(VMStartEvent event) {
		// intentionally left blank
	}

	@Override
	public void handleVMDisconnect(VMDisconnectEvent event) {
		terminate();
	}

	@Override
	public void handleVMDeath(VMDeathEvent event) {
		terminate();
	}

	@Override
	public void handleClassPrepare(ClassPrepareEvent event) {
		ReferenceType referenceType = event.referenceType();
		String className = referenceType.name();

		Set<EObject> elements = elementRegistry.get(className);
		if (null != elements) {
			locationConverter.registerClass(referenceType);
			elements.forEach(this::addVMBreakpoint);
		}
	}

	/**
	 * The breakpoint is set on the related file. It is assumed that the file is
	 * already loaded into the virtual machine.
	 * 
	 * @param modelElement
	 */
	private void addVMBreakpoint(EObject modelElement) {
		locationConverter.locationsFor(modelElement).forEach(
				virtualMachine::addBreakpoint);
	}

	@Override
	public ThreadAction handleBreakpoint(BreakpointEvent event) {
		com.sun.jdi.Location stoppedAt = event.location();
		Reference reference = locationConverter.referenceFor(stoppedAt);
		EObject modelElement = reference.resolve(resourceSet);

		boolean mustBreak = breakpoints.hasEnabledBreakpointOn(modelElement);
		if (mustBreak || waitingForSuspend) {
			markThreadAsSuspended(modelElement);
			return ThreadAction.RemainSuspended;
		}

		if (animation.getAnimate()) {
			animation.setAnimationMarker(modelElement);
			animation.suspendForAnimation(new TimerTask() {

				@Override
				public void run() {
					synchronized (animation) {
						animation.removeAnimationMarker();

						if (waitingForSuspend) {
							markThreadAsSuspended(modelElement);
						} else {
							try {
								virtualMachine.resume();
							} catch (VMDisconnectedException e) {
								// intentionally left blank
								// the vm was stopped during the timer
							}
						}
					}
				}
			});
			return ThreadAction.RemainSuspended;
		}

		animation.removeAllMarkers();
		return ThreadAction.ShouldResume;
	}

	/**
	 * Marks the thread and the debug target as suspended.
	 * 
	 * @param modelElement
	 *            the current element under the breakpoint (currently only a
	 *            state or transition)
	 */
	private void markThreadAsSuspended(EObject modelElement) {
		animation.setSuspendedMarker(modelElement);

		try {
			// suspend just the first and only thread for now
			MokaThread mokaThread = (MokaThread) debugTarget.getThreads()[0];
			// causes debug target to be suspended
			int eventCode = waitingForSuspend ? DebugEvent.CLIENT_REQUEST
					: DebugEvent.BREAKPOINT;
			sendEvent(new Suspend_Event(mokaThread, eventCode,
					new MokaThread[] { mokaThread }));
			// causes thread to be suspended
			mokaThread.setSuspended(true);
		} catch (DebugException e) {
			IdePlugin.logError("Error while marking thread as suspended", e);
		}

		waitingForSuspend = false;
	}

	@Override
	public void resume(Resume_Request request) {
		synchronized (animation) {
			waitingForSuspend = false;
			virtualMachine.resume();
		}

		if (DebugEvent.CLIENT_REQUEST != request.getResumeDetail()) {
			// this is a stepping request, just suspend again
			suspend(null);
		}
	}

	@Override
	public void suspend(Suspend_Request request) {
		synchronized (animation) {
			// this stops at the next breakpoint in the handler
			waitingForSuspend = true;

			if (!animation.getAnimate()) {
				return;
			}

			// stop the animation timer and run its ending task immediately
			animation.stopSuspendingForAnimation();
		}
	}

	@Override
	public void terminate(Terminate_Request request) {
		terminate();
	}

	private void terminate() {
		performShutdown();
		try {
			virtualMachine.terminate();
		} catch (DebugException e) {
			IdePlugin.logError("Error while terminating debug target", e);
		}
	}

	private void performShutdown() {
		setIsTerminated(true);
		animation.removeAllMarkers();
	}

	@Override
	public void disconnect() {
		performShutdown();
		virtualMachine.disconnect();
	}

	@Override
	public MokaThread[] getThreads() {
		MokaThread thread = new MokaThread(debugTarget);
		thread.setName("Default component");
		return new MokaThread[] { thread };
	}

	@Override
	public IStackFrame[] getStackFrames(IThread thread) {
		return new IStackFrame[0];
	}

	@Override
	public IVariable[] getVariables(IDebugElement stackFrameOrValue) {
		return new IVariable[0];
	}

	@Override
	public IRegisterGroup[] getRegisterGroups(IStackFrame stackFrame) {
		return new IRegisterGroup[0];
	}
}
