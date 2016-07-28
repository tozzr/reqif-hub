package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

class SpecObjects extends ReqIFElement {

	List<SpecObject> objects = new ArrayList<SpecObject>();
	
	protected SpecObjects() {
		super("SPEC-OBJECTS");
	}

	public SpecObject get(int index) {
		return objects.get(index);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPEC-OBJECT"))
			objects.add((SpecObject) new SpecObject().fromXml(e));
	}
	
}