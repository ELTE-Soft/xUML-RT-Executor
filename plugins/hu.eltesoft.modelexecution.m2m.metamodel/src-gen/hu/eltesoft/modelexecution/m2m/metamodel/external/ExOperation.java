/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.external;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ex Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation#getProxyClass <em>Proxy Class</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage#getExOperation()
 * @model
 * @generated
 */
public interface ExOperation extends Named {
	/**
	 * Returns the value of the '<em><b>Proxy Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proxy Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proxy Class</em>' attribute.
	 * @see #setProxyClass(String)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage#getExOperation_ProxyClass()
	 * @model
	 * @generated
	 */
	String getProxyClass();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation#getProxyClass <em>Proxy Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proxy Class</em>' attribute.
	 * @see #getProxyClass()
	 * @generated
	 */
	void setProxyClass(String value);

} // ExOperation
