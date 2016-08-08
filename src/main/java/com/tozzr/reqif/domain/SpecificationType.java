package com.tozzr.reqif.domain;

import org.w3c.dom.Element;

public class SpecificationType extends SpecType {

	protected SpecificationType() {
		super("SPECIFICATION-TYPE");
	}

	static SpecificationType fromElement(Element e) {
		SpecificationType t = new SpecificationType();
		t.handleElement(e);
		return t;
	}

}
