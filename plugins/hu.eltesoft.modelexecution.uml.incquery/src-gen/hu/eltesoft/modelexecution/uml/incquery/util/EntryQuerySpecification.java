package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.EntryMatch;
import hu.eltesoft.modelexecution.uml.incquery.EntryMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate EntryMatcher in a type-safe way.
 * 
 * @see EntryMatcher
 * @see EntryMatch
 * 
 */
@SuppressWarnings("all")
public final class EntryQuerySpecification extends BaseGeneratedQuerySpecification<EntryMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EntryQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected EntryMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EntryMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Entry";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","state","entry","entryName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("state", "org.eclipse.uml2.uml.State"),new PParameter("entry", "org.eclipse.uml2.uml.Behavior"),new PParameter("entryName", "java.lang.String"));
  }
  
  @Override
  public EntryMatch newEmptyMatch() {
    return EntryMatch.newEmptyMatch();
  }
  
  @Override
  public EntryMatch newMatch(final Object... parameters) {
    return EntryMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.State) parameters[1], (org.eclipse.uml2.uml.Behavior) parameters[2], (java.lang.String) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_state = body.getOrCreateVariableByName("state");
      PVariable var_entry = body.getOrCreateVariableByName("entry");
      PVariable var_entryName = body.getOrCreateVariableByName("entryName");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_state, "state"), 
        new ExportedParameter(body, var_entry, "entry"), 
        new ExportedParameter(body, var_entryName, "entryName")
      ));
      
      
      
      
      new TypeBinary(body, CONTEXT, var_state, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex", "container"), "http://www.eclipse.org/uml2/5.0.0/UML/Vertex.container");
      new TypeBinary(body, CONTEXT, var_state, var_entry, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State", "entry"), "http://www.eclipse.org/uml2/5.0.0/UML/State.entry");
      new TypeBinary(body, CONTEXT, var_entry, var_entryName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static EntryQuerySpecification INSTANCE = make();
    
    public static EntryQuerySpecification make() {
      return new EntryQuerySpecification();					
      
    }
  }
}
