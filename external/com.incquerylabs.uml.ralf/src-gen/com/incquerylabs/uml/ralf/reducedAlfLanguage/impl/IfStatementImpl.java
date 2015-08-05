/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.Block;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;

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
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IfStatementImpl#getNonFinalClauses <em>Non Final Clauses</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IfStatementImpl#getFinalClause <em>Final Clause</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends StatementImpl implements IfStatement
{
  /**
   * The cached value of the '{@link #getNonFinalClauses() <em>Non Final Clauses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNonFinalClauses()
   * @generated
   * @ordered
   */
  protected EList<ConcurrentClauses> nonFinalClauses;

  /**
   * The cached value of the '{@link #getFinalClause() <em>Final Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFinalClause()
   * @generated
   * @ordered
   */
  protected Block finalClause;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementImpl()
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
    return ReducedAlfLanguagePackage.Literals.IF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConcurrentClauses> getNonFinalClauses()
  {
    if (nonFinalClauses == null)
    {
      nonFinalClauses = new EObjectContainmentEList<ConcurrentClauses>(ConcurrentClauses.class, this, ReducedAlfLanguagePackage.IF_STATEMENT__NON_FINAL_CLAUSES);
    }
    return nonFinalClauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getFinalClause()
  {
    return finalClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFinalClause(Block newFinalClause, NotificationChain msgs)
  {
    Block oldFinalClause = finalClause;
    finalClause = newFinalClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.IF_STATEMENT__FINAL_CLAUSE, oldFinalClause, newFinalClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinalClause(Block newFinalClause)
  {
    if (newFinalClause != finalClause)
    {
      NotificationChain msgs = null;
      if (finalClause != null)
        msgs = ((InternalEObject)finalClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.IF_STATEMENT__FINAL_CLAUSE, null, msgs);
      if (newFinalClause != null)
        msgs = ((InternalEObject)newFinalClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.IF_STATEMENT__FINAL_CLAUSE, null, msgs);
      msgs = basicSetFinalClause(newFinalClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.IF_STATEMENT__FINAL_CLAUSE, newFinalClause, newFinalClause));
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
      case ReducedAlfLanguagePackage.IF_STATEMENT__NON_FINAL_CLAUSES:
        return ((InternalEList<?>)getNonFinalClauses()).basicRemove(otherEnd, msgs);
      case ReducedAlfLanguagePackage.IF_STATEMENT__FINAL_CLAUSE:
        return basicSetFinalClause(null, msgs);
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
      case ReducedAlfLanguagePackage.IF_STATEMENT__NON_FINAL_CLAUSES:
        return getNonFinalClauses();
      case ReducedAlfLanguagePackage.IF_STATEMENT__FINAL_CLAUSE:
        return getFinalClause();
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
      case ReducedAlfLanguagePackage.IF_STATEMENT__NON_FINAL_CLAUSES:
        getNonFinalClauses().clear();
        getNonFinalClauses().addAll((Collection<? extends ConcurrentClauses>)newValue);
        return;
      case ReducedAlfLanguagePackage.IF_STATEMENT__FINAL_CLAUSE:
        setFinalClause((Block)newValue);
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
      case ReducedAlfLanguagePackage.IF_STATEMENT__NON_FINAL_CLAUSES:
        getNonFinalClauses().clear();
        return;
      case ReducedAlfLanguagePackage.IF_STATEMENT__FINAL_CLAUSE:
        setFinalClause((Block)null);
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
      case ReducedAlfLanguagePackage.IF_STATEMENT__NON_FINAL_CLAUSES:
        return nonFinalClauses != null && !nonFinalClauses.isEmpty();
      case ReducedAlfLanguagePackage.IF_STATEMENT__FINAL_CLAUSE:
        return finalClause != null;
    }
    return super.eIsSet(featureID);
  }

} //IfStatementImpl
