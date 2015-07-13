package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.NamedReceptionMatch;
import hu.eltesoft.modelexecution.uml.incquery.NamedReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate NamedReceptionMatcher in a type-safe way.
 * 
 * @see NamedReceptionMatcher
 * @see NamedReceptionMatch
 * 
 */
@SuppressWarnings("all")
public final class NamedReceptionQuerySpecification extends BaseGeneratedQuerySpecification<NamedReceptionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NamedReceptionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected NamedReceptionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NamedReceptionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.NamedReception";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","reception","name");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("reception", "org.eclipse.uml2.uml.Reception"),new PParameter("name", "java.lang.String"));
  }
  
  @Override
  public NamedReceptionMatch newEmptyMatch() {
    return NamedReceptionMatch.newEmptyMatch();
  }
  
  @Override
  public NamedReceptionMatch newMatch(final Object... parameters) {
    return NamedReceptionMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Reception) parameters[1], (java.lang.String) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_reception = body.getOrCreateVariableByName("reception");
      PVariable var_name = body.getOrCreateVariableByName("name");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_reception, "reception"), 
        new ExportedParameter(body, var_name, "name")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_reception, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception"), "http://www.eclipse.org/uml2/5.0.0/UML/Reception");
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_reception, var___0_), ReceptionQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_reception, var_name, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static NamedReceptionQuerySpecification INSTANCE = make();
    
    public static NamedReceptionQuerySpecification make() {
      return new NamedReceptionQuerySpecification();					
      
    }
  }
}
