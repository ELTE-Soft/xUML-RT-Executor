/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.callable.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.callable.CaCallable;
import hu.eltesoft.modelexecution.m2m.metamodel.callable.CallablePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ca Callable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CaCallableImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CaCallableImpl#getReceptions <em>Receptions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CaCallableImpl extends TranslationObjectImpl implements CaCallable {
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
	 * The cached value of the '{@link #getReceptions() <em>Receptions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceptions()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedReference> receptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CaCallableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CallablePackage.Literals.CA_CALLABLE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CallablePackage.CA_CALLABLE__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedReference> getReceptions() {
		if (receptions == null) {
			receptions = new EDataTypeUniqueEList<NamedReference>(NamedReference.class, this, CallablePackage.CA_CALLABLE__RECEPTIONS);
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
			case CallablePackage.CA_CALLABLE__REFERENCE:
				return getReference();
			case CallablePackage.CA_CALLABLE__RECEPTIONS:
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
			case CallablePackage.CA_CALLABLE__REFERENCE:
				setReference((NamedReference)newValue);
				return;
			case CallablePackage.CA_CALLABLE__RECEPTIONS:
				getReceptions().clear();
				getReceptions().addAll((Collection<? extends NamedReference>)newValue);
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
			case CallablePackage.CA_CALLABLE__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case CallablePackage.CA_CALLABLE__RECEPTIONS:
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
			case CallablePackage.CA_CALLABLE__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case CallablePackage.CA_CALLABLE__RECEPTIONS:
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (reference: ");
		result.append(reference);
		result.append(", receptions: ");
		result.append(receptions);
		result.append(')');
		return result.toString();
	}

} //CaCallableImpl
