package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ReceptionNonSequentialMatch;
import hu.eltesoft.modelexecution.validation.ReceptionNonSequentialMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ReceptionNonSequentialMatcher in a type-safe way.
 * 
 * @see ReceptionNonSequentialMatcher
 * @see ReceptionNonSequentialMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionNonSequentialQuerySpecification extends BaseGeneratedEMFQuerySpecification<ReceptionNonSequentialMatcher> {
  private ReceptionNonSequentialQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionNonSequentialQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReceptionNonSequentialMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionNonSequentialMatcher.on(engine);
  }
  
  @Override
  public ReceptionNonSequentialMatch newEmptyMatch() {
    return ReceptionNonSequentialMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionNonSequentialMatch newMatch(final Object... parameters) {
    return ReceptionNonSequentialMatch.newMatch((org.eclipse.uml2.uml.BehavioralFeature) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ReceptionNonSequentialQuerySpecification INSTANCE = make();
    
    public static ReceptionNonSequentialQuerySpecification make() {
      return new ReceptionNonSequentialQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ReceptionNonSequentialQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ReceptionNonSequential";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("beh");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("beh", "org.eclipse.uml2.uml.BehavioralFeature"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_beh = body.getOrCreateVariableByName("beh");
      		PVariable var_con = body.getOrCreateVariableByName("con");
      		new TypeConstraint(body, new FlatTuple(var_beh), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_beh, "beh")
      		));
      		// 	BehavioralFeature.concurrency(beh, con)
      		new TypeConstraint(body, new FlatTuple(var_beh), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_beh, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "concurrency")));
      		new Equality(body, var__virtual_0_, var_con);
      		// 	con != CallConcurrencyKind::sequential
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.CallConcurrencyKind.get("sequential"));
      		new Inequality(body, var_con, var__virtual_1_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Only sequential behaviors are supported");
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
