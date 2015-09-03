package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.debug.XUmlRtExecutionEngine;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineBrowser;
import hu.eltesoft.modelexecution.ide.debug.model.utils.CombiningElementDebugContentProvider;
import hu.eltesoft.modelexecution.ide.debug.registry.BreakpointRegistry;
import hu.eltesoft.modelexecution.ide.debug.ui.DebugViewController;
import hu.eltesoft.modelexecution.ide.debug.util.ModelUtils;
import hu.eltesoft.modelexecution.ide.launch.ModelExecutionLaunchConfig;

public class DebugTarget extends DelegatingDebugTarget {

	private Component defaultComponent = null;

	private List<Component> components = new LinkedList<>();

	private BreakpointRegistry breakpoints = new BreakpointRegistry();

	private ResourceSet resourceSet;

	private VirtualMachineBrowser vmBrowser;

	private ILaunch launch;

	private DebugViewController debugControl = new DebugViewController();

	private EObject entryPoint;

	public DebugTarget(VirtualMachineBrowser vmBrowser, XUmlRtExecutionEngine xUmlRtExecutionEngine,
			ResourceSet resourceSet, ILaunch launch) {
		super(null, xUmlRtExecutionEngine.getDebugTarget());
		this.entryPoint = ModelUtils
				.findEObject(ModelExecutionLaunchConfig.getEntryPoint(launch.getLaunchConfiguration()), resourceSet);
		this.vmBrowser = vmBrowser;
		this.resourceSet = resourceSet;
		this.launch = launch;

		setDebugTarget(this);
	}

	public DebugViewController getDebugControl() {
		return debugControl;
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
		return ((NamedElement) entryPoint).getQualifiedName();
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

	public void addSMInstance(StateMachineInstance smInstance) {
		boolean selectElement = !hasSMInstance();
		if (defaultComponent == null) {
			defaultComponent = new Component(this, Messages.DebugTarget_default_component_label);
			debugControl.addDebugElement(this, defaultComponent);
		}
		ClassInstances cls = defaultComponent.getOrCreateClassFor(smInstance);
		cls.addStateMachineInstance(smInstance);
		if (selectElement) {
			debugControl.selectAndExpand(this, smInstance);
		}
	}

	public void removeSMInstance(String classId, int instanceId) {
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

		String actualSMInstance = vmBrowser.getActualSMInstance();
		try {
			List<StateMachineInstance> smInstances = getSmInstances();
			for (StateMachineInstance smInstance : smInstances) {
				StateMachineStackFrame stackFrame;
				if (smInstance.getName().equals(actualSMInstance)) {
					stackFrame = new StateMachineStackFrame(smInstance, (NamedElement) modelElement);
				} else {
					stackFrame = new StateMachineStackFrame(smInstance, resourceSet);
				}
				debugControl.updateElement(smInstance);
				smInstance.setStackFrames(new StackFrame[] { stackFrame });
				debugControl.reselect();

				isSuspended = true;
			}
		} catch (DebugException e) {
			IdePlugin.logError("Error while updating sm instances"); //$NON-NLS-1$
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

	@SuppressWarnings({ "unchecked", "restriction" })
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider.class) {
			return (T) new CombiningElementDebugContentProvider<DebugTarget>(
					dt -> new Object[][] { dt.getComponents() });
		} else {
			return super.getAdapter(adapter);
		}
	}

}
