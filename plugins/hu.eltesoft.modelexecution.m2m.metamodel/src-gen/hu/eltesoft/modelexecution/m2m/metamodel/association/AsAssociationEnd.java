/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.association;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ReferencedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>As Association End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationEnd#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage#getAsAssociationEnd()
 * @model
 * @generated
 */
public interface AsAssociationEnd extends Named {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ReferencedType)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage#getAsAssociationEnd_Type()
	 * @model required="true"
	 * @generated
	 */
	ReferencedType getType();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationEnd#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ReferencedType value);

} // AsAssociationEnd
