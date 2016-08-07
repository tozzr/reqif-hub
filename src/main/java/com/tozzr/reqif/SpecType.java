package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

public abstract class SpecType extends Identifiable {

	List<AttributeDefinition> specAttributes = new ArrayList<AttributeDefinition>();
	
	protected SpecType(String name) {
		super(name);
	}

	@Override
	public String toXml(int indent) {
		String elemStr = "";
		for (AttributeDefinition a : specAttributes)
			elemStr += a.toXml(indent+4);
		return String.format(
			"%s<%s IDENTIFIER=\"%s\" LAST-CHANGE=\"%s\" LONG-NAME=\"%s\">\n"
		  + "%s<SPEC-ATTRIBUTES>\n"
		  + "%s"
		  + "%s</SPEC-ATTRIBUTES>\n"
		  + "%s</%s>\n",
			getIndentStr(indent),
			getName(),
			identifier,
			lastChange,
			longName,
//			getExtraAttributesToXml(),
			getIndentStr(indent+2),
			elemStr,
			getIndentStr(indent+2),
			getIndentStr(indent),
			getName()
		);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPEC-OBJECT-TYPE")) {
			super.handleElement(e);
			fromXml(e);
		}
		if (e.getNodeName().equals("SPECIFICATION-TYPE")) {
			super.handleElement(e);
			fromXml(e);
		}
		if (e.getNodeName().equals("SPEC-RELATION-TYPE")) {
			super.handleElement(e);
			fromXml(e);
		}
		if (e.getNodeName().equals("SPEC-ATTRIBUTES"))
			fromXml(e);
		if (e.getNodeName().equals("ATTRIBUTE-DEFINITION-STRING"))
			specAttributes.add(AttributeDefinitionString.fromElement(e));
		if (e.getNodeName().equals("ATTRIBUTE-DEFINITION-XHTML"))
			specAttributes.add(AttributeDefinitionXHTML.fromElement(e));
	}
	
}
