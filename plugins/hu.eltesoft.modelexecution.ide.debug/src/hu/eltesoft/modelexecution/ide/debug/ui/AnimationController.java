package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.MokaConstants;

/**
 * Manages highlighting states and transitions for animation and when suspended
 * at a breakpoint by putting animation and suspended markers on model elements.
 * 
 * Only one suspended marker can be placed on the model at any time, but each
 * state machine instance has its own animation marker.
 */
public class AnimationController extends MokaAnimationBase {

	private int animationTimeMultiplier;

	/*
	 * Access to these fields is guarded by the synchronized keyword on the
	 * marker setter and removal methods below.
	 */
	private EObject lastSuspended;

	private Map<Object, EObject> lastAnimated = new HashMap<>();

	private final Timer animationTimer = new Timer();
	private TimerTask lastAnimationEndTask;

	public AnimationController(int xumlRTDelay) {
		animationTimeMultiplier = xumlRTDelay;

		CustomAnimationUtils.init();
	}

	public boolean getAnimate() {
		// return the constant from the UI every time
		return MokaConstants.MOKA_AUTOMATIC_ANIMATION;
	}

	public void startAnimationTimer(TimerTask animationEndTask) {
		cancelAnimationTimer();

		// we need to get the constant every time from the UI
		long ms = animationTimeMultiplier * MokaConstants.MOKA_ANIMATION_DELAY;

		if (ms <= 0) {
			// run the task immediately in the same thread
			animationEndTask.run();
		} else {
			lastAnimationEndTask = animationEndTask;
			animationTimer.schedule(lastAnimationEndTask, ms);
		}
	}

	public void cancelAnimationTimer() {
		if (null != lastAnimationEndTask) {
			lastAnimationEndTask.cancel();
			lastAnimationEndTask = null;
		}
	}

	/**
	 * Execute the currently scheduled timer task immediately.
	 */
	public void fireAnimationTimer() {
		if (null != lastAnimationEndTask) {
			lastAnimationEndTask.cancel();
			lastAnimationEndTask.run();
			lastAnimationEndTask = null;
		}
	}

	public synchronized void setAnimationMarker(EObject modelElement, Object group) {
		EObject animated = lastAnimated.get(group);
		if (null != animated) {
			UTILS.removeAnimationMarker(animated);
		}
		animated = CustomAnimationUtils.resolve(modelElement);
		lastAnimated.put(group, animated);
		UTILS.addAnimationMarker(animated);
	}

	public synchronized void removeAnimationMarker(Object group) {
		EObject animated = lastAnimated.remove(group);
		if (null != animated) {
			UTILS.removeAnimationMarker(animated);
		}
	}

	public synchronized void removeAnimationMarkers() {
		for (EObject animated : lastAnimated.values()) {
			UTILS.removeAnimationMarker(animated);
		}
		lastAnimated.clear();
	}

	public synchronized void setSuspendedMarker(EObject modelElement) {
		removeSuspendedMarker();
		lastSuspended = CustomAnimationUtils.resolve(modelElement);
		UTILS.addSuspendedMarker(lastSuspended);
		openContainingDiagram(modelElement);
	}

	public synchronized EObject removeSuspendedMarker() {
		EObject removed = null;
		if (null != lastSuspended) {
			UTILS.removeSuspendedMarker(null);
			removed = lastSuspended;
			lastSuspended = null;
		}
		return removed;
	}

	public void removeAllMarkers() {
		removeAnimationMarkers();
		removeSuspendedMarker();
	}
}
