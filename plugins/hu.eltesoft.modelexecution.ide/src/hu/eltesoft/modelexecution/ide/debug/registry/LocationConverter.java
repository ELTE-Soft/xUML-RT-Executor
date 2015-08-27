package hu.eltesoft.modelexecution.ide.debug.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.Location;
import com.sun.jdi.ReferenceType;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.util.ModelUtils;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationRegistry;
import hu.eltesoft.modelexecution.m2t.smap.emf.QualifiedReference;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

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
		Class<? extends LocationQualifier> qualifier;
		qualifier = ModelUtils.defaultQualifierFor(modelElement);
		return locationsFor(modelElement, qualifier);
	}

	public List<Location> locationsFor(EObject modelElement, Class<? extends LocationQualifier> qualifier) {
		List<Location> locations = new ArrayList<>();

		String className = ModelUtils.getContainerName(modelElement);
		DebugSymbols symbols = symbolsRegistry.getSymbolsFor(className);
		if (null == symbols) {
			IdePlugin.logError(String.format("Unable to load debug symbols for class: %s", className));
			return locations;
		}

		ReferenceType type = classForName.get(className);
		if (null == type) {
			IdePlugin.logError(String.format("Reference type not found for class: %s", className));
			return locations;
		}

		LocationRegistry registry = symbols.getLocationRegistry();
		Reference reference = new Reference(modelElement);
		hu.eltesoft.modelexecution.m2t.smap.xtend.Location location;
		location = registry.resolveQualified(reference, qualifier);
		if (null == location) {
			IdePlugin.logError("Unable to resolve model element location");
			return locations;
		}

		try {
			locations = type.locationsOfLine(location.getStartLine());
		} catch (AbsentInformationException e) {
			IdePlugin.logError("Debug information is missing for location");
		}

		return locations;
	}

	public QualifiedReference referenceFor(Location location) {
		String className = location.declaringType().name();
		DebugSymbols symbols = symbolsRegistry.getSymbolsFor(className);
		if (null == symbols) {
			IdePlugin.logError(String.format("Unable to load debug symbols for class: %s", className));
		}

		LocationRegistry registry = symbols.getLocationRegistry();
		try {
			return registry.resolveQualified(convert(location));
		} catch (AbsentInformationException e) {
			IdePlugin.logError("Debug information is missing for location");
			return null;
		}
	}

	private hu.eltesoft.modelexecution.m2t.smap.xtend.Location convert(Location jdiLocation)
			throws AbsentInformationException {
		String path = jdiLocation.sourcePath();
		int lineNumber = jdiLocation.lineNumber();
		return new hu.eltesoft.modelexecution.m2t.smap.xtend.Location(path, lineNumber, lineNumber);
	}
}
