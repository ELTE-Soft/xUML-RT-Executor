/**
 */
package snippetTemplate.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import snippetTemplate.CompositeSnippet;
import snippetTemplate.Snippet;
import snippetTemplate.SnippetTemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Snippet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link snippetTemplate.impl.CompositeSnippetImpl#getSnippet <em>Snippet</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeSnippetImpl extends SnippetImpl implements CompositeSnippet {
	/**
	 * The cached value of the '{@link #getSnippet() <em>Snippet</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnippet()
	 * @generated
	 * @ordered
	 */
	protected EList<Snippet> snippet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeSnippetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SnippetTemplatePackage.Literals.COMPOSITE_SNIPPET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Snippet> getSnippet() {
		if (snippet == null) {
			snippet = new EObjectContainmentEList<Snippet>(Snippet.class, this, SnippetTemplatePackage.COMPOSITE_SNIPPET__SNIPPET);
		}
		return snippet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SnippetTemplatePackage.COMPOSITE_SNIPPET__SNIPPET:
				return ((InternalEList<?>)getSnippet()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SnippetTemplatePackage.COMPOSITE_SNIPPET__SNIPPET:
				return getSnippet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SnippetTemplatePackage.COMPOSITE_SNIPPET__SNIPPET:
				getSnippet().clear();
				getSnippet().addAll((Collection<? extends Snippet>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SnippetTemplatePackage.COMPOSITE_SNIPPET__SNIPPET:
				getSnippet().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SnippetTemplatePackage.COMPOSITE_SNIPPET__SNIPPET:
				return snippet != null && !snippet.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeSnippetImpl
