package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.CapsulePartMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.capsulePart pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CapsulePartProcessor implements IMatchProcessor<CapsulePartMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pComponent the value of pattern parameter component in the currently processed match
   * @param pProperty the value of pattern parameter property in the currently processed match
   * 
   */
  public abstract void process(final Component pComponent, final Property pProperty);
  
  @Override
  public void process(final CapsulePartMatch match) {
    process(match.getComponent(), match.getProperty());
  }
}
