package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.IdePlugin;
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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdi.internal.ReferenceTypeImpl;
import org.eclipse.jdt.internal.debug.core.IJDIEventListener;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.eclipse.papyrus.moka.MokaConstants;
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
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.request.BreakpointRequest;
import com.sun.jdi.request.ClassPrepareRequest;
import com.sun.jdi.request.EventRequestManager;

/**
 * Execution engine for Moka.
 */
@SuppressWarnings("restriction")
public class XUmlRtExecutionEngine extends AbstractExecutionEngine implements
		IExecutionEngine {
	private static final String DEFAULT_STRATUM_NAME = "xUML-rt";

	private static final String SYMBOLS_EXTENSION = "symbols";

	private Map<String, DebugSymbols> filenameToDebugSymbols = new HashMap<>();
	private Map<String, ReferenceType> loadedClassnameToJDILocations = new HashMap<>();
	private Map<String, List<Pair<Location, EObject>>> loadedClassnameToDeferredLocation = new HashMap<>();
	private Map<Pair<String, Integer>, EObject> jdiLocationToEObject = new HashMap<>();

	private JDIDebugTarget jdiDebugTarget;
	private boolean animated;

	private EventRequestManager eventRequestManager;

	private MokaDebugTarget mokaDebugTarget;

	public XUmlRtExecutionEngine() {
	}

	@Override
	public void init(EObject eObjectToExecute, String[] args,
			MokaDebugTarget mokaDebugTarget, int requestPort, int replyPort,
			int eventPort) throws UnknownHostException, IOException {
		this.mokaDebugTarget = mokaDebugTarget;
		super.init(eObjectToExecute, args, mokaDebugTarget, requestPort,
				replyPort, eventPort);

		AnimationUtils.init(eObjectToExecute);
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

		jdiDebugTarget = getJDIDebugTarget(mokaDebugTarget);

		jdiDebugTarget.setDefaultStratum(DEFAULT_STRATUM_NAME);

		eventRequestManager = jdiDebugTarget.getEventRequestManager();
		ClassPrepareRequest classPrepareRequest = eventRequestManager
				.createClassPrepareRequest();
		classPrepareRequest.setEnabled(true);
		jdiDebugTarget.addJDIEventListener(new IJDIEventListener() {

			@Override
			public boolean handleEvent(Event event, JDIDebugTarget target,
					boolean suspendVote, EventSet eventSet) {
				handleClassLoaded((ClassPrepareEvent) event);
				return true;
			}

			@Override
			public void eventSetComplete(Event event, JDIDebugTarget target,
					boolean suspend, EventSet eventSet) {
			}
		}, classPrepareRequest);
	}

	private JDIDebugTarget getJDIDebugTarget(MokaDebugTarget mokaDebugTarget) {
		for (IDebugTarget debugTarget : mokaDebugTarget.getLaunch()
				.getDebugTargets()) {
			if (debugTarget instanceof JDIDebugTarget) {
				return (JDIDebugTarget) debugTarget;
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

		ReferenceType referenceType = loadedClassnameToJDILocations
				.get(containerName);

		if (referenceType == null) {
			deferBreakpoint(containerName, location, modelElement);
		} else {
			placeJdiBreakpoint(location, referenceType, modelElement);
		}

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

		int startLineInFile = startLine + 1;

		try {
			List<com.sun.jdi.Location> locationsOfLine = referenceType
					.locationsOfLine(startLineInFile);

			if (locationsOfLine.size() == 0) {
				IdePlugin
						.logError("Location with zero lines: " + referenceType);
				return;
			}

			if (locationsOfLine.size() > 1) {
				IdePlugin.logError("Location with multiple lines: "
						+ referenceType);
			}

			com.sun.jdi.Location jdiLocation = locationsOfLine.get(0);

			BreakpointRequest breakpointRequest = eventRequestManager
					.createBreakpointRequest(jdiLocation);
			breakpointRequest.setEnabled(true);
			jdiDebugTarget.addJDIEventListener(new IJDIEventListener() {

				@Override
				public boolean handleEvent(Event event, JDIDebugTarget target,
						boolean suspendVote, EventSet eventSet) {
					handleBreakpoint((BreakpointEvent) event);
					return false;
				}

				@Override
				public void eventSetComplete(Event event,
						JDIDebugTarget target, boolean suspend,
						EventSet eventSet) {
				}
			}, breakpointRequest);

			String className = removeLastDotSection(jdiLocation.sourceName());
			jdiLocationToEObject.put(new Pair<String, Integer>(className,
					startLine), modelElement);
		} catch (AbsentInformationException e) {
			IdePlugin.logError("While setting JDI breakpoint", e);
		}
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
	}

	private void handleClassLoaded(ClassPrepareEvent event) {
		Set<String> debugClassnames = getDebugClassnames();
		ReferenceType referenceType = event.referenceType();
		String loadedClassname = referenceType.name();
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
			int locationLine = stoppedAt.lineNumber() - 1;

			// TODO is removing the .java extension always good enough?
			String sourceName = removeLastDotSection(sourceFileName);

			EObject eObject = jdiLocationToEObject.get(new Pair<>(sourceName,
					locationLine));
			animate(eObject);
			jdiDebugTarget.refreshState();
		} catch (AbsentInformationException | DebugException e) {
			IdePlugin.logError("While handling breakpoint hit", e);
		}

		return true;
	}

	protected void animate(EObject element) {
		if (animated) {
			AnimationUtils utils = AnimationUtils.getInstance();
			if (!utils.diagramsExistFor(element)) {
				return;
			}
			utils.addAnimationMarker(element);
			try {
				Thread.sleep(MokaConstants.MOKA_ANIMATION_DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			utils.removeAnimationMarker(element);
		}
	}

	@Override
	public void suspend(Suspend_Request arg0) {
		try {
			
			jdiDebugTarget.suspend();
			mokaDebugTarget.suspend();
		} catch (DebugException e) {
			IdePlugin.logError("Error while suspending debug target", e);
		}
	}

	@Override
	public void terminate(Terminate_Request arg0) {
		setIsTerminated(true);
		try {
			jdiDebugTarget.terminate();
			mokaDebugTarget.terminate();
		} catch (DebugException e) {
			IdePlugin.logError("Error while terminating debug target", e);
		}
	}

	@Override
	public void disconnect() {
		setIsTerminated(true);
		try {
			jdiDebugTarget.disconnect();
			mokaDebugTarget.disconnect();
		} catch (DebugException e) {
			IdePlugin.logError("Error while disconnecting debug target", e);
		}
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
