package hu.eltesoft.modelexecution.m2t.smap.emf;

import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Assigns virtual locations to EMF object references. These locations can be
 * used to implement source mapping for generated code. Objects from different
 * model files (resources) are mapped to different virtual files, each having
 * its own virtual lines for their objects.
 */
public class LocationRegistry implements Serializable {

	private static final long serialVersionUID = -3728712114679694347L;

	private final Map<String, ReferenceToLineMapping> mappings = new HashMap<>();

	private ReferenceToLineMapping getMapping(String filePath) {
		ReferenceToLineMapping mapping = mappings.get(filePath);
		if (null != mapping) {
			return mapping;
		}

		mapping = new ReferenceToLineMapping();
		mappings.put(filePath, mapping);
		return mapping;
	}

	public Location assign(Reference reference) {
		return assignQualified(new QualifiedReference(reference));
	}

	public Location assignQualified(Reference reference,
			Class<? extends LocationQualifier> qualifier) {
		return assignQualified(new QualifiedReference(reference, qualifier));
	}

	public Location assignQualified(QualifiedReference reference) {
		String filePath = reference.getResourceURI().toString();
		int lineNumber = getMapping(filePath).addLineNumber(reference);
		return new Location(filePath, lineNumber, lineNumber);
	}

	public Reference resolve(Location location) {
		return resolveQualified(location);
	}

	public QualifiedReference resolveQualified(Location location) {
		ReferenceToLineMapping mapping = getMapping(location.getFilePath());
		for (int i = location.getStartLine(); i <= location.getEndLine(); ++i) {
			QualifiedReference result = mapping.fromLineNumber(i);
			if (null != result) {
				return result;
			}
		}
		return null;
	}

	public Location resolve(Reference reference) {
		return resolveQualified(new QualifiedReference(reference));
	}

	public Location resolveQualified(Reference reference,
			Class<? extends LocationQualifier> qualifier) {
		return resolveQualified(new QualifiedReference(reference, qualifier));
	}

	public Location resolveQualified(QualifiedReference reference) {
		String filePath = reference.getResourceURI().toString();
		Integer lineNumber = getMapping(filePath).toLineNumber(reference);
		if (null == lineNumber) {
			return null;
		}
		return new Location(filePath, lineNumber, lineNumber);
	}
}
