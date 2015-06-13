/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.association;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>As Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation#getEnds <em>Ends</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage#getAsAssociation()
 * @model
 * @generated
 */
public interface AsAssociation extends ModelRoot {
	/**
	 * Returns the value of the '<em><b>Ends</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationEnd}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ends</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage#getAsAssociation_Ends()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<AsAssociationEnd> getEnds();

} // AsAssociation
