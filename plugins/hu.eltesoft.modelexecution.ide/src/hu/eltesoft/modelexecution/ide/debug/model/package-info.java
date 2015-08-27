/**
 * Contains UI elements that contribute to the Debug perspective in the debug
 * view and the variables view. These must subclass Moka equivalents otherwise
 * Moka events could not be generated for them, but in theory they should be
 * only implementing the org.eclipse.debug interfaces, since they don't really
 * need attributes and methods inherited from Moka classes.
 */
package hu.eltesoft.modelexecution.ide.debug.model;