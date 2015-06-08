package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AssociationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClsQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.MethodQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.RegionOfClassQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in classdef.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file classdef.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.uml.incquery, the group contains the definition of the following patterns: <ul>
 * <li>Cls</li>
 * <li>RegionOfClass</li>
 * <li>Operation</li>
 * <li>OperationParameter</li>
 * <li>OperationReturnType</li>
 * <li>Attribute</li>
 * <li>Association</li>
 * <li>Method</li>
 * <li>Reception</li>
 * <li>IsBehavior</li>
 * <li>IsStereotype</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Classdef extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Classdef instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Classdef();
    }
    return INSTANCE;
    
  }
  
  private static Classdef INSTANCE;
  
  private Classdef() throws IncQueryException {
    querySpecifications.add(ClsQuerySpecification.instance());
    querySpecifications.add(RegionOfClassQuerySpecification.instance());
    querySpecifications.add(OperationQuerySpecification.instance());
    querySpecifications.add(OperationParameterQuerySpecification.instance());
    querySpecifications.add(OperationReturnTypeQuerySpecification.instance());
    querySpecifications.add(AttributeQuerySpecification.instance());
    querySpecifications.add(AssociationQuerySpecification.instance());
    querySpecifications.add(MethodQuerySpecification.instance());
    querySpecifications.add(ReceptionQuerySpecification.instance());
    
  }
  
  public ClsQuerySpecification getCls() throws IncQueryException {
    return ClsQuerySpecification.instance();
  }
  
  public ClsMatcher getCls(final IncQueryEngine engine) throws IncQueryException {
    return ClsMatcher.on(engine);
  }
  
  public RegionOfClassQuerySpecification getRegionOfClass() throws IncQueryException {
    return RegionOfClassQuerySpecification.instance();
  }
  
  public RegionOfClassMatcher getRegionOfClass(final IncQueryEngine engine) throws IncQueryException {
    return RegionOfClassMatcher.on(engine);
  }
  
  public OperationQuerySpecification getOperation() throws IncQueryException {
    return OperationQuerySpecification.instance();
  }
  
  public OperationMatcher getOperation(final IncQueryEngine engine) throws IncQueryException {
    return OperationMatcher.on(engine);
  }
  
  public OperationParameterQuerySpecification getOperationParameter() throws IncQueryException {
    return OperationParameterQuerySpecification.instance();
  }
  
  public OperationParameterMatcher getOperationParameter(final IncQueryEngine engine) throws IncQueryException {
    return OperationParameterMatcher.on(engine);
  }
  
  public OperationReturnTypeQuerySpecification getOperationReturnType() throws IncQueryException {
    return OperationReturnTypeQuerySpecification.instance();
  }
  
  public OperationReturnTypeMatcher getOperationReturnType(final IncQueryEngine engine) throws IncQueryException {
    return OperationReturnTypeMatcher.on(engine);
  }
  
  public AttributeQuerySpecification getAttribute() throws IncQueryException {
    return AttributeQuerySpecification.instance();
  }
  
  public AttributeMatcher getAttribute(final IncQueryEngine engine) throws IncQueryException {
    return AttributeMatcher.on(engine);
  }
  
  public AssociationQuerySpecification getAssociation() throws IncQueryException {
    return AssociationQuerySpecification.instance();
  }
  
  public AssociationMatcher getAssociation(final IncQueryEngine engine) throws IncQueryException {
    return AssociationMatcher.on(engine);
  }
  
  public MethodQuerySpecification getMethod() throws IncQueryException {
    return MethodQuerySpecification.instance();
  }
  
  public MethodMatcher getMethod(final IncQueryEngine engine) throws IncQueryException {
    return MethodMatcher.on(engine);
  }
  
  public ReceptionQuerySpecification getReception() throws IncQueryException {
    return ReceptionQuerySpecification.instance();
  }
  
  public ReceptionMatcher getReception(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionMatcher.on(engine);
  }
}
