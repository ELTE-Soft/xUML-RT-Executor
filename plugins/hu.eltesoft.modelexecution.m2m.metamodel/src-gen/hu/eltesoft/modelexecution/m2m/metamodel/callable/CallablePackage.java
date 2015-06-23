/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.callable;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.CallableFactory
 * @model kind="package"
 * @generated
 */
public interface CallablePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "callable";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/callable";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.callable";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CallablePackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CallablePackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CaCallableImpl <em>Ca Callable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CaCallableImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CallablePackageImpl#getCaCallable()
	 * @generated
	 */
	int CA_CALLABLE = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CA_CALLABLE__REFERENCE = BasePackage.MODEL_ROOT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Receptions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CA_CALLABLE__RECEPTIONS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ca Callable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CA_CALLABLE_FEATURE_COUNT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ca Callable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CA_CALLABLE_OPERATION_COUNT = BasePackage.MODEL_ROOT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.callable.CaCallable <em>Ca Callable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ca Callable</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.CaCallable
	 * @generated
	 */
	EClass getCaCallable();

	/**
	 * Returns the meta object for the attribute list '{@link hu.eltesoft.modelexecution.m2m.metamodel.callable.CaCallable#getReceptions <em>Receptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Receptions</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.CaCallable#getReceptions()
	 * @see #getCaCallable()
	 * @generated
	 */
	EAttribute getCaCallable_Receptions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CallableFactory getCallableFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CaCallableImpl <em>Ca Callable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CaCallableImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CallablePackageImpl#getCaCallable()
		 * @generated
		 */
		EClass CA_CALLABLE = eINSTANCE.getCaCallable();

		/**
		 * The meta object literal for the '<em><b>Receptions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CA_CALLABLE__RECEPTIONS = eINSTANCE.getCaCallable_Receptions();

	}

} //CallablePackage
