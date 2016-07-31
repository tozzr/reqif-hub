package com.tozzr.reqif;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	
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
	
	protected void addAttribute(String name, String value) {
		this.attributes.put(name, value);
	}
	
	public String toXml(int indent) {
		String identStr = getIndentStr(indent);
		String attrStr = "";
		for (String n : attributes.keySet())
			attrStr += String.format(" %s=\"%s\"", n, attributes.get(n));
		String elemStr = elementsToXml(indent);
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

	public static String format(Date date) {
		return sdf.format(date);
	}
	
	public static Date parse(String dateStr) throws ParseException {
		return sdf.parse(dateStr);
	}
	
}
