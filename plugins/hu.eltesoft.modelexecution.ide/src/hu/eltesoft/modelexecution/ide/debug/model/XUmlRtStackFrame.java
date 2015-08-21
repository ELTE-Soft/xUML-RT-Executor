package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.debug.MokaDebugElement;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;

public abstract class XUmlRtStackFrame extends MokaDebugElement implements IPresentation, IStackFrame  {

	protected String name;
	protected XUmlRtStateMachineInstance smInstance;
	protected NamedElement modelElement;
	private List<XUmlRtVariable> variables = new LinkedList<>();

	public XUmlRtStackFrame(MokaDebugTarget target, XUmlRtStateMachineInstance stateMachine, String name) {
		super(target);
		smInstance = stateMachine;
		this.name = name;
	}

	@Override
	public String getLabel() {
		String elementType = modelElement.eClass().getName();
		return String.format("%s [%s]", name, elementType);
	}

	@Override
	public String getDetails() {
		return null; // not shown
	}

	@Override
	public Image getImage() {
		// show the icon corresponding to the element on the debugger is stopped
		IImage image = ImageQuery.getEObjectImage(modelElement);
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}

	@Override
	public boolean canStepInto() {
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
	public boolean isStepping() {
		return false;
	}

	@Override
	public void stepInto() throws DebugException {		
	}

	@Override
	public void stepOver() throws DebugException {		
	}

	@Override
	public void stepReturn() throws DebugException {
	}

	@Override
	public boolean canResume() {
		return false;
	}

	@Override
	public boolean canSuspend() {
		return false;
	}

	@Override
	public boolean isSuspended() {
		return false;
	}

	@Override
	public void resume() throws DebugException {
	}

	@Override
	public void suspend() throws DebugException {
	}

	@Override
	public boolean canTerminate() {
		return false;
	}

	@Override
	public boolean isTerminated() {
		return false;
	}

	@Override
	public void terminate() throws DebugException {		
	}

	@Override
	public IThread getThread() {
		return smInstance;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		return variables.toArray(new IVariable[variables.size()]);
	}

	public void addVariable(XUmlRtVariable variable) {
		variables.add(variable);
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return !variables.isEmpty();
	}

	@Override
	public int getLineNumber() throws DebugException {
		return 0;
	}

	@Override
	public int getCharStart() throws DebugException {
		return 0;
	}

	@Override
	public int getCharEnd() throws DebugException {
		return 0;
	}

	@Override
	public String getName() throws DebugException {
		return name;
	}

	@Override
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return null;
	}

	@Override
	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	public NamedElement getModelElement() {
		return modelElement;
	}

	public void setModelElement(NamedElement modelElement) {
		this.modelElement = modelElement;
	}

}