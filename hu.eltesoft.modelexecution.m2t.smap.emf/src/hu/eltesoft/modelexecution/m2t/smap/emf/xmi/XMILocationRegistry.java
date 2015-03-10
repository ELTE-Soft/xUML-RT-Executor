package hu.eltesoft.modelexecution.m2t.smap.emf.xmi;

import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationRegistry;
import hu.eltesoft.modelexecution.m2t.smap.emf.QualifiedEObject;
import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class XMILocationRegistry implements LocationRegistry {

	public static final LocationRegistry INSTANCE = new XMILocationRegistry();

	private final Map<String, XMIIdToLineRegistry> registries = new HashMap<>();

	@Override
	public Location assign(EObject object) {
		return assignQualified(object, LocationQualifier.None.class);
	}

	@Override
	public Location assignQualified(EObject object,
			Class<? extends LocationQualifier> qualifier) {
		String filePath = getFilePath(object.eResource());
		XMIIdToLineRegistry registry = getRegistry(object.eResource());
		QualifiedEObject qualified = new QualifiedEObject(object, qualifier);
		int lineNumber = registry.objectToLineNumber(qualified);
		return new Location(filePath, lineNumber, lineNumber);
	}

	private XMIIdToLineRegistry getRegistry(Resource resource) {
		String filePath = getFilePath(resource);
		if (!registries.containsKey(filePath)) {
			registries.put(filePath, new XMIIdToLineRegistry(resource));
		}
		return registries.get(filePath);
	}

	private String getFilePath(Resource resource) {
		return resource.getURI().trimFragment().toFileString();
	}

	private XMIIdToLineRegistry getRegistry(String filePath) {
		return registries.get(filePath);
	}

	@Override
	public EObject resolve(Location location) {
		return resolveQualified(location).getEObject();
	}

	@Override
	public QualifiedEObject resolveQualified(Location location) {
		XMIIdToLineRegistry registry = getRegistry(location.getFilePath());
		for (int i = location.getStartLine(); i <= location.getEndLine(); ++i) {
			QualifiedEObject result = registry.lineNumberToObject(i);
			if (null != result) {
				return result;
			}
		}
		return null;
	}
}
