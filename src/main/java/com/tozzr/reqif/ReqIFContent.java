package com.tozzr.reqif;

import org.w3c.dom.Element;

class ReqIFContent extends ReqIFElement {

	public DataTypes dataTypes;
	
	protected ReqIFContent() {
		super("REQ-IF-CONTENT");
		dataTypes = new DataTypes();
		addElement(new SpecTypes());
		addElement(new SpecObjects());
		addElement(new SpecRelations());
		addElement(new Specifications());
	}
	
	@Override
	public String toXml(int ident) {
		return String.format(
			"%s<CORE-CONTENT>\n"
		  + "%s<REQ-IF-CONTENT>\n"
		  + "%s"
		  + "%s"
		  + "%s</REQ-IF-CONTENT>\n"
		  + "%s</CORE-CONTENT>\n", 
			getIdentStr(ident),
			getIdentStr(ident+2),
			dataTypes.toXml(ident+4),
			elementsToXml(ident+2), 
			getIdentStr(ident+2),
			getIdentStr(ident)
		);
	}

	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("REQ-IF-CONTENT"))
			fromXml(e);
		if (e.getNodeName().equals("DATATYPES"))
			dataTypes.fromXml(e);
	}
	
}
