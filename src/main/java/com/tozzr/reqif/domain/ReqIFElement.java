package com.tozzr.reqif.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class ReqIFElement {

	private String name;
	private List<ReqIFElement> elements;
	private Map<String, String> attributes;
	private boolean selfClosing = false;
	
	protected ReqIFElement(final String name, final boolean selfClosing) {
		this(name);
		this.selfClosing = selfClosing;
	}
	
	protected ReqIFElement(final String name) {
		this.name = name;
		this.elements = new ArrayList<ReqIFElement>();
		this.attributes = new TreeMap<String, String>();
	}
	
	public String getName() {
		return name;
	}
	
	protected void setAttribute(String name, String value) {
		this.attributes.put(name, value);
	}
	
	public String toXml(int indent) {
		String identStr = getIndentStr(indent);
		String attrStr = "";
		for (String n : attributes.keySet())
			attrStr += String.format(" %s=\"%s\"", n, attributes.get(n));
		String elemStr = elementsToXml(indent);
		if (selfClosing)
			return String.format(
				"%s<%s%s/>\n",
				identStr,
				name,
				attrStr
			);
		else
			return String.format(
				"%s<%s%s>\n%s%s</%s>\n", 
				identStr, 
				name, 
				attrStr, 
				elemStr,
				identStr,
				name
			);
	}

	protected String getIndentStr(int indent) {
		String indentStr = "";
		for (int i=0; i < indent; i++)
			indentStr += " ";
		return indentStr;
	}
	
	protected String elementsToXml(int ident) {
		String elemStr = "";
		for (ReqIFElement e : elements)
			elemStr += e.toXml(ident+2);
		return elemStr;
	}

	public ReqIFElement fromXml(Element element) {
		NodeList children = element.getChildNodes();
		for (int i=0; i<children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				handleElement(e);
			}
		}
		return this;
	}
	
	abstract protected void handleElement(Element e);

}
