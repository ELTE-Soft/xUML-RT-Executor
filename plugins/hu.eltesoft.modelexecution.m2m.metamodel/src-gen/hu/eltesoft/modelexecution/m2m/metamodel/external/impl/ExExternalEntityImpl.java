/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.external.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType;
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity;
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ex External Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExExternalEntityImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExExternalEntityImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExExternalEntityImpl#getImplementationClass <em>Implementation Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExExternalEntityImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExExternalEntityImpl extends TranslationObjectImpl implements ExExternalEntity {
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
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<ExOperation> operations;

	/**
	 * The default value of the '{@link #getImplementationClass() <em>Implementation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClass()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementationClass() <em>Implementation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClass()
	 * @generated
	 * @ordered
	 */
	protected String implementationClass = IMPLEMENTATION_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ExEntityType TYPE_EDEFAULT = ExEntityType.STATELESS;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ExEntityType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExExternalEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExternalPackage.Literals.EX_EXTERNAL_ENTITY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExternalPackage.EX_EXTERNAL_ENTITY__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectResolvingEList<ExOperation>(ExOperation.class, this, ExternalPackage.EX_EXTERNAL_ENTITY__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementationClass() {
		return implementationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClass(String newImplementationClass) {
		String oldImplementationClass = implementationClass;
		implementationClass = newImplementationClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExternalPackage.EX_EXTERNAL_ENTITY__IMPLEMENTATION_CLASS, oldImplementationClass, implementationClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExEntityType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ExEntityType newType) {
		ExEntityType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExternalPackage.EX_EXTERNAL_ENTITY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExternalPackage.EX_EXTERNAL_ENTITY__REFERENCE:
				return getReference();
			case ExternalPackage.EX_EXTERNAL_ENTITY__OPERATIONS:
				return getOperations();
			case ExternalPackage.EX_EXTERNAL_ENTITY__IMPLEMENTATION_CLASS:
				return getImplementationClass();
			case ExternalPackage.EX_EXTERNAL_ENTITY__TYPE:
				return getType();
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
			case ExternalPackage.EX_EXTERNAL_ENTITY__REFERENCE:
				setReference((NamedReference)newValue);
				return;
			case ExternalPackage.EX_EXTERNAL_ENTITY__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends ExOperation>)newValue);
				return;
			case ExternalPackage.EX_EXTERNAL_ENTITY__IMPLEMENTATION_CLASS:
				setImplementationClass((String)newValue);
				return;
			case ExternalPackage.EX_EXTERNAL_ENTITY__TYPE:
				setType((ExEntityType)newValue);
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
			case ExternalPackage.EX_EXTERNAL_ENTITY__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case ExternalPackage.EX_EXTERNAL_ENTITY__OPERATIONS:
				getOperations().clear();
				return;
			case ExternalPackage.EX_EXTERNAL_ENTITY__IMPLEMENTATION_CLASS:
				setImplementationClass(IMPLEMENTATION_CLASS_EDEFAULT);
				return;
			case ExternalPackage.EX_EXTERNAL_ENTITY__TYPE:
				setType(TYPE_EDEFAULT);
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
			case ExternalPackage.EX_EXTERNAL_ENTITY__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case ExternalPackage.EX_EXTERNAL_ENTITY__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case ExternalPackage.EX_EXTERNAL_ENTITY__IMPLEMENTATION_CLASS:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case ExternalPackage.EX_EXTERNAL_ENTITY__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(", implementationClass: ");
		result.append(implementationClass);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ExExternalEntityImpl
