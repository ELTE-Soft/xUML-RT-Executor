package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.util.ModelUtils;
import hu.eltesoft.modelexecution.ide.launch.ModelExecutionLaunchConfig;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Suspend_Event;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

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

	private static final String DEFAULT_STRATUM_NAME = "xUML-rt";

	private Map<String, List<EObject>> loadedClassnameToDeferredLocation = new HashMap<>();
	private Set<EObject> initialisedContainers = new HashSet<>();
	private EObject previousAnimatedEObject = null;

	private boolean animated;

	// /////////////////////////////////////////////////////////////////////////

	private ResourceSet resourceSet;
	private SymbolsRegistry symbolsRegistry;
	private LocationConverter locationConverter;
	private VirtualMachineManager virtualMachine;

	@Override
	public void init(EObject eObjectToExecute, String[] args,
			MokaDebugTarget mokaDebugTarget, int requestPort, int replyPort,
			int eventPort) throws UnknownHostException, IOException {
		super.init(eObjectToExecute, args, mokaDebugTarget, requestPort,
				replyPort, eventPort);

		debugTarget.setName("xUML-Rt Model");

		try {
			animated = debugTarget
					.getLaunch()
					.getLaunchConfiguration()
					.getAttribute(ModelExecutionLaunchConfig.ATTR_ANIMATE,
							false);
		} catch (CoreException e) {
			IdePlugin.logError("Error while reading launch config", e);
		}

		if (animated) {
			AnimationUtils.init(eObjectToExecute);
			AnimationUtils.init();
		}

		// /////////////////////////////////////////////////////////////////////

		resourceSet = eObjectToExecute.eResource().getResourceSet();
		IProject project = getProject(mokaDebugTarget);
		String directory = ExecutableModelProperties.getDebugFilesPath(project);
		IPath debugSymbolsDir = project.getLocation().append(directory);
		symbolsRegistry = new SymbolsRegistry(debugSymbolsDir);
		locationConverter = new LocationConverter(symbolsRegistry);

		virtualMachine = new VirtualMachineManager(mokaDebugTarget.getLaunch());
		virtualMachine.setDefaultStratum(DEFAULT_STRATUM_NAME);
		virtualMachine.addVMEventListener(this);
	}

	/**
	 * Marks all moka threads as suspended.
	 */
	private void markThreadAsSuspended() {
		try {
			for (IThread thread : debugTarget.getThreads()) {
				MokaThread mokaThread = (MokaThread) thread;
				// causes debug target to be suspended
				sendEvent(new Suspend_Event(mokaThread, DebugEvent.STEP_END,
						new MokaThread[] { mokaThread }));
				// causes thread to be suspended
				mokaThread.setSuspended(true);
			}
		} catch (DebugException e) {
			IdePlugin.logError("Error while marking thread as suspended", e);
		}
	}

	private IProject getProject(MokaDebugTarget mokaDebugTarget) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		ILaunchConfiguration launchConfiguration = mokaDebugTarget.getLaunch()
				.getLaunchConfiguration();
		IProject project = null;
		try {
			project = root.getProject(launchConfiguration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_PROJECT_NAME, ""));
		} catch (CoreException e) {
			IdePlugin.logError("Error while retrieving attribute", e);
		}
		return project;
	}

	@Override
	public void addBreakpoint(MokaBreakpoint breakpoint) {
		EObject modelElement = breakpoint.getModelElement();
		if (!(modelElement instanceof Vertex || modelElement instanceof Transition)) {
			// TODO Support breakpoints on other nodes
			return;
		}

		initEObjectForAnimation(modelElement);
		if (locationConverter.locationsFor(modelElement).isEmpty()) {
			deferBreakpoint(modelElement);
		} else {
			placeJdiBreakpoint(modelElement);
		}
	}

	// note: this reinitializes all internal hashmaps of AnimationUtils,
	// probably could be more efficient
	private void initEObjectForAnimation(EObject modelElement) {
		if (initialisedContainers.contains(modelElement)) {
			return;
		}

		// resolve EObject proxies here as animation depends on their eResource
		if (modelElement.eIsProxy()) {
			modelElement = EcoreUtil.resolve(modelElement, (EObject) null);
		}

		AnimationUtils.init(modelElement);
		initialisedContainers.add(modelElement);
	}

	/**
	 * The breakpoint is set on the related file. It is assumed that the file is
	 * already loaded into the virtual machine.
	 * 
	 * @param modelElement
	 */
	private void placeJdiBreakpoint(EObject modelElement) {
		locationConverter.locationsFor(modelElement).forEach(
				virtualMachine::addBreakpoint);
	}

	/**
	 * As the class for the breakpoint isn't loaded yet, the breakpoint
	 * information is stored until the class has arrived.
	 */
	private void deferBreakpoint(EObject modelElement) {
		String containerName = ModelUtils.getContainerName(modelElement);
		List<EObject> deferredLocations = loadedClassnameToDeferredLocation
				.get(containerName);
		if (deferredLocations == null) {
			deferredLocations = new ArrayList<>();
		}

		deferredLocations.add(modelElement);
		loadedClassnameToDeferredLocation.put(containerName, deferredLocations);
	}

	@Override
	public void initializeArguments(String[] arg0) {
	}

	@Override
	public void removeBreakpoint(MokaBreakpoint arg0) {
		// TODO: remove breakpoints
	}

	@Override
	public void resume(Resume_Request arg0) {
		virtualMachine.resume();
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
		// try to pre-load a symbols file
		locationConverter.registerClass(referenceType);
		symbolsRegistry.getSymbolsFor(className);

		placeDeferredBreakpoints(className, referenceType);
	}

	@Override
	public ThreadAction handleBreakpoint(BreakpointEvent event) {
		com.sun.jdi.Location stoppedAt = event.location();
		Reference reference = locationConverter.referenceFor(stoppedAt);
		EObject eObject = reference.resolve(resourceSet);
		animate(eObject);

		markThreadAsSuspended();
		return ThreadAction.RemainSuspended;
	}

	private void placeDeferredBreakpoints(String loadedClassname,
			ReferenceType referenceType) {
		List<EObject> deferredElements = loadedClassnameToDeferredLocation
				.get(loadedClassname);
		if (deferredElements == null)
			return;
		for (EObject deferred : deferredElements) {
			placeJdiBreakpoint(deferred);
		}
	}

	protected void animate(EObject element) {
		if (!animated)
			return;

		AnimationUtils utils = AnimationUtils.getInstance();
		if (!utils.diagramsExistFor(element)) {
			return;
		}

		if (previousAnimatedEObject != null) {
			utils.removeAnimationMarker(previousAnimatedEObject);
		}

		utils.addAnimationMarker(element);
		previousAnimatedEObject = element;
	}

	@Override
	public void suspend(Suspend_Request arg0) {
		virtualMachine.suspend();
	}

	@Override
	public void terminate(Terminate_Request arg0) {
		setIsTerminated(true);
		try {
			AnimationUtils.getInstance().removeAllAnimationMarker();
			virtualMachine.terminate();
		} catch (DebugException e) {
			IdePlugin.logError("Error while terminating debug target", e);
		}
	}

	@Override
	public void disconnect() {
		setIsTerminated(true);
		virtualMachine.disconnect();
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
