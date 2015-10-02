/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage
 * @generated
 */
public interface RegionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RegionFactory eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Rg Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rg Region</em>'.
	 * @generated
	 */
	RgRegion createRgRegion();

	/**
	 * Returns a new object of class '<em>Rg Initial Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rg Initial Pseudostate</em>'.
	 * @generated
	 */
	RgInitialPseudostate createRgInitialPseudostate();

	/**
	 * Returns a new object of class '<em>Rg State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rg State</em>'.
	 * @generated
	 */
	RgState createRgState();

	/**
	 * Returns a new object of class '<em>Rg Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rg Transition</em>'.
	 * @generated
	 */
	RgTransition createRgTransition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RegionPackage getRegionPackage();

} //RegionFactory
