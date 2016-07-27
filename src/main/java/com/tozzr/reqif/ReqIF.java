package com.tozzr.reqif;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ReqIF extends ReqIFElement {

	public String lang;
	
	public ReqIF(String identifier) {
		super("REQ-IF");
		addElement(new ReqIFHeader(identifier));
		addElement(new ReqIFContent());
	}
	
	public ReqIFHeader getHeader() {
		return (ReqIFHeader) getElement(0);
	}
	
	public ReqIFContent getContent() {
		return (ReqIFContent) getElement(1);
	}

	public String toXml() {
		return toXml(0);
	}
	
	@Override
	public String toXml(int ident) {
		return 
		    "<REQ-IF xmlns=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\" "
		  + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
		  + "xsi:schemaLocation=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\" "
		  + "xml:lang=\"en\">\n" + getHeader().toXml(2) + getContent().toXml(2) + "</REQ-IF>";
	}

	public ReqIF fromXml(Element element) {
		NodeList children = element.getChildNodes();
		Node node = children.item(1);
		if (node.getNodeType() == Node.ELEMENT_NODE)
			getHeader().fromXml((Element) node);
		return this;
	}
	
}
