package hu.eltesoft.modelexecution.m2m.logic.tasks;

public interface ModelGenerationTaskQueue {

	void add(ModelGenerationTask task);
	
	FileUpdateTaskQueue translateAll();
	
}
