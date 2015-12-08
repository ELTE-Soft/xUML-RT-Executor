package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.TransitionSourceUnknownMatch;
import hu.eltesoft.modelexecution.validation.TransitionSourceUnknownMatcher;
import hu.eltesoft.modelexecution.validation.util.TransitionSourceQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TransitionSourceUnknownMatcher in a type-safe way.
 * 
 * @see TransitionSourceUnknownMatcher
 * @see TransitionSourceUnknownMatch
 * 
 */
@SuppressWarnings("all")
public final class TransitionSourceUnknownQuerySpecification extends BaseGeneratedEMFQuerySpecification<TransitionSourceUnknownMatcher> {
  private TransitionSourceUnknownQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionSourceUnknownQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TransitionSourceUnknownMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TransitionSourceUnknownMatcher.on(engine);
  }
  
  @Override
  public TransitionSourceUnknownMatch newEmptyMatch() {
    return TransitionSourceUnknownMatch.newEmptyMatch();
  }
  
  @Override
  public TransitionSourceUnknownMatch newMatch(final Object... parameters) {
    return TransitionSourceUnknownMatch.newMatch((org.eclipse.uml2.uml.Transition) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static TransitionSourceUnknownQuerySpecification INSTANCE = make();
    
    public static TransitionSourceUnknownQuerySpecification make() {
      return new TransitionSourceUnknownQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TransitionSourceUnknownQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.TransitionSourceUnknown";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("tr");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("tr", "org.eclipse.uml2.uml.Transition"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_tr = body.getOrCreateVariableByName("tr");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_tr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_tr, "tr")
      		));
      		// 	neg find TransitionSource(tr, _)
      		new NegativePatternCall(body, new FlatTuple(var_tr, var___0_), TransitionSourceQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "The source of the transition is an initial pseudostate or a state");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "tr"
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
