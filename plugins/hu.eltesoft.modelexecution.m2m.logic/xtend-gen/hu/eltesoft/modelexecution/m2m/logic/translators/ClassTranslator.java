package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.translators.base.AbstractFeatureNode;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClParameter;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplate;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatch;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatch;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatch;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher;
import java.util.function.Function;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
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
        Type _type = it.getType();
        hu.eltesoft.modelexecution.m2m.metamodel.base.Type _convert = ClassTranslator.this.convert(_type);
        elem.setType(_convert);
        Property _attribute_1 = it.getAttribute();
        ValueSpecification _lowerValue = _attribute_1.getLowerValue();
        Property _attribute_2 = it.getAttribute();
        ValueSpecification _upperValue = _attribute_2.getUpperValue();
        Multiplicity _convert_1 = ClassTranslator.this.convert(_lowerValue, _upperValue);
        elem.setMultiplicity(_convert_1);
        return elem;
      }
    };
    rootNode.<ClAttribute, AttributeMatch>onEObject(_clClass_Attributes, _on_2, _function_2);
    EReference _clClass_Operations = ClassTranslator.PACKAGE.getClClass_Operations();
    OperationMatcher _on_3 = OperationMatcher.on(engine);
    final Function<OperationMatch, ClOperation> _function_3 = new Function<OperationMatch, ClOperation>() {
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
    final AbstractFeatureNode<ClOperation, OperationMatch> operationNode = rootNode.<ClOperation, OperationMatch>onEObject(_clClass_Operations, _on_3, _function_3);
    EReference _clOperation_Parameters = ClassTranslator.PACKAGE.getClOperation_Parameters();
    OperationParameterMatcher _on_4 = OperationParameterMatcher.on(engine);
    final Function<OperationParameterMatch, ClParameter> _function_4 = new Function<OperationParameterMatch, ClParameter>() {
      public ClParameter apply(final OperationParameterMatch it) {
        final ClParameter elem = ClassTranslator.FACTORY.createClParameter();
        Parameter _parameter = it.getParameter();
        NamedReference _namedReference = new NamedReference(_parameter);
        elem.setReference(_namedReference);
        Type _type = it.getType();
        hu.eltesoft.modelexecution.m2m.metamodel.base.Type _convert = ClassTranslator.this.convert(_type);
        elem.setType(_convert);
        ParameterDirectionKind _direction = it.getDirection();
        Direction _convert_1 = ClassTranslator.this.convert(_direction);
        elem.setDirection(_convert_1);
        return elem;
      }
    };
    operationNode.<ClParameter, OperationParameterMatch>onEObject(_clOperation_Parameters, _on_4, _function_4);
    EReference _clOperation_ReturnType = ClassTranslator.PACKAGE.getClOperation_ReturnType();
    OperationReturnTypeMatcher _on_5 = OperationReturnTypeMatcher.on(engine);
    final Function<OperationReturnTypeMatch, hu.eltesoft.modelexecution.m2m.metamodel.base.Type> _function_5 = new Function<OperationReturnTypeMatch, hu.eltesoft.modelexecution.m2m.metamodel.base.Type>() {
      public hu.eltesoft.modelexecution.m2m.metamodel.base.Type apply(final OperationReturnTypeMatch it) {
        Type _type = it.getType();
        return ClassTranslator.this.convert(_type);
      }
    };
    operationNode.<hu.eltesoft.modelexecution.m2m.metamodel.base.Type, OperationReturnTypeMatch>onEObject(_clOperation_ReturnType, _on_5, _function_5);
    EAttribute _clOperation_Method = ClassTranslator.PACKAGE.getClOperation_Method();
    MethodMatcher _on_6 = MethodMatcher.on(engine);
    final Function<MethodMatch, NamedReference> _function_6 = new Function<MethodMatch, NamedReference>() {
      public NamedReference apply(final MethodMatch it) {
        Behavior _method = it.getMethod();
        return new NamedReference(_method);
      }
    };
    operationNode.<NamedReference, MethodMatch>on(_clOperation_Method, _on_6, _function_6);
    EReference _clClass_Receptions = ClassTranslator.PACKAGE.getClClass_Receptions();
    ReceptionMatcher _on_7 = ReceptionMatcher.on(engine);
    final Function<ReceptionMatch, ClReception> _function_7 = new Function<ReceptionMatch, ClReception>() {
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
    rootNode.<ClReception, ReceptionMatch>onEObject(_clClass_Receptions, _on_7, _function_7);
    return rootNode;
  }
  
  public Template createTemplate(final ClClass cls) {
    return new ClassTemplate(cls);
  }
}
