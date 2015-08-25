package hu.eltesoft.modelexecution.ide;

import org.eclipse.papyrus.infra.core.resource.IModelSetSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

import hu.eltesoft.modelexecution.ide.builder.TranslatorRegistry;

public class ModelSetListener implements IModelSetSnippet {

	@Override
	public void start(ModelSet modelSet) {
		TranslatorRegistry.INSTANCE.modelSetLoaded(modelSet);
	}

	@Override
	public void dispose(ModelSet modelSet) {
		TranslatorRegistry.INSTANCE.modelSetUnloaded(modelSet);
	}

}