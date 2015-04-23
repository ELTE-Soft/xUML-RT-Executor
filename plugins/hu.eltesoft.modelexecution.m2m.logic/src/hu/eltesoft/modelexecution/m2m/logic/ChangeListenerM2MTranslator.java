package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2m.logic.impl.ChangeListenerM2MTranslatorImpl;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Incremental m2m translator interface, which can translate an EMF-UML2 model
 * in a whole but also listens to model changes and can do the translation
 * incrementally based on them.
 * <p>
 * As it should be created and called on the same thread on which the EMF-UML2
 * model is created and managed, the implementations of this interface are
 * <b><i>not</i></b> thread-safe.
 * 
 * @see SimpleM2MTranslator
 *
 */
public interface ChangeListenerM2MTranslator extends SimpleM2MTranslator {

	/**
	 * Creates a new <code>ChangeListenerM2MTranslator</code> instance.
	 * 
	 * @param engine
	 *            IncQuery engine created on the scope of the to-be-translated
	 *            model
	 * @param listener
	 *            a listener which will be informed when model changes affect
	 *            its textual representation
	 * @return the new <code>ChangeListenerM2MTranslator</code> instance
	 * @throws IncQueryException
	 *             if an error occurs during pattern matcher creation
	 */
	static ChangeListenerM2MTranslator create(IncQueryEngine engine,
			TextChangesListener listener) throws IncQueryException {
		return new ChangeListenerM2MTranslatorImpl(engine, listener);
	}

	/**
	 * Runs a full build on the model, and then resets this translator's change
	 * registry, or creates it if not existed.
	 * <p>
	 * <b>Note:</b> the result only contains modification tasks, therefore
	 * previously created and now unused files will remain existing if not
	 * deleted before calling this method.
	 * 
	 * @return the queue of tasks to be performed to update all files; only
	 *         contains modification tasks
	 */
	@Override
	FileUpdateTaskQueue fullBuild();

	/**
	 * Incrementally rebuilds the model based on this translator's change
	 * registry and then resets the registry. If the change registry has not
	 * existed, calling this method equals to calling <code>fullBuild</code>.
	 * <p>
	 * It is possible that in the result queue, two update tasks refer to the
	 * same file: a deletion and a modification. However, in this case, it is
	 * guaranteed that the deletion precedes the modification in the queue.
	 * 
	 * @return the queue of tasks to be performed to update all files; may
	 *         contain modification and deletion tasks as well
	 */
	FileUpdateTaskQueue rebuild();

	/**
	 * Activates this object's listeners to model changes. If <code>force</code>
	 * is set to be <code>true</code>, this method performs even if the
	 * listeners are already active. In this case, it first inactivates, then
	 * reactivates them (as a kind of reset).
	 * 
	 * @param force
	 *            perform even if the listeners are already active
	 * @return <code>true</code> if this method invoked the activation of the
	 *         listeners (if they were not active yet or <code>force</code> was
	 *         <code>true</code>), <code>false</code> otherwise
	 */
	boolean activateListeners(boolean force);

	/**
	 * Inactivates this object's listeners to model changes.
	 * 
	 * @return <code>true</code> if this method invoked the inactivation of the
	 *         listeners (if they were not inactive yet), <code>false</code>
	 *         otherwise
	 */
	boolean inactivateListeners();
}
