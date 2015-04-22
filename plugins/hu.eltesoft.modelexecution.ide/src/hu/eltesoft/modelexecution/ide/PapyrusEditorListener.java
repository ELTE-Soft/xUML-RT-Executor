package hu.eltesoft.modelexecution.ide;

import hu.eltesoft.modelexecution.ide.builder.ModelBuilderListenerInterface;
import hu.eltesoft.modelexecution.ide.builder.ModelBuilder;

import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * Monitors active Papyrus editors to access their resources and lock them when
 * the models are under compilation.
 */
public class PapyrusEditorListener extends ResourceSetListenerImpl {

	public static final String EDITING_DOMAIN = "hu.eltesoft.modelexecution.editingDomain"; //$NON-NLS-1$

	@Override
	public void setTarget(TransactionalEditingDomain domain) {
		TransactionalEditingDomain.Registry.INSTANCE
				.add(EDITING_DOMAIN, domain);
		ModelBuilder.initializeBuilders();
		ModelBuilderListenerInterface.hookupAllChangeListeners();
	}

	/**
	 * Gets the active editor.
	 */
	public static TransactionalEditingDomain getDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(PapyrusEditorListener.EDITING_DOMAIN);
	}
}
