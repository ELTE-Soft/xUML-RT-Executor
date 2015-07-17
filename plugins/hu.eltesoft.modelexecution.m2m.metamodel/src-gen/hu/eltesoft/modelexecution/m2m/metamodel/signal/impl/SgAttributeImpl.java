/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.signal.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sg Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SgAttributeImpl extends TranslationObjectImpl implements SgAttribute {
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
	 * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_BOUND_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected int lowerBound = LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_BOUND_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected int upperBound = UPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnique = IS_UNIQUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveType type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SgAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SignalPackage.Literals.SG_ATTRIBUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SignalPackage.SG_ATTRIBUTE__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(int newLowerBound) {
		int oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SignalPackage.SG_ATTRIBUTE__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(int newUpperBound) {
		int oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SignalPackage.SG_ATTRIBUTE__UPPER_BOUND, oldUpperBound, upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(boolean newIsOrdered) {
		boolean oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SignalPackage.SG_ATTRIBUTE__IS_ORDERED, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnique(boolean newIsUnique) {
		boolean oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SignalPackage.SG_ATTRIBUTE__IS_UNIQUE, oldIsUnique, isUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (PrimitiveType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SignalPackage.SG_ATTRIBUTE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(PrimitiveType newType) {
		PrimitiveType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SignalPackage.SG_ATTRIBUTE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SignalPackage.SG_ATTRIBUTE__REFERENCE:
				return getReference();
			case SignalPackage.SG_ATTRIBUTE__LOWER_BOUND:
				return getLowerBound();
			case SignalPackage.SG_ATTRIBUTE__UPPER_BOUND:
				return getUpperBound();
			case SignalPackage.SG_ATTRIBUTE__IS_ORDERED:
				return isIsOrdered();
			case SignalPackage.SG_ATTRIBUTE__IS_UNIQUE:
				return isIsUnique();
			case SignalPackage.SG_ATTRIBUTE__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case SignalPackage.SG_ATTRIBUTE__REFERENCE:
				setReference((NamedReference)newValue);
				return;
			case SignalPackage.SG_ATTRIBUTE__LOWER_BOUND:
				setLowerBound((Integer)newValue);
				return;
			case SignalPackage.SG_ATTRIBUTE__UPPER_BOUND:
				setUpperBound((Integer)newValue);
				return;
			case SignalPackage.SG_ATTRIBUTE__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case SignalPackage.SG_ATTRIBUTE__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case SignalPackage.SG_ATTRIBUTE__TYPE:
				setType((PrimitiveType)newValue);
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
			case SignalPackage.SG_ATTRIBUTE__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case SignalPackage.SG_ATTRIBUTE__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case SignalPackage.SG_ATTRIBUTE__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
				return;
			case SignalPackage.SG_ATTRIBUTE__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case SignalPackage.SG_ATTRIBUTE__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case SignalPackage.SG_ATTRIBUTE__TYPE:
				setType((PrimitiveType)null);
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
			case SignalPackage.SG_ATTRIBUTE__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case SignalPackage.SG_ATTRIBUTE__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
			case SignalPackage.SG_ATTRIBUTE__UPPER_BOUND:
				return upperBound != UPPER_BOUND_EDEFAULT;
			case SignalPackage.SG_ATTRIBUTE__IS_ORDERED:
				return isOrdered != IS_ORDERED_EDEFAULT;
			case SignalPackage.SG_ATTRIBUTE__IS_UNIQUE:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case SignalPackage.SG_ATTRIBUTE__TYPE:
				return type != null;
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
		if (baseClass == Multiplicity.class) {
			switch (derivedFeatureID) {
				case SignalPackage.SG_ATTRIBUTE__LOWER_BOUND: return BasePackage.MULTIPLICITY__LOWER_BOUND;
				case SignalPackage.SG_ATTRIBUTE__UPPER_BOUND: return BasePackage.MULTIPLICITY__UPPER_BOUND;
				case SignalPackage.SG_ATTRIBUTE__IS_ORDERED: return BasePackage.MULTIPLICITY__IS_ORDERED;
				case SignalPackage.SG_ATTRIBUTE__IS_UNIQUE: return BasePackage.MULTIPLICITY__IS_UNIQUE;
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
		if (baseClass == Multiplicity.class) {
			switch (baseFeatureID) {
				case BasePackage.MULTIPLICITY__LOWER_BOUND: return SignalPackage.SG_ATTRIBUTE__LOWER_BOUND;
				case BasePackage.MULTIPLICITY__UPPER_BOUND: return SignalPackage.SG_ATTRIBUTE__UPPER_BOUND;
				case BasePackage.MULTIPLICITY__IS_ORDERED: return SignalPackage.SG_ATTRIBUTE__IS_ORDERED;
				case BasePackage.MULTIPLICITY__IS_UNIQUE: return SignalPackage.SG_ATTRIBUTE__IS_UNIQUE;
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
		result.append(" (reference: ");
		result.append(reference);
		result.append(", lowerBound: ");
		result.append(lowerBound);
		result.append(", upperBound: ");
		result.append(upperBound);
		result.append(", isOrdered: ");
		result.append(isOrdered);
		result.append(", isUnique: ");
		result.append(isUnique);
		result.append(')');
		return result.toString();
	}

} //SgAttributeImpl
