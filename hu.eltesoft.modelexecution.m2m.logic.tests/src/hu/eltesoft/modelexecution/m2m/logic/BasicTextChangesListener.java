package hu.eltesoft.modelexecution.m2m.logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

public class BasicTextChangesListener implements TextChangesListener {

	ArrayList<String> deletions = new ArrayList<>();
	ArrayList<String> modifications = new ArrayList<>();
	ArrayList<SourceMappedText> outputs = new ArrayList<>();
	ArrayList<DebugSymbols> symbols = new ArrayList<>();

	public void clear() {
		deletions.clear();
		modifications.clear();
		outputs.clear();
		symbols.clear();
	}
	
	@Override
	public void contentChanged(String filename, SourceMappedText output,
			DebugSymbols symbols) {

		this.modifications.add(filename);
		this.outputs.add(output);
		this.symbols.add(symbols);
	}

	@Override
	public void contentDeleted(String filename) {

		this.deletions.add(filename);
	}

	public void printModifiedFiles(String path) {
		for (int i = 0; i < modifications.size(); ++i) {
			print(path, modifications.get(i), outputs.get(i).toString());
		}

	}

	private void print(String path, String filename, String content) {
		File outFile = Paths.get(path, filename + ".java").toFile();
		File parent = outFile.getParentFile();

		System.out.println("File generated: " + outFile.getAbsolutePath());

		if (null != parent) {
			parent.mkdirs();
		}

		try (FileWriter writer = new FileWriter(outFile);) {
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
