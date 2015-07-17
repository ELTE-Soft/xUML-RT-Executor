/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.TranslationObjectImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rg State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgStateImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgStateImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgStateImpl#getExit <em>Exit</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgStateImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgStateImpl#isIsFinal <em>Is Final</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RgStateImpl extends TranslationObjectImpl implements RgState {
	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final NamedReference REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected NamedReference reference = REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntry() <em>Entry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected static final NamedReference ENTRY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected NamedReference entry = ENTRY_EDEFAULT;

	/**
	 * The default value of the '{@link #getExit() <em>Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExit()
	 * @generated
	 * @ordered
	 */
	protected static final NamedReference EXIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExit() <em>Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExit()
	 * @generated
	 * @ordered
	 */
	protected NamedReference exit = EXIT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<RgTransition> transitions;

	/**
	 * The default value of the '{@link #isIsFinal() <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_FINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsFinal() <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFinal()
	 * @generated
	 * @ordered
	 */
	protected boolean isFinal = IS_FINAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RgStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RegionPackage.Literals.RG_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedReference getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(NamedReference newReference) {
		NamedReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_STATE__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedReference getEntry() {
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntry(NamedReference newEntry) {
		NamedReference oldEntry = entry;
		entry = newEntry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_STATE__ENTRY, oldEntry, entry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedReference getExit() {
		return exit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExit(NamedReference newExit) {
		NamedReference oldExit = exit;
		exit = newExit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_STATE__EXIT, oldExit, exit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RgTransition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectResolvingEList<RgTransition>(RgTransition.class, this, RegionPackage.RG_STATE__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFinal() {
		return isFinal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFinal(boolean newIsFinal) {
		boolean oldIsFinal = isFinal;
		isFinal = newIsFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionPackage.RG_STATE__IS_FINAL, oldIsFinal, isFinal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RegionPackage.RG_STATE__REFERENCE:
				return getReference();
			case RegionPackage.RG_STATE__ENTRY:
				return getEntry();
			case RegionPackage.RG_STATE__EXIT:
				return getExit();
			case RegionPackage.RG_STATE__TRANSITIONS:
				return getTransitions();
			case RegionPackage.RG_STATE__IS_FINAL:
				return isIsFinal();
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
			case RegionPackage.RG_STATE__REFERENCE:
				setReference((NamedReference)newValue);
				return;
			case RegionPackage.RG_STATE__ENTRY:
				setEntry((NamedReference)newValue);
				return;
			case RegionPackage.RG_STATE__EXIT:
				setExit((NamedReference)newValue);
				return;
			case RegionPackage.RG_STATE__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends RgTransition>)newValue);
				return;
			case RegionPackage.RG_STATE__IS_FINAL:
				setIsFinal((Boolean)newValue);
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
			case RegionPackage.RG_STATE__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case RegionPackage.RG_STATE__ENTRY:
				setEntry(ENTRY_EDEFAULT);
				return;
			case RegionPackage.RG_STATE__EXIT:
				setExit(EXIT_EDEFAULT);
				return;
			case RegionPackage.RG_STATE__TRANSITIONS:
				getTransitions().clear();
				return;
			case RegionPackage.RG_STATE__IS_FINAL:
				setIsFinal(IS_FINAL_EDEFAULT);
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
			case RegionPackage.RG_STATE__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case RegionPackage.RG_STATE__ENTRY:
				return ENTRY_EDEFAULT == null ? entry != null : !ENTRY_EDEFAULT.equals(entry);
			case RegionPackage.RG_STATE__EXIT:
				return EXIT_EDEFAULT == null ? exit != null : !EXIT_EDEFAULT.equals(exit);
			case RegionPackage.RG_STATE__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case RegionPackage.RG_STATE__IS_FINAL:
				return isFinal != IS_FINAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (reference: ");
		result.append(reference);
		result.append(", entry: ");
		result.append(entry);
		result.append(", exit: ");
		result.append(exit);
		result.append(", isFinal: ");
		result.append(isFinal);
		result.append(')');
		return result.toString();
	}

} //RgStateImpl
