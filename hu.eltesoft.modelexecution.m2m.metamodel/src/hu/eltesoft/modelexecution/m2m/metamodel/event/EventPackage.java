/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.event;

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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EventFactory
 * @model kind="package"
 * @generated
 */
public interface EventPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "event";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/event";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.event";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvEventImpl <em>Ev Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvEventImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl#getEvEvent()
	 * @generated
	 */
	int EV_EVENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_EVENT__NAME = BasePackage.MODEL_ROOT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ev Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_EVENT_FEATURE_COUNT = BasePackage.MODEL_ROOT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ev Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_EVENT_OPERATION_COUNT = BasePackage.MODEL_ROOT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvSignalEventImpl <em>Ev Signal Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvSignalEventImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl#getEvSignalEvent()
	 * @generated
	 */
	int EV_SIGNAL_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_SIGNAL_EVENT__NAME = EV_EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_SIGNAL_EVENT__SIGNAL = EV_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ev Signal Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_SIGNAL_EVENT_FEATURE_COUNT = EV_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ev Signal Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_SIGNAL_EVENT_OPERATION_COUNT = EV_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvSignalImpl <em>Ev Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvSignalImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl#getEvSignal()
	 * @generated
	 */
	int EV_SIGNAL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_SIGNAL__NAME = BasePackage.NAMED__NAME;

	/**
	 * The number of structural features of the '<em>Ev Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_SIGNAL_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ev Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EV_SIGNAL_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.EvEvent <em>Ev Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ev Event</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EvEvent
	 * @generated
	 */
	EClass getEvEvent();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent <em>Ev Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ev Signal Event</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent
	 * @generated
	 */
	EClass getEvSignalEvent();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent#getSignal()
	 * @see #getEvSignalEvent()
	 * @generated
	 */
	EReference getEvSignalEvent_Signal();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignal <em>Ev Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ev Signal</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignal
	 * @generated
	 */
	EClass getEvSignal();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventFactory getEventFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvEventImpl <em>Ev Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvEventImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl#getEvEvent()
		 * @generated
		 */
		EClass EV_EVENT = eINSTANCE.getEvEvent();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvSignalEventImpl <em>Ev Signal Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvSignalEventImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl#getEvSignalEvent()
		 * @generated
		 */
		EClass EV_SIGNAL_EVENT = eINSTANCE.getEvSignalEvent();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EV_SIGNAL_EVENT__SIGNAL = eINSTANCE.getEvSignalEvent_Signal();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvSignalImpl <em>Ev Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EvSignalImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl#getEvSignal()
		 * @generated
		 */
		EClass EV_SIGNAL = eINSTANCE.getEvSignal();

	}

} //EventPackage
