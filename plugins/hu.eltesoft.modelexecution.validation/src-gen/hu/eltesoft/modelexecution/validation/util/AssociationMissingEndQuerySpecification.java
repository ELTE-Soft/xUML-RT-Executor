package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.AssociationMissingEndMatch;
import hu.eltesoft.modelexecution.validation.AssociationMissingEndMatcher;
import hu.eltesoft.modelexecution.validation.util.AssociationEndsQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AssociationMissingEndMatcher in a type-safe way.
 * 
 * @see AssociationMissingEndMatcher
 * @see AssociationMissingEndMatch
 * 
 */
@SuppressWarnings("all")
public final class AssociationMissingEndQuerySpecification extends BaseGeneratedEMFQuerySpecification<AssociationMissingEndMatcher> {
  private AssociationMissingEndQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AssociationMissingEndQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AssociationMissingEndMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AssociationMissingEndMatcher.on(engine);
  }
  
  @Override
  public AssociationMissingEndMatch newEmptyMatch() {
    return AssociationMissingEndMatch.newEmptyMatch();
  }
  
  @Override
  public AssociationMissingEndMatch newMatch(final Object... parameters) {
    return AssociationMissingEndMatch.newMatch((org.eclipse.uml2.uml.Association) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static AssociationMissingEndQuerySpecification INSTANCE = make();
    
    public static AssociationMissingEndQuerySpecification make() {
      return new AssociationMissingEndQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static AssociationMissingEndQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.AssociationMissingEnd";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("ac");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("ac", "org.eclipse.uml2.uml.Association"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_ac = body.getOrCreateVariableByName("ac");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		new TypeConstraint(body, new FlatTuple(var_ac), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_ac, "ac")
      		));
      		// 	neg find AssociationEnds(ac, _, _)
      		new NegativePatternCall(body, new FlatTuple(var_ac, var___0_, var___1_), AssociationEndsQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_ac = body.getOrCreateVariableByName("ac");
      		PVariable var_me1 = body.getOrCreateVariableByName("me1");
      		PVariable var_me2 = body.getOrCreateVariableByName("me2");
      		PVariable var_me3 = body.getOrCreateVariableByName("me3");
      		new TypeConstraint(body, new FlatTuple(var_ac), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_ac, "ac")
      		));
      		// 	find AssociationEnds(ac, me1, me2)
      		new PositivePatternCall(body, new FlatTuple(var_ac, var_me1, var_me2), AssociationEndsQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Association.memberEnd(ac, me3)
      		new TypeConstraint(body, new FlatTuple(var_ac), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_ac, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association", "memberEnd")));
      		new Equality(body, var__virtual_0_, var_me3);
      		// 	me1 != me3
      		new Inequality(body, var_me1, var_me3);
      		// 	me2 != me3
      		new Inequality(body, var_me2, var_me3);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Association must have two ends");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "ac"
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
