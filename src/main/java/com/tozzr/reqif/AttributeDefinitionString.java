package com.tozzr.reqif;

import org.w3c.dom.Element;

public class AttributeDefinitionString extends AttributeDefinition {

	protected AttributeDefinitionString() {
		super("STRING");
	}

	public static AttributeDefinition fromElement(Element e) {
		AttributeDefinitionString s = new AttributeDefinitionString();
		s.handleElement(e);
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
		  "foo",
		  getIndentStr(indent+2),
		  getIndentStr(indent));
	}

}
