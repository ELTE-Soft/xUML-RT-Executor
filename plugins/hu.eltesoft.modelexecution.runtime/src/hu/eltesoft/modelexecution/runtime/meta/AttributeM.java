package hu.eltesoft.modelexecution.runtime.meta;

public class AttributeM {

	private String name;
	private String identifier;
	private VisibilityM visibility;

	public AttributeM(String name, String identifier, VisibilityM visibility) {
		super();
		this.name = name;
		this.visibility = visibility;
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public String getIdentifier() {
		return identifier;
	}

	public VisibilityM getVisibility() {
		return visibility;
	}

}
