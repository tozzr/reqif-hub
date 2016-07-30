package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

public class ReqIFToolExtension extends ReqIFElement {

	List<ToolExtension> extensions = new ArrayList<ToolExtension>();
	
	protected ReqIFToolExtension() {
		super("TE");
	}

	public ToolExtension get(int index) {
		return extensions.get(index);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("REQ-IF-TOOL-EXTENSION"))
			extensions.add((ToolExtension) new ToolExtension().fromXml(e));
	}

}
