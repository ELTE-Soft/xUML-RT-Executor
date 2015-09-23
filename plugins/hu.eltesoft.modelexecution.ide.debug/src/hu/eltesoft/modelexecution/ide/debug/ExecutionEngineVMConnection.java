package hu.eltesoft.modelexecution.ide.debug;

import java.util.Set;
import java.util.TimerTask;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Pair;

import com.sun.jdi.ReferenceType;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.common.ProjectProperties;
import hu.eltesoft.modelexecution.ide.common.process.IProcessWithController;
import hu.eltesoft.modelexecution.ide.common.runtime.RuntimeControllerClient;
import hu.eltesoft.modelexecution.ide.common.runtime.StateMachnineInstanceListener;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineBrowser;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineListener;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineManager;
import hu.eltesoft.modelexecution.ide.debug.model.StateMachineInstance;
import hu.eltesoft.modelexecution.ide.debug.model.XUMLRTDebugTarget;
import hu.eltesoft.modelexecution.ide.debug.registry.LocationConverter;
import hu.eltesoft.modelexecution.ide.debug.registry.ModelElementsRegistry;
import hu.eltesoft.modelexecution.ide.debug.registry.SymbolsRegistry;
import hu.eltesoft.modelexecution.ide.debug.ui.AnimationController;
import hu.eltesoft.modelexecution.ide.debug.ui.DebugViewController;
import hu.eltesoft.modelexecution.ide.debug.util.FilePathResourceLocator;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

/**
 * Communicates with the runtime through the JDI. Maintains the JDI's list of
 * breakpoints. Suspends threads when the VM is stopped on breakpoints.
 */
@SuppressWarnings("restriction")
public final class ExecutionEngineVMConnection implements VirtualMachineListener {

	/** Link to the execution engine connected to the vm. */
	private final XUMLRTDebugTarget debugTarget;

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
	private final VirtualMachineBrowser virtualMachineBrowser;

	/** To look up EObjects for animation */
	private final ResourceSet resourceSet;

	/** Direct control over the virtual machine */
	private final VirtualMachineManager virtualMachine;

	/** For animating when stopped on breakpoint */
	private final AnimationController animation;

	/** Access the state of the debug control buttons */
	private final DebugViewController debugControl = new DebugViewController();

	/** Access must be synchronized to intrinsic lock of "animation"! */
	private boolean waitingForSuspend = false;

	public ExecutionEngineVMConnection(XUMLRTDebugTarget debugTarget, IProject project, EObject eObjectToExecute,
			VirtualMachineManager virtualMachine, AnimationController animation) {
		this.virtualMachine = virtualMachine;
		this.animation = animation;
		this.virtualMachineBrowser = virtualMachine.getVMBrowser();
		this.resourceSet = eObjectToExecute.eResource().getResourceSet();

		// the constructor sets itself as resource locator for the resource set
		new FilePathResourceLocator(resourceSet);
		this.debugTarget = debugTarget;

		String directory = ProjectProperties.getDebugFilesPath(project);
		IPath debugSymbolsDir = project.getLocation().append(directory);
		SymbolsRegistry symbolsRegistry = new SymbolsRegistry(debugSymbolsDir);
		this.locationConverter = new LocationConverter(symbolsRegistry);
		this.elementRegistry = new ModelElementsRegistry(resourceSet);
		setupControllerListeners(debugTarget.getLaunch());
		virtualMachine.addEventListener(this);
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
							debugTarget.addSMInstance(classId, instanceId, originalName);
						}

						@Override
						public void instanceDestroyed(String classId, int instanceId) {
							StateMachineInstance removed = debugTarget.removeSMInstance(classId, instanceId);
							animation.removeAnimationMarker(removed);
						}
					});
				}
			}
		}
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
			debugTarget.terminate();
		} catch (DebugException e) {
			PluginLogger.logError("Error while terminating debug target", e);
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

		com.sun.jdi.Location stoppedAt = event.location();
		Reference reference = locationConverter.referenceFor(stoppedAt);
		EObject modelElement = reference.resolve(resourceSet);
		if (null == modelElement) {
			// forces the termination when the editor is closed
			forceTermination();
			return ThreadAction.ShouldResume;
		}

		boolean hasBreak = debugTarget.hasEnabledBreakpointOn(modelElement);
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
		StateMachineInstance suspendedSMInstance = debugTarget.getSuspendedSMInstance();
		if (actualSMInstanceIsSelected()) {
			animation.setAnimationMarker(modelElement, suspendedSMInstance);
			animation.startAnimationTimer(new TimerTask() {

				@Override
				public void run() {
					// the virtual machine is resumed after the animation
					virtualMachine.resume();
				}
			});
			return ThreadAction.RemainSuspended;
		} else {
			// remove stuck animation marker if any
			animation.removeAnimationMarker(suspendedSMInstance);
			// the virtual machine is resumed immediately
			return ThreadAction.ShouldResume;
		}
	}

	private boolean actualSMInstanceIsSelected() {
		Pair<String, Long> actualSMInstance = virtualMachineBrowser.getActualSMInstance();
		for (Object debugElem : debugControl.getSelectedDebugElements()) {
			if (debugElem instanceof StateMachineInstance) {
				StateMachineInstance smInstance = (StateMachineInstance) debugElem;
				Pair<String, Integer> smInstanceID = new Pair<>(smInstance.getClassId(), smInstance.getInstanceId());
				if (smInstanceID.equals(actualSMInstance)) {
					return true;
				}
			}
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
				animation.removeAnimationMarker(debugTarget.getSuspendedSMInstance());
				animation.setSuspendedMarker(modelElement);
				debugTarget.markThreadAsSuspended(modelElement);
				waitingForSuspend = false;
				return true;
			}
			return false;
		}
	}

	/**
	 * Puts the handler in suspending mode where it stops on each possible
	 * point.
	 */
	public void waitForSuspend() {
		synchronized (animation) {
			waitingForSuspend = true;
		}
	}

	/**
	 * Orders the handler to continue running, don't stop on the next
	 * breakpoint.
	 */
	public void resume() {
		synchronized (animation) {
			waitingForSuspend = false;
		}
	}
}