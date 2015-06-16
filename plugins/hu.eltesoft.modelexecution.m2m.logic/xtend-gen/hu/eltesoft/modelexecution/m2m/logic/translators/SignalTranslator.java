package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.translators.base.AbstractFeatureNode;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode;
import hu.eltesoft.modelexecution.m2m.metamodel.base.FullType;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;
import java.util.function.Function;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

@SuppressWarnings("all")
public class SignalTranslator extends RootElementTranslator<Signal, SgSignal, SignalMatch> {
  private final static SignalFactory FACTORY = SignalFactory.eINSTANCE;
  
  private final static SignalPackage PACKAGE = SignalPackage.eINSTANCE;
  
  public SignalTranslator(final IncQueryEngine engine) throws IncQueryException {
    super(engine);
  }
  
  protected RootNode<Signal, SgSignal, SignalMatch> buildMapper(final IncQueryEngine engine) throws IncQueryException {
    SignalMatcher _on = SignalMatcher.on(engine);
    final Function<SignalMatch, SgSignal> _function = new Function<SignalMatch, SgSignal>() {
      public SgSignal apply(final SignalMatch it) {
        final SgSignal root = SignalTranslator.FACTORY.createSgSignal();
        Signal _signal = it.getSignal();
        NamedReference _namedReference = new NamedReference(_signal);
        root.setReference(_namedReference);
        return root;
      }
    };
    final RootNode<Signal, SgSignal, SignalMatch> rootNode = this.fromRoot(_on, _function);
    EReference _sgSignal_Attributes = SignalTranslator.PACKAGE.getSgSignal_Attributes();
    SignalAttributeMatcher _on_1 = SignalAttributeMatcher.on(engine);
    final Function<SignalAttributeMatch, SgAttribute> _function_1 = new Function<SignalAttributeMatch, SgAttribute>() {
      public SgAttribute apply(final SignalAttributeMatch it) {
        final SgAttribute elem = SignalTranslator.FACTORY.createSgAttribute();
        Property _attribute = it.getAttribute();
        NamedReference _namedReference = new NamedReference(_attribute);
        elem.setReference(_namedReference);
        return elem;
      }
    };
    final AbstractFeatureNode<SgAttribute, SignalAttributeMatch> attributeNode = rootNode.<SgAttribute, SignalAttributeMatch>onEObject(_sgSignal_Attributes, _on_1, _function_1);
    EReference _sgAttribute_Type = SignalTranslator.PACKAGE.getSgAttribute_Type();
    SignalAttributeTypeMatcher _on_2 = SignalAttributeTypeMatcher.on(engine);
    final Function<SignalAttributeTypeMatch, FullType> _function_2 = new Function<SignalAttributeTypeMatch, FullType>() {
      public FullType apply(final SignalAttributeTypeMatch it) {
        final FullType elem = RootElementTranslator.BASE_FACTORY.createFullType();
        Type _type = it.getType();
        hu.eltesoft.modelexecution.m2m.metamodel.base.Type _convert = SignalTranslator.this.convert(_type);
        elem.setBaseType(_convert);
        Boolean _ordered = it.getOrdered();
        elem.setIsOrdered((_ordered).booleanValue());
        Boolean _unique = it.getUnique();
        elem.setIsUnique((_unique).booleanValue());
        return elem;
      }
    };
    final AbstractFeatureNode<FullType, SignalAttributeTypeMatch> typeNode = attributeNode.<FullType, SignalAttributeTypeMatch>on(_sgAttribute_Type, _on_2, _function_2);
    EAttribute _fullType_LowerBound = RootElementTranslator.BASE_PACKAGE.getFullType_LowerBound();
    SignalAttributeLowerBoundMatcher _on_3 = SignalAttributeLowerBoundMatcher.on(engine);
    final Function<SignalAttributeLowerBoundMatch, Integer> _function_3 = new Function<SignalAttributeLowerBoundMatch, Integer>() {
      public Integer apply(final SignalAttributeLowerBoundMatch it) {
        ValueSpecification _lowerBound = it.getLowerBound();
        return SignalTranslator.this.toInt(_lowerBound);
      }
    };
    typeNode.<Integer, SignalAttributeLowerBoundMatch>on(_fullType_LowerBound, _on_3, _function_3);
    EAttribute _fullType_UpperBound = RootElementTranslator.BASE_PACKAGE.getFullType_UpperBound();
    SignalAttributeUpperBoundMatcher _on_4 = SignalAttributeUpperBoundMatcher.on(engine);
    final Function<SignalAttributeUpperBoundMatch, Integer> _function_4 = new Function<SignalAttributeUpperBoundMatch, Integer>() {
      public Integer apply(final SignalAttributeUpperBoundMatch it) {
        ValueSpecification _upperBound = it.getUpperBound();
        return SignalTranslator.this.toInt(_upperBound);
      }
    };
    typeNode.<Integer, SignalAttributeUpperBoundMatch>on(_fullType_UpperBound, _on_4, _function_4);
    return rootNode;
  }
  
  public Template createTemplate(final SgSignal signal) {
    return new SignalTemplate(signal);
  }
}
