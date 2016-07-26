package com.tozzr.reqif;

class Header {

	private ReqIFHeader reqIFHeader; 
	
	public Header() {
		reqIFHeader = new ReqIFHeader();
	}
	
	public ReqIFHeader getReqIFHeader() {
		return reqIFHeader;
	}

	@Override
	public String toString() {
		return "<THE-HEADER>" + reqIFHeader.toString() + "</THE-HEADER>";
	}
	
}