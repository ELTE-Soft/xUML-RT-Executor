/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Named#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage#getNamed()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Named extends TranslationObject {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(NamedReference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage#getNamed_Reference()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference" required="true"
	 * @generated
	 */
	NamedReference getReference();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Named#getReference <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' attribute.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(NamedReference value);

} // Named
