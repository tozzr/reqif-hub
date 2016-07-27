package com.tozzr.reqif;

class DataTypeDefinitionString extends ReqIFElement {

	protected DataTypeDefinitionString(String id, int maxLength) {
		super("DATATYPE-DEFINITION-STRING");
		addAttribute("IDENTIFIER", id);
		addAttribute("MAX-LENGTH", ""+maxLength);
	}
	
	protected DataTypeDefinitionString(String id, String lastChange, int maxLength) {
		this(id, maxLength);
		addAttribute("LAST-CHANGE", lastChange);
	}
	
}
