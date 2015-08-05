package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.EnumerationMatch;
import com.incquerylabs.emdw.umlintegration.queries.EnumerationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.PackagedElementQuerySpecification;
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
 * A pattern-specific query specification that can instantiate EnumerationMatcher in a type-safe way.
 * 
 * @see EnumerationMatcher
 * @see EnumerationMatch
 * 
 */
@SuppressWarnings("all")
public final class EnumerationQuerySpecification extends BaseGeneratedEMFQuerySpecification<EnumerationMatcher> {
  private EnumerationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EnumerationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected EnumerationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EnumerationMatcher.on(engine);
  }
  
  @Override
  public EnumerationMatch newEmptyMatch() {
    return EnumerationMatch.newEmptyMatch();
  }
  
  @Override
  public EnumerationMatch newMatch(final Object... parameters) {
    return EnumerationMatch.newMatch((org.eclipse.uml2.uml.Enumeration) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static EnumerationQuerySpecification INSTANCE = make();
    
    public static EnumerationQuerySpecification make() {
      return new EnumerationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static EnumerationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.enumeration";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("enumeration");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("enumeration", "org.eclipse.uml2.uml.Enumeration"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_enumeration = body.getOrCreateVariableByName("enumeration");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_enumeration, "enumeration")
      	));
      	new TypeConstraint(body, new FlatTuple(var_enumeration), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Enumeration")));
      	new PositivePatternCall(body, new FlatTuple(var_enumeration), PackagedElementQuerySpecification.instance().getInternalQueryRepresentation());
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
