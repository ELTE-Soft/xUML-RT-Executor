package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.xtext.xbase.lib.Pair;

import hu.eltesoft.modelexecution.ide.common.launch.LaunchConfig;
import hu.eltesoft.modelexecution.ide.common.process.IProcessWithController;
import hu.eltesoft.modelexecution.ide.common.runtime.RuntimeControllerClient;
import hu.eltesoft.modelexecution.ide.debug.Messages;
import hu.eltesoft.modelexecution.ide.debug.XUmlRtExecutionEngine;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineBrowser;
import hu.eltesoft.modelexecution.ide.debug.model.utils.CombiningContentProvider;
import hu.eltesoft.modelexecution.ide.debug.registry.BreakpointRegistry;
import hu.eltesoft.modelexecution.ide.debug.ui.DebugViewController;
import hu.eltesoft.modelexecution.ide.debug.ui.VariablesViewController;
import hu.eltesoft.modelexecution.ide.debug.util.ModelUtils;

public class XUMLRTDebugTarget extends DelegatingDebugTarget {

	private Component defaultComponent = null;

	private List<Component> components = new LinkedList<>();

	private BreakpointRegistry breakpoints = new BreakpointRegistry();

	private ResourceSet resourceSet;

	private VirtualMachineBrowser vmBrowser;

	private ILaunch launch;

	private DebugViewController debugControl = new DebugViewController();

	private VariablesViewController variableControl = new VariablesViewController();

	private EObject entryPoint;

	private String suspendedStateMachine = "";

	public XUMLRTDebugTarget(VirtualMachineBrowser vmBrowser, XUmlRtExecutionEngine xUmlRtExecutionEngine,
			ResourceSet resourceSet, ILaunch launch) {
		super(null, xUmlRtExecutionEngine.getDebugTarget());
		this.entryPoint = ModelUtils.javaNameToEObject(LaunchConfig.getEntryPoint(launch.getLaunchConfiguration()),
				resourceSet);
		this.vmBrowser = vmBrowser;
		this.resourceSet = resourceSet;
		this.launch = launch;
		setDebugTarget(this);
	}

	@Override
	public DebugViewController getDebugControl() {
		return debugControl;
	}

	@Override
	public VariablesViewController getVariableControl() {
		return variableControl;
	}

	@Override
	public IThread[] getThreads() throws DebugException {
		List<StateMachineInstance> smInstances = getSmInstances();
		return smInstances.toArray(new IThread[smInstances.size()]);
	}

	@Override
	public boolean hasThreads() throws DebugException {
		return hasSMInstance();
	}

	@Override
	public String getName() {
		if (entryPoint != null) {
			return ((NamedElement) entryPoint).getQualifiedName() + suspendedStateMachine;
		} else {
			return Messages.XUMLRTDebugTarget_debug_target_name;
		}
	}

	public void terminated() {
		if (defaultComponent != null) {
			debugControl.removeDebugElement(defaultComponent);
		}
		defaultComponent = null;
		for (Component component : components) {
			debugControl.removeDebugElement(component);
		}
		components.clear();
	}

	public void resumed() {
		List<StateMachineInstance> smInstances = getSmInstances();
		smInstances.forEach(inst -> {
			inst.clearStackFrames();
			debugControl.updateElement(inst);
		});
		suspendedStateMachine = "";
		debugControl.updateElement(this);
	}

	@Override
	public void breakpointAdded(IBreakpoint breakpoint) {
		mokaDebugTarget.breakpointAdded(breakpoint);
	}

	@Override
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		mokaDebugTarget.breakpointRemoved(breakpoint, delta);
	}

	@Override
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		mokaDebugTarget.breakpointChanged(breakpoint, delta);
	}

	public void addSMInstance(String classId, long instanceId, String originalName) {
		if (isTerminated()) {
			return;
		}
		boolean selectElement = !hasSMInstance();
		if (defaultComponent == null) {
			defaultComponent = new Component(this, Messages.DebugTarget_default_component_label);
			debugControl.addDebugElement(defaultComponent);
		}
		StateMachineInstance added = defaultComponent.addStateMachineInstance(classId, instanceId, originalName);

		if (selectElement) {
			debugControl.addDebugElementSelected(added);
			sendStartSignal(launch);
		} else {
			debugControl.addDebugElement(added);
		}
		if (isSuspended) {
			StateMachineStackFrame stackFrame = new StateMachineStackFrame(added, resourceSet);
			added.setStackFrames(new StackFrame[] { stackFrame });
		}
	}

	private void sendStartSignal(ILaunch launch) {
		for (IProcess process : launch.getProcesses()) {
			if (process instanceof IProcessWithController) {
				RuntimeControllerClient controller = ((IProcessWithController) process).getController();
				controller.start();
				return;
			}
		}
	}

	/**
	 * Removes a terminated state machine instance from the debug model.
	 * 
	 * @return The removed instance or null if such instance was not found.
	 */
	public StateMachineInstance removeSMInstance(String classId, long instanceId) {
		if (isTerminated()) {
			return null;
		}
		List<StateMachineInstance> smInstances = defaultComponent.getSmInstances();
		StateMachineInstance removedInstance = null;
		for (StateMachineInstance smInstance : smInstances) {
			if (smInstance.getClassId().equals(classId) && smInstance.getInstanceId() == instanceId) {
				removedInstance = smInstance;
			}
		}
		defaultComponent.removeStateMachineInstance(removedInstance);
		// remove default component if became empty
		if (!defaultComponent.hasSMInstance()) {
			debugControl.removeDebugElement(defaultComponent);
			defaultComponent = null;
		}
		return removedInstance;
	}

	/**
	 * Marks each state machine as suspended. Can only be called when the
	 * underlying virtual machine is suspended.
	 *
	 * @param modelElement
	 *            the current element under the breakpoint (currently only a
	 *            state or transition)
	 */
	public void markThreadAsSuspended(EObject modelElement) {
		isSuspended = true;

		Pair<String, Long> actualSMInstance = vmBrowser.getActualSMInstance();
		List<StateMachineInstance> smInstances = getSmInstances();
		for (StateMachineInstance smInstance : smInstances) {
			StateMachineStackFrame stackFrame;
			if (actualSMInstance.getKey().equals(smInstance.getClassId())
					&& actualSMInstance.getValue().equals(smInstance.getInstanceId())) {
				// this is necessary, because the model element could be a
				// transition
				stackFrame = new StateMachineStackFrame(smInstance, (NamedElement) modelElement);
				suspendedStateMachine = " [" + smInstance.getClassName() + "#" + smInstance.getInstanceId() + "]";
				debugControl.updateElement(this);
			} else {
				// the current state of the state machine will be queried later
				stackFrame = new StateMachineStackFrame(smInstance, resourceSet);
			}
			smInstance.setStackFrames(new StackFrame[] { stackFrame });

			// force refresh of debug controls on toolbar
			debugControl.reselect();

			// force the refresh of the state machine instance to get rid of
			// phantom stack frames
//			debugControl.refresh(smInstance);
		}
	}

	public boolean hasEnabledBreakpointOn(EObject modelElement) {
		return breakpoints.hasEnabledBreakpointOn(modelElement);
	}

	public void addBreakpoint(MokaBreakpoint breakpoint) {
		breakpoints.add(breakpoint);
	}

	public void removeBreakpoint(MokaBreakpoint breakpoint) {
		breakpoints.remove(breakpoint);
	}

	@Override
	public VirtualMachineBrowser getVMBrowser() {
		return vmBrowser;
	}

	@Override
	public ILaunch getLaunch() {
		return launch;
	}

	public Component getDefaultComponent() {
		return defaultComponent;
	}

	public Component[] getComponents() {
		LinkedList<Component> ret = new LinkedList<>();
		if (defaultComponent != null) {
			ret.add(defaultComponent);
		}
		ret.addAll(components);
		return ret.toArray(new Component[ret.size()]);
	}

	public StateMachineInstance[] getStateMachineInstances() {
		List<StateMachineInstance> smInstances = getSmInstances();
		return smInstances.toArray(new StateMachineInstance[smInstances.size()]);
	}

	public boolean hasSMInstance() {
		if (defaultComponent != null) {
			return true;
		}
		for (Component component : components) {
			if (component.hasSMInstance()) {
				return true;
			}
		}
		return false;
	}

	public List<StateMachineInstance> getSmInstances() {
		List<StateMachineInstance> ret = new LinkedList<>();
		if (defaultComponent != null) {
			ret.addAll(defaultComponent.getSmInstances());
		}
		for (Component component : components) {
			ret.addAll(component.getSmInstances());
		}
		return ret;
	}

	/**
	 * @return The state machine instance that is suspended in the runtime, or
	 *         null if there isn't one.
	 */
	public StateMachineInstance getSuspendedSMInstance() {
		Pair<String, Long> actualSMInstance = vmBrowser.getActualSMInstance();
		for (StateMachineInstance instance : getSmInstances()) {
			if (actualSMInstance.equals(new Pair<>(instance.getClassId(), instance.getInstanceId()))) {
				return instance;
			}
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "restriction" })
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider.class) {
			return (T) new CombiningContentProvider<XUMLRTDebugTarget>().setMapping(IDebugUIConstants.ID_DEBUG_VIEW,
					dt -> new Object[][] { dt.getComponents() });
		} else {
			return super.getAdapter(adapter);
		}
	}

	@Override
	public DebugElement getParent() {
		return null;
	}

}
