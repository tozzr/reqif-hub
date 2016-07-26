package com.tozzr.reqif;

public abstract class SimplePayloadElement {

	private String name;
	private String payload;
	
	protected SimplePayloadElement(final String name, final String payload) {
		this.name = name;
		this.payload = payload;
	}
	
	@Override
	public String toString() {
		return String.format("<%s>%s</%s>", name, payload, name);
	}
}
