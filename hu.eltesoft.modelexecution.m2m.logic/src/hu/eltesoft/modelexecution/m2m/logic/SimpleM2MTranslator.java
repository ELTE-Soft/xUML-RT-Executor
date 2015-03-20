package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2m.logic.impl.SimpleM2MTranslatorImpl;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTaskQueue;

import org.eclipse.incquery.runtime.api.IncQueryEngine;

/**
 * Simple m2m translator interface, which can only translate an EMF-UML2 model
 * in whole, so has no incremental capability.
 * 
 * @author Kov�cs G�bor Ferenc
 * @see ChangeListenerM2MTranslator
 *
 */
public interface SimpleM2MTranslator {

	/**
	 * Creates a new <code>SimpleM2MTranslator</code> instance.
	 * 
	 * @param engine
	 *            IncQuery engine created on the scope of the to-be-translated
	 *            EMF-UML2.
	 * @param listener
	 *            A listener which will be informed when model changes affect
	 *            its textual representation.
	 * @return The new <code>SimpleM2MTranslator</code> instance.
	 */
	static SimpleM2MTranslator create(IncQueryEngine engine, TextChangesListener listener) {
		return new SimpleM2MTranslatorImpl(engine, listener);
	}

	/**
	 * @return The <code>IncQueryEngine</code> instance this translator was
	 *         parameterized with.
	 */
	IncQueryEngine getIncQueryEngine();

	/**
	 * Runs a full build on the model. Generates all the translation models then
	 * returns a queue of <code>FileUpdateTask</code> objects which make the
	 * required changes in the textual representation when performed.
	 * 
	 * @return The queue of tasks to be performed to update all files. Only
	 *         contains modification tasks.
	 */
	FileUpdateTaskQueue fullBuild();

}
