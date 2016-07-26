package com.tozzr.reqif;

import java.util.HashMap;
import java.util.Map;

public abstract class ReqIFElement {

	private String name;
	private String payload;
	private Map<String, ReqIFElement> elements;
	
	protected ReqIFElement(final String name, final String payload) {
		this.name = name;
		this.payload = payload;
		this.elements = new HashMap<String, ReqIFElement>();
	}
	
	protected void addElement(String key, ReqIFElement element) {
		this.elements.put(key, element);
	}
	
	protected ReqIFElement getElement(String key) {
		return elements.get(key);
	}
	
	@Override
	public String toString() {
		String elemStr = "";
		for (ReqIFElement e : elements.values())
			elemStr += e;
		return String.format("<%s>%s%s</%s>", name, payload, elemStr, name);
	}
}
