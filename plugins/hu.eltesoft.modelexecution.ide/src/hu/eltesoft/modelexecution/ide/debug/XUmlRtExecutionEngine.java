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
	private AnimationController animationController;

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
		animationController = new AnimationController(configReader);

		resourceSet = eObjectToExecute.eResource().getResourceSet();
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
		// intentionally left blank
	}

	@Override
	public void handleVMDeath(VMDeathEvent event) {
		// intentionally left blank
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
			waitingForSuspend = false;
			animationController.setSuspendedMarker(modelElement);
			markThreadAsSuspended();
			return ThreadAction.RemainSuspended;
		}

		if (animationController.getAnimate()) {
			animationController.setAnimationMarker(modelElement);
			animationController.suspendForAnimation();
			animationController.removeAnimationMarker();
		}
		return ThreadAction.ShouldResume;
	}

	/**
	 * Marks the thread and the debug target as suspended.
	 */
	private void markThreadAsSuspended() {
		try {
			// suspend just the first and only thread for now
			MokaThread mokaThread = (MokaThread) debugTarget.getThreads()[0];
			// causes debug target to be suspended
			sendEvent(new Suspend_Event(mokaThread, DebugEvent.STEP_END,
					new MokaThread[] { mokaThread }));
			// causes thread to be suspended
			mokaThread.setSuspended(true);
		} catch (DebugException e) {
			IdePlugin.logError("Error while marking thread as suspended", e);
		}
	}

	@Override
	public void resume(Resume_Request request) {
		virtualMachine.resume();
	}

	@Override
	public void suspend(Suspend_Request request) {
		// this stops at the next breakpoint in the handler
		waitingForSuspend = true;
	}

	@Override
	public void terminate(Terminate_Request request) {
		performShutdown();
		try {
			virtualMachine.terminate();
		} catch (DebugException e) {
			IdePlugin.logError("Error while terminating debug target", e);
		}
	}

	@Override
	public void disconnect() {
		performShutdown();
		virtualMachine.disconnect();
	}

	private void performShutdown() {
		setIsTerminated(true);
		animationController.removeAllMarkers();
	}

	@Override
	public MokaThread[] getThreads() {
		MokaThread mokaThread = new MokaThread(debugTarget);
		mokaThread.setName("Default component");
		return new MokaThread[] { mokaThread };
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
