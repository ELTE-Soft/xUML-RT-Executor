package hu.eltesoft.modelexecution.m2t.smap.emf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Maps qualified EMF object references to virtual line numbers. Line numbering
 * starts from one, and incremented by one when a new reference inserted.
 */
class ReferenceToLineMapping implements Serializable {

	private static final long serialVersionUID = 303577619348585564L;

	private final Vector<QualifiedReference> lineNumberToReference = new Vector<>();
	private final Map<QualifiedReference, Integer> referenceToLineNumber = new HashMap<>();

	public int addLineNumber(QualifiedReference reference) {
		Integer result = toLineNumber(reference);
		if (null != result) {
			return result;
		}

		lineNumberToReference.add(reference);
		int lineNumber = lineNumberToReference.size();
		referenceToLineNumber.put(reference, lineNumber);
		return lineNumber;
	}

	public Integer toLineNumber(QualifiedReference reference) {
		return referenceToLineNumber.get(reference);
	}

	public QualifiedReference fromLineNumber(int lineNumber) {
		// Vectors are indexed from zero, while lines from one
		int index = lineNumber - 1;

		if (index < 0 || lineNumberToReference.size() <= index) {
			return null;
		}

		return lineNumberToReference.get(index);
	}

	@Override
	public String toString() {
		return referenceToLineNumber.toString() + ";" + lineNumberToReference.toString();
	}
}
