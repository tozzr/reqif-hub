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
	public String toXml(int indent) {
		String elemStr = "";
		for (SpecObject o : objects)
			elemStr += o.toXml(indent+2);
		return String.format(
			"%s<SPEC-OBJECTS>\n"
		  + "%s"
		  + "%s</SPEC-OBJECTS>\n",
		  	getIndentStr(indent),
		  	elemStr,
		  	getIndentStr(indent)
		);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPEC-OBJECT"))
			objects.add(SpecObject.fromElement(e));
	}
	
}