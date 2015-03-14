/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;

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
 * An implementation of the model object '<em><b>Cl Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getReceptions <em>Receptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClClassImpl extends MinimalEObjectImpl.Container implements ClClass {
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
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected ClRegion region;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<ClOperation> operations;

	/**
	 * The cached value of the '{@link #getReceptions() <em>Receptions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceptions()
	 * @generated
	 * @ordered
	 */
	protected EList<ClReception> receptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdefPackage.Literals.CL_CLASS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdefPackage.CL_CLASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClRegion getRegion() {
		if (region != null && region.eIsProxy()) {
			InternalEObject oldRegion = (InternalEObject)region;
			region = (ClRegion)eResolveProxy(oldRegion);
			if (region != oldRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdefPackage.CL_CLASS__REGION, oldRegion, region));
			}
		}
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClRegion basicGetRegion() {
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegion(ClRegion newRegion) {
		ClRegion oldRegion = region;
		region = newRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdefPackage.CL_CLASS__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectResolvingEList<ClOperation>(ClOperation.class, this, ClassdefPackage.CL_CLASS__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClReception> getReceptions() {
		if (receptions == null) {
			receptions = new EObjectResolvingEList<ClReception>(ClReception.class, this, ClassdefPackage.CL_CLASS__RECEPTIONS);
		}
		return receptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdefPackage.CL_CLASS__NAME:
				return getName();
			case ClassdefPackage.CL_CLASS__REGION:
				if (resolve) return getRegion();
				return basicGetRegion();
			case ClassdefPackage.CL_CLASS__OPERATIONS:
				return getOperations();
			case ClassdefPackage.CL_CLASS__RECEPTIONS:
				return getReceptions();
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
			case ClassdefPackage.CL_CLASS__NAME:
				setName((String)newValue);
				return;
			case ClassdefPackage.CL_CLASS__REGION:
				setRegion((ClRegion)newValue);
				return;
			case ClassdefPackage.CL_CLASS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends ClOperation>)newValue);
				return;
			case ClassdefPackage.CL_CLASS__RECEPTIONS:
				getReceptions().clear();
				getReceptions().addAll((Collection<? extends ClReception>)newValue);
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
			case ClassdefPackage.CL_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ClassdefPackage.CL_CLASS__REGION:
				setRegion((ClRegion)null);
				return;
			case ClassdefPackage.CL_CLASS__OPERATIONS:
				getOperations().clear();
				return;
			case ClassdefPackage.CL_CLASS__RECEPTIONS:
				getReceptions().clear();
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
			case ClassdefPackage.CL_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ClassdefPackage.CL_CLASS__REGION:
				return region != null;
			case ClassdefPackage.CL_CLASS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case ClassdefPackage.CL_CLASS__RECEPTIONS:
				return receptions != null && !receptions.isEmpty();
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
				case ClassdefPackage.CL_CLASS__NAME: return BasePackage.NAMED__NAME;
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
				case BasePackage.NAMED__NAME: return ClassdefPackage.CL_CLASS__NAME;
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
		result.append(')');
		return result.toString();
	}

} //ClClassImpl
