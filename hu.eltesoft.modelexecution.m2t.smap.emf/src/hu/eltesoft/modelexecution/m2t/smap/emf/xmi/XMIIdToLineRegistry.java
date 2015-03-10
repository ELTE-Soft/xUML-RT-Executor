package hu.eltesoft.modelexecution.m2t.smap.emf.xmi;

import hu.eltesoft.modelexecution.m2t.smap.emf.QualifiedEObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * Assigns virtual line numbers for qualified EObjects contained in a single XMI
 * resource.
 */
class XMIIdToLineRegistry {
	private Vector<QualifiedXMIId> lineNumberToId = new Vector<>();
	private Map<QualifiedXMIId, Integer> idToLineNumber = new HashMap<>();

	private final Resource resource;

	public XMIIdToLineRegistry(Resource resource) {
		this.resource = resource;
	}

	public int objectToLineNumber(QualifiedEObject object) {
		String uuid = getXMIIdAttribute(object.getEObject());
		QualifiedXMIId key = new QualifiedXMIId(uuid, object.getQualifier());

		Integer result = idToLineNumber.get(key);
		if (null != result) {
			return result;
		}

		lineNumberToId.add(key);
		int lineNumber = lineNumberToId.size();
		idToLineNumber.put(key, lineNumber);
		return lineNumber;
	}

	private String getXMIIdAttribute(EObject object) {
		return ((XMLResource) object.eResource()).getID(object);
	}

	public QualifiedEObject lineNumberToObject(int lineNumber) {
		// Vectors are indexed from zero, while lines from one!
		int index = lineNumber - 1;

		if (lineNumber < 0 || lineNumberToId.size() <= index) {
			return null;
		}

		QualifiedXMIId key = lineNumberToId.get(index);
		EObject eObject = getEObject(key.getUuid());
		return new QualifiedEObject(eObject, key.getQualifier());
	}

	private EObject getEObject(String uuid) {
		return resource.getEObject(uuid);
	}
}
