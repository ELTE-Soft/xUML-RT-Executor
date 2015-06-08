/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage
 * @generated
 */
public interface BehaviorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BehaviorFactory eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bh Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bh Behavior</em>'.
	 * @generated
	 */
	BhBehavior createBhBehavior();

	/**
	 * Returns a new object of class '<em>Bh Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bh Parameter</em>'.
	 * @generated
	 */
	BhParameter createBhParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BehaviorPackage getBehaviorPackage();

} //BehaviorFactory
