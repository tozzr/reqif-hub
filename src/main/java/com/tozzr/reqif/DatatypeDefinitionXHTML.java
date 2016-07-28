package com.tozzr.reqif;

import org.w3c.dom.Element;

class DatatypeDefinitionXHTML extends ReqIFElement implements DatatypeDefinition {

	protected DatatypeDefinitionXHTML(String id, int maxLength) {
		this();
		addAttribute("IDENTIFIER", id);
		addAttribute("MAX-LENGTH", ""+maxLength);
	}
	
	protected DatatypeDefinitionXHTML(String id, String lastChange, int maxLength) {
		this(id, maxLength);
		addAttribute("LAST-CHANGE", lastChange);
	}
	
	private DatatypeDefinitionXHTML() {
		super("DATATYPE-DEFINITION-XHTML");
	}

	public String getType() {
		return "XHTML";
	}

	public static DatatypeDefinition fromElement(Element e) {
		DatatypeDefinitionXHTML s = new DatatypeDefinitionXHTML();
		return s;
	}

	@Override
	protected void handleElement(Element e) {
	}
	
}
