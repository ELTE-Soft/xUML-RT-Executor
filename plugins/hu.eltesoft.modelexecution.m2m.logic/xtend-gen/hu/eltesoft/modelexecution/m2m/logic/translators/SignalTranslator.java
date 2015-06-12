package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;
import java.util.function.Function;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;

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
        Property _attribute_1 = it.getAttribute();
        Type _type = _attribute_1.getType();
        hu.eltesoft.modelexecution.m2m.metamodel.base.Type _convert = SignalTranslator.this.convert(_type);
        elem.setType(_convert);
        return elem;
      }
    };
    rootNode.<SgAttribute, SignalAttributeMatch>onEObject(_sgSignal_Attributes, _on_1, _function_1);
    return rootNode;
  }
  
  public Template createTemplate(final SgSignal signal) {
    return new SignalTemplate(signal);
  }
}
