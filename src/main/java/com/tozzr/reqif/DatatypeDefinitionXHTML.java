package com.tozzr.reqif;

import org.w3c.dom.Element;

class DatatypeDefinitionXHTML extends Identifiable implements DatatypeDefinition {
	
	protected DatatypeDefinitionXHTML(String id, String lastChange) {
		this();
		this.identifier = id;
		this.lastChange = lastChange;
	}
	
	private DatatypeDefinitionXHTML() {
		super("DATATYPE-DEFINITION-XHTML", true);
	}
	
	public String getType() {
		return "XHTML";
	}

	public static DatatypeDefinition fromElement(Element e) {
		DatatypeDefinitionXHTML s = new DatatypeDefinitionXHTML();
		s.handleElement(e);
		return s;
	}

}
