package hu.eltesoft.modelexecution.runtime.meta;

public class OwnerMeta extends VariableMeta {

	public OwnerMeta(String name) {
		super(name);
	}

	@Override
	public boolean isSingle() {
		return true;
	}

}
