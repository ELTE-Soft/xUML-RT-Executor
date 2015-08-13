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
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.runtime.meta.PropertyM;
import hu.eltesoft.modelexecution.runtime.meta.BoundsM;
import hu.eltesoft.modelexecution.runtime.meta.ClassM;

/**
 * Presentation of values in the executed model. It appears in the variables
 * view.
 */
@SuppressWarnings("restriction")
public class XUmlRtValue extends MokaValue implements IValue {

	private static final String TO_ARRAY_METHOD = "toArray";
	private static final String TO_STRING_METHOD = "toString";
	private static final String SERIALIZE_METHOD_NAME = "serialize";
	
	
	/**
	 * The mirror of the value contained in the running virtual machine.
	 */
	private Value value;
	
	/**
	 * Main thread for invoking methods in the virtual machine to support presentation.
	 */
	private JDTThread thread;
	
	/**
	 * Multiplicity of the attribute that has this value. Used during presentation.
	 */
	private BoundsM bounds;

	public XUmlRtValue(MokaDebugTarget debugTarget, JDTThread mainThread, Value value) {
		super(debugTarget);
		this.thread = mainThread;
		this.value = value;
	}

	/**
	 * Constructs a value that is the value of an attribute (part of some other objects structure).
	 */
	public XUmlRtValue(MokaDebugTarget debugTarget, JDTThread thread, Value value, BoundsM bounds) {
		this(debugTarget, thread, value);
		this.bounds = bounds;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (value instanceof ObjectReference) {
			ObjectReference valueObj = (ObjectReference) value;
			ReferenceType type = valueObj.referenceType();
			Field metaField = type.fieldByName(Template.META_REPR_NAME);
			if (metaField != null) {
				return getVariablesUsingMetainfo(valueObj, type, metaField);
			}
		}
		return new IVariable[0];
	}

	public IVariable[] getVariablesUsingMetainfo(ObjectReference valueObj, ReferenceType type, Field metaField)
			throws DebugException {
		ObjectReference meta = (ObjectReference) type.getValue(metaField);
		try {
			StringReference res = (StringReference) thread.invokeMethod(meta,
					meta.referenceType().methodsByName(SERIALIZE_METHOD_NAME).get(0));
			ClassM metaInfo = ClassM.deserialize(res.value());
			Map<PropertyM, Value> attribValues = new HashMap<PropertyM, Value>();
			for (PropertyM attrib : metaInfo.getAttributes()) {
				Field field = type.fieldByName(attrib.getIdentifier());
				attribValues.put(attrib, valueObj.getValue(field));
			}
			return presentAttributes(attribValues);
		} catch (InvalidTypeException | ClassNotLoadedException | IncompatibleThreadStateException
				| InvocationException e) {
			IdePlugin.logError("Error while retrieving metainfo", e);
			return new IVariable[0];
		}
	}

	private IVariable[] presentAttributes(Map<PropertyM, Value> propertyValues) throws DebugException {
		List<IVariable> shownAttributes = new LinkedList<>();
		for (Entry<PropertyM, Value> propertyValue : propertyValues.entrySet()) {
			PropertyM property = propertyValue.getKey();
			XUmlRtValue varValue = new XUmlRtValue(debugTarget, thread, propertyValue.getValue(), property.getBounds());
			shownAttributes.add(new XUmlRtVariable(debugTarget, property, varValue));
		}
		return shownAttributes.toArray(new IVariable[shownAttributes.size()]);
	}

	@Override
	public String getValueString() throws DebugException {
		// default is to use the mirror's toString
		String ret = value.toString();
		// show the object using it's toString method
		if (value instanceof ObjectReference) {
			ObjectReference objectReference = (ObjectReference) value;
			try {
				ret = resolveSingletonObject(objectReference);
			} catch (Exception e) {
				// all exceptions are caught, we want to hide exceptions of UI
				IdePlugin.logError("Error while invoking toString to get representation", e);
			}
		}

		return ret;
	}

	/**
	 * If the given object has singleton multiplicity, than it extracts its
	 * first element or displays 'null' if there is none.
	 * 
	 * @return the textual representation of the value or null, if it couldn't
	 *         be decided
	 */
	private String resolveSingletonObject(ObjectReference objectReference)
			throws InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
		if (bounds != null && bounds.isAtMostSingle()) {
			List<Method> iteratorMethod = objectReference.referenceType().methodsByName(TO_ARRAY_METHOD);
			iteratorMethod.removeIf(m -> !m.argumentTypeNames().isEmpty());
			if (!iteratorMethod.isEmpty()) {
				ArrayReference valueArray;
				try {
					valueArray = (ArrayReference) thread.invokeMethod(objectReference, iteratorMethod.get(0));
				} catch (InvocationException e) {
					// error while calling toArray
					return null;
				}
				if (valueArray.length() > 0) {
					return invokeToString((ObjectReference) valueArray.getValue(0));
				} else {
					return "null";
				}
			} else {
				IdePlugin.logError("Attribute value is not collection");
				return null;
			}
		} else {
			return invokeToString(objectReference);			
		}
	}

	/**
	 * Invokes toString in the virtual machine to get the representation of the
	 * given object.
	 * 
	 * @return the textual representation of the value or null, if it couldn't
	 *         be decided
	 */
	private String invokeToString(ObjectReference objectReference)
			throws InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
		List<Method> toStringMethod = objectReference.referenceType().methodsByName(TO_STRING_METHOD);
		toStringMethod.removeIf(m -> !m.argumentTypeNames().isEmpty());
		if (toStringMethod.isEmpty()) {
			IdePlugin.logError("No toString method on value");
		} else {
			Value toStringResult;
			try {
				toStringResult = thread.invokeMethod(objectReference, toStringMethod.get(0));
			} catch (InvocationException e) {
				// exception in toString
				return null;
			}
			if (toStringResult instanceof StringReference) {
				return ((StringReference) toStringResult).value();
			} else {
				IdePlugin.logError("The result of toString is not a String");
			}
		}
		return null;
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
