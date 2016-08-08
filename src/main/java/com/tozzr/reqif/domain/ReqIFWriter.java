package com.tozzr.reqif.domain;

class ReqIFWriter {
	
	public String write(ReqIF reqIF) {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + reqIF.toXml();
	}
}