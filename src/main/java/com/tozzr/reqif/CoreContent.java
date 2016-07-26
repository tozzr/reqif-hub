package com.tozzr.reqif;

class CoreContent extends ReqIFElement {

	protected CoreContent() {
		super("CORE-CONTENT");
		addElement("reqIFContent", new ReqIFContent());
	}

}
