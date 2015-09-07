package hu.eltesoft.modelexecution.runtime.meta;

/**
 * An element of an attribute with multiplicity.
 */
public class IndexMeta extends VariableMeta {

	public IndexMeta(int index) {
		super(Integer.toString(index));
	}

	@Override
	public boolean isSingle() {
		return true;
	}

}
