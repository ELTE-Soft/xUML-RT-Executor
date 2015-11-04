package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.MethodQuerySpecification;
import hu.eltesoft.modelexecution.validation.OperationMethodParameterCheckMatch;
import hu.eltesoft.modelexecution.validation.OperationMethodParameterCheckMatcher;
import hu.eltesoft.modelexecution.validation.util.ParamsCheckQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate OperationMethodParameterCheckMatcher in a type-safe way.
 * 
 * @see OperationMethodParameterCheckMatcher
 * @see OperationMethodParameterCheckMatch
 * 
 */
@SuppressWarnings("all")
public final class OperationMethodParameterCheckQuerySpecification extends BaseGeneratedEMFQuerySpecification<OperationMethodParameterCheckMatcher> {
  private OperationMethodParameterCheckQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OperationMethodParameterCheckQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected OperationMethodParameterCheckMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OperationMethodParameterCheckMatcher.on(engine);
  }
  
  @Override
  public OperationMethodParameterCheckMatch newEmptyMatch() {
    return OperationMethodParameterCheckMatch.newEmptyMatch();
  }
  
  @Override
  public OperationMethodParameterCheckMatch newMatch(final Object... parameters) {
    return OperationMethodParameterCheckMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0], (org.eclipse.uml2.uml.Parameter) parameters[1], (org.eclipse.uml2.uml.Operation) parameters[2], (org.eclipse.uml2.uml.Behavior) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static OperationMethodParameterCheckQuerySpecification INSTANCE = make();
    
    public static OperationMethodParameterCheckQuerySpecification make() {
      return new OperationMethodParameterCheckQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static OperationMethodParameterCheckQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.OperationMethodParameterCheck";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("opParam","methodParam","op","method");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("opParam", "org.eclipse.uml2.uml.Parameter"),new PParameter("methodParam", "org.eclipse.uml2.uml.Parameter"),new PParameter("op", "org.eclipse.uml2.uml.Operation"),new PParameter("method", "org.eclipse.uml2.uml.Behavior"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_opParam = body.getOrCreateVariableByName("opParam");
      	PVariable var_methodParam = body.getOrCreateVariableByName("methodParam");
      	PVariable var_op = body.getOrCreateVariableByName("op");
      	PVariable var_method = body.getOrCreateVariableByName("method");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_opParam, "opParam"),
      				
      		new ExportedParameter(body, var_methodParam, "methodParam"),
      				
      		new ExportedParameter(body, var_op, "op"),
      				
      		new ExportedParameter(body, var_method, "method")
      	));
      	new TypeConstraint(body, new FlatTuple(var_opParam), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new TypeConstraint(body, new FlatTuple(var_methodParam), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      	new TypeConstraint(body, new FlatTuple(var_method), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_op, var_method), MethodQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      	new TypeConstraint(body, new FlatTuple(var_op, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter")));
      	new Equality(body, var__virtual_0_, var_opParam);
      	new TypeConstraint(body, new FlatTuple(var_method), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior")));
      	new TypeConstraint(body, new FlatTuple(var_method, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior", "ownedParameter")));
      	new Equality(body, var__virtual_1_, var_methodParam);
      	new NegativePatternCall(body, new FlatTuple(var_opParam, var_methodParam), ParamsCheckQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("post", "hu.eltesoft.modelexecution.validation.utils.IndexChecked");
      	annotation.addAttribute("message", "Parameter of the method {method} does not conform to its specification in {op}");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"methodParam"
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
