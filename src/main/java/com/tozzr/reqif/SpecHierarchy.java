package com.tozzr.reqif;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SpecHierarchy extends Identifiable {

	String ref = "";
	List<SpecHierarchy> children = new ArrayList<SpecHierarchy>();
	
	protected SpecHierarchy() {
		super("SPEC-HIERARCHY");
	}

	public static SpecHierarchy fromElement(Element e) {
		SpecHierarchy h = new SpecHierarchy();
		h.handleElement(e);
		return h;
	}
	
	@Override
	public String toXml(int indent) {
		return String.format(
			"%s<SPEC-HIERARCHY IDENTIFIER=\"%s\" LAST-CHANGE=\"%s\">\n"
		  + "%s<OBJECT>\n"
		  + "%s<SPEC-OBJECT-REF>%s</SPEC-OBJECT-REF>\n"
		  + "%s</OBJECT>\n"
		  + "%s"
		  + "%s</SPEC-HIERARCHY>\n", 
			getIndentStr(indent),
			identifier,
			lastChange,
			getIndentStr(indent+2),
			getIndentStr(indent+4),
			ref,
			getIndentStr(indent+2),
			childrenToXml(indent),
			getIndentStr(indent)
		);
	}

	private String childrenToXml(int indent) {
		if (children.size() <= 0) return "";
		String elemStr = "";
		for (SpecHierarchy h : children)
			elemStr += h.toXml(indent+4);
		return String.format(
			"%s<CHILDREN>\n"
		  + "%s"
		  + "%s</CHILDREN>\n",
		  getIndentStr(indent+2),
		  elemStr,
		  getIndentStr(indent+2)
		);
	}
	
	@Override
	protected void handleElement(Element e) {
		if (e.getNodeName().equals(getName())) {
			if (ref.equals("")) {
				super.handleElement(e);
				fromXml(e);
			} else {
				children.add(SpecHierarchy.fromElement(e));
			}			
		}
		if (e.getNodeName().equals("OBJECT"))
			fromXml(e);
		if (e.getNodeName().equals("SPEC-OBJECT-REF"))
			ref = e.getTextContent();
		if (e.getNodeName().equals("CHILDREN")) {
			NodeList nodes = e.getChildNodes();
			for (int i=0; i<nodes.getLength(); i++) {
				Node n = nodes.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					children.add(SpecHierarchy.fromElement((Element) n));
				}
			}
		}
	}
}
