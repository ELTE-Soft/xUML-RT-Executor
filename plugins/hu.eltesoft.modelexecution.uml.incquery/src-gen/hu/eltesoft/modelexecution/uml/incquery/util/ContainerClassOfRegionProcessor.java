package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Region;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegion pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ContainerClassOfRegionProcessor implements IMatchProcessor<ContainerClassOfRegionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRegion the value of pattern parameter region in the currently processed match
   * @param pContainerClassName the value of pattern parameter containerClassName in the currently processed match
   * 
   */
  public abstract void process(final Region pRegion, final String pContainerClassName);
  
  @Override
  public void process(final ContainerClassOfRegionMatch match) {
    process(match.getRegion(), match.getContainerClassName());
    
  }
}
