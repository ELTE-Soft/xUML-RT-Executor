package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

public class Component extends PlatformObject implements IPresentation {

	private List<StateMachineInstance> instances = new LinkedList<>();

	private List<Component> subcomponents = new LinkedList<>();

	private String name;

	public Component(String name) {
		this.name = name;
	}

	public StateMachineInstance[] getStateMachines() {
		return instances.toArray(new StateMachineInstance[instances.size()]);
	}
	
	public ClassInstances[] getStateMachineClasses() {
		Map<String, ClassInstances> ret = new HashMap<>();
		for (StateMachineInstance instance : instances) {
			ClassInstances cls = ret.get(instance.getClassId());
			if (cls == null) {
				cls = new ClassInstances(instance.getClassName());
				ret.put(instance.getClassId(), cls);
			}
			cls.addStateMachineInstance(instance);
		}
		Collection<ClassInstances> values = ret.values();
		return values.toArray(new ClassInstances[values.size()]);
	}

	public void addStateMachineInstance(StateMachineInstance instance) {
		instances.add(instance);
	}

	public StateMachineInstance[] getInstances() {
		return instances.toArray(new StateMachineInstance[instances.size()]);
	}

	public Component[] getComponents() {
		return subcomponents.toArray(new Component[subcomponents.size()]);
	}

	public void addSubcomponent(Component component) {
		subcomponents.add(component);
	}

	public Component[] getSubcomponents() {
		return subcomponents.toArray(new Component[subcomponents.size()]);
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

	@SuppressWarnings({ "unchecked", "restriction" })
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider.class) {
			return (T) new CombiningElementDebugContentProvider<Component>(
					c -> new Object[][] { c.getSubcomponents(), c.getStateMachineClasses() });
		} else if (adapter == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementLabelProvider.class) {
			return (T) new PresentationLabelProvider();
		} else {
			return super.getAdapter(adapter);
		}

	}

}
