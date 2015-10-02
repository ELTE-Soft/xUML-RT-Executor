package hu.eltesoft.modelexecution.validation;

import java.util.Objects;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public class ValidationError {

	private Element element;
	private String messageFormat;
	private String name;
	private IMarker marker;

	public ValidationError(String name, String message, Element element) {
		this.name = name;
		messageFormat = message;
		this.element = element;
	}

	@Override
	public int hashCode() {
		return Objects.hash(element, messageFormat);
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ValidationError)) {
			return false;
		}
		ValidationError other = (ValidationError) obj;
		return element.equals(other.element) && messageFormat.equals(other.messageFormat);
	}

	public void show() {
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		String platformString = element.eResource().getURI().toPlatformString(true);
		IResource resource = null;
		if (platformString != null) {
			resource = workspace.findMember(platformString);
		}
		if (resource == null) {
			return;
		}
		try {
			marker = resource.createMarker(EValidator.MARKER);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			if (element instanceof NamedElement) {
				String qualifiedName = ((NamedElement) element).getQualifiedName();
				if (qualifiedName != null) {
					marker.setAttribute(IMarker.LOCATION, qualifiedName);
				}
			}
			marker.setAttribute(IMarker.MESSAGE, messageFormat);
			marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(element).toString());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void remove() {
		try {
			marker.delete();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		marker = null;
	}
}
