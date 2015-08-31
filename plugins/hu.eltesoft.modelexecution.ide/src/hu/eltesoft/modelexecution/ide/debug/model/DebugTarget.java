package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineBrowser;
import hu.eltesoft.modelexecution.ide.debug.registry.BreakpointRegistry;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtDebugModelPresentation;

public class DebugTarget extends DebugElement implements IDebugTarget {

	private MokaDebugTarget mokaDebugTarget;

	private List<StateMachineInstance> smInstances = new LinkedList<>();
	
	private BreakpointRegistry breakpoints = new BreakpointRegistry();

	private ResourceSet resourceSet;
	
	private VirtualMachineBrowser vmBrowser;

	private ILaunch launch;

	public DebugTarget(VirtualMachineBrowser vmBrowser, MokaDebugTarget mokaDebugTarget, ResourceSet resourceSet, ILaunch launch) {
		super(null);
		this.vmBrowser = vmBrowser;
		this.mokaDebugTarget = mokaDebugTarget;
		this.resourceSet = resourceSet;
		this.launch = launch;
		setDebugTarget(this);
	}

	@Override
	public IThread[] getThreads() throws DebugException {
		return smInstances.toArray(new StateMachineInstance[smInstances.size()]);
	}

	@Override
	public boolean hasThreads() throws DebugException {
		return !smInstances.isEmpty();
	}

	@Override
	public String getName() throws DebugException {
		return "xUML-RT debug target";
	}

	// rest of the functionality is delegated to the moka debug target

	@Override
	public boolean canTerminate() {
		return mokaDebugTarget.canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return mokaDebugTarget.isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		mokaDebugTarget.terminate();
	}

	public void terminated() {
		smInstances.clear();
		XUmlRtDebugModelPresentation.refreshDebugElements();
	}

	@Override
	public boolean canResume() {
		return mokaDebugTarget.canResume();
	}

	@Override
	public void resume() throws DebugException {
		mokaDebugTarget.resume();
	}

	public void resumed() {
		smInstances.forEach(inst -> inst.clearStackFrames());
		XUmlRtDebugModelPresentation.refreshDebugElements();
	}

	@Override
	public boolean canSuspend() {
		return mokaDebugTarget.canSuspend();
	}

	@Override
	public boolean isSuspended() {
		return mokaDebugTarget.isSuspended();
	}

	@Override
	public void suspend() throws DebugException {
		mokaDebugTarget.suspend();
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

	@Override
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return mokaDebugTarget.supportsBreakpoint(breakpoint);
	}

	@Override
	public boolean canDisconnect() {
		return mokaDebugTarget.canDisconnect();
	}

	@Override
	public void disconnect() throws DebugException {
		mokaDebugTarget.disconnect();
	}

	@Override
	public boolean isDisconnected() {
		return mokaDebugTarget.isDisconnected();
	}

	@Override
	public boolean supportsStorageRetrieval() {
		return mokaDebugTarget.supportsStorageRetrieval();
	}

	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return mokaDebugTarget.getMemoryBlock(startAddress, length);
	}

	@Override
	public IProcess getProcess() {
		return mokaDebugTarget.getProcess();
	}

	public void stepOver(StateMachineStackFrame stateMachineStackFrame) {
		try {
			mokaDebugTarget.resume(stateMachineStackFrame, DebugEvent.STEP_OVER);
		} catch (DebugException e) {
			IdePlugin.logError("While trying to step over", e);
		}
	}

	public void addSMInstance(StateMachineInstance smInstance) {
		smInstances.add(smInstance);
		XUmlRtDebugModelPresentation.refreshDebugElements();
	}

	public void removeSMInstance(String classId, int instanceId) {
		smInstances.removeIf(t -> t.getClassId().equals(classId) && t.getInstanceId() == instanceId);
		XUmlRtDebugModelPresentation.refreshDebugElements();
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
					vmBrowser.addEventVariable(stackFrame);
				} else {
					stackFrame = new StateMachineStackFrame(smInstance, null);
				}
				smInstance.setStackFrames(new StackFrame[] { stackFrame });
				vmBrowser.loadDataOfSMInstance(stackFrame, resourceSet);
				
				smInstance.setSuspended(true, breakpoints.get(modelElement));
				XUmlRtDebugModelPresentation.refreshDebugElements();
			}
		} catch (DebugException e) {
			IdePlugin.logError("Error while updating sm instances");
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

}
