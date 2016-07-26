package com.tozzr.reqif;

class Header extends ReqIFElement {

	public Header() {
		super("THE-HEADER");
		addElement("reqIFHeader", new ReqIFHeader());
	}
	
	public ReqIFHeader getReqIFHeader() {
		return (ReqIFHeader) getElement("reqIFHeader");
	}

}