package hu.eltesoft.modelexecution.m2m.logic.interfaces;

import org.eclipse.emf.ecore.EObject;

import hu.eltesoft.modelexecution.m2m.logic.impl.ChangeRegistryEntryForDeletion;
import hu.eltesoft.modelexecution.m2m.logic.impl.ChangeRegistryEntryForModification;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ModelGenerationTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ModelGenerationTaskQueue;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

public interface ChangeRegistry extends ModelGenerationTaskQueue {

	public interface Entry extends ModelGenerationTask {

		Type getType();

		public enum Type {
			MODIFICATION {
				public <S extends EObject, R extends ModelRoot> ParametricEntry<S, R> createEntry() {
					return new ChangeRegistryEntryForModification<S, R>(null, null);
				}
			}, DELETION {
				public <S extends EObject, R extends ModelRoot> ParametricEntry<S, R> createEntry() {
					return new ChangeRegistryEntryForDeletion<S, R>(null, null);
				}				
			};
			
			public abstract <S extends EObject, R extends ModelRoot> ParametricEntry<S, R> createEntry();
		}

	}

	public interface ParametricEntry<S extends EObject, R extends ModelRoot> extends Entry {
	}

}
