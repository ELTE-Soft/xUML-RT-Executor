package hu.eltesoft.modelexecution.ide.debug.model.utils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.internal.ui.model.elements.ElementLabelProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;

/**
 * Allows the presentation of model elements in the debug view that implement
 * the {@link IPresentation} interface.
 */
@SuppressWarnings("restriction")
public class PresentationLabelProvider extends ElementLabelProvider {

	@Override
	protected String getLabel(TreePath elementPath, IPresentationContext presentationContext, String columnId)
			throws CoreException {
		Object element = elementPath.getLastSegment();
		if (element instanceof IPresentation) {
			return ((IPresentation) element).getLabel();
		}
		return null;
	}

	@Override
	protected ImageDescriptor getImageDescriptor(TreePath elementPath, IPresentationContext presentationContext,
			String columnId) throws CoreException {
		Object element = elementPath.getLastSegment();
		if (element instanceof IPresentation) {
			return ImageDescriptor.createFromImage(((IPresentation) element).getImage());
		}
		return null;
	}

}
