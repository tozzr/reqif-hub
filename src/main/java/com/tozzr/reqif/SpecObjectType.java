package com.tozzr.reqif;

import org.w3c.dom.Element;

public class SpecObjectType extends SpecType {

	protected SpecObjectType() {
		super("SPEC-OBJECT-TYPE");
	}

	static SpecType fromElement(Element e) {
		SpecObjectType t = new SpecObjectType();
		t.handleElement(e);
		return t;
	}
	
}
