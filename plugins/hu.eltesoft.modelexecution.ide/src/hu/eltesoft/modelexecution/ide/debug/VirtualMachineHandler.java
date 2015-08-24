package hu.eltesoft.modelexecution.ide.debug;

import java.util.Set;
import java.util.TimerTask;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Suspend_Event;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.uml2.uml.NamedElement;

import com.sun.jdi.ReferenceType;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineConnection;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineListener;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineManager;
import hu.eltesoft.modelexecution.ide.debug.model.BreakpointStoppedStackFrame;
import hu.eltesoft.modelexecution.ide.debug.model.PausedStackFrame;
import hu.eltesoft.modelexecution.ide.debug.model.XUmlRtStateMachineInstance;
import hu.eltesoft.modelexecution.ide.debug.registry.BreakpointRegistry;
import hu.eltesoft.modelexecution.ide.debug.registry.ModelElementsRegistry;
import hu.eltesoft.modelexecution.ide.debug.registry.SymbolsRegistry;
import hu.eltesoft.modelexecution.ide.debug.ui.AnimationController;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

/**
 * Communicates with the runtime through the JDI. Maintains the JDI's list of
 * breakpoints. Suspends threads when the VM is stoppend on breakpoints.
 */
@SuppressWarnings("restriction")
public final class VirtualMachineHandler implements VirtualMachineListener {

	/** Link to the execution engine connected to the vm. */
	private final XUmlRtExecutionEngine executionEngine;

	/**
	 * For deciding which model elements have been loaded to the runtime in case
	 * of a class prepared event.
	 */
	private final ModelElementsRegistry elementRegistry;

	/**
	 * For converting breakpoint locations between model and generated java
	 * source locations
	 */
	private final LocationConverter locationConverter;

	/** For getting details about debug model elements */
	private final VirtualMachineConnection virtualMachineConnection;

	/** To look up EObjects for animation */
	private ResourceSet resourceSet;

	/** Access must be synchronized to intrinsic lock of "animation"! */
	private boolean waitingForSuspend = false;

	/** Direct control over the virtual machine */
	private VirtualMachineManager virtualMachine;

	/** For animating when stopped on breakpoint */
	private AnimationController animation;

	private BreakpointRegistry breakpoints;

	public VirtualMachineHandler(XUmlRtExecutionEngine xUmlRtExecutionEngine, EObject eObjectToExecute,
			LaunchConfigReader configReader, VirtualMachineManager virtualMachine, AnimationController animation,
			BreakpointRegistry breakpoints) {
		this.virtualMachine = virtualMachine;
		this.animation = animation;
		this.breakpoints = breakpoints;
		virtualMachineConnection = virtualMachine.createConnection();
		resourceSet = eObjectToExecute.eResource().getResourceSet();
		// the constructor sets itself as resource locator for the resource set
		new FilePathResourceLocator(resourceSet);
		executionEngine = xUmlRtExecutionEngine;
		IProject project = configReader.getProject();
		String directory = ExecutableModelProperties.getDebugFilesPath(project);
		IPath debugSymbolsDir = project.getLocation().append(directory);
		SymbolsRegistry symbolsRegistry = new SymbolsRegistry(debugSymbolsDir);
		this.locationConverter = new LocationConverter(symbolsRegistry);
		this.elementRegistry = new ModelElementsRegistry(eObjectToExecute);
	}

	@Override
	public void handleVMStart(VMStartEvent event) {
		// intentionally left blank
	}

	@Override
	public void handleVMDisconnect(VMDisconnectEvent event) {
		forceTermination();
	}

	/**
	 * Force the debug target to send a termination request, which will be
	 * handled by {@linkplain XUmlRtExecutionEngine#terminate}
	 */
	private void forceTermination() {
		try {
			executionEngine.getDebugTarget().terminate();
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
		locationConverter.locationsFor(modelElement).forEach(virtualMachine::addBreakpoint);
	}

	@Override
	public ThreadAction handleBreakpoint(BreakpointEvent event) {
		animation.cancelAnimationTimer();
		animation.removeAllMarkers();

		com.sun.jdi.Location stoppedAt = event.location();
		Reference reference = locationConverter.referenceFor(stoppedAt);
		EObject modelElement = reference.resolve(resourceSet);
		if (null == modelElement) {
			// forces the termination when the editor is closed
			forceTermination();
			return ThreadAction.ShouldResume;
		}

		boolean hasBreak = breakpoints.hasEnabledBreakpointOn(modelElement);
		if (suspendIfWaitingOrHasBreak(modelElement, hasBreak)) {
			return ThreadAction.RemainSuspended;
		}

		if (animation.getAnimate()) {
			synchronized (animation) {
				return animateIfSelected(modelElement);
			}
		}
		return ThreadAction.ShouldResume;
	}

	private ThreadAction animateIfSelected(EObject modelElement) {
		if (actualSMInstanceIsSelected()) {
			animation.setAnimationMarker(modelElement);
			animation.startAnimationTimer(new TimerTask() {

				@Override
				public void run() {
					virtualMachine.resume();
				}
			});
			return ThreadAction.RemainSuspended;
		} else {
			return ThreadAction.ShouldResume;
		}
	}

	private boolean actualSMInstanceIsSelected() {
		try {
			String actualSMInstance = virtualMachineConnection.getActualSMInstance();
			for (Object debugElem : XUmlRtDebugModelPresentation.getSelectedDebugElements()) {
				if (debugElem instanceof XUmlRtStateMachineInstance) {
					XUmlRtStateMachineInstance smInstance = (XUmlRtStateMachineInstance) debugElem;
					if (smInstance.getName().equals(actualSMInstance)) {
						return true;
					}
				}
			}
		} catch (DebugException e) {
			IdePlugin.logError("Error while animating", e);
		}
		return false;
	}

	/**
	 * Suspends the current thread if there was a user-defined breakpoint here
	 * or a previous suspension request was waiting for the next JDI breakpoint.
	 * Can only be called when the underlying virtual machine is suspended.
	 *
	 * @param modelElement
	 *            the current element under the breakpoint
	 * @param hasBreak
	 *            whether there is a user-defined breakpoint on the element
	 * @return true when the thread has to remain in a suspended state
	 */
	private boolean suspendIfWaitingOrHasBreak(EObject modelElement, boolean hasBreak) {
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
	 * Marks each state machine as suspended. Can only be called when the
	 * underlying virtual machine is suspended.
	 *
	 * @param modelElement
	 *            the current element under the breakpoint (currently only a
	 *            state or transition)
	 */
	private void markThreadAsSuspended(EObject modelElement) {
		animation.setSuspendedMarker(modelElement);

		String actualSMInstance = virtualMachineConnection.getActualSMInstance();
		try {
			for (XUmlRtStateMachineInstance smInstance : executionEngine.getSmInstances()) {
				MokaStackFrame stackFrame;
				if (smInstance.getName().equals(actualSMInstance)) {
					stackFrame = new BreakpointStoppedStackFrame(executionEngine.getDebugTarget(), smInstance,
							(NamedElement) modelElement);
					virtualMachineConnection.addEventVariable(stackFrame);
				} else {
					stackFrame = new PausedStackFrame(smInstance);
				}
				smInstance.setStackFrames(new IStackFrame[] { stackFrame });
				virtualMachineConnection.loadDataOfSMInstance(stackFrame, resourceSet);
				int eventCode = waitingForSuspend ? DebugEvent.CLIENT_REQUEST : DebugEvent.BREAKPOINT;
				executionEngine.sendEvent(new Suspend_Event(smInstance, eventCode, executionEngine.getThreads()));
				smInstance.setSuspended(true);
			}
		} catch (DebugException e) {
			IdePlugin.logError("Error while updating sm instances");
		}
	}

	/**
	 * Puts the handler in suspending mode where it stops on each possible
	 * point.
	 */
	public void waitForSuspend() {
		waitingForSuspend = true;
	}

	/**
	 * Orders the handler to continue running, don't stop on the next
	 * breakpoint.
	 */
	public void resume() {
		waitingForSuspend = false;
	}
}