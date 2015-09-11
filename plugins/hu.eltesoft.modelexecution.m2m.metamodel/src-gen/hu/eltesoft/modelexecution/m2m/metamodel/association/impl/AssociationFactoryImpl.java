/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.association.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.association.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssociationFactoryImpl extends EFactoryImpl implements AssociationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AssociationFactory init() {
		try {
			AssociationFactory theAssociationFactory = (AssociationFactory)EPackage.Registry.INSTANCE.getEFactory(AssociationPackage.eNS_URI);
			if (theAssociationFactory != null) {
				return theAssociationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AssociationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationFactoryImpl() {
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
			case AssociationPackage.AS_ASSOCIATION: return createAsAssociation();
			case AssociationPackage.AS_ASSOCIATION_END: return createAsAssociationEnd();
			case AssociationPackage.AS_ASSOCIATION_CLASS: return createAsAssociationClass();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsAssociation createAsAssociation() {
		AsAssociationImpl asAssociation = new AsAssociationImpl();
		return asAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsAssociationEnd createAsAssociationEnd() {
		AsAssociationEndImpl asAssociationEnd = new AsAssociationEndImpl();
		return asAssociationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsAssociationClass createAsAssociationClass() {
		AsAssociationClassImpl asAssociationClass = new AsAssociationClassImpl();
		return asAssociationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationPackage getAssociationPackage() {
		return (AssociationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AssociationPackage getPackage() {
		return AssociationPackage.eINSTANCE;
	}

} //AssociationFactoryImpl
