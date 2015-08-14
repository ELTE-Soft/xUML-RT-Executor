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

@SuppressWarnings("restriction")
public class SingleValue extends XUmlRtValue {

	public SingleValue(MokaDebugTarget debugTarget, JDTThreadWrapper mainThread, Value value) {
		super(debugTarget, mainThread, value);
	}

	@Override
	protected IVariable[] handleCollectionValues(List<IVariable> list, List<Value> collectionValues)
			throws DebugException {
		if (!collectionValues.isEmpty()) {
			return new SingleValue(debugTarget, thread, collectionValues.get(0)).getVariables();
		} else {
			return new IVariable[0];
		}
	}

	@Override
	protected String resolveSingletonObject(ObjectReference objectReference)
			throws InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
		if (jdtUtils.isCollectionType(objectReference.referenceType())) {
			List<Value> collectionValues = jdtUtils.getCollectionValues(objectReference);
			if (collectionValues.size() > 0) {
				return jdtUtils.invokeToString((ObjectReference) collectionValues.get(0));
			} else {
				return "null";
			}
		} else {
			return jdtUtils.invokeToString(objectReference);
		}
	}
	
}
