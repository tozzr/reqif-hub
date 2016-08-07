package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

class SpecRelations extends ReqIFElement {

	List<SpecRelation> relations = new ArrayList<SpecRelation>();
	
	protected SpecRelations() {
		super("SPEC-RELATIONS");
	}

	public SpecRelation get(int index) {
		return relations.get(index);
	}
	
	@Override
	public String toXml(int indent) {
		String elemStr = "";
		for (SpecRelation r : relations)
			elemStr += r.toXml(indent+2);
		return String.format(
			"%s<SPEC-RELATIONS>\n"
		  + "%s"
		  + "%s</SPEC-RELATIONS>\n",
			getIndentStr(indent),
			elemStr,
			getIndentStr(indent)
		);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPEC-RELATION"))
			relations.add((SpecRelation) new SpecRelation().fromXml(e));
	}
	
}
