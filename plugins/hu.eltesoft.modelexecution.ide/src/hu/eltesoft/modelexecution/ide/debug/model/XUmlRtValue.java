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
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaValue;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Image;

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
import hu.eltesoft.modelexecution.ide.debug.jvm.JDTThreadWrapper;
import hu.eltesoft.modelexecution.ide.debug.util.JDTUtils;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.runtime.meta.ClassM;
import hu.eltesoft.modelexecution.runtime.meta.PropertyM;

/**
 * Presentation of values in the executed model. It appears in the variables
 * view. The value can have its inner structure, and in that case it can be
 * accessed through this class.
 */
@SuppressWarnings("restriction")
public abstract class XUmlRtValue extends MokaValue implements IValue, IPresentation {

	private static final String SERIALIZE_METHOD_NAME = "serialize";

	/**
	 * The mirror of the value contained in the running virtual machine.
	 */
	private Value value;

	/**
	 * Main thread for invoking methods in the virtual machine to support
	 * presentation.
	 */
	protected JDTThreadWrapper thread;

	protected JDTUtils jdtUtils;

	public XUmlRtValue(MokaDebugTarget debugTarget, JDTThreadWrapper mainThread, Value value) {
		super(debugTarget);
		this.thread = mainThread;
		this.value = value;
		this.jdtUtils = new JDTUtils(mainThread);
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
			} else if (jdtUtils.isCollectionType(type)) {
				// collection
				List<IVariable> list = new LinkedList<IVariable>();
				List<Value> collectionValues = jdtUtils.getCollectionValues(valueObj);
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
			ClassM metaInfo = ClassM.deserialize(res.value());
			Map<PropertyM, Value> attribValues = new HashMap<PropertyM, Value>();
			for (PropertyM attrib : metaInfo.getAttributes()) {
				attribValues.put(attrib, thread.invokeMethod(valueObj, attrib.getIdentifier()));
			}
			return presentAttributes(attribValues);
		} catch (InvalidTypeException | ClassNotLoadedException | IncompatibleThreadStateException | InvocationException
				| NoSuchMethodException e) {
			IdePlugin.logError("Error while retrieving metainfo", e);
			return new IVariable[0];
		}
	}

	private IVariable[] presentAttributes(Map<PropertyM, Value> propertyValues) throws DebugException {
		List<XUmlRtVariable> shownAttributes = new LinkedList<>();
		for (Entry<PropertyM, Value> propertyValue : propertyValues.entrySet()) {
			PropertyM property = propertyValue.getKey();
			XUmlRtValue varValue;
			if (property.getBounds().isAtMostSingle()) {
				varValue = new SingleValue(debugTarget, thread, propertyValue.getValue());
			} else {
				varValue = new MultiValue(debugTarget, thread, propertyValue.getValue());
			}
			shownAttributes.add(new XUmlRtVariable(debugTarget, property, varValue));
		}
		// sort the attributes alphabetically
		shownAttributes.sort(Comparator.comparing(XUmlRtVariable::getName));
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
			IdePlugin.logError("Error while filling out details", e);
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

}
