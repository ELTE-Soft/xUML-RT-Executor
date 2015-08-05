/**
 */
package snippetTemplate.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import snippetTemplate.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SnippetTemplateFactoryImpl extends EFactoryImpl implements SnippetTemplateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SnippetTemplateFactory init() {
		try {
			SnippetTemplateFactory theSnippetTemplateFactory = (SnippetTemplateFactory)EPackage.Registry.INSTANCE.getEFactory(SnippetTemplatePackage.eNS_URI);
			if (theSnippetTemplateFactory != null) {
				return theSnippetTemplateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SnippetTemplateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SnippetTemplateFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SnippetTemplatePackage.STRING_SNIPPET: return createStringSnippet();
			case SnippetTemplatePackage.COMPOSITE_SNIPPET: return createCompositeSnippet();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringSnippet createStringSnippet() {
		StringSnippetImpl stringSnippet = new StringSnippetImpl();
		return stringSnippet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSnippet createCompositeSnippet() {
		CompositeSnippetImpl compositeSnippet = new CompositeSnippetImpl();
		return compositeSnippet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SnippetTemplatePackage getSnippetTemplatePackage() {
		return (SnippetTemplatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SnippetTemplatePackage getPackage() {
		return SnippetTemplatePackage.eINSTANCE;
	}

} //SnippetTemplateFactoryImpl
