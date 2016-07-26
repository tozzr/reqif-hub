package com.tozzr.reqif;

class ReqIFHeader {

	private Comment comment;
	private Title title;
	
	public ReqIFHeader() {
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