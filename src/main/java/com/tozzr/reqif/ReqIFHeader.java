package com.tozzr.reqif;

import java.util.Date;

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

}