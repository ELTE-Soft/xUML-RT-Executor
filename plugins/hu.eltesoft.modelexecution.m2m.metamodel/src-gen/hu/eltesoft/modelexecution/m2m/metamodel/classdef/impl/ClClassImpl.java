/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClCtorRecord;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cl Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getInheritedRegion <em>Inherited Region</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getReceptions <em>Receptions</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getInheritedAttributes <em>Inherited Attributes</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl#getCtorRecords <em>Ctor Records</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClClassImpl extends TranslationObjectImpl implements ClClass {
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
	 * The default value of the '{@link #getRegion() <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected static final NamedReference REGION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected NamedReference region = REGION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInheritedRegion() <em>Inherited Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedRegion()
	 * @generated
	 * @ordered
	 */
	protected static final NamedReference INHERITED_REGION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInheritedRegion() <em>Inherited Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedRegion()
	 * @generated
	 * @ordered
	 */
	protected NamedReference inheritedRegion = INHERITED_REGION_EDEFAULT;

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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ClAttribute> attributes;

	/**
	 * The cached value of the '{@link #getInheritedAttributes() <em>Inherited Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ClInheritedAttribute> inheritedAttributes;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<ClAssociation> associations;

	/**
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedReference> parents;

	/**
	 * The cached value of the '{@link #getCtorRecords() <em>Ctor Records</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCtorRecords()
	 * @generated
	 * @ordered
	 */
	protected EList<ClCtorRecord> ctorRecords;

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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdefPackage.CL_CLASS__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedReference getRegion() {
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegion(NamedReference newRegion) {
		NamedReference oldRegion = region;
		region = newRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdefPackage.CL_CLASS__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedReference getInheritedRegion() {
		return inheritedRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedRegion(NamedReference newInheritedRegion) {
		NamedReference oldInheritedRegion = inheritedRegion;
		inheritedRegion = newInheritedRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdefPackage.CL_CLASS__INHERITED_REGION, oldInheritedRegion, inheritedRegion));
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
	public EList<ClAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectResolvingEList<ClAttribute>(ClAttribute.class, this, ClassdefPackage.CL_CLASS__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClInheritedAttribute> getInheritedAttributes() {
		if (inheritedAttributes == null) {
			inheritedAttributes = new EObjectResolvingEList<ClInheritedAttribute>(ClInheritedAttribute.class, this, ClassdefPackage.CL_CLASS__INHERITED_ATTRIBUTES);
		}
		return inheritedAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClAssociation> getAssociations() {
		if (associations == null) {
			associations = new EObjectResolvingEList<ClAssociation>(ClAssociation.class, this, ClassdefPackage.CL_CLASS__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedReference> getParents() {
		if (parents == null) {
			parents = new EDataTypeUniqueEList<NamedReference>(NamedReference.class, this, ClassdefPackage.CL_CLASS__PARENTS);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClCtorRecord> getCtorRecords() {
		if (ctorRecords == null) {
			ctorRecords = new EObjectResolvingEList<ClCtorRecord>(ClCtorRecord.class, this, ClassdefPackage.CL_CLASS__CTOR_RECORDS);
		}
		return ctorRecords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdefPackage.CL_CLASS__REFERENCE:
				return getReference();
			case ClassdefPackage.CL_CLASS__REGION:
				return getRegion();
			case ClassdefPackage.CL_CLASS__INHERITED_REGION:
				return getInheritedRegion();
			case ClassdefPackage.CL_CLASS__OPERATIONS:
				return getOperations();
			case ClassdefPackage.CL_CLASS__RECEPTIONS:
				return getReceptions();
			case ClassdefPackage.CL_CLASS__ATTRIBUTES:
				return getAttributes();
			case ClassdefPackage.CL_CLASS__INHERITED_ATTRIBUTES:
				return getInheritedAttributes();
			case ClassdefPackage.CL_CLASS__ASSOCIATIONS:
				return getAssociations();
			case ClassdefPackage.CL_CLASS__PARENTS:
				return getParents();
			case ClassdefPackage.CL_CLASS__CTOR_RECORDS:
				return getCtorRecords();
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
			case ClassdefPackage.CL_CLASS__REFERENCE:
				setReference((NamedReference)newValue);
				return;
			case ClassdefPackage.CL_CLASS__REGION:
				setRegion((NamedReference)newValue);
				return;
			case ClassdefPackage.CL_CLASS__INHERITED_REGION:
				setInheritedRegion((NamedReference)newValue);
				return;
			case ClassdefPackage.CL_CLASS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends ClOperation>)newValue);
				return;
			case ClassdefPackage.CL_CLASS__RECEPTIONS:
				getReceptions().clear();
				getReceptions().addAll((Collection<? extends ClReception>)newValue);
				return;
			case ClassdefPackage.CL_CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends ClAttribute>)newValue);
				return;
			case ClassdefPackage.CL_CLASS__INHERITED_ATTRIBUTES:
				getInheritedAttributes().clear();
				getInheritedAttributes().addAll((Collection<? extends ClInheritedAttribute>)newValue);
				return;
			case ClassdefPackage.CL_CLASS__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends ClAssociation>)newValue);
				return;
			case ClassdefPackage.CL_CLASS__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends NamedReference>)newValue);
				return;
			case ClassdefPackage.CL_CLASS__CTOR_RECORDS:
				getCtorRecords().clear();
				getCtorRecords().addAll((Collection<? extends ClCtorRecord>)newValue);
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
			case ClassdefPackage.CL_CLASS__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case ClassdefPackage.CL_CLASS__REGION:
				setRegion(REGION_EDEFAULT);
				return;
			case ClassdefPackage.CL_CLASS__INHERITED_REGION:
				setInheritedRegion(INHERITED_REGION_EDEFAULT);
				return;
			case ClassdefPackage.CL_CLASS__OPERATIONS:
				getOperations().clear();
				return;
			case ClassdefPackage.CL_CLASS__RECEPTIONS:
				getReceptions().clear();
				return;
			case ClassdefPackage.CL_CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case ClassdefPackage.CL_CLASS__INHERITED_ATTRIBUTES:
				getInheritedAttributes().clear();
				return;
			case ClassdefPackage.CL_CLASS__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case ClassdefPackage.CL_CLASS__PARENTS:
				getParents().clear();
				return;
			case ClassdefPackage.CL_CLASS__CTOR_RECORDS:
				getCtorRecords().clear();
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
			case ClassdefPackage.CL_CLASS__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case ClassdefPackage.CL_CLASS__REGION:
				return REGION_EDEFAULT == null ? region != null : !REGION_EDEFAULT.equals(region);
			case ClassdefPackage.CL_CLASS__INHERITED_REGION:
				return INHERITED_REGION_EDEFAULT == null ? inheritedRegion != null : !INHERITED_REGION_EDEFAULT.equals(inheritedRegion);
			case ClassdefPackage.CL_CLASS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case ClassdefPackage.CL_CLASS__RECEPTIONS:
				return receptions != null && !receptions.isEmpty();
			case ClassdefPackage.CL_CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case ClassdefPackage.CL_CLASS__INHERITED_ATTRIBUTES:
				return inheritedAttributes != null && !inheritedAttributes.isEmpty();
			case ClassdefPackage.CL_CLASS__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case ClassdefPackage.CL_CLASS__PARENTS:
				return parents != null && !parents.isEmpty();
			case ClassdefPackage.CL_CLASS__CTOR_RECORDS:
				return ctorRecords != null && !ctorRecords.isEmpty();
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
		result.append(", region: ");
		result.append(region);
		result.append(", inheritedRegion: ");
		result.append(inheritedRegion);
		result.append(", parents: ");
		result.append(parents);
		result.append(')');
		return result.toString();
	}

} //ClClassImpl
