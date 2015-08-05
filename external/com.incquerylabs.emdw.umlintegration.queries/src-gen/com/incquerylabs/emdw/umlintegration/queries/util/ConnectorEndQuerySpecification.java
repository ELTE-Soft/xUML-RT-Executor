package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ConnectorEndMatch;
import com.incquerylabs.emdw.umlintegration.queries.ConnectorEndMatcher;
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
 * A pattern-specific query specification that can instantiate ConnectorEndMatcher in a type-safe way.
 * 
 * @see ConnectorEndMatcher
 * @see ConnectorEndMatch
 * 
 */
@SuppressWarnings("all")
public final class ConnectorEndQuerySpecification extends BaseGeneratedEMFQuerySpecification<ConnectorEndMatcher> {
  private ConnectorEndQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ConnectorEndQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ConnectorEndMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ConnectorEndMatcher.on(engine);
  }
  
  @Override
  public ConnectorEndMatch newEmptyMatch() {
    return ConnectorEndMatch.newEmptyMatch();
  }
  
  @Override
  public ConnectorEndMatch newMatch(final Object... parameters) {
    return ConnectorEndMatch.newMatch((org.eclipse.uml2.uml.Connector) parameters[0], (org.eclipse.uml2.uml.ConnectorEnd) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ConnectorEndQuerySpecification INSTANCE = make();
    
    public static ConnectorEndQuerySpecification make() {
      return new ConnectorEndQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ConnectorEndQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.connectorEnd";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("connector","connectorEnd");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("connector", "org.eclipse.uml2.uml.Connector"),new PParameter("connectorEnd", "org.eclipse.uml2.uml.ConnectorEnd"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_connector = body.getOrCreateVariableByName("connector");
      	PVariable var_connectorEnd = body.getOrCreateVariableByName("connectorEnd");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_connector, "connector"),
      				
      		new ExportedParameter(body, var_connectorEnd, "connectorEnd")
      	));
      	new TypeConstraint(body, new FlatTuple(var_connector), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Connector")));
      	new TypeConstraint(body, new FlatTuple(var_connectorEnd), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "ConnectorEnd")));
      	new TypeConstraint(body, new FlatTuple(var_connector), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Connector")));
      	new TypeConstraint(body, new FlatTuple(var_connector, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Connector", "end")));
      	new Equality(body, var__virtual_0_, var_connectorEnd);
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
