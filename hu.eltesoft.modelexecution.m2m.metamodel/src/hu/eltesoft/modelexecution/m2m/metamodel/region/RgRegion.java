/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rg Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getContainingClass <em>Containing Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getInitialTransition <em>Initial Transition</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgRegion()
 * @model
 * @generated
 */
public interface RgRegion extends ModelRoot, Named {
	/**
	 * Returns the value of the '<em><b>Containing Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Class</em>' reference.
	 * @see #setContainingClass(RgClass)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgRegion_ContainingClass()
	 * @model required="true"
	 * @generated
	 */
	RgClass getContainingClass();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getContainingClass <em>Containing Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Class</em>' reference.
	 * @see #getContainingClass()
	 * @generated
	 */
	void setContainingClass(RgClass value);

	/**
	 * Returns the value of the '<em><b>Initial Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Transition</em>' reference.
	 * @see #setInitialTransition(RgTransition)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgRegion_InitialTransition()
	 * @model
	 * @generated
	 */
	RgTransition getInitialTransition();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getInitialTransition <em>Initial Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Transition</em>' reference.
	 * @see #getInitialTransition()
	 * @generated
	 */
	void setInitialTransition(RgTransition value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgRegion_States()
	 * @model required="true"
	 * @generated
	 */
	EList<RgState> getStates();

} // RgRegion
