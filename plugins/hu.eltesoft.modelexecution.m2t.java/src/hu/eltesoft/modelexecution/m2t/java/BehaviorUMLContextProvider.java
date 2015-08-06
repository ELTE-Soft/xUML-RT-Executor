package hu.eltesoft.modelexecution.m2t.java;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;

import com.incquerylabs.uml.ralf.scoping.UMLContextProvider;

public class BehaviorUMLContextProvider extends UMLContextProvider {

	private final OpaqueBehavior behavior;

	public BehaviorUMLContextProvider(OpaqueBehavior behavior) {
		this.behavior = behavior;
		Set<Operation> operations = getOperationsOfClass((Class) behavior.getOwner());
		for (Operation operation : operations) {
			if (operation.getMethods().contains(behavior)) {
				setDefinedOperation(operation);
				return;
			}
		}
	}

	@Override
	protected IncQueryEngine doGetEngine() {
		ResourceSet resourceSet = behavior.eResource().getResourceSet();
		try {
			return IncQueryEngine.on(new EMFScope(resourceSet));
		} catch (IncQueryException e) {
			throw new CompilationFailedException(e);
		}
	}

	@Override
	protected EObject getContextObject() {
		return getDefinedOperation();
	}
}
