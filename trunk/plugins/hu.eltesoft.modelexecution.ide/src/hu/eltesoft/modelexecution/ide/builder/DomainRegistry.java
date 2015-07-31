package hu.eltesoft.modelexecution.ide.builder;

import java.util.ConcurrentModificationException;
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
 * Holds editing domains for resource sets. It maintains the translation
 * registry for resources in the managed domains.
 */
public class DomainRegistry {

	public static final DomainRegistry INSTANCE = new DomainRegistry();

	private final Map<ResourceSet, TransactionalEditingDomain> domains = new HashMap<>();
	private final Map<TransactionalEditingDomain, DomainResourceListener> listeners = new HashMap<>();

	protected DomainRegistry() {
	}

	public synchronized void editingDomainLoaded(
			TransactionalEditingDomain domain) {
		ResourceSet resourceSet = domain.getResourceSet();
		domains.put(resourceSet, domain);

		DomainResourceListener listener = new DomainResourceListener();
		listeners.put(domain, listener);
		domain.addResourceSetListener(listener);

		// load events will not be fired for pre-loaded resources which are
		// already in the set
		loadPreloadedResources(resourceSet);
	}

	private void loadPreloadedResources(ResourceSet resourceSet) {
		boolean success = false;
		do {
			// this list can be modified concurrently, in this case, try to
			// iterate again
			try {
				for (Resource resource : resourceSet.getResources()) {
					TranslatorRegistry.INSTANCE.resourceLoaded(resource);
				}
				success = true;
			} catch (ConcurrentModificationException e) {
				// try again
			}
		} while (!success);
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

	/**
	 * Listens for resource loading and unloading events on a resource set. It
	 * is used to maintain the translation registry during the lifetime of a
	 * managed domain.
	 */
	private static class DomainResourceListener extends ResourceSetListenerImpl {

		private static final NotificationFilter FILTER = NotificationFilter.RESOURCE_LOADED
				.or(NotificationFilter.RESOURCE_UNLOADED);

		public DomainResourceListener() {
			super(FILTER);
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
