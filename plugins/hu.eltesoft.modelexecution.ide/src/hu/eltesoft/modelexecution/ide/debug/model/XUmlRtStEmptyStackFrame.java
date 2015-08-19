package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLFactory;

import hu.eltesoft.modelexecution.ide.IdePlugin;

public class XUmlRtStEmptyStackFrame  extends MokaStackFrame implements IPresentation {

	public XUmlRtStEmptyStackFrame(MokaThread thread) {
		super((MokaDebugTarget) thread.getDebugTarget());
		setThread(thread);
	}

	@Override
	public String getLabel() {
		try {
			return getName();
		} catch (DebugException e) {
			IdePlugin.logError("Error while asking the stack frame name", e);
			return "?";
		}
	}
	
	@Override
	public String getDetails() {
		return null; // not inspected
	}

	@Override
	public Image getImage() {
		IImage image = ImageQuery.getEObjectImage(UMLFactory.eINSTANCE.createInterval());
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}
	
	@Override
	public IVariable[] getVariables() throws DebugException {
		return super.getVariables();
	}


}
