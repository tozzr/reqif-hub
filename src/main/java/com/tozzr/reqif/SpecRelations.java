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
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPEC-RELATION"))
			relations.add((SpecRelation) new SpecRelation().fromXml(e));
	}
	
}
