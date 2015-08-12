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

import com.sun.jdi.ArrayReference;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.Field;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StringReference;
import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.JDTThread;
import hu.eltesoft.modelexecution.runtime.meta.AttributeM;
import hu.eltesoft.modelexecution.runtime.meta.BoundsM;
import hu.eltesoft.modelexecution.runtime.meta.ClassM;

@SuppressWarnings("restriction")
public class XUmlRtValue extends MokaValue implements IValue {

	private Value value;
	private JDTThread thread;
	private BoundsM bounds;

	public XUmlRtValue(MokaDebugTarget debugTarget, JDTThread mainThread, Value value) {
		super(debugTarget);
		this.thread = mainThread;
		this.value = value;
	}

	public XUmlRtValue(MokaDebugTarget debugTarget, JDTThread thread, Value value, BoundsM bounds) {
		this(debugTarget, thread, value);
		this.bounds = bounds;
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
					synchronized (thread) {
						StringReference res = (StringReference) thread.invokeMethod(meta,
								meta.referenceType().methodsByName("serialize").get(0));
						ClassM metaInfo = ClassM.deserialize(res.value());
						Map<AttributeM, Value> attribValues = new HashMap<AttributeM, Value>();
						for (AttributeM attrib : metaInfo.getAttributes()) {
							Field field = type.fieldByName(attrib.getIdentifier());
							attribValues.put(attrib, valueObj.getValue(field));
						}
						return presentAttributes(attribValues);
					}
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
			XUmlRtValue varValue = new XUmlRtValue(debugTarget, thread, attribValue.getValue(),
					attribValue.getKey().getBounds());
			MokaVariable attr = new XUmlRtVariable(debugTarget, attribValue.getKey().getName(), varValue);
			presentedAttributes.add(attr);
		}
		return presentedAttributes.toArray(new IVariable[presentedAttributes.size()]);
	}

	@Override
	public String getValueString() throws DebugException {
		synchronized (thread) {
			// show the object using it's toString method
			if (value instanceof ObjectReference) {
				ObjectReference objectReference = (ObjectReference) value;
				try {
					if (bounds != null && bounds.isAtMostSingle()) {
						List<Method> iteratorMethod = objectReference.referenceType().methodsByName("toArray");
						iteratorMethod.removeIf(m -> !m.argumentTypeNames().isEmpty());
						if (iteratorMethod.isEmpty()) {
							IdePlugin.logError("Attribute value is not iterable");
						} else {
							ArrayReference valueArray = (ArrayReference) thread.invokeMethod(objectReference,
									iteratorMethod.get(0));
							if (valueArray.length() > 0) {
								objectReference = (ObjectReference) valueArray.getValue(0);
							} else {
								return "null";
							}
						}
					}

					List<Method> toStringMethod = objectReference.referenceType().methodsByName("toString");
					toStringMethod.removeIf(m -> !m.argumentTypeNames().isEmpty());
					if (toStringMethod.isEmpty()) {
						IdePlugin.logError("No toString method on value");
					} else {
						Value toStringResult = thread.invokeMethod(objectReference, toStringMethod.get(0));
						if (toStringResult instanceof StringReference) {
							return ((StringReference) toStringResult).value();
						} else {
							IdePlugin.logError("The result of toString is not a String");
						}
					}
				} catch (InvocationException e) {
					// Exception while calling toString, fall through
				} catch (Exception e) {
					IdePlugin.logError("Error while invoking toString to get representation", e);
				}
			}
			// if not available, use the mirror's toString
			return value.toString();
		}
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
