package hu.eltesoft.modelexecution.m2m.logic.tasks;

import hu.eltesoft.modelexecution.m2m.logic.generators.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;
import hu.eltesoft.modelexecution.m2t.java.Template;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * A task to generate a translation model.
 */
public class ModelGenerationTask<S extends EObject> {

	private final S source;
	private final Generator<S> generator;

	public ModelGenerationTask(S source, Generator<S> generator) {
		this.source = source;
		this.generator = generator;
	}

	/**
	 * Performs the model generation this task was created for.
	 * 
	 * @return a file modification task to perform the required updates in the
	 *         textual representation of the original model
	 * @throws GenerationException
	 *             if a generation error occurred. It might be due to an
	 *             inconsistent model or a missing source object
	 */
	public FileModificationTask perform() throws GenerationException {
		Pair<String, Template> result = generator.getTemplate(source);
		return new FileModificationTask(result.getKey(), result.getValue());
	}

	@Override
	public int hashCode() {
		return (source == null) ? 0 : source.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelGenerationTask<?> other = (ModelGenerationTask<?>) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
}
