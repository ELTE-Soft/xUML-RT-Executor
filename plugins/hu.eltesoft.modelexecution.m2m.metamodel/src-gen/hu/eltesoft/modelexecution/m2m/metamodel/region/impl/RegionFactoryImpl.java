/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.region.*;

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
public class RegionFactoryImpl extends EFactoryImpl implements RegionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RegionFactory init() {
		try {
			RegionFactory theRegionFactory = (RegionFactory)EPackage.Registry.INSTANCE.getEFactory(RegionPackage.eNS_URI);
			if (theRegionFactory != null) {
				return theRegionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RegionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionFactoryImpl() {
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
			case RegionPackage.RG_REGION: return createRgRegion();
			case RegionPackage.RG_CLASS: return createRgClass();
			case RegionPackage.RG_INITIAL_PSEUDOSTATE: return createRgInitialPseudostate();
			case RegionPackage.RG_STATE: return createRgState();
			case RegionPackage.RG_TRANSITION: return createRgTransition();
			case RegionPackage.RG_MESSAGE: return createRgMessage();
			case RegionPackage.RG_BEHAVIOR: return createRgBehavior();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgRegion createRgRegion() {
		RgRegionImpl rgRegion = new RgRegionImpl();
		return rgRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgClass createRgClass() {
		RgClassImpl rgClass = new RgClassImpl();
		return rgClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgInitialPseudostate createRgInitialPseudostate() {
		RgInitialPseudostateImpl rgInitialPseudostate = new RgInitialPseudostateImpl();
		return rgInitialPseudostate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgState createRgState() {
		RgStateImpl rgState = new RgStateImpl();
		return rgState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgTransition createRgTransition() {
		RgTransitionImpl rgTransition = new RgTransitionImpl();
		return rgTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgMessage createRgMessage() {
		RgMessageImpl rgMessage = new RgMessageImpl();
		return rgMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RgBehavior createRgBehavior() {
		RgBehaviorImpl rgBehavior = new RgBehaviorImpl();
		return rgBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionPackage getRegionPackage() {
		return (RegionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RegionPackage getPackage() {
		return RegionPackage.eINSTANCE;
	}

} //RegionFactoryImpl
