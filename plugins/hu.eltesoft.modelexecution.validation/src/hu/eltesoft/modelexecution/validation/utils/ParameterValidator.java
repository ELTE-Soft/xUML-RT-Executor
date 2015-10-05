package hu.eltesoft.modelexecution.validation.utils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Parameter;

public class ParameterValidator extends BaseValidator {

	public ParameterValidator(Collection<String> marked) {
		super(marked);
	}

	@Override
	public boolean check(IPatternMatch match) {
		if (!super.check(match)) {
			return false;
		}
		List<Parameter> parameters1 = getParameters((Element) match.get(0));
		List<Parameter> parameters2 = getParameters((Element) match.get(1));
		if (parameters1.size() != parameters2.size()) {
			return true;
		}
		for (int i = 0; i < parameters1.size(); i++) {
			Parameter param1 = parameters1.get(i);
			Parameter param2 = parameters2.get(i);
			if (!param1.getType().equals(param2.getType())) {
				return true;
			}
			if (!param1.getDirection().equals(param2.getDirection())) {
				return true;
			}
			if (param1.getLower() != param2.getLower()) {
				return true;
			}
			if (param1.getUpper() != param2.getUpper()) {
				return true;
			}
		}
		return false;
	}
	
	List<Parameter> getParameters(Element element) {
		if (element instanceof BehavioralFeature) {
			return ((BehavioralFeature) element).getOwnedParameters();
		}
		List<Parameter> ret = new LinkedList<>();
		for (Element subElem : element.allOwnedElements()) {
			if (subElem instanceof Parameter) {
				ret.add((Parameter) subElem);
			}
		}
		return ret;
	}

}
