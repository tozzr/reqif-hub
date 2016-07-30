package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class ReqIFElement {

	private String name;
	private String payload;
	private List<ReqIFElement> elements;
	private Map<String, String> attributes;
	
	protected ReqIFElement(final String name) {
		this(name, "");
	}
	
	protected ReqIFElement(final String name, final String payload) {
		this.name = name;
		this.payload = payload;
		this.elements = new ArrayList<ReqIFElement>();
		this.attributes = new TreeMap<String, String>();
	}
	
	public String getName() {
		return name;
	}
	
	protected void addElement(ReqIFElement element) {
		this.elements.add(element);
	}
	
	protected ReqIFElement getElement(int index) {
		return elements.get(index);
	}
	
	protected void addAttribute(String name, String value) {
		this.attributes.put(name, value);
	}
	
	public String toXml(int ident) {
		String identStr = getIndentStr(ident);
		String attrStr = "";
		for (String n : attributes.keySet())
			attrStr += String.format(" %s=\"%s\"", n, attributes.get(n));
		String elemStr = elementsToXml(ident);
		return String.format(
			"%s<%s%s>\n%s%s%s</%s>\n", 
			identStr, 
			name, 
			attrStr, 
			payload,
			elemStr,
			identStr,
			name
		);
	}

	protected String getIndentStr(int ident) {
		String identStr = "";
		for (int i=0; i < ident; i++)
			identStr += " ";
		return identStr;
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
