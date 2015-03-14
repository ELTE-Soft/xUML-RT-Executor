/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhClass;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bh Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getContainingClass <em>Containing Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl#getAlfCode <em>Alf Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BhBehaviorImpl extends MinimalEObjectImpl.Container implements BhBehavior {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContainingClass() <em>Containing Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainingClass()
	 * @generated
	 * @ordered
	 */
	protected BhClass containingClass;

	/**
	 * The default value of the '{@link #getAlfCode() <em>Alf Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlfCode()
	 * @generated
	 * @ordered
	 */
	protected static final String ALF_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlfCode() <em>Alf Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlfCode()
	 * @generated
	 * @ordered
	 */
	protected String alfCode = ALF_CODE_EDEFAULT;

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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BhClass getContainingClass() {
		if (containingClass != null && containingClass.eIsProxy()) {
			InternalEObject oldContainingClass = (InternalEObject)containingClass;
			containingClass = (BhClass)eResolveProxy(oldContainingClass);
			if (containingClass != oldContainingClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorPackage.BH_BEHAVIOR__CONTAINING_CLASS, oldContainingClass, containingClass));
			}
		}
		return containingClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BhClass basicGetContainingClass() {
		return containingClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingClass(BhClass newContainingClass) {
		BhClass oldContainingClass = containingClass;
		containingClass = newContainingClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__CONTAINING_CLASS, oldContainingClass, containingClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlfCode() {
		return alfCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlfCode(String newAlfCode) {
		String oldAlfCode = alfCode;
		alfCode = newAlfCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BH_BEHAVIOR__ALF_CODE, oldAlfCode, alfCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviorPackage.BH_BEHAVIOR__NAME:
				return getName();
			case BehaviorPackage.BH_BEHAVIOR__CONTAINING_CLASS:
				if (resolve) return getContainingClass();
				return basicGetContainingClass();
			case BehaviorPackage.BH_BEHAVIOR__ALF_CODE:
				return getAlfCode();
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
			case BehaviorPackage.BH_BEHAVIOR__NAME:
				setName((String)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__CONTAINING_CLASS:
				setContainingClass((BhClass)newValue);
				return;
			case BehaviorPackage.BH_BEHAVIOR__ALF_CODE:
				setAlfCode((String)newValue);
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
			case BehaviorPackage.BH_BEHAVIOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BehaviorPackage.BH_BEHAVIOR__CONTAINING_CLASS:
				setContainingClass((BhClass)null);
				return;
			case BehaviorPackage.BH_BEHAVIOR__ALF_CODE:
				setAlfCode(ALF_CODE_EDEFAULT);
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
			case BehaviorPackage.BH_BEHAVIOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BehaviorPackage.BH_BEHAVIOR__CONTAINING_CLASS:
				return containingClass != null;
			case BehaviorPackage.BH_BEHAVIOR__ALF_CODE:
				return ALF_CODE_EDEFAULT == null ? alfCode != null : !ALF_CODE_EDEFAULT.equals(alfCode);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Named.class) {
			switch (derivedFeatureID) {
				case BehaviorPackage.BH_BEHAVIOR__NAME: return BasePackage.NAMED__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Named.class) {
			switch (baseFeatureID) {
				case BasePackage.NAMED__NAME: return BehaviorPackage.BH_BEHAVIOR__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", alfCode: ");
		result.append(alfCode);
		result.append(')');
		return result.toString();
	}

} //BhBehaviorImpl
