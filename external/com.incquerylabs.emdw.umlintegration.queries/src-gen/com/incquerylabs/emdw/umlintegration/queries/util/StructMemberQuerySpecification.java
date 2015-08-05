package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.StructMemberMatch;
import com.incquerylabs.emdw.umlintegration.queries.StructMemberMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate StructMemberMatcher in a type-safe way.
 * 
 * @see StructMemberMatcher
 * @see StructMemberMatch
 * 
 */
@SuppressWarnings("all")
public final class StructMemberQuerySpecification extends BaseGeneratedEMFQuerySpecification<StructMemberMatcher> {
  private StructMemberQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StructMemberQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StructMemberMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StructMemberMatcher.on(engine);
  }
  
  @Override
  public StructMemberMatch newEmptyMatch() {
    return StructMemberMatch.newEmptyMatch();
  }
  
  @Override
  public StructMemberMatch newMatch(final Object... parameters) {
    return StructMemberMatch.newMatch((org.eclipse.uml2.uml.DataType) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static StructMemberQuerySpecification INSTANCE = make();
    
    public static StructMemberQuerySpecification make() {
      return new StructMemberQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StructMemberQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.structMember";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("structType","member");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("structType", "org.eclipse.uml2.uml.DataType"),new PParameter("member", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_structType = body.getOrCreateVariableByName("structType");
      	PVariable var_member = body.getOrCreateVariableByName("member");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_structType, "structType"),
      				
      		new ExportedParameter(body, var_member, "member")
      	));
      	new TypeConstraint(body, new FlatTuple(var_structType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")));
      	new TypeConstraint(body, new FlatTuple(var_member), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_structType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")));
      	new TypeConstraint(body, new FlatTuple(var_structType, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DataType", "ownedAttribute")));
      	new Equality(body, var__virtual_0_, var_member);
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
