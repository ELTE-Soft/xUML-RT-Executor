package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.Arrays;
import java.util.List;

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

import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineBrowser;
import hu.eltesoft.modelexecution.ide.debug.model.utils.CombiningElementDebugContentProvider;

/**
 * Thread-like debug model element for a state machine instance.
 */
public class StateMachineInstance extends SuspendableThread implements IPresentation {

	private int instanceId;

	// lazily populated
	private List<ModelVariable> attributes = null;

	private ClassInstances cls;

	public StateMachineInstance(ClassInstances parent, int instanceId) {
		super(parent);
		this.cls = parent;
		this.instanceId = instanceId;
	}

	@Override
	public String getLabel() {
		return getName();
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
		return cls.getClassId();
	}

	public int getInstanceId() {
		return instanceId;
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
	public String getName() {
		return getClassName() + "#" + getInstanceId();
	}

	@Override
	public IBreakpoint[] getBreakpoints() {
		return new IBreakpoint[0];
	}

	public void clearStackFrames() {
		for (StackFrame stackFrame : stackFrames) {
			getDebugControl().removeDebugElement(stackFrame);
		}
		stackFrames.clear();
	}

	public void setStackFrames(StackFrame[] stackFrames) {
		clearStackFrames();
		this.stackFrames.addAll(Arrays.asList(stackFrames));
		for (StackFrame stackFrame : stackFrames) {
			getDebugControl().addDebugElement(this, stackFrame);
		}
	}

	public String getClassName() {
		return cls.getName();
	}

	// FIXME: this should be called when the debug view populates the variables
	// view when selecting a state machine instance
	public ModelVariable[] getAttributes() {
		if (attributes == null) {
			VirtualMachineBrowser vmBrowser = getVMBrowser();
			try {
				attributes = vmBrowser.getAttributes(this);
			} catch (DebugException e) {
				return new ModelVariable[0];
			}
		}
		if (attributes == null) {
			return new ModelVariable[0];
		}
		return attributes.toArray(new ModelVariable[attributes.size()]);
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

	@Override
	public DebugElement getParent() {
		return cls;
	}

}
