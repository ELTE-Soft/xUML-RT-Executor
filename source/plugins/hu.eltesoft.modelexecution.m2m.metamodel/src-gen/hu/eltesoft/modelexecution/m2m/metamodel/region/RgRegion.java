/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rg Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getContainerClass <em>Container Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getInitialPseudostate <em>Initial Pseudostate</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgRegion()
 * @model
 * @generated
 */
public interface RgRegion extends ModelRoot, Named {
	/**
	 * Returns the value of the '<em><b>Container Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Class</em>' attribute.
	 * @see #setContainerClass(NamedReference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgRegion_ContainerClass()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference" required="true"
	 * @generated
	 */
	NamedReference getContainerClass();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getContainerClass <em>Container Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Class</em>' attribute.
	 * @see #getContainerClass()
	 * @generated
	 */
	void setContainerClass(NamedReference value);

	/**
	 * Returns the value of the '<em><b>Initial Pseudostate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Pseudostate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Pseudostate</em>' reference.
	 * @see #setInitialPseudostate(RgInitialPseudostate)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgRegion_InitialPseudostate()
	 * @model required="true"
	 * @generated
	 */
	RgInitialPseudostate getInitialPseudostate();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getInitialPseudostate <em>Initial Pseudostate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Pseudostate</em>' reference.
	 * @see #getInitialPseudostate()
	 * @generated
	 */
	void setInitialPseudostate(RgInitialPseudostate value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#getRgRegion_States()
	 * @model required="true"
	 * @generated
	 */
	EList<RgState> getStates();

} // RgRegion
