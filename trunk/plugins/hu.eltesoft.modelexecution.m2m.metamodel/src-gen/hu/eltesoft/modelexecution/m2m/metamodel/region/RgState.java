/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rg State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getEntry <em>Entry</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getExit <em>Exit</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#isIsFinal <em>Is Final</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgState()
 * @model
 * @generated
 */
public interface RgState extends Named {
	/**
	 * Returns the value of the '<em><b>Entry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' attribute.
	 * @see #setEntry(NamedReference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgState_Entry()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference"
	 * @generated
	 */
	NamedReference getEntry();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getEntry <em>Entry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry</em>' attribute.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(NamedReference value);

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit</em>' attribute.
	 * @see #setExit(NamedReference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgState_Exit()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference"
	 * @generated
	 */
	NamedReference getExit();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getExit <em>Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit</em>' attribute.
	 * @see #getExit()
	 * @generated
	 */
	void setExit(NamedReference value);

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgState_Transitions()
	 * @model ordered="false"
	 * @generated
	 */
	EList<RgTransition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Is Final</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Final</em>' attribute.
	 * @see #setIsFinal(boolean)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgState_IsFinal()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsFinal();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#isIsFinal <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Final</em>' attribute.
	 * @see #isIsFinal()
	 * @generated
	 */
	void setIsFinal(boolean value);

} // RgState
