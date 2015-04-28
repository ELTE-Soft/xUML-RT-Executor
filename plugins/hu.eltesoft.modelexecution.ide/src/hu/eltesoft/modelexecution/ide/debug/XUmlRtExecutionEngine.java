package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.builder.BuilderListenerInterface;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProjectSetup;
import hu.eltesoft.modelexecution.m2m.logic.ChangeListenerM2MTranslator;
import hu.eltesoft.modelexecution.m2m.logic.ContainerNameProvider;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.StateQualifiers;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationRegistry;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;
import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;
import hu.eltesoft.modelexecution.runtime.TestRuntime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdi.Bootstrap;
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
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.base.Optional;
import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.Field;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.Connector.Argument;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.jdi.connect.LaunchingConnector;
import com.sun.jdi.connect.VMStartException;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventQueue;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;

/**
 * Execution engine for Moka.
 */
@SuppressWarnings("restriction")
public class XUmlRtExecutionEngine  extends AbstractExecutionEngine implements IExecutionEngine {
	private static final String DEBUG_CLASSPATH_DIR = "bin-debug";

	private static final String DEFAULT_STRATUM_NAME = "xUML-rt";

	private static final String SYMBOLS_EXTENSION = "symbols";

	private VirtualMachine vm;
	private Job vmJob;
		
	private ContainerNameProvider containerNameProvider;
	
//	private BreakpointRegistry bpReg = new BreakpointRegistry();
	private Map<String, DebugSymbols> filenameToDebugSymbols = new HashMap<>();
	private Map<String, ReferenceType> loadedClassnameToJDILocations = new HashMap<>();
	private Map<String, List<Pair<Location, EObject>>> loadedClassnameToDeferredLocation = new HashMap<>();
	private Map<Pair<String, Integer>, EObject> jdiLocationToEObject = new HashMap<>();
	
	public XUmlRtExecutionEngine() {
	}

	@Override
	public void init(EObject eObjectToExecute, String[] args,
			MokaDebugTarget mokaDebugTarget, int requestPort, int replyPort,
			int eventPort) throws UnknownHostException, IOException {
		super.init(eObjectToExecute, args, mokaDebugTarget, requestPort, replyPort,
				eventPort);
		
		dbg("--------------------------------");

		AnimationUtils.init(eObjectToExecute);
		if (this.debugTarget != null) {
			this.debugTarget.setName("xUML-Rt State machine");
		}

		loadDebugSymbols(mokaDebugTarget);

		containerNameProvider = getContainerNameProvider(eObjectToExecute);
		
		vm = getVM(mokaDebugTarget);
//		vm = mkVM(mokaDebugTarget, getFQN(eObjectToExecute));
		vm.setDefaultStratum(DEFAULT_STRATUM_NAME);

	}

	// TODO remove
	private String getFQN(EObject eObjectToExecute) {
		String fullyQualifiedName = containerNameProvider.getContainerName(eObjectToExecute);
		return fullyQualifiedName;
	}

	// TODO remove
	private Region getStateMachineRegion(EObject eObjectToExecute) {
		StateMachine machine = (StateMachine) eObjectToExecute;
		if (machine.getRegions().size() < 1) {
			return null;
		}

		return machine.getRegions().get(0);
	}

	// TODO remove (currently present because getVM()'s VM seems to be missing a classpath entry)
	VirtualMachine mkVM(MokaDebugTarget mokaDebugTarget, String fullyQualifiedName) {
		VirtualMachineManager manager = Bootstrap.virtualMachineManager();
		LaunchingConnector defaultConnector = manager.defaultConnector();

		Map<String, ? extends Argument> arguments = mkVmArgs(defaultConnector, fullyQualifiedName, mokaDebugTarget);

		try {
			vm = defaultConnector.launch(arguments);
			vm.setDefaultStratum(DEFAULT_STRATUM_NAME);
			return vm;
		} catch (IllegalConnectorArgumentsException | VMStartException | IOException e) {
			// TODO proper error message
			e.printStackTrace();
			return null;
		}
	}
	
	// TODO remove
	private Map<String, ? extends Argument> mkVmArgs(LaunchingConnector connector, String fullyQualifiedName, MokaDebugTarget mokaDebugTarget) {
		Map<String, ? extends Argument> arguments = connector.defaultArguments();
		String testRuntimeClassName = TestRuntime.class.getCanonicalName();

		String feedName = "feed";
		
		fullyQualifiedName = "Loop";
		
		String[] args = {testRuntimeClassName, fullyQualifiedName, feedName}; 
		
		dbg("vmargs " + String.join(" ", args));
		
		arguments.get("main").setValue(String.join(" ", args));
		
		
		String binClasspath = Paths.get(getBaseDir(mokaDebugTarget), DEBUG_CLASSPATH_DIR).toAbsolutePath().toString();
		dbg("binCP " + binClasspath);

		String runtimeClasspath = "F:\\vcs\\modelinterpreter\\product\\trunk\\plugins\\hu.eltesoft.modelexecution.runtime\\bin";
		String thirdPartyClasspath = "F:\\vcs\\modelinterpreter\\product\\trunk\\plugins\\hu.eltesoft.modelexecution.3pp";

		String fullClasspath = String.join(File.pathSeparator, binClasspath, runtimeClasspath, thirdPartyClasspath);
		arguments.get("options").setValue("-cp " + fullClasspath + "/");

		dbg("cp " + binClasspath);

		return arguments;
	}

	// TODO remove
	private String getBaseDir(MokaDebugTarget mokaDebugTarget) {
		return "T:\\runtime-MokaModel3\\Test1";
	}

	private ContainerNameProvider getContainerNameProvider(EObject eObjectToExecute) {
		Resource res = eObjectToExecute.eResource();
		ChangeListenerM2MTranslator translatorOfEmfRes = BuilderListenerInterface.getTranslatorOfEmfRes(res);
		return translatorOfEmfRes.getContainerNameProvider();
	}

	/** @return The supplied virtual machine.
	 *          If no virtual machine is supplied, {@code null}; this should not happen. */
	private VirtualMachine getVM(MokaDebugTarget mokaDebugTarget) {
		for (IDebugTarget debugTarget : mokaDebugTarget.getLaunch().getDebugTargets()) {
			if (debugTarget instanceof JDIDebugTarget) {
				return ((JDIDebugTarget)debugTarget).getVM();
			}
		}
		
		return null;
	}

	private void dbg(String string) {
		System.out.println(string);
	}

	
	/** @param consumer It processes the event, and returns true if the event loop should continue.
	 *  @return The virtual machine is stopped. */
	private boolean forEachVmEvent(EventQueue eventQueue, Predicate<Event> consumer) {
		EventSet eventSet = null;
		try {
			eventSet = eventQueue.remove();
//			eventSet.stream().forEach(event -> dbg("evEach " + event.toString()));
		} catch (InterruptedException | com.sun.jdi.VMDisconnectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (eventSet == null) {
			dbg("nullEvtSet");
			return false;
		}
		
		for (Event event : eventSet) {
			if (event instanceof VMDeathEvent
					|| event instanceof VMDisconnectEvent) {
				return true;
			} else {
				boolean continueLoop = consumer.test(event);
				if (!continueLoop)   break;
			}
		}
		eventSet.resume();
		return false;
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
		try {
			dbg(mokaDebugTarget.getLaunch().getLaunchConfiguration().getAttributes().toString());
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String defaultBaseDir = "/";
//		String baseDir = defaultBaseDir;

		
		
//		String baseDir = mokaDebugTarget.getLaunch().getLaunchConfiguration().getAttribute(ExecutableModelProperties.getSourceGenPath(mokaDebugTarget.getProcess()), defaultBaseDir);
			// TODO remove hack
		String	baseDir = getBaseDir(mokaDebugTarget);
		
		dbg(ExecutableModelProjectSetup.SMAP_FOLDER.toString());
		dbg(Paths.get(baseDir, ExecutableModelProjectSetup.SMAP_FOLDER).toString());
		dbg(Paths.get(baseDir, ExecutableModelProjectSetup.SMAP_FOLDER).toFile().toString());
		dbg(Paths.get(baseDir, ExecutableModelProjectSetup.SMAP_FOLDER).toFile().listFiles().toString());
		
		for (File file : Paths.get(baseDir, ExecutableModelProjectSetup.SMAP_FOLDER).toFile().listFiles()) {
			if (!file.isFile())  continue;
			String filename = file.getName();
			if (!filename.endsWith("." + SYMBOLS_EXTENSION))  continue;

			try (
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			) {
				DebugSymbols debugSymbols = (DebugSymbols)ois.readObject();
				filenameToDebugSymbols.put(filename, debugSymbols);
			} catch (ClassNotFoundException e) {
				// TODO proper error message
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addBreakpoint(MokaBreakpoint breakpoint) {
		EObject modelElement = breakpoint.getModelElement();
		if (!(modelElement instanceof Vertex || modelElement instanceof Transition)) {
			// TODO note: breakpoints are only supported on Vertex and Transition nodes
			return;
		}

		Reference reference = new Reference(modelElement);
		Optional<Location> optLocation = referenceToLocation(reference);

		dbg("queryBp " + reference + " " + modelElement);

		if (!optLocation.isPresent()) {
			dbg("missingBp " + modelElement + " " + modelElement.eContents());

			// TODO error msg
			return;
		}

		Location location = optLocation.get();
		dbg("foundBp " + reference + " " + modelElement + " " + location);

		String containerName = getContainingRegionName(modelElement);
//		String containerName = containerNameProvider.getContainerName(modelElement);
		dbg("container " + containerName);

		dbg("loadedToLocs " + loadedClassnameToJDILocations);
		ReferenceType referenceType = loadedClassnameToJDILocations.get(containerName);
		
		if (referenceType == null) {
			dbg("deferringBp " + location);
			deferBreakpoint(containerName, location, modelElement);
		} else {
			dbg("immediateBp " + referenceType.toString());
			placeJdiBreakpoint(location, referenceType, modelElement);
		}

	}

	/** This method traverses EObjects, and should be removed in the future.
	 *  @return The name of the (state machine) region that contains the {@code modelElement},
	 *          or {@code null} if no such region is found. */
	private String getContainingRegionName(EObject modelElement) {
		EObject container = modelElement;
		dbg("initCont " + container.getClass().getName() + " " + container);
		while (container.eContainer() != null) {
			container = container.eContainer();
			dbg("parCont " + container.getClass().getName() + " " + container);
			if (container instanceof Region)   break;
		}

		if (!(container instanceof Region)) {
			// TODO
			dbg("nonStateMachineContainer " + container.getClass().getName());
			return null;
		}

		return ((Region)container).getName();
	}

	/** The breakpoint is set on the related file.
	 *  It is assumed that the file is already loaded into the virtual machine. 
	 * @param modelElement */
	private void placeJdiBreakpoint(Location location,
			ReferenceType referenceType, EObject modelElement) {
		try {
			dbg("rtStrat " + referenceType.availableStrata());
			for (int i = 0; i < 1000; i++) {
				if (referenceType.locationsOfLine(DEFAULT_STRATUM_NAME, "model3.uml", i).isEmpty())  continue;
				dbg("line " + i + " " + referenceType.locationsOfLine(DEFAULT_STRATUM_NAME, "model3.uml", i));
			}
			dbg("allFields " + referenceType.allFields());
			dbg("allLocsRefType " + referenceType.allLineLocations());
			dbg("allLocsRefType " + referenceType.allLineLocations(DEFAULT_STRATUM_NAME, "model3.uml"));
		} catch (AbsentInformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int startLine = location.getStartLine();

		int startLineInFile = startLine + 1;
		
		try {
			List<com.sun.jdi.Location> locationsOfLine = referenceType.locationsOfLine(startLineInFile);

			dbgPrintLocsOfLine(referenceType);
			
			if (locationsOfLine.size() == 0) {
				dbg("missingBPloc " + startLineInFile);
				return;
			}

			if (locationsOfLine.size() > 1) {
				dbg("multiloc " + locationsOfLine);
			}
			
			com.sun.jdi.Location jdiLocation = locationsOfLine.get(0);
			
			dbg("jdiLocation " + jdiLocation);
			
			vm.eventRequestManager().createBreakpointRequest(jdiLocation).setEnabled(true);
			
			String className = removeLastDotSection(jdiLocation.sourceName());
			dbg("addedBp " + jdiLocation + " " + className);
			jdiLocationToEObject.put(new Pair<String, Integer>(className, startLine), modelElement);
		} catch (AbsentInformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dbgPrintLocsOfLine(ReferenceType referenceType) {
		for (int i = 1; i < 20; i++) {
			try {
				List<com.sun.jdi.Location> locationsOfLine2 = referenceType.locationsOfLine(i);
				dbg("locLine " + i + " ------> " + ((locationsOfLine2 == null) ? "X" : locationsOfLine2.get(0)));
			} catch (Exception e) {
				dbg("overLocLine " + i + " " + e);
				break;
			}
		}
	}

	/** As the class for the breakpoint isn't loaded yet,
	 *  the breakpoint information is stored until the class has arrived. */
	private void deferBreakpoint(String containerName, Location location, EObject modelElement) {
		dbg("deferring " + containerName);
		List<Pair<Location, EObject>> deferredLocations = loadedClassnameToDeferredLocation.get(containerName);
		if (deferredLocations == null) {
			deferredLocations = new ArrayList<>();
		}

		deferredLocations.add(new Pair<>(location, modelElement));
		loadedClassnameToDeferredLocation.put(containerName, deferredLocations);
	}

	/** @return The {@link Location} of the {@link Reference}, or null if not found.
	 *          Tries to resolve the reference as unqualified and both as {@link StateQualifiers.Entry}
	 *          and a {@link StateQualifiers.Exit}. */
	private Optional<Location> referenceToLocation(Reference reference) {
		dbg("kset " + filenameToDebugSymbols);

		for (Map.Entry<String, DebugSymbols> entry : filenameToDebugSymbols.entrySet()) {
			String filename = entry.getKey();
			DebugSymbols debugSymbols = entry.getValue();
			LocationRegistry locationRegistry = debugSymbols.getLocationRegistry();

			dbg("dsyms " + locationRegistry);

			Location location1 = locationRegistry.resolve(reference);
			if (location1 != null)   return Optional.of(location1);

			Location location2 = locationRegistry.resolveQualified(reference, StateQualifiers.Entry.class);
			if (location2 != null)   return Optional.of(location2);

			Location location3 = locationRegistry.resolveQualified(reference, StateQualifiers.Exit.class);
			if (location3 != null)   return Optional.of(location3);
		}
		return Optional.absent();
	}

	@Override
	public void initializeArguments(String[] arg0) {
	}

	@Override
	public void removeBreakpoint(MokaBreakpoint arg0) {
		// TODO Auto-generated method stub
		
	}

	private volatile boolean isVmJobStarted = false;
	private volatile boolean isVmJobSuspended = false;
	private volatile boolean vmJobWasSuspended = false;
	private volatile Object vmJobLock = new Object();

	@Override
	public void resume(Resume_Request arg0) {
		dbg("resuming...");
		
		isVmJobSuspended = false;
		
		if (!isVmJobStarted) {
			dbg("starting job...");
			vmJob = mkVmJob();
		}

		vmJob.schedule();
	}

	private Job mkVmJob() {
		return new Job("xUML-RT Execution") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				dbg("job started");
				Set<String> debugClassnames = getDebugClassnames();
				vm.eventRequestManager().createClassPrepareRequest().setEnabled(true);
				vm.resume();

				EventQueue eventQueue = vm.eventQueue();
				while (true) {
					waitIfSuspended();

					if (vmJobWasSuspended) {
						vm.resume();
					}

//					dbg("handling events...");

					// TODO is this necessary all the time?
					vm.resume();

					boolean vmIsFinished = forEachVmEvent(eventQueue, event -> {
//						dbg("evt " + event);

						if (event instanceof BreakpointEvent)   return handleBreakpoint((BreakpointEvent)event);
						else if (event instanceof ClassPrepareEvent)    return handleClassLoaded((ClassPrepareEvent)event, debugClassnames);

						return true;
					});

//					dbg("handled events...");

					if (vmIsFinished)   break;
				}

				forceTermination();

				return Status.OK_STATUS;
			}

			// TODO remove
			private int loadedClassCount = 0;
			
			private boolean handleClassLoaded(ClassPrepareEvent event, Set<String> debugClassnames) {
				ReferenceType referenceType = event.referenceType();
				String loadedClassname = referenceType.name();
				dbg("classLoaded " + loadedClassname);
				if (!debugClassnames.contains(loadedClassname))   return true;

				debugClassnames.remove(loadedClassname);
				dbg("loaded: " + loadedClassname + " #" + (++loadedClassCount) + " remaining: " + debugClassnames.size() + " " + new TreeSet<String>(debugClassnames).toString());

				loadedClassnameToJDILocations.put(loadedClassname, referenceType);

//				dbg("strata " + referenceType.name() + " " + referenceType.availableStrata());
//				dbg("defStratum " + referenceType.defaultStratum());

				placeDeferredBreakpoints(loadedClassname, referenceType);
				
				return true;
			}

			private void placeDeferredBreakpoints(String loadedClassname, ReferenceType referenceType) {
				List<Pair<Location, EObject>> deferredLocations = loadedClassnameToDeferredLocation.get(loadedClassname);
				if (referenceType.defaultStratum().contains(DEFAULT_STRATUM_NAME) && deferredLocations == null) dbg("noDeferredForXStratum");
				if (deferredLocations == null) {
					return;
				}

				dbg("deferredsFor " + loadedClassname + " " + deferredLocations);

				for (Pair<Location, EObject> deferred: deferredLocations) {
					dbg("placeDeferredBp " + deferred);
					Location location = deferred.getKey();
					EObject modelElement = deferred.getValue();
					placeJdiBreakpoint(location, referenceType, modelElement);
				}
			}

			private void forceTermination() {
				if (!isTerminated()) {
					try {
						getDebugTarget().terminate();
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
			}

			private void waitIfSuspended() {
				while (isVmJobSuspended) {
					vmJobWasSuspended = true;
					synchronized (vmJobLock) {
						try {
							wait();
						} catch (InterruptedException e) {
						}
					}
				}
			}

			private boolean handleBreakpoint(BreakpointEvent event) {
				com.sun.jdi.Location stoppedAt = event.location();

				// dbg("Breakpoint found " + stoppedAt);

				try {
					String sourceFileName = stoppedAt.sourceName();
					int locationLine = stoppedAt.lineNumber() - 1;

					// TODO is removing the .java extension always good enough?
					String sourceName = removeLastDotSection(sourceFileName);

					EObject eObject = jdiLocationToEObject.get(new Pair<>(sourceName, locationLine));
					// dbg("BReobj " + sourceName + " " + locationLine + " " + eObject);
					
					animate(eObject);
				} catch (AbsentInformationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return true;
			}

			protected void animate(EObject element) {
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
		};
	}

	@Override
	public void suspend(Suspend_Request arg0) {
		isVmJobSuspended = true;
		vm.suspend();
	}

	@Override
	public void terminate(Terminate_Request arg0) {
		dbg("terminated");
		setIsTerminated(true);
		if (vmJob != null) {
			vmJob.done(Status.CANCEL_STATUS);
		}
		if (vm != null) {
			vm.exit(0);
		}
	}

	@Override
	public void disconnect() {
		dbg("disconnected");
		setIsTerminated(true);
		if (vmJob != null) {
			vmJob.done(Status.CANCEL_STATUS);
		}
		if (vm != null) {
			vm.exit(0);
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

	/** Typical usage: to remove {@code .java} postfixes.
	 *  @return The input string without the last dot in it and everything that comes after that.
	 *          If the text does not contain any dots, returns the original text.  */
    public static String removeLastDotSection(String in){
        if(in == null) {
            return null;
        }
        int lastDotIdx = in.lastIndexOf(".");
        if(lastDotIdx <= 0){
            return in;
        }
        return in.substring(0, lastDotIdx);
    }
}
