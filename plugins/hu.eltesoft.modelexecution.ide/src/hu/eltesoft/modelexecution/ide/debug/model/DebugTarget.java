package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.ArrayList;
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

public class DebugTarget extends DelegatingDebugTarget {

	private List<StateMachineInstance> smInstances = new LinkedList<>();

	private List<Component> components = new LinkedList<>();

	private BreakpointRegistry breakpoints = new BreakpointRegistry();

	private ResourceSet resourceSet;

	private VirtualMachineBrowser vmBrowser;

	private ILaunch launch;

	private DebugViewController debugControl = new DebugViewController();
	
	public DebugTarget(VirtualMachineBrowser vmBrowser, XUmlRtExecutionEngine xUmlRtExecutionEngine, ResourceSet resourceSet,
			ILaunch launch) {
		super(null, xUmlRtExecutionEngine.getDebugTarget());
		this.vmBrowser = vmBrowser;
		this.resourceSet = resourceSet;
		this.launch = launch;
		setDebugTarget(this);
	}

	@Override
	public IThread[] getThreads() throws DebugException {
		return smInstances.toArray(new IThread[smInstances.size()]);
	}

	@Override
	public boolean hasThreads() throws DebugException {
		return !smInstances.isEmpty();
	}

	@Override
	public String getName() throws DebugException {
		return Messages.DebugTarget_debug_target_label;
	}

	public void terminated() {
		components.clear();
		smInstances.clear();
		debugControl.refreshDebugElements();
	}

	public void resumed() {
		smInstances.forEach(inst -> inst.clearStackFrames());
		debugControl.refreshDebugElements();
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
		smInstances.add(smInstance);
		debugControl.refreshDebugElements();
	}

	public void removeSMInstance(String classId, int instanceId) {
		smInstances.removeIf(t -> t.getClassId().equals(classId) && t.getInstanceId() == instanceId);
		debugControl.refreshDebugElements();
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
			for (StateMachineInstance smInstance : smInstances) {
				StateMachineStackFrame stackFrame;
				if (smInstance.getName().equals(actualSMInstance)) {
					stackFrame = new StateMachineStackFrame(smInstance, (NamedElement) modelElement);
				} else {
					stackFrame = new StateMachineStackFrame(smInstance, resourceSet);
				}
				smInstance.setStackFrames(new StackFrame[] { stackFrame });
				
				isSuspended = true;

				debugControl.refreshDebugElements();
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

	public Component[] getComponents() {
		if ((components.isEmpty() || !smInstances.isEmpty()) && !isTerminated()) {
			// puts the state machine instances into a default component
			ArrayList<Object> ret = new ArrayList<>(components.size() + 1);
			Component defaultComponent = new Component(Messages.DebugTarget_default_component_label);
			ret.add(defaultComponent);
			for (StateMachineInstance instance : smInstances) {
				defaultComponent.addStateMachineInstance(instance);
			}
			ret.addAll(components);
			return ret.toArray(new Component[ret.size()]);
		}
		return components.toArray(new Component[components.size()]);
	}

	public StateMachineInstance[] getStateMachineInstances() {
		return smInstances.toArray(new StateMachineInstance[smInstances.size()]);
	}

	@SuppressWarnings({ "unchecked", "restriction" })
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider.class) {
			return (T) new CombiningElementDebugContentProvider<DebugTarget>(
					dt -> new Object[][] { dt.getComponents() });
		}
		return super.getAdapter(adapter);
	}

}
