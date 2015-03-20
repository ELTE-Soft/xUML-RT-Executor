package hu.eltesoft.modelexecution.m2m.logic.tasks;

public interface UniqueQueue<E> {

	void addUniquely(E element);
	
	void add(E element);
	
	E take();
	
}
