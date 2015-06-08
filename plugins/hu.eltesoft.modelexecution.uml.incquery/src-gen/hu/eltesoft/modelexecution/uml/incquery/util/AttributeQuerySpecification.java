package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AttributeMatcher in a type-safe way.
 * 
 * @see AttributeMatcher
 * @see AttributeMatch
 * 
 */
@SuppressWarnings("all")
public final class AttributeQuerySpecification extends BaseGeneratedQuerySpecification<AttributeMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AttributeQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AttributeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AttributeMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Attribute";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","attribute","isStatic","type");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("attribute", "org.eclipse.uml2.uml.Property"),new PParameter("isStatic", "java.lang.Boolean"),new PParameter("type", "org.eclipse.uml2.uml.Type"));
  }
  
  @Override
  public AttributeMatch newEmptyMatch() {
    return AttributeMatch.newEmptyMatch();
  }
  
  @Override
  public AttributeMatch newMatch(final Object... parameters) {
    return AttributeMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (java.lang.Boolean) parameters[2], (org.eclipse.uml2.uml.Type) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_attribute = body.getOrCreateVariableByName("attribute");
      PVariable var_isStatic = body.getOrCreateVariableByName("isStatic");
      PVariable var_type = body.getOrCreateVariableByName("type");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_attribute, "attribute"), 
        new ExportedParameter(body, var_isStatic, "isStatic"), 
        new ExportedParameter(body, var_type, "type")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls), ClsQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_cls, var_attribute, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuredClassifier", "ownedAttribute"), "http://www.eclipse.org/uml2/5.0.0/UML/StructuredClassifier.ownedAttribute");
      new TypeBinary(body, CONTEXT, var_attribute, var_isStatic, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Feature", "isStatic"), "http://www.eclipse.org/uml2/5.0.0/UML/Feature.isStatic");
      new TypeBinary(body, CONTEXT, var_attribute, var_type, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AttributeQuerySpecification INSTANCE = make();
    
    public static AttributeQuerySpecification make() {
      return new AttributeQuerySpecification();					
      
    }
  }
}
