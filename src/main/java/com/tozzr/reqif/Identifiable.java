package com.tozzr.reqif;

import org.w3c.dom.Element;

public abstract class Identifiable extends ReqIFElement {

	public String identifier;
	public String lastChange;
	public String longName;
	
	protected Identifiable(String name) {
		super(name);
	}
	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<%s IDENTIFIER=\"%s\" LAST-CHANGE=\"%s\" LONG-NAME=\"%s\"%s/>\n",
			getIndentStr(indent),
			getName(),
			identifier,
			lastChange,
			longName,
			getExtraAttributesToXml()
		);
	}
	
	protected String getExtraAttributesToXml() {
		return "";
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
