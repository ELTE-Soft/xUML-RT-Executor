package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Thread-like debug model element for a state machine instance.
 */
public class StateMachineInstance extends DebugElement implements IThread, IPresentation {

	private String classId;
	private int instanceId;
	protected String name;
	private boolean isSuspended;
	private List<StackFrame> stackFrames = new LinkedList<>();
	private IBreakpoint breakPointStoppedOn;
	private String className;

	public StateMachineInstance(DebugTarget debugTarget, String classId, int instanceId, String originalName) {
		super(debugTarget);
		this.classId = classId;
		this.instanceId = instanceId;
		this.className = originalName;
		name = originalName + "#" + instanceId;
	}

	@Override
	public String getLabel() {
		return name;
	}

	@Override
	public String getDetails() {
		return null; // not shown
	}

	@Override
	public Image getImage() {
		// show the image corresponding to state machines
		EObject component = UMLFactory.eINSTANCE.createStateMachine();
		IImage image = ImageQuery.getEObjectImage(component);
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}

	public String getClassId() {
		return classId;
	}

	public int getInstanceId() {
		return instanceId;
	}

	@Override
	public boolean canResume() {
		return isSuspended();
	}

	@Override
	public boolean canSuspend() {
		return !isSuspended();
	}

	@Override
	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended, IBreakpoint breakPoint) {
		this.isSuspended = isSuspended;
		breakPointStoppedOn = breakPoint;
	}

	@Override
	public void resume() throws DebugException {
		getXUmlRtDebugTarget().resume();
	}

	@Override
	public void suspend() throws DebugException {
		getXUmlRtDebugTarget().resume();
	}

	@Override
	public boolean canStepInto() {
		return this.isSuspended() && !stackFrames.isEmpty() && stackFrames.get(0).canStepInto();
	}

	@Override
	public boolean canStepOver() {
		return this.isSuspended() && !stackFrames.isEmpty() && stackFrames.get(0).canStepOver();
	}

	@Override
	public boolean canStepReturn() {
		return this.isSuspended() && !stackFrames.isEmpty() && stackFrames.get(0).canStepReturn();
	}

	@Override
	public boolean isStepping() {
		return isSuspended();
	}

	@Override
	public void stepInto() throws DebugException {
		stackFrames.get(0).stepInto();
	}

	@Override
	public void stepOver() throws DebugException {
		stackFrames.get(0).stepOver();
	}

	@Override
	public void stepReturn() throws DebugException {
		stackFrames.get(0).stepReturn();
	}

	@Override
	public boolean canTerminate() {
		return getDebugTarget().canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		getXUmlRtDebugTarget().terminate();
	}

	@Override
	public IStackFrame[] getStackFrames() throws DebugException {
		return stackFrames.toArray(new StateMachineStackFrame[stackFrames.size()]);
	}

	@Override
	public boolean hasStackFrames() throws DebugException {
		return !stackFrames.isEmpty();
	}

	@Override
	public int getPriority() throws DebugException {
		return 0;
	}

	@Override
	public IStackFrame getTopStackFrame() throws DebugException {
		return stackFrames.get(0);
	}

	@Override
	public String getName() throws DebugException {
		return name;
	}

	@Override
	public IBreakpoint[] getBreakpoints() {
		if (isSuspended) {
			return new IBreakpoint[] { breakPointStoppedOn };
		} else {
			return new IBreakpoint[0];
		}
	}

	public void clearStackFrames() {
		stackFrames.clear();
	}

	public void setStackFrames(StackFrame[] stackFrames) {
		this.stackFrames.clear();
		this.stackFrames.addAll(Arrays.asList(stackFrames));
	}

	public String getClassName() {
		return className;
	}
}
