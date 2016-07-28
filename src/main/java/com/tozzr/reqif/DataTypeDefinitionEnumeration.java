package com.tozzr.reqif;

import org.w3c.dom.Element;

public class DataTypeDefinitionEnumeration extends ReqIFElement implements DatatypeDefinition {

	protected DataTypeDefinitionEnumeration(String id, String lastChange) {
		super("DATATYPE-DEFINITION-ENUMERATION");
		addAttribute("IDENTIFIER", id);
		addAttribute("LAST-CHANGE", lastChange);
		addElement(new SpecifiedValues());
		
	}

	public String getType() {
		return "ENUMERATION";
	}

	@Override
	protected void handleElement(Element e) {
	}

}
