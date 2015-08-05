/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationOperator;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classification Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassificationExpressionImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassificationExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassificationExpressionImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassificationExpressionImpl extends ExpressionImpl implements ClassificationExpression
{
  /**
   * The cached value of the '{@link #getOperand() <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand()
   * @generated
   * @ordered
   */
  protected Expression operand;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final ClassificationOperator OPERATOR_EDEFAULT = ClassificationOperator.INSTANCEOF;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected ClassificationOperator operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected org.eclipse.uml2.uml.Class type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassificationExpressionImpl()
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
    return ReducedAlfLanguagePackage.Literals.CLASSIFICATION_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getOperand()
  {
    return operand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand(Expression newOperand, NotificationChain msgs)
  {
    Expression oldOperand = operand;
    operand = newOperand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERAND, oldOperand, newOperand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperand(Expression newOperand)
  {
    if (newOperand != operand)
    {
      NotificationChain msgs = null;
      if (operand != null)
        msgs = ((InternalEObject)operand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERAND, null, msgs);
      if (newOperand != null)
        msgs = ((InternalEObject)newOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERAND, null, msgs);
      msgs = basicSetOperand(newOperand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERAND, newOperand, newOperand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(ClassificationOperator newOperator)
  {
    ClassificationOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.uml2.uml.Class getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (org.eclipse.uml2.uml.Class)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.uml2.uml.Class basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(org.eclipse.uml2.uml.Class newType)
  {
    org.eclipse.uml2.uml.Class oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__TYPE, oldType, type));
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
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERAND:
        return basicSetOperand(null, msgs);
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
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERAND:
        return getOperand();
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERATOR:
        return getOperator();
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__TYPE:
        if (resolve) return getType();
        return basicGetType();
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
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERAND:
        setOperand((Expression)newValue);
        return;
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERATOR:
        setOperator((ClassificationOperator)newValue);
        return;
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__TYPE:
        setType((org.eclipse.uml2.uml.Class)newValue);
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
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERAND:
        setOperand((Expression)null);
        return;
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__TYPE:
        setType((org.eclipse.uml2.uml.Class)null);
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
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERAND:
        return operand != null;
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION__TYPE:
        return type != null;
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

} //ClassificationExpressionImpl
