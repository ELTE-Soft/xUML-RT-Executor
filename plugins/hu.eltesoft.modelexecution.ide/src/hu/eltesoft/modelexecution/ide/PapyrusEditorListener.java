package hu.eltesoft.modelexecution.ide;

import hu.eltesoft.modelexecution.ide.builder.EMFResourceRegistry;

import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * Monitors active Papyrus editors to access their resources and lock them when
 * the models are under compilation.
 */
public class PapyrusEditorListener extends ResourceSetListenerImpl {

	@Override
	public void setTarget(TransactionalEditingDomain domain) {
		super.setTarget(domain);
		EMFResourceRegistry.editingDomainLoaded(domain);
	}

	@Override
	public void unsetTarget(TransactionalEditingDomain domain) {
		EMFResourceRegistry.editingDomainUnloaded(domain);
		super.unsetTarget(domain);
	}
}
