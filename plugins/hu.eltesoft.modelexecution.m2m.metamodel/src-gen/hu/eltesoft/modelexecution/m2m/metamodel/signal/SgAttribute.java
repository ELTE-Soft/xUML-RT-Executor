/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.signal;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sg Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute#getType <em>Type</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage#getSgAttribute()
 * @model
 * @generated
 */
public interface SgAttribute extends Named {
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
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage#getSgAttribute_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
	 * @see #setMultiplicity(Multiplicity)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage#getSgAttribute_Multiplicity()
	 * @model
	 * @generated
	 */
	Multiplicity getMultiplicity();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(Multiplicity value);

} // SgAttribute
