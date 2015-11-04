package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ParameterStreamMatch;
import hu.eltesoft.modelexecution.validation.ParameterStreamMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ParameterStreamMatcher in a type-safe way.
 * 
 * @see ParameterStreamMatcher
 * @see ParameterStreamMatch
 * 
 */
@SuppressWarnings("all")
public final class ParameterStreamQuerySpecification extends BaseGeneratedEMFQuerySpecification<ParameterStreamMatcher> {
  private ParameterStreamQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ParameterStreamQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ParameterStreamMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ParameterStreamMatcher.on(engine);
  }
  
  @Override
  public ParameterStreamMatch newEmptyMatch() {
    return ParameterStreamMatch.newEmptyMatch();
  }
  
  @Override
  public ParameterStreamMatch newMatch(final Object... parameters) {
    return ParameterStreamMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ParameterStreamQuerySpecification INSTANCE = make();
    
    public static ParameterStreamQuerySpecification make() {
      return new ParameterStreamQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ParameterStreamQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ParameterStream";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("pm");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("pm", "org.eclipse.uml2.uml.Parameter"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_pm = body.getOrCreateVariableByName("pm");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_pm, "pm")
      	));
      	new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new ConstantValue(body, var__virtual_0_, true);
      	new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new TypeConstraint(body, new FlatTuple(var_pm, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "isStream")));
      	new Equality(body, var__virtual_1_, var__virtual_0_);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Stream parameters are not supported");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"pm"
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
