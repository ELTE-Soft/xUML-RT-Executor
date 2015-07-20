/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClCtorRecord;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cl Ctor Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClCtorRecordImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClCtorRecordImpl#getUsedObjs <em>Used Objs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClCtorRecordImpl extends TranslationObjectImpl implements ClCtorRecord {
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
	 * The cached value of the '{@link #getUsedObjs() <em>Used Objs</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedObjs()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedReference> usedObjs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClCtorRecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdefPackage.Literals.CL_CTOR_RECORD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdefPackage.CL_CTOR_RECORD__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedReference> getUsedObjs() {
		if (usedObjs == null) {
			usedObjs = new EDataTypeUniqueEList<NamedReference>(NamedReference.class, this, ClassdefPackage.CL_CTOR_RECORD__USED_OBJS);
		}
		return usedObjs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdefPackage.CL_CTOR_RECORD__REFERENCE:
				return getReference();
			case ClassdefPackage.CL_CTOR_RECORD__USED_OBJS:
				return getUsedObjs();
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
			case ClassdefPackage.CL_CTOR_RECORD__REFERENCE:
				setReference((NamedReference)newValue);
				return;
			case ClassdefPackage.CL_CTOR_RECORD__USED_OBJS:
				getUsedObjs().clear();
				getUsedObjs().addAll((Collection<? extends NamedReference>)newValue);
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
			case ClassdefPackage.CL_CTOR_RECORD__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case ClassdefPackage.CL_CTOR_RECORD__USED_OBJS:
				getUsedObjs().clear();
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
			case ClassdefPackage.CL_CTOR_RECORD__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case ClassdefPackage.CL_CTOR_RECORD__USED_OBJS:
				return usedObjs != null && !usedObjs.isEmpty();
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
		result.append(", usedObjs: ");
		result.append(usedObjs);
		result.append(')');
		return result.toString();
	}

} //ClCtorRecordImpl
