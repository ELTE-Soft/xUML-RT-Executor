/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bh Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getContainerClass <em>Container Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getAlfResult <em>Alf Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhBehavior()
 * @model
 * @generated
 */
public interface BhBehavior extends ModelRoot, Named {
	/**
	 * Returns the value of the '<em><b>Container Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Class</em>' attribute.
	 * @see #setContainerClass(NamedReference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhBehavior_ContainerClass()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference" required="true"
	 * @generated
	 */
	NamedReference getContainerClass();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getContainerClass <em>Container Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Class</em>' attribute.
	 * @see #getContainerClass()
	 * @generated
	 */
	void setContainerClass(NamedReference value);

	/**
	 * Returns the value of the '<em><b>Alf Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alf Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alf Result</em>' attribute.
	 * @see #setAlfResult(AlfAnalyzerResult)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage#getBhBehavior_AlfResult()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.behavior.AlfAnalyzerResult" required="true"
	 * @generated
	 */
	AlfAnalyzerResult getAlfResult();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getAlfResult <em>Alf Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alf Result</em>' attribute.
	 * @see #getAlfResult()
	 * @generated
	 */
	void setAlfResult(AlfAnalyzerResult value);

} // BhBehavior
