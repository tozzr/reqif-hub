package com.tozzr.reqif;

class Title extends SimplePayloadElement {
	
	public Title() {
		this("");
	}
	
	public Title(String title) {
		super("TITLE", title);
	}

}
