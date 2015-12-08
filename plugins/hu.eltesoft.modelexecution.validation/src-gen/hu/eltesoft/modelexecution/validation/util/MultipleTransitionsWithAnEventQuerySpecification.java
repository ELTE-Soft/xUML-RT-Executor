package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEventMatch;
import hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEventMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MultipleTransitionsWithAnEventMatcher in a type-safe way.
 * 
 * @see MultipleTransitionsWithAnEventMatcher
 * @see MultipleTransitionsWithAnEventMatch
 * 
 */
@SuppressWarnings("all")
public final class MultipleTransitionsWithAnEventQuerySpecification extends BaseGeneratedEMFQuerySpecification<MultipleTransitionsWithAnEventMatcher> {
  private MultipleTransitionsWithAnEventQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MultipleTransitionsWithAnEventQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MultipleTransitionsWithAnEventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MultipleTransitionsWithAnEventMatcher.on(engine);
  }
  
  @Override
  public MultipleTransitionsWithAnEventMatch newEmptyMatch() {
    return MultipleTransitionsWithAnEventMatch.newEmptyMatch();
  }
  
  @Override
  public MultipleTransitionsWithAnEventMatch newMatch(final Object... parameters) {
    return MultipleTransitionsWithAnEventMatch.newMatch((org.eclipse.uml2.uml.Transition) parameters[0], (org.eclipse.uml2.uml.Transition) parameters[1], (org.eclipse.uml2.uml.State) parameters[2], (org.eclipse.uml2.uml.Event) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static MultipleTransitionsWithAnEventQuerySpecification INSTANCE = make();
    
    public static MultipleTransitionsWithAnEventQuerySpecification make() {
      return new MultipleTransitionsWithAnEventQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static MultipleTransitionsWithAnEventQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEvent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("tr1","tr2","src","ev");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("tr1", "org.eclipse.uml2.uml.Transition"),new PParameter("tr2", "org.eclipse.uml2.uml.Transition"),new PParameter("src", "org.eclipse.uml2.uml.State"),new PParameter("ev", "org.eclipse.uml2.uml.Event"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_tr1 = body.getOrCreateVariableByName("tr1");
      		PVariable var_tr2 = body.getOrCreateVariableByName("tr2");
      		PVariable var_src = body.getOrCreateVariableByName("src");
      		PVariable var_ev = body.getOrCreateVariableByName("ev");
      		new TypeConstraint(body, new FlatTuple(var_tr1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      		new TypeConstraint(body, new FlatTuple(var_tr2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      		new TypeConstraint(body, new FlatTuple(var_src), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      		new TypeConstraint(body, new FlatTuple(var_ev), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Event")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_tr1, "tr1"),
      		   new ExportedParameter(body, var_tr2, "tr2"),
      		   new ExportedParameter(body, var_src, "src"),
      		   new ExportedParameter(body, var_ev, "ev")
      		));
      		// 	Transition.source(tr1, src)
      		new TypeConstraint(body, new FlatTuple(var_tr1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_tr1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "source")));
      		new Equality(body, var__virtual_0_, var_src);
      		// 	find TransitionEvent(tr1, ev)
      		new PositivePatternCall(body, new FlatTuple(var_tr1, var_ev), TransitionEventQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Transition.source(tr2, src)
      		new TypeConstraint(body, new FlatTuple(var_tr2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_tr2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "source")));
      		new Equality(body, var__virtual_1_, var_src);
      		// 	find TransitionEvent(tr2, ev)
      		new PositivePatternCall(body, new FlatTuple(var_tr2, var_ev), TransitionEventQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	tr1 != tr2
      		new Inequality(body, var_tr1, var_tr2);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Multiple transitions from a single state with a single event are not supported");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "src"
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
