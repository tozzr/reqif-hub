package com.tozzr.reqif;

class ReqIF {

	private Header header;
	private CoreContent coreContent;
	
	public ReqIF() {
		header = new Header();
		coreContent = new CoreContent();
	}
	
	public Header getHeader() {
		return header;
	}
	
	public CoreContent getCoreContent() {
		return coreContent;
	}
	
}
