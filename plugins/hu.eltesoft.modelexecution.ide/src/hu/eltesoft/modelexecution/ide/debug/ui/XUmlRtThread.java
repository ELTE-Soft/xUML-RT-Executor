package hu.eltesoft.modelexecution.ide.debug.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLFactory;

public class XUmlRtThread extends MokaThread implements IPresentation {

	public XUmlRtThread(MokaDebugTarget debugTarget) {
		super(debugTarget);
	}

	@Override
	public String getLabel() {
		return name;
	}

	@Override
	public String getDetails() {
		// currently we provide no details at all
		return null;
	}

	@Override
	public Image getImage() {
		EObject component = UMLFactory.eINSTANCE.createStateMachine();
		IImage image = ImageQuery.getEObjectImage(component);
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}
}
