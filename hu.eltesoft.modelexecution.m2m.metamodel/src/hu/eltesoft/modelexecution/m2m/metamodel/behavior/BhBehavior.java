/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bh Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getContainerClass <em>Container Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getAlfCode <em>Alf Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhBehavior()
 * @model
 * @generated
 */
public interface BhBehavior extends ModelRoot, Named {
	/**
	 * Returns the value of the '<em><b>Container Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Class</em>' reference.
	 * @see #setContainerClass(BhClass)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhBehavior_ContainerClass()
	 * @model required="true"
	 * @generated
	 */
	BhClass getContainerClass();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getContainerClass <em>Container Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Class</em>' reference.
	 * @see #getContainerClass()
	 * @generated
	 */
	void setContainerClass(BhClass value);

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
