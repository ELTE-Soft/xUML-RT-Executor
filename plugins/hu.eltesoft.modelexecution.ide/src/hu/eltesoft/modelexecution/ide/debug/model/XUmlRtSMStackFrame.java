package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;

public class XUmlRtSMStackFrame extends MokaStackFrame implements IPresentation {

	public XUmlRtSMStackFrame(MokaDebugTarget target, XUmlRtStateMachineInstance smInstance, NamedElement modelElement) {
		super(target);
		setModelElement(modelElement);
		setThread(smInstance);
		setName(modelElement.getQualifiedName());
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
}
