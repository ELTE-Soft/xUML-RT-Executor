package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ConnectorEndMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.connectorEnd pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ConnectorEndProcessor implements IMatchProcessor<ConnectorEndMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pConnector the value of pattern parameter connector in the currently processed match
   * @param pConnectorEnd the value of pattern parameter connectorEnd in the currently processed match
   * 
   */
  public abstract void process(final Connector pConnector, final ConnectorEnd pConnectorEnd);
  
  @Override
  public void process(final ConnectorEndMatch match) {
    process(match.getConnector(), match.getConnectorEnd());
  }
}
