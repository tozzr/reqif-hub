package com.tozzr.reqif.domain;

import org.w3c.dom.Element;

public class AttributeDefinitionString extends AttributeDefinition {

	public String ref;
	
	protected AttributeDefinitionString() {
		super("STRING");
	}

	public static AttributeDefinition fromElement(Element e) {
		AttributeDefinitionString s = new AttributeDefinitionString();
		s.handleElement(e);
		s.ref = e.getTextContent().trim();
		return s;
	}

	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<ATTRIBUTE-DEFINITION-STRING IDENTIFIER=\"%s\" LAST-CHANGE=\"%s\" LONG-NAME=\"%s\">\n"
		  + "%s<TYPE>\n"
		  + "%s<DATATYPE-DEFINITION-STRING-REF>%s</DATATYPE-DEFINITION-STRING-REF>\n"
		  + "%s</TYPE>\n"
		  + "%s</ATTRIBUTE-DEFINITION-STRING>\n", 
		  getIndentStr(indent),
		  identifier,
		  lastChange,
		  longName,
		  getIndentStr(indent+2),
		  getIndentStr(indent+4),
		  ref,
		  getIndentStr(indent+2),
		  getIndentStr(indent));
	}

}
