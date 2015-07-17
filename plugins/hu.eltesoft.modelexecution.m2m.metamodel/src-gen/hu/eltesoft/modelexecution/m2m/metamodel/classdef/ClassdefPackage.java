/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
 * @model kind="package"
 * @generated
 */
public interface ClassdefPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classdef";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/classdef";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.classdef";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassdefPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl <em>Cl Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClClass()
	 * @generated
	 */
	int CL_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__REFERENCE = BasePackage.MODEL_ROOT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__REGION = BasePackage.MODEL_ROOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherited Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__INHERITED_REGION = BasePackage.MODEL_ROOT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__OPERATIONS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Receptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__RECEPTIONS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__ATTRIBUTES = BasePackage.MODEL_ROOT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Inherited Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__INHERITED_ATTRIBUTES = BasePackage.MODEL_ROOT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__ASSOCIATIONS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__PARENTS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Cl Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_FEATURE_COUNT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Cl Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_OPERATION_COUNT = BasePackage.MODEL_ROOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl <em>Cl Class Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClClassSpec()
	 * @generated
	 */
	int CL_CLASS_SPEC = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_SPEC__REFERENCE = BasePackage.MODEL_ROOT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_SPEC__OPERATIONS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Receptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_SPEC__RECEPTIONS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_SPEC__ATTRIBUTES = BasePackage.MODEL_ROOT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_SPEC__ASSOCIATIONS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Has State Machine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_SPEC__HAS_STATE_MACHINE = BasePackage.MODEL_ROOT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Cl Class Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_SPEC_FEATURE_COUNT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Cl Class Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_SPEC_OPERATION_COUNT = BasePackage.MODEL_ROOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationSpecImpl <em>Cl Operation Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationSpecImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClOperationSpec()
	 * @generated
	 */
	int CL_OPERATION_SPEC = 3;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION_SPEC__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION_SPEC__RETURN_TYPE = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION_SPEC__PARAMETERS = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cl Operation Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION_SPEC_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cl Operation Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION_SPEC_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationImpl <em>Cl Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClOperation()
	 * @generated
	 */
	int CL_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION__REFERENCE = CL_OPERATION_SPEC__REFERENCE;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION__RETURN_TYPE = CL_OPERATION_SPEC__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION__PARAMETERS = CL_OPERATION_SPEC__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION__METHOD = CL_OPERATION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION__IS_STATIC = CL_OPERATION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cl Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION_FEATURE_COUNT = CL_OPERATION_SPEC_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cl Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION_OPERATION_COUNT = CL_OPERATION_SPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionSpecImpl <em>Cl Reception Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionSpecImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClReceptionSpec()
	 * @generated
	 */
	int CL_RECEPTION_SPEC = 5;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_SPEC__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_SPEC__PARAMETERS = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cl Reception Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_SPEC_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cl Reception Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_SPEC_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionImpl <em>Cl Reception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClReception()
	 * @generated
	 */
	int CL_RECEPTION = 4;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION__REFERENCE = CL_RECEPTION_SPEC__REFERENCE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION__PARAMETERS = CL_RECEPTION_SPEC__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION__SIGNAL = CL_RECEPTION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cl Reception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_FEATURE_COUNT = CL_RECEPTION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cl Reception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_OPERATION_COUNT = CL_RECEPTION_SPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionParameterImpl <em>Cl Reception Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionParameterImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClReceptionParameter()
	 * @generated
	 */
	int CL_RECEPTION_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_PARAMETER__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_PARAMETER__LOWER_BOUND = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_PARAMETER__UPPER_BOUND = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_PARAMETER__IS_ORDERED = BasePackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_PARAMETER__IS_UNIQUE = BasePackage.NAMED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_PARAMETER__TYPE = BasePackage.NAMED_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Cl Reception Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_PARAMETER_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Cl Reception Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_PARAMETER_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAttributeSpecImpl <em>Cl Attribute Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAttributeSpecImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClAttributeSpec()
	 * @generated
	 */
	int CL_ATTRIBUTE_SPEC = 8;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ATTRIBUTE_SPEC__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ATTRIBUTE_SPEC__TYPE = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cl Attribute Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ATTRIBUTE_SPEC_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cl Attribute Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ATTRIBUTE_SPEC_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAttributeImpl <em>Cl Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAttributeImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClAttribute()
	 * @generated
	 */
	int CL_ATTRIBUTE = 7;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ATTRIBUTE__REFERENCE = CL_ATTRIBUTE_SPEC__REFERENCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ATTRIBUTE__TYPE = CL_ATTRIBUTE_SPEC__TYPE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ATTRIBUTE__IS_STATIC = CL_ATTRIBUTE_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cl Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ATTRIBUTE_FEATURE_COUNT = CL_ATTRIBUTE_SPEC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cl Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ATTRIBUTE_OPERATION_COUNT = CL_ATTRIBUTE_SPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClInheritedAttributeImpl <em>Cl Inherited Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClInheritedAttributeImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClInheritedAttribute()
	 * @generated
	 */
	int CL_INHERITED_ATTRIBUTE = 9;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_INHERITED_ATTRIBUTE__REFERENCE = CL_ATTRIBUTE_SPEC__REFERENCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_INHERITED_ATTRIBUTE__TYPE = CL_ATTRIBUTE_SPEC__TYPE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_INHERITED_ATTRIBUTE__PARENT = CL_ATTRIBUTE_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cl Inherited Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_INHERITED_ATTRIBUTE_FEATURE_COUNT = CL_ATTRIBUTE_SPEC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cl Inherited Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_INHERITED_ATTRIBUTE_OPERATION_COUNT = CL_ATTRIBUTE_SPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAssociationImpl <em>Cl Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAssociationImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClAssociation()
	 * @generated
	 */
	int CL_ASSOCIATION = 10;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ASSOCIATION__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ASSOCIATION__TYPE = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cl Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ASSOCIATION_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cl Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_ASSOCIATION_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.InheritedImpl <em>Inherited</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.InheritedImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getInherited()
	 * @generated
	 */
	int INHERITED = 11;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITED__PARENT = 0;

	/**
	 * The number of structural features of the '<em>Inherited</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Inherited</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITED_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass <em>Cl Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Class</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
	 * @generated
	 */
	EClass getClClass();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Region</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getRegion()
	 * @see #getClClass()
	 * @generated
	 */
	EAttribute getClClass_Region();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getInheritedRegion <em>Inherited Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inherited Region</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getInheritedRegion()
	 * @see #getClClass()
	 * @generated
	 */
	EAttribute getClClass_InheritedRegion();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getOperations()
	 * @see #getClClass()
	 * @generated
	 */
	EReference getClClass_Operations();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getReceptions <em>Receptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receptions</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getReceptions()
	 * @see #getClClass()
	 * @generated
	 */
	EReference getClClass_Receptions();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getAttributes()
	 * @see #getClClass()
	 * @generated
	 */
	EReference getClClass_Attributes();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getInheritedAttributes <em>Inherited Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inherited Attributes</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getInheritedAttributes()
	 * @see #getClClass()
	 * @generated
	 */
	EReference getClClass_InheritedAttributes();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associations</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getAssociations()
	 * @see #getClClass()
	 * @generated
	 */
	EReference getClClass_Associations();

	/**
	 * Returns the meta object for the attribute list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parents</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getParents()
	 * @see #getClClass()
	 * @generated
	 */
	EAttribute getClClass_Parents();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec <em>Cl Class Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Class Spec</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec
	 * @generated
	 */
	EClass getClClassSpec();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#getOperations()
	 * @see #getClClassSpec()
	 * @generated
	 */
	EReference getClClassSpec_Operations();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#getReceptions <em>Receptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receptions</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#getReceptions()
	 * @see #getClClassSpec()
	 * @generated
	 */
	EReference getClClassSpec_Receptions();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#getAttributes()
	 * @see #getClClassSpec()
	 * @generated
	 */
	EReference getClClassSpec_Attributes();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associations</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#getAssociations()
	 * @see #getClClassSpec()
	 * @generated
	 */
	EReference getClClassSpec_Associations();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#isHasStateMachine <em>Has State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has State Machine</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec#isHasStateMachine()
	 * @see #getClClassSpec()
	 * @generated
	 */
	EAttribute getClClassSpec_HasStateMachine();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation <em>Cl Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Operation</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation
	 * @generated
	 */
	EClass getClOperation();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation#getMethod()
	 * @see #getClOperation()
	 * @generated
	 */
	EAttribute getClOperation_Method();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation#isIsStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation#isIsStatic()
	 * @see #getClOperation()
	 * @generated
	 */
	EAttribute getClOperation_IsStatic();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec <em>Cl Operation Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Operation Spec</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec
	 * @generated
	 */
	EClass getClOperationSpec();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Return Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec#getReturnType()
	 * @see #getClOperationSpec()
	 * @generated
	 */
	EReference getClOperationSpec_ReturnType();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec#getParameters()
	 * @see #getClOperationSpec()
	 * @generated
	 */
	EReference getClOperationSpec_Parameters();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception <em>Cl Reception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Reception</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception
	 * @generated
	 */
	EClass getClReception();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signal</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception#getSignal()
	 * @see #getClReception()
	 * @generated
	 */
	EAttribute getClReception_Signal();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec <em>Cl Reception Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Reception Spec</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec
	 * @generated
	 */
	EClass getClReceptionSpec();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec#getParameters()
	 * @see #getClReceptionSpec()
	 * @generated
	 */
	EReference getClReceptionSpec_Parameters();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionParameter <em>Cl Reception Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Reception Parameter</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionParameter
	 * @generated
	 */
	EClass getClReceptionParameter();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionParameter#getType()
	 * @see #getClReceptionParameter()
	 * @generated
	 */
	EReference getClReceptionParameter_Type();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute <em>Cl Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Attribute</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute
	 * @generated
	 */
	EClass getClAttribute();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute#isIsStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute#isIsStatic()
	 * @see #getClAttribute()
	 * @generated
	 */
	EAttribute getClAttribute_IsStatic();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec <em>Cl Attribute Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Attribute Spec</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec
	 * @generated
	 */
	EClass getClAttributeSpec();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute <em>Cl Inherited Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Inherited Attribute</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute
	 * @generated
	 */
	EClass getClInheritedAttribute();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation <em>Cl Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Association</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation
	 * @generated
	 */
	EClass getClAssociation();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.Inherited <em>Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inherited</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.Inherited
	 * @generated
	 */
	EClass getInherited();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.Inherited#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.Inherited#getParent()
	 * @see #getInherited()
	 * @generated
	 */
	EAttribute getInherited_Parent();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassdefFactory getClassdefFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl <em>Cl Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClClass()
		 * @generated
		 */
		EClass CL_CLASS = eINSTANCE.getClClass();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CL_CLASS__REGION = eINSTANCE.getClClass_Region();

		/**
		 * The meta object literal for the '<em><b>Inherited Region</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CL_CLASS__INHERITED_REGION = eINSTANCE.getClClass_InheritedRegion();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS__OPERATIONS = eINSTANCE.getClClass_Operations();

		/**
		 * The meta object literal for the '<em><b>Receptions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS__RECEPTIONS = eINSTANCE.getClClass_Receptions();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS__ATTRIBUTES = eINSTANCE.getClClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Inherited Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS__INHERITED_ATTRIBUTES = eINSTANCE.getClClass_InheritedAttributes();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS__ASSOCIATIONS = eINSTANCE.getClClass_Associations();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CL_CLASS__PARENTS = eINSTANCE.getClClass_Parents();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl <em>Cl Class Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassSpecImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClClassSpec()
		 * @generated
		 */
		EClass CL_CLASS_SPEC = eINSTANCE.getClClassSpec();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS_SPEC__OPERATIONS = eINSTANCE.getClClassSpec_Operations();

		/**
		 * The meta object literal for the '<em><b>Receptions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS_SPEC__RECEPTIONS = eINSTANCE.getClClassSpec_Receptions();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS_SPEC__ATTRIBUTES = eINSTANCE.getClClassSpec_Attributes();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS_SPEC__ASSOCIATIONS = eINSTANCE.getClClassSpec_Associations();

		/**
		 * The meta object literal for the '<em><b>Has State Machine</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CL_CLASS_SPEC__HAS_STATE_MACHINE = eINSTANCE.getClClassSpec_HasStateMachine();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationImpl <em>Cl Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClOperation()
		 * @generated
		 */
		EClass CL_OPERATION = eINSTANCE.getClOperation();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CL_OPERATION__METHOD = eINSTANCE.getClOperation_Method();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CL_OPERATION__IS_STATIC = eINSTANCE.getClOperation_IsStatic();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationSpecImpl <em>Cl Operation Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationSpecImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClOperationSpec()
		 * @generated
		 */
		EClass CL_OPERATION_SPEC = eINSTANCE.getClOperationSpec();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_OPERATION_SPEC__RETURN_TYPE = eINSTANCE.getClOperationSpec_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_OPERATION_SPEC__PARAMETERS = eINSTANCE.getClOperationSpec_Parameters();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionImpl <em>Cl Reception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClReception()
		 * @generated
		 */
		EClass CL_RECEPTION = eINSTANCE.getClReception();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CL_RECEPTION__SIGNAL = eINSTANCE.getClReception_Signal();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionSpecImpl <em>Cl Reception Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionSpecImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClReceptionSpec()
		 * @generated
		 */
		EClass CL_RECEPTION_SPEC = eINSTANCE.getClReceptionSpec();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_RECEPTION_SPEC__PARAMETERS = eINSTANCE.getClReceptionSpec_Parameters();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionParameterImpl <em>Cl Reception Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionParameterImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClReceptionParameter()
		 * @generated
		 */
		EClass CL_RECEPTION_PARAMETER = eINSTANCE.getClReceptionParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_RECEPTION_PARAMETER__TYPE = eINSTANCE.getClReceptionParameter_Type();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAttributeImpl <em>Cl Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAttributeImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClAttribute()
		 * @generated
		 */
		EClass CL_ATTRIBUTE = eINSTANCE.getClAttribute();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CL_ATTRIBUTE__IS_STATIC = eINSTANCE.getClAttribute_IsStatic();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAttributeSpecImpl <em>Cl Attribute Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAttributeSpecImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClAttributeSpec()
		 * @generated
		 */
		EClass CL_ATTRIBUTE_SPEC = eINSTANCE.getClAttributeSpec();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClInheritedAttributeImpl <em>Cl Inherited Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClInheritedAttributeImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClInheritedAttribute()
		 * @generated
		 */
		EClass CL_INHERITED_ATTRIBUTE = eINSTANCE.getClInheritedAttribute();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAssociationImpl <em>Cl Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClAssociationImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClAssociation()
		 * @generated
		 */
		EClass CL_ASSOCIATION = eINSTANCE.getClAssociation();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.InheritedImpl <em>Inherited</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.InheritedImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getInherited()
		 * @generated
		 */
		EClass INHERITED = eINSTANCE.getInherited();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INHERITED__PARENT = eINSTANCE.getInherited_Parent();

	}

} //ClassdefPackage
