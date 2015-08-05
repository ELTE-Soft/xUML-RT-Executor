package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.XtAssociationMatch;
import com.incquerylabs.emdw.umlintegration.queries.XtAssociationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.AssociationOwnedEndQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate XtAssociationMatcher in a type-safe way.
 * 
 * @see XtAssociationMatcher
 * @see XtAssociationMatch
 * 
 */
@SuppressWarnings("all")
public final class XtAssociationQuerySpecification extends BaseGeneratedEMFQuerySpecification<XtAssociationMatcher> {
  private XtAssociationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static XtAssociationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected XtAssociationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return XtAssociationMatcher.on(engine);
  }
  
  @Override
  public XtAssociationMatch newEmptyMatch() {
    return XtAssociationMatch.newEmptyMatch();
  }
  
  @Override
  public XtAssociationMatch newMatch(final Object... parameters) {
    return XtAssociationMatch.newMatch((org.eclipse.uml2.uml.Association) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Property) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static XtAssociationQuerySpecification INSTANCE = make();
    
    public static XtAssociationQuerySpecification make() {
      return new XtAssociationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static XtAssociationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.xtAssociation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("association","sourceEnd","targetEnd");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("association", "org.eclipse.uml2.uml.Association"),new PParameter("sourceEnd", "org.eclipse.uml2.uml.Property"),new PParameter("targetEnd", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_association = body.getOrCreateVariableByName("association");
      	PVariable var_sourceEnd = body.getOrCreateVariableByName("sourceEnd");
      	PVariable var_targetEnd = body.getOrCreateVariableByName("targetEnd");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_association, "association"),
      				
      		new ExportedParameter(body, var_sourceEnd, "sourceEnd"),
      				
      		new ExportedParameter(body, var_targetEnd, "targetEnd")
      	));
      	new TypeConstraint(body, new FlatTuple(var_association), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      	new TypeConstraint(body, new FlatTuple(var_sourceEnd), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_targetEnd), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new PatternMatchCounter(body, new FlatTuple(var_association, var___0_), AssociationOwnedEndQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_0_);
      	new ConstantValue(body, var__virtual_1_, 2);
      	new Equality(body, var__virtual_0_, var__virtual_1_);
      	new TypeConstraint(body, new FlatTuple(var_association), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      	new TypeConstraint(body, new FlatTuple(var_association, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association", "ownedEnd")));
      	new Equality(body, var__virtual_2_, var_sourceEnd);
      	new TypeConstraint(body, new FlatTuple(var_association), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      	new TypeConstraint(body, new FlatTuple(var_association, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association", "ownedEnd")));
      	new Equality(body, var__virtual_3_, var_targetEnd);
      	new Inequality(body, var_sourceEnd, var_targetEnd);
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
