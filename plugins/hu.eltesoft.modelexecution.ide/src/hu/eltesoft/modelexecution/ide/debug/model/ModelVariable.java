package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLFactory;

import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.debug.jvm.JDIThreadWrapper;
import hu.eltesoft.modelexecution.runtime.meta.IndexMeta;
import hu.eltesoft.modelexecution.runtime.meta.OwnerMeta;
import hu.eltesoft.modelexecution.runtime.meta.PropertyMeta;
import hu.eltesoft.modelexecution.runtime.meta.SignalMeta;
import hu.eltesoft.modelexecution.runtime.meta.StateMeta;
import hu.eltesoft.modelexecution.runtime.meta.VariableMeta;

/**
 * A presentation of a named read-only value.
 */
@SuppressWarnings("restriction")
public class ModelVariable extends DebugElement implements IVariable, IPresentation {

	private VariableMeta leftVal;
	private Value value;
	private JDIThreadWrapper operationThread;
	private DebugElement owner;

	public ModelVariable(DebugElement owner, VariableMeta leftVal, JDIThreadWrapper operationThread, Value value) {
		super(owner.getXUmlRtDebugTarget());
		this.owner = owner;
		this.leftVal = leftVal;
		this.operationThread = operationThread;
		this.value = value;
	}

	@Override
	public String getName() {
		return leftVal.getName();
	}

	@Override
	public String getLabel() {
		return null; // not shown
	}

	@Override
	public String getDetails() {
		return null; // not shown
	}

	@Override
	public Image getImage() {
		if (leftVal instanceof PropertyMeta) {
			return getIconForType(UMLFactory.eINSTANCE.createProperty());
		} else if (leftVal instanceof SignalMeta) {
			return getIconForType(UMLFactory.eINSTANCE.createSignal());
		} else if (leftVal instanceof OwnerMeta) {
			return getIconForType(UMLFactory.eINSTANCE.createClass());
		} else if (leftVal instanceof StateMeta) {
			return getIconForType(UMLFactory.eINSTANCE.createState());
		} else if (leftVal instanceof IndexMeta) {
			return getIconForType(UMLFactory.eINSTANCE.createLiteralInteger());
		} else {
			return null;
		}
	}

	public Image getIconForType(EObject element) {
		IImage image = ImageQuery.getEObjectImage(element);
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}

	@Override
	public void setValue(String expression) throws DebugException {
		// value modification is currently not supported
	}

	@Override
	public void setValue(IValue value) throws DebugException {
		// value modification is currently not supported
	}

	@Override
	public boolean supportsValueModification() {
		// value modification is currently not supported
		return false;
	}

	@Override
	public boolean verifyValue(String expression) throws DebugException {
		// value modification is currently not supported
		return false;
	}

	@Override
	public boolean verifyValue(IValue value) throws DebugException {
		// value modification is currently not supported
		return false;
	}

	@Override
	public IValue getValue() throws DebugException {
		if (leftVal.isSingle()) {
			return new SingleValue(this, operationThread, value);
		} else {
			return new MultiValue(this, operationThread, value);
		}
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		return value.type().name();
	}

	@Override
	public boolean hasValueChanged() throws DebugException {
		// change notifications are currently not supported
		return false;
	}

	@Override
	public DebugElement getParent() {
		return owner;
	}

}
