package hu.eltesoft.modelexecution.m2m.logic.tasks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A reversible task which is composed of multiple reversible tasks.
 */
public class CompositeReversibleTask implements ReversibleTask {

	private final List<ReversibleTask> subtasks;

	public CompositeReversibleTask(ReversibleTask... subtasks) {
		this.subtasks = new LinkedList<>(Arrays.asList(subtasks));
	}

	public void add(ReversibleTask subtask) {
		subtasks.add(subtask);
	}

	/**
	 * Reverts all the subtasks at once. Returns true only when the reversion of
	 * all subtasks is succeeded.
	 */
	@Override
	public boolean revert() {
		boolean success = true;
		for (ReversibleTask subtask : subtasks) {
			success &= subtask.revert();
		}
		return success;
	}
}
