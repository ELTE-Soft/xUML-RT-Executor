package hu.eltesoft.modelexecution.m2m.logic;

import org.eclipse.emf.ecore.EObject;

public interface ContainerNameProvider {

	/**
	 * Returns the fully qualified name of model object which contains
	 * <code>modelElement</code>. This container is the root element of the file
	 * in the model's textual representation in which <code>modelElement</code>
	 * is represented.
	 * 
	 * <b>Important note:</b> currently this feature is only supported for
	 * transitions and states. For any other model element, this method will
	 * return <code>null</code>.
	 * 
	 * @param modelElement
	 *            a model element for which the fully qualified name of its
	 *            representing file's root element will be returned
	 * @return the fully qualified name of the root element of the file in which
	 *         <code>modelElement</code> is represented
	 */
	String getContainerName(EObject modelElement);

}
