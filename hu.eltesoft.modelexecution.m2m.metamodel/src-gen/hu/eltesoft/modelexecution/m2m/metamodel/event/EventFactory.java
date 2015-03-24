/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.event;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EventPackage
 * @generated
 */
public interface EventFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventFactory eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ev Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ev Event</em>'.
	 * @generated
	 */
	EvEvent createEvEvent();

	/**
	 * Returns a new object of class '<em>Ev Signal Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ev Signal Event</em>'.
	 * @generated
	 */
	EvSignalEvent createEvSignalEvent();

	/**
	 * Returns a new object of class '<em>Ev Signal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ev Signal</em>'.
	 * @generated
	 */
	EvSignal createEvSignal();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EventPackage getEventPackage();

} //EventFactory
