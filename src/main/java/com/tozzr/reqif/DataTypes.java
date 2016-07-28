package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

class DataTypes extends ReqIFElement {

	private List<DatatypeDefinition> types = new ArrayList<DatatypeDefinition>();
	
	protected DataTypes() {
		super("DATATYPES");
	}
	
	public DatatypeDefinition get(int index) {
		return types.get(index);
	}
	
	@Override
	public String toXml(int ident) {
		String identStr = "";
		for (int i=0; i<ident; i++)
			identStr += " ";
		String elemStr = elementsToXml(ident);
		return String.format("%s<DATATYPES>\n%s%s</DATATYPES>\n", identStr, elemStr, identStr);
	}
	
	protected void handleElement(Element e) {
		if (e.getNodeName().endsWith("STRING"))
			types.add(DatatypeDefinitionString.fromElement(e));
		if (e.getNodeName().endsWith("XHTML"))
			types.add(DatatypeDefinitionXHTML.fromElement(e));
	}
	
}