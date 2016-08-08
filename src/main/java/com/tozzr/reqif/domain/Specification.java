package com.tozzr.reqif.domain;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

public class Specification extends Identifiable {

	List<AttributeValue> values = new ArrayList<AttributeValue>();
	String ref = "";
	List<SpecHierarchy> children = new ArrayList<SpecHierarchy>();
	
	protected Specification() {
		super("SPECIFICATION");
	}

	public static Specification fromElement(Element e) {
		Specification s = new Specification();
		s.handleElement(e);
		return s;
	}

	@Override
	public String toXml(int indent) {
		String elemStr = "";
		for (AttributeValue v : values)
			elemStr += v.toXml(indent+4);
		String childrenStr = "";
		for (SpecHierarchy h : children) 
			childrenStr += h.toXml(indent+4);
		return String.format(
			"%s<SPECIFICATION IDENTIFIER=\"%s\" LAST-CHANGE=\"%s\" LONG-NAME=\"%s\">\n"
		  + "%s<VALUES>\n"
		  + "%s"
		  + "%s</VALUES>\n"
		  + "%s<TYPE>\n"
		  + "%s<SPECIFICATION-TYPE-REF>%s</SPECIFICATION-TYPE-REF>\n"
		  + "%s</TYPE>\n"
		  + "%s<CHILDREN>\n"
		  + "%s"
		  + "%s</CHILDREN>\n"
		  + "%s</SPECIFICATION>\n",
			getIndentStr(indent),
			identifier,
			lastChange,
			longName,
			getIndentStr(indent+2),
			elemStr,
			getIndentStr(indent+2),
			getIndentStr(indent+2),
			getIndentStr(indent+4),
			ref,
			getIndentStr(indent+2),
			getIndentStr(indent+2),
			childrenStr,
			getIndentStr(indent+2),
			getIndentStr(indent)
		);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPECIFICATION")) {
			super.handleElement(e);
			fromXml(e);
		}
		if (e.getNodeName().equals("VALUES"))
			fromXml(e);
		if (e.getNodeName().equals("ATTRIBUTE-VALUE-XHTML"))
			values.add(AttributeValueXHTML.fromElement(e));
		if (e.getNodeName().equals("ATTRIBUTE-VALUE-STRING"))
			values.add(AttributeValueString.fromElement(e));
		if (e.getNodeName().equals("TYPE"))
			fromXml(e);
		if (e.getNodeName().equals("SPECIFICATION-TYPE-REF"))
			ref = e.getTextContent();
		if (e.getNodeName().equals("CHILDREN"))
			fromXml(e);
		if (e.getNodeName().equals("SPEC-HIERARCHY"))
			children.add(SpecHierarchy.fromElement(e));
	}
}
