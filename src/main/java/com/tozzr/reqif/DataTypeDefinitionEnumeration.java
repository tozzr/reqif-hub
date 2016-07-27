package com.tozzr.reqif;

public class DataTypeDefinitionEnumeration extends ReqIFElement {

	protected DataTypeDefinitionEnumeration(String id, String lastChange) {
		super("DATATYPE-DEFINITION-ENUMERATION");
		addAttribute("IDENTIFIER", id);
		addAttribute("LAST-CHANGE", lastChange);
		addElement(new SpecifiedValues());
		
	}

}
