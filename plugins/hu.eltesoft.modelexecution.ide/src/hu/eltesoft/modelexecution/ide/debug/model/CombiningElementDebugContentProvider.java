package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.internal.ui.model.elements.ElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerUpdate;
import org.eclipse.debug.ui.IDebugUIConstants;

@SuppressWarnings("restriction")
public class CombiningElementDebugContentProvider<T> extends ElementContentProvider {

	private Function<T, Object[][]> fun;

	public CombiningElementDebugContentProvider(Function<T, Object[][]> fun) {
		this.fun = fun;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Object[] getChildren(Object parent, int index, int length, IPresentationContext context,
			IViewerUpdate monitor) throws CoreException {
		List<Object> ret = new ArrayList<>();
		for (Object[] objects : fun.apply((T) parent)) {
			ret.addAll(Arrays.asList(objects));
		}
		return ret.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected int getChildCount(Object element, IPresentationContext context, IViewerUpdate monitor)
			throws CoreException {
		int ret = 0;
		for (Object[] objects : fun.apply((T) element)) {
			ret += objects.length;
		}
		return ret;
	}

	@Override
	protected boolean supportsContextId(String id) {
		return IDebugUIConstants.ID_DEBUG_VIEW.equals(id);
	}

}
