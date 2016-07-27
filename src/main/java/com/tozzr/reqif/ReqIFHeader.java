package com.tozzr.reqif;

import java.util.Date;

class ReqIFHeader extends ReqIFElement {

	private String comment;
	private Date creationTime;
	private String identifier;
	private String title;
	
	public ReqIFHeader(String identifier) {
		super("REQ-IF-HEADER");
		comment = "";
		creationTime = new Date();
		this.identifier = identifier;
		title = "";
	}
	
	@Override
	public String toString() {
		return 
			"<REQ-IF-HEADER IDENTIFIER=\"" + identifier + "\">"
		  + "<COMMENT>" + comment + "</COMMENT>"
		  + "<CREATION-TIME>" + creationTime + "</CREATION-TIME>"
		  + "<TITLE>" + title + "</TITLE>"
		  + "</REQ-IF-HEADER>";
	}

	public String getComment() {
		return comment;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public String getTitle() {
		return title;
	}
}