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

import hu.eltesoft.modelexecution.ide.debug.jvm.JDIThreadWrapper;

/**
 * The debug model representation of a value with at most 1 elements. If it has
 * no value it is shown as "null" otherwise the single value is simply shown.
 */
@SuppressWarnings("restriction")
public class SingleValue extends XUmlRtValue {

	public SingleValue(MokaDebugTarget debugTarget, JDIThreadWrapper mainThread, Value value) {
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
		if (jdiUtils.isCollectionType(objectReference.referenceType())) {
			List<Value> collectionValues = jdiUtils.getCollectionValues(objectReference);
			if (collectionValues.size() > 0) {
				return jdiUtils.invokeToString((ObjectReference) collectionValues.get(0));
			} else {
				return "null";
			}
		} else {
			return jdiUtils.invokeToString(objectReference);
		}
	}

}
