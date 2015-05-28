/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;

import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviorPackage.BH_BEHAVIOR__REFERENCE:
				return getReference();
			case BehaviorPackage.BH_BEHAVIOR__CONTAINER_CLASS:
				return getContainerClass();
			case BehaviorPackage.BH_BEHAVIOR__ALF_RESULT:
				return getAlfResult();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
		result.append(')');
		return result.toString();
	}

} //BhBehaviorImpl
