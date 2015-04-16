package hu.eltesoft.modelexecution.ide;

import hu.eltesoft.modelexecution.ide.project.ModelBuilder;
import hu.eltesoft.modelexecution.ide.project.BuilderListenerInterface;

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
		BuilderListenerInterface.hookupAllChangeListeners();
	}

	/**
	 * Gets the active editor.
	 */
	public static TransactionalEditingDomain getDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(PapyrusEditorListener.EDITING_DOMAIN);
	}
}