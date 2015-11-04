package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNumMatch;
import hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNumMatcher;
import hu.eltesoft.modelexecution.validation.util.ParameterOfReceptionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertiesOfSignalQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ReceptionSignalParameterNumMatcher in a type-safe way.
 * 
 * @see ReceptionSignalParameterNumMatcher
 * @see ReceptionSignalParameterNumMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionSignalParameterNumQuerySpecification extends BaseGeneratedEMFQuerySpecification<ReceptionSignalParameterNumMatcher> {
  private ReceptionSignalParameterNumQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionSignalParameterNumQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReceptionSignalParameterNumMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionSignalParameterNumMatcher.on(engine);
  }
  
  @Override
  public ReceptionSignalParameterNumMatch newEmptyMatch() {
    return ReceptionSignalParameterNumMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionSignalParameterNumMatch newMatch(final Object... parameters) {
    return ReceptionSignalParameterNumMatch.newMatch((org.eclipse.uml2.uml.Reception) parameters[0], (org.eclipse.uml2.uml.Signal) parameters[1], (java.lang.Integer) parameters[2], (java.lang.Integer) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static ReceptionSignalParameterNumQuerySpecification INSTANCE = make();
    
    public static ReceptionSignalParameterNumQuerySpecification make() {
      return new ReceptionSignalParameterNumQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ReceptionSignalParameterNumQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNum";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("rc","sg","params","properties");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("rc", "org.eclipse.uml2.uml.Reception"),new PParameter("sg", "org.eclipse.uml2.uml.Signal"),new PParameter("params", "java.lang.Integer"),new PParameter("properties", "java.lang.Integer"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_rc = body.getOrCreateVariableByName("rc");
      	PVariable var_sg = body.getOrCreateVariableByName("sg");
      	PVariable var_params = body.getOrCreateVariableByName("params");
      	PVariable var_properties = body.getOrCreateVariableByName("properties");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_rc, "rc"),
      				
      		new ExportedParameter(body, var_sg, "sg"),
      				
      		new ExportedParameter(body, var_params, "params"),
      				
      		new ExportedParameter(body, var_properties, "properties")
      	));
      	new TypeConstraint(body, new FlatTuple(var_rc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      	new TypeConstraint(body, new FlatTuple(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_rc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      	new TypeConstraint(body, new FlatTuple(var_rc, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception", "signal")));
      	new Equality(body, var__virtual_0_, var_sg);
      	new PatternMatchCounter(body, new FlatTuple(var_rc, var___0_), ParameterOfReceptionQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_1_);
      	new Equality(body, var_params, var__virtual_1_);
      	new PatternMatchCounter(body, new FlatTuple(var_sg, var___1_), PropertiesOfSignalQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_2_);
      	new Equality(body, var_properties, var__virtual_2_);
      	new Inequality(body, var_params, var_properties);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Number of parameters ({params}) does not the same as number of properties in signal {sg} ({properties})");
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
