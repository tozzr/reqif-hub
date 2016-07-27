package com.tozzr.reqif;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ReqIFHeader extends ReqIFElement {

	public String comment = "";
	public Date creationTime = new Date();
	public String identifier = "";
	public String repositoryId = "";
	public String reqIFToolId = "";
	public String reqIFVersion = "";
	public String sourceToolId = "";
	public String title = "";
	
	public ReqIFHeader(String identifier) {
		super("REQ-IF-HEADER");
		this.identifier = identifier;
	}
	
	public String toXml(int ident) {
		return 
			"  <THE-HEADER>\n"
			  + "    <REQ-IF-HEADER IDENTIFIER=\"myId\">\n"
			  + "      <COMMENT>" + comment + "</COMMENT>\n"
			  + "      <CREATION-TIME>" + creationTime + "</CREATION-TIME>\n"
			  + "      <REQ-IF-TOOL-ID>" + reqIFToolId + "</REQ-IF-TOOL-ID>\n"
			  + "      <REQ-IF-VERSION>" + reqIFVersion + "</REQ-IF-VERSION>\n"
			  + "      <SOURCE-TOOL-ID>" + sourceToolId  + "</SOURCE-TOOL-ID>\n"
			  + "      <TITLE>" + title + "</TITLE>\n"
			  + "    </REQ-IF-HEADER>\n"
			  + "  </THE-HEADER>\n";
	}

	public ReqIFHeader fromXml(Element element) {
		element = (Element) element.getChildNodes().item(1);
		identifier = element.getAttribute("IDENTIFIER");
		NodeList children = element.getChildNodes();
		for (int i=0; i<children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				if (e.getNodeName() == "COMMENT")
					comment = e.getTextContent();
				if (e.getNodeName() == "CREATION-TIME") {
					try {
						creationTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(e.getTextContent());
					} catch (DOMException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				if (e.getNodeName() == "REQ-IF-TOOL-ID")
					reqIFToolId = e.getTextContent();
				if (e.getNodeName() == "REQ-IF-VERSION")
					reqIFVersion = e.getTextContent();
				if (e.getNodeName() == "SOURCE-TOOL-ID")
					sourceToolId = e.getTextContent();
				if (e.getNodeName() == "TITLE")
					title = e.getTextContent();
			}
		}
		return this;
	}

}