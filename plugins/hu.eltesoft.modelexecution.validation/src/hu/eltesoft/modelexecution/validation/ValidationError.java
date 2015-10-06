package hu.eltesoft.modelexecution.validation;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.uml2.uml.NamedElement;

public class ValidationError {

	public enum Severity {
		INFO(IMarker.SEVERITY_INFO), WARNING(IMarker.SEVERITY_WARNING), ERROR(IMarker.SEVERITY_ERROR);
		private int severityCode;

		private Severity(int severityCode) {
			this.severityCode = severityCode;
		}

		public int getSeverityCode() {
			return severityCode;
		}
	}

	final private Matcher matcher;

	private List<EObject> elements;
	private String messageFormat;
	private IMarker marker;
	private Severity severity;
	private IPatternMatch match;

	public ValidationError(IPatternMatch match, Severity severity, String message, List<EObject> elements) {
		this.match = match;
		matcher = ValidationRule.KEY_PATTERN.matcher(message);
		this.severity = severity;
		messageFormat = message;
		this.elements = elements;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elements, messageFormat);
	}

	private String formatMessage() {
		matcher.reset();
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String k = matcher.group(1);
			Object obj = match.get(k);
			String v;
			if (obj instanceof NamedElement) {
				v = ((NamedElement) obj).getQualifiedName();
			} else {
				v = obj.toString();
			}
			matcher.appendReplacement(sb, Matcher.quoteReplacement(v));
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ValidationError)) {
			return false;
		}
		ValidationError other = (ValidationError) obj;
		return elements.equals(other.elements) && messageFormat.equals(other.messageFormat);
	}

	public void show() {
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		String platformString = elements.get(0).eResource().getURI().toPlatformString(true);
		IResource resource = null;
		if (platformString != null) {
			resource = workspace.findMember(platformString);
		}
		if (resource == null) {
			return;
		}
		for (EObject element : elements) {
			markElement(resource, element);
		}
	}

	private void markElement(IResource resource, EObject element) {
		try {
			String uriString = EcoreUtil.getURI(element).toString();
			String patternName = match.specification().getFullyQualifiedName();
			IMarker existing = getMarker(resource, uriString, patternName);
			if (existing != null) {
				return;
			}
			marker = resource.createMarker(EValidator.MARKER);
			marker.setAttribute(IMarker.SEVERITY, severity.getSeverityCode());
			marker.setAttribute(ValidationRule.PATTERN_NAME, patternName);
			if (element instanceof NamedElement) {
				String qualifiedName = ((NamedElement) element).getQualifiedName();
				if (qualifiedName != null) {
					marker.setAttribute(IMarker.LOCATION, qualifiedName);
				}
			}
			marker.setAttribute(IMarker.MESSAGE, formatMessage());
			marker.setAttribute(EValidator.URI_ATTRIBUTE, uriString);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public static IMarker getMarker(IResource resource, String uriString, String patternName) throws CoreException {
		IMarker[] existingMarkers = resource.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
		for (IMarker existing : existingMarkers) {
			if (uriString.equals(existing.getAttribute(EValidator.URI_ATTRIBUTE, ""))
					&& patternName.equals(existing.getAttribute(ValidationRule.PATTERN_NAME, ""))) {
				return existing;
			}
		}
		return null;
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
