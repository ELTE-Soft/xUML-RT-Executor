/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior;

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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory
 * @model kind="package"
 * @generated
 */
public interface BehaviorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "behavior";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/behavior";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.behavior";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BehaviorPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl <em>Bh Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl#getBhBehavior()
	 * @generated
	 */
	int BH_BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR__NAME = BasePackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR__ID = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alf Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR__ALF_CODE = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bh Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bh Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior <em>Bh Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bh Behavior</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior
	 * @generated
	 */
	EClass getBhBehavior();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getAlfCode <em>Alf Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alf Code</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getAlfCode()
	 * @see #getBhBehavior()
	 * @generated
	 */
	EAttribute getBhBehavior_AlfCode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BehaviorFactory getBehaviorFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl <em>Bh Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl#getBhBehavior()
		 * @generated
		 */
		EClass BH_BEHAVIOR = eINSTANCE.getBhBehavior();

		/**
		 * The meta object literal for the '<em><b>Alf Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BH_BEHAVIOR__ALF_CODE = eINSTANCE.getBhBehavior_AlfCode();

	}

} //BehaviorPackage
