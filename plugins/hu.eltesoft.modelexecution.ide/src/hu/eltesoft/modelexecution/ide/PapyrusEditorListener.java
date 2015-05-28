package hu.eltesoft.modelexecution.ide;

import hu.eltesoft.modelexecution.ide.builder.DomainRegistry;

import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * Monitors active Papyrus editors to register their domain and resource set
 * into the EMF resource registry. These resources will be used by translators
 * to attach notification-based model generators.
 */
public class PapyrusEditorListener extends ResourceSetListenerImpl {

	@Override
	public void setTarget(TransactionalEditingDomain domain) {
		super.setTarget(domain);
		DomainRegistry.INSTANCE.editingDomainLoaded(domain);
	}

	@Override
	public void unsetTarget(TransactionalEditingDomain domain) {
		DomainRegistry.INSTANCE.editingDomainUnloaded(domain);
		super.unsetTarget(domain);
	}
}
