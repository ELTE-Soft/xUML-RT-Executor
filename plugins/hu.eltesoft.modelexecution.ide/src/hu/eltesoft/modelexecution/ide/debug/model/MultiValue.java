package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.debug.jvm.JDIThreadWrapper;
import hu.eltesoft.modelexecution.runtime.meta.IndexMeta;

/**
 * The debug model representation of a value that can have more than 1 elements.
 * When showing the value, the elements are put inside braces.
 */
@SuppressWarnings("restriction")
public class MultiValue extends AbstractValue {

	public MultiValue(ModelVariable variable, JDIThreadWrapper mainThread, Value value) {
		super(variable, mainThread, value);
	}

	@Override
	protected IVariable[] handleCollectionValues(List<IVariable> list, List<Value> collectionValues)
			throws DebugException {
		for (int i = 0; i < collectionValues.size(); i++) {
			list.add(new ModelVariable(getXUmlRtDebugTarget(), new IndexMeta(i), thread,
					collectionValues.get(i)));
		}
		return list.toArray(new IVariable[list.size()]);
	}

	@Override
	protected String resolveSingletonObject(ObjectReference objectReference)
			throws InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
		return jdiUtils.invokeToString(objectReference);
	}

}
