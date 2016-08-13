package com.tozzr.reqif.domain;

import org.w3c.dom.Element;

class ReqIFHeader extends ReqIFElement {

	public String comment = "";
	public String creationTime = "";
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
			  + "    <REQ-IF-HEADER IDENTIFIER=\"" + identifier + "\">\n"
			  + "      <COMMENT>" + comment + "</COMMENT>\n"
			  + "      <CREATION-TIME>" + creationTime + "</CREATION-TIME>\n"
			  + "      <REQ-IF-TOOL-ID>" + reqIFToolId + "</REQ-IF-TOOL-ID>\n"
			  + "      <REQ-IF-VERSION>" + reqIFVersion + "</REQ-IF-VERSION>\n"
			  + "      <SOURCE-TOOL-ID>" + sourceToolId  + "</SOURCE-TOOL-ID>\n"
			  + "      <TITLE>" + title + "</TITLE>\n"
			  + "    </REQ-IF-HEADER>\n"
			  + "  </THE-HEADER>\n";
	}

	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName() == "REQ-IF-HEADER") {
			identifier = e.getAttribute("IDENTIFIER");
			fromXml(e);
		}
		if (e.getNodeName() == "COMMENT")
			comment = e.getTextContent();
		if (e.getNodeName() == "CREATION-TIME")
			creationTime = e.getTextContent();
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
