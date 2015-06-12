package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EventFactory;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalEventTemplate;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatcher;
import java.util.function.Function;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class SignalEventTranslator extends RootElementTranslator<SignalEvent, EvSignalEvent, SignalEventMatch> {
  private final static EventFactory FACTORY = EventFactory.eINSTANCE;
  
  public SignalEventTranslator(final IncQueryEngine engine) throws IncQueryException {
    super(engine);
  }
  
  public RootNode<SignalEvent, EvSignalEvent, SignalEventMatch> buildMapper(final IncQueryEngine engine) {
    try {
      SignalEventMatcher _on = SignalEventMatcher.on(engine);
      final Function<SignalEventMatch, EvSignalEvent> _function = new Function<SignalEventMatch, EvSignalEvent>() {
        public EvSignalEvent apply(final SignalEventMatch it) {
          final EvSignalEvent root = SignalEventTranslator.FACTORY.createEvSignalEvent();
          SignalEvent _event = it.getEvent();
          NamedReference _namedReference = new NamedReference(_event);
          root.setReference(_namedReference);
          Signal _signal = it.getSignal();
          NamedReference _namedReference_1 = new NamedReference(_signal);
          root.setSignal(_namedReference_1);
          return root;
        }
      };
      return this.fromRoot(_on, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Template createTemplate(final EvSignalEvent event) {
    return new SignalEventTemplate(event);
  }
}
