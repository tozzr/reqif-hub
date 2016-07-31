package com.tozzr.reqif;

public abstract class AttributeDefinition extends Identifiable {

	protected AttributeDefinition(String name) {
		super("ATTRIBUTE-DEFINITION-" + name);
	}
	
}
