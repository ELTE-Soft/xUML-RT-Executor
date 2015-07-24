/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassdefFactoryImpl extends EFactoryImpl implements ClassdefFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassdefFactory init() {
		try {
			ClassdefFactory theClassdefFactory = (ClassdefFactory)EPackage.Registry.INSTANCE.getEFactory(ClassdefPackage.eNS_URI);
			if (theClassdefFactory != null) {
				return theClassdefFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassdefFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdefFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ClassdefPackage.CL_CLASS: return createClClass();
			case ClassdefPackage.CL_CLASS_SPEC: return createClClassSpec();
			case ClassdefPackage.CL_OPERATION: return createClOperation();
			case ClassdefPackage.CL_OPERATION_SPEC: return createClOperationSpec();
			case ClassdefPackage.CL_RECEPTION: return createClReception();
			case ClassdefPackage.CL_RECEPTION_SPEC: return createClReceptionSpec();
			case ClassdefPackage.CL_RECEPTION_PARAMETER: return createClReceptionParameter();
			case ClassdefPackage.CL_ATTRIBUTE: return createClAttribute();
			case ClassdefPackage.CL_ATTRIBUTE_SPEC: return createClAttributeSpec();
			case ClassdefPackage.CL_INHERITED_ATTRIBUTE: return createClInheritedAttribute();
			case ClassdefPackage.CL_ASSOCIATION: return createClAssociation();
			case ClassdefPackage.CL_INHERITED_ASSOCIATION: return createClInheritedAssociation();
			case ClassdefPackage.CL_CTOR_RECORD: return createClCtorRecord();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClClass createClClass() {
		ClClassImpl clClass = new ClClassImpl();
		return clClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClClassSpec createClClassSpec() {
		ClClassSpecImpl clClassSpec = new ClClassSpecImpl();
		return clClassSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClOperation createClOperation() {
		ClOperationImpl clOperation = new ClOperationImpl();
		return clOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClOperationSpec createClOperationSpec() {
		ClOperationSpecImpl clOperationSpec = new ClOperationSpecImpl();
		return clOperationSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClReception createClReception() {
		ClReceptionImpl clReception = new ClReceptionImpl();
		return clReception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClReceptionSpec createClReceptionSpec() {
		ClReceptionSpecImpl clReceptionSpec = new ClReceptionSpecImpl();
		return clReceptionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClReceptionParameter createClReceptionParameter() {
		ClReceptionParameterImpl clReceptionParameter = new ClReceptionParameterImpl();
		return clReceptionParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClAttribute createClAttribute() {
		ClAttributeImpl clAttribute = new ClAttributeImpl();
		return clAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClAttributeSpec createClAttributeSpec() {
		ClAttributeSpecImpl clAttributeSpec = new ClAttributeSpecImpl();
		return clAttributeSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClInheritedAttribute createClInheritedAttribute() {
		ClInheritedAttributeImpl clInheritedAttribute = new ClInheritedAttributeImpl();
		return clInheritedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClAssociation createClAssociation() {
		ClAssociationImpl clAssociation = new ClAssociationImpl();
		return clAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClInheritedAssociation createClInheritedAssociation() {
		ClInheritedAssociationImpl clInheritedAssociation = new ClInheritedAssociationImpl();
		return clInheritedAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClCtorRecord createClCtorRecord() {
		ClCtorRecordImpl clCtorRecord = new ClCtorRecordImpl();
		return clCtorRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdefPackage getClassdefPackage() {
		return (ClassdefPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClassdefPackage getPackage() {
		return ClassdefPackage.eINSTANCE;
	}

} //ClassdefFactoryImpl
