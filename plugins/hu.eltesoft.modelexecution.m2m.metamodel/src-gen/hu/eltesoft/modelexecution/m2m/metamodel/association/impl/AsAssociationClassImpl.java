/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.association.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationClass;
import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getInheritedRegion <em>Inherited Region</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getReceptions <em>Receptions</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl#getAssociations <em>Associations</em>}</li>
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
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<ClAssociation> associations;

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
			eNotify(new ENotificationImpl(this, Notification.SET, AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_REGION, oldInheritedRegion, inheritedRegion));
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AssociationPackage.AS_ASSOCIATION_CLASS__REGION:
				return getRegion();
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_REGION:
				return getInheritedRegion();
			case AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS:
				return getOperations();
			case AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS:
				return getReceptions();
			case AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES:
				return getAttributes();
			case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS:
				return getAssociations();
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
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_REGION:
				setInheritedRegion((NamedReference)newValue);
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
			case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends ClAssociation>)newValue);
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
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_REGION:
				setInheritedRegion(INHERITED_REGION_EDEFAULT);
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
			case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS:
				getAssociations().clear();
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
			case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_REGION:
				return INHERITED_REGION_EDEFAULT == null ? inheritedRegion != null : !INHERITED_REGION_EDEFAULT.equals(inheritedRegion);
			case AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS:
				return receptions != null && !receptions.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
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
				case AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_REGION: return ClassdefPackage.CL_CLASS__INHERITED_REGION;
				case AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS: return ClassdefPackage.CL_CLASS__OPERATIONS;
				case AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS: return ClassdefPackage.CL_CLASS__RECEPTIONS;
				case AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES: return ClassdefPackage.CL_CLASS__ATTRIBUTES;
				case AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS: return ClassdefPackage.CL_CLASS__ASSOCIATIONS;
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
				case ClassdefPackage.CL_CLASS__INHERITED_REGION: return AssociationPackage.AS_ASSOCIATION_CLASS__INHERITED_REGION;
				case ClassdefPackage.CL_CLASS__OPERATIONS: return AssociationPackage.AS_ASSOCIATION_CLASS__OPERATIONS;
				case ClassdefPackage.CL_CLASS__RECEPTIONS: return AssociationPackage.AS_ASSOCIATION_CLASS__RECEPTIONS;
				case ClassdefPackage.CL_CLASS__ATTRIBUTES: return AssociationPackage.AS_ASSOCIATION_CLASS__ATTRIBUTES;
				case ClassdefPackage.CL_CLASS__ASSOCIATIONS: return AssociationPackage.AS_ASSOCIATION_CLASS__ASSOCIATIONS;
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
		result.append(", inheritedRegion: ");
		result.append(inheritedRegion);
		result.append(')');
		return result.toString();
	}

} //AsAssociationClassImpl
