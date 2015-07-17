/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.external.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ex Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExOperationImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExOperationImpl#getProxyClass <em>Proxy Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExOperationImpl extends TranslationObjectImpl implements ExOperation {
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
	 * The default value of the '{@link #getProxyClass() <em>Proxy Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyClass()
	 * @generated
	 * @ordered
	 */
	protected static final String PROXY_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProxyClass() <em>Proxy Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyClass()
	 * @generated
	 * @ordered
	 */
	protected String proxyClass = PROXY_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExternalPackage.Literals.EX_OPERATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExternalPackage.EX_OPERATION__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProxyClass() {
		return proxyClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxyClass(String newProxyClass) {
		String oldProxyClass = proxyClass;
		proxyClass = newProxyClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExternalPackage.EX_OPERATION__PROXY_CLASS, oldProxyClass, proxyClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExternalPackage.EX_OPERATION__REFERENCE:
				return getReference();
			case ExternalPackage.EX_OPERATION__PROXY_CLASS:
				return getProxyClass();
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
			case ExternalPackage.EX_OPERATION__REFERENCE:
				setReference((NamedReference)newValue);
				return;
			case ExternalPackage.EX_OPERATION__PROXY_CLASS:
				setProxyClass((String)newValue);
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
			case ExternalPackage.EX_OPERATION__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case ExternalPackage.EX_OPERATION__PROXY_CLASS:
				setProxyClass(PROXY_CLASS_EDEFAULT);
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
			case ExternalPackage.EX_OPERATION__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case ExternalPackage.EX_OPERATION__PROXY_CLASS:
				return PROXY_CLASS_EDEFAULT == null ? proxyClass != null : !PROXY_CLASS_EDEFAULT.equals(proxyClass);
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
		result.append(", proxyClass: ");
		result.append(proxyClass);
		result.append(')');
		return result.toString();
	}

} //ExOperationImpl
