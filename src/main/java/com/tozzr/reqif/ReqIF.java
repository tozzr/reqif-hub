package com.tozzr.reqif;

import org.w3c.dom.Element;

class ReqIF extends ReqIFElement {

	public String lang;
	public ReqIFHeader theHeader;
	public ReqIFContent coreContent;
	public ReqIFToolExtension toolExtension;
	
	public ReqIF(String identifier) {
		super("REQ-IF");
		theHeader = new ReqIFHeader(identifier);
		coreContent = new ReqIFContent();
		toolExtension = new ReqIFToolExtension();
	}
	

	public String toXml() {
		return toXml(0);
	}
	
	@Override
	public String toXml(int ident) {
		return 
		    "<REQ-IF xmlns=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\" "
		  + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
		  + "xsi:schemaLocation=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\" "
		  + "xml:lang=\"en\">\n"
		  + theHeader.toXml(2)
		  + coreContent.toXml(2)
		  + toolExtension.toXml(2)
		  + "</REQ-IF>";
	}

	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("THE-HEADER"))      theHeader.fromXml(e);
		if (e.getNodeName().equals("CORE-CONTENT"))    coreContent.fromXml(e);
		if (e.getNodeName().equals("TOOL-EXTENSIONS")) toolExtension.fromXml(e);
	}
	
}
