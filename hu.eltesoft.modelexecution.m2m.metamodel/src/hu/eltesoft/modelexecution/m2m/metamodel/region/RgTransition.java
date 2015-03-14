/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rg Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getEvent <em>Event</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getEffect <em>Effect</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgTransition()
 * @model
 * @generated
 */
public interface RgTransition extends Referenced {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(RgEvent)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgTransition_Event()
	 * @model required="true"
	 * @generated
	 */
	RgEvent getEvent();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(RgEvent value);

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effect</em>' reference.
	 * @see #setEffect(RgBehavior)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgTransition_Effect()
	 * @model
	 * @generated
	 */
	RgBehavior getEffect();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getEffect <em>Effect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect</em>' reference.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(RgBehavior value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(RgState)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgTransition_Target()
	 * @model required="true"
	 * @generated
	 */
	RgState getTarget();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(RgState value);

} // RgTransition
