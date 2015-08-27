package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaVariable;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLFactory;

import hu.eltesoft.modelexecution.runtime.meta.IndexMeta;
import hu.eltesoft.modelexecution.runtime.meta.VariableMeta;
import hu.eltesoft.modelexecution.runtime.meta.OwnerMeta;
import hu.eltesoft.modelexecution.runtime.meta.PropertyMeta;
import hu.eltesoft.modelexecution.runtime.meta.SignalMeta;
import hu.eltesoft.modelexecution.runtime.meta.StateMeta;

/**
 * A presentation of a named read-only value.
 */
public class ModelVariable extends MokaVariable implements IPresentation {

	private VariableMeta leftVal;

	public ModelVariable(MokaDebugTarget debugTarget, VariableMeta leftVal, AbstractValue value) {
		super(debugTarget);
		this.leftVal = leftVal;
		setName(leftVal.getName());
		try {
			setValue(value);
		} catch (DebugException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getName() {
		try {
			return super.getName();
		} catch (DebugException e) {
			throw new RuntimeException(e);
		}
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

}
