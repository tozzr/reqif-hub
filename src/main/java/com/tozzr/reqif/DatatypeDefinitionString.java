package com.tozzr.reqif;

import org.w3c.dom.Element;

class DatatypeDefinitionString extends ReqIFElement implements DatatypeDefinition {

	protected DatatypeDefinitionString(String id, int maxLength) {
		this();
		addAttribute("IDENTIFIER", id);
		addAttribute("MAX-LENGTH", ""+maxLength);
	}
	
	protected DatatypeDefinitionString(String id, String lastChange, int maxLength) {
		this(id, maxLength);
		addAttribute("LAST-CHANGE", lastChange);
	}
	
	private DatatypeDefinitionString() {
		super("DATATYPE-DEFINITION-STRING");
	}

	public String getType() {
		return "STRING";
	}

	public static DatatypeDefinition fromElement(Element e) {
		DatatypeDefinitionString s = new DatatypeDefinitionString();
		return s;
	}

	@Override
	protected void handleElement(Element e) {
		// TODO Auto-generated method stub
		
	}
	
}
