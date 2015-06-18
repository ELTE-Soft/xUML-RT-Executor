package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndMatch;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AssociationEndMatcher in a type-safe way.
 * 
 * @see AssociationEndMatcher
 * @see AssociationEndMatch
 * 
 */
@SuppressWarnings("all")
public final class AssociationEndQuerySpecification extends BaseGeneratedQuerySpecification<AssociationEndMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AssociationEndQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AssociationEndMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AssociationEndMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AssociationEnd";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("association","end");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("association", "org.eclipse.uml2.uml.Association"),new PParameter("end", "org.eclipse.uml2.uml.Property"));
  }
  
  @Override
  public AssociationEndMatch newEmptyMatch() {
    return AssociationEndMatch.newEmptyMatch();
  }
  
  @Override
  public AssociationEndMatch newMatch(final Object... parameters) {
    return AssociationEndMatch.newMatch((org.eclipse.uml2.uml.Association) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_association = body.getOrCreateVariableByName("association");
      PVariable var_end = body.getOrCreateVariableByName("end");
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_association, "association"), 
        new ExportedParameter(body, var_end, "end")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_association), AssociationQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_cls), ClsQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_association, var_end, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association", "ownedEnd"), "http://www.eclipse.org/uml2/5.0.0/UML/Association.ownedEnd");
      new TypeBinary(body, CONTEXT, var_end, var_cls, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AssociationEndQuerySpecification INSTANCE = make();
    
    public static AssociationEndQuerySpecification make() {
      return new AssociationEndQuerySpecification();					
      
    }
  }
}
