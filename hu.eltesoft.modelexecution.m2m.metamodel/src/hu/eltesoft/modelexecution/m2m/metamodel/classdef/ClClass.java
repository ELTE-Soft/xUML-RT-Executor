/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Identified;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cl Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getOperations <em>Operations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getReceptions <em>Receptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass()
 * @model
 * @generated
 */
public interface ClClass extends Named, Identified {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_Operations()
	 * @model
	 * @generated
	 */
	EList<ClOperation> getOperations();

	/**
	 * Returns the value of the '<em><b>Receptions</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClSignal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receptions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receptions</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_Receptions()
	 * @model
	 * @generated
	 */
	EList<ClSignal> getReceptions();

} // ClClass
