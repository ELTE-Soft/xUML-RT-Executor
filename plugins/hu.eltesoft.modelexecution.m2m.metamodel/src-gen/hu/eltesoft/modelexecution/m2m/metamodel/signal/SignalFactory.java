/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.signal;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage
 * @generated
 */
public interface SignalFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SignalFactory eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sg Signal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sg Signal</em>'.
	 * @generated
	 */
	SgSignal createSgSignal();

	/**
	 * Returns a new object of class '<em>Sg Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sg Attribute</em>'.
	 * @generated
	 */
	SgAttribute createSgAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SignalPackage getSignalPackage();

} //SignalFactory
