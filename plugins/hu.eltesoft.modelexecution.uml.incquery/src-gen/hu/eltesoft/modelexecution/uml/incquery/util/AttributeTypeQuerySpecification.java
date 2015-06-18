package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AttributeTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeQuerySpecification;
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
 * A pattern-specific query specification that can instantiate AttributeTypeMatcher in a type-safe way.
 * 
 * @see AttributeTypeMatcher
 * @see AttributeTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class AttributeTypeQuerySpecification extends BaseGeneratedQuerySpecification<AttributeTypeMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AttributeTypeQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AttributeTypeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AttributeTypeMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AttributeType";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","attribute","type","ordered","unique");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("attribute", "org.eclipse.uml2.uml.Property"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("ordered", "java.lang.Boolean"),new PParameter("unique", "java.lang.Boolean"));
  }
  
  @Override
  public AttributeTypeMatch newEmptyMatch() {
    return AttributeTypeMatch.newEmptyMatch();
  }
  
  @Override
  public AttributeTypeMatch newMatch(final Object... parameters) {
    return AttributeTypeMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2], (java.lang.Boolean) parameters[3], (java.lang.Boolean) parameters[4]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_attribute = body.getOrCreateVariableByName("attribute");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_ordered = body.getOrCreateVariableByName("ordered");
      PVariable var_unique = body.getOrCreateVariableByName("unique");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_attribute, "attribute"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_ordered, "ordered"), 
        new ExportedParameter(body, var_unique, "unique")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_attribute, var___0_), AttributeQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_attribute, var_type, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      new TypeBinary(body, CONTEXT, var_attribute, var_ordered, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "isOrdered"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.isOrdered");
      new TypeUnary(body, var_attribute, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      new TypeBinary(body, CONTEXT, var_attribute, var_unique, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "isUnique"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.isUnique");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AttributeTypeQuerySpecification INSTANCE = make();
    
    public static AttributeTypeQuerySpecification make() {
      return new AttributeTypeQuerySpecification();					
      
    }
  }
}
