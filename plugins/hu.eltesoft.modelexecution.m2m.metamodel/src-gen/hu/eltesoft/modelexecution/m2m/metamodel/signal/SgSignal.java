/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.signal;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sg Signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage#getSgSignal()
 * @model
 * @generated
 */
public interface SgSignal extends ModelRoot, Named {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage#getSgSignal_Attributes()
	 * @model
	 * @generated
	 */
	EList<SgAttribute> getAttributes();

} // SgSignal
