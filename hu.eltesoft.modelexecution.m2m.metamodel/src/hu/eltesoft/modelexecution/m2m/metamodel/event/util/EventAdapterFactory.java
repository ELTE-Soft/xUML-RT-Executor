/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.event.util;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject;

import hu.eltesoft.modelexecution.m2m.metamodel.event.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EventPackage
 * @generated
 */
public class EventAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EventPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventSwitch<Adapter> modelSwitch =
		new EventSwitch<Adapter>() {
			@Override
			public Adapter caseEvEvent(EvEvent object) {
				return createEvEventAdapter();
			}
			@Override
			public Adapter caseEvSignalEvent(EvSignalEvent object) {
				return createEvSignalEventAdapter();
			}
			@Override
			public Adapter caseEvSignal(EvSignal object) {
				return createEvSignalAdapter();
			}
			@Override
			public Adapter caseTranslationObject(TranslationObject object) {
				return createTranslationObjectAdapter();
			}
			@Override
			public Adapter caseModelRoot(ModelRoot object) {
				return createModelRootAdapter();
			}
			@Override
			public Adapter caseNamed(Named object) {
				return createNamedAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.EvEvent <em>Ev Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EvEvent
	 * @generated
	 */
	public Adapter createEvEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent <em>Ev Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent
	 * @generated
	 */
	public Adapter createEvSignalEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignal <em>Ev Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignal
	 * @generated
	 */
	public Adapter createEvSignalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject <em>Translation Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject
	 * @generated
	 */
	public Adapter createTranslationObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot <em>Model Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot
	 * @generated
	 */
	public Adapter createModelRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Named
	 * @generated
	 */
	public Adapter createNamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EventAdapterFactory
