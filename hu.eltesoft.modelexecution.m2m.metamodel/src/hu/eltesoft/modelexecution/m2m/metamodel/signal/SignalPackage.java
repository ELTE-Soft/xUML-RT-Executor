/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.signal;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory
 * @model kind="package"
 * @generated
 */
public interface SignalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "signal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/signal";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.signal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SignalPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgSignalImpl <em>Sg Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgSignalImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl#getSgSignal()
	 * @generated
	 */
	int SG_SIGNAL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_SIGNAL__NAME = BasePackage.MODEL_ROOT__NAME;

	/**
	 * The number of structural features of the '<em>Sg Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_SIGNAL_FEATURE_COUNT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sg Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_SIGNAL_OPERATION_COUNT = BasePackage.MODEL_ROOT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal <em>Sg Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sg Signal</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
	 * @generated
	 */
	EClass getSgSignal();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SignalFactory getSignalFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgSignalImpl <em>Sg Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgSignalImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl#getSgSignal()
		 * @generated
		 */
		EClass SG_SIGNAL = eINSTANCE.getSgSignal();

	}

} //SignalPackage
