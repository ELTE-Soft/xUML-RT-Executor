package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.TemplateParameterMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Classifier;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.TemplateParameter pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TemplateParameterProcessor implements IMatchProcessor<TemplateParameterMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final Classifier pElem);
  
  @Override
  public void process(final TemplateParameterMatch match) {
    process(match.getElem());
  }
}
