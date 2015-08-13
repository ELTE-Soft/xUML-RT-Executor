package hu.eltesoft.modelexecution.runtime.base;

public abstract class Class {
	
	protected abstract String getOriginalClassName();
	
	@Override
	public String toString() {
		return getOriginalClassName();
	}

}