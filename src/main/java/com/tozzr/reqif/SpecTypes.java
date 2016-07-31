package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

class SpecTypes extends ReqIFElement {

	private List<SpecType> types = new ArrayList<SpecType>();
	
	protected SpecTypes() {
		super("SPEC-TYPES");
	}

	public SpecType get(int index) {
		return types.get(index);
	}

	@Override
	public String toXml(int indent) {
		String elemStr = "";
		for (SpecType t : types)
			elemStr += t.toXml(indent+2);
		return String.format(
			"%s<SPEC-TYPES>\n"
		  + "%s"
		  + "%s</SPEC-TYPES>\n", 
		  getIndentStr(indent), 
		  elemStr, 
		  getIndentStr(indent));
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPEC-OBJECT-TYPE"))
			types.add(SpecObjectType.fromElement(e));
		if (e.getNodeName().equals("SPECIFICATION-TYPE"))
			types.add((SpecificationType) new SpecificationType().fromXml(e));
		if (e.getNodeName().equals("SPEC-RELATION-TYPE"))
			types.add((SpecRelationType) new SpecRelationType().fromXml(e));
	}
	
}
