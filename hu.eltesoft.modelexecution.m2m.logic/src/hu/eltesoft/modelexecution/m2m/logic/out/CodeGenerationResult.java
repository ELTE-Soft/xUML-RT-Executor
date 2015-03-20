package hu.eltesoft.modelexecution.m2m.logic.out;

import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

public interface CodeGenerationResult {

	String getName();
	
	SourceMappedText getOutput();
	
	DebugSymbols getDebugSymbols();
	
}
