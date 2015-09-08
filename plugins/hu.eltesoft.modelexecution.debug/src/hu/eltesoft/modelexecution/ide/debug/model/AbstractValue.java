package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Image;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.Field;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StringReference;
import com.sun.jdi.Value;

import hu.eltesoft.modelexecution.ide.debug.jvm.JDIThreadWrapper;
import hu.eltesoft.modelexecution.ide.debug.util.JDIUtils;
import hu.eltesoft.modelexecution.logger.PluginLogger;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.runtime.meta.ClassMeta;
import hu.eltesoft.modelexecution.runtime.meta.PropertyMeta;

/**
 * Presentation of values in the executed model. It appears in the variables
 * view. The value can have its inner structure, and in that case it can be
 * accessed through this class.
 * 
 * The life of these values lasts only while the debugger is stopped.
 */
@SuppressWarnings("restriction")
public abstract class AbstractValue extends DebugElement implements IValue, IPresentation {

	private static final String SERIALIZE_METHOD_NAME = "serialize";

	/**
	 * The mirror of the value contained in the running virtual machine.
	 */
	private Value value;

	/**
	 * Main thread for invoking methods in the virtual machine to support
	 * presentation.
	 */
	protected JDIThreadWrapper thread;

	protected JDIUtils jdiUtils;

	protected ModelVariable variable;

	public AbstractValue(ModelVariable variable, JDIThreadWrapper mainThread, Value value) {
		super(variable.getXUmlRtDebugTarget());
		this.variable = variable;
		this.thread = mainThread;
		this.value = value;
		this.jdiUtils = new JDIUtils(mainThread);
	}

	public AbstractValue(XUMLRTDebugTarget debugTarget, JDIThreadWrapper mainThread, Value value) {
		super(debugTarget);
		this.thread = mainThread;
		this.value = value;
		this.jdiUtils = new JDIUtils(mainThread);
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (value instanceof ObjectReference) {
			ObjectReference valueObj = (ObjectReference) value;
			ReferenceType type = valueObj.referenceType();
			Field metaField = type.fieldByName(Template.META_REPR_NAME);
			if (metaField != null) {
				// structure
				return getVariablesUsingMetainfo(valueObj, type, metaField);
			} else if (jdiUtils.isCollectionType(type)) {
				// collection
				List<IVariable> list = new LinkedList<IVariable>();
				List<Value> collectionValues = jdiUtils.getCollectionValues(valueObj);
				return handleCollectionValues(list, collectionValues);

			}
		}
		return new IVariable[0];
	}

	abstract protected IVariable[] handleCollectionValues(List<IVariable> list, List<Value> collectionValues)
			throws DebugException;

	/**
	 * Gets structural information of a class or signal where the metadata is
	 * present.
	 */
	public IVariable[] getVariablesUsingMetainfo(ObjectReference valueObj, ReferenceType type, Field metaField)
			throws DebugException {
		ObjectReference meta = (ObjectReference) type.getValue(metaField);
		try {
			StringReference res = (StringReference) thread.invokeMethod(meta, SERIALIZE_METHOD_NAME);

			ClassMeta metaInfo = JDIUtils.withInfiniteTimeout(res.virtualMachine(),
					() -> ClassMeta.deserialize(res.value()));
			Map<PropertyMeta, Value> attribValues = new HashMap<PropertyMeta, Value>();
			for (PropertyMeta attrib : metaInfo.getAttributes()) {
				attribValues.put(attrib, thread.invokeMethod(valueObj, attrib.getIdentifier()));
			}
			return presentAttributes(attribValues);
		} catch (Exception e) {
			PluginLogger.logError("Error while retrieving metainfo", e);
			return new IVariable[0];
		}
	}

	private IVariable[] presentAttributes(Map<PropertyMeta, Value> propertyValues) throws DebugException {
		List<ModelVariable> shownAttributes = new LinkedList<>();
		for (Entry<PropertyMeta, Value> propertyValue : propertyValues.entrySet()) {
			PropertyMeta property = propertyValue.getKey();
			shownAttributes.add(new ModelVariable(getXUmlRtDebugTarget(), property, thread, propertyValue.getValue()));
		}
		// sort the attributes alphabetically
		shownAttributes.sort(Comparator.comparing(ModelVariable::getName));
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
				PluginLogger.logError("Error while invoking toString to get representation", e);
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
	protected abstract String resolveSingletonObject(ObjectReference objectReference)
			throws InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException;

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

	@Override
	public String getDetails() {
		try {
			return getValueString();
		} catch (DebugException e) {
			PluginLogger.logError("Error while filling out details", e);
			return e.getMessage();
		}
	}

	@Override
	public String getLabel() {
		return null; // not displayed
	}

	@Override
	public Image getImage() {
		return null; // not displayed
	}

	@Override
	public DebugElement getParent() {
		return variable;
	}

}
