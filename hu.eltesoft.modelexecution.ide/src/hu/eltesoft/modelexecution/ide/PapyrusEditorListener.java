package hu.eltesoft.modelexecution.ide;

import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * Monitors active Papyrus editors to lock them when the models are under
 * compilation.
 */
public class PapyrusEditorListener extends ResourceSetListenerImpl {

	public static final String EDITING_DOMAIN = "hu.eltesoft.modelexecution.editingDomain";

	@Override
	public void setTarget(TransactionalEditingDomain domain) {
		TransactionalEditingDomain.Registry.INSTANCE
				.add(EDITING_DOMAIN, domain);
	}

}
