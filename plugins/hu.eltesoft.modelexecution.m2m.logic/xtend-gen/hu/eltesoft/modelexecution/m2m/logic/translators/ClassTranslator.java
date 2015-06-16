package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.translators.base.AbstractFeatureNode;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.FullType;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClParameter;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplate;
import hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatch;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatch;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatch;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher;
import java.util.function.Function;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

@SuppressWarnings("all")
public class ClassTranslator extends RootElementTranslator<org.eclipse.uml2.uml.Class, ClClass, ClsMatch> {
  private final static ClassdefFactory FACTORY = ClassdefFactory.eINSTANCE;
  
  private final static ClassdefPackage PACKAGE = ClassdefPackage.eINSTANCE;
  
  public ClassTranslator(final IncQueryEngine engine) throws IncQueryException {
    super(engine);
  }
  
  public RootNode<org.eclipse.uml2.uml.Class, ClClass, ClsMatch> buildMapper(final IncQueryEngine engine) throws IncQueryException {
    ClsMatcher _on = ClsMatcher.on(engine);
    final Function<ClsMatch, ClClass> _function = new Function<ClsMatch, ClClass>() {
      public ClClass apply(final ClsMatch it) {
        final ClClass root = ClassTranslator.FACTORY.createClClass();
        org.eclipse.uml2.uml.Class _cls = it.getCls();
        NamedReference _namedReference = new NamedReference(_cls);
        root.setReference(_namedReference);
        return root;
      }
    };
    final RootNode<org.eclipse.uml2.uml.Class, ClClass, ClsMatch> rootNode = this.fromRoot(_on, _function);
    EAttribute _clClass_Region = ClassTranslator.PACKAGE.getClClass_Region();
    RegionOfClassMatcher _on_1 = RegionOfClassMatcher.on(engine);
    final Function<RegionOfClassMatch, NamedReference> _function_1 = new Function<RegionOfClassMatch, NamedReference>() {
      public NamedReference apply(final RegionOfClassMatch it) {
        Region _region = it.getRegion();
        return new NamedReference(_region);
      }
    };
    rootNode.<NamedReference, RegionOfClassMatch>on(_clClass_Region, _on_1, _function_1);
    EReference _clClass_Attributes = ClassTranslator.PACKAGE.getClClass_Attributes();
    AttributeMatcher _on_2 = AttributeMatcher.on(engine);
    final Function<AttributeMatch, ClAttribute> _function_2 = new Function<AttributeMatch, ClAttribute>() {
      public ClAttribute apply(final AttributeMatch it) {
        final ClAttribute elem = ClassTranslator.FACTORY.createClAttribute();
        Property _attribute = it.getAttribute();
        NamedReference _namedReference = new NamedReference(_attribute);
        elem.setReference(_namedReference);
        Boolean _isStatic = it.getIsStatic();
        elem.setIsStatic((_isStatic).booleanValue());
        return elem;
      }
    };
    final AbstractFeatureNode<ClAttribute, AttributeMatch> attributeNode = rootNode.<ClAttribute, AttributeMatch>onEObject(_clClass_Attributes, _on_2, _function_2);
    EReference _clAttribute_Type = ClassTranslator.PACKAGE.getClAttribute_Type();
    AttributeTypeMatcher _on_3 = AttributeTypeMatcher.on(engine);
    final Function<AttributeTypeMatch, FullType> _function_3 = new Function<AttributeTypeMatch, FullType>() {
      public FullType apply(final AttributeTypeMatch it) {
        final FullType elem = RootElementTranslator.BASE_FACTORY.createFullType();
        Type _type = it.getType();
        hu.eltesoft.modelexecution.m2m.metamodel.base.Type _convert = ClassTranslator.this.convert(_type);
        elem.setBaseType(_convert);
        Boolean _ordered = it.getOrdered();
        elem.setIsOrdered((_ordered).booleanValue());
        Boolean _unique = it.getUnique();
        elem.setIsUnique((_unique).booleanValue());
        return elem;
      }
    };
    final AbstractFeatureNode<FullType, AttributeTypeMatch> attributeType = attributeNode.<FullType, AttributeTypeMatch>onEObject(_clAttribute_Type, _on_3, _function_3);
    EAttribute _fullType_LowerBound = RootElementTranslator.BASE_PACKAGE.getFullType_LowerBound();
    AttributeLowerBoundMatcher _on_4 = AttributeLowerBoundMatcher.on(engine);
    final Function<AttributeLowerBoundMatch, Integer> _function_4 = new Function<AttributeLowerBoundMatch, Integer>() {
      public Integer apply(final AttributeLowerBoundMatch it) {
        ValueSpecification _lowerBound = it.getLowerBound();
        return ClassTranslator.this.toInt(_lowerBound);
      }
    };
    attributeType.<Integer, AttributeLowerBoundMatch>on(_fullType_LowerBound, _on_4, _function_4);
    EAttribute _fullType_UpperBound = RootElementTranslator.BASE_PACKAGE.getFullType_UpperBound();
    AttributeUpperBoundMatcher _on_5 = AttributeUpperBoundMatcher.on(engine);
    final Function<AttributeUpperBoundMatch, Integer> _function_5 = new Function<AttributeUpperBoundMatch, Integer>() {
      public Integer apply(final AttributeUpperBoundMatch it) {
        ValueSpecification _upperBound = it.getUpperBound();
        return ClassTranslator.this.toInt(_upperBound);
      }
    };
    attributeType.<Integer, AttributeUpperBoundMatch>on(_fullType_UpperBound, _on_5, _function_5);
    EReference _clClass_Operations = ClassTranslator.PACKAGE.getClClass_Operations();
    OperationMatcher _on_6 = OperationMatcher.on(engine);
    final Function<OperationMatch, ClOperation> _function_6 = new Function<OperationMatch, ClOperation>() {
      public ClOperation apply(final OperationMatch it) {
        final ClOperation elem = ClassTranslator.FACTORY.createClOperation();
        Operation _operation = it.getOperation();
        NamedReference _namedReference = new NamedReference(_operation);
        elem.setReference(_namedReference);
        Boolean _isStatic = it.getIsStatic();
        elem.setIsStatic((_isStatic).booleanValue());
        return elem;
      }
    };
    final AbstractFeatureNode<ClOperation, OperationMatch> operationNode = rootNode.<ClOperation, OperationMatch>onEObject(_clClass_Operations, _on_6, _function_6);
    EReference _clOperation_Parameters = ClassTranslator.PACKAGE.getClOperation_Parameters();
    OperationParameterMatcher _on_7 = OperationParameterMatcher.on(engine);
    final Function<OperationParameterMatch, ClParameter> _function_7 = new Function<OperationParameterMatch, ClParameter>() {
      public ClParameter apply(final OperationParameterMatch it) {
        final ClParameter elem = ClassTranslator.FACTORY.createClParameter();
        Parameter _parameter = it.getParameter();
        NamedReference _namedReference = new NamedReference(_parameter);
        elem.setReference(_namedReference);
        ParameterDirectionKind _direction = it.getDirection();
        Direction _convert = ClassTranslator.this.convert(_direction);
        elem.setDirection(_convert);
        return elem;
      }
    };
    final AbstractFeatureNode<ClParameter, OperationParameterMatch> parameterNode = operationNode.<ClParameter, OperationParameterMatch>onEObject(_clOperation_Parameters, _on_7, _function_7);
    EReference _clParameter_Type = ClassTranslator.PACKAGE.getClParameter_Type();
    OperationParameterTypeMatcher _on_8 = OperationParameterTypeMatcher.on(engine);
    final Function<OperationParameterTypeMatch, FullType> _function_8 = new Function<OperationParameterTypeMatch, FullType>() {
      public FullType apply(final OperationParameterTypeMatch it) {
        final FullType elem = RootElementTranslator.BASE_FACTORY.createFullType();
        Type _type = it.getType();
        hu.eltesoft.modelexecution.m2m.metamodel.base.Type _convert = ClassTranslator.this.convert(_type);
        elem.setBaseType(_convert);
        Boolean _ordered = it.getOrdered();
        elem.setIsOrdered((_ordered).booleanValue());
        Boolean _unique = it.getUnique();
        elem.setIsUnique((_unique).booleanValue());
        return elem;
      }
    };
    final AbstractFeatureNode<FullType, OperationParameterTypeMatch> parameterTypeNode = parameterNode.<FullType, OperationParameterTypeMatch>onEObject(_clParameter_Type, _on_8, _function_8);
    EAttribute _fullType_LowerBound_1 = RootElementTranslator.BASE_PACKAGE.getFullType_LowerBound();
    OperationParameterLowerBoundMatcher _on_9 = OperationParameterLowerBoundMatcher.on(engine);
    final Function<OperationParameterLowerBoundMatch, Integer> _function_9 = new Function<OperationParameterLowerBoundMatch, Integer>() {
      public Integer apply(final OperationParameterLowerBoundMatch it) {
        ValueSpecification _lowerBound = it.getLowerBound();
        return ClassTranslator.this.toInt(_lowerBound);
      }
    };
    parameterTypeNode.<Integer, OperationParameterLowerBoundMatch>on(_fullType_LowerBound_1, _on_9, _function_9);
    EAttribute _fullType_UpperBound_1 = RootElementTranslator.BASE_PACKAGE.getFullType_UpperBound();
    OperationParameterUpperBoundMatcher _on_10 = OperationParameterUpperBoundMatcher.on(engine);
    final Function<OperationParameterUpperBoundMatch, Integer> _function_10 = new Function<OperationParameterUpperBoundMatch, Integer>() {
      public Integer apply(final OperationParameterUpperBoundMatch it) {
        ValueSpecification _upperBound = it.getUpperBound();
        return ClassTranslator.this.toInt(_upperBound);
      }
    };
    parameterTypeNode.<Integer, OperationParameterUpperBoundMatch>on(_fullType_UpperBound_1, _on_10, _function_10);
    EReference _clOperation_ReturnType = ClassTranslator.PACKAGE.getClOperation_ReturnType();
    OperationReturnTypeMatcher _on_11 = OperationReturnTypeMatcher.on(engine);
    final Function<OperationReturnTypeMatch, FullType> _function_11 = new Function<OperationReturnTypeMatch, FullType>() {
      public FullType apply(final OperationReturnTypeMatch it) {
        final FullType elem = RootElementTranslator.BASE_FACTORY.createFullType();
        Type _type = it.getType();
        hu.eltesoft.modelexecution.m2m.metamodel.base.Type _convert = ClassTranslator.this.convert(_type);
        elem.setBaseType(_convert);
        Boolean _ordered = it.getOrdered();
        elem.setIsOrdered((_ordered).booleanValue());
        Boolean _unique = it.getUnique();
        elem.setIsUnique((_unique).booleanValue());
        return elem;
      }
    };
    final AbstractFeatureNode<FullType, OperationReturnTypeMatch> operationReturn = operationNode.<FullType, OperationReturnTypeMatch>onEObject(_clOperation_ReturnType, _on_11, _function_11);
    EAttribute _fullType_LowerBound_2 = RootElementTranslator.BASE_PACKAGE.getFullType_LowerBound();
    OperationReturnLowerBoundMatcher _on_12 = OperationReturnLowerBoundMatcher.on(engine);
    final Function<OperationReturnLowerBoundMatch, Integer> _function_12 = new Function<OperationReturnLowerBoundMatch, Integer>() {
      public Integer apply(final OperationReturnLowerBoundMatch it) {
        ValueSpecification _lowerBound = it.getLowerBound();
        return ClassTranslator.this.toInt(_lowerBound);
      }
    };
    operationReturn.<Integer, OperationReturnLowerBoundMatch>on(_fullType_LowerBound_2, _on_12, _function_12);
    EAttribute _fullType_UpperBound_2 = RootElementTranslator.BASE_PACKAGE.getFullType_UpperBound();
    OperationReturnUpperBoundMatcher _on_13 = OperationReturnUpperBoundMatcher.on(engine);
    final Function<OperationReturnUpperBoundMatch, Integer> _function_13 = new Function<OperationReturnUpperBoundMatch, Integer>() {
      public Integer apply(final OperationReturnUpperBoundMatch it) {
        ValueSpecification _upperBound = it.getUpperBound();
        return ClassTranslator.this.toInt(_upperBound);
      }
    };
    operationReturn.<Integer, OperationReturnUpperBoundMatch>on(_fullType_UpperBound_2, _on_13, _function_13);
    EAttribute _clOperation_Method = ClassTranslator.PACKAGE.getClOperation_Method();
    MethodMatcher _on_14 = MethodMatcher.on(engine);
    final Function<MethodMatch, NamedReference> _function_14 = new Function<MethodMatch, NamedReference>() {
      public NamedReference apply(final MethodMatch it) {
        Behavior _method = it.getMethod();
        return new NamedReference(_method);
      }
    };
    operationNode.<NamedReference, MethodMatch>on(_clOperation_Method, _on_14, _function_14);
    EReference _clClass_Associations = ClassTranslator.PACKAGE.getClClass_Associations();
    ClassAssociationMatcher _on_15 = ClassAssociationMatcher.on(engine);
    final Function<ClassAssociationMatch, ClAssociation> _function_15 = new Function<ClassAssociationMatch, ClAssociation>() {
      public ClAssociation apply(final ClassAssociationMatch it) {
        final ClAssociation elem = ClassTranslator.FACTORY.createClAssociation();
        Property _end = it.getEnd();
        NamedReference _namedReference = new NamedReference(_end);
        elem.setReference(_namedReference);
        return elem;
      }
    };
    final AbstractFeatureNode<ClAssociation, ClassAssociationMatch> assocNode = rootNode.<ClAssociation, ClassAssociationMatch>onEObject(_clClass_Associations, _on_15, _function_15);
    EReference _clAssociation_Type = ClassTranslator.PACKAGE.getClAssociation_Type();
    ClassAssociationTypeMatcher _on_16 = ClassAssociationTypeMatcher.on(engine);
    final Function<ClassAssociationTypeMatch, FullType> _function_16 = new Function<ClassAssociationTypeMatch, FullType>() {
      public FullType apply(final ClassAssociationTypeMatch it) {
        final FullType elem = RootElementTranslator.BASE_FACTORY.createFullType();
        Association _type = it.getType();
        hu.eltesoft.modelexecution.m2m.metamodel.base.Type _convert = ClassTranslator.this.convert(_type);
        elem.setBaseType(_convert);
        return elem;
      }
    };
    final AbstractFeatureNode<FullType, ClassAssociationTypeMatch> assocType = assocNode.<FullType, ClassAssociationTypeMatch>onEObject(_clAssociation_Type, _on_16, _function_16);
    EAttribute _fullType_LowerBound_3 = RootElementTranslator.BASE_PACKAGE.getFullType_LowerBound();
    ClassAssociationLowerBoundMatcher _on_17 = ClassAssociationLowerBoundMatcher.on(engine);
    final Function<ClassAssociationLowerBoundMatch, Integer> _function_17 = new Function<ClassAssociationLowerBoundMatch, Integer>() {
      public Integer apply(final ClassAssociationLowerBoundMatch it) {
        ValueSpecification _lowerBound = it.getLowerBound();
        return ClassTranslator.this.toInt(_lowerBound);
      }
    };
    assocType.<Integer, ClassAssociationLowerBoundMatch>on(_fullType_LowerBound_3, _on_17, _function_17);
    EAttribute _fullType_UpperBound_3 = RootElementTranslator.BASE_PACKAGE.getFullType_UpperBound();
    ClassAssociationUpperBoundMatcher _on_18 = ClassAssociationUpperBoundMatcher.on(engine);
    final Function<ClassAssociationUpperBoundMatch, Integer> _function_18 = new Function<ClassAssociationUpperBoundMatch, Integer>() {
      public Integer apply(final ClassAssociationUpperBoundMatch it) {
        ValueSpecification _upperBound = it.getUpperBound();
        return ClassTranslator.this.toInt(_upperBound);
      }
    };
    assocType.<Integer, ClassAssociationUpperBoundMatch>on(_fullType_UpperBound_3, _on_18, _function_18);
    EReference _clClass_Receptions = ClassTranslator.PACKAGE.getClClass_Receptions();
    ReceptionMatcher _on_19 = ReceptionMatcher.on(engine);
    final Function<ReceptionMatch, ClReception> _function_19 = new Function<ReceptionMatch, ClReception>() {
      public ClReception apply(final ReceptionMatch it) {
        final ClReception elem = ClassTranslator.FACTORY.createClReception();
        Reception _reception = it.getReception();
        NamedReference _namedReference = new NamedReference(_reception);
        elem.setReference(_namedReference);
        Signal _signal = it.getSignal();
        NamedReference _namedReference_1 = new NamedReference(_signal);
        elem.setSignal(_namedReference_1);
        return elem;
      }
    };
    rootNode.<ClReception, ReceptionMatch>onEObject(_clClass_Receptions, _on_19, _function_19);
    return rootNode;
  }
  
  public Template createTemplate(final ClClass cls) {
    return new ClassTemplate(cls);
  }
}
