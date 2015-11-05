package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.markerlistener.PapyrusMarkerAdapter;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.launch.EditorUtils;
import org.eclipse.ui.IEditorPart;

/**
 * This is a modified version of the original AnimationUtils in Moka. The method
 * getDiagrams is patched to find references only in the notation resource, not
 * in the whole resource set. This improves the performance of diagram opening
 * significantly. However, when an element is only visible on a diagram which is
 * contained by a different model, then that diagram will not be found. In
 * almost all cases the elements and their diagrams are in the same model, so
 * this is not a real use case for us.
 */
public class CustomAnimationUtils {

	/**
	 * The static instance for this class
	 */
	protected static CustomAnimationUtils eInstance = null;

	/**
	 * An EObject -> 'Suspended' marker map
	 */
	protected static Map<EObject, IPapyrusMarker> eObjectToSuspendedMarker = new ConcurrentHashMap<EObject, IPapyrusMarker>();

	/**
	 * An EObject -> 'Animation' marker map
	 */
	protected static Map<EObject, IPapyrusMarker> eObjectToAnimationMarker = new ConcurrentHashMap<EObject, IPapyrusMarker>();

	/**
	 * An EObject -> List<Diagram> map
	 */
	protected static Map<EObject, List<Diagram>> eObjectToDiagrams = new ConcurrentHashMap<EObject, List<Diagram>>();

	private CustomAnimationUtils() {

	}

	public static void init() {
		// Reinitializes hash maps
		eObjectToAnimationMarker = new ConcurrentHashMap<EObject, IPapyrusMarker>();
		eObjectToSuspendedMarker = new ConcurrentHashMap<EObject, IPapyrusMarker>();
		eObjectToDiagrams = new ConcurrentHashMap<EObject, List<Diagram>>();
	}

	public static void init(EObject eobject) {
		init();
		getInstance().getDiagrams(eobject);
	}

	/**
	 * Typically called on engine termination. This methods removes all markers
	 * used to enable semantic elements animation at runtime
	 */
	public synchronized void removeAllAnimationMarker() {
		for (EObject animatedObject : eObjectToAnimationMarker.keySet()) {
			this.removeAnimationMarker(animatedObject);
		}
	}

	/**
	 * Returns an instance of DiagramUtils. Guarantees that DiagramUtils is
	 * instantiated only once.
	 *
	 * @return An instance of DiagramUtils
	 */
	public static CustomAnimationUtils getInstance() {
		if (eInstance == null) {
			eInstance = new CustomAnimationUtils();
		}
		return eInstance;
	}

	/**
	 * Retrieves all diagrams in which the given model element has a graphical
	 * representation
	 *
	 * @param modelElement
	 *            The model element for which diagrams where it appears have to
	 *            be retrieved
	 * @return all diagrams in which the given model element has a graphical
	 *         representation
	 */
	public synchronized List<Diagram> getDiagrams(EObject modelElement) {
		List<Diagram> matchingDiagrams = eObjectToDiagrams.get(modelElement);
		if (matchingDiagrams != null) {
			return matchingDiagrams;
		}

		Resource resource = modelElement.eResource();
		if (!resource.getURI().isPlatformResource()) {
			matchingDiagrams = new ArrayList<Diagram>();
			eObjectToDiagrams.put(modelElement, new ArrayList<Diagram>());
			return matchingDiagrams;
		}
		ResourceSet resourceSet = resource.getResourceSet();

		final String resourceNotationURI = modelElement.eResource().getURI().toString().replaceAll("\\.uml$",
				".notation");
		Resource notationResource = resourceSet.getResource(URI.createURI(resourceNotationURI), true);
		List<EObject> matchingObjects = new ArrayList<EObject>();
		matchingObjects.add(modelElement);

		Map<EObject, Collection<Setting>> maps = EcoreUtil.UsageCrossReferencer.findAll(matchingObjects,
				notationResource);
		matchingDiagrams = new ArrayList<Diagram>();

		for (Object key : maps.keySet()) {
			for (Setting setting : maps.get(key)) {
				if (setting.getEObject() instanceof View) {
					Diagram diagram = ((View) setting.getEObject()).getDiagram();
					if (!matchingDiagrams.contains(diagram)) {
						matchingDiagrams.add(diagram);
					}
					// For optimization purposes,
					// Add mapping entries for other semantic elements
					// having a representation in this diagram
					for (Iterator<EObject> i = diagram.eAllContents(); i.hasNext();) {
						EObject cddView = i.next();
						if (cddView instanceof View) {
							EObject element = ((View) cddView).getElement();
							if (element != modelElement && element != null) {
								List<Diagram> diags = eObjectToDiagrams.get(element);
								if (diags == null) {
									diags = new ArrayList<Diagram>();
								} else if (!diags.contains(diagram)) {
									diags.add(diagram);
								}
								eObjectToDiagrams.put(element, diags);
							}
						}
					}
				}
			}
		}

		eObjectToDiagrams.put(modelElement, matchingDiagrams);

		return matchingDiagrams;
	}

	/**
	 * Returns true if some diagrams with graphical representation of the given
	 * model element exist, false otherwise
	 *
	 * @param modelElement
	 * @return true if some diagrams with graphical representation of the given
	 *         model element exist, false otherwise
	 */
	public boolean diagramsExistFor(EObject modelElement) {
		return !this.getDiagrams(modelElement).isEmpty();
	}

	/**
	 * In the case where the list of diagrams for the given modelElement has
	 * already been retrieved, resets this list
	 *
	 * @param modelElement
	 *            The model element for which the list of diagrams has to be
	 *            reset
	 */
	public void resetDiagrams(EObject modelElement) {
		eObjectToDiagrams.remove(modelElement);
	}

	/**
	 * Opens the given diagram (or puts focus on diagram if this diagram is
	 * already opened) in the current active papyrus editor. By construction,
	 * the active papyrus editor is supposed to be opened with the appropriate
	 * .di file. openDiagram is called by
	 * MokaDebugModelPresentation.addAnnotations(), which is always called after
	 * MokaDebugModelPresentation.getEditorInput() is called.
	 * MokaDebugModelPresentation.getEditorInput() returns a FileEditorInput for
	 * the .di model to which the given Diagram belongs.
	 *
	 * @param diagram
	 *            The diagram to be opened.
	 */
	public void openDiagram(final Diagram diagram, boolean closeOpenedDiagrams) {
		IEditorPart part = EditorUtils.getEditorPart(diagram);
		ServicesRegistry servicesRegistry = (ServicesRegistry) part.getAdapter(ServicesRegistry.class);
		try {
			final IPageManager pageMngr = ServiceUtils.getInstance().getIPageManager(servicesRegistry);
			try {
				if (pageMngr.isOpen(diagram)) {
					pageMngr.selectPage(diagram);
				} else {
					TransactionalEditingDomain domain = (TransactionalEditingDomain) EMFHelper
							.resolveEditingDomain(diagram);
					OpenDiagramCommand updateCommand = new OpenDiagramCommand(diagram, pageMngr, domain);
					domain.getCommandStack().execute(updateCommand);
				}
			} catch (Exception e) {
				// Activator.log.error(e);
			}
		} catch (ServiceException e1) {
			// Activator.log.error(e1);
		}
	}

	/**
	 * A convenience method for retrieving the diagram edit part corresponding
	 * to a graphical editor.
	 *
	 * @return the diagram edit part corresponding to the given editor
	 */
	public RootEditPart getRootEditPart(GraphicalEditor editor) {
		return (RootEditPart) editor.getAdapter(EditPart.class);
	}

	/**
	 * Adds a "Suspended" marker to the given semantic element
	 *
	 * @param semanticElement
	 *            The semantic element to which a "Suspended" marker has to be
	 *            attached
	 * @param thread
	 *            The context thread in which this marker is attached
	 */
	public void addSuspendedMarker(EObject semanticElement) {
		if (eObjectToSuspendedMarker.get(semanticElement) != null) {
			// Marker already exists
			return;
		}
		if (semanticElement.eIsProxy()) {
			semanticElement = resolve(semanticElement);
		}
		IResource iresource = MokaBreakpoint.getIResource(semanticElement.eResource());
		try {
			if (iresource != null) {
				String uriOfSemanticElement = EcoreUtil.getURI(semanticElement).toString();
				IMarker marker = iresource.createMarker(MokaConstants.MOKA_SUSPENDED_MARKER_ID);
				marker.setAttribute(EValidator.URI_ATTRIBUTE, uriOfSemanticElement);
				eObjectToSuspendedMarker.put(semanticElement,
						PapyrusMarkerAdapter.wrap(semanticElement.eResource(), marker));
			}
		} catch (CoreException ce) {
			// Activator.log.error(ce);
		}
	}

	/**
	 * Removes the "Suspended" marker for all semantic elements suspended in the
	 * context of the given thread
	 *
	 * @param thread
	 *            The thread for which "Suspend" markers have to be removed from
	 *            suspended semantic elements
	 */
	public void removeSuspendedMarker(IThread thread) {
		for (EObject key : eObjectToSuspendedMarker.keySet()) {
			IPapyrusMarker stackFrameMarker = eObjectToSuspendedMarker.get(key);
			try {
				stackFrameMarker.delete();
			} catch (CoreException e) {
				// Activator.log.error(e);
			}
		}
		eObjectToSuspendedMarker.clear();
	}

	/**
	 * Adds an "Animation" marker to the given semantic element
	 *
	 * @param semanticElement
	 *            The semantic element to which an "Animation" marker has to be
	 *            attached
	 */
	public void addAnimationMarker(EObject semanticElement) {
		if (eObjectToAnimationMarker.get(semanticElement) != null) {
			// Marker already exists
			return;
		}
		if (semanticElement.eIsProxy()) {
			semanticElement = resolve(semanticElement);
		}
		IResource iresource = MokaBreakpoint.getIResource(semanticElement.eResource());
		try {
			if (iresource != null) {
				String uriOfSemanticElement = EcoreUtil.getURI(semanticElement).toString();
				if (MokaConstants.MOKA_OPEN_DIAGRAM_IN_AUTOMATIC_ANIMATION) {
					List<Diagram> diagrams = getDiagrams(semanticElement);
					for (Diagram d : diagrams) {
						openDiagram(d, false);
					}
				}
				IMarker marker = iresource.createMarker(MokaConstants.MOKA_ANIMATION_MARKER_ID);
				marker.setAttribute(EValidator.URI_ATTRIBUTE, uriOfSemanticElement);
				eObjectToAnimationMarker.put(semanticElement,
						PapyrusMarkerAdapter.wrap(semanticElement.eResource(), marker));
			}
		} catch (CoreException ce) {
			// Activator.log.error(ce);
		}
	}

	/**
	 * Removes the "Animation" marker associated with the given semantic
	 * element, if any
	 *
	 * @param semanticElement
	 *            The semantic element to which an "Animation" marker has to be
	 *            attached
	 */
	public void removeAnimationMarker(EObject semanticElement) {
		if (semanticElement.eIsProxy()) {
			semanticElement = resolve(semanticElement);
		}
		IPapyrusMarker animationFrameMarker = eObjectToAnimationMarker.get(semanticElement);
		if (animationFrameMarker != null) {
			try {
				animationFrameMarker.delete();
				eObjectToAnimationMarker.remove(semanticElement);
			} catch (CoreException e) {
				// Activator.log.error(e);
			}
		}
	}

	/**
	 * Resolve the given semantic element in the case where it is a proxy. This
	 * is supposed to happen only when, in the course of execution, the editor
	 * for the model being executed is closed. This may imply re-creation of a
	 * new IEditorPart.
	 *
	 * @param semanticElement
	 *            The semantic element that needs to be resolved
	 * @return the resolved semantic element
	 */
	public static EObject resolve(EObject semanticElement) {
		if (semanticElement.eIsProxy()) {
			getInstance().resetDiagrams(semanticElement);
			IEditorPart part = EditorUtils.getEditorPart(semanticElement);
			ServicesRegistry registry = (ServicesRegistry) part.getAdapter(ServicesRegistry.class);
			ResourceSet resourceSet = null;
			try {
				resourceSet = registry.getService(ModelSet.class);
			} catch (ServiceException e) {
				resourceSet = new ResourceSetImpl();
			}
			semanticElement = EcoreUtil.resolve(semanticElement, resourceSet);
		}
		return semanticElement;
	}

	public boolean isAnimationMarkerApplied(EObject element) {
		return eObjectToAnimationMarker.get(element) != null;
	}

	/**
	 * A command for opening a diagram
	 *
	 */
	protected class OpenDiagramCommand extends RecordingCommand {

		protected Diagram diagram;

		protected IPageManager pageMngr;

		/**
		 * Constructor for the OpenDiagramCommand.
		 *
		 * @param diagram
		 *            The diagram to be opened
		 * @param pageMngr
		 *            The page manager to be used for opening the diagram
		 * @param domain
		 *            The editing domain in which the command will be executed
		 */
		public OpenDiagramCommand(Diagram diagram, IPageManager pageMngr, TransactionalEditingDomain domain) {
			super(domain);
			this.diagram = diagram;
			this.pageMngr = pageMngr;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.
		 * AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.
		 * runtime.IProgressMonitor , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected void doExecute() {
			this.pageMngr.openPage(diagram);
			this.pageMngr.selectPage(diagram);
		}

	}

}
