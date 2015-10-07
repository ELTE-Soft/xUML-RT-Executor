package hu.eltesoft.modelexecution.validation.utils;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IPatternMatch;

public class BaseValidator {

	private Collection<String> marked;

	public BaseValidator(Collection<String> markedElements) {
		this.marked = markedElements;
	}

	public boolean check(IPatternMatch match) {
		for (String mark : marked) {
			Object object = match.get(mark);
			if (object instanceof EObject) {
				Resource eResource = ((EObject) object).eResource();
				if (eResource != null) {
					URI uri = eResource.getURI();
					if (uri != null) {
						return !"pathmap".equals(uri.scheme());
					}
				}
			}
		}
		return true;
	}

}
