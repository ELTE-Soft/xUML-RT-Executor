package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeTypeQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AttributeLowerBoundMatcher in a type-safe way.
 * 
 * @see AttributeLowerBoundMatcher
 * @see AttributeLowerBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class AttributeLowerBoundQuerySpecification extends BaseGeneratedQuerySpecification<AttributeLowerBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AttributeLowerBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AttributeLowerBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AttributeLowerBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","attribute","type","lowerBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("attribute", "org.eclipse.uml2.uml.Property"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("lowerBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public AttributeLowerBoundMatch newEmptyMatch() {
    return AttributeLowerBoundMatch.newEmptyMatch();
  }
  
  @Override
  public AttributeLowerBoundMatch newMatch(final Object... parameters) {
    return AttributeLowerBoundMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_attribute = body.getOrCreateVariableByName("attribute");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_lowerBound = body.getOrCreateVariableByName("lowerBound");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_attribute, "attribute"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_lowerBound, "lowerBound")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_attribute, var_type, var___0_, var___1_), AttributeTypeQuerySpecification.instance());
      new TypeUnary(body, var_attribute, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      new TypeBinary(body, CONTEXT, var_attribute, var_lowerBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.lowerValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AttributeLowerBoundQuerySpecification INSTANCE = make();
    
    public static AttributeLowerBoundQuerySpecification make() {
      return new AttributeLowerBoundQuerySpecification();					
      
    }
  }
}
