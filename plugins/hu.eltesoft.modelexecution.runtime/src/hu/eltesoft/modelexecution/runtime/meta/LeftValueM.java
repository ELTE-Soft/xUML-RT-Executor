package hu.eltesoft.modelexecution.runtime.meta;

/**
 * The meta representation of a left value is something with a name. Different
 * kind of left values represent different substructures that can be examined.
 */
public abstract class LeftValueM {

	protected String name;

	public LeftValueM(String name) {
		super();
		this.name = name;
	}

	protected LeftValueM() {
		super();
	}

	public String getName() {
		return name;
	}

}