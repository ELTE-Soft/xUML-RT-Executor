package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.RegionMatch;
import hu.eltesoft.modelexecution.uml.incquery.RegionMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate RegionMatcher in a type-safe way.
 * 
 * @see RegionMatcher
 * @see RegionMatch
 * 
 */
@SuppressWarnings("all")
public final class RegionQuerySpecification extends BaseGeneratedQuerySpecification<RegionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RegionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected RegionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RegionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Region";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","regionName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("regionName", "java.lang.String"));
  }
  
  @Override
  public RegionMatch newEmptyMatch() {
    return RegionMatch.newEmptyMatch();
  }
  
  @Override
  public RegionMatch newMatch(final Object... parameters) {
    return RegionMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (java.lang.String) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_regionName = body.getOrCreateVariableByName("regionName");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_regionName, "regionName")
      ));
      
      new TypeUnary(body, var_region, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region"), "http://www.eclipse.org/uml2/5.0.0/UML/Region");
      
      new TypeBinary(body, CONTEXT, var_region, var_regionName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static RegionQuerySpecification INSTANCE = make();
    
    public static RegionQuerySpecification make() {
      return new RegionQuerySpecification();					
      
    }
  }
}
