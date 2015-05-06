package hu.eltesoft.modelexecution.ide.debug;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;

public class AnimationController {

	private int animationTimeMultiplier;

	private EObject lastAnimated;
	private EObject lastSuspended;

	private Timer animationTimer;
	// needs to be volatile as it is accessed from the timer thread too
	private volatile TimerTask lastAnimationEndTask;

	public AnimationController(LaunchConfigReader configReader) {
		animationTimeMultiplier = configReader.getAnimationTimerMultiplier();

		AnimationUtils.init();
	}

	public boolean getAnimate() {
		// return the constant from the UI every time
		return MokaConstants.MOKA_AUTOMATIC_ANIMATION;
	}

	public void suspendForAnimation(TimerTask animationEndTask) {
		if (null != lastAnimationEndTask) {
			animationTimer.cancel();
			lastAnimationEndTask = null;
		}

		// we need to get the constant every time from the UI
		long ms = animationTimeMultiplier * MokaConstants.MOKA_ANIMATION_DELAY;
		lastAnimationEndTask = animationEndTask;
		animationTimer = new Timer();
		animationTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				if (lastAnimationEndTask != null) {
					lastAnimationEndTask.run();
					lastAnimationEndTask = null;
				}
			}
		}, ms);
	}

	public void stopSuspendingForAnimation() {
		if (null != lastAnimationEndTask) {
			animationTimer.cancel();
			lastAnimationEndTask.run();
			lastAnimationEndTask = null;
		}
	}

	public void setAnimationMarker(EObject modelElement) {
		removeAllMarkers();
		lastAnimated = AnimationUtils.resolve(modelElement);
		AnimationUtils.getInstance().addAnimationMarker(lastAnimated);
	}

	public void removeAnimationMarker() {
		if (null != lastAnimated) {
			AnimationUtils.getInstance().removeAnimationMarker(lastAnimated);
			lastAnimated = null;
		}
	}

	public void setSuspendedMarker(EObject modelElement) {
		removeAllMarkers();
		lastSuspended = AnimationUtils.resolve(modelElement);
		AnimationUtils.getInstance().addSuspendedMarker(lastSuspended);
	}

	public void removeSuspendedMarker() {
		if (null != lastSuspended) {
			AnimationUtils.getInstance().removeSuspendedMarker(null);
			lastSuspended = null;
		}
	}

	public void removeAllMarkers() {
		removeAnimationMarker();
		removeSuspendedMarker();
	}
}
