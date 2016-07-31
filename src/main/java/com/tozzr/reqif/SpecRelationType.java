package com.tozzr.reqif;

import org.w3c.dom.Element;

public class SpecRelationType extends SpecType {

	protected SpecRelationType() {
		super("SPEC-RELATION-TYPE");
	}

	static SpecRelationType fromElement(Element e) {
		SpecRelationType t = new SpecRelationType();
		t.handleElement(e);
		return t;
	}

}
