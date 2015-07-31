/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.signal.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.signal.*;

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
public class SignalFactoryImpl extends EFactoryImpl implements SignalFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SignalFactory init() {
		try {
			SignalFactory theSignalFactory = (SignalFactory)EPackage.Registry.INSTANCE.getEFactory(SignalPackage.eNS_URI);
			if (theSignalFactory != null) {
				return theSignalFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SignalFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalFactoryImpl() {
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
			case SignalPackage.SG_SIGNAL: return createSgSignal();
			case SignalPackage.SG_ATTRIBUTE: return createSgAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SgSignal createSgSignal() {
		SgSignalImpl sgSignal = new SgSignalImpl();
		return sgSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SgAttribute createSgAttribute() {
		SgAttributeImpl sgAttribute = new SgAttributeImpl();
		return sgAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalPackage getSignalPackage() {
		return (SignalPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SignalPackage getPackage() {
		return SignalPackage.eINSTANCE;
	}

} //SignalFactoryImpl
