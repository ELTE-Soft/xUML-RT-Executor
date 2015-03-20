package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2m.logic.impl.ChangeListenerM2MTranslatorImpl;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTaskQueue;

import org.eclipse.incquery.runtime.api.IncQueryEngine;

/**
 * Incremental m2m translator interface, which can translate an EMF-UML2 model
 * in a whole but also listens to model changes and based on them.
 * 
 * @author Kovács Gábor Ferenc
 * @see SimpleM2MTranslator
 *
 */
public interface ChangeListenerM2MTranslator extends SimpleM2MTranslator {

	/**
	 * Creates a new <code>ChangeListenerM2MTranslator</code> instance.
	 * 
	 * @param engine
	 *            IncQuery engine created on the scope of the to-be-translated
	 *            EMF-UML2.
	 * @param listener
	 *            A listener which will be informed when model changes affect
	 *            its textual representation.
	 * @return The new <code>ChangeListenerM2MTranslator</code> instance.
	 */
	static ChangeListenerM2MTranslator create(IncQueryEngine engine, TextChangesListener listener) {
		return new ChangeListenerM2MTranslatorImpl(engine, listener);
	}

	/**
	 * Runs a full build on the model, and then resets this object's change
	 * registry, or creates it if not existed.
	 * 
	 * @return The queue of tasks to be performed to update all files. Only
	 *         contains modification tasks.
	 */
	@Override
	FileUpdateTaskQueue fullBuild();

	/**
	 * Incrementally rebuilds the model based on this object's change registry
	 * and then resets the registry. If the change registry has not existed,
	 * calling this method equals to calling <code>fullBuild</code>.
	 * 
	 * @return The queue of tasks to be performed to update all files. May
	 *         contain modification and deletion tasks as well.
	 */
	FileUpdateTaskQueue rebuild();

}
