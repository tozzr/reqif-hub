package com.tozzr.reqif;

class Header extends ReqIFElement {

	public Header(String identifier) {
		super("THE-HEADER");
		addElement(new ReqIFHeader(identifier));
	}
	
	public ReqIFHeader getReqIFHeader() {
		return (ReqIFHeader) getElement(0);
	}

}