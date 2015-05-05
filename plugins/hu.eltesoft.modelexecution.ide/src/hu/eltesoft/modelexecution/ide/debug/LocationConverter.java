package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.debug.util.ModelUtils;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.StateQualifiers;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier.None;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationRegistry;
import hu.eltesoft.modelexecution.m2t.smap.emf.QualifiedReference;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.State;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.Location;
import com.sun.jdi.ReferenceType;

@SuppressWarnings("restriction")
public class LocationConverter {

	private final SymbolsRegistry symbolsRegistry;
	private final Map<String, ReferenceType> classForName = new HashMap<>();

	public LocationConverter(SymbolsRegistry symbolsRegistry) {
		this.symbolsRegistry = symbolsRegistry;
	}

	public void registerClass(ReferenceType type) {
		classForName.put(type.name(), type);
	}

	public List<Location> locationsFor(EObject modelElement) {
		Class<? extends LocationQualifier> qualifier = defaultQualifierFor(modelElement);
		return locationsFor(modelElement, qualifier);
	}

	private Class<? extends LocationQualifier> defaultQualifierFor(
			EObject modelElement) {
		if (modelElement instanceof Pseudostate) {
			return StateQualifiers.Exit.class;
		} else if (modelElement instanceof State) {
			return StateQualifiers.Entry.class;
		}
		return None.class;
	}

	public List<Location> locationsFor(EObject modelElement,
			Class<? extends LocationQualifier> qualifier) {
		List<Location> locations = new ArrayList<>();

		String className = ModelUtils.getContainerName(modelElement);
		DebugSymbols symbols = symbolsRegistry.getSymbolsFor(className);
		if (null == symbols) {
			// TODO: log error?
			return locations;
		}

		LocationRegistry registry = symbols.getLocationRegistry();
		// TODO: resolve model element?
		Reference reference = new Reference(modelElement);
		int startLine = registry.resolveQualified(reference, qualifier)
				.getStartLine();

		ReferenceType type = classForName.get(className);
		if (null == type) {
			// TODO: log error?
			return locations;
		}

		try {
			locations = type.locationsOfLine(startLine);
		} catch (AbsentInformationException e) {
			// TODO: log error?
		}

		return locations;
	}

	public QualifiedReference referenceFor(Location location) {
		String className = location.declaringType().name();
		DebugSymbols symbols = symbolsRegistry.getSymbolsFor(className);
		if (null == symbols) {
			// TODO: log error?
			return null;
		}

		LocationRegistry registry = symbols.getLocationRegistry();
		try {
			return registry.resolveQualified(convert(location));
		} catch (AbsentInformationException e) {
			// TODO: log error?
			return null;
		}
	}

	private hu.eltesoft.modelexecution.m2t.smap.xtend.Location convert(
			Location jdiLocation) throws AbsentInformationException {
		String path = jdiLocation.sourcePath();
		int lineNumber = jdiLocation.lineNumber();
		return new hu.eltesoft.modelexecution.m2t.smap.xtend.Location(path,
				lineNumber, lineNumber);
	}
}
