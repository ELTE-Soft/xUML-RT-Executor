package hu.eltesoft.modelexecution.ide.debug.ui;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
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

import hu.eltesoft.modelexecution.runtime.meta.AttributeM;
import hu.eltesoft.modelexecution.runtime.meta.LeftValueM;
import hu.eltesoft.modelexecution.runtime.meta.OwnerM;
import hu.eltesoft.modelexecution.runtime.meta.SignalM;
import hu.eltesoft.modelexecution.runtime.meta.StateM;

/**
 * A presentation of a named read-only value.
 */
public class XUmlRtVariable extends MokaVariable implements IPresentation {

	private XUmlRtValue value2;
	private String name2;
	private LeftValueM leftVal;

	public XUmlRtVariable(MokaDebugTarget debugTarget, LeftValueM leftVal, XUmlRtValue value) {
		super(debugTarget);
		this.leftVal = leftVal;
		name2 = leftVal.getName();
		value2 = value;
	}

	@Override
	public IValue getValue() throws DebugException {
		return value2;
	}

	@Override
	public String getName() throws DebugException {
		return name2;
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
		// TODO: show different icons for public, protected, package, private,
		// static attributes and local variables
		if (leftVal instanceof AttributeM) {
			return getIconForType(UMLFactory.eINSTANCE.createProperty());
		} else if (leftVal instanceof SignalM) {
			return getIconForType(UMLFactory.eINSTANCE.createSignal());
		} else if (leftVal instanceof OwnerM) {
			return getIconForType(UMLFactory.eINSTANCE.createClass());
		} else if (leftVal instanceof StateM) {
			return getIconForType(UMLFactory.eINSTANCE.createState());
		} else {
			return null;
		}
	}

	// TODO: cache icons
	public Image getIconForType(EObject element) {
		IImage image = ImageQuery.getEObjectImage(element);
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}

}
