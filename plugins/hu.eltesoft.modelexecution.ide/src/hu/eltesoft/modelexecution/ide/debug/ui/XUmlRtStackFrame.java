package hu.eltesoft.modelexecution.ide.debug.ui;

import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;

public class XUmlRtStackFrame extends MokaStackFrame implements IPresentation {

	public XUmlRtStackFrame(MokaDebugTarget target, NamedElement modelElement) {
		super(target);
		setModelElement(modelElement);
		setName(modelElement.getName());
	}

	@Override
	public String getLabel() {
		String elementType = modelElement.eClass().getName();
		return String.format("%s [%s]", name, elementType);
	}

	@Override
	public String getDetails() {
		// currently we provide no details at all
		return null;
	}

	@Override
	public Image getImage() {
		IImage image = ImageQuery.getEObjectImage(modelElement);
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}
}
