package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.debug.jvm.JDTThreadWrapper;
import hu.eltesoft.modelexecution.runtime.meta.IndexM;

@SuppressWarnings("restriction")
public class MultiValue extends XUmlRtValue {

	public MultiValue(MokaDebugTarget debugTarget, JDTThreadWrapper mainThread, Value value) {
		super(debugTarget, mainThread, value);
	}

	@Override
	protected IVariable[] handleCollectionValues(List<IVariable> list, List<Value> collectionValues)
			throws DebugException {
		for (int i = 0; i < collectionValues.size(); i++) {
			list.add(new XUmlRtVariable(debugTarget, new IndexM(i),
					new SingleValue(debugTarget, thread, collectionValues.get(i))));
		}
		return list.toArray(new IVariable[list.size()]);
	}

	@Override
	protected String resolveSingletonObject(ObjectReference objectReference)
			throws InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
		return jdtUtils.invokeToString(objectReference);
	}

}
