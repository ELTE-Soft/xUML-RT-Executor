package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ModelViewpointMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Model;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ModelViewpoint pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ModelViewpointProcessor implements IMatchProcessor<ModelViewpointMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pMd the value of pattern parameter md in the currently processed match
   * 
   */
  public abstract void process(final Model pMd);
  
  @Override
  public void process(final ModelViewpointMatch match) {
    process(match.getMd());
  }
}
