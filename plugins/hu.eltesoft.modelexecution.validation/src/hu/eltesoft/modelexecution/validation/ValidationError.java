package hu.eltesoft.modelexecution.validation;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.uml2.uml.Element;
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

	static final private Pattern keyPattern = 
	        Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_]*)\\}");
	final private Matcher matcher;
	
	private List<Element> elements;
	private String messageFormat;
	private IMarker marker;
	private Severity severity;
	private IPatternMatch match;

	public ValidationError(IPatternMatch match, Severity severity, String message, List<Element> elements) {
		this.match = match;
		matcher = keyPattern.matcher(message);
		this.severity = severity;
		messageFormat = message;
		this.elements = elements;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elements, messageFormat);
	}

	public String getName() {
		return match.patternName();
	}

	private String formatMessage() {
		matcher.reset();
        StringBuffer sb = new StringBuffer();
        while (matcher.find())
        {
            String k = matcher.group(1);
            String v = match.get(k).toString();
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
		for (Element element : elements) {
			try {
				marker = resource.createMarker(EValidator.MARKER);
				marker.setAttribute(IMarker.SEVERITY, severity.getSeverityCode());
				if (elements instanceof NamedElement) {
					String qualifiedName = ((NamedElement) element).getQualifiedName();
					if (qualifiedName != null) {
						marker.setAttribute(IMarker.LOCATION, qualifiedName);
					}
				}
				marker.setAttribute(IMarker.MESSAGE, formatMessage());
				marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(element).toString());
			} catch (CoreException e) {
				e.printStackTrace();
			}
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
