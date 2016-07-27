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
	
	@Override
	public String toXml(int ident) {
		String identStr = "";
		for (int i=0; i<ident; i++)
			identStr += " ";
		return String.format("%s<CORE-CONTENT>\n%s%s</CORE-CONTENT>\n", identStr, super.toXml(ident+2), identStr);
	}
}
