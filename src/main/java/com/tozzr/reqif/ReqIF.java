package com.tozzr.reqif;

class ReqIF extends ReqIFElement {

	public ReqIF() {
		super("REQ-IF", "");
		addElement("header", new Header());
		addElement("coreContent", new CoreContent());
	}
	
	public Header getHeader() {
		return (Header) getElement("header");
	}
	
	public CoreContent getCoreContent() {
		return (CoreContent) getElement("coreContent");
	}

	@Override
	public String toString() {
		return 
		    "<REQ-IF xmlns=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\"\n\t"
		  + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n\t"
		  + "xsi:schemaLocation=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\"\n\t"
		  + "xml:lang=\"en\">\n\t" + getHeader() + getCoreContent() + "</REQ-IF>";
	}
	
}
