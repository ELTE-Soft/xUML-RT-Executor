/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.util;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Identified;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import hu.eltesoft.modelexecution.m2m.metamodel.region.*;

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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage
 * @generated
 */
public class RegionSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RegionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionSwitch() {
		if (modelPackage == null) {
			modelPackage = RegionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case RegionPackage.RG_REGION: {
				RgRegion rgRegion = (RgRegion)theEObject;
				T result = caseRgRegion(rgRegion);
				if (result == null) result = caseNamed(rgRegion);
				if (result == null) result = caseIdentified(rgRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RegionPackage.RG_STATE: {
				RgState rgState = (RgState)theEObject;
				T result = caseRgState(rgState);
				if (result == null) result = caseNamed(rgState);
				if (result == null) result = caseIdentified(rgState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RegionPackage.RG_TRANSITION: {
				RgTransition rgTransition = (RgTransition)theEObject;
				T result = caseRgTransition(rgTransition);
				if (result == null) result = caseNamed(rgTransition);
				if (result == null) result = caseIdentified(rgTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RegionPackage.RG_EVENT: {
				RgEvent rgEvent = (RgEvent)theEObject;
				T result = caseRgEvent(rgEvent);
				if (result == null) result = caseNamed(rgEvent);
				if (result == null) result = caseIdentified(rgEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RegionPackage.RG_BEHAVIOR: {
				RgBehavior rgBehavior = (RgBehavior)theEObject;
				T result = caseRgBehavior(rgBehavior);
				if (result == null) result = caseNamed(rgBehavior);
				if (result == null) result = caseIdentified(rgBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rg Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rg Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRgRegion(RgRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rg State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rg State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRgState(RgState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rg Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rg Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRgTransition(RgTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rg Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rg Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRgEvent(RgEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rg Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rg Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRgBehavior(RgBehavior object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Identified</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identified</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentified(Identified object) {
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

} //RegionSwitch
