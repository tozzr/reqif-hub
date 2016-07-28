package com.tozzr.reqif;

import org.w3c.dom.Element;

class ReqIFContent extends ReqIFElement {

	public DataTypes dataTypes;
	public SpecTypes specTypes;
	public SpecObjects specObjects;
	
	protected ReqIFContent() {
		super("REQ-IF-CONTENT");
		dataTypes = new DataTypes();
		specTypes = new SpecTypes();
		specObjects = new SpecObjects();
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
		  + "%s"
		  + "%s"
		  + "%s</REQ-IF-CONTENT>\n"
		  + "%s</CORE-CONTENT>\n", 
			getIdentStr(ident),
			getIdentStr(ident+2),
			dataTypes.toXml(ident+4),
			specTypes.toXml(ident+4),
			specObjects.toXml(ident+4),
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
		if (e.getNodeName().equals("SPEC-TYPES"))
			specTypes.fromXml(e);
		if (e.getNodeName().equals("SPEC-OBJECTS"))
			specObjects.fromXml(e);
	}
	
}
