package hu.eltesoft.modelexecution.m2m.logic.tasks;

import hu.eltesoft.modelexecution.m2m.logic.generators.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;

/**
 * A task to generate a translation model.
 * 
 * @author Gábor Ferenc Kovács
 *
 */
public class ModelGenerationTask<S extends EObject, R extends ModelRoot> {

	private final S source;
	private final Generator<S, R> generator;

	public ModelGenerationTask(S source, Generator<S, R> generator) {
		this.source = source;
		this.generator = generator;
	}

	/**
	 * Performs the model generation this task was created for.
	 * 
	 * @return A file modification task to perform the required updates in the
	 *         textual representation of the original model.
	 * @throws GenerationException
	 *             If a generation error occurred. It might be due to an
	 *             inconsistent model or a missing source object.
	 */
	public FileModificationTask<S, R> perform() throws GenerationException {
		R root = generator.generateTranslationModel(source);

		return new FileModificationTask<S, R>(root, generator);
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
		ModelGenerationTask<?, ?> other = (ModelGenerationTask<?, ?>) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

}
