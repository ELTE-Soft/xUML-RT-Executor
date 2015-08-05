/**
 */
package snippetTemplate.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import snippetTemplate.CompositeSnippet;
import snippetTemplate.Snippet;
import snippetTemplate.SnippetTemplateFactory;
import snippetTemplate.SnippetTemplatePackage;
import snippetTemplate.StringSnippet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SnippetTemplatePackageImpl extends EPackageImpl implements SnippetTemplatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snippetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringSnippetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeSnippetEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see snippetTemplate.SnippetTemplatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SnippetTemplatePackageImpl() {
		super(eNS_URI, SnippetTemplateFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SnippetTemplatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SnippetTemplatePackage init() {
		if (isInited) return (SnippetTemplatePackage)EPackage.Registry.INSTANCE.getEPackage(SnippetTemplatePackage.eNS_URI);

		// Obtain or create and register package
		SnippetTemplatePackageImpl theSnippetTemplatePackage = (SnippetTemplatePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SnippetTemplatePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SnippetTemplatePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSnippetTemplatePackage.createPackageContents();

		// Initialize created meta-data
		theSnippetTemplatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSnippetTemplatePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SnippetTemplatePackage.eNS_URI, theSnippetTemplatePackage);
		return theSnippetTemplatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSnippet() {
		return snippetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringSnippet() {
		return stringSnippetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringSnippet_Value() {
		return (EAttribute)stringSnippetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeSnippet() {
		return compositeSnippetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeSnippet_Snippet() {
		return (EReference)compositeSnippetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SnippetTemplateFactory getSnippetTemplateFactory() {
		return (SnippetTemplateFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		snippetEClass = createEClass(SNIPPET);

		stringSnippetEClass = createEClass(STRING_SNIPPET);
		createEAttribute(stringSnippetEClass, STRING_SNIPPET__VALUE);

		compositeSnippetEClass = createEClass(COMPOSITE_SNIPPET);
		createEReference(compositeSnippetEClass, COMPOSITE_SNIPPET__SNIPPET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stringSnippetEClass.getESuperTypes().add(this.getSnippet());
		compositeSnippetEClass.getESuperTypes().add(this.getSnippet());

		// Initialize classes, features, and operations; add parameters
		initEClass(snippetEClass, Snippet.class, "Snippet", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringSnippetEClass, StringSnippet.class, "StringSnippet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringSnippet_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringSnippet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeSnippetEClass, CompositeSnippet.class, "CompositeSnippet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeSnippet_Snippet(), this.getSnippet(), null, "snippet", null, 0, -1, CompositeSnippet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SnippetTemplatePackageImpl
