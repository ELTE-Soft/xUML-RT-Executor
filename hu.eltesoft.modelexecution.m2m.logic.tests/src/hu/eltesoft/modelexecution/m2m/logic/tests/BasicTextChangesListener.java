package hu.eltesoft.modelexecution.m2m.logic.tests;

import java.util.ArrayList;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

public class BasicTextChangesListener implements TextChangesListener {

	ArrayList<String> deletions = new ArrayList<>();
	ArrayList<String> modifications = new ArrayList<>();
	ArrayList<SourceMappedText> outputs = new ArrayList<>();
	ArrayList<DebugSymbols> symbols = new ArrayList<>();
	
	
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

	
}
