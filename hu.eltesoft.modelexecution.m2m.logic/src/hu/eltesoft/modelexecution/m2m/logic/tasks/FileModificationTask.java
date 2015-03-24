package hu.eltesoft.modelexecution.m2m.logic.tasks;

import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;

/**
 * An implementation of {@link FileUpdateTask} which performs the modification
 * of a single file.
 * 
 * @author Gábor Ferenc Kovács
 *
 */
public class FileModificationTask<S extends EObject, R extends ModelRoot>
		implements FileUpdateTask {

	private final R root;
	private final Generator<S, R> generator;

	public FileModificationTask(R root, Generator<S, R> generator) {
		this.root = root;
		this.generator = generator;
	}

	@Override
	public void perform() {
		generator.generateText(root);
	}

	@Override
	public int hashCode() {
		return (root == null) ? 0 : root.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileModificationTask<?, ?> other = (FileModificationTask<?, ?>) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}

}
