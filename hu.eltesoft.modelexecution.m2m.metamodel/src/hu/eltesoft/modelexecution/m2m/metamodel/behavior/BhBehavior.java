/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Identified;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bh Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getAlfCode <em>Alf Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhBehavior()
 * @model
 * @generated
 */
public interface BhBehavior extends Named, Identified {
	/**
	 * Returns the value of the '<em><b>Alf Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alf Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alf Code</em>' attribute.
	 * @see #setAlfCode(String)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhBehavior_AlfCode()
	 * @model required="true"
	 * @generated
	 */
	String getAlfCode();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getAlfCode <em>Alf Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alf Code</em>' attribute.
	 * @see #getAlfCode()
	 * @generated
	 */
	void setAlfCode(String value);

} // BhBehavior
