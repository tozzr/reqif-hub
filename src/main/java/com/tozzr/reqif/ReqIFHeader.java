package com.tozzr.reqif;

class ReqIFHeader extends ReqIFElement {

	private Comment comment;
	private Title title;
	
	public ReqIFHeader() {
		super("REQ-IF-HEADER");
		comment = new Comment();
		title = new Title();
	}
	
	@Override
	public String toString() {
		return "<REQ-IF-HEADER>" + comment + title + "</REQ-IF-HEADER>";
	}

	public Comment getComment() {
		return comment;
	}

	public Title getTitle() {
		return title;
	}
}