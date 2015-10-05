package hu.eltesoft.modelexecution.validation.utils;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
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
				return !"pathmap".equals(((EObject) object).eResource().getURI().scheme());
			}
		}
		return true;
	}

}
