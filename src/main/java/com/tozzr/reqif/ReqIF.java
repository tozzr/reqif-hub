package com.tozzr.reqif;

class ReqIF extends ReqIFElement {

	public ReqIF(String identifier) {
		super("REQ-IF");
		addElement(new Header(identifier));
		addElement(new CoreContent());
	}
	
	public Header getHeader() {
		return (Header) getElement(0);
	}
	
	public CoreContent getCoreContent() {
		return (CoreContent) getElement(1);
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
