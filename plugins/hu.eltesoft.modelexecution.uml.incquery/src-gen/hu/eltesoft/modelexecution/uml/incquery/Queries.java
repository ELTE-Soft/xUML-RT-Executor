package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEndMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.EntryMatcher;
import hu.eltesoft.modelexecution.uml.incquery.EventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ExitMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ExternalOperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.FinalStateMatcher;
import hu.eltesoft.modelexecution.uml.incquery.InitialsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;
import hu.eltesoft.modelexecution.uml.incquery.NamedClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.NamedOperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.NamedReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;
import hu.eltesoft.modelexecution.uml.incquery.StateMatcher;
import hu.eltesoft.modelexecution.uml.incquery.StaticBehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatcher;
import hu.eltesoft.modelexecution.uml.incquery.TransitionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AlfCodeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationEndQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationEndTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationOtherEndQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorReturnLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorReturnTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorReturnUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClsQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfRegionQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.EntryQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.EventQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ExitQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ExternalOperationParameterQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.FinalStateQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.InitialsQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.MethodQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.NamedClsQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.NamedOperationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.NamedReceptionQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionParameterLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionParameterQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionParameterUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.RegionOfClassQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.RegionQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalEventQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.StateQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.StaticBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionEffectQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in queries.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file queries.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.uml.incquery, the group contains the definition of the following patterns: <ul>
 * <li>Association</li>
 * <li>AssociationEnd</li>
 * <li>AssociationEndType</li>
 * <li>AssociationOtherEnd</li>
 * <li>Behavior</li>
 * <li>ContainerClassOfBehavior</li>
 * <li>BehaviorParameter</li>
 * <li>BehaviorParameterType</li>
 * <li>BehaviorParameterLowerBound</li>
 * <li>BehaviorParameterUpperBound</li>
 * <li>BehaviorReturnType</li>
 * <li>BehaviorReturnLowerBound</li>
 * <li>BehaviorReturnUpperBound</li>
 * <li>StaticBehavior</li>
 * <li>AlfCode</li>
 * <li>ContainerClassOfVertex</li>
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
 * <li>ReceptionParameter</li>
 * <li>ReceptionParameterLowerBound</li>
 * <li>ReceptionParameterUpperBound</li>
 * <li>ClassAssociation</li>
 * <li>ClassAssociationType</li>
 * <li>ClassAssociationLowerBound</li>
 * <li>ClassAssociationUpperBound</li>
 * <li>Event</li>
 * <li>SignalEvent</li>
 * <li>NamedCls</li>
 * <li>NamedOperation</li>
 * <li>ExternalOperationParameter</li>
 * <li>NamedReception</li>
 * <li>Region</li>
 * <li>ContainerClassOfRegion</li>
 * <li>Initials</li>
 * <li>State</li>
 * <li>FinalState</li>
 * <li>Entry</li>
 * <li>Exit</li>
 * <li>Transition</li>
 * <li>TransitionBase</li>
 * <li>TransitionEffect</li>
 * <li>Signal</li>
 * <li>SignalAttribute</li>
 * <li>SignalAttributeLowerBound</li>
 * <li>SignalAttributeUpperBound</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Queries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Queries instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Queries();
    }
    return INSTANCE;
    
  }
  
  private static Queries INSTANCE;
  
  private Queries() throws IncQueryException {
    querySpecifications.add(AssociationQuerySpecification.instance());
    querySpecifications.add(AssociationEndQuerySpecification.instance());
    querySpecifications.add(AssociationEndTypeQuerySpecification.instance());
    querySpecifications.add(AssociationOtherEndQuerySpecification.instance());
    querySpecifications.add(BehaviorQuerySpecification.instance());
    querySpecifications.add(ContainerClassOfBehaviorQuerySpecification.instance());
    querySpecifications.add(BehaviorParameterQuerySpecification.instance());
    querySpecifications.add(BehaviorParameterTypeQuerySpecification.instance());
    querySpecifications.add(BehaviorParameterLowerBoundQuerySpecification.instance());
    querySpecifications.add(BehaviorParameterUpperBoundQuerySpecification.instance());
    querySpecifications.add(BehaviorReturnTypeQuerySpecification.instance());
    querySpecifications.add(BehaviorReturnLowerBoundQuerySpecification.instance());
    querySpecifications.add(BehaviorReturnUpperBoundQuerySpecification.instance());
    querySpecifications.add(StaticBehaviorQuerySpecification.instance());
    querySpecifications.add(AlfCodeQuerySpecification.instance());
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
    querySpecifications.add(ReceptionParameterQuerySpecification.instance());
    querySpecifications.add(ReceptionParameterLowerBoundQuerySpecification.instance());
    querySpecifications.add(ReceptionParameterUpperBoundQuerySpecification.instance());
    querySpecifications.add(ClassAssociationQuerySpecification.instance());
    querySpecifications.add(ClassAssociationTypeQuerySpecification.instance());
    querySpecifications.add(ClassAssociationLowerBoundQuerySpecification.instance());
    querySpecifications.add(ClassAssociationUpperBoundQuerySpecification.instance());
    querySpecifications.add(EventQuerySpecification.instance());
    querySpecifications.add(SignalEventQuerySpecification.instance());
    querySpecifications.add(NamedClsQuerySpecification.instance());
    querySpecifications.add(NamedOperationQuerySpecification.instance());
    querySpecifications.add(ExternalOperationParameterQuerySpecification.instance());
    querySpecifications.add(NamedReceptionQuerySpecification.instance());
    querySpecifications.add(RegionQuerySpecification.instance());
    querySpecifications.add(ContainerClassOfRegionQuerySpecification.instance());
    querySpecifications.add(InitialsQuerySpecification.instance());
    querySpecifications.add(StateQuerySpecification.instance());
    querySpecifications.add(FinalStateQuerySpecification.instance());
    querySpecifications.add(EntryQuerySpecification.instance());
    querySpecifications.add(ExitQuerySpecification.instance());
    querySpecifications.add(TransitionQuerySpecification.instance());
    querySpecifications.add(TransitionEffectQuerySpecification.instance());
    querySpecifications.add(SignalQuerySpecification.instance());
    querySpecifications.add(SignalAttributeQuerySpecification.instance());
    querySpecifications.add(SignalAttributeLowerBoundQuerySpecification.instance());
    querySpecifications.add(SignalAttributeUpperBoundQuerySpecification.instance());
    
  }
  
  public AssociationQuerySpecification getAssociation() throws IncQueryException {
    return AssociationQuerySpecification.instance();
  }
  
  public AssociationMatcher getAssociation(final IncQueryEngine engine) throws IncQueryException {
    return AssociationMatcher.on(engine);
  }
  
  public AssociationEndQuerySpecification getAssociationEnd() throws IncQueryException {
    return AssociationEndQuerySpecification.instance();
  }
  
  public AssociationEndMatcher getAssociationEnd(final IncQueryEngine engine) throws IncQueryException {
    return AssociationEndMatcher.on(engine);
  }
  
  public AssociationEndTypeQuerySpecification getAssociationEndType() throws IncQueryException {
    return AssociationEndTypeQuerySpecification.instance();
  }
  
  public AssociationEndTypeMatcher getAssociationEndType(final IncQueryEngine engine) throws IncQueryException {
    return AssociationEndTypeMatcher.on(engine);
  }
  
  public AssociationOtherEndQuerySpecification getAssociationOtherEnd() throws IncQueryException {
    return AssociationOtherEndQuerySpecification.instance();
  }
  
  public AssociationOtherEndMatcher getAssociationOtherEnd(final IncQueryEngine engine) throws IncQueryException {
    return AssociationOtherEndMatcher.on(engine);
  }
  
  public BehaviorQuerySpecification getBehavior() throws IncQueryException {
    return BehaviorQuerySpecification.instance();
  }
  
  public BehaviorMatcher getBehavior(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorMatcher.on(engine);
  }
  
  public ContainerClassOfBehaviorQuerySpecification getContainerClassOfBehavior() throws IncQueryException {
    return ContainerClassOfBehaviorQuerySpecification.instance();
  }
  
  public ContainerClassOfBehaviorMatcher getContainerClassOfBehavior(final IncQueryEngine engine) throws IncQueryException {
    return ContainerClassOfBehaviorMatcher.on(engine);
  }
  
  public BehaviorParameterQuerySpecification getBehaviorParameter() throws IncQueryException {
    return BehaviorParameterQuerySpecification.instance();
  }
  
  public BehaviorParameterMatcher getBehaviorParameter(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterMatcher.on(engine);
  }
  
  public BehaviorParameterTypeQuerySpecification getBehaviorParameterType() throws IncQueryException {
    return BehaviorParameterTypeQuerySpecification.instance();
  }
  
  public BehaviorParameterTypeMatcher getBehaviorParameterType(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterTypeMatcher.on(engine);
  }
  
  public BehaviorParameterLowerBoundQuerySpecification getBehaviorParameterLowerBound() throws IncQueryException {
    return BehaviorParameterLowerBoundQuerySpecification.instance();
  }
  
  public BehaviorParameterLowerBoundMatcher getBehaviorParameterLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterLowerBoundMatcher.on(engine);
  }
  
  public BehaviorParameterUpperBoundQuerySpecification getBehaviorParameterUpperBound() throws IncQueryException {
    return BehaviorParameterUpperBoundQuerySpecification.instance();
  }
  
  public BehaviorParameterUpperBoundMatcher getBehaviorParameterUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterUpperBoundMatcher.on(engine);
  }
  
  public BehaviorReturnTypeQuerySpecification getBehaviorReturnType() throws IncQueryException {
    return BehaviorReturnTypeQuerySpecification.instance();
  }
  
  public BehaviorReturnTypeMatcher getBehaviorReturnType(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorReturnTypeMatcher.on(engine);
  }
  
  public BehaviorReturnLowerBoundQuerySpecification getBehaviorReturnLowerBound() throws IncQueryException {
    return BehaviorReturnLowerBoundQuerySpecification.instance();
  }
  
  public BehaviorReturnLowerBoundMatcher getBehaviorReturnLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorReturnLowerBoundMatcher.on(engine);
  }
  
  public BehaviorReturnUpperBoundQuerySpecification getBehaviorReturnUpperBound() throws IncQueryException {
    return BehaviorReturnUpperBoundQuerySpecification.instance();
  }
  
  public BehaviorReturnUpperBoundMatcher getBehaviorReturnUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorReturnUpperBoundMatcher.on(engine);
  }
  
  public StaticBehaviorQuerySpecification getStaticBehavior() throws IncQueryException {
    return StaticBehaviorQuerySpecification.instance();
  }
  
  public StaticBehaviorMatcher getStaticBehavior(final IncQueryEngine engine) throws IncQueryException {
    return StaticBehaviorMatcher.on(engine);
  }
  
  public AlfCodeQuerySpecification getAlfCode() throws IncQueryException {
    return AlfCodeQuerySpecification.instance();
  }
  
  public AlfCodeMatcher getAlfCode(final IncQueryEngine engine) throws IncQueryException {
    return AlfCodeMatcher.on(engine);
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
  
  public ReceptionParameterQuerySpecification getReceptionParameter() throws IncQueryException {
    return ReceptionParameterQuerySpecification.instance();
  }
  
  public ReceptionParameterMatcher getReceptionParameter(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionParameterMatcher.on(engine);
  }
  
  public ReceptionParameterLowerBoundQuerySpecification getReceptionParameterLowerBound() throws IncQueryException {
    return ReceptionParameterLowerBoundQuerySpecification.instance();
  }
  
  public ReceptionParameterLowerBoundMatcher getReceptionParameterLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionParameterLowerBoundMatcher.on(engine);
  }
  
  public ReceptionParameterUpperBoundQuerySpecification getReceptionParameterUpperBound() throws IncQueryException {
    return ReceptionParameterUpperBoundQuerySpecification.instance();
  }
  
  public ReceptionParameterUpperBoundMatcher getReceptionParameterUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionParameterUpperBoundMatcher.on(engine);
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
  
  public EventQuerySpecification getEvent() throws IncQueryException {
    return EventQuerySpecification.instance();
  }
  
  public EventMatcher getEvent(final IncQueryEngine engine) throws IncQueryException {
    return EventMatcher.on(engine);
  }
  
  public SignalEventQuerySpecification getSignalEvent() throws IncQueryException {
    return SignalEventQuerySpecification.instance();
  }
  
  public SignalEventMatcher getSignalEvent(final IncQueryEngine engine) throws IncQueryException {
    return SignalEventMatcher.on(engine);
  }
  
  public NamedClsQuerySpecification getNamedCls() throws IncQueryException {
    return NamedClsQuerySpecification.instance();
  }
  
  public NamedClsMatcher getNamedCls(final IncQueryEngine engine) throws IncQueryException {
    return NamedClsMatcher.on(engine);
  }
  
  public NamedOperationQuerySpecification getNamedOperation() throws IncQueryException {
    return NamedOperationQuerySpecification.instance();
  }
  
  public NamedOperationMatcher getNamedOperation(final IncQueryEngine engine) throws IncQueryException {
    return NamedOperationMatcher.on(engine);
  }
  
  public ExternalOperationParameterQuerySpecification getExternalOperationParameter() throws IncQueryException {
    return ExternalOperationParameterQuerySpecification.instance();
  }
  
  public ExternalOperationParameterMatcher getExternalOperationParameter(final IncQueryEngine engine) throws IncQueryException {
    return ExternalOperationParameterMatcher.on(engine);
  }
  
  public NamedReceptionQuerySpecification getNamedReception() throws IncQueryException {
    return NamedReceptionQuerySpecification.instance();
  }
  
  public NamedReceptionMatcher getNamedReception(final IncQueryEngine engine) throws IncQueryException {
    return NamedReceptionMatcher.on(engine);
  }
  
  public RegionQuerySpecification getRegion() throws IncQueryException {
    return RegionQuerySpecification.instance();
  }
  
  public RegionMatcher getRegion(final IncQueryEngine engine) throws IncQueryException {
    return RegionMatcher.on(engine);
  }
  
  public ContainerClassOfRegionQuerySpecification getContainerClassOfRegion() throws IncQueryException {
    return ContainerClassOfRegionQuerySpecification.instance();
  }
  
  public ContainerClassOfRegionMatcher getContainerClassOfRegion(final IncQueryEngine engine) throws IncQueryException {
    return ContainerClassOfRegionMatcher.on(engine);
  }
  
  public InitialsQuerySpecification getInitials() throws IncQueryException {
    return InitialsQuerySpecification.instance();
  }
  
  public InitialsMatcher getInitials(final IncQueryEngine engine) throws IncQueryException {
    return InitialsMatcher.on(engine);
  }
  
  public StateQuerySpecification getState() throws IncQueryException {
    return StateQuerySpecification.instance();
  }
  
  public StateMatcher getState(final IncQueryEngine engine) throws IncQueryException {
    return StateMatcher.on(engine);
  }
  
  public FinalStateQuerySpecification getFinalState() throws IncQueryException {
    return FinalStateQuerySpecification.instance();
  }
  
  public FinalStateMatcher getFinalState(final IncQueryEngine engine) throws IncQueryException {
    return FinalStateMatcher.on(engine);
  }
  
  public EntryQuerySpecification getEntry() throws IncQueryException {
    return EntryQuerySpecification.instance();
  }
  
  public EntryMatcher getEntry(final IncQueryEngine engine) throws IncQueryException {
    return EntryMatcher.on(engine);
  }
  
  public ExitQuerySpecification getExit() throws IncQueryException {
    return ExitQuerySpecification.instance();
  }
  
  public ExitMatcher getExit(final IncQueryEngine engine) throws IncQueryException {
    return ExitMatcher.on(engine);
  }
  
  public TransitionQuerySpecification getTransition() throws IncQueryException {
    return TransitionQuerySpecification.instance();
  }
  
  public TransitionMatcher getTransition(final IncQueryEngine engine) throws IncQueryException {
    return TransitionMatcher.on(engine);
  }
  
  public TransitionEffectQuerySpecification getTransitionEffect() throws IncQueryException {
    return TransitionEffectQuerySpecification.instance();
  }
  
  public TransitionEffectMatcher getTransitionEffect(final IncQueryEngine engine) throws IncQueryException {
    return TransitionEffectMatcher.on(engine);
  }
  
  public SignalQuerySpecification getSignal() throws IncQueryException {
    return SignalQuerySpecification.instance();
  }
  
  public SignalMatcher getSignal(final IncQueryEngine engine) throws IncQueryException {
    return SignalMatcher.on(engine);
  }
  
  public SignalAttributeQuerySpecification getSignalAttribute() throws IncQueryException {
    return SignalAttributeQuerySpecification.instance();
  }
  
  public SignalAttributeMatcher getSignalAttribute(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeMatcher.on(engine);
  }
  
  public SignalAttributeLowerBoundQuerySpecification getSignalAttributeLowerBound() throws IncQueryException {
    return SignalAttributeLowerBoundQuerySpecification.instance();
  }
  
  public SignalAttributeLowerBoundMatcher getSignalAttributeLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeLowerBoundMatcher.on(engine);
  }
  
  public SignalAttributeUpperBoundQuerySpecification getSignalAttributeUpperBound() throws IncQueryException {
    return SignalAttributeUpperBoundQuerySpecification.instance();
  }
  
  public SignalAttributeUpperBoundMatcher getSignalAttributeUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeUpperBoundMatcher.on(engine);
  }
}
