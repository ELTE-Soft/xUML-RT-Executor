/**
 * <p>
 * Base classes and a small DSL for building translators that translate IncQuery
 * pattern matches containing UML elements into an instance of the translational
 * model.
 * </p>
 * 
 * <p>
 * To create a translator we build a translator tree. That tree establishes a
 * mapping between the structure of the IncQuery patterns and the translational
 * metamodel. For every IncQuery pattern, we assign a feature of the translation
 * model that is set by the results of the pattern.
 * </p>
 * 
 * <p>
 * While constructing the translator from the UML model to the translational
 * model we assume that the patterns are structured as the following:
 * </p>
 * 
 * <ul>
 * <li>The first parameter is the root element, from which a source file will be
 * generated.</li>
 *
 * <li>If the current element is in the nth level of the feature tree, the first
 * n-1 parameters of the pattern are the ancestors of the current element.</li>
 * 
 * <li>The nth parameter in the pattern is the current element.</li>
 * </ul>
 */
package hu.eltesoft.modelexecution.m2m.logic.translators.base;
