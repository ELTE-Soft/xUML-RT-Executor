package hu.eltesoft.modelexecution.m2m.logic.registry;

import hu.eltesoft.modelexecution.m2m.logic.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.UpdateSourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2t.java.Template;

import org.eclipse.uml2.uml.NamedElement;

/**
 * A task to generate a translation model.
 */
class TranslationTask<UML extends NamedElement> {

	private final UML source;
	private final RootElementTranslator<UML, ?, ?> builder;

	public TranslationTask(UML source, RootElementTranslator<UML, ?, ?> builder) {
		this.source = source;
		this.builder = builder;
	}

	/**
	 * Performs the model generation this task was created for.
	 * 
	 * @return a source code update task to perform the required updates in the
	 *         textual representation of the original model
	 * @throws GenerationException
	 *             if a generation error occurred, due to an inconsistent model
	 *             or a missing source object
	 */
	public UpdateSourceCodeTask perform() throws GenerationException {
		Template template = builder.getTemplate(source);
		return new UpdateSourceCodeTask(template);
	}
}
