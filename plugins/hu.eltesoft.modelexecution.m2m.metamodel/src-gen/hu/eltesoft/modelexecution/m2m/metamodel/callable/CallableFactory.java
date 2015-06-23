/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.callable;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.CallablePackage
 * @generated
 */
public interface CallableFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CallableFactory eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CallableFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ca Callable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ca Callable</em>'.
	 * @generated
	 */
	CaCallable createCaCallable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CallablePackage getCallablePackage();

} //CallableFactory
