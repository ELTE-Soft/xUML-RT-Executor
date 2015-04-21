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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdi.Bootstrap;
import org.eclipse.jdt.debug.core.JDIDebugModel;
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

import com.google.common.base.Optional;
import com.sun.jdi.AbsentInformationException;
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
	
	private BreakpointRegistry bpReg = new BreakpointRegistry();
	private Map<String, DebugSymbols> filenameToDebugSymbols = new HashMap<>();
	private Map<String, ReferenceType> loadedClassnameToJDILocations = new HashMap<>();
	
	public XUmlRtExecutionEngine() {
	}

	@Override
	public void init(EObject eObjectToExecute, String[] args,
			MokaDebugTarget mokaDebugTarget, int requestPort, int replyPort,
			int eventPort) throws UnknownHostException, IOException {
		super.init(eObjectToExecute, args, mokaDebugTarget, requestPort, replyPort,
				eventPort);

		dbg("--------------------------------");
		dbg("target# " + mokaDebugTarget.getLaunch().getDebugTargets().length);
		
		Region region = getStateMachineRegion(eObjectToExecute);
		if (region == null) {
			setIsTerminated(true);
			return;
		}

		AnimationUtils.init(eObjectToExecute);
		if (this.debugTarget != null) {
			this.debugTarget.setName("xUML-Rt State machine");
		}

		Resource res = eObjectToExecute.eResource();
		ChangeListenerM2MTranslator translatorOfEmfRes = BuilderListenerInterface.getTranslatorOfEmfRes(res);
		containerNameProvider = translatorOfEmfRes.getContainerNameProvider();
		EList<Vertex> subvertices = region.getSubvertices();
		if (subvertices.size() == 0) {
			// TODO error message: no vertices in region
		}
		Vertex aVertex = subvertices.get(0);
		String fullyQualifiedName = containerNameProvider.getContainerName(aVertex);

		if (fullyQualifiedName == null) {
			// TODO proper error message
			dbg("NULL fully qualified name!");
		} else {
			dbg("fully qualified name: " + fullyQualifiedName);
		}

		IDebugTarget debugTarget = mkDebugTarget(mokaDebugTarget, fullyQualifiedName);

		loadDebugSymbols(mokaDebugTarget);
		
		loadDebuggedClasses();
	}

	private void dbg(String string) {
		System.out.println(string);
	}

	/** Ensures that all classes that have associated .symbols files
	 *  are loaded into the VM. */
	private void loadDebuggedClasses() {
		Set<String> debugClassnames = getDebugClassnames(); 
		
		listenForClassLoadEvents(vm, true);

		vm.resume();

		EventQueue eventQueue = vm.eventQueue();
		while (debugClassnames.size() > 0) {
			forEachVmEvent(eventQueue, event -> {
				if (!(event instanceof ClassPrepareEvent))    return true;

				ReferenceType type = ((ClassPrepareEvent) event).referenceType();
				String loadedClassname = type.name();
				if (!debugClassnames.contains(loadedClassname))   return true;

				debugClassnames.remove(loadedClassname);
				dbg("loaded: " + loadedClassname);
				dbg("remaining: " + debugClassnames.size());

				for (int i = 0; i < 15; i++) {
					loadedClassnameToJDILocations.put(loadedClassname, type);
				}

				if (debugClassnames.size() == 0) {
					return false;
				}
				
				return true;
			});

		}
		vm.suspend();
		
		listenForClassLoadEvents(vm, false);
	}

	/** @param consumer It processes the event, and returns true if the event loop should continue.
	 *  @return The virtual machine is stopped. */
	private boolean forEachVmEvent(EventQueue eventQueue, Predicate<Event> consumer) {
		EventSet eventSet = null;
		try {
			eventSet = eventQueue.remove();
			eventSet.stream().forEach(event -> dbg(event.toString()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	/** Turns listening for VM class load events on and off. */
	private void listenForClassLoadEvents(VirtualMachine vm, boolean shouldListen) {
		vm.eventRequestManager().createClassPrepareRequest().setEnabled(shouldListen);
	}

	private Set<String> getDebugClassnames() {
		String symExt = "." + SYMBOLS_EXTENSION;
		return filenameToDebugSymbols.keySet().stream()
				.filter(filename -> filename.endsWith(symExt))
				.map(XUmlRtExecutionEngine::removeFromLastDot)
				.collect(Collectors.toSet());
	}

	/** @return The argument, with the portion after the last dot removed (including the dot).
	 *          Useful for removing file extensions, for example. */
	static private String removeFromLastDot(String s) {
		return s.substring(0, s.lastIndexOf('.'));
	}
	
	private void loadDebugSymbols(MokaDebugTarget mokaDebugTarget)
			throws IOException, FileNotFoundException {
		String baseDir = getBaseDir(mokaDebugTarget);
		
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

	/** @return The absolute path to the base directory of the xUML-RT project. */
	private String getBaseDir(MokaDebugTarget mokaDebugTarget) {
/* TODO fix or remove
		try {
			String uriAttr = mokaDebugTarget.getLaunch().getLaunchConfiguration().getAttribute("URI_ATTRIBUTE", ".");
//			String fileString = URI.createPlatformResourceURI(uriAttr, true).toFileString();
//			String fileString = URI.createURI(uriAttr).toFileString();
			URI platformResourceURI = URI.createPlatformResourceURI(uriAttr, true);
			
			dbg(uriAttr);
			dbg("fs " + resourceURIToAbsolutePath(platformResourceURI));
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/

		// TODO remove fake dir
		return "t:\\runtime-MokaModel2\\Test1";
	}

	/** @return The state machine region if {@code eObjectToExecute} is a state machine,
	 * otherwise {@code null}. */
	private Region getStateMachineRegion(EObject eObjectToExecute) {
		if (!isExecutingStateMachine(eObjectToExecute)) {
			errorNotExecutingStateMachine();
			return null;
		}

		StateMachine machine = (StateMachine) eObjectToExecute;
		if (machine.getRegions().size() < 1) {
// TODO proper error message
//			getOutputStream().write("Error: no state machine region found!\n");
			return null;
		}

		return machine.getRegions().get(0);
	}

	
	// TODO remove
	IDebugTarget mkDebugTarget(MokaDebugTarget mokaDebugTarget, String fullyQualifiedName) {
		VirtualMachineManager manager = Bootstrap.virtualMachineManager();
		LaunchingConnector defaultConnector = manager.defaultConnector();

		Map<String, ? extends Argument> arguments = mkVmArgs(defaultConnector, fullyQualifiedName, mokaDebugTarget);

		try {
			vm = defaultConnector.launch(arguments);
			vm.setDefaultStratum(DEFAULT_STRATUM_NAME);
			vm.resume();
			// TODO give better name
			String name = "xUML-RT Virtual Machine";
			IProcess process = mokaDebugTarget.getProcess();
			boolean allowTerminate = true;
			boolean allowDisconnect = true;
			return JDIDebugModel.newDebugTarget(mokaDebugTarget.getLaunch(), vm, name, process, allowTerminate, allowDisconnect);
		} catch (IllegalConnectorArgumentsException | VMStartException | IOException e) {
			// TODO proper error message
			e.printStackTrace();
			return null;
		}
	}
	

	private Map<String, ? extends Argument> mkVmArgs(LaunchingConnector connector, String fullyQualifiedName, MokaDebugTarget mokaDebugTarget) {
		Map<String, ? extends Argument> arguments = connector.defaultArguments();
		String testRuntimeClassName = TestRuntime.class.getCanonicalName();
		// TODO get it from Boldi
		String feedName = "feed";
		
		// TODO remove hack: we have to decide how to get from Region1 to the Loop class
		fullyQualifiedName = "Loop";
		
		// TODO other arguments
		String[] args = {testRuntimeClassName, fullyQualifiedName, feedName}; 
		
		dbg("vmargs " + String.join(" ", args));
		
		arguments.get("main").setValue(String.join(" ", args));
		
		
		String binClasspath = Paths.get(getBaseDir(mokaDebugTarget), DEBUG_CLASSPATH_DIR).toAbsolutePath().toString();
		// TODO remove fake dirs
		String runtimeClasspath = "F:\\vcs\\modelinterpreter\\product\\trunk\\plugins\\hu.eltesoft.modelexecution.runtime\\bin";
		String thirdPartyClasspath = "F:\\vcs\\modelinterpreter\\product\\trunk\\plugins\\hu.eltesoft.modelexecution.3pp";
		// TODO make it not Windows-only
		String fullClasspath = String.join(";", binClasspath, runtimeClasspath, thirdPartyClasspath);
		arguments.get("options").setValue("-cp " + fullClasspath + "/");

		dbg("cp " + binClasspath);

		return arguments;
	}
	
	private void errorNotExecutingStateMachine() {
		// TODO
//		getOutputStream().write(
//				"Error: the selected element is not a state machine!\n");
	}

	private boolean isExecutingStateMachine(EObject eObjectToExecute) {
		return eObjectToExecute instanceof StateMachine;
	}

	@Override
	public void addBreakpoint(MokaBreakpoint breakpoint) {
		dbg("adding bp " + breakpoint);
		
		EObject modelElement = breakpoint.getModelElement();
		if (!(modelElement instanceof Vertex || modelElement instanceof Transition)) {
			// TODO note: breakpoints are only supported on Vertex and Transition nodes
			return;
		}

		Reference reference = new Reference(modelElement);
		Optional<Location> optLocation = referenceToLocation(reference);

		if (!optLocation.isPresent()) {
			dbg("missing breakpoint location!!!");

			// TODO error msg
			return;
		}

		Location location = optLocation.get();
		dbg("found " + reference + " " + modelElement + " " + location);

		String containerName = containerNameProvider.getContainerName(breakpoint.getModelElement());
		dbg("container " + containerName);

		// TODO what about multiline Locations? use all lines between getStartLine and getEndLine?
		// TODO what about if locationsOfLine returns multiple lines?
		try {
			com.sun.jdi.Location jdiLocation = loadedClassnameToJDILocations.get(containerName).locationsOfLine(location.getStartLine()).get(0);
			vm.eventRequestManager().createBreakpointRequest(jdiLocation).setEnabled(true);
			
			dbg("addedBp " + jdiLocation);
		} catch (AbsentInformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/** @return The {@link Location} of the {@link Reference}, or null if not found.
	 *          Tries to resolve the reference as unqualified and both as {@link StateQualifiers.Entry}
	 *          and a {@link StateQualifiers.Exit}. */
	private Optional<Location> referenceToLocation(Reference reference) {
		dbg("kset " + filenameToDebugSymbols.entrySet());

		for (Map.Entry<String, DebugSymbols> entry : filenameToDebugSymbols.entrySet()) {
			String filename = entry.getKey();
			DebugSymbols debugSymbols = entry.getValue();
			LocationRegistry locationRegistry = debugSymbols.getLocationRegistry();

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
			vmJob.schedule();
		}
	}

	private Job mkVmJob() {
		return new Job("xUML-RT Execution") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				dbg("job started");
				vm.resume();

				EventQueue eventQueue = vm.eventQueue();
				while (true) {
					waitIfSuspended();

					if (vmJobWasSuspended) {
						vm.resume();
					}

					dbg("handling events...");

					vm.resume();

					boolean vmIsFinished = forEachVmEvent(eventQueue, event -> {
						dbg("evt " + event);

						if (!(event instanceof BreakpointEvent))   return true;
						
						handleBreakpoint(event);

						return true;
					});

					dbg("handled events...");

					if (vmIsFinished)   break;
				}

				forceTermination();

				return Status.OK_STATUS;
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

			private void handleBreakpoint(Event event) {
				com.sun.jdi.Location stoppedAt = ((BreakpointEvent) event).location();

				dbg("Breakpoint found " + stoppedAt);

				/*
				Vertex state = representation.states
						.get(stoppedAt.lineNumber() - 1);
				animate(state);
				try {
					dbg("Break on state: " + state.getName() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
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
}
