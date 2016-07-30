package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

class Specifications extends ReqIFElement {

	List<Specification> specifications = new ArrayList<Specification>();
	
	protected Specifications() {
		super("SPECIFICATIONS");
	}

	public Specification get(int index) {
		return specifications.get(index);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPECIFICATION"))
			specifications.add((Specification) new Specification().fromXml(e));
	}
	
}
