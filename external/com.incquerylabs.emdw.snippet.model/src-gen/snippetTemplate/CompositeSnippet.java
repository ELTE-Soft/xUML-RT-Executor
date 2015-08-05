/**
 */
package snippetTemplate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Snippet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link snippetTemplate.CompositeSnippet#getSnippet <em>Snippet</em>}</li>
 * </ul>
 *
 * @see snippetTemplate.SnippetTemplatePackage#getCompositeSnippet()
 * @model
 * @generated
 */
public interface CompositeSnippet extends Snippet {
	/**
	 * Returns the value of the '<em><b>Snippet</b></em>' containment reference list.
	 * The list contents are of type {@link snippetTemplate.Snippet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snippet</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snippet</em>' containment reference list.
	 * @see snippetTemplate.SnippetTemplatePackage#getCompositeSnippet_Snippet()
	 * @model containment="true"
	 * @generated
	 */
	EList<Snippet> getSnippet();

} // CompositeSnippet
