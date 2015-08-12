package hu.eltesoft.modelexecution.m2t.java.behavior;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Vertex;

import com.incquerylabs.uml.ralf.scoping.UMLContextProvider;

import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException;

public class BehaviorUMLContextProvider extends UMLContextProvider {

	private final OpaqueBehavior behavior;
	private final Class context;

	public BehaviorUMLContextProvider(OpaqueBehavior behavior) {
		this.behavior = behavior;
		if (behavior.getOwner() instanceof Class) {
			context = (Class) behavior.getOwner();
			setDefinedOperation((Operation) behavior.getSpecification());
		} else if (behavior.getOwner() instanceof Vertex) {
			Vertex v = (Vertex) behavior.getOwner();
			Region r = (Region) v.getOwner();
			StateMachine sm = r.getStateMachine();
			context = (Class) sm.getOwner();
		} else {
			throw new CompilationFailedException("Unable to get context of behavior");
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
	public Class getThisType() {
		if (null != getDefinedOperation()) {
			return super.getThisType();
		}
		return context;
	}

	@Override
	protected EObject getContextObject() {
		return context;
	}
}
