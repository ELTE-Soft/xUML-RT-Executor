package hu.eltesoft.modelexecution.ide.builder;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * 
 */
public class DomainRegistry {

	private static final NotificationFilter filter = NotificationFilter.RESOURCE_LOADED
			.or(NotificationFilter.RESOURCE_UNLOADED);

	private final Map<ResourceSet, TransactionalEditingDomain> domains = new HashMap<>();
	private final Map<TransactionalEditingDomain, DomainResourceListener> listeners = new HashMap<>();

	public static final DomainRegistry INSTANCE = new DomainRegistry();

	protected DomainRegistry() {
	}

	public synchronized void editingDomainLoaded(
			TransactionalEditingDomain domain) {
		ResourceSet resourceSet = domain.getResourceSet();
		domains.put(resourceSet, domain);

		// load events will not be fired for pre-loaded resources which are
		// already in the set
		for (Resource resource : resourceSet.getResources()) {
			TranslatorRegistry.INSTANCE.resourceLoaded(resource);
		}

		DomainResourceListener listener = new DomainResourceListener();
		listeners.put(domain, listener);
		domain.addResourceSetListener(listener);
	}

	public synchronized void editingDomainUnloaded(
			TransactionalEditingDomain domain) {
		DomainResourceListener listener = listeners.get(domain);
		domain.removeResourceSetListener(listener);
		ResourceSet resourceSet = domain.getResourceSet();
		domains.remove(resourceSet);
	}

	public synchronized TransactionalEditingDomain getDomain(
			ResourceSet resourceSet) {
		return domains.get(resourceSet);
	}

	private static class DomainResourceListener extends ResourceSetListenerImpl {

		public DomainResourceListener() {
			super(filter);
		}

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			for (Notification notification : event.getNotifications()) {
				if (!(notification.getNotifier() instanceof Resource)) {
					continue;
				}

				Resource resource = (Resource) notification.getNotifier();
				if (notification.getNewBooleanValue()) {
					TranslatorRegistry.INSTANCE.resourceLoaded(resource);
				} else {
					TranslatorRegistry.INSTANCE.resourceUnloaded(resource);
				}
			}
		}
	}
}
