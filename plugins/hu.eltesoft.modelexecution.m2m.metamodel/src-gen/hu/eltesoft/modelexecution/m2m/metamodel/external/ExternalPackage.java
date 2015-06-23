/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.external;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalFactory
 * @model kind="package"
 * @generated
 */
public interface ExternalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "external";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/external";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.external";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExternalPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExternalPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExExternalEntityImpl <em>Ex External Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExExternalEntityImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExternalPackageImpl#getExExternalEntity()
	 * @generated
	 */
	int EX_EXTERNAL_ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_EXTERNAL_ENTITY__REFERENCE = BasePackage.MODEL_ROOT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_EXTERNAL_ENTITY__OPERATIONS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_EXTERNAL_ENTITY__IMPLEMENTATION_CLASS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_EXTERNAL_ENTITY__TYPE = BasePackage.MODEL_ROOT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Ex External Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_EXTERNAL_ENTITY_FEATURE_COUNT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Ex External Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_EXTERNAL_ENTITY_OPERATION_COUNT = BasePackage.MODEL_ROOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExOperationImpl <em>Ex Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExOperationImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExternalPackageImpl#getExOperation()
	 * @generated
	 */
	int EX_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_OPERATION__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Proxy Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_OPERATION__PROXY_CLASS = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ex Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_OPERATION_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ex Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_OPERATION_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType <em>Ex Entity Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExternalPackageImpl#getExEntityType()
	 * @generated
	 */
	int EX_ENTITY_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity <em>Ex External Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ex External Entity</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity
	 * @generated
	 */
	EClass getExExternalEntity();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getOperations()
	 * @see #getExExternalEntity()
	 * @generated
	 */
	EReference getExExternalEntity_Operations();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getImplementationClass <em>Implementation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Class</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getImplementationClass()
	 * @see #getExExternalEntity()
	 * @generated
	 */
	EAttribute getExExternalEntity_ImplementationClass();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getType()
	 * @see #getExExternalEntity()
	 * @generated
	 */
	EAttribute getExExternalEntity_Type();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation <em>Ex Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ex Operation</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation
	 * @generated
	 */
	EClass getExOperation();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation#getProxyClass <em>Proxy Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy Class</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation#getProxyClass()
	 * @see #getExOperation()
	 * @generated
	 */
	EAttribute getExOperation_ProxyClass();

	/**
	 * Returns the meta object for enum '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType <em>Ex Entity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ex Entity Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType
	 * @generated
	 */
	EEnum getExEntityType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExternalFactory getExternalFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExExternalEntityImpl <em>Ex External Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExExternalEntityImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExternalPackageImpl#getExExternalEntity()
		 * @generated
		 */
		EClass EX_EXTERNAL_ENTITY = eINSTANCE.getExExternalEntity();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EX_EXTERNAL_ENTITY__OPERATIONS = eINSTANCE.getExExternalEntity_Operations();

		/**
		 * The meta object literal for the '<em><b>Implementation Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EX_EXTERNAL_ENTITY__IMPLEMENTATION_CLASS = eINSTANCE.getExExternalEntity_ImplementationClass();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EX_EXTERNAL_ENTITY__TYPE = eINSTANCE.getExExternalEntity_Type();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExOperationImpl <em>Ex Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExOperationImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExternalPackageImpl#getExOperation()
		 * @generated
		 */
		EClass EX_OPERATION = eINSTANCE.getExOperation();

		/**
		 * The meta object literal for the '<em><b>Proxy Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EX_OPERATION__PROXY_CLASS = eINSTANCE.getExOperation_ProxyClass();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType <em>Ex Entity Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExternalPackageImpl#getExEntityType()
		 * @generated
		 */
		EEnum EX_ENTITY_TYPE = eINSTANCE.getExEntityType();

	}

} //ExternalPackage
