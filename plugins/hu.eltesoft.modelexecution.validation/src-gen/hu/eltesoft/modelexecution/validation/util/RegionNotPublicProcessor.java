package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.RegionNotPublicMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Region;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.RegionNotPublic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class RegionNotPublicProcessor implements IMatchProcessor<RegionNotPublicMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRg the value of pattern parameter rg in the currently processed match
   * 
   */
  public abstract void process(final Region pRg);
  
  @Override
  public void process(final RegionNotPublicMatch match) {
    process(match.getRg());
  }
}
