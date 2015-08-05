/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalLogicalExpressionImpl#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalLogicalExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalLogicalExpressionImpl#getOperand2 <em>Operand2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalLogicalExpressionImpl extends ExpressionImpl implements ConditionalLogicalExpression
{
  /**
   * The cached value of the '{@link #getOperand1() <em>Operand1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand1()
   * @generated
   * @ordered
   */
  protected Expression operand1;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final String OPERATOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected String operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getOperand2() <em>Operand2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand2()
   * @generated
   * @ordered
   */
  protected Expression operand2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalLogicalExpressionImpl()
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
    return ReducedAlfLanguagePackage.Literals.CONDITIONAL_LOGICAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getOperand1()
  {
    return operand1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand1(Expression newOperand1, NotificationChain msgs)
  {
    Expression oldOperand1 = operand1;
    operand1 = newOperand1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1, oldOperand1, newOperand1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperand1(Expression newOperand1)
  {
    if (newOperand1 != operand1)
    {
      NotificationChain msgs = null;
      if (operand1 != null)
        msgs = ((InternalEObject)operand1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1, null, msgs);
      if (newOperand1 != null)
        msgs = ((InternalEObject)newOperand1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1, null, msgs);
      msgs = basicSetOperand1(newOperand1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1, newOperand1, newOperand1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(String newOperator)
  {
    String oldOperator = operator;
    operator = newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getOperand2()
  {
    return operand2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand2(Expression newOperand2, NotificationChain msgs)
  {
    Expression oldOperand2 = operand2;
    operand2 = newOperand2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2, oldOperand2, newOperand2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperand2(Expression newOperand2)
  {
    if (newOperand2 != operand2)
    {
      NotificationChain msgs = null;
      if (operand2 != null)
        msgs = ((InternalEObject)operand2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2, null, msgs);
      if (newOperand2 != null)
        msgs = ((InternalEObject)newOperand2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2, null, msgs);
      msgs = basicSetOperand2(newOperand2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2, newOperand2, newOperand2));
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
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1:
        return basicSetOperand1(null, msgs);
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2:
        return basicSetOperand2(null, msgs);
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
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1:
        return getOperand1();
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERATOR:
        return getOperator();
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2:
        return getOperand2();
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
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1:
        setOperand1((Expression)newValue);
        return;
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERATOR:
        setOperator((String)newValue);
        return;
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2:
        setOperand2((Expression)newValue);
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
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1:
        setOperand1((Expression)null);
        return;
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2:
        setOperand2((Expression)null);
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
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1:
        return operand1 != null;
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERATOR:
        return OPERATOR_EDEFAULT == null ? operator != null : !OPERATOR_EDEFAULT.equals(operator);
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2:
        return operand2 != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //ConditionalLogicalExpressionImpl
