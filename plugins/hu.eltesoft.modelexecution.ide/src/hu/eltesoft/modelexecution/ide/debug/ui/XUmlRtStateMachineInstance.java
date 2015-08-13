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

/**
 * Thread-like presentation of a state machine instance.
 */
public class XUmlRtStateMachineInstance extends MokaThread implements IPresentation {

	public XUmlRtStateMachineInstance(MokaDebugTarget debugTarget) {
		super(debugTarget);
	}

	@Override
	public String getLabel() {
		return name;
	}

	@Override
	public String getDetails() {
		// not shown
		return null;
	}

	@Override
	public Image getImage() {
		// show the image corresponding to state machines
		EObject component = UMLFactory.eINSTANCE.createStateMachine();
		IImage image = ImageQuery.getEObjectImage(component);
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}
}
