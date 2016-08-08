package com.tozzr.reqif.domain;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

class DataTypes extends ReqIFElement {

	List<DatatypeDefinition> types = new ArrayList<DatatypeDefinition>();
	
	protected DataTypes() {
		super("DATATYPES");
	}
	
	public DatatypeDefinition get(int index) {
		return types.get(index);
	}
	
	@Override
	public String toXml(int indent) {
		String elemStr = "";
		for (DatatypeDefinition d : types)
			elemStr += d.toXml(indent+2);
		return String.format(
			"%s<DATATYPES>\n"
		  + "%s"
		  + "%s</DATATYPES>\n", 
		  getIndentStr(indent), 
		  elemStr, 
		  getIndentStr(indent));
	}
	
	protected void handleElement(Element e) {
		if (e.getNodeName().endsWith("STRING"))
			types.add(DatatypeDefinitionString.fromElement(e));
		if (e.getNodeName().endsWith("XHTML"))
			types.add(DatatypeDefinitionXHTML.fromElement(e));
	}
	
}