/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgBehavior;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgClass;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState;

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
 * An implementation of the model object '<em><b>Rg Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl#getContainingClass <em>Containing Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl#getInitial <em>Initial</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl#getInitialEffect <em>Initial Effect</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RgRegionImpl extends MinimalEObjectImpl.Container implements RgRegion {
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
	protected RgClass containingClass;

	/**
	 * The cached value of the '{@link #getInitial() <em>Initial</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitial()
	 * @generated
	 * @ordered
	 */
	protected RgState initial;

	/**
	 * The cached value of the '{@link #getInitialEffect() <em>Initial Effect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialEffect()
	 * @generated
	 * @ordered
	 */
	protected RgBehavior initialEffect;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<RgState> states;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RgRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RegionPackage.Literals.RG_REGION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_REGION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgClass getContainingClass() {
		if (containingClass != null && containingClass.eIsProxy()) {
			InternalEObject oldContainingClass = (InternalEObject)containingClass;
			containingClass = (RgClass)eResolveProxy(oldContainingClass);
			if (containingClass != oldContainingClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RegionPackage.RG_REGION__CONTAINING_CLASS, oldContainingClass, containingClass));
			}
		}
		return containingClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgClass basicGetContainingClass() {
		return containingClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingClass(RgClass newContainingClass) {
		RgClass oldContainingClass = containingClass;
		containingClass = newContainingClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_REGION__CONTAINING_CLASS, oldContainingClass, containingClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgState getInitial() {
		if (initial != null && initial.eIsProxy()) {
			InternalEObject oldInitial = (InternalEObject)initial;
			initial = (RgState)eResolveProxy(oldInitial);
			if (initial != oldInitial) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RegionPackage.RG_REGION__INITIAL, oldInitial, initial));
			}
		}
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgState basicGetInitial() {
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitial(RgState newInitial) {
		RgState oldInitial = initial;
		initial = newInitial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_REGION__INITIAL, oldInitial, initial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgBehavior getInitialEffect() {
		if (initialEffect != null && initialEffect.eIsProxy()) {
			InternalEObject oldInitialEffect = (InternalEObject)initialEffect;
			initialEffect = (RgBehavior)eResolveProxy(oldInitialEffect);
			if (initialEffect != oldInitialEffect) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RegionPackage.RG_REGION__INITIAL_EFFECT, oldInitialEffect, initialEffect));
			}
		}
		return initialEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgBehavior basicGetInitialEffect() {
		return initialEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialEffect(RgBehavior newInitialEffect) {
		RgBehavior oldInitialEffect = initialEffect;
		initialEffect = newInitialEffect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_REGION__INITIAL_EFFECT, oldInitialEffect, initialEffect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RgState> getStates() {
		if (states == null) {
			states = new EObjectResolvingEList<RgState>(RgState.class, this, RegionPackage.RG_REGION__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RegionPackage.RG_REGION__NAME:
				return getName();
			case RegionPackage.RG_REGION__CONTAINING_CLASS:
				if (resolve) return getContainingClass();
				return basicGetContainingClass();
			case RegionPackage.RG_REGION__INITIAL:
				if (resolve) return getInitial();
				return basicGetInitial();
			case RegionPackage.RG_REGION__INITIAL_EFFECT:
				if (resolve) return getInitialEffect();
				return basicGetInitialEffect();
			case RegionPackage.RG_REGION__STATES:
				return getStates();
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
			case RegionPackage.RG_REGION__NAME:
				setName((String)newValue);
				return;
			case RegionPackage.RG_REGION__CONTAINING_CLASS:
				setContainingClass((RgClass)newValue);
				return;
			case RegionPackage.RG_REGION__INITIAL:
				setInitial((RgState)newValue);
				return;
			case RegionPackage.RG_REGION__INITIAL_EFFECT:
				setInitialEffect((RgBehavior)newValue);
				return;
			case RegionPackage.RG_REGION__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends RgState>)newValue);
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
			case RegionPackage.RG_REGION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RegionPackage.RG_REGION__CONTAINING_CLASS:
				setContainingClass((RgClass)null);
				return;
			case RegionPackage.RG_REGION__INITIAL:
				setInitial((RgState)null);
				return;
			case RegionPackage.RG_REGION__INITIAL_EFFECT:
				setInitialEffect((RgBehavior)null);
				return;
			case RegionPackage.RG_REGION__STATES:
				getStates().clear();
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
			case RegionPackage.RG_REGION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RegionPackage.RG_REGION__CONTAINING_CLASS:
				return containingClass != null;
			case RegionPackage.RG_REGION__INITIAL:
				return initial != null;
			case RegionPackage.RG_REGION__INITIAL_EFFECT:
				return initialEffect != null;
			case RegionPackage.RG_REGION__STATES:
				return states != null && !states.isEmpty();
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
				case RegionPackage.RG_REGION__NAME: return BasePackage.NAMED__NAME;
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
				case BasePackage.NAMED__NAME: return RegionPackage.RG_REGION__NAME;
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

} //RgRegionImpl
