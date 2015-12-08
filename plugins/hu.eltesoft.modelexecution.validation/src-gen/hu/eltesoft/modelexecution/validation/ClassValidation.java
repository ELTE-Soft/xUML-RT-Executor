package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.AbstractOperationWithMethodMatcher;
import hu.eltesoft.modelexecution.validation.AmbigousOperationMatcher;
import hu.eltesoft.modelexecution.validation.AssociationAbstractMatcher;
import hu.eltesoft.modelexecution.validation.AssociationDerivedMatcher;
import hu.eltesoft.modelexecution.validation.AssociationElementMatcher;
import hu.eltesoft.modelexecution.validation.AssociationEndMustBeClassMatcher;
import hu.eltesoft.modelexecution.validation.AssociationMissingEndMatcher;
import hu.eltesoft.modelexecution.validation.AssociationNonPublicMatcher;
import hu.eltesoft.modelexecution.validation.ClassContainsAbstractOperationMatcher;
import hu.eltesoft.modelexecution.validation.ClassNotPublicMatcher;
import hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehaviorMatcher;
import hu.eltesoft.modelexecution.validation.ConstructorReturnMatcher;
import hu.eltesoft.modelexecution.validation.ConstructorWrongNameMatcher;
import hu.eltesoft.modelexecution.validation.CyclicInheritanceMatcher;
import hu.eltesoft.modelexecution.validation.DestructorParameterMatcher;
import hu.eltesoft.modelexecution.validation.DestructorWrongNameMatcher;
import hu.eltesoft.modelexecution.validation.DirectMultipleGeneralizationMatcher;
import hu.eltesoft.modelexecution.validation.GeneralizationNotSubstitutableMatcher;
import hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClassMatcher;
import hu.eltesoft.modelexecution.validation.GeneralizationSetMatcher;
import hu.eltesoft.modelexecution.validation.LeafClassGeneralizedMatcher;
import hu.eltesoft.modelexecution.validation.MethodAbstractMatcher;
import hu.eltesoft.modelexecution.validation.MethodActiveMatcher;
import hu.eltesoft.modelexecution.validation.MethodClassifierBehaviorMatcher;
import hu.eltesoft.modelexecution.validation.MethodElementMatcher;
import hu.eltesoft.modelexecution.validation.MethodNotOpaqueBehaviorMatcher;
import hu.eltesoft.modelexecution.validation.MethodNotPublicMatcher;
import hu.eltesoft.modelexecution.validation.MethodRedefinesMatcher;
import hu.eltesoft.modelexecution.validation.MethodReentrantMatcher;
import hu.eltesoft.modelexecution.validation.MethodWithoutRalfMatcher;
import hu.eltesoft.modelexecution.validation.MethodWithoutSpecificationMatcher;
import hu.eltesoft.modelexecution.validation.MultiReturnsMatcher;
import hu.eltesoft.modelexecution.validation.NonDatatypePropertyMatcher;
import hu.eltesoft.modelexecution.validation.OperationNotPublicMatcher;
import hu.eltesoft.modelexecution.validation.ParameterEffectMatcher;
import hu.eltesoft.modelexecution.validation.ParameterElementMatcher;
import hu.eltesoft.modelexecution.validation.ParameterExceptionMatcher;
import hu.eltesoft.modelexecution.validation.ParameterNonPublicMatcher;
import hu.eltesoft.modelexecution.validation.ParameterSetMatcher;
import hu.eltesoft.modelexecution.validation.ParameterStreamMatcher;
import hu.eltesoft.modelexecution.validation.ParameterWithoutTypeMatcher;
import hu.eltesoft.modelexecution.validation.PassiveClassWithBehaviorMatcher;
import hu.eltesoft.modelexecution.validation.PropertyAggregationMatcher;
import hu.eltesoft.modelexecution.validation.PropertyCannotBeDefaultInitializedMatcher;
import hu.eltesoft.modelexecution.validation.PropertyDefaultValueMatcher;
import hu.eltesoft.modelexecution.validation.PropertyIsDerivedMatcher;
import hu.eltesoft.modelexecution.validation.PropertyIsIDMatcher;
import hu.eltesoft.modelexecution.validation.PropertyIsReadOnlyMatcher;
import hu.eltesoft.modelexecution.validation.PropertyNotPublicMatcher;
import hu.eltesoft.modelexecution.validation.PropertyRedefinedPropertyMatcher;
import hu.eltesoft.modelexecution.validation.PropertySubsettedPropertyMatcher;
import hu.eltesoft.modelexecution.validation.PropertyUnrecognizedElementMatcher;
import hu.eltesoft.modelexecution.validation.PropertyWithoutTypeMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionAbstractMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionElementMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionMethodMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionNonPublicMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionParameterNotInMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionRaisedExceptionMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionStaticMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionWithoutSignalMatcher;
import hu.eltesoft.modelexecution.validation.RedefinedLeafMatcher;
import hu.eltesoft.modelexecution.validation.RedefinedMustBeInAncestorMatcher;
import hu.eltesoft.modelexecution.validation.RedefinedStaticMatcher;
import hu.eltesoft.modelexecution.validation.RedefiningAbstractMatcher;
import hu.eltesoft.modelexecution.validation.RedefiningNameDifferentMatcher;
import hu.eltesoft.modelexecution.validation.RedefiningStaticMatcher;
import hu.eltesoft.modelexecution.validation.ReturnTypeMultiplicityMatcher;
import hu.eltesoft.modelexecution.validation.SelfGeneralizationMatcher;
import hu.eltesoft.modelexecution.validation.StaticAbstractOperationMatcher;
import hu.eltesoft.modelexecution.validation.UnmarkedConstructorMatcher;
import hu.eltesoft.modelexecution.validation.UnmarkedDestructorMatcher;
import hu.eltesoft.modelexecution.validation.UnrecognizedElementInClassMatcher;
import hu.eltesoft.modelexecution.validation.util.AbstractOperationWithMethodQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.AmbigousOperationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.AssociationAbstractQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.AssociationDerivedQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.AssociationElementQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.AssociationEndMustBeClassQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.AssociationMissingEndQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.AssociationNonPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ClassContainsAbstractOperationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ClassNotPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ClassStateMachineOwnedBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ConstructorReturnQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ConstructorWrongNameQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.CyclicInheritanceQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.DestructorParameterQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.DestructorWrongNameQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.DirectMultipleGeneralizationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.GeneralizationNotSubstitutableQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.GeneralizationOfAssocClassQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.GeneralizationSetQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.LeafClassGeneralizedQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodAbstractQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodActiveQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodClassifierBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodElementQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodNotOpaqueBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodNotPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodRedefinesQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodReentrantQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodWithoutRalfQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MethodWithoutSpecificationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MultiReturnsQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.NonDatatypePropertyQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.OperationNotPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ParameterEffectQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ParameterElementQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ParameterExceptionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ParameterNonPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ParameterSetQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ParameterStreamQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ParameterWithoutTypeQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PassiveClassWithBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyAggregationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyCannotBeDefaultInitializedQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyDefaultValueQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyIsDerivedQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyIsIDQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyIsReadOnlyQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyNotPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyRedefinedPropertyQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertySubsettedPropertyQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyUnrecognizedElementQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyWithoutTypeQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionAbstractQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionElementQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionMethodQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionNonPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionParameterNotInQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionRaisedExceptionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionStaticQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionWithoutSignalQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RedefinedLeafQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RedefinedMustBeInAncestorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RedefinedStaticQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RedefiningAbstractQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RedefiningNameDifferentQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RedefiningStaticQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReturnTypeMultiplicityQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.SelfGeneralizationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StaticAbstractOperationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.UnmarkedConstructorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.UnmarkedDestructorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.UnrecognizedElementInClassQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in ClassValidation.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file ClassValidation.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.validation, the group contains the definition of the following patterns: <ul>
 * <li>ClassNotPublic</li>
 * <li>LeafClassGeneralized</li>
 * <li>SelfGeneralization</li>
 * <li>DirectMultipleGeneralization</li>
 * <li>CyclicInheritance</li>
 * <li>PassiveClassWithBehavior</li>
 * <li>ClassStateMachineOwnedBehavior</li>
 * <li>ClassifierBehavior</li>
 * <li>AmbigousOperation</li>
 * <li>UnrecognizedElementInClass</li>
 * <li>Property</li>
 * <li>Signal_</li>
 * <li>StateMachine</li>
 * <li>Generalization</li>
 * <li>GeneralizationSet</li>
 * <li>GeneralizationNotSubstitutable</li>
 * <li>GeneralizationOfAssocClass</li>
 * <li>NonDatatypeProperty</li>
 * <li>PropertyWithoutType</li>
 * <li>PropertyType</li>
 * <li>DataType</li>
 * <li>PropertyAggregation</li>
 * <li>PropertyDefaultValue</li>
 * <li>PropertyIsDerived</li>
 * <li>PropertyIsID</li>
 * <li>PropertyIsReadOnly</li>
 * <li>PropertyRedefinedProperty</li>
 * <li>PropertySubsettedProperty</li>
 * <li>PropertyNotPublic</li>
 * <li>PropertyUnrecognizedElement</li>
 * <li>IsBound</li>
 * <li>PropertyCannotBeDefaultInitialized</li>
 * <li>ReturnTypeMultiplicity</li>
 * <li>AbstractOperationWithMethod</li>
 * <li>RedefiningNameDifferent</li>
 * <li>RedefinedMustBeInAncestor</li>
 * <li>RedefiningAbstract</li>
 * <li>RedefiningStatic</li>
 * <li>RedefinedStatic</li>
 * <li>RedefinedLeaf</li>
 * <li>ClassContainsAbstractOperation</li>
 * <li>StaticAbstractOperation</li>
 * <li>UnmarkedConstructor</li>
 * <li>ConstructorWrongName</li>
 * <li>ConstructorReturn</li>
 * <li>Constructor</li>
 * <li>UnmarkedDestructor</li>
 * <li>DestructorWrongName</li>
 * <li>DestructorParameter</li>
 * <li>Destructor</li>
 * <li>MethodNotOpaqueBehavior</li>
 * <li>OpaqueBehavior</li>
 * <li>OperationNotPublic</li>
 * <li>MethodWithoutRalf</li>
 * <li>MethodRalf</li>
 * <li>MethodWithoutSpecification</li>
 * <li>SMEffect</li>
 * <li>MethodClassifierBehavior</li>
 * <li>MethodAbstract</li>
 * <li>MethodActive</li>
 * <li>MethodReentrant</li>
 * <li>MethodRedefines</li>
 * <li>MethodNotPublic</li>
 * <li>MethodElement</li>
 * <li>Parameter</li>
 * <li>MultiReturns</li>
 * <li>ParameterWithoutType</li>
 * <li>ParameterType</li>
 * <li>ParameterEffect</li>
 * <li>ParameterException</li>
 * <li>ParameterStream</li>
 * <li>ParameterSet</li>
 * <li>ParameterNonPublic</li>
 * <li>ParameterElement</li>
 * <li>AssociationNonPublic</li>
 * <li>AssociationMissingEnd</li>
 * <li>AssociationEnds</li>
 * <li>AssociationEndMustBeClass</li>
 * <li>AssociationAbstract</li>
 * <li>AssociationDerived</li>
 * <li>AssociationElement</li>
 * <li>ReceptionWithoutSignal</li>
 * <li>ReceptionSignal</li>
 * <li>ReceptionAbstract</li>
 * <li>ReceptionParameterNotIn</li>
 * <li>ReceptionStatic</li>
 * <li>ReceptionMethod</li>
 * <li>ReceptionRaisedException</li>
 * <li>ReceptionNonPublic</li>
 * <li>ReceptionElement</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class ClassValidation extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static ClassValidation instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new ClassValidation();
    }
    return INSTANCE;
  }
  
  private static ClassValidation INSTANCE;
  
  private ClassValidation() throws IncQueryException {
    querySpecifications.add(ClassNotPublicQuerySpecification.instance());
    querySpecifications.add(LeafClassGeneralizedQuerySpecification.instance());
    querySpecifications.add(SelfGeneralizationQuerySpecification.instance());
    querySpecifications.add(DirectMultipleGeneralizationQuerySpecification.instance());
    querySpecifications.add(CyclicInheritanceQuerySpecification.instance());
    querySpecifications.add(PassiveClassWithBehaviorQuerySpecification.instance());
    querySpecifications.add(ClassStateMachineOwnedBehaviorQuerySpecification.instance());
    querySpecifications.add(AmbigousOperationQuerySpecification.instance());
    querySpecifications.add(UnrecognizedElementInClassQuerySpecification.instance());
    querySpecifications.add(GeneralizationSetQuerySpecification.instance());
    querySpecifications.add(GeneralizationNotSubstitutableQuerySpecification.instance());
    querySpecifications.add(GeneralizationOfAssocClassQuerySpecification.instance());
    querySpecifications.add(NonDatatypePropertyQuerySpecification.instance());
    querySpecifications.add(PropertyWithoutTypeQuerySpecification.instance());
    querySpecifications.add(PropertyAggregationQuerySpecification.instance());
    querySpecifications.add(PropertyDefaultValueQuerySpecification.instance());
    querySpecifications.add(PropertyIsDerivedQuerySpecification.instance());
    querySpecifications.add(PropertyIsIDQuerySpecification.instance());
    querySpecifications.add(PropertyIsReadOnlyQuerySpecification.instance());
    querySpecifications.add(PropertyRedefinedPropertyQuerySpecification.instance());
    querySpecifications.add(PropertySubsettedPropertyQuerySpecification.instance());
    querySpecifications.add(PropertyNotPublicQuerySpecification.instance());
    querySpecifications.add(PropertyUnrecognizedElementQuerySpecification.instance());
    querySpecifications.add(PropertyCannotBeDefaultInitializedQuerySpecification.instance());
    querySpecifications.add(ReturnTypeMultiplicityQuerySpecification.instance());
    querySpecifications.add(AbstractOperationWithMethodQuerySpecification.instance());
    querySpecifications.add(RedefiningNameDifferentQuerySpecification.instance());
    querySpecifications.add(RedefinedMustBeInAncestorQuerySpecification.instance());
    querySpecifications.add(RedefiningAbstractQuerySpecification.instance());
    querySpecifications.add(RedefiningStaticQuerySpecification.instance());
    querySpecifications.add(RedefinedStaticQuerySpecification.instance());
    querySpecifications.add(RedefinedLeafQuerySpecification.instance());
    querySpecifications.add(ClassContainsAbstractOperationQuerySpecification.instance());
    querySpecifications.add(StaticAbstractOperationQuerySpecification.instance());
    querySpecifications.add(UnmarkedConstructorQuerySpecification.instance());
    querySpecifications.add(ConstructorWrongNameQuerySpecification.instance());
    querySpecifications.add(ConstructorReturnQuerySpecification.instance());
    querySpecifications.add(UnmarkedDestructorQuerySpecification.instance());
    querySpecifications.add(DestructorWrongNameQuerySpecification.instance());
    querySpecifications.add(DestructorParameterQuerySpecification.instance());
    querySpecifications.add(MethodNotOpaqueBehaviorQuerySpecification.instance());
    querySpecifications.add(OperationNotPublicQuerySpecification.instance());
    querySpecifications.add(MethodWithoutRalfQuerySpecification.instance());
    querySpecifications.add(MethodWithoutSpecificationQuerySpecification.instance());
    querySpecifications.add(MethodClassifierBehaviorQuerySpecification.instance());
    querySpecifications.add(MethodAbstractQuerySpecification.instance());
    querySpecifications.add(MethodActiveQuerySpecification.instance());
    querySpecifications.add(MethodReentrantQuerySpecification.instance());
    querySpecifications.add(MethodRedefinesQuerySpecification.instance());
    querySpecifications.add(MethodNotPublicQuerySpecification.instance());
    querySpecifications.add(MethodElementQuerySpecification.instance());
    querySpecifications.add(MultiReturnsQuerySpecification.instance());
    querySpecifications.add(ParameterWithoutTypeQuerySpecification.instance());
    querySpecifications.add(ParameterEffectQuerySpecification.instance());
    querySpecifications.add(ParameterExceptionQuerySpecification.instance());
    querySpecifications.add(ParameterStreamQuerySpecification.instance());
    querySpecifications.add(ParameterSetQuerySpecification.instance());
    querySpecifications.add(ParameterNonPublicQuerySpecification.instance());
    querySpecifications.add(ParameterElementQuerySpecification.instance());
    querySpecifications.add(AssociationNonPublicQuerySpecification.instance());
    querySpecifications.add(AssociationMissingEndQuerySpecification.instance());
    querySpecifications.add(AssociationEndMustBeClassQuerySpecification.instance());
    querySpecifications.add(AssociationAbstractQuerySpecification.instance());
    querySpecifications.add(AssociationDerivedQuerySpecification.instance());
    querySpecifications.add(AssociationElementQuerySpecification.instance());
    querySpecifications.add(ReceptionWithoutSignalQuerySpecification.instance());
    querySpecifications.add(ReceptionAbstractQuerySpecification.instance());
    querySpecifications.add(ReceptionParameterNotInQuerySpecification.instance());
    querySpecifications.add(ReceptionStaticQuerySpecification.instance());
    querySpecifications.add(ReceptionMethodQuerySpecification.instance());
    querySpecifications.add(ReceptionRaisedExceptionQuerySpecification.instance());
    querySpecifications.add(ReceptionNonPublicQuerySpecification.instance());
    querySpecifications.add(ReceptionElementQuerySpecification.instance());
  }
  
  public ClassNotPublicQuerySpecification getClassNotPublic() throws IncQueryException {
    return ClassNotPublicQuerySpecification.instance();
  }
  
  public ClassNotPublicMatcher getClassNotPublic(final IncQueryEngine engine) throws IncQueryException {
    return ClassNotPublicMatcher.on(engine);
  }
  
  public LeafClassGeneralizedQuerySpecification getLeafClassGeneralized() throws IncQueryException {
    return LeafClassGeneralizedQuerySpecification.instance();
  }
  
  public LeafClassGeneralizedMatcher getLeafClassGeneralized(final IncQueryEngine engine) throws IncQueryException {
    return LeafClassGeneralizedMatcher.on(engine);
  }
  
  public SelfGeneralizationQuerySpecification getSelfGeneralization() throws IncQueryException {
    return SelfGeneralizationQuerySpecification.instance();
  }
  
  public SelfGeneralizationMatcher getSelfGeneralization(final IncQueryEngine engine) throws IncQueryException {
    return SelfGeneralizationMatcher.on(engine);
  }
  
  public DirectMultipleGeneralizationQuerySpecification getDirectMultipleGeneralization() throws IncQueryException {
    return DirectMultipleGeneralizationQuerySpecification.instance();
  }
  
  public DirectMultipleGeneralizationMatcher getDirectMultipleGeneralization(final IncQueryEngine engine) throws IncQueryException {
    return DirectMultipleGeneralizationMatcher.on(engine);
  }
  
  public CyclicInheritanceQuerySpecification getCyclicInheritance() throws IncQueryException {
    return CyclicInheritanceQuerySpecification.instance();
  }
  
  public CyclicInheritanceMatcher getCyclicInheritance(final IncQueryEngine engine) throws IncQueryException {
    return CyclicInheritanceMatcher.on(engine);
  }
  
  public PassiveClassWithBehaviorQuerySpecification getPassiveClassWithBehavior() throws IncQueryException {
    return PassiveClassWithBehaviorQuerySpecification.instance();
  }
  
  public PassiveClassWithBehaviorMatcher getPassiveClassWithBehavior(final IncQueryEngine engine) throws IncQueryException {
    return PassiveClassWithBehaviorMatcher.on(engine);
  }
  
  public ClassStateMachineOwnedBehaviorQuerySpecification getClassStateMachineOwnedBehavior() throws IncQueryException {
    return ClassStateMachineOwnedBehaviorQuerySpecification.instance();
  }
  
  public ClassStateMachineOwnedBehaviorMatcher getClassStateMachineOwnedBehavior(final IncQueryEngine engine) throws IncQueryException {
    return ClassStateMachineOwnedBehaviorMatcher.on(engine);
  }
  
  public AmbigousOperationQuerySpecification getAmbigousOperation() throws IncQueryException {
    return AmbigousOperationQuerySpecification.instance();
  }
  
  public AmbigousOperationMatcher getAmbigousOperation(final IncQueryEngine engine) throws IncQueryException {
    return AmbigousOperationMatcher.on(engine);
  }
  
  public UnrecognizedElementInClassQuerySpecification getUnrecognizedElementInClass() throws IncQueryException {
    return UnrecognizedElementInClassQuerySpecification.instance();
  }
  
  public UnrecognizedElementInClassMatcher getUnrecognizedElementInClass(final IncQueryEngine engine) throws IncQueryException {
    return UnrecognizedElementInClassMatcher.on(engine);
  }
  
  public GeneralizationSetQuerySpecification getGeneralizationSet() throws IncQueryException {
    return GeneralizationSetQuerySpecification.instance();
  }
  
  public GeneralizationSetMatcher getGeneralizationSet(final IncQueryEngine engine) throws IncQueryException {
    return GeneralizationSetMatcher.on(engine);
  }
  
  public GeneralizationNotSubstitutableQuerySpecification getGeneralizationNotSubstitutable() throws IncQueryException {
    return GeneralizationNotSubstitutableQuerySpecification.instance();
  }
  
  public GeneralizationNotSubstitutableMatcher getGeneralizationNotSubstitutable(final IncQueryEngine engine) throws IncQueryException {
    return GeneralizationNotSubstitutableMatcher.on(engine);
  }
  
  public GeneralizationOfAssocClassQuerySpecification getGeneralizationOfAssocClass() throws IncQueryException {
    return GeneralizationOfAssocClassQuerySpecification.instance();
  }
  
  public GeneralizationOfAssocClassMatcher getGeneralizationOfAssocClass(final IncQueryEngine engine) throws IncQueryException {
    return GeneralizationOfAssocClassMatcher.on(engine);
  }
  
  public NonDatatypePropertyQuerySpecification getNonDatatypeProperty() throws IncQueryException {
    return NonDatatypePropertyQuerySpecification.instance();
  }
  
  public NonDatatypePropertyMatcher getNonDatatypeProperty(final IncQueryEngine engine) throws IncQueryException {
    return NonDatatypePropertyMatcher.on(engine);
  }
  
  public PropertyWithoutTypeQuerySpecification getPropertyWithoutType() throws IncQueryException {
    return PropertyWithoutTypeQuerySpecification.instance();
  }
  
  public PropertyWithoutTypeMatcher getPropertyWithoutType(final IncQueryEngine engine) throws IncQueryException {
    return PropertyWithoutTypeMatcher.on(engine);
  }
  
  public PropertyAggregationQuerySpecification getPropertyAggregation() throws IncQueryException {
    return PropertyAggregationQuerySpecification.instance();
  }
  
  public PropertyAggregationMatcher getPropertyAggregation(final IncQueryEngine engine) throws IncQueryException {
    return PropertyAggregationMatcher.on(engine);
  }
  
  public PropertyDefaultValueQuerySpecification getPropertyDefaultValue() throws IncQueryException {
    return PropertyDefaultValueQuerySpecification.instance();
  }
  
  public PropertyDefaultValueMatcher getPropertyDefaultValue(final IncQueryEngine engine) throws IncQueryException {
    return PropertyDefaultValueMatcher.on(engine);
  }
  
  public PropertyIsDerivedQuerySpecification getPropertyIsDerived() throws IncQueryException {
    return PropertyIsDerivedQuerySpecification.instance();
  }
  
  public PropertyIsDerivedMatcher getPropertyIsDerived(final IncQueryEngine engine) throws IncQueryException {
    return PropertyIsDerivedMatcher.on(engine);
  }
  
  public PropertyIsIDQuerySpecification getPropertyIsID() throws IncQueryException {
    return PropertyIsIDQuerySpecification.instance();
  }
  
  public PropertyIsIDMatcher getPropertyIsID(final IncQueryEngine engine) throws IncQueryException {
    return PropertyIsIDMatcher.on(engine);
  }
  
  public PropertyIsReadOnlyQuerySpecification getPropertyIsReadOnly() throws IncQueryException {
    return PropertyIsReadOnlyQuerySpecification.instance();
  }
  
  public PropertyIsReadOnlyMatcher getPropertyIsReadOnly(final IncQueryEngine engine) throws IncQueryException {
    return PropertyIsReadOnlyMatcher.on(engine);
  }
  
  public PropertyRedefinedPropertyQuerySpecification getPropertyRedefinedProperty() throws IncQueryException {
    return PropertyRedefinedPropertyQuerySpecification.instance();
  }
  
  public PropertyRedefinedPropertyMatcher getPropertyRedefinedProperty(final IncQueryEngine engine) throws IncQueryException {
    return PropertyRedefinedPropertyMatcher.on(engine);
  }
  
  public PropertySubsettedPropertyQuerySpecification getPropertySubsettedProperty() throws IncQueryException {
    return PropertySubsettedPropertyQuerySpecification.instance();
  }
  
  public PropertySubsettedPropertyMatcher getPropertySubsettedProperty(final IncQueryEngine engine) throws IncQueryException {
    return PropertySubsettedPropertyMatcher.on(engine);
  }
  
  public PropertyNotPublicQuerySpecification getPropertyNotPublic() throws IncQueryException {
    return PropertyNotPublicQuerySpecification.instance();
  }
  
  public PropertyNotPublicMatcher getPropertyNotPublic(final IncQueryEngine engine) throws IncQueryException {
    return PropertyNotPublicMatcher.on(engine);
  }
  
  public PropertyUnrecognizedElementQuerySpecification getPropertyUnrecognizedElement() throws IncQueryException {
    return PropertyUnrecognizedElementQuerySpecification.instance();
  }
  
  public PropertyUnrecognizedElementMatcher getPropertyUnrecognizedElement(final IncQueryEngine engine) throws IncQueryException {
    return PropertyUnrecognizedElementMatcher.on(engine);
  }
  
  public PropertyCannotBeDefaultInitializedQuerySpecification getPropertyCannotBeDefaultInitialized() throws IncQueryException {
    return PropertyCannotBeDefaultInitializedQuerySpecification.instance();
  }
  
  public PropertyCannotBeDefaultInitializedMatcher getPropertyCannotBeDefaultInitialized(final IncQueryEngine engine) throws IncQueryException {
    return PropertyCannotBeDefaultInitializedMatcher.on(engine);
  }
  
  public ReturnTypeMultiplicityQuerySpecification getReturnTypeMultiplicity() throws IncQueryException {
    return ReturnTypeMultiplicityQuerySpecification.instance();
  }
  
  public ReturnTypeMultiplicityMatcher getReturnTypeMultiplicity(final IncQueryEngine engine) throws IncQueryException {
    return ReturnTypeMultiplicityMatcher.on(engine);
  }
  
  public AbstractOperationWithMethodQuerySpecification getAbstractOperationWithMethod() throws IncQueryException {
    return AbstractOperationWithMethodQuerySpecification.instance();
  }
  
  public AbstractOperationWithMethodMatcher getAbstractOperationWithMethod(final IncQueryEngine engine) throws IncQueryException {
    return AbstractOperationWithMethodMatcher.on(engine);
  }
  
  public RedefiningNameDifferentQuerySpecification getRedefiningNameDifferent() throws IncQueryException {
    return RedefiningNameDifferentQuerySpecification.instance();
  }
  
  public RedefiningNameDifferentMatcher getRedefiningNameDifferent(final IncQueryEngine engine) throws IncQueryException {
    return RedefiningNameDifferentMatcher.on(engine);
  }
  
  public RedefinedMustBeInAncestorQuerySpecification getRedefinedMustBeInAncestor() throws IncQueryException {
    return RedefinedMustBeInAncestorQuerySpecification.instance();
  }
  
  public RedefinedMustBeInAncestorMatcher getRedefinedMustBeInAncestor(final IncQueryEngine engine) throws IncQueryException {
    return RedefinedMustBeInAncestorMatcher.on(engine);
  }
  
  public RedefiningAbstractQuerySpecification getRedefiningAbstract() throws IncQueryException {
    return RedefiningAbstractQuerySpecification.instance();
  }
  
  public RedefiningAbstractMatcher getRedefiningAbstract(final IncQueryEngine engine) throws IncQueryException {
    return RedefiningAbstractMatcher.on(engine);
  }
  
  public RedefiningStaticQuerySpecification getRedefiningStatic() throws IncQueryException {
    return RedefiningStaticQuerySpecification.instance();
  }
  
  public RedefiningStaticMatcher getRedefiningStatic(final IncQueryEngine engine) throws IncQueryException {
    return RedefiningStaticMatcher.on(engine);
  }
  
  public RedefinedStaticQuerySpecification getRedefinedStatic() throws IncQueryException {
    return RedefinedStaticQuerySpecification.instance();
  }
  
  public RedefinedStaticMatcher getRedefinedStatic(final IncQueryEngine engine) throws IncQueryException {
    return RedefinedStaticMatcher.on(engine);
  }
  
  public RedefinedLeafQuerySpecification getRedefinedLeaf() throws IncQueryException {
    return RedefinedLeafQuerySpecification.instance();
  }
  
  public RedefinedLeafMatcher getRedefinedLeaf(final IncQueryEngine engine) throws IncQueryException {
    return RedefinedLeafMatcher.on(engine);
  }
  
  public ClassContainsAbstractOperationQuerySpecification getClassContainsAbstractOperation() throws IncQueryException {
    return ClassContainsAbstractOperationQuerySpecification.instance();
  }
  
  public ClassContainsAbstractOperationMatcher getClassContainsAbstractOperation(final IncQueryEngine engine) throws IncQueryException {
    return ClassContainsAbstractOperationMatcher.on(engine);
  }
  
  public StaticAbstractOperationQuerySpecification getStaticAbstractOperation() throws IncQueryException {
    return StaticAbstractOperationQuerySpecification.instance();
  }
  
  public StaticAbstractOperationMatcher getStaticAbstractOperation(final IncQueryEngine engine) throws IncQueryException {
    return StaticAbstractOperationMatcher.on(engine);
  }
  
  public UnmarkedConstructorQuerySpecification getUnmarkedConstructor() throws IncQueryException {
    return UnmarkedConstructorQuerySpecification.instance();
  }
  
  public UnmarkedConstructorMatcher getUnmarkedConstructor(final IncQueryEngine engine) throws IncQueryException {
    return UnmarkedConstructorMatcher.on(engine);
  }
  
  public ConstructorWrongNameQuerySpecification getConstructorWrongName() throws IncQueryException {
    return ConstructorWrongNameQuerySpecification.instance();
  }
  
  public ConstructorWrongNameMatcher getConstructorWrongName(final IncQueryEngine engine) throws IncQueryException {
    return ConstructorWrongNameMatcher.on(engine);
  }
  
  public ConstructorReturnQuerySpecification getConstructorReturn() throws IncQueryException {
    return ConstructorReturnQuerySpecification.instance();
  }
  
  public ConstructorReturnMatcher getConstructorReturn(final IncQueryEngine engine) throws IncQueryException {
    return ConstructorReturnMatcher.on(engine);
  }
  
  public UnmarkedDestructorQuerySpecification getUnmarkedDestructor() throws IncQueryException {
    return UnmarkedDestructorQuerySpecification.instance();
  }
  
  public UnmarkedDestructorMatcher getUnmarkedDestructor(final IncQueryEngine engine) throws IncQueryException {
    return UnmarkedDestructorMatcher.on(engine);
  }
  
  public DestructorWrongNameQuerySpecification getDestructorWrongName() throws IncQueryException {
    return DestructorWrongNameQuerySpecification.instance();
  }
  
  public DestructorWrongNameMatcher getDestructorWrongName(final IncQueryEngine engine) throws IncQueryException {
    return DestructorWrongNameMatcher.on(engine);
  }
  
  public DestructorParameterQuerySpecification getDestructorParameter() throws IncQueryException {
    return DestructorParameterQuerySpecification.instance();
  }
  
  public DestructorParameterMatcher getDestructorParameter(final IncQueryEngine engine) throws IncQueryException {
    return DestructorParameterMatcher.on(engine);
  }
  
  public MethodNotOpaqueBehaviorQuerySpecification getMethodNotOpaqueBehavior() throws IncQueryException {
    return MethodNotOpaqueBehaviorQuerySpecification.instance();
  }
  
  public MethodNotOpaqueBehaviorMatcher getMethodNotOpaqueBehavior(final IncQueryEngine engine) throws IncQueryException {
    return MethodNotOpaqueBehaviorMatcher.on(engine);
  }
  
  public OperationNotPublicQuerySpecification getOperationNotPublic() throws IncQueryException {
    return OperationNotPublicQuerySpecification.instance();
  }
  
  public OperationNotPublicMatcher getOperationNotPublic(final IncQueryEngine engine) throws IncQueryException {
    return OperationNotPublicMatcher.on(engine);
  }
  
  public MethodWithoutRalfQuerySpecification getMethodWithoutRalf() throws IncQueryException {
    return MethodWithoutRalfQuerySpecification.instance();
  }
  
  public MethodWithoutRalfMatcher getMethodWithoutRalf(final IncQueryEngine engine) throws IncQueryException {
    return MethodWithoutRalfMatcher.on(engine);
  }
  
  public MethodWithoutSpecificationQuerySpecification getMethodWithoutSpecification() throws IncQueryException {
    return MethodWithoutSpecificationQuerySpecification.instance();
  }
  
  public MethodWithoutSpecificationMatcher getMethodWithoutSpecification(final IncQueryEngine engine) throws IncQueryException {
    return MethodWithoutSpecificationMatcher.on(engine);
  }
  
  public MethodClassifierBehaviorQuerySpecification getMethodClassifierBehavior() throws IncQueryException {
    return MethodClassifierBehaviorQuerySpecification.instance();
  }
  
  public MethodClassifierBehaviorMatcher getMethodClassifierBehavior(final IncQueryEngine engine) throws IncQueryException {
    return MethodClassifierBehaviorMatcher.on(engine);
  }
  
  public MethodAbstractQuerySpecification getMethodAbstract() throws IncQueryException {
    return MethodAbstractQuerySpecification.instance();
  }
  
  public MethodAbstractMatcher getMethodAbstract(final IncQueryEngine engine) throws IncQueryException {
    return MethodAbstractMatcher.on(engine);
  }
  
  public MethodActiveQuerySpecification getMethodActive() throws IncQueryException {
    return MethodActiveQuerySpecification.instance();
  }
  
  public MethodActiveMatcher getMethodActive(final IncQueryEngine engine) throws IncQueryException {
    return MethodActiveMatcher.on(engine);
  }
  
  public MethodReentrantQuerySpecification getMethodReentrant() throws IncQueryException {
    return MethodReentrantQuerySpecification.instance();
  }
  
  public MethodReentrantMatcher getMethodReentrant(final IncQueryEngine engine) throws IncQueryException {
    return MethodReentrantMatcher.on(engine);
  }
  
  public MethodRedefinesQuerySpecification getMethodRedefines() throws IncQueryException {
    return MethodRedefinesQuerySpecification.instance();
  }
  
  public MethodRedefinesMatcher getMethodRedefines(final IncQueryEngine engine) throws IncQueryException {
    return MethodRedefinesMatcher.on(engine);
  }
  
  public MethodNotPublicQuerySpecification getMethodNotPublic() throws IncQueryException {
    return MethodNotPublicQuerySpecification.instance();
  }
  
  public MethodNotPublicMatcher getMethodNotPublic(final IncQueryEngine engine) throws IncQueryException {
    return MethodNotPublicMatcher.on(engine);
  }
  
  public MethodElementQuerySpecification getMethodElement() throws IncQueryException {
    return MethodElementQuerySpecification.instance();
  }
  
  public MethodElementMatcher getMethodElement(final IncQueryEngine engine) throws IncQueryException {
    return MethodElementMatcher.on(engine);
  }
  
  public MultiReturnsQuerySpecification getMultiReturns() throws IncQueryException {
    return MultiReturnsQuerySpecification.instance();
  }
  
  public MultiReturnsMatcher getMultiReturns(final IncQueryEngine engine) throws IncQueryException {
    return MultiReturnsMatcher.on(engine);
  }
  
  public ParameterWithoutTypeQuerySpecification getParameterWithoutType() throws IncQueryException {
    return ParameterWithoutTypeQuerySpecification.instance();
  }
  
  public ParameterWithoutTypeMatcher getParameterWithoutType(final IncQueryEngine engine) throws IncQueryException {
    return ParameterWithoutTypeMatcher.on(engine);
  }
  
  public ParameterEffectQuerySpecification getParameterEffect() throws IncQueryException {
    return ParameterEffectQuerySpecification.instance();
  }
  
  public ParameterEffectMatcher getParameterEffect(final IncQueryEngine engine) throws IncQueryException {
    return ParameterEffectMatcher.on(engine);
  }
  
  public ParameterExceptionQuerySpecification getParameterException() throws IncQueryException {
    return ParameterExceptionQuerySpecification.instance();
  }
  
  public ParameterExceptionMatcher getParameterException(final IncQueryEngine engine) throws IncQueryException {
    return ParameterExceptionMatcher.on(engine);
  }
  
  public ParameterStreamQuerySpecification getParameterStream() throws IncQueryException {
    return ParameterStreamQuerySpecification.instance();
  }
  
  public ParameterStreamMatcher getParameterStream(final IncQueryEngine engine) throws IncQueryException {
    return ParameterStreamMatcher.on(engine);
  }
  
  public ParameterSetQuerySpecification getParameterSet() throws IncQueryException {
    return ParameterSetQuerySpecification.instance();
  }
  
  public ParameterSetMatcher getParameterSet(final IncQueryEngine engine) throws IncQueryException {
    return ParameterSetMatcher.on(engine);
  }
  
  public ParameterNonPublicQuerySpecification getParameterNonPublic() throws IncQueryException {
    return ParameterNonPublicQuerySpecification.instance();
  }
  
  public ParameterNonPublicMatcher getParameterNonPublic(final IncQueryEngine engine) throws IncQueryException {
    return ParameterNonPublicMatcher.on(engine);
  }
  
  public ParameterElementQuerySpecification getParameterElement() throws IncQueryException {
    return ParameterElementQuerySpecification.instance();
  }
  
  public ParameterElementMatcher getParameterElement(final IncQueryEngine engine) throws IncQueryException {
    return ParameterElementMatcher.on(engine);
  }
  
  public AssociationNonPublicQuerySpecification getAssociationNonPublic() throws IncQueryException {
    return AssociationNonPublicQuerySpecification.instance();
  }
  
  public AssociationNonPublicMatcher getAssociationNonPublic(final IncQueryEngine engine) throws IncQueryException {
    return AssociationNonPublicMatcher.on(engine);
  }
  
  public AssociationMissingEndQuerySpecification getAssociationMissingEnd() throws IncQueryException {
    return AssociationMissingEndQuerySpecification.instance();
  }
  
  public AssociationMissingEndMatcher getAssociationMissingEnd(final IncQueryEngine engine) throws IncQueryException {
    return AssociationMissingEndMatcher.on(engine);
  }
  
  public AssociationEndMustBeClassQuerySpecification getAssociationEndMustBeClass() throws IncQueryException {
    return AssociationEndMustBeClassQuerySpecification.instance();
  }
  
  public AssociationEndMustBeClassMatcher getAssociationEndMustBeClass(final IncQueryEngine engine) throws IncQueryException {
    return AssociationEndMustBeClassMatcher.on(engine);
  }
  
  public AssociationAbstractQuerySpecification getAssociationAbstract() throws IncQueryException {
    return AssociationAbstractQuerySpecification.instance();
  }
  
  public AssociationAbstractMatcher getAssociationAbstract(final IncQueryEngine engine) throws IncQueryException {
    return AssociationAbstractMatcher.on(engine);
  }
  
  public AssociationDerivedQuerySpecification getAssociationDerived() throws IncQueryException {
    return AssociationDerivedQuerySpecification.instance();
  }
  
  public AssociationDerivedMatcher getAssociationDerived(final IncQueryEngine engine) throws IncQueryException {
    return AssociationDerivedMatcher.on(engine);
  }
  
  public AssociationElementQuerySpecification getAssociationElement() throws IncQueryException {
    return AssociationElementQuerySpecification.instance();
  }
  
  public AssociationElementMatcher getAssociationElement(final IncQueryEngine engine) throws IncQueryException {
    return AssociationElementMatcher.on(engine);
  }
  
  public ReceptionWithoutSignalQuerySpecification getReceptionWithoutSignal() throws IncQueryException {
    return ReceptionWithoutSignalQuerySpecification.instance();
  }
  
  public ReceptionWithoutSignalMatcher getReceptionWithoutSignal(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionWithoutSignalMatcher.on(engine);
  }
  
  public ReceptionAbstractQuerySpecification getReceptionAbstract() throws IncQueryException {
    return ReceptionAbstractQuerySpecification.instance();
  }
  
  public ReceptionAbstractMatcher getReceptionAbstract(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionAbstractMatcher.on(engine);
  }
  
  public ReceptionParameterNotInQuerySpecification getReceptionParameterNotIn() throws IncQueryException {
    return ReceptionParameterNotInQuerySpecification.instance();
  }
  
  public ReceptionParameterNotInMatcher getReceptionParameterNotIn(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionParameterNotInMatcher.on(engine);
  }
  
  public ReceptionStaticQuerySpecification getReceptionStatic() throws IncQueryException {
    return ReceptionStaticQuerySpecification.instance();
  }
  
  public ReceptionStaticMatcher getReceptionStatic(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionStaticMatcher.on(engine);
  }
  
  public ReceptionMethodQuerySpecification getReceptionMethod() throws IncQueryException {
    return ReceptionMethodQuerySpecification.instance();
  }
  
  public ReceptionMethodMatcher getReceptionMethod(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionMethodMatcher.on(engine);
  }
  
  public ReceptionRaisedExceptionQuerySpecification getReceptionRaisedException() throws IncQueryException {
    return ReceptionRaisedExceptionQuerySpecification.instance();
  }
  
  public ReceptionRaisedExceptionMatcher getReceptionRaisedException(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionRaisedExceptionMatcher.on(engine);
  }
  
  public ReceptionNonPublicQuerySpecification getReceptionNonPublic() throws IncQueryException {
    return ReceptionNonPublicQuerySpecification.instance();
  }
  
  public ReceptionNonPublicMatcher getReceptionNonPublic(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionNonPublicMatcher.on(engine);
  }
  
  public ReceptionElementQuerySpecification getReceptionElement() throws IncQueryException {
    return ReceptionElementQuerySpecification.instance();
  }
  
  public ReceptionElementMatcher getReceptionElement(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionElementMatcher.on(engine);
  }
}
