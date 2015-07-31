package hu.eltesoft.modelexecution.ide;

import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import hu.eltesoft.modelexecution.ide.builder.DomainRegistry;

/**
 * Monitors active EMF editors to register their domain into a registry. The
 * underlying resources will be used by translators to attach notification-based
 * model generators.
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
