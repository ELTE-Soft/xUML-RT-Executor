package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.AssociationOwnedEndMatch;
import com.incquerylabs.emdw.umlintegration.queries.AssociationOwnedEndMatcher;
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
 * A pattern-specific query specification that can instantiate AssociationOwnedEndMatcher in a type-safe way.
 * 
 * @see AssociationOwnedEndMatcher
 * @see AssociationOwnedEndMatch
 * 
 */
@SuppressWarnings("all")
public final class AssociationOwnedEndQuerySpecification extends BaseGeneratedEMFQuerySpecification<AssociationOwnedEndMatcher> {
  private AssociationOwnedEndQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AssociationOwnedEndQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AssociationOwnedEndMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AssociationOwnedEndMatcher.on(engine);
  }
  
  @Override
  public AssociationOwnedEndMatch newEmptyMatch() {
    return AssociationOwnedEndMatch.newEmptyMatch();
  }
  
  @Override
  public AssociationOwnedEndMatch newMatch(final Object... parameters) {
    return AssociationOwnedEndMatch.newMatch((org.eclipse.uml2.uml.Association) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static AssociationOwnedEndQuerySpecification INSTANCE = make();
    
    public static AssociationOwnedEndQuerySpecification make() {
      return new AssociationOwnedEndQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static AssociationOwnedEndQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.associationOwnedEnd";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("association","ownedEnd");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("association", "org.eclipse.uml2.uml.Association"),new PParameter("ownedEnd", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_association = body.getOrCreateVariableByName("association");
      	PVariable var_ownedEnd = body.getOrCreateVariableByName("ownedEnd");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_association, "association"),
      				
      		new ExportedParameter(body, var_ownedEnd, "ownedEnd")
      	));
      	new TypeConstraint(body, new FlatTuple(var_association), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      	new TypeConstraint(body, new FlatTuple(var_ownedEnd), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_association), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      	new TypeConstraint(body, new FlatTuple(var_association, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association", "ownedEnd")));
      	new Equality(body, var__virtual_0_, var_ownedEnd);
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
