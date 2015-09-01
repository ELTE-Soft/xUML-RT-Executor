package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.Arrays;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLFactory;

import hu.eltesoft.modelexecution.ide.debug.model.utils.CombiningElementDebugContentProvider;

/**
 * Thread-like debug model element for a state machine instance.
 */
public class StateMachineInstance extends SuspendableThread implements IPresentation {

	private String classId;
	private int instanceId;
	protected String name;
	private IBreakpoint breakPointStoppedOn;
	private String className;

	public StateMachineInstance(DelegatingDebugTarget debugTarget, String classId, int instanceId, String originalName) {
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

	public void setSuspended(boolean isSuspended, IBreakpoint breakPoint) {
		this.isSuspended = isSuspended;
		breakPointStoppedOn = breakPoint;
	}

	@Override
	public IStackFrame[] getStackFrames() {
		return stackFrames.toArray(new StateMachineStackFrame[stackFrames.size()]);
	}

	@Override
	public boolean hasStackFrames() {
		return !stackFrames.isEmpty();
	}

	@Override
	public int getPriority() throws DebugException {
		return 0;
	}

	@Override
	public IStackFrame getTopStackFrame() {
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
	
	@SuppressWarnings({ "unchecked", "restriction" })
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider.class) {
			return (T) new CombiningElementDebugContentProvider<StateMachineInstance>(
					dt -> new Object[][] { dt.getStackFrames() });
		}
		return super.getAdapter(adapter);
	}

}
