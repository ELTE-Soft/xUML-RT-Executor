package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.registry.BreakpointRegistry;
import hu.eltesoft.modelexecution.ide.debug.registry.ModelElementsRegistry;
import hu.eltesoft.modelexecution.ide.debug.registry.SymbolsRegistry;
import hu.eltesoft.modelexecution.ide.debug.ui.AnimationController;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtStackFrame;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtThread;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;
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
import org.eclipse.papyrus.moka.debug.MokaVariable;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;
import org.eclipse.uml2.uml.NamedElement;

import com.sun.jdi.ReferenceType;
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
		IExecutionEngine, VirtualMachineListener {

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

	// access must be synchronized to intrinsic lock of "animation"!
	private boolean waitingForSuspend = false;

	private MokaThread[] threads;

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
		virtualMachine.addEventListener(this);
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
		try {
			// force the debug target to send a termination request,
			// which will be handled by the terminate method below
			debugTarget.terminate();
		} catch (DebugException e) {
			IdePlugin.logError("Error while terminating debug target", e);
		}
	}

	@Override
	public void handleVMDeath(VMDeathEvent event) {
		// intentionally left blank
		// this is an optional notification before a disconnect event
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
		animation.cancelAnimationTimer();
		animation.removeAllMarkers();

		com.sun.jdi.Location stoppedAt = event.location();
		Reference reference = locationConverter.referenceFor(stoppedAt);
		EObject modelElement = reference.resolve(resourceSet);

		boolean hasBreak = breakpoints.hasEnabledBreakpointOn(modelElement);
		if (suspendIfWaitingOrHasBreak(modelElement, hasBreak)) {
			return ThreadAction.RemainSuspended;
		}

		if (animation.getAnimate()) {
			animation.setAnimationMarker(modelElement);
			animation.startAnimationTimer(new TimerTask() {

				@Override
				public void run() {
					if (!suspendIfWaitingOrHasBreak(modelElement, false)) {
						virtualMachine.resume();
					}
				}
			});
			return ThreadAction.RemainSuspended;
		}

		return ThreadAction.ShouldResume;
	}

	/**
	 * Suspends the current thread if there was a user-defined breakpoint here
	 * or a previous suspension request was waiting for the next JDI breakpoint.
	 *
	 * @param modelElement
	 *            the current element under the breakpoint
	 * @param hasBreak
	 *            whether there is a user-defined breakpoint on the element
	 * @return true when the thread has to remain in a suspended state
	 */
	private boolean suspendIfWaitingOrHasBreak(EObject modelElement,
			boolean hasBreak) {
		synchronized (animation) {
			if (waitingForSuspend || hasBreak) {
				markThreadAsSuspended(modelElement);
				waitingForSuspend = false;
				return true;
			}
			return false;
		}
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

		// suspend just the first and only thread for now
		MokaThread thread = (MokaThread) getThreads()[0];

		// show the current element as a stack frame
		XUmlRtStackFrame frame = new XUmlRtStackFrame(debugTarget,
				(NamedElement) modelElement);
		frame.setThread(thread);
		thread.setStackFrames(new IStackFrame[] { frame });

		// causes debug target to be suspended
		int eventCode = waitingForSuspend ? DebugEvent.CLIENT_REQUEST
				: DebugEvent.BREAKPOINT;
		sendEvent(new Suspend_Event(thread, eventCode,
				new MokaThread[] { thread }));

		// causes thread to be suspended
		thread.setSuspended(true);
	}

	@Override
	public void resume(Resume_Request request) {
		synchronized (animation) {
			// remove stack frames from all threads before resuming
			Arrays.stream(threads).forEach(
					t -> t.setStackFrames(new IStackFrame[0]));

			waitingForSuspend = false;
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
			waitingForSuspend = true;

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
		} catch (DebugException e) {
			IdePlugin.logError("Error while terminating debug target", e);
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
		if (null == threads) {
			XUmlRtThread thread = new XUmlRtThread(debugTarget);
			thread.setName("Default component");
			threads = new MokaThread[] { thread };
		}
		return threads;
	}

	@Override
	public IStackFrame[] getStackFrames(IThread thread) {
		return new XUmlRtStackFrame[0];
	}

	@Override
	public IVariable[] getVariables(IDebugElement stackFrameOrValue) {
		return new MokaVariable[0];
	}

	@Override
	public IRegisterGroup[] getRegisterGroups(IStackFrame stackFrame) {
		return new IRegisterGroup[0];
	}
}
