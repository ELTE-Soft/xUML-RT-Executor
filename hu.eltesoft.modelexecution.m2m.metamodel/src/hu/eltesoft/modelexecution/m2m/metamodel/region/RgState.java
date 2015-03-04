/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Identified;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rg State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getEntry <em>Entry</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getExit <em>Exit</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgState()
 * @model
 * @generated
 */
public interface RgState extends Named, Identified {
	/**
	 * Returns the value of the '<em><b>Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' reference.
	 * @see #setEntry(RgBehavior)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgState_Entry()
	 * @model
	 * @generated
	 */
	RgBehavior getEntry();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getEntry <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry</em>' reference.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(RgBehavior value);

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit</em>' reference.
	 * @see #setExit(RgBehavior)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgState_Exit()
	 * @model
	 * @generated
	 */
	RgBehavior getExit();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getExit <em>Exit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit</em>' reference.
	 * @see #getExit()
	 * @generated
	 */
	void setExit(RgBehavior value);

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgState_Transitions()
	 * @model required="true"
	 * @generated
	 */
	EList<RgTransition> getTransitions();

} // RgState
