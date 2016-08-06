package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

public class SpecObject extends Identifiable {

	List<AttributeValue> values = new ArrayList<AttributeValue>();
	String ref = "";
	
	protected SpecObject() {
		super("SPEC-OBJECT");
	}

	@Override
	public String toXml(int indent) {
		String elemStr = "";
		for (AttributeValue v : values)
			elemStr += v.toXml(indent+4);
		return String.format(
			"%s<SPEC-OBJECT IDENTIFIER=\"%s\" LAST-CHANGE=\"%s\">\n"
		  + "%s<VALUES>\n"
		  + "%s"
		  + "%s</VALUES>\n"
		  + "%s<TYPE>\n"
		  + "%s<SPEC-OBJECT-TYPE-REF>%s</SPEC-OBJECT-TYPE-REF>\n"
		  + "%s</TYPE>\n"
		  + "%s</SPEC-OBJECT>\n",
			getIndentStr(indent),
			identifier,
			lastChange,
			getIndentStr(indent+2),
			elemStr,
			getIndentStr(indent+2),
			getIndentStr(indent+2),
			getIndentStr(indent+4),
			ref,
			getIndentStr(indent+2),
			getIndentStr(indent)
		);
	}
	
	public static SpecObject fromElement(Element e) {
		SpecObject s = new SpecObject();
		s.handleElement(e);
		return s;
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPEC-OBJECT")) {
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
		if (e.getNodeName().equals("SPEC-OBJECT-TYPE-REF"))
			ref = e.getTextContent();
	}

}
