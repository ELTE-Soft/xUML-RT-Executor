/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable#getType <em>Type</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable#isHasMultiplicity <em>Has Multiplicity</em>}</li>
 * </ul>
 *
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeDeclaration)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getVariable_Type()
   * @model containment="true"
   * @generated
   */
  TypeDeclaration getType();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeDeclaration value);

  /**
   * Returns the value of the '<em><b>Has Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Multiplicity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Multiplicity</em>' attribute.
   * @see #setHasMultiplicity(boolean)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getVariable_HasMultiplicity()
   * @model
   * @generated
   */
  boolean isHasMultiplicity();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable#isHasMultiplicity <em>Has Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Multiplicity</em>' attribute.
   * @see #isHasMultiplicity()
   * @generated
   */
  void setHasMultiplicity(boolean value);

} // Variable
