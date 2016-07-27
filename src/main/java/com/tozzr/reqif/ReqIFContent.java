package com.tozzr.reqif;

class ReqIFContent extends ReqIFElement {

	protected ReqIFContent() {
		super("REQ-IF-CONTENT");
		addElement(new DataTypes());
		addElement(new SpecTypes());
		addElement(new SpecObjects());
		addElement(new SpecRelations());
		addElement(new Specifications());
	}
	
}
