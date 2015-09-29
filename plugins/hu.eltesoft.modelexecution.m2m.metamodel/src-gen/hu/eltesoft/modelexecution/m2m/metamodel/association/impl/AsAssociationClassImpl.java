/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.association.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationClass;
import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAssociation;
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
 * An implementation of the model object '<em><b>As Association Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getDestructor <em>Destructor</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getReceptions <em>Receptions</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getInheritedAttributes <em>Inherited Attributes</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getInheritedAssociations <em>Inherited Associations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#isHasReceptions <em>Has Receptions</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#isIsAbstract <em>Is Abstract</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AsAssociationClassImpl extends AsAssociationImpl implements AsAssociationClass {
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
	 * The default value of the '{@link #getDestructor() <em>Destructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestructor()
	 * @generated
	 * @ordered
	 */
	protected static final NamedReference DESTRUCTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestructor() <em>Destructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestructor()
	 * @generated
	 * @ordered
	 */
	protected NamedReference destructor = DESTRUCTOR_EDEFAULT;

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
	 * The cached value of the '{@link #getInheritedAssociations() <em>Inherited Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<ClInheritedAssociation> inheritedAssociations;

	/**
	 * The default value of the '{@link #isHasReceptions() <em>Has Receptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasReceptions()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_RECEPTIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasReceptions() <em>Has Receptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasReceptions()
	 * @generated
	 * @ordered
	 */
	protected boolean hasReceptions = HAS_RECEPTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsAssociationClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssociationPackage.Literals.AS_ASSOCIATION_CLASS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AssociationPackage.AS_ASSOCIATION_CLASS__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedReference getDestructor() {
		return destructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestructor(NamedReference newDestructor) {
		NamedReference oldDestructor = destructor;
		destructor = newDestructor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssociationPackage.AS_ASSOCIATION_CLASS__DESTRUCTOR, oldDestructor, destructor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectResolvingEList<ClOperation>(ClOperation.class, this, AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS);
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
			receptions = new EObjectResolvingEList<ClReception>(ClReception.class, this, AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS);
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
			attributes = new EObjectResolvingEList<ClAttribute>(ClAttribute.class, this, AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES);
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
			inheritedAttributes = new EObjectResolvingEList<ClInheritedAttribute>(ClInheritedAttribute.class, this, AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ATTRIBUTES);
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
			associations = new EObjectResolvingEList<ClAssociation>(ClAssociation.class, this, AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS);
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
			parents = new EDataTypeUniqueEList<NamedReference>(NamedReference.class, this, AssociationPackage.AS_ASSOCIATION_CLASS__PARENTS);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClInheritedAssociation> getInheritedAssociations() {
		if (inheritedAssociations == null) {
			inheritedAssociations = new EObjectResolvingEList<ClInheritedAssociation>(ClInheritedAssociation.class, this, AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ASSOCIATIONS);
		}
		return inheritedAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasReceptions() {
		return hasReceptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasReceptions(boolean newHasReceptions) {
		boolean oldHasReceptions = hasReceptions;
		hasReceptions = newHasReceptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssociationPackage.AS_ASSOCIATION_CLASS__HAS_RECEPTIONS, oldHasReceptions, hasReceptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssociationPackage.AS_ASSOCIATION_CLASS__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AssociationPackage.AS_ASSOCIATION_CLASS__REGION:
				return getRegion();
			case AssociationPackage.AS_ASSOCIATION_CLASS__DESTRUCTOR:
				return getDestructor();
			case AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS:
				return getOperations();
			case AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS:
				return getReceptions();
			case AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES:
				return getAttributes();
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ATTRIBUTES:
				return getInheritedAttributes();
			case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS:
				return getAssociations();
			case AssociationPackage.AS_ASSOCIATION_CLASS__PARENTS:
				return getParents();
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ASSOCIATIONS:
				return getInheritedAssociations();
			case AssociationPackage.AS_ASSOCIATION_CLASS__HAS_RECEPTIONS:
				return isHasReceptions();
			case AssociationPackage.AS_ASSOCIATION_CLASS__IS_ABSTRACT:
				return isIsAbstract();
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
			case AssociationPackage.AS_ASSOCIATION_CLASS__REGION:
				setRegion((NamedReference)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__DESTRUCTOR:
				setDestructor((NamedReference)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends ClOperation>)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS:
				getReceptions().clear();
				getReceptions().addAll((Collection<? extends ClReception>)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends ClAttribute>)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ATTRIBUTES:
				getInheritedAttributes().clear();
				getInheritedAttributes().addAll((Collection<? extends ClInheritedAttribute>)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends ClAssociation>)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends NamedReference>)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ASSOCIATIONS:
				getInheritedAssociations().clear();
				getInheritedAssociations().addAll((Collection<? extends ClInheritedAssociation>)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__HAS_RECEPTIONS:
				setHasReceptions((Boolean)newValue);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
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
			case AssociationPackage.AS_ASSOCIATION_CLASS__REGION:
				setRegion(REGION_EDEFAULT);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__DESTRUCTOR:
				setDestructor(DESTRUCTOR_EDEFAULT);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS:
				getOperations().clear();
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS:
				getReceptions().clear();
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ATTRIBUTES:
				getInheritedAttributes().clear();
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__PARENTS:
				getParents().clear();
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ASSOCIATIONS:
				getInheritedAssociations().clear();
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__HAS_RECEPTIONS:
				setHasReceptions(HAS_RECEPTIONS_EDEFAULT);
				return;
			case AssociationPackage.AS_ASSOCIATION_CLASS__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
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
			case AssociationPackage.AS_ASSOCIATION_CLASS__REGION:
				return REGION_EDEFAULT == null ? region != null : !REGION_EDEFAULT.equals(region);
			case AssociationPackage.AS_ASSOCIATION_CLASS__DESTRUCTOR:
				return DESTRUCTOR_EDEFAULT == null ? destructor != null : !DESTRUCTOR_EDEFAULT.equals(destructor);
			case AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS:
				return receptions != null && !receptions.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ATTRIBUTES:
				return inheritedAttributes != null && !inheritedAttributes.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__PARENTS:
				return parents != null && !parents.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ASSOCIATIONS:
				return inheritedAssociations != null && !inheritedAssociations.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__HAS_RECEPTIONS:
				return hasReceptions != HAS_RECEPTIONS_EDEFAULT;
			case AssociationPackage.AS_ASSOCIATION_CLASS__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
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
		if (baseClass == ClClass.class) {
			switch (derivedFeatureID) {
				case AssociationPackage.AS_ASSOCIATION_CLASS__REGION: return ClassdefPackage.CL_CLASS__REGION;
				case AssociationPackage.AS_ASSOCIATION_CLASS__DESTRUCTOR: return ClassdefPackage.CL_CLASS__DESTRUCTOR;
				case AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS: return ClassdefPackage.CL_CLASS__OPERATIONS;
				case AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS: return ClassdefPackage.CL_CLASS__RECEPTIONS;
				case AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES: return ClassdefPackage.CL_CLASS__ATTRIBUTES;
				case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ATTRIBUTES: return ClassdefPackage.CL_CLASS__INHERITED_ATTRIBUTES;
				case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS: return ClassdefPackage.CL_CLASS__ASSOCIATIONS;
				case AssociationPackage.AS_ASSOCIATION_CLASS__PARENTS: return ClassdefPackage.CL_CLASS__PARENTS;
				case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ASSOCIATIONS: return ClassdefPackage.CL_CLASS__INHERITED_ASSOCIATIONS;
				case AssociationPackage.AS_ASSOCIATION_CLASS__HAS_RECEPTIONS: return ClassdefPackage.CL_CLASS__HAS_RECEPTIONS;
				case AssociationPackage.AS_ASSOCIATION_CLASS__IS_ABSTRACT: return ClassdefPackage.CL_CLASS__IS_ABSTRACT;
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
		if (baseClass == ClClass.class) {
			switch (baseFeatureID) {
				case ClassdefPackage.CL_CLASS__REGION: return AssociationPackage.AS_ASSOCIATION_CLASS__REGION;
				case ClassdefPackage.CL_CLASS__DESTRUCTOR: return AssociationPackage.AS_ASSOCIATION_CLASS__DESTRUCTOR;
				case ClassdefPackage.CL_CLASS__OPERATIONS: return AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS;
				case ClassdefPackage.CL_CLASS__RECEPTIONS: return AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS;
				case ClassdefPackage.CL_CLASS__ATTRIBUTES: return AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES;
				case ClassdefPackage.CL_CLASS__INHERITED_ATTRIBUTES: return AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ATTRIBUTES;
				case ClassdefPackage.CL_CLASS__ASSOCIATIONS: return AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS;
				case ClassdefPackage.CL_CLASS__PARENTS: return AssociationPackage.AS_ASSOCIATION_CLASS__PARENTS;
				case ClassdefPackage.CL_CLASS__INHERITED_ASSOCIATIONS: return AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_ASSOCIATIONS;
				case ClassdefPackage.CL_CLASS__HAS_RECEPTIONS: return AssociationPackage.AS_ASSOCIATION_CLASS__HAS_RECEPTIONS;
				case ClassdefPackage.CL_CLASS__IS_ABSTRACT: return AssociationPackage.AS_ASSOCIATION_CLASS__IS_ABSTRACT;
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
		result.append(" (region: ");
		result.append(region);
		result.append(", destructor: ");
		result.append(destructor);
		result.append(", parents: ");
		result.append(parents);
		result.append(", hasReceptions: ");
		result.append(hasReceptions);
		result.append(", isAbstract: ");
		result.append(isAbstract);
		result.append(')');
		return result.toString();
	}

} //AsAssociationClassImpl
