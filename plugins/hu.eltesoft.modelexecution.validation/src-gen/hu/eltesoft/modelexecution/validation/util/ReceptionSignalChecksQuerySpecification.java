package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ReceptionSignalChecksMatch;
import hu.eltesoft.modelexecution.validation.ReceptionSignalChecksMatcher;
import hu.eltesoft.modelexecution.validation.util.ParamPropCheckQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ReceptionSignalChecksMatcher in a type-safe way.
 * 
 * @see ReceptionSignalChecksMatcher
 * @see ReceptionSignalChecksMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionSignalChecksQuerySpecification extends BaseGeneratedEMFQuerySpecification<ReceptionSignalChecksMatcher> {
  private ReceptionSignalChecksQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionSignalChecksQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReceptionSignalChecksMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionSignalChecksMatcher.on(engine);
  }
  
  @Override
  public ReceptionSignalChecksMatch newEmptyMatch() {
    return ReceptionSignalChecksMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionSignalChecksMatch newMatch(final Object... parameters) {
    return ReceptionSignalChecksMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Reception) parameters[2], (org.eclipse.uml2.uml.Signal) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static ReceptionSignalChecksQuerySpecification INSTANCE = make();
    
    public static ReceptionSignalChecksQuerySpecification make() {
      return new ReceptionSignalChecksQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ReceptionSignalChecksQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ReceptionSignalChecks";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("param","property","rc","sg");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("param", "org.eclipse.uml2.uml.Parameter"),new PParameter("property", "org.eclipse.uml2.uml.Property"),new PParameter("rc", "org.eclipse.uml2.uml.Reception"),new PParameter("sg", "org.eclipse.uml2.uml.Signal"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_param = body.getOrCreateVariableByName("param");
      	PVariable var_property = body.getOrCreateVariableByName("property");
      	PVariable var_rc = body.getOrCreateVariableByName("rc");
      	PVariable var_sg = body.getOrCreateVariableByName("sg");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_param, "param"),
      				
      		new ExportedParameter(body, var_property, "property"),
      				
      		new ExportedParameter(body, var_rc, "rc"),
      				
      		new ExportedParameter(body, var_sg, "sg")
      	));
      	new TypeConstraint(body, new FlatTuple(var_param), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_rc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      	new TypeConstraint(body, new FlatTuple(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_rc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      	new TypeConstraint(body, new FlatTuple(var_rc, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception", "signal")));
      	new Equality(body, var__virtual_0_, var_sg);
      	new TypeConstraint(body, new FlatTuple(var_rc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      	new TypeConstraint(body, new FlatTuple(var_rc, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter")));
      	new Equality(body, var__virtual_1_, var_param);
      	new TypeConstraint(body, new FlatTuple(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_sg, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier", "attribute")));
      	new Equality(body, var__virtual_2_, var_property);
      	new NegativePatternCall(body, new FlatTuple(var_param, var_property), ParamPropCheckQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("post", "hu.eltesoft.modelexecution.validation.utils.IndexChecked");
      	annotation.addAttribute("message", "Reception parameter must conform to the property {property} of signal {sg}");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"param"
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
