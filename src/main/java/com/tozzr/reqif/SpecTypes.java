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
	protected void handleElement(Element e) {
		if (e.getNodeName().equals("SPEC-OBJECT-TYPE"))
			types.add((SpecObjectType) new SpecObjectType().fromXml(e));
		if (e.getNodeName().equals("SPECIFICATION-TYPE"))
			types.add((SpecificationType) new SpecificationType().fromXml(e));
		if (e.getNodeName().equals("SPEC-RELATION-TYPE"))
			types.add((SpecRelationType) new SpecRelationType().fromXml(e));
	}
	
}
