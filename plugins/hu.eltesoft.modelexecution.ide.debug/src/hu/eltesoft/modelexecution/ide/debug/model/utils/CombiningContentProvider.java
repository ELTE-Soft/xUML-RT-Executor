package hu.eltesoft.modelexecution.ide.debug.model.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.internal.ui.model.elements.ElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerUpdate;

import com.sun.jdi.VMDisconnectedException;

@SuppressWarnings("restriction")
public class CombiningContentProvider<T> extends ElementContentProvider {

	private Map<String, Function<T, Object[][]>> childrenAccess = new HashMap<>();

	public CombiningContentProvider() {
	}

	public CombiningContentProvider<T> setMapping(String id, Function<T, Object[][]> accessFunction) {
		childrenAccess.put(id, accessFunction);
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object[] getChildren(Object parent, int index, int length, IPresentationContext context,
			IViewerUpdate monitor) throws CoreException {
		List<Object> ret = new ArrayList<>();
		String id = context.getId();
		if (childrenAccess.containsKey(id)) {
			for (Object[] objects : childrenAccess.get(id).apply((T) parent)) {
				ret.addAll(Arrays.asList(objects));
			}
		}
		return ret.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected int getChildCount(Object element, IPresentationContext context, IViewerUpdate monitor)
			throws CoreException {
		int ret = 0;
		String id = context.getId();
		try {
			if (childrenAccess.containsKey(id)) {
				Object[][] children = childrenAccess.get(id).apply((T) element);
				for (Object[] objects : children) {
					ret += objects.length;
				}
			}
		} catch (VMDisconnectedException e) {
			// nothing to do, the launch already ended
		}
		return ret;
	}

	@Override
	protected void retrieveChildren(IChildrenUpdate update) {
		// TODO: this concurrency issue may be inspected deeper, and solved more nicely
		try {
			// cannot perform an update when the number of children is changed since
			if (update.getLength() != getChildCount(update.getElement(), update.getPresentationContext(), null)) {
				update.cancel();
			}
		} catch (CoreException e) {
			update.cancel();
		}
		super.retrieveChildren(update);
	}
	
	@Override
	protected boolean supportsContextId(String id) {
		return childrenAccess.containsKey(id);
	}

}
