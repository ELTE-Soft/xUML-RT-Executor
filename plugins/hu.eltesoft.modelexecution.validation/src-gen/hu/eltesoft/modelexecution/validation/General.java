package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.AbstractMatcher;
import hu.eltesoft.modelexecution.validation.ExtensionMatcher;
import hu.eltesoft.modelexecution.validation.FinalSpecificationMatcher;
import hu.eltesoft.modelexecution.validation.HighBoundZeroMatcher;
import hu.eltesoft.modelexecution.validation.LeafRedefinedMatcher;
import hu.eltesoft.modelexecution.validation.LowBoundHigherThanHighBoundMatcher;
import hu.eltesoft.modelexecution.validation.LowBoundInfiniteMatcher;
import hu.eltesoft.modelexecution.validation.PowertypeExtentMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionNonSequentialMatcher;
import hu.eltesoft.modelexecution.validation.RedefinedClassifierMatcher;
import hu.eltesoft.modelexecution.validation.RepresentationMatcher;
import hu.eltesoft.modelexecution.validation.TemplateParameterMatcher;
import hu.eltesoft.modelexecution.validation.TwoElementWithSameNameMatcher;
import hu.eltesoft.modelexecution.validation.UseCaseMatcher;
import hu.eltesoft.modelexecution.validation.util.AbstractQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExtensionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.FinalSpecificationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.HighBoundZeroQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.LeafRedefinedQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.LowBoundHigherThanHighBoundQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.LowBoundInfiniteQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PowertypeExtentQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionNonSequentialQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RedefinedClassifierQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RepresentationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.TemplateParameterQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.TwoElementWithSameNameQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.UseCaseQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in General.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file General.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.validation, the group contains the definition of the following patterns: <ul>
 * <li>TwoElementWithSameName</li>
 * <li>LeafRedefined</li>
 * <li>Extension</li>
 * <li>Abstract</li>
 * <li>FinalSpecification</li>
 * <li>Representation</li>
 * <li>PowertypeExtent</li>
 * <li>RedefinedClassifier</li>
 * <li>TemplateParameter</li>
 * <li>UseCase</li>
 * <li>ReceptionNonSequential</li>
 * <li>HighBoundZero</li>
 * <li>LowBoundInfinite</li>
 * <li>LowBoundHigherThanHighBound</li>
 * <li>HighBound</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class General extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static General instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new General();
    }
    return INSTANCE;
  }
  
  private static General INSTANCE;
  
  private General() throws IncQueryException {
    querySpecifications.add(TwoElementWithSameNameQuerySpecification.instance());
    querySpecifications.add(LeafRedefinedQuerySpecification.instance());
    querySpecifications.add(ExtensionQuerySpecification.instance());
    querySpecifications.add(AbstractQuerySpecification.instance());
    querySpecifications.add(FinalSpecificationQuerySpecification.instance());
    querySpecifications.add(RepresentationQuerySpecification.instance());
    querySpecifications.add(PowertypeExtentQuerySpecification.instance());
    querySpecifications.add(RedefinedClassifierQuerySpecification.instance());
    querySpecifications.add(TemplateParameterQuerySpecification.instance());
    querySpecifications.add(UseCaseQuerySpecification.instance());
    querySpecifications.add(ReceptionNonSequentialQuerySpecification.instance());
    querySpecifications.add(HighBoundZeroQuerySpecification.instance());
    querySpecifications.add(LowBoundInfiniteQuerySpecification.instance());
    querySpecifications.add(LowBoundHigherThanHighBoundQuerySpecification.instance());
  }
  
  public TwoElementWithSameNameQuerySpecification getTwoElementWithSameName() throws IncQueryException {
    return TwoElementWithSameNameQuerySpecification.instance();
  }
  
  public TwoElementWithSameNameMatcher getTwoElementWithSameName(final IncQueryEngine engine) throws IncQueryException {
    return TwoElementWithSameNameMatcher.on(engine);
  }
  
  public LeafRedefinedQuerySpecification getLeafRedefined() throws IncQueryException {
    return LeafRedefinedQuerySpecification.instance();
  }
  
  public LeafRedefinedMatcher getLeafRedefined(final IncQueryEngine engine) throws IncQueryException {
    return LeafRedefinedMatcher.on(engine);
  }
  
  public ExtensionQuerySpecification getExtension() throws IncQueryException {
    return ExtensionQuerySpecification.instance();
  }
  
  public ExtensionMatcher getExtension(final IncQueryEngine engine) throws IncQueryException {
    return ExtensionMatcher.on(engine);
  }
  
  public AbstractQuerySpecification getAbstract() throws IncQueryException {
    return AbstractQuerySpecification.instance();
  }
  
  public AbstractMatcher getAbstract(final IncQueryEngine engine) throws IncQueryException {
    return AbstractMatcher.on(engine);
  }
  
  public FinalSpecificationQuerySpecification getFinalSpecification() throws IncQueryException {
    return FinalSpecificationQuerySpecification.instance();
  }
  
  public FinalSpecificationMatcher getFinalSpecification(final IncQueryEngine engine) throws IncQueryException {
    return FinalSpecificationMatcher.on(engine);
  }
  
  public RepresentationQuerySpecification getRepresentation() throws IncQueryException {
    return RepresentationQuerySpecification.instance();
  }
  
  public RepresentationMatcher getRepresentation(final IncQueryEngine engine) throws IncQueryException {
    return RepresentationMatcher.on(engine);
  }
  
  public PowertypeExtentQuerySpecification getPowertypeExtent() throws IncQueryException {
    return PowertypeExtentQuerySpecification.instance();
  }
  
  public PowertypeExtentMatcher getPowertypeExtent(final IncQueryEngine engine) throws IncQueryException {
    return PowertypeExtentMatcher.on(engine);
  }
  
  public RedefinedClassifierQuerySpecification getRedefinedClassifier() throws IncQueryException {
    return RedefinedClassifierQuerySpecification.instance();
  }
  
  public RedefinedClassifierMatcher getRedefinedClassifier(final IncQueryEngine engine) throws IncQueryException {
    return RedefinedClassifierMatcher.on(engine);
  }
  
  public TemplateParameterQuerySpecification getTemplateParameter() throws IncQueryException {
    return TemplateParameterQuerySpecification.instance();
  }
  
  public TemplateParameterMatcher getTemplateParameter(final IncQueryEngine engine) throws IncQueryException {
    return TemplateParameterMatcher.on(engine);
  }
  
  public UseCaseQuerySpecification getUseCase() throws IncQueryException {
    return UseCaseQuerySpecification.instance();
  }
  
  public UseCaseMatcher getUseCase(final IncQueryEngine engine) throws IncQueryException {
    return UseCaseMatcher.on(engine);
  }
  
  public ReceptionNonSequentialQuerySpecification getReceptionNonSequential() throws IncQueryException {
    return ReceptionNonSequentialQuerySpecification.instance();
  }
  
  public ReceptionNonSequentialMatcher getReceptionNonSequential(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionNonSequentialMatcher.on(engine);
  }
  
  public HighBoundZeroQuerySpecification getHighBoundZero() throws IncQueryException {
    return HighBoundZeroQuerySpecification.instance();
  }
  
  public HighBoundZeroMatcher getHighBoundZero(final IncQueryEngine engine) throws IncQueryException {
    return HighBoundZeroMatcher.on(engine);
  }
  
  public LowBoundInfiniteQuerySpecification getLowBoundInfinite() throws IncQueryException {
    return LowBoundInfiniteQuerySpecification.instance();
  }
  
  public LowBoundInfiniteMatcher getLowBoundInfinite(final IncQueryEngine engine) throws IncQueryException {
    return LowBoundInfiniteMatcher.on(engine);
  }
  
  public LowBoundHigherThanHighBoundQuerySpecification getLowBoundHigherThanHighBound() throws IncQueryException {
    return LowBoundHigherThanHighBoundQuerySpecification.instance();
  }
  
  public LowBoundHigherThanHighBoundMatcher getLowBoundHigherThanHighBound(final IncQueryEngine engine) throws IncQueryException {
    return LowBoundHigherThanHighBoundMatcher.on(engine);
  }
}
