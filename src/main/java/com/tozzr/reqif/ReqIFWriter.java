package com.tozzr.reqif;

class ReqIFWriter {
	
	public String write(ReqIF reqIF) {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + reqIF.toXml();
	}
}