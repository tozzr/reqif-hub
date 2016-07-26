package com.tozzr.reqif;

class Header {

	private ReqIFHeader reqIFHeader; 
	
	public Header() {
		reqIFHeader = new ReqIFHeader();
	}
	
	@Override
	public String toString() {
		return "<THE-HEADER></THE-HEADER>";
	}

	public ReqIFHeader getReqIFHeader() {
		return reqIFHeader;
	}
	
}