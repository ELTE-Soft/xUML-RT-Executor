package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.GeneralizationSetMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Generalization;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.GeneralizationSet pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GeneralizationSetProcessor implements IMatchProcessor<GeneralizationSetMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pGen the value of pattern parameter gen in the currently processed match
   * 
   */
  public abstract void process(final Generalization pGen);
  
  @Override
  public void process(final GeneralizationSetMatch match) {
    process(match.getGen());
  }
}
