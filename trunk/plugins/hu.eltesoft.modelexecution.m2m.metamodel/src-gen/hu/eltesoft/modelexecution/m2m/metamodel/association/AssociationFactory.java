/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.association;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage
 * @generated
 */
public interface AssociationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AssociationFactory eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>As Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As Association</em>'.
	 * @generated
	 */
	AsAssociation createAsAssociation();

	/**
	 * Returns a new object of class '<em>As Association End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As Association End</em>'.
	 * @generated
	 */
	AsAssociationEnd createAsAssociationEnd();

	/**
	 * Returns a new object of class '<em>As Association Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As Association Class</em>'.
	 * @generated
	 */
	AsAssociationClass createAsAssociationClass();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AssociationPackage getAssociationPackage();

} //AssociationFactory
