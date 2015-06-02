package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Region;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.RegionOfClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class RegionOfClassProcessor implements IMatchProcessor<RegionOfClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pRegion the value of pattern parameter region in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Region pRegion);
  
  @Override
  public void process(final RegionOfClassMatch match) {
    process(match.getCls(), match.getRegion());
    
  }
}
