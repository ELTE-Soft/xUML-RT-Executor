package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehaviorMatch;
import hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehaviorMatcher;
import hu.eltesoft.modelexecution.validation.util.ClassifierBehaviorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ClassStateMachineOwnedBehaviorMatcher in a type-safe way.
 * 
 * @see ClassStateMachineOwnedBehaviorMatcher
 * @see ClassStateMachineOwnedBehaviorMatch
 * 
 */
@SuppressWarnings("all")
public final class ClassStateMachineOwnedBehaviorQuerySpecification extends BaseGeneratedEMFQuerySpecification<ClassStateMachineOwnedBehaviorMatcher> {
  private ClassStateMachineOwnedBehaviorQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ClassStateMachineOwnedBehaviorQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ClassStateMachineOwnedBehaviorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ClassStateMachineOwnedBehaviorMatcher.on(engine);
  }
  
  @Override
  public ClassStateMachineOwnedBehaviorMatch newEmptyMatch() {
    return ClassStateMachineOwnedBehaviorMatch.newEmptyMatch();
  }
  
  @Override
  public ClassStateMachineOwnedBehaviorMatch newMatch(final Object... parameters) {
    return ClassStateMachineOwnedBehaviorMatch.newMatch((org.eclipse.uml2.uml.StateMachine) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ClassStateMachineOwnedBehaviorQuerySpecification INSTANCE = make();
    
    public static ClassStateMachineOwnedBehaviorQuerySpecification make() {
      return new ClassStateMachineOwnedBehaviorQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ClassStateMachineOwnedBehaviorQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehavior";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("beh");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("beh", "org.eclipse.uml2.uml.StateMachine"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_beh = body.getOrCreateVariableByName("beh");
      		PVariable var_cl = body.getOrCreateVariableByName("cl");
      		new TypeConstraint(body, new FlatTuple(var_beh), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_beh, "beh")
      		));
      		// 	Class.ownedBehavior(cl, beh)
      		new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_cl, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier", "ownedBehavior")));
      		new Equality(body, var__virtual_0_, var_beh);
      		// 	neg find ClassifierBehavior(cl, beh)
      		new NegativePatternCall(body, new FlatTuple(var_cl, var_beh), ClassifierBehaviorQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "If state machine is owned by class it must be its classifier behavior");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "beh"
      		                }));
      		addAnnotation(annotation);
      	}
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
