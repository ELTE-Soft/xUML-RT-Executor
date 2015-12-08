package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.RegionQuerySpecification;
import hu.eltesoft.modelexecution.validation.ForbiddenStateMachineMemberMatch;
import hu.eltesoft.modelexecution.validation.ForbiddenStateMachineMemberMatcher;
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
 * A pattern-specific query specification that can instantiate ForbiddenStateMachineMemberMatcher in a type-safe way.
 * 
 * @see ForbiddenStateMachineMemberMatcher
 * @see ForbiddenStateMachineMemberMatch
 * 
 */
@SuppressWarnings("all")
public final class ForbiddenStateMachineMemberQuerySpecification extends BaseGeneratedEMFQuerySpecification<ForbiddenStateMachineMemberMatcher> {
  private ForbiddenStateMachineMemberQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ForbiddenStateMachineMemberQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ForbiddenStateMachineMemberMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenStateMachineMemberMatcher.on(engine);
  }
  
  @Override
  public ForbiddenStateMachineMemberMatch newEmptyMatch() {
    return ForbiddenStateMachineMemberMatch.newEmptyMatch();
  }
  
  @Override
  public ForbiddenStateMachineMemberMatch newMatch(final Object... parameters) {
    return ForbiddenStateMachineMemberMatch.newMatch((org.eclipse.uml2.uml.StateMachine) parameters[0], (org.eclipse.uml2.uml.Element) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ForbiddenStateMachineMemberQuerySpecification INSTANCE = make();
    
    public static ForbiddenStateMachineMemberQuerySpecification make() {
      return new ForbiddenStateMachineMemberQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ForbiddenStateMachineMemberQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ForbiddenStateMachineMember";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sm","elem");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sm", "org.eclipse.uml2.uml.StateMachine"),new PParameter("elem", "org.eclipse.uml2.uml.Element"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_sm = body.getOrCreateVariableByName("sm");
      		PVariable var_elem = body.getOrCreateVariableByName("elem");
      		new TypeConstraint(body, new FlatTuple(var_sm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_sm, "sm"),
      		   new ExportedParameter(body, var_elem, "elem")
      		));
      		// 	StateMachine.ownedElement(sm, elem)
      		new TypeConstraint(body, new FlatTuple(var_sm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_sm, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
      		new Equality(body, var__virtual_0_, var_elem);
      		// 	neg find Region(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), RegionQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "State machines can only contain regions");
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
