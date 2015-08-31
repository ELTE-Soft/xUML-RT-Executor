package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLFactory;

import hu.eltesoft.modelexecution.ide.debug.model.utils.CombiningElementDebugContentProvider;
import hu.eltesoft.modelexecution.ide.debug.model.utils.PresentationLabelProvider;

public class ClassInstances extends PlatformObject implements IPresentation {

	private List<StateMachineInstance> instances = new LinkedList<>();

	private String name;

	public ClassInstances(String className) {
		this.name = className;
	}

	public StateMachineInstance[] getStateMachines() {
		return instances.toArray(new StateMachineInstance[instances.size()]);
	}

	public void addStateMachineInstance(StateMachineInstance instance) {
		instances.add(instance);
	}

	public StateMachineInstance[] getInstances() {
		return instances.toArray(new StateMachineInstance[instances.size()]);
	}

	@Override
	public String getLabel() {
		return name;
	}

	@Override
	public String getDetails() {
		return null; // should not be shown
	}

	@Override
	public Image getImage() {
		EObject component = UMLFactory.eINSTANCE.createClass();
		IImage image = ImageQuery.getEObjectImage(component);
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}

	@SuppressWarnings({ "unchecked", "restriction" })
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider.class) {
			return (T) new CombiningElementDebugContentProvider<ClassInstances>(
					c -> new Object[][] { c.getInstances() });
		} else if (adapter == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementLabelProvider.class) {
			return (T) new PresentationLabelProvider();
		} else {
			return null;
		}

	}	

}
