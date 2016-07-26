package com.tozzr.reqif;

class Comment extends SimplePayloadElement {

	public Comment() {
		this("");
	}
	
	public Comment(String text) {
		super("COMMENT", text);
	}

}
