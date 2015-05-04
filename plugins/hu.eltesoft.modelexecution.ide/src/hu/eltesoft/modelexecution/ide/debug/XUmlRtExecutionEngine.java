package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.launch.BackgroundJavaLauncher.BackgroundJavaProcess;
import hu.eltesoft.modelexecution.ide.launch.ModelExecutionLaunchConfig;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.StateQualifiers;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationRegistry;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;
import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdi.internal.ReferenceTypeImpl;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.base.Optional;
import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;
import com.sun.jdi.request.BreakpointRequest;
import com.sun.jdi.request.ClassPrepareRequest;
import com.sun.jdi.request.EventRequest;
import com.sun.jdi.request.EventRequestManager;

/**
 * Execution engine for Moka.
 */
@SuppressWarnings("restriction")
public class XUmlRtExecutionEngine extends AbstractExecutionEngine implements

	private static final String DEFAULT_STRATUM_NAME = "xUML-rt";

	private static final String SYMBOLS_EXTENSION = "symbols";

	private Map<String, DebugSymbols> filenameToDebugSymbols = new HashMap<>();
	private Map<String, ReferenceType> loadedClassnameToJDILocations = new HashMap<>();
	private Map<String, List<Pair<Location, EObject>>> loadedClassnameToDeferredLocation = new HashMap<>();
	private Map<Pair<String, Integer>, EObject> jdiLocationToEObject = new HashMap<>();
	private Set<EObject> initialisedContainers = new HashSet<>();
	private EObject previousAnimatedEObject = null;

	private VirtualMachine virtualMachine;
	private boolean animated;

	private EventRequestManager eventRequestManager;

	private MokaDebugTarget mokaDebugTarget;
	private Thread eventHandlerThread;
	private BackgroundJavaProcess javaProcess;

	private static void dbg(String msg) {
		System.err.println(msg);
	}

	@Override
	public void init(EObject eObjectToExecute, String[] args,
			MokaDebugTarget mokaDebugTarget, int requestPort, int replyPort,
			int eventPort) throws UnknownHostException, IOException {
		this.mokaDebugTarget = mokaDebugTarget;
		super.init(eObjectToExecute, args, mokaDebugTarget, requestPort,
				replyPort, eventPort);

		if (this.debugTarget != null) {
			this.debugTarget.setName("xUML-Rt State machine");
		}

		loadDebugSymbols(mokaDebugTarget);
		try {
			animated = mokaDebugTarget
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

		javaProcess = getJavaProcess(mokaDebugTarget);
		virtualMachine = getVirtualMachine(mokaDebugTarget);
		eventHandlerThread = createEventHandlerThread();
		eventHandlerThread.start();

		virtualMachine.setDefaultStratum(DEFAULT_STRATUM_NAME);

		eventRequestManager = virtualMachine.eventRequestManager();
		ClassPrepareRequest classPrepareRequest = eventRequestManager
				.createClassPrepareRequest();
		classPrepareRequest.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		classPrepareRequest.enable();
	}

	private Thread createEventHandlerThread() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						boolean stop = false;
						EventSet events = virtualMachine.eventQueue().remove();
						for (Event event : events) {
							if (event instanceof VMStartEvent) {
								dbg("VMStart");
								// initial start (the vm starts suspended)
								// virtualMachine.resume();
							} else if (event instanceof ClassPrepareEvent) {
								handleClassLoaded((ClassPrepareEvent) event);
							} else if (event instanceof BreakpointEvent) {
								handleBreakpoint((BreakpointEvent) event);
								stop = true;
							} else if (event instanceof VMDisconnectEvent) {
								// stop on vm disconnect
								return;
							}
						}
						if (!stop) {
							events.resume();
						} else {
							debugTarget.suspend();
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

	private VirtualMachine getVirtualMachine(MokaDebugTarget mokaDebugTarget2) {
		return getJavaProcess(mokaDebugTarget2).getVM();
	}

	private BackgroundJavaProcess getJavaProcess(MokaDebugTarget mokaDebugTarget) {
		for (IProcess process : mokaDebugTarget.getLaunch().getProcesses()) {
			if (process instanceof BackgroundJavaProcess) {
				return (BackgroundJavaProcess) process;
			}
		}
		return null;
	}

	// TODO: resolve container in a sophisticated way
	public String getContainerName(EObject modelElement) {
		EObject container = getContainer(modelElement);
		return ((NamedElement) container).getName();
	}

	private EObject getContainer(EObject modelElement) {
		while (!isContainer(modelElement)) {
			modelElement = ((Element) modelElement).getOwner();
		}

		return modelElement;
	}

	// TODO: resolve container in a sophisticated way
	protected boolean isContainer(EObject modelElement) {
		return (modelElement instanceof Region)
				|| (modelElement instanceof org.eclipse.uml2.uml.Class);
	}

	private Set<String> getDebugClassnames() {
		String symExt = "." + SYMBOLS_EXTENSION;
		return filenameToDebugSymbols.keySet().stream()
				.filter(filename -> filename.endsWith(symExt))
				.map(XUmlRtExecutionEngine::removeLastDotSection)
				.collect(Collectors.toSet());
	}

	private void loadDebugSymbols(MokaDebugTarget mokaDebugTarget)
			throws IOException, FileNotFoundException {
		IProject project = getProject(mokaDebugTarget);
		if (project == null) {
			return;
		}
		String debugResDir = ExecutableModelProperties
				.getDebugFilesPath(project);

		for (File file : project.getLocation().append(debugResDir).toFile()
				.listFiles()) {
			if (!file.isFile())
				continue;
			String filename = file.getName();
			if (!filename.endsWith("." + SYMBOLS_EXTENSION))
				continue;

			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file));) {
				DebugSymbols debugSymbols = (DebugSymbols) ois.readObject();
				filenameToDebugSymbols.put(filename, debugSymbols);
			} catch (ClassNotFoundException e) {
				IdePlugin.logError("While deserializing symbol file", e);
			}
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

		Reference reference = new Reference(modelElement);
		Optional<Location> optLocation = referenceToLocation(reference);

		if (!optLocation.isPresent()) {
			IdePlugin.logError("Breakpoint information is missing for "
					+ reference);
			return;
		}

		Location location = optLocation.get();
		String containerName = getContainerName(breakpoint.getModelElement());

		initEObjectForAnimation(modelElement);

		ReferenceType referenceType = loadedClassnameToJDILocations
				.get(containerName);

		if (referenceType == null) {
			deferBreakpoint(containerName, location, modelElement);
		} else {
			placeJdiBreakpoint(location, referenceType, modelElement);
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
	private void placeJdiBreakpoint(Location location,
			ReferenceType referenceType, EObject modelElement) {
		((ReferenceTypeImpl) referenceType).flushStoredJdwpResults();
		int startLine = location.getStartLine();

		int startLineInFile = startLine;

		try {
			List<com.sun.jdi.Location> locationsOfLine = referenceType
					.locationsOfLine(startLineInFile);

			if (locationsOfLine.size() == 0) {
				IdePlugin
						.logError("Location with zero lines: " + referenceType);
				return;
			}

			for (com.sun.jdi.Location jdiLocation : locationsOfLine) {
				placeJdiBreakpointOnLocation(modelElement, startLine,
						jdiLocation);
			}
		} catch (AbsentInformationException e) {
			IdePlugin.logError("While setting JDI breakpoint", e);
		}
	}

	private void placeJdiBreakpointOnLocation(EObject modelElement,
			int startLine, com.sun.jdi.Location jdiLocation)
			throws AbsentInformationException {
		BreakpointRequest breakpointRequest = eventRequestManager
				.createBreakpointRequest(jdiLocation);
		breakpointRequest.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		breakpointRequest.enable();

		String className = removeLastDotSection(jdiLocation.sourceName());
		jdiLocationToEObject.put(
				new Pair<String, Integer>(className, startLine), modelElement);
	}

	/**
	 * As the class for the breakpoint isn't loaded yet, the breakpoint
	 * information is stored until the class has arrived.
	 */
	private void deferBreakpoint(String containerName, Location location,
			EObject modelElement) {
		List<Pair<Location, EObject>> deferredLocations = loadedClassnameToDeferredLocation
				.get(containerName);
		if (deferredLocations == null) {
			deferredLocations = new ArrayList<>();
		}

		deferredLocations.add(new Pair<>(location, modelElement));
		loadedClassnameToDeferredLocation.put(containerName, deferredLocations);
	}

	/**
	 * @return The {@link Location} of the {@link Reference}, or null if not
	 *         found. Tries to resolve the reference as unqualified and both as
	 *         {@link StateQualifiers.Entry} and a {@link StateQualifiers.Exit}.
	 */
	private Optional<Location> referenceToLocation(Reference reference) {
		for (Map.Entry<String, DebugSymbols> entry : filenameToDebugSymbols
				.entrySet()) {
			DebugSymbols debugSymbols = entry.getValue();
			LocationRegistry locationRegistry = debugSymbols
					.getLocationRegistry();

			Location location1 = locationRegistry.resolve(reference);
			if (location1 != null)
				return Optional.of(location1);

			Location location2 = locationRegistry.resolveQualified(reference,
					StateQualifiers.Entry.class);
			if (location2 != null)
				return Optional.of(location2);

			Location location3 = locationRegistry.resolveQualified(reference,
					StateQualifiers.Exit.class);
			if (location3 != null)
				return Optional.of(location3);
		}
		return Optional.absent();
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

	private void handleClassLoaded(ClassPrepareEvent event) {
		Set<String> debugClassnames = getDebugClassnames();
		ReferenceType referenceType = event.referenceType();
		String loadedClassname = referenceType.name();
		dbg("Class loaded: " + loadedClassname);
		if (!debugClassnames.contains(loadedClassname)) {
			return;
		}

		debugClassnames.remove(loadedClassname);
		loadedClassnameToJDILocations.put(loadedClassname, referenceType);
		placeDeferredBreakpoints(loadedClassname, referenceType);
	}

	private void placeDeferredBreakpoints(String loadedClassname,
			ReferenceType referenceType) {
		List<Pair<Location, EObject>> deferredLocations = loadedClassnameToDeferredLocation
				.get(loadedClassname);
		if (deferredLocations == null)
			return;
		for (Pair<Location, EObject> deferred : deferredLocations) {
			Location location = deferred.getKey();
			EObject modelElement = deferred.getValue();
			placeJdiBreakpoint(location, referenceType, modelElement);
		}
	}

	private boolean handleBreakpoint(BreakpointEvent event) {
		com.sun.jdi.Location stoppedAt = event.location();
		try {
			String sourceFileName = stoppedAt.sourceName();
			int locationLine = stoppedAt.lineNumber();
			dbg("Breakpoint hit: " + sourceFileName + ":" + locationLine);

			// TODO is removing the .java extension always good enough?
			String sourceName = removeLastDotSection(sourceFileName);

			EObject eObject = jdiLocationToEObject.get(new Pair<>(sourceName,
					locationLine));
			animate(eObject);
		} catch (AbsentInformationException e) {
			IdePlugin.logError("While handling breakpoint hit", e);
		}

		return true;
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
			virtualMachine.dispose();
			javaProcess.terminate();
		} catch (DebugException e) {
			IdePlugin.logError("Error while terminating debug target", e);
		}
	}

	@Override
	public void disconnect() {
		setIsTerminated(true);
		virtualMachine.dispose();
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
		return new IVariable[0];
	}

	@Override
	public IRegisterGroup[] getRegisterGroups(IStackFrame stackFrame) {
		return new IRegisterGroup[0];
	}

	/**
	 * Typical usage: to remove {@code .java} postfixes.
	 * 
	 * @return The input string without the last dot in it and everything that
	 *         comes after that. If the text does not contain any dots, returns
	 *         the original text.
	 */
	public static String removeLastDotSection(String in) {
		if (in == null) {
			return null;
		}
		int lastDotIdx = in.lastIndexOf(".");
		if (lastDotIdx <= 0) {
			return in;
		}
		return in.substring(0, lastDotIdx);
	}
}
