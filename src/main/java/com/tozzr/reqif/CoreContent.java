package com.tozzr.reqif;

class CoreContent extends ReqIFElement {

	protected CoreContent() {
		super("CORE-CONTENT");
		addElement(new ReqIFContent());
	}

}
