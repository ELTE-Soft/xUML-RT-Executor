/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
 * @generated
 */
public interface ClassdefFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassdefFactory eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Cl Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Class</em>'.
	 * @generated
	 */
	ClClass createClClass();

	/**
	 * Returns a new object of class '<em>Cl Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Region</em>'.
	 * @generated
	 */
	ClRegion createClRegion();

	/**
	 * Returns a new object of class '<em>Cl Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Operation</em>'.
	 * @generated
	 */
	ClOperation createClOperation();

	/**
	 * Returns a new object of class '<em>Cl Reception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Reception</em>'.
	 * @generated
	 */
	ClReception createClReception();

	/**
	 * Returns a new object of class '<em>Cl Signal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Signal</em>'.
	 * @generated
	 */
	ClSignal createClSignal();

	/**
	 * Returns a new object of class '<em>Cl Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Method</em>'.
	 * @generated
	 */
	ClMethod createClMethod();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ClassdefPackage getClassdefPackage();

} //ClassdefFactory
