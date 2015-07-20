/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NameWrapper;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cl Ctor Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClCtorRecord#getUsedArgs <em>Used Args</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClCtorRecord()
 * @model
 * @generated
 */
public interface ClCtorRecord extends Named {
	/**
	 * Returns the value of the '<em><b>Used Args</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.base.NameWrapper}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Args</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Args</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClCtorRecord_UsedArgs()
	 * @model
	 * @generated
	 */
	EList<NameWrapper> getUsedArgs();

} // ClCtorRecord
