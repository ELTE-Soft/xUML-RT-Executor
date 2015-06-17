package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEndMatch;
import hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEndMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate AssociationOtherEndMatcher in a type-safe way.
 * 
 * @see AssociationOtherEndMatcher
 * @see AssociationOtherEndMatch
 * 
 */
@SuppressWarnings("all")
public final class AssociationOtherEndQuerySpecification extends BaseGeneratedQuerySpecification<AssociationOtherEndMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AssociationOtherEndQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AssociationOtherEndMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AssociationOtherEndMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEnd";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("end","otherEnd");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("end", "org.eclipse.uml2.uml.Property"),new PParameter("otherEnd", "org.eclipse.uml2.uml.Property"));
  }
  
  @Override
  public AssociationOtherEndMatch newEmptyMatch() {
    return AssociationOtherEndMatch.newEmptyMatch();
  }
  
  @Override
  public AssociationOtherEndMatch newMatch(final Object... parameters) {
    return AssociationOtherEndMatch.newMatch((org.eclipse.uml2.uml.Property) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_end = body.getOrCreateVariableByName("end");
      PVariable var_otherEnd = body.getOrCreateVariableByName("otherEnd");
      PVariable var_association = body.getOrCreateVariableByName("association");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_end, "end"), 
        new ExportedParameter(body, var_otherEnd, "otherEnd")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_association, var_end, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association", "ownedEnd"), "http://www.eclipse.org/uml2/5.0.0/UML/Association.ownedEnd");
      new TypeBinary(body, CONTEXT, var_association, var_otherEnd, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association", "ownedEnd"), "http://www.eclipse.org/uml2/5.0.0/UML/Association.ownedEnd");
      new Inequality(body, var_end, var_otherEnd);
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AssociationOtherEndQuerySpecification INSTANCE = make();
    
    public static AssociationOtherEndQuerySpecification make() {
      return new AssociationOtherEndQuerySpecification();					
      
    }
  }
}
