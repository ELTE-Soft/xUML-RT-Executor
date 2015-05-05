package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.IdePlugin;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;

public class AnimationController {

	private boolean animate;
	private int animationTimeMultiplier;

	private EObject lastAnimated;
	private EObject lastSuspended;

	public AnimationController(LaunchConfigReader configReader) {
		animate = configReader.getAnimate();
		animationTimeMultiplier = configReader.getAnimationTimerMultiplier();

		AnimationUtils.init();
	}

	public boolean getAnimate() {
		return MokaConstants.MOKA_AUTOMATIC_ANIMATION;
	}

	public void suspendForAnimation() {
		if (!animate) {
			return;
		}

		// we need to get the constant every time from the UI
		long ms = animationTimeMultiplier * MokaConstants.MOKA_ANIMATION_DELAY;
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			IdePlugin.logError("Debugger interrupted during animation", e);
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
			// TODO: it is maybe incorrect to pass null here
			AnimationUtils.getInstance().removeSuspendedMarker(null);
			lastSuspended = null;
		}
	}

	public void removeAllMarkers() {
		removeAnimationMarker();
		removeSuspendedMarker();
	}
}
