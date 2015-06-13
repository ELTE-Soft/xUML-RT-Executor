package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClsQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.MethodQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnUpperBoundQuerySpecification;
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
 * <li>IsBehavior</li>
 * <li>IsStereotype</li>
 * <li>RegionOfClass</li>
 * <li>Attribute</li>
 * <li>AttributeType</li>
 * <li>AttributeLowerBound</li>
 * <li>AttributeUpperBound</li>
 * <li>Operation</li>
 * <li>OperationParameter</li>
 * <li>OperationParameterType</li>
 * <li>OperationParameterLowerBound</li>
 * <li>OperationParameterUpperBound</li>
 * <li>OperationReturn</li>
 * <li>OperationReturnType</li>
 * <li>OperationReturnLowerBound</li>
 * <li>OperationReturnUpperBound</li>
 * <li>Method</li>
 * <li>Reception</li>
 * <li>ClassAssociation</li>
 * <li>ClassAssociationType</li>
 * <li>ClassAssociationLowerBound</li>
 * <li>ClassAssociationUpperBound</li>
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
    querySpecifications.add(AttributeQuerySpecification.instance());
    querySpecifications.add(AttributeTypeQuerySpecification.instance());
    querySpecifications.add(AttributeLowerBoundQuerySpecification.instance());
    querySpecifications.add(AttributeUpperBoundQuerySpecification.instance());
    querySpecifications.add(OperationQuerySpecification.instance());
    querySpecifications.add(OperationParameterQuerySpecification.instance());
    querySpecifications.add(OperationParameterTypeQuerySpecification.instance());
    querySpecifications.add(OperationParameterLowerBoundQuerySpecification.instance());
    querySpecifications.add(OperationParameterUpperBoundQuerySpecification.instance());
    querySpecifications.add(OperationReturnTypeQuerySpecification.instance());
    querySpecifications.add(OperationReturnLowerBoundQuerySpecification.instance());
    querySpecifications.add(OperationReturnUpperBoundQuerySpecification.instance());
    querySpecifications.add(MethodQuerySpecification.instance());
    querySpecifications.add(ReceptionQuerySpecification.instance());
    querySpecifications.add(ClassAssociationQuerySpecification.instance());
    querySpecifications.add(ClassAssociationTypeQuerySpecification.instance());
    querySpecifications.add(ClassAssociationLowerBoundQuerySpecification.instance());
    querySpecifications.add(ClassAssociationUpperBoundQuerySpecification.instance());
    
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
  
  public AttributeQuerySpecification getAttribute() throws IncQueryException {
    return AttributeQuerySpecification.instance();
  }
  
  public AttributeMatcher getAttribute(final IncQueryEngine engine) throws IncQueryException {
    return AttributeMatcher.on(engine);
  }
  
  public AttributeTypeQuerySpecification getAttributeType() throws IncQueryException {
    return AttributeTypeQuerySpecification.instance();
  }
  
  public AttributeTypeMatcher getAttributeType(final IncQueryEngine engine) throws IncQueryException {
    return AttributeTypeMatcher.on(engine);
  }
  
  public AttributeLowerBoundQuerySpecification getAttributeLowerBound() throws IncQueryException {
    return AttributeLowerBoundQuerySpecification.instance();
  }
  
  public AttributeLowerBoundMatcher getAttributeLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return AttributeLowerBoundMatcher.on(engine);
  }
  
  public AttributeUpperBoundQuerySpecification getAttributeUpperBound() throws IncQueryException {
    return AttributeUpperBoundQuerySpecification.instance();
  }
  
  public AttributeUpperBoundMatcher getAttributeUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return AttributeUpperBoundMatcher.on(engine);
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
  
  public OperationParameterTypeQuerySpecification getOperationParameterType() throws IncQueryException {
    return OperationParameterTypeQuerySpecification.instance();
  }
  
  public OperationParameterTypeMatcher getOperationParameterType(final IncQueryEngine engine) throws IncQueryException {
    return OperationParameterTypeMatcher.on(engine);
  }
  
  public OperationParameterLowerBoundQuerySpecification getOperationParameterLowerBound() throws IncQueryException {
    return OperationParameterLowerBoundQuerySpecification.instance();
  }
  
  public OperationParameterLowerBoundMatcher getOperationParameterLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return OperationParameterLowerBoundMatcher.on(engine);
  }
  
  public OperationParameterUpperBoundQuerySpecification getOperationParameterUpperBound() throws IncQueryException {
    return OperationParameterUpperBoundQuerySpecification.instance();
  }
  
  public OperationParameterUpperBoundMatcher getOperationParameterUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return OperationParameterUpperBoundMatcher.on(engine);
  }
  
  public OperationReturnTypeQuerySpecification getOperationReturnType() throws IncQueryException {
    return OperationReturnTypeQuerySpecification.instance();
  }
  
  public OperationReturnTypeMatcher getOperationReturnType(final IncQueryEngine engine) throws IncQueryException {
    return OperationReturnTypeMatcher.on(engine);
  }
  
  public OperationReturnLowerBoundQuerySpecification getOperationReturnLowerBound() throws IncQueryException {
    return OperationReturnLowerBoundQuerySpecification.instance();
  }
  
  public OperationReturnLowerBoundMatcher getOperationReturnLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return OperationReturnLowerBoundMatcher.on(engine);
  }
  
  public OperationReturnUpperBoundQuerySpecification getOperationReturnUpperBound() throws IncQueryException {
    return OperationReturnUpperBoundQuerySpecification.instance();
  }
  
  public OperationReturnUpperBoundMatcher getOperationReturnUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return OperationReturnUpperBoundMatcher.on(engine);
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
  
  public ClassAssociationQuerySpecification getClassAssociation() throws IncQueryException {
    return ClassAssociationQuerySpecification.instance();
  }
  
  public ClassAssociationMatcher getClassAssociation(final IncQueryEngine engine) throws IncQueryException {
    return ClassAssociationMatcher.on(engine);
  }
  
  public ClassAssociationTypeQuerySpecification getClassAssociationType() throws IncQueryException {
    return ClassAssociationTypeQuerySpecification.instance();
  }
  
  public ClassAssociationTypeMatcher getClassAssociationType(final IncQueryEngine engine) throws IncQueryException {
    return ClassAssociationTypeMatcher.on(engine);
  }
  
  public ClassAssociationLowerBoundQuerySpecification getClassAssociationLowerBound() throws IncQueryException {
    return ClassAssociationLowerBoundQuerySpecification.instance();
  }
  
  public ClassAssociationLowerBoundMatcher getClassAssociationLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return ClassAssociationLowerBoundMatcher.on(engine);
  }
  
  public ClassAssociationUpperBoundQuerySpecification getClassAssociationUpperBound() throws IncQueryException {
    return ClassAssociationUpperBoundQuerySpecification.instance();
  }
  
  public ClassAssociationUpperBoundMatcher getClassAssociationUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return ClassAssociationUpperBoundMatcher.on(engine);
  }
}
