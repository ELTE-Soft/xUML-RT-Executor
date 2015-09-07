package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

import hu.eltesoft.modelexecution.ide.debug.jvm.VirtualMachineBrowser;
import hu.eltesoft.modelexecution.ide.debug.model.utils.XUmlRtContants;
import hu.eltesoft.modelexecution.ide.debug.ui.DebugViewController;

public abstract class DebugElement extends PlatformObject implements IDebugElement {

	private XUMLRTDebugTarget debugTarget;

	public DebugElement(XUMLRTDebugTarget target) {
		this.debugTarget = target;
	}

	public DebugViewController getDebugControl() {
		return getXUmlRtDebugTarget().getDebugControl();
	}

	public VirtualMachineBrowser getVMBrowser() {
		return debugTarget.getVMBrowser();
	}

	@Override
	public String getModelIdentifier() {
		return XUmlRtContants.XUML_RT_DEBUG_MODEL_ID;
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return debugTarget;
	}

	public XUMLRTDebugTarget getXUmlRtDebugTarget() {
		return debugTarget;
	}

	public void setDebugTarget(XUMLRTDebugTarget debugTarget) {
		this.debugTarget = debugTarget;
	}

	@Override
	public ILaunch getLaunch() {
		return debugTarget.getLaunch();
	}

	public abstract DebugElement getParent();

}
