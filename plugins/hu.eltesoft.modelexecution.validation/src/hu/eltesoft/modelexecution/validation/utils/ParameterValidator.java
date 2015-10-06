package hu.eltesoft.modelexecution.validation.utils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;

public class ParameterValidator extends BaseValidator {

	public ParameterValidator(Collection<String> marked) {
		super(marked);
	}

	@Override
	public boolean check(IPatternMatch match) {
		if (!super.check(match)) {
			return false;
		}
		List<DataElement> parameters1 = getParameters((Element) match.get(0));
		List<DataElement> parameters2 = getParameters((Element) match.get(1));
		return !parameters1.equals(parameters2);
	}

	List<DataElement> getParameters(Element element) {
		if (element instanceof BehavioralFeature) {
			return createDataElems(((BehavioralFeature) element).getOwnedParameters());
		}
		return createDataElems(element.getOwnedElements());
	}

	private List<DataElement> createDataElems(List<? extends Element> datas) {
		List<DataElement> ret = new LinkedList<>();
		for (Element data : datas) {
			DataElement create = DataElement.create(data);
			if (create != null) {
				ret.add(create);
			}
		}
		return ret;
	}

	private static class DataElement {

		public static DataElement create(Element element) {
			if (element instanceof Parameter) {
				Parameter parameter = (Parameter) element;
				return new DataElement(parameter.getName(), Optional.of(parameter.getDirection()), parameter.getLower(),
						parameter.getUpper());
			} else if (element instanceof Property) {
				Property property = (Property) element;
				return new DataElement(property.getName(), Optional.empty(), property.getLower(), property.getUpper());
			} else {
				return null;
			}
		}

		private DataElement(String name, Optional<ParameterDirectionKind> direction, int lowerBound, int upperBound) {
			this.name = name;
			this.direction = direction;
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}

		private String name;
		private Optional<ParameterDirectionKind> direction;
		private int lowerBound;
		private int upperBound;

		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof DataElement)) {
				return false;
			}
			DataElement other = (DataElement) obj;
			return name.equals(other.name) && lowerBound == other.lowerBound && upperBound == other.upperBound
					&& direction.orElse(ParameterDirectionKind.IN_LITERAL)
							.equals(other.direction.orElse(ParameterDirectionKind.IN_LITERAL));
		}

	}

}
