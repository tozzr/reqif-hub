package com.tozzr.reqif.domain;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AttributeValueXHTML extends AttributeValue {

	protected AttributeValueXHTML() {
		super("XHTML");
	}

	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<ATTRIBUTE-VALUE-XHTML>\n"
		  + "%s<DEFINITION>\n"
		  + "%s<ATTRIBUTE-DEFINITION-XHTML-REF>%s</ATTRIBUTE-DEFINITION-XHTML-REF>\n"
		  + "%s</DEFINITION>\n"
		  + "%s<THE-VALUE>\n"
		  + "%s%s\n"
		  + "%s</THE-VALUE>\n"
		  + "%s</ATTRIBUTE-VALUE-XHTML>\n",
		  getIndentStr(indent),
		  getIndentStr(indent+2),
		  getIndentStr(indent+4),
		  ref,
		  getIndentStr(indent+2),
		  getIndentStr(indent+2),
		  getIndentStr(indent+4),
		  value,
		  getIndentStr(indent+2),
		  getIndentStr(indent)
		);
	}
	
	public static AttributeValue fromElement(Element e) {
		AttributeValue v = new AttributeValueXHTML();
		v.handleElement(e);
		return v;
	}

	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("ATTRIBUTE-DEFINITION-XHTML-REF"))
			ref = e.getTextContent();
		if (e.getNodeName().equals("THE-VALUE"))
			value = parseXHTML(e);
		else
			fromXml(e);
	}
	
	private String parseXHTML(Node e) {
		String xhtml = "";
		NodeList children = e.getChildNodes();
		for (int i=0; i<children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				String name = node.getNodeName();
				String attrStr = "";
				if (node.hasAttributes()) {
					NamedNodeMap attrs = node.getAttributes();
					for (int j=0; j<attrs.getLength(); j++) {
						Node a = attrs.item(j);
						attrStr += String.format(" %s=\"%s\"", a.getNodeName(), a.getNodeValue()); 
					}
				}
				xhtml += String.format("<%s%s>%s</%s>", name, attrStr, parseXHTML(node), name);
			}
		}
		return xhtml.equals("") ? e.getTextContent() : xhtml;
	}

}
