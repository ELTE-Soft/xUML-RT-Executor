/**
 */
package snippetTemplate.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import snippetTemplate.Snippet;
import snippetTemplate.SnippetTemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Snippet</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class SnippetImpl extends MinimalEObjectImpl.Container implements Snippet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnippetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SnippetTemplatePackage.Literals.SNIPPET;
	}

} //SnippetImpl
