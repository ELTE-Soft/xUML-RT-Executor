package hu.eltesoft.modelexecution.runtime.meta;

/**
 * The meta representation of a left value is something with a name. Different
 * kind of left values represent different substructures that can be examined.
 */
public abstract class VariableMeta {

	protected String name;

	public VariableMeta(String name) {
		this.name = name;
	}

	protected VariableMeta() {
		super();
	}

	public String getName() {
		return name;
	}

}