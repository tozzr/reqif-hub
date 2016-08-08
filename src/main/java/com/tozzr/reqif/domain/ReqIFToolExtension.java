package com.tozzr.reqif.domain;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

public class ReqIFToolExtension extends ReqIFElement {

	List<ToolExtension> extensions = new ArrayList<ToolExtension>();
	
	protected ReqIFToolExtension() {
		super("TOOL-EXTENSIONS");
	}

	public ToolExtension get(int index) {
		return extensions.get(index);
	}
	
	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<TOOL-EXTENSIONS>\n"
		  + "%s<REQ-IF-TOOL-EXTENSION>\n"
		  + "%s</REQ-IF-TOOL-EXTENSION>\n"
		  + "%s</TOOL-EXTENSIONS>\n", 
		  getIndentStr(indent),
		  getIndentStr(indent+2),
		  getIndentStr(indent+2),
		  getIndentStr(indent)
		);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("REQ-IF-TOOL-EXTENSION"))
			extensions.add((ToolExtension) new ToolExtension().fromXml(e));
	}

}
