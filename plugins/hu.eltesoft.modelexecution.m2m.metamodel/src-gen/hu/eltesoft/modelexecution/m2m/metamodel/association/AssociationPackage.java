/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.association;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationFactory
 * @model kind="package"
 * @generated
 */
public interface AssociationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "association";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/association";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.association";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AssociationPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationImpl <em>As Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationPackageImpl#getAsAssociation()
	 * @generated
	 */
	int AS_ASSOCIATION = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION__REFERENCE = BasePackage.MODEL_ROOT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Ends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION__ENDS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>As Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_FEATURE_COUNT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>As Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_OPERATION_COUNT = BasePackage.MODEL_ROOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationEndImpl <em>As Association End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationEndImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationPackageImpl#getAsAssociationEnd()
	 * @generated
	 */
	int AS_ASSOCIATION_END = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_END__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_END__TYPE = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>As Association End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_END_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>As Association End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_END_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl <em>As Association Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationPackageImpl#getAsAssociationClass()
	 * @generated
	 */
	int AS_ASSOCIATION_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__REFERENCE = AS_ASSOCIATION__REFERENCE;

	/**
	 * The feature id for the '<em><b>Ends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__ENDS = AS_ASSOCIATION__ENDS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__REGION = AS_ASSOCIATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__DESTRUCTOR = AS_ASSOCIATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__OPERATIONS = AS_ASSOCIATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Receptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__RECEPTIONS = AS_ASSOCIATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__ATTRIBUTES = AS_ASSOCIATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Inherited Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__INHERITED_ATTRIBUTES = AS_ASSOCIATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__ASSOCIATIONS = AS_ASSOCIATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__PARENTS = AS_ASSOCIATION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Inherited Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__INHERITED_ASSOCIATIONS = AS_ASSOCIATION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Has Receptions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__HAS_RECEPTIONS = AS_ASSOCIATION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__IS_ABSTRACT = AS_ASSOCIATION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS__IS_ACTIVE = AS_ASSOCIATION_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>As Association Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS_FEATURE_COUNT = AS_ASSOCIATION_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>As Association Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_ASSOCIATION_CLASS_OPERATION_COUNT = AS_ASSOCIATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation <em>As Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>As Association</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation
	 * @generated
	 */
	EClass getAsAssociation();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation#getEnds <em>Ends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ends</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation#getEnds()
	 * @see #getAsAssociation()
	 * @generated
	 */
	EReference getAsAssociation_Ends();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationEnd <em>As Association End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>As Association End</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationEnd
	 * @generated
	 */
	EClass getAsAssociationEnd();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationEnd#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationEnd#getType()
	 * @see #getAsAssociationEnd()
	 * @generated
	 */
	EReference getAsAssociationEnd_Type();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationClass <em>As Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>As Association Class</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationClass
	 * @generated
	 */
	EClass getAsAssociationClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AssociationFactory getAssociationFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationImpl <em>As Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationPackageImpl#getAsAssociation()
		 * @generated
		 */
		EClass AS_ASSOCIATION = eINSTANCE.getAsAssociation();

		/**
		 * The meta object literal for the '<em><b>Ends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AS_ASSOCIATION__ENDS = eINSTANCE.getAsAssociation_Ends();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationEndImpl <em>As Association End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationEndImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationPackageImpl#getAsAssociationEnd()
		 * @generated
		 */
		EClass AS_ASSOCIATION_END = eINSTANCE.getAsAssociationEnd();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AS_ASSOCIATION_END__TYPE = eINSTANCE.getAsAssociationEnd_Type();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl <em>As Association Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AsAssociationClassImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationPackageImpl#getAsAssociationClass()
		 * @generated
		 */
		EClass AS_ASSOCIATION_CLASS = eINSTANCE.getAsAssociationClass();

	}

} //AssociationPackage
