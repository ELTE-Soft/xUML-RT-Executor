package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ReceptionRaisedExceptionMatch;
import hu.eltesoft.modelexecution.validation.ReceptionRaisedExceptionMatcher;
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
 * A pattern-specific query specification that can instantiate ReceptionRaisedExceptionMatcher in a type-safe way.
 * 
 * @see ReceptionRaisedExceptionMatcher
 * @see ReceptionRaisedExceptionMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionRaisedExceptionQuerySpecification extends BaseGeneratedEMFQuerySpecification<ReceptionRaisedExceptionMatcher> {
  private ReceptionRaisedExceptionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionRaisedExceptionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReceptionRaisedExceptionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionRaisedExceptionMatcher.on(engine);
  }
  
  @Override
  public ReceptionRaisedExceptionMatch newEmptyMatch() {
    return ReceptionRaisedExceptionMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionRaisedExceptionMatch newMatch(final Object... parameters) {
    return ReceptionRaisedExceptionMatch.newMatch((org.eclipse.uml2.uml.Reception) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ReceptionRaisedExceptionQuerySpecification INSTANCE = make();
    
    public static ReceptionRaisedExceptionQuerySpecification make() {
      return new ReceptionRaisedExceptionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ReceptionRaisedExceptionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ReceptionRaisedException";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("rc");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("rc", "org.eclipse.uml2.uml.Reception"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_rc = body.getOrCreateVariableByName("rc");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_rc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_rc, "rc")
      		));
      		// 	Reception.raisedException(rc, _)
      		new TypeConstraint(body, new FlatTuple(var_rc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_rc, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "raisedException")));
      		new Equality(body, var__virtual_0_, var___0_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Receptions cannot raise exceptions");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "rc"
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
