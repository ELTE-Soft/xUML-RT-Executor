package hu.eltesoft.modelexecution.runtime.meta;

import java.util.LinkedList;
import java.util.List;

public class ClassM {

	private AttributeM[] attributes;
	private ClassM[] parents;

	public String[] allAttributeIdentifiers() {
		List<String> ret = new LinkedList<>();
		for (AttributeM attributeM : attributes) {
			ret.add(attributeM.getIdentifier());
		}
		return ret.toArray(new String[ret.size()]);
	}

	public ClassM(ClassM[] parents, AttributeM[] attributes) {
		super();
		this.attributes = attributes;
		this.parents = parents;
	}

	public AttributeM[] getAttributes() {
		return attributes;
	}

	public ClassM[] getParents() {
		return parents;
	}

}
