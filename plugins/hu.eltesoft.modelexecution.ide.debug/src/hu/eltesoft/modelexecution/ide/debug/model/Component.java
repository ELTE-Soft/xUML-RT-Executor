package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLFactory;

import hu.eltesoft.modelexecution.ide.debug.model.utils.CombiningContentProvider;
import hu.eltesoft.modelexecution.ide.debug.model.utils.PresentationLabelProvider;

public class Component extends DebugElement implements IPresentation {

	private List<ClassInstances> classes = new LinkedList<>();

	private List<Component> subcomponents = new LinkedList<>();

	private String name;

	private DebugElement parent;

	public Component(XUMLRTDebugTarget parent, String name) {
		super(parent);
		this.parent = parent;
		this.name = name;
	}

	public Component(Component parent, String name) {
		super(parent.getXUmlRtDebugTarget());
		this.parent = parent;
		this.name = name;
	}

	public StateMachineInstance[] getStateMachines() {
		List<StateMachineInstance> instances = getSmInstances();
		return instances.toArray(new StateMachineInstance[instances.size()]);
	}

	public ClassInstances[] getStateMachineClasses() {
		return classes.toArray(new ClassInstances[classes.size()]);
	}

	public StateMachineInstance addStateMachineInstance(String classId, int instanceId, String originalName) {
		ClassInstances cls = getOrCreateClassFor(classId, originalName);
		return cls.addStateMachineInstance(instanceId);
	}

	public void removeStateMachineInstance(StateMachineInstance instance) {
		ClassInstances cls = getOrCreateClassFor(instance.getClassId(), instance.getClassName());
		cls.removeStateMachineInstance(instance);
	}

	public StateMachineInstance[] getInstances() {
		List<StateMachineInstance> instances = getSmInstances();
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
			return (T) new CombiningContentProvider<Component>().setMapping(IDebugUIConstants.ID_DEBUG_VIEW,
					c -> new Object[][] { c.getSubcomponents(), c.getStateMachineClasses() });
		} else if (adapter == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementLabelProvider.class) {
			return (T) new PresentationLabelProvider();
		} else {
			return super.getAdapter(adapter);
		}

	}

	public boolean hasSMInstance() {
		if (!classes.isEmpty()) {
			return true;
		}
		for (Component component : subcomponents) {
			if (component.hasSMInstance()) {
				return true;
			}
		}
		return false;
	}

	public List<StateMachineInstance> getSmInstances() {
		List<StateMachineInstance> ret = new LinkedList<>();
		for (Component component : subcomponents) {
			ret.addAll(component.getSmInstances());
		}
		for (ClassInstances cls : classes) {
			ret.addAll(cls.getSmInstances());
		}
		return ret;
	}

	public ClassInstances getOrCreateClassFor(String classId, String className) {
		for (ClassInstances cls : classes) {
			if (cls.getClassId().equals(classId)) {
				return cls;
			}
		}
		ClassInstances cls = new ClassInstances(this, classId, className);
		classes.add(cls);
		getDebugControl().addDebugElement(this, cls);
		return cls;
	}

	@Override
	public DebugElement getParent() {
		return parent;
	}

}
