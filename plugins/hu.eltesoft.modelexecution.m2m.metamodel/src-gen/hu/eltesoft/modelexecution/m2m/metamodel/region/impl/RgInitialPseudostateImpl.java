/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.NamedImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rg Initial Pseudostate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgInitialPseudostateImpl#getInitialTransition <em>Initial Transition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RgInitialPseudostateImpl extends NamedImpl implements RgInitialPseudostate {
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
			case RegionPackage.RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION:
				return initialTransition != null;
		}
		return super.eIsSet(featureID);
	}

} //RgInitialPseudostateImpl
