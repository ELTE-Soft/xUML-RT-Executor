package hu.eltesoft.modelexecution.m2m.logic.registry;

import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.m2m.logic.UpdateSourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2t.java.GenerationException;
import hu.eltesoft.modelexecution.m2t.java.Template;

/**
 * A task to generate a translation model.
 */
class TranslationTask<UML extends NamedElement> {

	private final UML source;
	private final RootElementTranslator<UML, ?, ?> translator;

	public TranslationTask(UML source, RootElementTranslator<UML, ?, ?> translator) {
		this.source = source;
		this.translator = translator;
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
		String rootName = translator.getRootName(source);
		Template template = translator.getTemplate(source);
		return new UpdateSourceCodeTask(rootName, template);
	}

	@Override
	public String toString() {
		return super.toString() + "( source: " + source + ", translator: " + translator + ")";
	}
}
