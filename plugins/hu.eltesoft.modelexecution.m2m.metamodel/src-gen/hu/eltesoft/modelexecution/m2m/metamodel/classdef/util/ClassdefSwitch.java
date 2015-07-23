/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef.util;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Inherited;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Typed;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.*;

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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
 * @generated
 */
public class ClassdefSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ClassdefPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdefSwitch() {
		if (modelPackage == null) {
			modelPackage = ClassdefPackage.eINSTANCE;
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
			case ClassdefPackage.CL_CLASS: {
				ClClass clClass = (ClClass)theEObject;
				T result = caseClClass(clClass);
				if (result == null) result = caseModelRoot(clClass);
				if (result == null) result = caseNamed(clClass);
				if (result == null) result = caseTranslationObject(clClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_CLASS_SPEC: {
				ClClassSpec clClassSpec = (ClClassSpec)theEObject;
				T result = caseClClassSpec(clClassSpec);
				if (result == null) result = caseModelRoot(clClassSpec);
				if (result == null) result = caseNamed(clClassSpec);
				if (result == null) result = caseTranslationObject(clClassSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_OPERATION: {
				ClOperation clOperation = (ClOperation)theEObject;
				T result = caseClOperation(clOperation);
				if (result == null) result = caseClOperationSpec(clOperation);
				if (result == null) result = caseNamed(clOperation);
				if (result == null) result = caseTranslationObject(clOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_OPERATION_SPEC: {
				ClOperationSpec clOperationSpec = (ClOperationSpec)theEObject;
				T result = caseClOperationSpec(clOperationSpec);
				if (result == null) result = caseNamed(clOperationSpec);
				if (result == null) result = caseTranslationObject(clOperationSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_RECEPTION: {
				ClReception clReception = (ClReception)theEObject;
				T result = caseClReception(clReception);
				if (result == null) result = caseClReceptionSpec(clReception);
				if (result == null) result = caseNamed(clReception);
				if (result == null) result = caseTranslationObject(clReception);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_RECEPTION_SPEC: {
				ClReceptionSpec clReceptionSpec = (ClReceptionSpec)theEObject;
				T result = caseClReceptionSpec(clReceptionSpec);
				if (result == null) result = caseNamed(clReceptionSpec);
				if (result == null) result = caseTranslationObject(clReceptionSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_RECEPTION_PARAMETER: {
				ClReceptionParameter clReceptionParameter = (ClReceptionParameter)theEObject;
				T result = caseClReceptionParameter(clReceptionParameter);
				if (result == null) result = caseNamed(clReceptionParameter);
				if (result == null) result = caseMultiplicity(clReceptionParameter);
				if (result == null) result = caseTranslationObject(clReceptionParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_ATTRIBUTE: {
				ClAttribute clAttribute = (ClAttribute)theEObject;
				T result = caseClAttribute(clAttribute);
				if (result == null) result = caseClAttributeSpec(clAttribute);
				if (result == null) result = caseNamed(clAttribute);
				if (result == null) result = caseTyped(clAttribute);
				if (result == null) result = caseTranslationObject(clAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_ATTRIBUTE_SPEC: {
				ClAttributeSpec clAttributeSpec = (ClAttributeSpec)theEObject;
				T result = caseClAttributeSpec(clAttributeSpec);
				if (result == null) result = caseNamed(clAttributeSpec);
				if (result == null) result = caseTyped(clAttributeSpec);
				if (result == null) result = caseTranslationObject(clAttributeSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_INHERITED_ATTRIBUTE: {
				ClInheritedAttribute clInheritedAttribute = (ClInheritedAttribute)theEObject;
				T result = caseClInheritedAttribute(clInheritedAttribute);
				if (result == null) result = caseClAttributeSpec(clInheritedAttribute);
				if (result == null) result = caseInherited(clInheritedAttribute);
				if (result == null) result = caseNamed(clInheritedAttribute);
				if (result == null) result = caseTyped(clInheritedAttribute);
				if (result == null) result = caseTranslationObject(clInheritedAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_ASSOCIATION: {
				ClAssociation clAssociation = (ClAssociation)theEObject;
				T result = caseClAssociation(clAssociation);
				if (result == null) result = caseClAssociationSpec(clAssociation);
				if (result == null) result = caseNamed(clAssociation);
				if (result == null) result = caseTyped(clAssociation);
				if (result == null) result = caseTranslationObject(clAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_ASSOCIATION_SPEC: {
				ClAssociationSpec clAssociationSpec = (ClAssociationSpec)theEObject;
				T result = caseClAssociationSpec(clAssociationSpec);
				if (result == null) result = caseNamed(clAssociationSpec);
				if (result == null) result = caseTyped(clAssociationSpec);
				if (result == null) result = caseTranslationObject(clAssociationSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_INHERITED_ASSOCIATION: {
				ClInheritedAssociation clInheritedAssociation = (ClInheritedAssociation)theEObject;
				T result = caseClInheritedAssociation(clInheritedAssociation);
				if (result == null) result = caseInherited(clInheritedAssociation);
				if (result == null) result = caseClAssociationSpec(clInheritedAssociation);
				if (result == null) result = caseNamed(clInheritedAssociation);
				if (result == null) result = caseTyped(clInheritedAssociation);
				if (result == null) result = caseTranslationObject(clInheritedAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ClassdefPackage.CL_CTOR_RECORD: {
				ClCtorRecord clCtorRecord = (ClCtorRecord)theEObject;
				T result = caseClCtorRecord(clCtorRecord);
				if (result == null) result = caseNamed(clCtorRecord);
				if (result == null) result = caseTranslationObject(clCtorRecord);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Cl Class Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Class Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClClassSpec(ClClassSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClOperation(ClOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Operation Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Operation Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClOperationSpec(ClOperationSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Reception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Reception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClReception(ClReception object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Reception Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Reception Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClReceptionSpec(ClReceptionSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Reception Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Reception Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClReceptionParameter(ClReceptionParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClAttribute(ClAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Attribute Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Attribute Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClAttributeSpec(ClAttributeSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Inherited Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Inherited Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClInheritedAttribute(ClInheritedAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClAssociation(ClAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Association Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Association Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClAssociationSpec(ClAssociationSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Inherited Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Inherited Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClInheritedAssociation(ClInheritedAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cl Ctor Record</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cl Ctor Record</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClCtorRecord(ClCtorRecord object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicity(Multiplicity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTyped(Typed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inherited</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inherited</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInherited(Inherited object) {
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

} //ClassdefSwitch
