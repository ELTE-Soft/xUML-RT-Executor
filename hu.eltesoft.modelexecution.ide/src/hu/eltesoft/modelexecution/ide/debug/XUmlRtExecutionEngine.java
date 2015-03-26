package hu.eltesoft.modelexecution.ide.debug;

import java.io.IOException;
import java.net.UnknownHostException;

import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;

/**
 * Execution engine for Moka
 * 
 * @author nboldi
 */
public class XUmlRtExecutionEngine implements IExecutionEngine {
	// TODO: this class is a stub and need to be implemented later
	
	public XUmlRtExecutionEngine() {
		// TODO: implement
	}

	@Override
	public void init(EObject eObjectToExecute, String[] args,
			MokaDebugTarget debugTarget, int requestPort, int replyPort,
			int eventPort) throws UnknownHostException, IOException {
		// TODO: implement
	}

	@Override
	public void initializeArguments(String[] args) {
		// TODO: implement
	}

	@Override
	public void start() throws IOException {
		// TODO: implement
	}

	@Override
	public MokaThread[] getThreads() {
		// TODO: implement
		return new MokaThread[] {};
	}

	@Override
	public void addBreakpoint(MokaBreakpoint breakpoint) {
		// TODO: implement
	}

	@Override
	public void removeBreakpoint(MokaBreakpoint breakpoint) {
		// TODO: implement
	}

	@Override
	public void disconnect() {
		// TODO: implement
	}

	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length) {
		// TODO: implement
		return null;
	}

	@Override
	public void resume(Resume_Request request) {
		// TODO: implement
	}

	@Override
	public void suspend(Suspend_Request request) {
		// TODO: implement
	}

	@Override
	public void terminate(Terminate_Request request) {
		// TODO: implement		
	}

	@Override
	public IStackFrame[] getStackFrames(IThread thread) {
		// TODO: implement
		return new IStackFrame[] {};
	}

	@Override
	public IVariable[] getVariables(IDebugElement stackFrameOrValue) {
		// TODO: implement
		return new IVariable[] {};
	}

	@Override
	public IRegisterGroup[] getRegisterGroups(IStackFrame stackFrame) {
		// TODO: implement
		return new IRegisterGroup[] {};
	}

	@Override
	public IValue getValue(IVariable variable) {
		// TODO: implement
		return null;
	}

	@Override
	public String getReferenceTypeName(IDebugElement debugElement) {
		// TODO: implement
		return "<getReferenceTypeName>";
	}

	@Override
	public String getValueString(IValue value) {
		// TODO: implement
		return "<getValueString>";
	}

}
