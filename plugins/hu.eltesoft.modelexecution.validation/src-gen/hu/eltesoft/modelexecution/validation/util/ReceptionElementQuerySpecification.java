package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ReceptionElementMatch;
import hu.eltesoft.modelexecution.validation.ReceptionElementMatcher;
import hu.eltesoft.modelexecution.validation.util.ParameterQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ReceptionElementMatcher in a type-safe way.
 * 
 * @see ReceptionElementMatcher
 * @see ReceptionElementMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionElementQuerySpecification extends BaseGeneratedEMFQuerySpecification<ReceptionElementMatcher> {
  private ReceptionElementQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionElementQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReceptionElementMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionElementMatcher.on(engine);
  }
  
  @Override
  public ReceptionElementMatch newEmptyMatch() {
    return ReceptionElementMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionElementMatch newMatch(final Object... parameters) {
    return ReceptionElementMatch.newMatch((org.eclipse.uml2.uml.Element) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ReceptionElementQuerySpecification INSTANCE = make();
    
    public static ReceptionElementQuerySpecification make() {
      return new ReceptionElementQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ReceptionElementQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ReceptionElement";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("elem");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("elem", "org.eclipse.uml2.uml.Element"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_elem = body.getOrCreateVariableByName("elem");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_elem, "elem")
      		));
      		// 	Reception.ownedElement(_, elem)
      		new TypeConstraint(body, new FlatTuple(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var___0_, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
      		new Equality(body, var__virtual_0_, var_elem);
      		// 	neg find Parameter(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), ParameterQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Receptions can only contain parameters");
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
