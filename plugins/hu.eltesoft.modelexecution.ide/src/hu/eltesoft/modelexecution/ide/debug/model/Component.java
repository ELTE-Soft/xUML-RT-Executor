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

public class Component extends PlatformObject implements IPresentation {

	private List<StateMachineInstance> instances = new LinkedList<>();
	
	private List<Component> components = new LinkedList<>();
	
	private String name;
	
	
	public Component(String name) {
		this.name = name;
	}

	public StateMachineInstance[] getStateMachines() {
		return instances.toArray(new StateMachineInstance[instances.size()]);
	}
	
	public void addStateMachineInstance(StateMachineInstance instance) {
		instances.add(instance);
	}
	
	public Component[] getComponents() {
		return components.toArray(new Component[components.size()]);
	}
	
	public void addSubcomponent(Component component) {
		components.add(component);
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
		EObject component = UMLFactory.eINSTANCE.createComponent();
		IImage image = ImageQuery.getEObjectImage(component);
		Device device = Display.getCurrent();
		return new Image(device, image.getInputStream());
	}
	
}
