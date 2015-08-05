/**
 */
package snippetTemplate;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see snippetTemplate.SnippetTemplatePackage
 * @generated
 */
public interface SnippetTemplateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SnippetTemplateFactory eINSTANCE = snippetTemplate.impl.SnippetTemplateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>String Snippet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Snippet</em>'.
	 * @generated
	 */
	StringSnippet createStringSnippet();

	/**
	 * Returns a new object of class '<em>Composite Snippet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Snippet</em>'.
	 * @generated
	 */
	CompositeSnippet createCompositeSnippet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SnippetTemplatePackage getSnippetTemplatePackage();

} //SnippetTemplateFactory
