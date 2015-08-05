package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.AssociationOwnedEndMatcher;
import com.incquerylabs.emdw.umlintegration.queries.AttributeMatcher;
import com.incquerylabs.emdw.umlintegration.queries.CapsulePartMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ConnectorEndMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ConnectorMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ConstructorByNameMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ConstructorOperationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.DestructorByNameMatcher;
import com.incquerylabs.emdw.umlintegration.queries.DestructorOperationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.EnumerationLiteralMatcher;
import com.incquerylabs.emdw.umlintegration.queries.EnumerationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ModelMatcher;
import com.incquerylabs.emdw.umlintegration.queries.MultiplicityElementMatcher;
import com.incquerylabs.emdw.umlintegration.queries.NamedDataTypeMatcher;
import com.incquerylabs.emdw.umlintegration.queries.OperationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ParameterInOperationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ParameterMatcher;
import com.incquerylabs.emdw.umlintegration.queries.PrimitiveTypeMatcher;
import com.incquerylabs.emdw.umlintegration.queries.RegularOperationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.SignalAttributeMatcher;
import com.incquerylabs.emdw.umlintegration.queries.StructMemberMatcher;
import com.incquerylabs.emdw.umlintegration.queries.StructTypeInComponentMatcher;
import com.incquerylabs.emdw.umlintegration.queries.StructTypeInPackageMatcher;
import com.incquerylabs.emdw.umlintegration.queries.StructTypeMatcher;
import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionInComponentMatcher;
import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionInPackageMatcher;
import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtAssociationClassMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtAssociationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtClassEventGeneralizationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtClassEventMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtClassInComponentMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtClassInModelMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtClassInPackageMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtClassMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtComponentInModelMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtComponentInPackageMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtComponentMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtGeneralizationMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtPackageInComponentMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtPackageInModelMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtPackageInPackageMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtPackageMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtPortMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.AssociationOwnedEndQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.AttributeQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.CapsulePartQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ConnectorEndQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ConnectorQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ConstructorByNameQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ConstructorOperationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.DestructorByNameQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.DestructorOperationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.EnumerationLiteralQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.EnumerationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ModelQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.MultiplicityElementQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.NamedDataTypeQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.OperationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ParameterInOperationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ParameterQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.PrimitiveTypeQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.RegularOperationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.SignalAttributeQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StructMemberQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StructTypeInComponentQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StructTypeInPackageQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StructTypeQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.TypeDefinitionInComponentQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.TypeDefinitionInPackageQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.TypeDefinitionQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtAssociationClassQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtAssociationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassEventGeneralizationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassEventQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassInComponentQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassInModelQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassInPackageQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtComponentInModelQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtComponentInPackageQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtComponentQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtGeneralizationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageInComponentQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageInModelQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageInPackageQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPortQuerySpecification;
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
 * <p> From package com.incquerylabs.emdw.umlintegration.queries, the group contains the definition of the following patterns: <ul>
 * <li>xtPackage</li>
 * <li>model</li>
 * <li>profile</li>
 * <li>namedDataType</li>
 * <li>xtPackageInModel</li>
 * <li>xtPackageInComponent</li>
 * <li>xtPackageInPackage</li>
 * <li>xtComponent</li>
 * <li>xtComponentInModel</li>
 * <li>xtComponentInPackage</li>
 * <li>xtPort</li>
 * <li>capsulePart</li>
 * <li>connector</li>
 * <li>connectorEnd</li>
 * <li>xtClass</li>
 * <li>behavior</li>
 * <li>node</li>
 * <li>stereotype</li>
 * <li>xtClassInModel</li>
 * <li>xtClassInPackage</li>
 * <li>xtClassInComponent</li>
 * <li>operation</li>
 * <li>regularOperation</li>
 * <li>constructorOperation</li>
 * <li>destructorOperation</li>
 * <li>constructorByName</li>
 * <li>destructorByName</li>
 * <li>entity</li>
 * <li>attribute</li>
 * <li>signalAttribute</li>
 * <li>multiplicityElement</li>
 * <li>parameter</li>
 * <li>parameterInOperation</li>
 * <li>notReturnParameter</li>
 * <li>xtAssociation</li>
 * <li>associationOwnedEnd</li>
 * <li>xtAssociationClass</li>
 * <li>xtGeneralization</li>
 * <li>xtClassEvent</li>
 * <li>xtClassEventGeneralization</li>
 * <li>typeDefinitionInPackage</li>
 * <li>typeDefinitionInComponent</li>
 * <li>typeDefinition</li>
 * <li>primitiveType</li>
 * <li>enumeration</li>
 * <li>enumerationLiteral</li>
 * <li>structType</li>
 * <li>structTypeInComponent</li>
 * <li>structTypeInPackage</li>
 * <li>structMember</li>
 * <li>packagedElement</li>
 * <li>elementInComponent</li>
 * <li>elementInPackage</li>
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
    querySpecifications.add(XtPackageQuerySpecification.instance());
    querySpecifications.add(ModelQuerySpecification.instance());
    querySpecifications.add(NamedDataTypeQuerySpecification.instance());
    querySpecifications.add(XtPackageInModelQuerySpecification.instance());
    querySpecifications.add(XtPackageInComponentQuerySpecification.instance());
    querySpecifications.add(XtPackageInPackageQuerySpecification.instance());
    querySpecifications.add(XtComponentQuerySpecification.instance());
    querySpecifications.add(XtComponentInModelQuerySpecification.instance());
    querySpecifications.add(XtComponentInPackageQuerySpecification.instance());
    querySpecifications.add(XtPortQuerySpecification.instance());
    querySpecifications.add(CapsulePartQuerySpecification.instance());
    querySpecifications.add(ConnectorQuerySpecification.instance());
    querySpecifications.add(ConnectorEndQuerySpecification.instance());
    querySpecifications.add(XtClassQuerySpecification.instance());
    querySpecifications.add(XtClassInModelQuerySpecification.instance());
    querySpecifications.add(XtClassInPackageQuerySpecification.instance());
    querySpecifications.add(XtClassInComponentQuerySpecification.instance());
    querySpecifications.add(OperationQuerySpecification.instance());
    querySpecifications.add(RegularOperationQuerySpecification.instance());
    querySpecifications.add(ConstructorOperationQuerySpecification.instance());
    querySpecifications.add(DestructorOperationQuerySpecification.instance());
    querySpecifications.add(ConstructorByNameQuerySpecification.instance());
    querySpecifications.add(DestructorByNameQuerySpecification.instance());
    querySpecifications.add(AttributeQuerySpecification.instance());
    querySpecifications.add(SignalAttributeQuerySpecification.instance());
    querySpecifications.add(MultiplicityElementQuerySpecification.instance());
    querySpecifications.add(ParameterQuerySpecification.instance());
    querySpecifications.add(ParameterInOperationQuerySpecification.instance());
    querySpecifications.add(XtAssociationQuerySpecification.instance());
    querySpecifications.add(AssociationOwnedEndQuerySpecification.instance());
    querySpecifications.add(XtAssociationClassQuerySpecification.instance());
    querySpecifications.add(XtGeneralizationQuerySpecification.instance());
    querySpecifications.add(XtClassEventQuerySpecification.instance());
    querySpecifications.add(XtClassEventGeneralizationQuerySpecification.instance());
    querySpecifications.add(TypeDefinitionInPackageQuerySpecification.instance());
    querySpecifications.add(TypeDefinitionInComponentQuerySpecification.instance());
    querySpecifications.add(TypeDefinitionQuerySpecification.instance());
    querySpecifications.add(PrimitiveTypeQuerySpecification.instance());
    querySpecifications.add(EnumerationQuerySpecification.instance());
    querySpecifications.add(EnumerationLiteralQuerySpecification.instance());
    querySpecifications.add(StructTypeQuerySpecification.instance());
    querySpecifications.add(StructTypeInComponentQuerySpecification.instance());
    querySpecifications.add(StructTypeInPackageQuerySpecification.instance());
    querySpecifications.add(StructMemberQuerySpecification.instance());
  }
  
  public XtPackageQuerySpecification getXtPackage() throws IncQueryException {
    return XtPackageQuerySpecification.instance();
  }
  
  public XtPackageMatcher getXtPackage(final IncQueryEngine engine) throws IncQueryException {
    return XtPackageMatcher.on(engine);
  }
  
  public ModelQuerySpecification getModel() throws IncQueryException {
    return ModelQuerySpecification.instance();
  }
  
  public ModelMatcher getModel(final IncQueryEngine engine) throws IncQueryException {
    return ModelMatcher.on(engine);
  }
  
  public NamedDataTypeQuerySpecification getNamedDataType() throws IncQueryException {
    return NamedDataTypeQuerySpecification.instance();
  }
  
  public NamedDataTypeMatcher getNamedDataType(final IncQueryEngine engine) throws IncQueryException {
    return NamedDataTypeMatcher.on(engine);
  }
  
  public XtPackageInModelQuerySpecification getXtPackageInModel() throws IncQueryException {
    return XtPackageInModelQuerySpecification.instance();
  }
  
  public XtPackageInModelMatcher getXtPackageInModel(final IncQueryEngine engine) throws IncQueryException {
    return XtPackageInModelMatcher.on(engine);
  }
  
  public XtPackageInComponentQuerySpecification getXtPackageInComponent() throws IncQueryException {
    return XtPackageInComponentQuerySpecification.instance();
  }
  
  public XtPackageInComponentMatcher getXtPackageInComponent(final IncQueryEngine engine) throws IncQueryException {
    return XtPackageInComponentMatcher.on(engine);
  }
  
  public XtPackageInPackageQuerySpecification getXtPackageInPackage() throws IncQueryException {
    return XtPackageInPackageQuerySpecification.instance();
  }
  
  public XtPackageInPackageMatcher getXtPackageInPackage(final IncQueryEngine engine) throws IncQueryException {
    return XtPackageInPackageMatcher.on(engine);
  }
  
  public XtComponentQuerySpecification getXtComponent() throws IncQueryException {
    return XtComponentQuerySpecification.instance();
  }
  
  public XtComponentMatcher getXtComponent(final IncQueryEngine engine) throws IncQueryException {
    return XtComponentMatcher.on(engine);
  }
  
  public XtComponentInModelQuerySpecification getXtComponentInModel() throws IncQueryException {
    return XtComponentInModelQuerySpecification.instance();
  }
  
  public XtComponentInModelMatcher getXtComponentInModel(final IncQueryEngine engine) throws IncQueryException {
    return XtComponentInModelMatcher.on(engine);
  }
  
  public XtComponentInPackageQuerySpecification getXtComponentInPackage() throws IncQueryException {
    return XtComponentInPackageQuerySpecification.instance();
  }
  
  public XtComponentInPackageMatcher getXtComponentInPackage(final IncQueryEngine engine) throws IncQueryException {
    return XtComponentInPackageMatcher.on(engine);
  }
  
  public XtPortQuerySpecification getXtPort() throws IncQueryException {
    return XtPortQuerySpecification.instance();
  }
  
  public XtPortMatcher getXtPort(final IncQueryEngine engine) throws IncQueryException {
    return XtPortMatcher.on(engine);
  }
  
  public CapsulePartQuerySpecification getCapsulePart() throws IncQueryException {
    return CapsulePartQuerySpecification.instance();
  }
  
  public CapsulePartMatcher getCapsulePart(final IncQueryEngine engine) throws IncQueryException {
    return CapsulePartMatcher.on(engine);
  }
  
  public ConnectorQuerySpecification getConnector() throws IncQueryException {
    return ConnectorQuerySpecification.instance();
  }
  
  public ConnectorMatcher getConnector(final IncQueryEngine engine) throws IncQueryException {
    return ConnectorMatcher.on(engine);
  }
  
  public ConnectorEndQuerySpecification getConnectorEnd() throws IncQueryException {
    return ConnectorEndQuerySpecification.instance();
  }
  
  public ConnectorEndMatcher getConnectorEnd(final IncQueryEngine engine) throws IncQueryException {
    return ConnectorEndMatcher.on(engine);
  }
  
  public XtClassQuerySpecification getXtClass() throws IncQueryException {
    return XtClassQuerySpecification.instance();
  }
  
  public XtClassMatcher getXtClass(final IncQueryEngine engine) throws IncQueryException {
    return XtClassMatcher.on(engine);
  }
  
  public XtClassInModelQuerySpecification getXtClassInModel() throws IncQueryException {
    return XtClassInModelQuerySpecification.instance();
  }
  
  public XtClassInModelMatcher getXtClassInModel(final IncQueryEngine engine) throws IncQueryException {
    return XtClassInModelMatcher.on(engine);
  }
  
  public XtClassInPackageQuerySpecification getXtClassInPackage() throws IncQueryException {
    return XtClassInPackageQuerySpecification.instance();
  }
  
  public XtClassInPackageMatcher getXtClassInPackage(final IncQueryEngine engine) throws IncQueryException {
    return XtClassInPackageMatcher.on(engine);
  }
  
  public XtClassInComponentQuerySpecification getXtClassInComponent() throws IncQueryException {
    return XtClassInComponentQuerySpecification.instance();
  }
  
  public XtClassInComponentMatcher getXtClassInComponent(final IncQueryEngine engine) throws IncQueryException {
    return XtClassInComponentMatcher.on(engine);
  }
  
  public OperationQuerySpecification getOperation() throws IncQueryException {
    return OperationQuerySpecification.instance();
  }
  
  public OperationMatcher getOperation(final IncQueryEngine engine) throws IncQueryException {
    return OperationMatcher.on(engine);
  }
  
  public RegularOperationQuerySpecification getRegularOperation() throws IncQueryException {
    return RegularOperationQuerySpecification.instance();
  }
  
  public RegularOperationMatcher getRegularOperation(final IncQueryEngine engine) throws IncQueryException {
    return RegularOperationMatcher.on(engine);
  }
  
  public ConstructorOperationQuerySpecification getConstructorOperation() throws IncQueryException {
    return ConstructorOperationQuerySpecification.instance();
  }
  
  public ConstructorOperationMatcher getConstructorOperation(final IncQueryEngine engine) throws IncQueryException {
    return ConstructorOperationMatcher.on(engine);
  }
  
  public DestructorOperationQuerySpecification getDestructorOperation() throws IncQueryException {
    return DestructorOperationQuerySpecification.instance();
  }
  
  public DestructorOperationMatcher getDestructorOperation(final IncQueryEngine engine) throws IncQueryException {
    return DestructorOperationMatcher.on(engine);
  }
  
  public ConstructorByNameQuerySpecification getConstructorByName() throws IncQueryException {
    return ConstructorByNameQuerySpecification.instance();
  }
  
  public ConstructorByNameMatcher getConstructorByName(final IncQueryEngine engine) throws IncQueryException {
    return ConstructorByNameMatcher.on(engine);
  }
  
  public DestructorByNameQuerySpecification getDestructorByName() throws IncQueryException {
    return DestructorByNameQuerySpecification.instance();
  }
  
  public DestructorByNameMatcher getDestructorByName(final IncQueryEngine engine) throws IncQueryException {
    return DestructorByNameMatcher.on(engine);
  }
  
  public AttributeQuerySpecification getAttribute() throws IncQueryException {
    return AttributeQuerySpecification.instance();
  }
  
  public AttributeMatcher getAttribute(final IncQueryEngine engine) throws IncQueryException {
    return AttributeMatcher.on(engine);
  }
  
  public SignalAttributeQuerySpecification getSignalAttribute() throws IncQueryException {
    return SignalAttributeQuerySpecification.instance();
  }
  
  public SignalAttributeMatcher getSignalAttribute(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeMatcher.on(engine);
  }
  
  public MultiplicityElementQuerySpecification getMultiplicityElement() throws IncQueryException {
    return MultiplicityElementQuerySpecification.instance();
  }
  
  public MultiplicityElementMatcher getMultiplicityElement(final IncQueryEngine engine) throws IncQueryException {
    return MultiplicityElementMatcher.on(engine);
  }
  
  public ParameterQuerySpecification getParameter() throws IncQueryException {
    return ParameterQuerySpecification.instance();
  }
  
  public ParameterMatcher getParameter(final IncQueryEngine engine) throws IncQueryException {
    return ParameterMatcher.on(engine);
  }
  
  public ParameterInOperationQuerySpecification getParameterInOperation() throws IncQueryException {
    return ParameterInOperationQuerySpecification.instance();
  }
  
  public ParameterInOperationMatcher getParameterInOperation(final IncQueryEngine engine) throws IncQueryException {
    return ParameterInOperationMatcher.on(engine);
  }
  
  public XtAssociationQuerySpecification getXtAssociation() throws IncQueryException {
    return XtAssociationQuerySpecification.instance();
  }
  
  public XtAssociationMatcher getXtAssociation(final IncQueryEngine engine) throws IncQueryException {
    return XtAssociationMatcher.on(engine);
  }
  
  public AssociationOwnedEndQuerySpecification getAssociationOwnedEnd() throws IncQueryException {
    return AssociationOwnedEndQuerySpecification.instance();
  }
  
  public AssociationOwnedEndMatcher getAssociationOwnedEnd(final IncQueryEngine engine) throws IncQueryException {
    return AssociationOwnedEndMatcher.on(engine);
  }
  
  public XtAssociationClassQuerySpecification getXtAssociationClass() throws IncQueryException {
    return XtAssociationClassQuerySpecification.instance();
  }
  
  public XtAssociationClassMatcher getXtAssociationClass(final IncQueryEngine engine) throws IncQueryException {
    return XtAssociationClassMatcher.on(engine);
  }
  
  public XtGeneralizationQuerySpecification getXtGeneralization() throws IncQueryException {
    return XtGeneralizationQuerySpecification.instance();
  }
  
  public XtGeneralizationMatcher getXtGeneralization(final IncQueryEngine engine) throws IncQueryException {
    return XtGeneralizationMatcher.on(engine);
  }
  
  public XtClassEventQuerySpecification getXtClassEvent() throws IncQueryException {
    return XtClassEventQuerySpecification.instance();
  }
  
  public XtClassEventMatcher getXtClassEvent(final IncQueryEngine engine) throws IncQueryException {
    return XtClassEventMatcher.on(engine);
  }
  
  public XtClassEventGeneralizationQuerySpecification getXtClassEventGeneralization() throws IncQueryException {
    return XtClassEventGeneralizationQuerySpecification.instance();
  }
  
  public XtClassEventGeneralizationMatcher getXtClassEventGeneralization(final IncQueryEngine engine) throws IncQueryException {
    return XtClassEventGeneralizationMatcher.on(engine);
  }
  
  public TypeDefinitionInPackageQuerySpecification getTypeDefinitionInPackage() throws IncQueryException {
    return TypeDefinitionInPackageQuerySpecification.instance();
  }
  
  public TypeDefinitionInPackageMatcher getTypeDefinitionInPackage(final IncQueryEngine engine) throws IncQueryException {
    return TypeDefinitionInPackageMatcher.on(engine);
  }
  
  public TypeDefinitionInComponentQuerySpecification getTypeDefinitionInComponent() throws IncQueryException {
    return TypeDefinitionInComponentQuerySpecification.instance();
  }
  
  public TypeDefinitionInComponentMatcher getTypeDefinitionInComponent(final IncQueryEngine engine) throws IncQueryException {
    return TypeDefinitionInComponentMatcher.on(engine);
  }
  
  public TypeDefinitionQuerySpecification getTypeDefinition() throws IncQueryException {
    return TypeDefinitionQuerySpecification.instance();
  }
  
  public TypeDefinitionMatcher getTypeDefinition(final IncQueryEngine engine) throws IncQueryException {
    return TypeDefinitionMatcher.on(engine);
  }
  
  public PrimitiveTypeQuerySpecification getPrimitiveType() throws IncQueryException {
    return PrimitiveTypeQuerySpecification.instance();
  }
  
  public PrimitiveTypeMatcher getPrimitiveType(final IncQueryEngine engine) throws IncQueryException {
    return PrimitiveTypeMatcher.on(engine);
  }
  
  public EnumerationQuerySpecification getEnumeration() throws IncQueryException {
    return EnumerationQuerySpecification.instance();
  }
  
  public EnumerationMatcher getEnumeration(final IncQueryEngine engine) throws IncQueryException {
    return EnumerationMatcher.on(engine);
  }
  
  public EnumerationLiteralQuerySpecification getEnumerationLiteral() throws IncQueryException {
    return EnumerationLiteralQuerySpecification.instance();
  }
  
  public EnumerationLiteralMatcher getEnumerationLiteral(final IncQueryEngine engine) throws IncQueryException {
    return EnumerationLiteralMatcher.on(engine);
  }
  
  public StructTypeQuerySpecification getStructType() throws IncQueryException {
    return StructTypeQuerySpecification.instance();
  }
  
  public StructTypeMatcher getStructType(final IncQueryEngine engine) throws IncQueryException {
    return StructTypeMatcher.on(engine);
  }
  
  public StructTypeInComponentQuerySpecification getStructTypeInComponent() throws IncQueryException {
    return StructTypeInComponentQuerySpecification.instance();
  }
  
  public StructTypeInComponentMatcher getStructTypeInComponent(final IncQueryEngine engine) throws IncQueryException {
    return StructTypeInComponentMatcher.on(engine);
  }
  
  public StructTypeInPackageQuerySpecification getStructTypeInPackage() throws IncQueryException {
    return StructTypeInPackageQuerySpecification.instance();
  }
  
  public StructTypeInPackageMatcher getStructTypeInPackage(final IncQueryEngine engine) throws IncQueryException {
    return StructTypeInPackageMatcher.on(engine);
  }
  
  public StructMemberQuerySpecification getStructMember() throws IncQueryException {
    return StructMemberQuerySpecification.instance();
  }
  
  public StructMemberMatcher getStructMember(final IncQueryEngine engine) throws IncQueryException {
    return StructMemberMatcher.on(engine);
  }
}
