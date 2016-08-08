package com.tozzr.reqif.domain;

public abstract class AttributeValue extends ReqIFElement {

	public String ref = "";
	public String value = "";

	protected AttributeValue(String name) {
		super("ATTRIBUTE-VALUE-");
	}

}
