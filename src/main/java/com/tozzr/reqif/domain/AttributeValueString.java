package com.tozzr.reqif.domain;

import org.w3c.dom.Element;

public class AttributeValueString extends AttributeValue {

	protected AttributeValueString() {
		super("STRING");
	}

	public static AttributeValue fromElement(Element e) {
		AttributeValueString v = new AttributeValueString();
		v.handleElement(e);
		return v;
	}
	
	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<ATTRIBUTE-VALUE-STRING THE-VALUE=\"%s\">\n"
		  + "%s<DEFINITION>\n"
		  + "%s<ATTRIBUTE-DEFINITION-STRING-REF>%s</ATTRIBUTE-DEFINITION-STRING-REF>\n"
		  + "%s</DEFINITION>\n"
		  + "%s</ATTRIBUTE-VALUE-STRING>\n",
		  getIndentStr(indent),
		  value,
		  getIndentStr(indent+2),
		  getIndentStr(indent+4),
		  ref,
		  getIndentStr(indent+2),
		  getIndentStr(indent)
		);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("ATTRIBUTE-VALUE-STRING"))
			value = e.getAttribute("THE-VALUE");
		if (e.getNodeName().equals("ATTRIBUTE-DEFINITION-STRING-REF"))
			ref = e.getTextContent();
		else
			fromXml(e);
	}
	
}
