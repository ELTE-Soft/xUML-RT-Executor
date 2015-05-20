package hu.eltesoft.modelexecution.ide.debug.ui;

import hu.eltesoft.modelexecution.ide.debug.LaunchConfigReader;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;

public class AnimationController {

	private static final AnimationUtils UTILS = AnimationUtils.getInstance();

	private int animationTimeMultiplier;

	/**
	 * Access to these fields is guarded by the synchronized keyword on the
	 * marker setter and removal methods below.
	 */
	private EObject lastAnimated, lastSuspended;

	private final Timer animationTimer = new Timer();
	private TimerTask lastAnimationEndTask;

	public AnimationController(LaunchConfigReader configReader) {
		animationTimeMultiplier = configReader.getAnimationTimerMultiplier();

		AnimationUtils.init();
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

	public synchronized void setAnimationMarker(EObject modelElement) {
		removeAllMarkers();
		lastAnimated = AnimationUtils.resolve(modelElement);
		UTILS.addAnimationMarker(lastAnimated);
	}

	public synchronized void removeAnimationMarker() {
		if (null != lastAnimated) {
			UTILS.removeAnimationMarker(lastAnimated);
			lastAnimated = null;
		}
	}

	public synchronized void setSuspendedMarker(EObject modelElement) {
		removeAllMarkers();
		lastSuspended = AnimationUtils.resolve(modelElement);
		UTILS.addSuspendedMarker(lastSuspended);
	}

	public synchronized void removeSuspendedMarker() {
		if (null != lastSuspended) {
			UTILS.removeSuspendedMarker(null);
			lastSuspended = null;
		}
	}

	public void removeAllMarkers() {
		removeAnimationMarker();
		removeSuspendedMarker();
	}
}
