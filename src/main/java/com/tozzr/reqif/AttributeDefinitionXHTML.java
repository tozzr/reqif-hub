package com.tozzr.reqif;

import org.w3c.dom.Element;

public class AttributeDefinitionXHTML extends AttributeDefinition {

	public String ref;
	
	protected AttributeDefinitionXHTML() {
		super("XHTML");
	}

	public static AttributeDefinition fromElement(Element e) {
		AttributeDefinitionXHTML s = new AttributeDefinitionXHTML();
		s.handleElement(e);
		s.ref = e.getTextContent().trim();
		return s;
	}

	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<ATTRIBUTE-DEFINITION-XHTML IDENTIFIER=\"%s\" LAST-CHANGE=\"%s\" LONG-NAME=\"%s\">\n"
		  + "%s<TYPE>\n"
		  + "%s<DATATYPE-DEFINITION-XHTML-REF>%s</DATATYPE-DEFINITION-XHTML-REF>\n"
		  + "%s</TYPE>\n"
		  + "%s</ATTRIBUTE-DEFINITION-XHTML>\n", 
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
