/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rg Initial Pseudostate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate#getInitialTransition <em>Initial Transition</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgInitialPseudostate()
 * @model
 * @generated
 */
public interface RgInitialPseudostate extends Named {
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
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgInitialPseudostate_InitialTransition()
	 * @model required="true"
	 * @generated
	 */
	RgTransition getInitialTransition();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate#getInitialTransition <em>Initial Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Transition</em>' reference.
	 * @see #getInitialTransition()
	 * @generated
	 */
	void setInitialTransition(RgTransition value);

} // RgInitialPseudostate
