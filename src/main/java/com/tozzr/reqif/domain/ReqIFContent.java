package com.tozzr.reqif.domain;

import org.w3c.dom.Element;

class ReqIFContent extends ReqIFElement {

	public DataTypes dataTypes;
	public SpecTypes specTypes;
	public SpecObjects specObjects;
	public SpecRelations specRelations;
	public Specifications specifications;
	
	protected ReqIFContent() {
		super("REQ-IF-CONTENT");
		dataTypes = new DataTypes();
		specTypes = new SpecTypes();
		specObjects = new SpecObjects();
		specRelations = new SpecRelations();
		specifications = new Specifications();
	}
	
	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<CORE-CONTENT>\n"
		  + "%s<REQ-IF-CONTENT>\n"
		  + "%s"
		  + "%s"
		  + "%s"
		  + "%s"
		  + "%s"
		  + "%s</REQ-IF-CONTENT>\n"
		  + "%s</CORE-CONTENT>\n", 
			getIndentStr(indent),
			getIndentStr(indent+2),
			dataTypes.toXml(indent+4),
			specTypes.toXml(indent+4),
			specObjects.toXml(indent+4),
			specRelations.toXml(indent+4),
			specifications.toXml(indent+4),
			getIndentStr(indent+2),
			getIndentStr(indent)
		);
	}

	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("REQ-IF-CONTENT")) fromXml(e);
		if (e.getNodeName().equals("DATATYPES"))      dataTypes.fromXml(e);
		if (e.getNodeName().equals("SPEC-TYPES"))     specTypes.fromXml(e);
		if (e.getNodeName().equals("SPEC-OBJECTS"))   specObjects.fromXml(e);
		if (e.getNodeName().equals("SPEC-RELATIONS")) specRelations.fromXml(e);
		if (e.getNodeName().equals("SPECIFICATIONS")) specifications.fromXml(e);
	}
	
}
