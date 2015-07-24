/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.association.util;

import hu.eltesoft.modelexecution.m2m.metamodel.association.*;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage
 * @generated
 */
public class AssociationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AssociationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationSwitch() {
		if (modelPackage == null) {
			modelPackage = AssociationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AssociationPackage.AS_ASSOCIATION: {
				AsAssociation asAssociation = (AsAssociation)theEObject;
				T result = caseAsAssociation(asAssociation);
				if (result == null) result = caseModelRoot(asAssociation);
				if (result == null) result = caseNamed(asAssociation);
				if (result == null) result = caseTranslationObject(asAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssociationPackage.AS_ASSOCIATION_END: {
				AsAssociationEnd asAssociationEnd = (AsAssociationEnd)theEObject;
				T result = caseAsAssociationEnd(asAssociationEnd);
				if (result == null) result = caseNamed(asAssociationEnd);
				if (result == null) result = caseTranslationObject(asAssociationEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssociationPackage.AS_ASSOCIATION_CLASS: {
				AsAssociationClass asAssociationClass = (AsAssociationClass)theEObject;
				T result = caseAsAssociationClass(asAssociationClass);
				if (result == null) result = caseAsAssociation(asAssociationClass);
				if (result == null) result = caseClClass(asAssociationClass);
				if (result == null) result = caseModelRoot(asAssociationClass);
				if (result == null) result = caseNamed(asAssociationClass);
				if (result == null) result = caseTranslationObject(asAssociationClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>As Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>As Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAsAssociation(AsAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>As Association End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>As Association End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAsAssociationEnd(AsAssociationEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>As Association Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>As Association Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAsAssociationClass(AsAssociationClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Translation Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Translation Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTranslationObject(TranslationObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamed(Named object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelRoot(ModelRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClClass(ClClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AssociationSwitch
