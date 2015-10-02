/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Parameter#getDirection <em>Direction</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends Named, Typed {
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
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage#getParameter_Direction()
	 * @model required="true"
	 * @generated
	 */
	Direction getDirection();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Parameter#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Direction
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(Direction value);

} // Parameter
