/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cl Reception</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception#getSignal <em>Signal</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClReception()
 * @model
 * @generated
 */
public interface ClReception extends ClReceptionSpec {
	/**
	 * Returns the value of the '<em><b>Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal</em>' attribute.
	 * @see #setSignal(NamedReference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClReception_Signal()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference" required="true"
	 * @generated
	 */
	NamedReference getSignal();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception#getSignal <em>Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal</em>' attribute.
	 * @see #getSignal()
	 * @generated
	 */
	void setSignal(NamedReference value);

} // ClReception
