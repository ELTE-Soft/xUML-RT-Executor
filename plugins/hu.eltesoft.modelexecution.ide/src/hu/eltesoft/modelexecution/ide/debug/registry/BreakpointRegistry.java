package hu.eltesoft.modelexecution.ide.debug.registry;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.util.ModelUtils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;

public class BreakpointRegistry {

	private final Map<EObject, MokaBreakpoint> breakpointsForElements = new HashMap<>();

	public void add(MokaBreakpoint breakpoint) {
		EObject modelElement = breakpoint.getModelElement();
		if (null == modelElement || !ModelUtils.isSupportedNode(modelElement)) {
			return;
		}

		breakpointsForElements.put(modelElement, breakpoint);
	}

	public void remove(MokaBreakpoint breakpoint) {
		EObject modelElement = breakpoint.getModelElement();
		if (null == modelElement) {
			return;
		}

		breakpointsForElements.remove(modelElement);
	}

	public boolean hasEnabledBreakpointOn(EObject modelElement) {
		MokaBreakpoint breakpoint = breakpointsForElements.get(modelElement);
		if (null == breakpoint) {
			return false;
		}

		try {
			return breakpoint.isEnabled();
		} catch (CoreException e) {
			IdePlugin.logError(
					"Unable to check whether a breakpoint is enalbed", e);
			return false;
		}
	}
}
