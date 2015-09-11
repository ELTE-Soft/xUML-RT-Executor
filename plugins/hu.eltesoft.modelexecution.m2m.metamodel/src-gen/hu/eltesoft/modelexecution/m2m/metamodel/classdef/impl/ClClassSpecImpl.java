/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.NamedImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClCtorRecord;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec;
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
 * An implementation of the model object '<em><b>Cl Class Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl#getReceptions <em>Receptions</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl#isHasStateMachine <em>Has State Machine</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl#getCtorRecords <em>Ctor Records</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl#isHasReceptions <em>Has Receptions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClClassSpecImpl extends NamedImpl implements ClClassSpec {
	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<ClOperationSpec> operations;

	/**
	 * The cached value of the '{@link #getReceptions() <em>Receptions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceptions()
	 * @generated
	 * @ordered
	 */
	protected EList<ClReceptionSpec> receptions;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ClAttributeSpec> attributes;

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
	 * The default value of the '{@link #isHasStateMachine() <em>Has State Machine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasStateMachine()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_STATE_MACHINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasStateMachine() <em>Has State Machine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasStateMachine()
	 * @generated
	 * @ordered
	 */
	protected boolean hasStateMachine = HAS_STATE_MACHINE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClClassSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdefPackage.Literals.CL_CLASS_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClOperationSpec> getOperations() {
		if (operations == null) {
			operations = new EObjectResolvingEList<ClOperationSpec>(ClOperationSpec.class, this, ClassdefPackage.CL_CLASS_SPEC__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClReceptionSpec> getReceptions() {
		if (receptions == null) {
			receptions = new EObjectResolvingEList<ClReceptionSpec>(ClReceptionSpec.class, this, ClassdefPackage.CL_CLASS_SPEC__RECEPTIONS);
		}
		return receptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClAttributeSpec> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectResolvingEList<ClAttributeSpec>(ClAttributeSpec.class, this, ClassdefPackage.CL_CLASS_SPEC__ATTRIBUTES);
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
			associations = new EObjectResolvingEList<ClAssociation>(ClAssociation.class, this, ClassdefPackage.CL_CLASS_SPEC__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasStateMachine() {
		return hasStateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasStateMachine(boolean newHasStateMachine) {
		boolean oldHasStateMachine = hasStateMachine;
		hasStateMachine = newHasStateMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdefPackage.CL_CLASS_SPEC__HAS_STATE_MACHINE, oldHasStateMachine, hasStateMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedReference> getParents() {
		if (parents == null) {
			parents = new EDataTypeUniqueEList<NamedReference>(NamedReference.class, this, ClassdefPackage.CL_CLASS_SPEC__PARENTS);
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
			ctorRecords = new EObjectResolvingEList<ClCtorRecord>(ClCtorRecord.class, this, ClassdefPackage.CL_CLASS_SPEC__CTOR_RECORDS);
		}
		return ctorRecords;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdefPackage.CL_CLASS_SPEC__HAS_RECEPTIONS, oldHasReceptions, hasReceptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdefPackage.CL_CLASS_SPEC__OPERATIONS:
				return getOperations();
			case ClassdefPackage.CL_CLASS_SPEC__RECEPTIONS:
				return getReceptions();
			case ClassdefPackage.CL_CLASS_SPEC__ATTRIBUTES:
				return getAttributes();
			case ClassdefPackage.CL_CLASS_SPEC__ASSOCIATIONS:
				return getAssociations();
			case ClassdefPackage.CL_CLASS_SPEC__HAS_STATE_MACHINE:
				return isHasStateMachine();
			case ClassdefPackage.CL_CLASS_SPEC__PARENTS:
				return getParents();
			case ClassdefPackage.CL_CLASS_SPEC__CTOR_RECORDS:
				return getCtorRecords();
			case ClassdefPackage.CL_CLASS_SPEC__HAS_RECEPTIONS:
				return isHasReceptions();
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
			case ClassdefPackage.CL_CLASS_SPEC__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends ClOperationSpec>)newValue);
				return;
			case ClassdefPackage.CL_CLASS_SPEC__RECEPTIONS:
				getReceptions().clear();
				getReceptions().addAll((Collection<? extends ClReceptionSpec>)newValue);
				return;
			case ClassdefPackage.CL_CLASS_SPEC__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends ClAttributeSpec>)newValue);
				return;
			case ClassdefPackage.CL_CLASS_SPEC__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends ClAssociation>)newValue);
				return;
			case ClassdefPackage.CL_CLASS_SPEC__HAS_STATE_MACHINE:
				setHasStateMachine((Boolean)newValue);
				return;
			case ClassdefPackage.CL_CLASS_SPEC__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends NamedReference>)newValue);
				return;
			case ClassdefPackage.CL_CLASS_SPEC__CTOR_RECORDS:
				getCtorRecords().clear();
				getCtorRecords().addAll((Collection<? extends ClCtorRecord>)newValue);
				return;
			case ClassdefPackage.CL_CLASS_SPEC__HAS_RECEPTIONS:
				setHasReceptions((Boolean)newValue);
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
			case ClassdefPackage.CL_CLASS_SPEC__OPERATIONS:
				getOperations().clear();
				return;
			case ClassdefPackage.CL_CLASS_SPEC__RECEPTIONS:
				getReceptions().clear();
				return;
			case ClassdefPackage.CL_CLASS_SPEC__ATTRIBUTES:
				getAttributes().clear();
				return;
			case ClassdefPackage.CL_CLASS_SPEC__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case ClassdefPackage.CL_CLASS_SPEC__HAS_STATE_MACHINE:
				setHasStateMachine(HAS_STATE_MACHINE_EDEFAULT);
				return;
			case ClassdefPackage.CL_CLASS_SPEC__PARENTS:
				getParents().clear();
				return;
			case ClassdefPackage.CL_CLASS_SPEC__CTOR_RECORDS:
				getCtorRecords().clear();
				return;
			case ClassdefPackage.CL_CLASS_SPEC__HAS_RECEPTIONS:
				setHasReceptions(HAS_RECEPTIONS_EDEFAULT);
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
			case ClassdefPackage.CL_CLASS_SPEC__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case ClassdefPackage.CL_CLASS_SPEC__RECEPTIONS:
				return receptions != null && !receptions.isEmpty();
			case ClassdefPackage.CL_CLASS_SPEC__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case ClassdefPackage.CL_CLASS_SPEC__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case ClassdefPackage.CL_CLASS_SPEC__HAS_STATE_MACHINE:
				return hasStateMachine != HAS_STATE_MACHINE_EDEFAULT;
			case ClassdefPackage.CL_CLASS_SPEC__PARENTS:
				return parents != null && !parents.isEmpty();
			case ClassdefPackage.CL_CLASS_SPEC__CTOR_RECORDS:
				return ctorRecords != null && !ctorRecords.isEmpty();
			case ClassdefPackage.CL_CLASS_SPEC__HAS_RECEPTIONS:
				return hasReceptions != HAS_RECEPTIONS_EDEFAULT;
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
		result.append(" (hasStateMachine: ");
		result.append(hasStateMachine);
		result.append(", parents: ");
		result.append(parents);
		result.append(", hasReceptions: ");
		result.append(hasReceptions);
		result.append(')');
		return result.toString();
	}

} //ClClassSpecImpl
