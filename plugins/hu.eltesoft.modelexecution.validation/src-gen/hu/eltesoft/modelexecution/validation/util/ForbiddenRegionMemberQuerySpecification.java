package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.StateQuerySpecification;
import hu.eltesoft.modelexecution.validation.ForbiddenRegionMemberMatch;
import hu.eltesoft.modelexecution.validation.ForbiddenRegionMemberMatcher;
import hu.eltesoft.modelexecution.validation.util.InitialStateQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.TransitionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ForbiddenRegionMemberMatcher in a type-safe way.
 * 
 * @see ForbiddenRegionMemberMatcher
 * @see ForbiddenRegionMemberMatch
 * 
 */
@SuppressWarnings("all")
public final class ForbiddenRegionMemberQuerySpecification extends BaseGeneratedEMFQuerySpecification<ForbiddenRegionMemberMatcher> {
  private ForbiddenRegionMemberQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ForbiddenRegionMemberQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ForbiddenRegionMemberMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenRegionMemberMatcher.on(engine);
  }
  
  @Override
  public ForbiddenRegionMemberMatch newEmptyMatch() {
    return ForbiddenRegionMemberMatch.newEmptyMatch();
  }
  
  @Override
  public ForbiddenRegionMemberMatch newMatch(final Object... parameters) {
    return ForbiddenRegionMemberMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.Element) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ForbiddenRegionMemberQuerySpecification INSTANCE = make();
    
    public static ForbiddenRegionMemberQuerySpecification make() {
      return new ForbiddenRegionMemberQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ForbiddenRegionMemberQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ForbiddenRegionMember";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("rg","elem");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("rg", "org.eclipse.uml2.uml.Region"),new PParameter("elem", "org.eclipse.uml2.uml.Element"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_rg = body.getOrCreateVariableByName("rg");
      		PVariable var_elem = body.getOrCreateVariableByName("elem");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		new TypeConstraint(body, new FlatTuple(var_rg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_rg, "rg"),
      		   new ExportedParameter(body, var_elem, "elem")
      		));
      		// 	Region.ownedElement(rg, elem)
      		new TypeConstraint(body, new FlatTuple(var_rg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_rg, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
      		new Equality(body, var__virtual_0_, var_elem);
      		// 	neg find State(_, elem)
      		new NegativePatternCall(body, new FlatTuple(var___0_, var_elem), StateQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find Transition(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), TransitionQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find InitialState(_, elem)
      		new NegativePatternCall(body, new FlatTuple(var___1_, var_elem), InitialStateQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "State machines regions can only contain transitions and states");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "elem"
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
