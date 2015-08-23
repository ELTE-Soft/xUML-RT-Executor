package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.ide.IdePlugin;

public abstract class StateMachineStackFrame extends MokaStackFrame implements IPresentation {

	public StateMachineStackFrame(MokaDebugTarget target, XUmlRtStateMachineInstance stateMachine) {
		super(target);
		setName(name);
		setThread(stateMachine);
	}

	@Override
	public String getLabel() {
		try {
			return getName();
		} catch (DebugException e) {
			IdePlugin.logError("Name could not be retrived", e);
			return "?";
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

}