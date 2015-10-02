/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory
 * @model kind="package"
 * @generated
 */
public interface BasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "base";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/base";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.base";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasePackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl <em>Translation Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getTranslationObject()
	 * @generated
	 */
	int TRANSLATION_OBJECT = 0;

	/**
	 * The number of structural features of the '<em>Translation Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATION_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Translation Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATION_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.NamedImpl <em>Named</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.NamedImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getNamed()
	 * @generated
	 */
	int NAMED = 2;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED__REFERENCE = TRANSLATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FEATURE_COUNT = TRANSLATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OPERATION_COUNT = TRANSLATION_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot <em>Model Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getModelRoot()
	 * @generated
	 */
	int MODEL_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ROOT__REFERENCE = NAMED__REFERENCE;

	/**
	 * The number of structural features of the '<em>Model Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ROOT_FEATURE_COUNT = NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Model Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ROOT_OPERATION_COUNT = NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ReferencedImpl <em>Referenced</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ReferencedImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getReferenced()
	 * @generated
	 */
	int REFERENCED = 3;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED__REFERENCE = TRANSLATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Referenced</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_FEATURE_COUNT = TRANSLATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Referenced</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_OPERATION_COUNT = TRANSLATION_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TypedImpl <em>Typed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TypedImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getTyped()
	 * @generated
	 */
	int TYPED = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED__TYPE = TRANSLATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_FEATURE_COUNT = TRANSLATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Typed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OPERATION_COUNT = TRANSLATION_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TypeImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getType()
	 * @generated
	 */
	int TYPE = 5;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__LOWER_BOUND = TRANSLATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__UPPER_BOUND = TRANSLATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__IS_ORDERED = TRANSLATION_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__IS_UNIQUE = TRANSLATION_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__BASE_TYPE = TRANSLATION_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = TRANSLATION_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = TRANSLATION_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ScalarTypeImpl <em>Scalar Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ScalarTypeImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getScalarType()
	 * @generated
	 */
	int SCALAR_TYPE = 6;

	/**
	 * The number of structural features of the '<em>Scalar Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Scalar Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.PrimitiveTypeImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TYPE = SCALAR_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = SCALAR_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = SCALAR_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ReferencedTypeImpl <em>Referenced Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ReferencedTypeImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getReferencedType()
	 * @generated
	 */
	int REFERENCED_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_TYPE__REFERENCE = SCALAR_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Referenced Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_TYPE_FEATURE_COUNT = SCALAR_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Referenced Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_TYPE_OPERATION_COUNT = SCALAR_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ParameterImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 9;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__REFERENCE = NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DIRECTION = NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.MultiplicityImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getMultiplicity()
	 * @generated
	 */
	int MULTIPLICITY = 10;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY__LOWER_BOUND = 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY__UPPER_BOUND = 1;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY__IS_ORDERED = 2;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY__IS_UNIQUE = 3;

	/**
	 * The number of structural features of the '<em>Multiplicity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Multiplicity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.InheritedImpl <em>Inherited</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.InheritedImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getInherited()
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
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Direction <em>Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Direction
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getDirection()
	 * @generated
	 */
	int DIRECTION = 12;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes <em>Primitive Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getPrimitiveTypes()
	 * @generated
	 */
	int PRIMITIVE_TYPES = 13;

	/**
	 * The meta object id for the '<em>Named Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getNamedReference()
	 * @generated
	 */
	int NAMED_REFERENCE = 14;

	/**
	 * The meta object id for the '<em>Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2t.smap.emf.Reference
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 15;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject <em>Translation Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Translation Object</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject
	 * @generated
	 */
	EClass getTranslationObject();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot <em>Model Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Root</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot
	 * @generated
	 */
	EClass getModelRoot();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Named
	 * @generated
	 */
	EClass getNamed();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Named#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Named#getReference()
	 * @see #getNamed()
	 * @generated
	 */
	EAttribute getNamed_Reference();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced <em>Referenced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referenced</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced
	 * @generated
	 */
	EClass getReferenced();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced#getReference()
	 * @see #getReferenced()
	 * @generated
	 */
	EAttribute getReferenced_Reference();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Typed <em>Typed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Typed
	 * @generated
	 */
	EClass getTyped();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Typed#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Typed#getType()
	 * @see #getTyped()
	 * @generated
	 */
	EReference getTyped_Type();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Type#getBaseType <em>Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Type#getBaseType()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_BaseType();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.ScalarType <em>Scalar Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.ScalarType
	 * @generated
	 */
	EClass getScalarType();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType#getType()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Type();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.ReferencedType <em>Referenced Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referenced Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.ReferencedType
	 * @generated
	 */
	EClass getReferencedType();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Parameter#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Parameter#getDirection()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Direction();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
	 * @generated
	 */
	EClass getMultiplicity();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity#getLowerBound()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity#getUpperBound()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_UpperBound();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity#isIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity#isIsOrdered()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_IsOrdered();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity#isIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity#isIsUnique()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_IsUnique();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Inherited <em>Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inherited</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Inherited
	 * @generated
	 */
	EClass getInherited();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Inherited#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Inherited#getParent()
	 * @see #getInherited()
	 * @generated
	 */
	EAttribute getInherited_Parent();

	/**
	 * Returns the meta object for enum '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Direction <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Direction
	 * @generated
	 */
	EEnum getDirection();

	/**
	 * Returns the meta object for enum '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes <em>Primitive Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Types</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes
	 * @generated
	 */
	EEnum getPrimitiveTypes();

	/**
	 * Returns the meta object for data type '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference <em>Named Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Named Reference</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
	 * @model instanceClass="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference"
	 * @generated
	 */
	EDataType getNamedReference();

	/**
	 * Returns the meta object for data type '{@link hu.eltesoft.modelexecution.m2t.smap.emf.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Reference</em>'.
	 * @see hu.eltesoft.modelexecution.m2t.smap.emf.Reference
	 * @model instanceClass="hu.eltesoft.modelexecution.m2t.smap.emf.Reference"
	 * @generated
	 */
	EDataType getReference();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaseFactory getBaseFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl <em>Translation Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getTranslationObject()
		 * @generated
		 */
		EClass TRANSLATION_OBJECT = eINSTANCE.getTranslationObject();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot <em>Model Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getModelRoot()
		 * @generated
		 */
		EClass MODEL_ROOT = eINSTANCE.getModelRoot();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.NamedImpl <em>Named</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.NamedImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getNamed()
		 * @generated
		 */
		EClass NAMED = eINSTANCE.getNamed();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED__REFERENCE = eINSTANCE.getNamed_Reference();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ReferencedImpl <em>Referenced</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ReferencedImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getReferenced()
		 * @generated
		 */
		EClass REFERENCED = eINSTANCE.getReferenced();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCED__REFERENCE = eINSTANCE.getReferenced_Reference();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TypedImpl <em>Typed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TypedImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getTyped()
		 * @generated
		 */
		EClass TYPED = eINSTANCE.getTyped();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED__TYPE = eINSTANCE.getTyped_Type();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TypeImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Base Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__BASE_TYPE = eINSTANCE.getType_BaseType();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ScalarTypeImpl <em>Scalar Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ScalarTypeImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getScalarType()
		 * @generated
		 */
		EClass SCALAR_TYPE = eINSTANCE.getScalarType();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.PrimitiveTypeImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__TYPE = eINSTANCE.getPrimitiveType_Type();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ReferencedTypeImpl <em>Referenced Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ReferencedTypeImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getReferencedType()
		 * @generated
		 */
		EClass REFERENCED_TYPE = eINSTANCE.getReferencedType();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.ParameterImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DIRECTION = eINSTANCE.getParameter_Direction();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.MultiplicityImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getMultiplicity()
		 * @generated
		 */
		EClass MULTIPLICITY = eINSTANCE.getMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY__LOWER_BOUND = eINSTANCE.getMultiplicity_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY__UPPER_BOUND = eINSTANCE.getMultiplicity_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY__IS_ORDERED = eINSTANCE.getMultiplicity_IsOrdered();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY__IS_UNIQUE = eINSTANCE.getMultiplicity_IsUnique();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.impl.InheritedImpl <em>Inherited</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.InheritedImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getInherited()
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

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Direction <em>Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Direction
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getDirection()
		 * @generated
		 */
		EEnum DIRECTION = eINSTANCE.getDirection();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes <em>Primitive Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getPrimitiveTypes()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPES = eINSTANCE.getPrimitiveTypes();

		/**
		 * The meta object literal for the '<em>Named Reference</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getNamedReference()
		 * @generated
		 */
		EDataType NAMED_REFERENCE = eINSTANCE.getNamedReference();

		/**
		 * The meta object literal for the '<em>Reference</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2t.smap.emf.Reference
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getReference()
		 * @generated
		 */
		EDataType REFERENCE = eINSTANCE.getReference();

	}

} //BasePackage
