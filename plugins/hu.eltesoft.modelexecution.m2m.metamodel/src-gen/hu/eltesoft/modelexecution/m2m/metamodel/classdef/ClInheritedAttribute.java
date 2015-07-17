/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cl Inherited Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClInheritedAttribute()
 * @model
 * @generated
 */
public interface ClInheritedAttribute extends ClAttributeSpec {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' attribute.
	 * @see #setParent(NamedReference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClInheritedAttribute_Parent()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference" required="true"
	 * @generated
	 */
	NamedReference getParent();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute#getParent <em>Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' attribute.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(NamedReference value);

} // ClInheritedAttribute
