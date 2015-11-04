package hu.eltesoft.modelexecution.validation.utils;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.incquery.runtime.api.IPatternMatch;

public class IndexChecked extends BaseValidator {

	public IndexChecked(Collection<String> markedElements) {
		super(markedElements);
	}
	
	@Override
	public boolean check(IPatternMatch match) {
		if (!super.check(match)) {
			return false;
		}
		EObject m0 = (EObject) match.get(0);		
		EObject m1 = (EObject) match.get(1);	
		return indexOf(m0) == indexOf(m1);
	}

	private int indexOf(EObject elem) {
		EStructuralFeature containingFeature = elem.eContainingFeature();
		EObject eContainer = elem.eContainer();
		if (eContainer == null) {
			return 0;
		}
		Object featureContent = eContainer.eGet(containingFeature);
		if (featureContent instanceof List<?>) {
			return ((List<?>) featureContent).indexOf(elem);
		} else {
			return 0;
		}
	}
	
}
