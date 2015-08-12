package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaValue;
import org.eclipse.papyrus.moka.debug.MokaVariable;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.Field;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StringReference;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.runtime.meta.AttributeM;
import hu.eltesoft.modelexecution.runtime.meta.ClassM;

@SuppressWarnings("restriction")
public class XUmlRtValue extends MokaValue implements IValue {

	private Value value;
	private ThreadReference thread;

	public XUmlRtValue(MokaDebugTarget debugTarget, ThreadReference thread, Value value) {
		super(debugTarget);
		this.thread = thread;
		this.value = value;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (value instanceof ObjectReference) {
			ObjectReference valueObj = (ObjectReference) value;
			ReferenceType type = valueObj.referenceType();
			Field metaField = type.fieldByName("metaRepr");
			if (metaField != null) {
				ObjectReference meta = (ObjectReference) type.getValue(metaField);
				try {
					StringReference res = (StringReference) meta.invokeMethod(thread,
							meta.referenceType().methodsByName("serialize").get(0), new LinkedList<>(), 0);
					ClassM metaInfo = ClassM.deserialize(res.value());
					Map<AttributeM, Value> attribValues = new HashMap<AttributeM, Value>();
					for (AttributeM attrib : metaInfo.attributes) {
						Field field = type.fieldByName(attrib.identifier);
						attribValues.put(attrib, valueObj.getValue(field));
					}
					return presentAttributes(attribValues);
				} catch (InvalidTypeException | ClassNotLoadedException | IncompatibleThreadStateException
						| InvocationException e) {
					IdePlugin.logError("Error while retrieving meta info");
				}
			}
		}
		return new IVariable[0];
	}

	private IVariable[] presentAttributes(Map<AttributeM, Value> attribValues) throws DebugException {
		List<IVariable> presentedAttributes = new LinkedList<>();
		for (Entry<AttributeM, Value> attribValue : attribValues.entrySet()) {
			MokaVariable attr = new MokaVariable(debugTarget);
			attr.setName(attribValue.getKey().name);
			attr.setValue(new XUmlRtValue(debugTarget, thread, attribValue.getValue()));
			presentedAttributes.add(attr);
		}
		return presentedAttributes.toArray(new IVariable[presentedAttributes.size()]);
	}

	@Override
	public String getValueString() throws DebugException {
		String stringRepr = value.toString();
		if (value instanceof ObjectReference) {
			ObjectReference objectReference = (ObjectReference) value;
			try {
				stringRepr = objectReference.invokeMethod(thread,
						objectReference.referenceType().methodsByName("toString").get(0), new LinkedList<>(), 0)
						.toString();
			} catch (InvalidTypeException | ClassNotLoadedException | IncompatibleThreadStateException e) {
				IdePlugin.logError("Error while invoking toString to get representation");
			} catch (InvocationException e) {
				// Exception while calling toString, fall through
			}
		}
		return stringRepr;
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		return value.type().name();
	}

	@Override
	public boolean isAllocated() throws DebugException {
		return !((ObjectReference) value).isCollected();
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return getVariables().length > 0;
	}

}
