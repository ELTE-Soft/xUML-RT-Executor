package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.StateMachineWithClassifierBehaviorMatch;
import hu.eltesoft.modelexecution.validation.StateMachineWithClassifierBehaviorMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate StateMachineWithClassifierBehaviorMatcher in a type-safe way.
 * 
 * @see StateMachineWithClassifierBehaviorMatcher
 * @see StateMachineWithClassifierBehaviorMatch
 * 
 */
@SuppressWarnings("all")
public final class StateMachineWithClassifierBehaviorQuerySpecification extends BaseGeneratedEMFQuerySpecification<StateMachineWithClassifierBehaviorMatcher> {
  private StateMachineWithClassifierBehaviorQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateMachineWithClassifierBehaviorQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StateMachineWithClassifierBehaviorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineWithClassifierBehaviorMatcher.on(engine);
  }
  
  @Override
  public StateMachineWithClassifierBehaviorMatch newEmptyMatch() {
    return StateMachineWithClassifierBehaviorMatch.newEmptyMatch();
  }
  
  @Override
  public StateMachineWithClassifierBehaviorMatch newMatch(final Object... parameters) {
    return StateMachineWithClassifierBehaviorMatch.newMatch((org.eclipse.uml2.uml.StateMachine) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static StateMachineWithClassifierBehaviorQuerySpecification INSTANCE = make();
    
    public static StateMachineWithClassifierBehaviorQuerySpecification make() {
      return new StateMachineWithClassifierBehaviorQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StateMachineWithClassifierBehaviorQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.StateMachineWithClassifierBehavior";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sm");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sm", "org.eclipse.uml2.uml.StateMachine"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_sm = body.getOrCreateVariableByName("sm");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_sm, "sm")
      	));
      	new TypeConstraint(body, new FlatTuple(var_sm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      	new TypeConstraint(body, new FlatTuple(var_sm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      	new TypeConstraint(body, new FlatTuple(var_sm, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier", "classifierBehavior")));
      	new Equality(body, var__virtual_0_, var___0_);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "State machines cannot have classifier behavior");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"sm"
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
