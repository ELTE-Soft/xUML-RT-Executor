package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameNameMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityAttributeMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityGeneralizationMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityGeneralizedMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityMustBeAbstractMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityNameNotValidMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityOpNotStaticMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationNameNotValidMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterMultiplicityNotOneMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterMustBeInMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterNameNotValidMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterReturnNotValidMatcher;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterTypeNotValidMatcher;
import hu.eltesoft.modelexecution.validation.NonAbstractOperationWithoutMethodMatcher;
import hu.eltesoft.modelexecution.validation.util.ExternalEntitiesWithTheSameNameQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityAttributeQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityGeneralizationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityGeneralizedQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityMustBeAbstractQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityNameNotValidQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOpNotStaticQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOperationNameNotValidQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOperationParameterMustBeInQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOperationParameterNameNotValidQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOperationParameterReturnNotValidQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOperationParameterTypeNotValidQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.NonAbstractOperationWithoutMethodQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in ExternalEntity.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file ExternalEntity.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.validation, the group contains the definition of the following patterns: <ul>
 * <li>ExternalEntity</li>
 * <li>ExternalEntityOpNotStatic</li>
 * <li>ExternalEntityAttribute</li>
 * <li>ExternalEntityNameNotValid</li>
 * <li>ExternalEntityOperationNameNotValid</li>
 * <li>ExternalEntityOperationParameterTypeNotValid</li>
 * <li>ExternalEntityOperationParameterMustBeIn</li>
 * <li>ExternalEntityOperationParameterNameNotValid</li>
 * <li>ExternalEntityOperationParameterMultiplicityNotOne</li>
 * <li>ExternalEntityMustBeAbstract</li>
 * <li>ExternalEntityOperationParameterReturnNotValid</li>
 * <li>ExternalEntityGeneralization</li>
 * <li>ExternalEntityGeneralized</li>
 * <li>ExternalEntitiesWithTheSameName</li>
 * <li>PrimitiveType_</li>
 * <li>ExternalEntityOpParam</li>
 * <li>Callable</li>
 * <li>NonAbstractOperationWithoutMethod</li>
 * <li>HasMethod</li>
 * <li>_Parent</li>
 * <li>_NumericValue</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class ExternalEntity extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static ExternalEntity instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new ExternalEntity();
    }
    return INSTANCE;
  }
  
  private static ExternalEntity INSTANCE;
  
  private ExternalEntity() throws IncQueryException {
    querySpecifications.add(ExternalEntityOpNotStaticQuerySpecification.instance());
    querySpecifications.add(ExternalEntityAttributeQuerySpecification.instance());
    querySpecifications.add(ExternalEntityNameNotValidQuerySpecification.instance());
    querySpecifications.add(ExternalEntityOperationNameNotValidQuerySpecification.instance());
    querySpecifications.add(ExternalEntityOperationParameterTypeNotValidQuerySpecification.instance());
    querySpecifications.add(ExternalEntityOperationParameterMustBeInQuerySpecification.instance());
    querySpecifications.add(ExternalEntityOperationParameterNameNotValidQuerySpecification.instance());
    querySpecifications.add(ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification.instance());
    querySpecifications.add(ExternalEntityMustBeAbstractQuerySpecification.instance());
    querySpecifications.add(ExternalEntityOperationParameterReturnNotValidQuerySpecification.instance());
    querySpecifications.add(ExternalEntityGeneralizationQuerySpecification.instance());
    querySpecifications.add(ExternalEntityGeneralizedQuerySpecification.instance());
    querySpecifications.add(ExternalEntitiesWithTheSameNameQuerySpecification.instance());
    querySpecifications.add(NonAbstractOperationWithoutMethodQuerySpecification.instance());
  }
  
  public ExternalEntityOpNotStaticQuerySpecification getExternalEntityOpNotStatic() throws IncQueryException {
    return ExternalEntityOpNotStaticQuerySpecification.instance();
  }
  
  public ExternalEntityOpNotStaticMatcher getExternalEntityOpNotStatic(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOpNotStaticMatcher.on(engine);
  }
  
  public ExternalEntityAttributeQuerySpecification getExternalEntityAttribute() throws IncQueryException {
    return ExternalEntityAttributeQuerySpecification.instance();
  }
  
  public ExternalEntityAttributeMatcher getExternalEntityAttribute(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityAttributeMatcher.on(engine);
  }
  
  public ExternalEntityNameNotValidQuerySpecification getExternalEntityNameNotValid() throws IncQueryException {
    return ExternalEntityNameNotValidQuerySpecification.instance();
  }
  
  public ExternalEntityNameNotValidMatcher getExternalEntityNameNotValid(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityNameNotValidMatcher.on(engine);
  }
  
  public ExternalEntityOperationNameNotValidQuerySpecification getExternalEntityOperationNameNotValid() throws IncQueryException {
    return ExternalEntityOperationNameNotValidQuerySpecification.instance();
  }
  
  public ExternalEntityOperationNameNotValidMatcher getExternalEntityOperationNameNotValid(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOperationNameNotValidMatcher.on(engine);
  }
  
  public ExternalEntityOperationParameterTypeNotValidQuerySpecification getExternalEntityOperationParameterTypeNotValid() throws IncQueryException {
    return ExternalEntityOperationParameterTypeNotValidQuerySpecification.instance();
  }
  
  public ExternalEntityOperationParameterTypeNotValidMatcher getExternalEntityOperationParameterTypeNotValid(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOperationParameterTypeNotValidMatcher.on(engine);
  }
  
  public ExternalEntityOperationParameterMustBeInQuerySpecification getExternalEntityOperationParameterMustBeIn() throws IncQueryException {
    return ExternalEntityOperationParameterMustBeInQuerySpecification.instance();
  }
  
  public ExternalEntityOperationParameterMustBeInMatcher getExternalEntityOperationParameterMustBeIn(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOperationParameterMustBeInMatcher.on(engine);
  }
  
  public ExternalEntityOperationParameterNameNotValidQuerySpecification getExternalEntityOperationParameterNameNotValid() throws IncQueryException {
    return ExternalEntityOperationParameterNameNotValidQuerySpecification.instance();
  }
  
  public ExternalEntityOperationParameterNameNotValidMatcher getExternalEntityOperationParameterNameNotValid(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOperationParameterNameNotValidMatcher.on(engine);
  }
  
  public ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification getExternalEntityOperationParameterMultiplicityNotOne() throws IncQueryException {
    return ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification.instance();
  }
  
  public ExternalEntityOperationParameterMultiplicityNotOneMatcher getExternalEntityOperationParameterMultiplicityNotOne(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOperationParameterMultiplicityNotOneMatcher.on(engine);
  }
  
  public ExternalEntityMustBeAbstractQuerySpecification getExternalEntityMustBeAbstract() throws IncQueryException {
    return ExternalEntityMustBeAbstractQuerySpecification.instance();
  }
  
  public ExternalEntityMustBeAbstractMatcher getExternalEntityMustBeAbstract(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityMustBeAbstractMatcher.on(engine);
  }
  
  public ExternalEntityOperationParameterReturnNotValidQuerySpecification getExternalEntityOperationParameterReturnNotValid() throws IncQueryException {
    return ExternalEntityOperationParameterReturnNotValidQuerySpecification.instance();
  }
  
  public ExternalEntityOperationParameterReturnNotValidMatcher getExternalEntityOperationParameterReturnNotValid(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOperationParameterReturnNotValidMatcher.on(engine);
  }
  
  public ExternalEntityGeneralizationQuerySpecification getExternalEntityGeneralization() throws IncQueryException {
    return ExternalEntityGeneralizationQuerySpecification.instance();
  }
  
  public ExternalEntityGeneralizationMatcher getExternalEntityGeneralization(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityGeneralizationMatcher.on(engine);
  }
  
  public ExternalEntityGeneralizedQuerySpecification getExternalEntityGeneralized() throws IncQueryException {
    return ExternalEntityGeneralizedQuerySpecification.instance();
  }
  
  public ExternalEntityGeneralizedMatcher getExternalEntityGeneralized(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityGeneralizedMatcher.on(engine);
  }
  
  public ExternalEntitiesWithTheSameNameQuerySpecification getExternalEntitiesWithTheSameName() throws IncQueryException {
    return ExternalEntitiesWithTheSameNameQuerySpecification.instance();
  }
  
  public ExternalEntitiesWithTheSameNameMatcher getExternalEntitiesWithTheSameName(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntitiesWithTheSameNameMatcher.on(engine);
  }
  
  public NonAbstractOperationWithoutMethodQuerySpecification getNonAbstractOperationWithoutMethod() throws IncQueryException {
    return NonAbstractOperationWithoutMethodQuerySpecification.instance();
  }
  
  public NonAbstractOperationWithoutMethodMatcher getNonAbstractOperationWithoutMethod(final IncQueryEngine engine) throws IncQueryException {
    return NonAbstractOperationWithoutMethodMatcher.on(engine);
  }
}
