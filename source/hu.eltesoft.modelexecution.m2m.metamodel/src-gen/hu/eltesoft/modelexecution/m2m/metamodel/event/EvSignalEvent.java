/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.event;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ev Signal Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EventPackage#getEvSignalEvent()
 * @model
 * @generated
 */
public interface EvSignalEvent extends EvEvent {
	/**
	 * Returns the value of the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal</em>' reference.
	 * @see #setSignal(EvSignal)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EventPackage#getEvSignalEvent_Signal()
	 * @model required="true"
	 * @generated
	 */
	EvSignal getSignal();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent#getSignal <em>Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal</em>' reference.
	 * @see #getSignal()
	 * @generated
	 */
	void setSignal(EvSignal value);

} // EvSignalEvent
