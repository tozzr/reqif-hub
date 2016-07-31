package com.tozzr.reqif;

import org.w3c.dom.Element;

public class DataTypeDefinitionEnumeration extends ReqIFElement implements DatatypeDefinition {

	public String identifier;
	public String lastChange;
	public SpecifiedValues specifiedValues;
	
	protected DataTypeDefinitionEnumeration(String id, String lastChange) {
		super("DATATYPE-DEFINITION-ENUMERATION");
		this.identifier = id;
		this.lastChange = lastChange;
		specifiedValues = new SpecifiedValues();
		
	}

	public String getType() {
		return "ENUMERATION";
	}

	@Override
	protected void handleElement(Element e) {
	}

	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<DATATYPE-DEFINITION-ENUMERATION IDENTIFIER=\"%s\" LAST-CHANGE=\"%s\">\n"
		  + "%s"
		  + "%s</DATATYPE-DEFINITION-ENUMERATION>\n", 
		  getIndentStr(indent),
		  identifier,
		  lastChange,
		  specifiedValues.toXml(indent+2), 
		  getIndentStr(indent));
	}
}
