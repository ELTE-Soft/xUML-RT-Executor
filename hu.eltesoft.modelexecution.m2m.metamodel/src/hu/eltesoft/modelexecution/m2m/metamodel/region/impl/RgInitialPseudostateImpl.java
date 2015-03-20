/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition;

import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rg Initial Pseudostate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgInitialPseudostateImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgInitialPseudostateImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgInitialPseudostateImpl#getInitialTransition <em>Initial Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RgInitialPseudostateImpl extends MinimalEObjectImpl.Container implements RgInitialPseudostate {
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
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final Reference REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected Reference reference = REFERENCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInitialTransition() <em>Initial Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialTransition()
	 * @generated
	 * @ordered
	 */
	protected RgTransition initialTransition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RgInitialPseudostateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RegionPackage.Literals.RG_INITIAL_PSEUDOSTATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_INITIAL_PSEUDOSTATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(Reference newReference) {
		Reference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_INITIAL_PSEUDOSTATE__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgTransition getInitialTransition() {
		if (initialTransition != null && initialTransition.eIsProxy()) {
			InternalEObject oldInitialTransition = (InternalEObject)initialTransition;
			initialTransition = (RgTransition)eResolveProxy(oldInitialTransition);
			if (initialTransition != oldInitialTransition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RegionPackage.RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION, oldInitialTransition, initialTransition));
			}
		}
		return initialTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgTransition basicGetInitialTransition() {
		return initialTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialTransition(RgTransition newInitialTransition) {
		RgTransition oldInitialTransition = initialTransition;
		initialTransition = newInitialTransition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION, oldInitialTransition, initialTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__NAME:
				return getName();
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__REFERENCE:
				return getReference();
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION:
				if (resolve) return getInitialTransition();
				return basicGetInitialTransition();
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
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__NAME:
				setName((String)newValue);
				return;
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__REFERENCE:
				setReference((Reference)newValue);
				return;
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION:
				setInitialTransition((RgTransition)newValue);
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
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION:
				setInitialTransition((RgTransition)null);
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
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION:
				return initialTransition != null;
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
		if (baseClass == Referenced.class) {
			switch (derivedFeatureID) {
				case RegionPackage.RG_INITIAL_PSEUDOSTATE__REFERENCE: return BasePackage.REFERENCED__REFERENCE;
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
		if (baseClass == Referenced.class) {
			switch (baseFeatureID) {
				case BasePackage.REFERENCED__REFERENCE: return RegionPackage.RG_INITIAL_PSEUDOSTATE__REFERENCE;
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
		result.append(", reference: ");
		result.append(reference);
		result.append(')');
		return result.toString();
	}

} //RgInitialPseudostateImpl
