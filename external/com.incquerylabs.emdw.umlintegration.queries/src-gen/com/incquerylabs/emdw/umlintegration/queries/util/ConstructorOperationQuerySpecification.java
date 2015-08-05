package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ConstructorOperationMatch;
import com.incquerylabs.emdw.umlintegration.queries.ConstructorOperationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.ConstructorByNameQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ConstructorOperationMatcher in a type-safe way.
 * 
 * @see ConstructorOperationMatcher
 * @see ConstructorOperationMatch
 * 
 */
@SuppressWarnings("all")
public final class ConstructorOperationQuerySpecification extends BaseGeneratedEMFQuerySpecification<ConstructorOperationMatcher> {
  private ConstructorOperationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ConstructorOperationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ConstructorOperationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ConstructorOperationMatcher.on(engine);
  }
  
  @Override
  public ConstructorOperationMatch newEmptyMatch() {
    return ConstructorOperationMatch.newEmptyMatch();
  }
  
  @Override
  public ConstructorOperationMatch newMatch(final Object... parameters) {
    return ConstructorOperationMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ConstructorOperationQuerySpecification INSTANCE = make();
    
    public static ConstructorOperationQuerySpecification make() {
      return new ConstructorOperationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ConstructorOperationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.constructorOperation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlClass","operation");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("umlClass", "org.eclipse.uml2.uml.Class"),new PParameter("operation", "org.eclipse.uml2.uml.Operation"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_umlClass = body.getOrCreateVariableByName("umlClass");
      	PVariable var_operation = body.getOrCreateVariableByName("operation");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_umlClass, "umlClass"),
      				
      		new ExportedParameter(body, var_operation, "operation")
      	));
      	new TypeConstraint(body, new FlatTuple(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_operation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      	new PositivePatternCall(body, new FlatTuple(var_umlClass, var_operation), ConstructorByNameQuerySpecification.instance().getInternalQueryRepresentation());
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
