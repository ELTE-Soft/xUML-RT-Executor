/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bh Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhParameter#getType <em>Type</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhParameter#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhParameter()
 * @model
 * @generated
 */
public interface BhParameter extends Named {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhParameter_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhParameter#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.eltesoft.modelexecution.m2m.metamodel.base.Direction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Direction
	 * @see #setDirection(Direction)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhParameter_Direction()
	 * @model
	 * @generated
	 */
	Direction getDirection();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhParameter#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Direction
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(Direction value);

} // BhParameter
