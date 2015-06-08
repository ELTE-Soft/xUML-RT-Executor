/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Type;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhParameter;
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bh Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getContainerClass <em>Container Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getAlfResult <em>Alf Result</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BhBehaviorImpl extends MinimalEObjectImpl.Container implements BhBehavior {
	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final NamedReference REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected NamedReference reference = REFERENCE_EDEFAULT;

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
	 * The default value of the '{@link #getAlfResult() <em>Alf Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlfResult()
	 * @generated
	 * @ordered
	 */
	protected static final AlfAnalyzerResult ALF_RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlfResult() <em>Alf Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlfResult()
	 * @generated
	 * @ordered
	 */
	protected AlfAnalyzerResult alfResult = ALF_RESULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<BhParameter> parameters;

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
	public NamedReference getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(NamedReference newReference) {
		NamedReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__REFERENCE, oldReference, reference));
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
	public AlfAnalyzerResult getAlfResult() {
		return alfResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlfResult(AlfAnalyzerResult newAlfResult) {
		AlfAnalyzerResult oldAlfResult = alfResult;
		alfResult = newAlfResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__ALF_RESULT, oldAlfResult, alfResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BhParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<BhParameter>(BhParameter.class, this, BehaviorPackage.BH_BEHAVIOR__PARAMETERS);
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviorPackage.BH_BEHAVIOR__REFERENCE:
				return getReference();
			case BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS:
				return getContainerClass();
			case BehaviorPackage.BH_BEHAVIOR__ALF_RESULT:
				return getAlfResult();
			case BehaviorPackage.BH_BEHAVIOR__PARAMETERS:
				return getParameters();
			case BehaviorPackage.BH_BEHAVIOR__IS_STATIC:
				return isIsStatic();
			case BehaviorPackage.BH_BEHAVIOR__RETURN_TYPE:
				if (resolve) return getReturnType();
				return basicGetReturnType();
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
			case BehaviorPackage.BH_BEHAVIOR__REFERENCE:
				setReference((NamedReference)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS:
				setContainerClass((NamedReference)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__ALF_RESULT:
				setAlfResult((AlfAnalyzerResult)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends BhParameter>)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__RETURN_TYPE:
				setReturnType((Type)newValue);
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
			case BehaviorPackage.BH_BEHAVIOR__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS:
				setContainerClass(CONTAINER_CLASS_EDEFAULT);
				return;
			case BehaviorPackage.BH_BEHAVIOR__ALF_RESULT:
				setAlfResult(ALF_RESULT_EDEFAULT);
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
			case BehaviorPackage.BH_BEHAVIOR__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS:
				return CONTAINER_CLASS_EDEFAULT == null ? containerClass != null : !CONTAINER_CLASS_EDEFAULT.equals(containerClass);
			case BehaviorPackage.BH_BEHAVIOR__ALF_RESULT:
				return ALF_RESULT_EDEFAULT == null ? alfResult != null : !ALF_RESULT_EDEFAULT.equals(alfResult);
			case BehaviorPackage.BH_BEHAVIOR__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case BehaviorPackage.BH_BEHAVIOR__IS_STATIC:
				return isStatic != IS_STATIC_EDEFAULT;
			case BehaviorPackage.BH_BEHAVIOR__RETURN_TYPE:
				return returnType != null;
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
		result.append(" (reference: ");
		result.append(reference);
		result.append(", containerClass: ");
		result.append(containerClass);
		result.append(", alfResult: ");
		result.append(alfResult);
		result.append(", isStatic: ");
		result.append(isStatic);
		result.append(')');
		return result.toString();
	}

} //BhBehaviorImpl
