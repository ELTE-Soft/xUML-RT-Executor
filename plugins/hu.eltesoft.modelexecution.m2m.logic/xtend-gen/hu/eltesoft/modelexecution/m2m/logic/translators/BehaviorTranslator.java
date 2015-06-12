package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhParameter;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplate;
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzer;
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult;
import hu.eltesoft.modelexecution.uml.alf.UnsupportedAlfFeatureException;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.StaticBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.StaticBehaviorMatcher;
import java.util.function.Function;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class BehaviorTranslator extends RootElementTranslator<Behavior, BhBehavior, BehaviorMatch> {
  private final static BehaviorFactory FACTORY = BehaviorFactory.eINSTANCE;
  
  private final static BehaviorPackage PACKAGE = BehaviorPackage.eINSTANCE;
  
  public BehaviorTranslator(final IncQueryEngine engine) throws IncQueryException {
    super(engine);
  }
  
  public RootNode<Behavior, BhBehavior, BehaviorMatch> buildMapper(final IncQueryEngine engine) {
    try {
      BehaviorMatcher _on = BehaviorMatcher.on(engine);
      final Function<BehaviorMatch, BhBehavior> _function = new Function<BehaviorMatch, BhBehavior>() {
        public BhBehavior apply(final BehaviorMatch it) {
          final BhBehavior root = BehaviorTranslator.FACTORY.createBhBehavior();
          Behavior _behavior = it.getBehavior();
          NamedReference _namedReference = new NamedReference(_behavior);
          root.setReference(_namedReference);
          AlfAnalyzer _alfAnalyzer = new AlfAnalyzer();
          AlfAnalyzerResult _analyze = _alfAnalyzer.analyze("{}");
          root.setAlfResult(_analyze);
          return root;
        }
      };
      final RootNode<Behavior, BhBehavior, BehaviorMatch> rootNode = this.fromRoot(_on, _function);
      EAttribute _bhBehavior_IsStatic = BehaviorTranslator.PACKAGE.getBhBehavior_IsStatic();
      StaticBehaviorMatcher _on_1 = StaticBehaviorMatcher.on(engine);
      final Function<StaticBehaviorMatch, Boolean> _function_1 = new Function<StaticBehaviorMatch, Boolean>() {
        public Boolean apply(final StaticBehaviorMatch it) {
          return it.getIsStatic();
        }
      };
      rootNode.<Boolean, StaticBehaviorMatch>on(_bhBehavior_IsStatic, _on_1, _function_1);
      EReference _bhBehavior_Parameters = BehaviorTranslator.PACKAGE.getBhBehavior_Parameters();
      BehaviorParameterMatcher _on_2 = BehaviorParameterMatcher.on(engine);
      final Function<BehaviorParameterMatch, BhParameter> _function_2 = new Function<BehaviorParameterMatch, BhParameter>() {
        public BhParameter apply(final BehaviorParameterMatch it) {
          final BhParameter bhParameter = BehaviorTranslator.FACTORY.createBhParameter();
          Parameter _parameter = it.getParameter();
          NamedReference _namedReference = new NamedReference(_parameter);
          bhParameter.setReference(_namedReference);
          Type _type = it.getType();
          hu.eltesoft.modelexecution.m2m.metamodel.base.Type _convert = BehaviorTranslator.this.convert(_type);
          bhParameter.setType(_convert);
          ParameterDirectionKind _direction = it.getDirection();
          Direction _convert_1 = BehaviorTranslator.this.convert(_direction);
          bhParameter.setDirection(_convert_1);
          return bhParameter;
        }
      };
      rootNode.<BhParameter, BehaviorParameterMatch>onEObject(_bhBehavior_Parameters, _on_2, _function_2);
      EReference _bhBehavior_ReturnType = BehaviorTranslator.PACKAGE.getBhBehavior_ReturnType();
      BehaviorReturnTypeMatcher _on_3 = BehaviorReturnTypeMatcher.on(engine);
      final Function<BehaviorReturnTypeMatch, hu.eltesoft.modelexecution.m2m.metamodel.base.Type> _function_3 = new Function<BehaviorReturnTypeMatch, hu.eltesoft.modelexecution.m2m.metamodel.base.Type>() {
        public hu.eltesoft.modelexecution.m2m.metamodel.base.Type apply(final BehaviorReturnTypeMatch it) {
          Type _type = it.getType();
          return BehaviorTranslator.this.convert(_type);
        }
      };
      rootNode.<hu.eltesoft.modelexecution.m2m.metamodel.base.Type, BehaviorReturnTypeMatch>onEObject(_bhBehavior_ReturnType, _on_3, _function_3);
      EAttribute _bhBehavior_AlfResult = BehaviorTranslator.PACKAGE.getBhBehavior_AlfResult();
      AlfCodeMatcher _on_4 = AlfCodeMatcher.on(engine);
      final Function<AlfCodeMatch, AlfAnalyzerResult> _function_4 = new Function<AlfCodeMatch, AlfAnalyzerResult>() {
        public AlfAnalyzerResult apply(final AlfCodeMatch it) {
          try {
            AlfAnalyzer _alfAnalyzer = new AlfAnalyzer();
            String _alfCode = it.getAlfCode();
            org.eclipse.uml2.uml.Class _containerClass = it.getContainerClass();
            return _alfAnalyzer.analyze(_alfCode, _containerClass);
          } catch (final Throwable _t) {
            if (_t instanceof UnsupportedAlfFeatureException) {
              final UnsupportedAlfFeatureException e = (UnsupportedAlfFeatureException)_t;
              throw new GenerationException(e);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
      rootNode.<AlfAnalyzerResult, AlfCodeMatch>on(_bhBehavior_AlfResult, _on_4, _function_4);
      EAttribute _bhBehavior_ContainerClass = BehaviorTranslator.PACKAGE.getBhBehavior_ContainerClass();
      ContainerClassOfBehaviorMatcher _on_5 = ContainerClassOfBehaviorMatcher.on(engine);
      final Function<ContainerClassOfBehaviorMatch, NamedReference> _function_5 = new Function<ContainerClassOfBehaviorMatch, NamedReference>() {
        public NamedReference apply(final ContainerClassOfBehaviorMatch it) {
          org.eclipse.uml2.uml.Class _containerClass = it.getContainerClass();
          return new NamedReference(_containerClass);
        }
      };
      rootNode.<NamedReference, ContainerClassOfBehaviorMatch>on(_bhBehavior_ContainerClass, _on_5, _function_5);
      return rootNode;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Template createTemplate(final BhBehavior behavior) {
    return new BehaviorTemplate(behavior);
  }
}
