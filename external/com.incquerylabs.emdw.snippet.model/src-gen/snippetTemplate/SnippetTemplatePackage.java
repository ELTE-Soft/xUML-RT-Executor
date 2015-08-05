/**
 */
package snippetTemplate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see snippetTemplate.SnippetTemplateFactory
 * @model kind="package"
 * @generated
 */
public interface SnippetTemplatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "snippetTemplate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.incquerylabs.com/uml/ralf/SnippetTemplate";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "snippetTemplate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SnippetTemplatePackage eINSTANCE = snippetTemplate.impl.SnippetTemplatePackageImpl.init();

	/**
	 * The meta object id for the '{@link snippetTemplate.impl.SnippetImpl <em>Snippet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see snippetTemplate.impl.SnippetImpl
	 * @see snippetTemplate.impl.SnippetTemplatePackageImpl#getSnippet()
	 * @generated
	 */
	int SNIPPET = 0;

	/**
	 * The number of structural features of the '<em>Snippet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNIPPET_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Snippet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNIPPET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link snippetTemplate.impl.StringSnippetImpl <em>String Snippet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see snippetTemplate.impl.StringSnippetImpl
	 * @see snippetTemplate.impl.SnippetTemplatePackageImpl#getStringSnippet()
	 * @generated
	 */
	int STRING_SNIPPET = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SNIPPET__VALUE = SNIPPET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Snippet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SNIPPET_FEATURE_COUNT = SNIPPET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Snippet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SNIPPET_OPERATION_COUNT = SNIPPET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link snippetTemplate.impl.CompositeSnippetImpl <em>Composite Snippet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see snippetTemplate.impl.CompositeSnippetImpl
	 * @see snippetTemplate.impl.SnippetTemplatePackageImpl#getCompositeSnippet()
	 * @generated
	 */
	int COMPOSITE_SNIPPET = 2;

	/**
	 * The feature id for the '<em><b>Snippet</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SNIPPET__SNIPPET = SNIPPET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Snippet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SNIPPET_FEATURE_COUNT = SNIPPET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Snippet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SNIPPET_OPERATION_COUNT = SNIPPET_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link snippetTemplate.Snippet <em>Snippet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snippet</em>'.
	 * @see snippetTemplate.Snippet
	 * @generated
	 */
	EClass getSnippet();

	/**
	 * Returns the meta object for class '{@link snippetTemplate.StringSnippet <em>String Snippet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Snippet</em>'.
	 * @see snippetTemplate.StringSnippet
	 * @generated
	 */
	EClass getStringSnippet();

	/**
	 * Returns the meta object for the attribute '{@link snippetTemplate.StringSnippet#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see snippetTemplate.StringSnippet#getValue()
	 * @see #getStringSnippet()
	 * @generated
	 */
	EAttribute getStringSnippet_Value();

	/**
	 * Returns the meta object for class '{@link snippetTemplate.CompositeSnippet <em>Composite Snippet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Snippet</em>'.
	 * @see snippetTemplate.CompositeSnippet
	 * @generated
	 */
	EClass getCompositeSnippet();

	/**
	 * Returns the meta object for the containment reference list '{@link snippetTemplate.CompositeSnippet#getSnippet <em>Snippet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Snippet</em>'.
	 * @see snippetTemplate.CompositeSnippet#getSnippet()
	 * @see #getCompositeSnippet()
	 * @generated
	 */
	EReference getCompositeSnippet_Snippet();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SnippetTemplateFactory getSnippetTemplateFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link snippetTemplate.impl.SnippetImpl <em>Snippet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see snippetTemplate.impl.SnippetImpl
		 * @see snippetTemplate.impl.SnippetTemplatePackageImpl#getSnippet()
		 * @generated
		 */
		EClass SNIPPET = eINSTANCE.getSnippet();

		/**
		 * The meta object literal for the '{@link snippetTemplate.impl.StringSnippetImpl <em>String Snippet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see snippetTemplate.impl.StringSnippetImpl
		 * @see snippetTemplate.impl.SnippetTemplatePackageImpl#getStringSnippet()
		 * @generated
		 */
		EClass STRING_SNIPPET = eINSTANCE.getStringSnippet();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_SNIPPET__VALUE = eINSTANCE.getStringSnippet_Value();

		/**
		 * The meta object literal for the '{@link snippetTemplate.impl.CompositeSnippetImpl <em>Composite Snippet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see snippetTemplate.impl.CompositeSnippetImpl
		 * @see snippetTemplate.impl.SnippetTemplatePackageImpl#getCompositeSnippet()
		 * @generated
		 */
		EClass COMPOSITE_SNIPPET = eINSTANCE.getCompositeSnippet();

		/**
		 * The meta object literal for the '<em><b>Snippet</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_SNIPPET__SNIPPET = eINSTANCE.getCompositeSnippet_Snippet();

	}

} //SnippetTemplatePackage
