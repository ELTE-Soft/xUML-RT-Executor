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
	 * Returns a new object of class '<em>Cl Class Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Class Spec</em>'.
	 * @generated
	 */
	ClClassSpec createClClassSpec();

	/**
	 * Returns a new object of class '<em>Cl Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Operation</em>'.
	 * @generated
	 */
	ClOperation createClOperation();

	/**
	 * Returns a new object of class '<em>Cl Operation Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Operation Spec</em>'.
	 * @generated
	 */
	ClOperationSpec createClOperationSpec();

	/**
	 * Returns a new object of class '<em>Cl Reception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Reception</em>'.
	 * @generated
	 */
	ClReception createClReception();

	/**
	 * Returns a new object of class '<em>Cl Reception Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Reception Spec</em>'.
	 * @generated
	 */
	ClReceptionSpec createClReceptionSpec();

	/**
	 * Returns a new object of class '<em>Cl Reception Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Reception Parameter</em>'.
	 * @generated
	 */
	ClReceptionParameter createClReceptionParameter();

	/**
	 * Returns a new object of class '<em>Cl Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Attribute</em>'.
	 * @generated
	 */
	ClAttribute createClAttribute();

	/**
	 * Returns a new object of class '<em>Cl Attribute Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Attribute Spec</em>'.
	 * @generated
	 */
	ClAttributeSpec createClAttributeSpec();

	/**
	 * Returns a new object of class '<em>Cl Inherited Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Inherited Attribute</em>'.
	 * @generated
	 */
	ClInheritedAttribute createClInheritedAttribute();

	/**
	 * Returns a new object of class '<em>Cl Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Association</em>'.
	 * @generated
	 */
	ClAssociation createClAssociation();

	/**
	 * Returns a new object of class '<em>Cl Inherited Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Inherited Association</em>'.
	 * @generated
	 */
	ClInheritedAssociation createClInheritedAssociation();

	/**
	 * Returns a new object of class '<em>Cl Ctor Record</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cl Ctor Record</em>'.
	 * @generated
	 */
	ClCtorRecord createClCtorRecord();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ClassdefPackage getClassdefPackage();

} //ClassdefFactory
