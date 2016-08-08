package com.tozzr.reqif.domain;

import org.w3c.dom.Element;

public abstract class Identifiable extends ReqIFElement {

	public String identifier;
	public String lastChange;
	public String longName;
	
	protected Identifiable(final String name) {
		super(name);
	}
	
	protected Identifiable(final String name, final boolean selfClosing) {
		super(name, selfClosing);
	}
	
	@Override
	public String toXml(int indent) {
		setAttribute("IDENTIFIER", identifier);
		setAttribute("LAST-CHANGE", lastChange);
		setAttribute("LONG-NAME", longName);
		return super.toXml(indent);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals(getName())) {
			identifier = e.getAttribute("IDENTIFIER");
			lastChange = e.getAttribute("LAST-CHANGE");
			longName = e.getAttribute("LONG-NAME");
			handleExtraAttributes(e);
		}
	}

	protected void handleExtraAttributes(Element e) {
	}
}
