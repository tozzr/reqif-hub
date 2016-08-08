package com.tozzr.reqif.domain;

import org.w3c.dom.Element;

class DatatypeDefinitionString extends Identifiable implements DatatypeDefinition {

	public int maxLength;
	
	protected DatatypeDefinitionString(String id, int maxLength) {
		this();
		this.identifier = id;
		this.maxLength = maxLength;
	}
	
	protected DatatypeDefinitionString(String id, String lastChange, String longName, int maxLength) {
		this(id, maxLength);
		this.longName = longName;
		this.lastChange = lastChange;
	}
	
	private DatatypeDefinitionString() {
		super("DATATYPE-DEFINITION-STRING", true);
	}

	public String getType() {
		return "STRING";
	}

	public static DatatypeDefinition fromElement(Element e) {
		DatatypeDefinitionString s = new DatatypeDefinitionString();
		s.handleElement(e);
		return s;
	}

	@Override
	public String toXml(int indent) {
		setAttribute("MAX-LENGTH", ""+maxLength);
		return super.toXml(indent);
	}
	
	@Override
	protected void handleExtraAttributes(Element e) {
		maxLength = Integer.valueOf(e.getAttribute("MAX-LENGTH"));
	}
	
}
