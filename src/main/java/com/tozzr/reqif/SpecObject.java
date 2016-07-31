package com.tozzr.reqif;

import org.w3c.dom.Element;

public class SpecObject extends Identifiable {

	protected SpecObject() {
		super("SPEC-OBJECT");
	}

	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<SPEC-OBJECT IDENTIFIER=\"%s\" LAST-CHANGE=\"%s\">\n"
		  + "%s</SPEC-OBJECT>\n",
			getIndentStr(indent),
			identifier,
			lastChange,
			getIndentStr(indent)
		);
	}
	
	public static SpecObject fromElement(Element e) {
		SpecObject s = new SpecObject();
		s.handleElement(e);
		return s;
	}

}
