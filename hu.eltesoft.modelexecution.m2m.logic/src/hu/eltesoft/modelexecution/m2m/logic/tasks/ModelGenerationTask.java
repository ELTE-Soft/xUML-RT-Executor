package hu.eltesoft.modelexecution.m2m.logic.tasks;

public interface ModelGenerationTask {
	
	FileUpdateTask generate();
	
	@Override
	int hashCode();
	
	@Override
	boolean equals(Object obj);
}
