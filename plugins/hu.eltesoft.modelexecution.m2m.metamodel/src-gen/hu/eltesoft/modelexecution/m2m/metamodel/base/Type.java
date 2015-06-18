/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Type#getBaseType <em>Base Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage#getType()
 * @model
 * @generated
 */
public interface Type extends TranslationObject, Multiplicity {
	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Type</em>' reference.
	 * @see #setBaseType(ScalarType)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage#getType_BaseType()
	 * @model required="true"
	 * @generated
	 */
	ScalarType getBaseType();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Type#getBaseType <em>Base Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Type</em>' reference.
	 * @see #getBaseType()
	 * @generated
	 */
	void setBaseType(ScalarType value);

} // Type
