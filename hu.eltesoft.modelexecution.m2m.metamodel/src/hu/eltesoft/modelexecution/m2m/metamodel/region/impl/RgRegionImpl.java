/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgClass;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate;
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
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl#getContainerClass <em>Container Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl#getInitialPseudostate <em>Initial Pseudostate</em>}</li>
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
	 * The cached value of the '{@link #getContainerClass() <em>Container Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerClass()
	 * @generated
	 * @ordered
	 */
	protected RgClass containerClass;

	/**
	 * The cached value of the '{@link #getInitialPseudostate() <em>Initial Pseudostate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialPseudostate()
	 * @generated
	 * @ordered
	 */
	protected RgInitialPseudostate initialPseudostate;

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
	public RgClass getContainerClass() {
		if (containerClass != null && containerClass.eIsProxy()) {
			InternalEObject oldContainerClass = (InternalEObject)containerClass;
			containerClass = (RgClass)eResolveProxy(oldContainerClass);
			if (containerClass != oldContainerClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RegionPackage.RG_REGION__CONTAINER_CLASS, oldContainerClass, containerClass));
			}
		}
		return containerClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgClass basicGetContainerClass() {
		return containerClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerClass(RgClass newContainerClass) {
		RgClass oldContainerClass = containerClass;
		containerClass = newContainerClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_REGION__CONTAINER_CLASS, oldContainerClass, containerClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgInitialPseudostate getInitialPseudostate() {
		if (initialPseudostate != null && initialPseudostate.eIsProxy()) {
			InternalEObject oldInitialPseudostate = (InternalEObject)initialPseudostate;
			initialPseudostate = (RgInitialPseudostate)eResolveProxy(oldInitialPseudostate);
			if (initialPseudostate != oldInitialPseudostate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RegionPackage.RG_REGION__INITIAL_PSEUDOSTATE, oldInitialPseudostate, initialPseudostate));
			}
		}
		return initialPseudostate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgInitialPseudostate basicGetInitialPseudostate() {
		return initialPseudostate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialPseudostate(RgInitialPseudostate newInitialPseudostate) {
		RgInitialPseudostate oldInitialPseudostate = initialPseudostate;
		initialPseudostate = newInitialPseudostate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_REGION__INITIAL_PSEUDOSTATE, oldInitialPseudostate, initialPseudostate));
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
			case RegionPackage.RG_REGION__CONTAINER_CLASS:
				if (resolve) return getContainerClass();
				return basicGetContainerClass();
			case RegionPackage.RG_REGION__INITIAL_PSEUDOSTATE:
				if (resolve) return getInitialPseudostate();
				return basicGetInitialPseudostate();
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
			case RegionPackage.RG_REGION__CONTAINER_CLASS:
				setContainerClass((RgClass)newValue);
				return;
			case RegionPackage.RG_REGION__INITIAL_PSEUDOSTATE:
				setInitialPseudostate((RgInitialPseudostate)newValue);
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
			case RegionPackage.RG_REGION__CONTAINER_CLASS:
				setContainerClass((RgClass)null);
				return;
			case RegionPackage.RG_REGION__INITIAL_PSEUDOSTATE:
				setInitialPseudostate((RgInitialPseudostate)null);
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
			case RegionPackage.RG_REGION__CONTAINER_CLASS:
				return containerClass != null;
			case RegionPackage.RG_REGION__INITIAL_PSEUDOSTATE:
				return initialPseudostate != null;
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //RgRegionImpl
