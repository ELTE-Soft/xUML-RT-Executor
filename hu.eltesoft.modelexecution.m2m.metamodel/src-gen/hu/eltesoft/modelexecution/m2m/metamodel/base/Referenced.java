/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.base;

import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referenced</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage#getReferenced()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Referenced extends TranslationObject {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(Reference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage#getReferenced_Reference()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.Reference" required="true"
	 * @generated
	 */
	Reference getReference();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced#getReference <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' attribute.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(Reference value);

} // Referenced
