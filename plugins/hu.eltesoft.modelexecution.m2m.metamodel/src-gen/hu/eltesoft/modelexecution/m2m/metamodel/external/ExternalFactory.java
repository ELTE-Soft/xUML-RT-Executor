/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.external;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage
 * @generated
 */
public interface ExternalFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExternalFactory eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.external.impl.ExternalFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ex External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ex External Entity</em>'.
	 * @generated
	 */
	ExExternalEntity createExExternalEntity();

	/**
	 * Returns a new object of class '<em>Ex Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ex Operation</em>'.
	 * @generated
	 */
	ExOperation createExOperation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExternalPackage getExternalPackage();

} //ExternalFactory
