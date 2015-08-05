package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.EnumerationLiteralMatch;
import com.incquerylabs.emdw.umlintegration.queries.EnumerationLiteralMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.EnumerationQuerySpecification;
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
 * A pattern-specific query specification that can instantiate EnumerationLiteralMatcher in a type-safe way.
 * 
 * @see EnumerationLiteralMatcher
 * @see EnumerationLiteralMatch
 * 
 */
@SuppressWarnings("all")
public final class EnumerationLiteralQuerySpecification extends BaseGeneratedEMFQuerySpecification<EnumerationLiteralMatcher> {
  private EnumerationLiteralQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EnumerationLiteralQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected EnumerationLiteralMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EnumerationLiteralMatcher.on(engine);
  }
  
  @Override
  public EnumerationLiteralMatch newEmptyMatch() {
    return EnumerationLiteralMatch.newEmptyMatch();
  }
  
  @Override
  public EnumerationLiteralMatch newMatch(final Object... parameters) {
    return EnumerationLiteralMatch.newMatch((org.eclipse.uml2.uml.Enumeration) parameters[0], (org.eclipse.uml2.uml.EnumerationLiteral) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static EnumerationLiteralQuerySpecification INSTANCE = make();
    
    public static EnumerationLiteralQuerySpecification make() {
      return new EnumerationLiteralQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static EnumerationLiteralQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.enumerationLiteral";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("enumeration","enumerationLiteral");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("enumeration", "org.eclipse.uml2.uml.Enumeration"),new PParameter("enumerationLiteral", "org.eclipse.uml2.uml.EnumerationLiteral"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_enumeration = body.getOrCreateVariableByName("enumeration");
      	PVariable var_enumerationLiteral = body.getOrCreateVariableByName("enumerationLiteral");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_enumeration, "enumeration"),
      				
      		new ExportedParameter(body, var_enumerationLiteral, "enumerationLiteral")
      	));
      	new TypeConstraint(body, new FlatTuple(var_enumeration), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Enumeration")));
      	new TypeConstraint(body, new FlatTuple(var_enumerationLiteral), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "EnumerationLiteral")));
      	new PositivePatternCall(body, new FlatTuple(var_enumeration), EnumerationQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_enumeration), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Enumeration")));
      	new TypeConstraint(body, new FlatTuple(var_enumeration, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Enumeration", "ownedLiteral")));
      	new Equality(body, var__virtual_0_, var_enumerationLiteral);
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
