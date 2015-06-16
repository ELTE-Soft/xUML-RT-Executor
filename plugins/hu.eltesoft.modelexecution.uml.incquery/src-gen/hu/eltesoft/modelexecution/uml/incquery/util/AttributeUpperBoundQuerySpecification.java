package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatcher;
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
 * A pattern-specific query specification that can instantiate AttributeUpperBoundMatcher in a type-safe way.
 * 
 * @see AttributeUpperBoundMatcher
 * @see AttributeUpperBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class AttributeUpperBoundQuerySpecification extends BaseGeneratedQuerySpecification<AttributeUpperBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AttributeUpperBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AttributeUpperBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AttributeUpperBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","attribute","type","upperBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("attribute", "org.eclipse.uml2.uml.Property"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("upperBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public AttributeUpperBoundMatch newEmptyMatch() {
    return AttributeUpperBoundMatch.newEmptyMatch();
  }
  
  @Override
  public AttributeUpperBoundMatch newMatch(final Object... parameters) {
    return AttributeUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_attribute = body.getOrCreateVariableByName("attribute");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_upperBound = body.getOrCreateVariableByName("upperBound");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_attribute, "attribute"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_upperBound, "upperBound")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_attribute, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      
      new TypeUnary(body, var_type, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type"), "http://www.eclipse.org/uml2/5.0.0/UML/Type");
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_attribute, var_type, var___0_, var___1_), AttributeTypeQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_attribute, var_upperBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.upperValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AttributeUpperBoundQuerySpecification INSTANCE = make();
    
    public static AttributeUpperBoundQuerySpecification make() {
      return new AttributeUpperBoundQuerySpecification();					
      
    }
  }
}
