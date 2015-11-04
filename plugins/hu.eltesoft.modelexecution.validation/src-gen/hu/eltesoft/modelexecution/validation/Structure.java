package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.AbstractSignalMatcher;
import hu.eltesoft.modelexecution.validation.ComponentClassifierBehaviorMatcher;
import hu.eltesoft.modelexecution.validation.ComponentDirectlyInstantiatedMatcher;
import hu.eltesoft.modelexecution.validation.ComponentNonPublicMatcher;
import hu.eltesoft.modelexecution.validation.EventIsNotSignalEventMatcher;
import hu.eltesoft.modelexecution.validation.EventNonPublicMatcher;
import hu.eltesoft.modelexecution.validation.ForbiddenComponentMemberMatcher;
import hu.eltesoft.modelexecution.validation.ForbiddenModelMemberMatcher;
import hu.eltesoft.modelexecution.validation.ForbiddenPackageMemberMatcher;
import hu.eltesoft.modelexecution.validation.ModelViewpointMatcher;
import hu.eltesoft.modelexecution.validation.PackageImportNonPublicMatcher;
import hu.eltesoft.modelexecution.validation.PackageMergeMatcher;
import hu.eltesoft.modelexecution.validation.PackageNonPublicMatcher;
import hu.eltesoft.modelexecution.validation.PackageTemplateBindingMatcher;
import hu.eltesoft.modelexecution.validation.PackageTemplateParameterMatcher;
import hu.eltesoft.modelexecution.validation.SignalElementMatcher;
import hu.eltesoft.modelexecution.validation.SignalEventWithNoEventMatcher;
import hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEventsMatcher;
import hu.eltesoft.modelexecution.validation.SignalNonPublicMatcher;
import hu.eltesoft.modelexecution.validation.SignalPropertyMultipleMatcher;
import hu.eltesoft.modelexecution.validation.SignalPropertyNotPrimitiveMatcher;
import hu.eltesoft.modelexecution.validation.SignalPropertyStaticMatcher;
import hu.eltesoft.modelexecution.validation.util.AbstractSignalQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ComponentClassifierBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ComponentDirectlyInstantiatedQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ComponentNonPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.EventIsNotSignalEventQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.EventNonPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ForbiddenComponentMemberQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ForbiddenModelMemberQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ForbiddenPackageMemberQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ModelViewpointQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PackageImportNonPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PackageMergeQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PackageNonPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PackageTemplateBindingQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PackageTemplateParameterQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.SignalElementQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.SignalEventWithNoEventQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.SignalInMultipleSignalEventsQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.SignalNonPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.SignalPropertyMultipleQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.SignalPropertyNotPrimitiveQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.SignalPropertyStaticQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in Structure.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file Structure.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.validation, the group contains the definition of the following patterns: <ul>
 * <li>GeneralPackagedElement</li>
 * <li>Model</li>
 * <li>ForbiddenModelMember</li>
 * <li>ModelViewpoint</li>
 * <li>PackageImport</li>
 * <li>PackageImportNonPublic</li>
 * <li>Package</li>
 * <li>PackageMerge</li>
 * <li>PackageTemplateBinding</li>
 * <li>PackageTemplateParameter</li>
 * <li>PackageNonPublic</li>
 * <li>ForbiddenPackageMember</li>
 * <li>Component</li>
 * <li>ForbiddenComponentMember</li>
 * <li>ComponentNonPublic</li>
 * <li>ComponentClassifierBehavior</li>
 * <li>ComponentDirectlyInstantiated</li>
 * <li>IsSignalEvent</li>
 * <li>EventIsNotSignalEvent</li>
 * <li>SignalEventWithNoEvent</li>
 * <li>SignalInMultipleSignalEvents</li>
 * <li>EventNonPublic</li>
 * <li>Signal</li>
 * <li>AbstractSignal</li>
 * <li>SignalPropertyStatic</li>
 * <li>SignalPropertyMultiple</li>
 * <li>SignalPropertyNotPrimitive</li>
 * <li>PrimitiveType</li>
 * <li>SignalNonPublic</li>
 * <li>SignalElement</li>
 * <li>SignalProperty</li>
 * <li>ProfileApplication</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Structure extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Structure instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Structure();
    }
    return INSTANCE;
  }
  
  private static Structure INSTANCE;
  
  private Structure() throws IncQueryException {
    querySpecifications.add(ForbiddenModelMemberQuerySpecification.instance());
    querySpecifications.add(ModelViewpointQuerySpecification.instance());
    querySpecifications.add(PackageImportNonPublicQuerySpecification.instance());
    querySpecifications.add(PackageMergeQuerySpecification.instance());
    querySpecifications.add(PackageTemplateBindingQuerySpecification.instance());
    querySpecifications.add(PackageTemplateParameterQuerySpecification.instance());
    querySpecifications.add(PackageNonPublicQuerySpecification.instance());
    querySpecifications.add(ForbiddenPackageMemberQuerySpecification.instance());
    querySpecifications.add(ForbiddenComponentMemberQuerySpecification.instance());
    querySpecifications.add(ComponentNonPublicQuerySpecification.instance());
    querySpecifications.add(ComponentClassifierBehaviorQuerySpecification.instance());
    querySpecifications.add(ComponentDirectlyInstantiatedQuerySpecification.instance());
    querySpecifications.add(EventIsNotSignalEventQuerySpecification.instance());
    querySpecifications.add(SignalEventWithNoEventQuerySpecification.instance());
    querySpecifications.add(SignalInMultipleSignalEventsQuerySpecification.instance());
    querySpecifications.add(EventNonPublicQuerySpecification.instance());
    querySpecifications.add(AbstractSignalQuerySpecification.instance());
    querySpecifications.add(SignalPropertyStaticQuerySpecification.instance());
    querySpecifications.add(SignalPropertyMultipleQuerySpecification.instance());
    querySpecifications.add(SignalPropertyNotPrimitiveQuerySpecification.instance());
    querySpecifications.add(SignalNonPublicQuerySpecification.instance());
    querySpecifications.add(SignalElementQuerySpecification.instance());
  }
  
  public ForbiddenModelMemberQuerySpecification getForbiddenModelMember() throws IncQueryException {
    return ForbiddenModelMemberQuerySpecification.instance();
  }
  
  public ForbiddenModelMemberMatcher getForbiddenModelMember(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenModelMemberMatcher.on(engine);
  }
  
  public ModelViewpointQuerySpecification getModelViewpoint() throws IncQueryException {
    return ModelViewpointQuerySpecification.instance();
  }
  
  public ModelViewpointMatcher getModelViewpoint(final IncQueryEngine engine) throws IncQueryException {
    return ModelViewpointMatcher.on(engine);
  }
  
  public PackageImportNonPublicQuerySpecification getPackageImportNonPublic() throws IncQueryException {
    return PackageImportNonPublicQuerySpecification.instance();
  }
  
  public PackageImportNonPublicMatcher getPackageImportNonPublic(final IncQueryEngine engine) throws IncQueryException {
    return PackageImportNonPublicMatcher.on(engine);
  }
  
  public PackageMergeQuerySpecification getPackageMerge() throws IncQueryException {
    return PackageMergeQuerySpecification.instance();
  }
  
  public PackageMergeMatcher getPackageMerge(final IncQueryEngine engine) throws IncQueryException {
    return PackageMergeMatcher.on(engine);
  }
  
  public PackageTemplateBindingQuerySpecification getPackageTemplateBinding() throws IncQueryException {
    return PackageTemplateBindingQuerySpecification.instance();
  }
  
  public PackageTemplateBindingMatcher getPackageTemplateBinding(final IncQueryEngine engine) throws IncQueryException {
    return PackageTemplateBindingMatcher.on(engine);
  }
  
  public PackageTemplateParameterQuerySpecification getPackageTemplateParameter() throws IncQueryException {
    return PackageTemplateParameterQuerySpecification.instance();
  }
  
  public PackageTemplateParameterMatcher getPackageTemplateParameter(final IncQueryEngine engine) throws IncQueryException {
    return PackageTemplateParameterMatcher.on(engine);
  }
  
  public PackageNonPublicQuerySpecification getPackageNonPublic() throws IncQueryException {
    return PackageNonPublicQuerySpecification.instance();
  }
  
  public PackageNonPublicMatcher getPackageNonPublic(final IncQueryEngine engine) throws IncQueryException {
    return PackageNonPublicMatcher.on(engine);
  }
  
  public ForbiddenPackageMemberQuerySpecification getForbiddenPackageMember() throws IncQueryException {
    return ForbiddenPackageMemberQuerySpecification.instance();
  }
  
  public ForbiddenPackageMemberMatcher getForbiddenPackageMember(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenPackageMemberMatcher.on(engine);
  }
  
  public ForbiddenComponentMemberQuerySpecification getForbiddenComponentMember() throws IncQueryException {
    return ForbiddenComponentMemberQuerySpecification.instance();
  }
  
  public ForbiddenComponentMemberMatcher getForbiddenComponentMember(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenComponentMemberMatcher.on(engine);
  }
  
  public ComponentNonPublicQuerySpecification getComponentNonPublic() throws IncQueryException {
    return ComponentNonPublicQuerySpecification.instance();
  }
  
  public ComponentNonPublicMatcher getComponentNonPublic(final IncQueryEngine engine) throws IncQueryException {
    return ComponentNonPublicMatcher.on(engine);
  }
  
  public ComponentClassifierBehaviorQuerySpecification getComponentClassifierBehavior() throws IncQueryException {
    return ComponentClassifierBehaviorQuerySpecification.instance();
  }
  
  public ComponentClassifierBehaviorMatcher getComponentClassifierBehavior(final IncQueryEngine engine) throws IncQueryException {
    return ComponentClassifierBehaviorMatcher.on(engine);
  }
  
  public ComponentDirectlyInstantiatedQuerySpecification getComponentDirectlyInstantiated() throws IncQueryException {
    return ComponentDirectlyInstantiatedQuerySpecification.instance();
  }
  
  public ComponentDirectlyInstantiatedMatcher getComponentDirectlyInstantiated(final IncQueryEngine engine) throws IncQueryException {
    return ComponentDirectlyInstantiatedMatcher.on(engine);
  }
  
  public EventIsNotSignalEventQuerySpecification getEventIsNotSignalEvent() throws IncQueryException {
    return EventIsNotSignalEventQuerySpecification.instance();
  }
  
  public EventIsNotSignalEventMatcher getEventIsNotSignalEvent(final IncQueryEngine engine) throws IncQueryException {
    return EventIsNotSignalEventMatcher.on(engine);
  }
  
  public SignalEventWithNoEventQuerySpecification getSignalEventWithNoEvent() throws IncQueryException {
    return SignalEventWithNoEventQuerySpecification.instance();
  }
  
  public SignalEventWithNoEventMatcher getSignalEventWithNoEvent(final IncQueryEngine engine) throws IncQueryException {
    return SignalEventWithNoEventMatcher.on(engine);
  }
  
  public SignalInMultipleSignalEventsQuerySpecification getSignalInMultipleSignalEvents() throws IncQueryException {
    return SignalInMultipleSignalEventsQuerySpecification.instance();
  }
  
  public SignalInMultipleSignalEventsMatcher getSignalInMultipleSignalEvents(final IncQueryEngine engine) throws IncQueryException {
    return SignalInMultipleSignalEventsMatcher.on(engine);
  }
  
  public EventNonPublicQuerySpecification getEventNonPublic() throws IncQueryException {
    return EventNonPublicQuerySpecification.instance();
  }
  
  public EventNonPublicMatcher getEventNonPublic(final IncQueryEngine engine) throws IncQueryException {
    return EventNonPublicMatcher.on(engine);
  }
  
  public AbstractSignalQuerySpecification getAbstractSignal() throws IncQueryException {
    return AbstractSignalQuerySpecification.instance();
  }
  
  public AbstractSignalMatcher getAbstractSignal(final IncQueryEngine engine) throws IncQueryException {
    return AbstractSignalMatcher.on(engine);
  }
  
  public SignalPropertyStaticQuerySpecification getSignalPropertyStatic() throws IncQueryException {
    return SignalPropertyStaticQuerySpecification.instance();
  }
  
  public SignalPropertyStaticMatcher getSignalPropertyStatic(final IncQueryEngine engine) throws IncQueryException {
    return SignalPropertyStaticMatcher.on(engine);
  }
  
  public SignalPropertyMultipleQuerySpecification getSignalPropertyMultiple() throws IncQueryException {
    return SignalPropertyMultipleQuerySpecification.instance();
  }
  
  public SignalPropertyMultipleMatcher getSignalPropertyMultiple(final IncQueryEngine engine) throws IncQueryException {
    return SignalPropertyMultipleMatcher.on(engine);
  }
  
  public SignalPropertyNotPrimitiveQuerySpecification getSignalPropertyNotPrimitive() throws IncQueryException {
    return SignalPropertyNotPrimitiveQuerySpecification.instance();
  }
  
  public SignalPropertyNotPrimitiveMatcher getSignalPropertyNotPrimitive(final IncQueryEngine engine) throws IncQueryException {
    return SignalPropertyNotPrimitiveMatcher.on(engine);
  }
  
  public SignalNonPublicQuerySpecification getSignalNonPublic() throws IncQueryException {
    return SignalNonPublicQuerySpecification.instance();
  }
  
  public SignalNonPublicMatcher getSignalNonPublic(final IncQueryEngine engine) throws IncQueryException {
    return SignalNonPublicMatcher.on(engine);
  }
  
  public SignalElementQuerySpecification getSignalElement() throws IncQueryException {
    return SignalElementQuerySpecification.instance();
  }
  
  public SignalElementMatcher getSignalElement(final IncQueryEngine engine) throws IncQueryException {
    return SignalElementMatcher.on(engine);
  }
}
