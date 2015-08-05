/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.Block;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchStatementImpl#getNonDefaultClause <em>Non Default Clause</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchStatementImpl#getDefaultClause <em>Default Clause</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SwitchStatementImpl extends StatementImpl implements SwitchStatement
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getNonDefaultClause() <em>Non Default Clause</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNonDefaultClause()
   * @generated
   * @ordered
   */
  protected EList<SwitchClause> nonDefaultClause;

  /**
   * The cached value of the '{@link #getDefaultClause() <em>Default Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultClause()
   * @generated
   * @ordered
   */
  protected Block defaultClause;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SwitchStatementImpl()
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
    return ReducedAlfLanguagePackage.Literals.SWITCH_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.SWITCH_STATEMENT__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.SWITCH_STATEMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.SWITCH_STATEMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.SWITCH_STATEMENT__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SwitchClause> getNonDefaultClause()
  {
    if (nonDefaultClause == null)
    {
      nonDefaultClause = new EObjectContainmentEList<SwitchClause>(SwitchClause.class, this, ReducedAlfLanguagePackage.SWITCH_STATEMENT__NON_DEFAULT_CLAUSE);
    }
    return nonDefaultClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getDefaultClause()
  {
    return defaultClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDefaultClause(Block newDefaultClause, NotificationChain msgs)
  {
    Block oldDefaultClause = defaultClause;
    defaultClause = newDefaultClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.SWITCH_STATEMENT__DEFAULT_CLAUSE, oldDefaultClause, newDefaultClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultClause(Block newDefaultClause)
  {
    if (newDefaultClause != defaultClause)
    {
      NotificationChain msgs = null;
      if (defaultClause != null)
        msgs = ((InternalEObject)defaultClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.SWITCH_STATEMENT__DEFAULT_CLAUSE, null, msgs);
      if (newDefaultClause != null)
        msgs = ((InternalEObject)newDefaultClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.SWITCH_STATEMENT__DEFAULT_CLAUSE, null, msgs);
      msgs = basicSetDefaultClause(newDefaultClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.SWITCH_STATEMENT__DEFAULT_CLAUSE, newDefaultClause, newDefaultClause));
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
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__EXPRESSION:
        return basicSetExpression(null, msgs);
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__NON_DEFAULT_CLAUSE:
        return ((InternalEList<?>)getNonDefaultClause()).basicRemove(otherEnd, msgs);
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__DEFAULT_CLAUSE:
        return basicSetDefaultClause(null, msgs);
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
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__EXPRESSION:
        return getExpression();
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__NON_DEFAULT_CLAUSE:
        return getNonDefaultClause();
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__DEFAULT_CLAUSE:
        return getDefaultClause();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__NON_DEFAULT_CLAUSE:
        getNonDefaultClause().clear();
        getNonDefaultClause().addAll((Collection<? extends SwitchClause>)newValue);
        return;
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__DEFAULT_CLAUSE:
        setDefaultClause((Block)newValue);
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
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__EXPRESSION:
        setExpression((Expression)null);
        return;
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__NON_DEFAULT_CLAUSE:
        getNonDefaultClause().clear();
        return;
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__DEFAULT_CLAUSE:
        setDefaultClause((Block)null);
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
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__EXPRESSION:
        return expression != null;
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__NON_DEFAULT_CLAUSE:
        return nonDefaultClause != null && !nonDefaultClause.isEmpty();
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT__DEFAULT_CLAUSE:
        return defaultClause != null;
    }
    return super.eIsSet(featureID);
  }

} //SwitchStatementImpl
