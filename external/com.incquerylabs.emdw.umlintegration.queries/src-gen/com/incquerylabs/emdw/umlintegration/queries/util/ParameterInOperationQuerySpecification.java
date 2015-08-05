package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ParameterInOperationMatch;
import com.incquerylabs.emdw.umlintegration.queries.ParameterInOperationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.NotReturnParameterQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.OperationQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ParameterInOperationMatcher in a type-safe way.
 * 
 * @see ParameterInOperationMatcher
 * @see ParameterInOperationMatch
 * 
 */
@SuppressWarnings("all")
public final class ParameterInOperationQuerySpecification extends BaseGeneratedEMFQuerySpecification<ParameterInOperationMatcher> {
  private ParameterInOperationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ParameterInOperationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ParameterInOperationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ParameterInOperationMatcher.on(engine);
  }
  
  @Override
  public ParameterInOperationMatch newEmptyMatch() {
    return ParameterInOperationMatch.newEmptyMatch();
  }
  
  @Override
  public ParameterInOperationMatch newMatch(final Object... parameters) {
    return ParameterInOperationMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0], (org.eclipse.uml2.uml.Parameter) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ParameterInOperationQuerySpecification INSTANCE = make();
    
    public static ParameterInOperationQuerySpecification make() {
      return new ParameterInOperationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ParameterInOperationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.parameterInOperation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("operation","parameter");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_operation = body.getOrCreateVariableByName("operation");
      	PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_operation, "operation"),
      				
      		new ExportedParameter(body, var_parameter, "parameter")
      	));
      	new TypeConstraint(body, new FlatTuple(var_operation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      	new TypeConstraint(body, new FlatTuple(var_parameter), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_operation), OperationQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_operation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      	new TypeConstraint(body, new FlatTuple(var_operation, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter")));
      	new Equality(body, var__virtual_0_, var_parameter);
      	new PositivePatternCall(body, new FlatTuple(var_parameter), NotReturnParameterQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
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
