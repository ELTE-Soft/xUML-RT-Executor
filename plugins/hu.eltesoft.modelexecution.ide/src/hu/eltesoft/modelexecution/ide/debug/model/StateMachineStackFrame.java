package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.ide.IdePlugin;

/**
 * A stack frame that represents the execution at a state, transition or
 * pseudostate.
 */
public class StateMachineStackFrame extends StackFrame {

	private static final String UNKNOWN_STACK_FRAME = "?";

	private NamedElement modelElement;

	public StateMachineStackFrame(StateMachineInstance stateMachine, NamedElement modelElement) {
		super(stateMachine, null);
		setModelElement(modelElement);
	}

	@Override
	public String getLabel() {
		try {
			return getName();
		} catch (DebugException e) {
			IdePlugin.logError("Name could not be retrived", e);
			return UNKNOWN_STACK_FRAME;
		}
	}

	@Override
	public String getName() throws DebugException {
		if (modelElement != null && modelElement instanceof NamedElement) {
			String elementType = modelElement.eClass().getName();
			return String.format("%s [%s]", ((NamedElement) modelElement).getName(), elementType);
		} else {
			return getThread().getName();
		}
	}

	@Override
	public String getDetails() {
		return null; // not shown
	}

	@Override
	public Image getImage() {
		// show the icon corresponding to the element on the debugger is stopped
		if (modelElement != null) {
			IImage image = ImageQuery.getEObjectImage(modelElement);
			Device device = Display.getCurrent();
			return new Image(device, image.getInputStream());
		} else {
			return null;
		}
	}

	@Override
	public int getLineNumber() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCharStart() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCharEnd() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canStepInto() {
		// currently not supported to step into the action code
		return false;
	}

	@Override
	public boolean canStepOver() {
		return true;
	}

	@Override
	public boolean canStepReturn() {
		return false;
	}

	@Override
	public void stepInto() throws DebugException {
	}

	@Override
	public void stepOver() throws DebugException {
		getXUmlRtDebugTarget().stepOver(this);
	}

	@Override
	public void stepReturn() throws DebugException {
	}

	public void setModelElement(NamedElement modelElement) {
		this.modelElement = modelElement;
		this.resourceSet = modelElement.eResource().getResourceSet();
	}

	public NamedElement getModelElement() {
		if (modelElement == null) {
			setModelElement(getVMBrowser().loadModelElement(this, resourceSet));
		}
		return modelElement;
	}

	@Override
	protected void loadVariables() throws DebugException {
		if (variables == null) {
			variables = getVMBrowser().loadDataOfStackFrame(this);
		}
	}

}