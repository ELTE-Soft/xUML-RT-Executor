/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.Block;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Each Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForEachStatementImpl#getVariableDefinition <em>Variable Definition</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForEachStatementImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForEachStatementImpl extends StatementImpl implements ForEachStatement
{
  /**
   * The cached value of the '{@link #getVariableDefinition() <em>Variable Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableDefinition()
   * @generated
   * @ordered
   */
  protected Variable variableDefinition;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected Block body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForEachStatementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReducedAlfLanguagePackage.Literals.FOR_EACH_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable getVariableDefinition()
  {
    return variableDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariableDefinition(Variable newVariableDefinition, NotificationChain msgs)
  {
    Variable oldVariableDefinition = variableDefinition;
    variableDefinition = newVariableDefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__VARIABLE_DEFINITION, oldVariableDefinition, newVariableDefinition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableDefinition(Variable newVariableDefinition)
  {
    if (newVariableDefinition != variableDefinition)
    {
      NotificationChain msgs = null;
      if (variableDefinition != null)
        msgs = ((InternalEObject)variableDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__VARIABLE_DEFINITION, null, msgs);
      if (newVariableDefinition != null)
        msgs = ((InternalEObject)newVariableDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__VARIABLE_DEFINITION, null, msgs);
      msgs = basicSetVariableDefinition(newVariableDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__VARIABLE_DEFINITION, newVariableDefinition, newVariableDefinition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(Block newBody, NotificationChain msgs)
  {
    Block oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(Block newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__BODY, newBody, newBody));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__VARIABLE_DEFINITION:
        return basicSetVariableDefinition(null, msgs);
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__BODY:
        return basicSetBody(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__VARIABLE_DEFINITION:
        return getVariableDefinition();
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__BODY:
        return getBody();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__VARIABLE_DEFINITION:
        setVariableDefinition((Variable)newValue);
        return;
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__BODY:
        setBody((Block)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__VARIABLE_DEFINITION:
        setVariableDefinition((Variable)null);
        return;
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__BODY:
        setBody((Block)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__VARIABLE_DEFINITION:
        return variableDefinition != null;
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //ForEachStatementImpl
