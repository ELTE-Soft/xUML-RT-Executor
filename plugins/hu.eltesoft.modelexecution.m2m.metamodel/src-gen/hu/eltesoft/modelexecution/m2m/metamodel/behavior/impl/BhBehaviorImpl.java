/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl;

import com.incquerylabs.uml.ralf.api.impl.ParsingResults;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Parameter;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.NamedImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bh Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getContainerClass <em>Container Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getParsingResults <em>Parsing Results</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#isHasSignal <em>Has Signal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BhBehaviorImpl extends NamedImpl implements BhBehavior {
	/**
	 * The default value of the '{@link #getContainerClass() <em>Container Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerClass()
	 * @generated
	 * @ordered
	 */
	protected static final NamedReference CONTAINER_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContainerClass() <em>Container Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerClass()
	 * @generated
	 * @ordered
	 */
	protected NamedReference containerClass = CONTAINER_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getParsingResults() <em>Parsing Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsingResults()
	 * @generated
	 * @ordered
	 */
	protected static final ParsingResults PARSING_RESULTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParsingResults() <em>Parsing Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsingResults()
	 * @generated
	 * @ordered
	 */
	protected ParsingResults parsingResults = PARSING_RESULTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The default value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean isStatic = IS_STATIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected Type returnType;

	/**
	 * The default value of the '{@link #isHasSignal() <em>Has Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasSignal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_SIGNAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasSignal() <em>Has Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasSignal()
	 * @generated
	 * @ordered
	 */
	protected boolean hasSignal = HAS_SIGNAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BhBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviorPackage.Literals.BH_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedReference getContainerClass() {
		return containerClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerClass(NamedReference newContainerClass) {
		NamedReference oldContainerClass = containerClass;
		containerClass = newContainerClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS, oldContainerClass, containerClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParsingResults getParsingResults() {
		return parsingResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParsingResults(ParsingResults newParsingResults) {
		ParsingResults oldParsingResults = parsingResults;
		parsingResults = newParsingResults;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__PARSING_RESULTS, oldParsingResults, parsingResults));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<Parameter>(Parameter.class, this, BehaviorPackage.BH_BEHAVIOR__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsStatic() {
		return isStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStatic(boolean newIsStatic) {
		boolean oldIsStatic = isStatic;
		isStatic = newIsStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__IS_STATIC, oldIsStatic, isStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getReturnType() {
		if (returnType != null && returnType.eIsProxy()) {
			InternalEObject oldReturnType = (InternalEObject)returnType;
			returnType = (Type)eResolveProxy(oldReturnType);
			if (returnType != oldReturnType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorPackage.BH_BEHAVIOR__RETURN_TYPE, oldReturnType, returnType));
			}
		}
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(Type newReturnType) {
		Type oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__RETURN_TYPE, oldReturnType, returnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasSignal() {
		return hasSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasSignal(boolean newHasSignal) {
		boolean oldHasSignal = hasSignal;
		hasSignal = newHasSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__HAS_SIGNAL, oldHasSignal, hasSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS:
				return getContainerClass();
			case BehaviorPackage.BH_BEHAVIOR__PARSING_RESULTS:
				return getParsingResults();
			case BehaviorPackage.BH_BEHAVIOR__PARAMETERS:
				return getParameters();
			case BehaviorPackage.BH_BEHAVIOR__IS_STATIC:
				return isIsStatic();
			case BehaviorPackage.BH_BEHAVIOR__RETURN_TYPE:
				if (resolve) return getReturnType();
				return basicGetReturnType();
			case BehaviorPackage.BH_BEHAVIOR__HAS_SIGNAL:
				return isHasSignal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS:
				setContainerClass((NamedReference)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__PARSING_RESULTS:
				setParsingResults((ParsingResults)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__RETURN_TYPE:
				setReturnType((Type)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__HAS_SIGNAL:
				setHasSignal((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS:
				setContainerClass(CONTAINER_CLASS_EDEFAULT);
				return;
			case BehaviorPackage.BH_BEHAVIOR__PARSING_RESULTS:
				setParsingResults(PARSING_RESULTS_EDEFAULT);
				return;
			case BehaviorPackage.BH_BEHAVIOR__PARAMETERS:
				getParameters().clear();
				return;
			case BehaviorPackage.BH_BEHAVIOR__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case BehaviorPackage.BH_BEHAVIOR__RETURN_TYPE:
				setReturnType((Type)null);
				return;
			case BehaviorPackage.BH_BEHAVIOR__HAS_SIGNAL:
				setHasSignal(HAS_SIGNAL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS:
				return CONTAINER_CLASS_EDEFAULT == null ? containerClass != null : !CONTAINER_CLASS_EDEFAULT.equals(containerClass);
			case BehaviorPackage.BH_BEHAVIOR__PARSING_RESULTS:
				return PARSING_RESULTS_EDEFAULT == null ? parsingResults != null : !PARSING_RESULTS_EDEFAULT.equals(parsingResults);
			case BehaviorPackage.BH_BEHAVIOR__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case BehaviorPackage.BH_BEHAVIOR__IS_STATIC:
				return isStatic != IS_STATIC_EDEFAULT;
			case BehaviorPackage.BH_BEHAVIOR__RETURN_TYPE:
				return returnType != null;
			case BehaviorPackage.BH_BEHAVIOR__HAS_SIGNAL:
				return hasSignal != HAS_SIGNAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (containerClass: ");
		result.append(containerClass);
		result.append(", parsingResults: ");
		result.append(parsingResults);
		result.append(", isStatic: ");
		result.append(isStatic);
		result.append(", hasSignal: ");
		result.append(hasSignal);
		result.append(')');
		return result.toString();
	}

} //BhBehaviorImpl
