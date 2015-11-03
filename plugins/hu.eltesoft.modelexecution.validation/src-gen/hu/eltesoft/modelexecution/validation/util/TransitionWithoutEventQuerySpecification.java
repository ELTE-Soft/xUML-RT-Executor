package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.TransitionWithoutEventMatch;
import hu.eltesoft.modelexecution.validation.TransitionWithoutEventMatcher;
import hu.eltesoft.modelexecution.validation.util.TransitionEventQuerySpecification;
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
 * A pattern-specific query specification that can instantiate TransitionWithoutEventMatcher in a type-safe way.
 * 
 * @see TransitionWithoutEventMatcher
 * @see TransitionWithoutEventMatch
 * 
 */
@SuppressWarnings("all")
public final class TransitionWithoutEventQuerySpecification extends BaseGeneratedEMFQuerySpecification<TransitionWithoutEventMatcher> {
  private TransitionWithoutEventQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionWithoutEventQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TransitionWithoutEventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TransitionWithoutEventMatcher.on(engine);
  }
  
  @Override
  public TransitionWithoutEventMatch newEmptyMatch() {
    return TransitionWithoutEventMatch.newEmptyMatch();
  }
  
  @Override
  public TransitionWithoutEventMatch newMatch(final Object... parameters) {
    return TransitionWithoutEventMatch.newMatch((org.eclipse.uml2.uml.Transition) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static TransitionWithoutEventQuerySpecification INSTANCE = make();
    
    public static TransitionWithoutEventQuerySpecification make() {
      return new TransitionWithoutEventQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TransitionWithoutEventQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.TransitionWithoutEvent";
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
      	PVariable var_src = body.getOrCreateVariableByName("src");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_tr, "tr")
      	));
      	new TypeConstraint(body, new FlatTuple(var_tr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_tr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_tr, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "source")));
      	new Equality(body, var__virtual_0_, var_src);
      	new TypeConstraint(body, new FlatTuple(var_src), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new NegativePatternCall(body, new FlatTuple(var_tr, var___0_), TransitionEventQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Transitions between normal states must have a trigger with an event");
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
