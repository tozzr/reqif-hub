package com.tozzr.reqif;

class Comment extends ReqIFElement {

	public Comment() {
		this("");
	}
	
	public Comment(String text) {
		super("COMMENT", text);
	}

}
