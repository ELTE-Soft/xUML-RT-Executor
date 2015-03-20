/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

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
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject <em>Translation Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject
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
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot <em>Model Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getModelRoot()
	 * @generated
	 */
	int MODEL_ROOT = 1;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Named <em>Named</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Named
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getNamed()
	 * @generated
	 */
	int NAMED = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED__NAME = TRANSLATION_OBJECT_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ROOT__NAME = NAMED__NAME;

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
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced <em>Referenced</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced
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
	 * The meta object id for the '<em>Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2t.smap.emf.Reference
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 4;


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
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Named#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Named#getName()
	 * @see #getNamed()
	 * @generated
	 */
	EAttribute getNamed_Name();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject <em>Translation Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject
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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Named <em>Named</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Named
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl#getNamed()
		 * @generated
		 */
		EClass NAMED = eINSTANCE.getNamed();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced <em>Referenced</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced
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
