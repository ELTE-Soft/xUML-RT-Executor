package hu.eltesoft.modelexecution.ide.debug.registry;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;

public class SymbolsRegistry {

	private static final String SYMBOLS_EXTENSION = ".symbols";

	private final IPath debugSymbolsDir;

	private final Map<String, DebugSymbols> symbolsForClass = new HashMap<>();

	public SymbolsRegistry(IPath debugSymbolsDir) {
		this.debugSymbolsDir = debugSymbolsDir;
	}

	public DebugSymbols getSymbolsFor(String className) {
		if (!symbolsForClass.containsKey(className)) {
			loadSymbolsFor(className);
		}

		return symbolsForClass.get(className);
	}

	private void loadSymbolsFor(String className) {
		String fileName = toSymbolsFileName(className);
		File file = debugSymbolsDir.append(fileName).toFile();
		if (!file.isFile()) {
			return;
		}

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
			DebugSymbols symbols = (DebugSymbols) ois.readObject();
			symbolsForClass.put(className, symbols);
		} catch (Exception e) {
			PluginLogger.logError("Unable to deserialize symbols file", e);
		}
	}

	private String toSymbolsFileName(String className) {
		return className.replace('.', '/') + SYMBOLS_EXTENSION;
	}
}
