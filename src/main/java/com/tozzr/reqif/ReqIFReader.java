package com.tozzr.reqif;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class ReqIFReader {
	
	public ReqIF read(String filename) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		File file = new File(filename);
		Document doc = builder.parse(file);
		doc.getDocumentElement().normalize();
		return (ReqIF) new ReqIF("").fromXml(doc.getDocumentElement());
	}

	public void parse(String filename) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		File file = new File(filename);
		Document doc = builder.parse(file);
		doc.getDocumentElement().normalize();
		parse(doc.getDocumentElement());
	}

	private void parse(Element element) {
		String str = element.getNodeName();
		str += ", ";
		NamedNodeMap attr = element.getAttributes();
		for (int i=0; i<attr.getLength(); i++)
			str += attr.item(i).getNodeName() + "=" + attr.item(i).getNodeValue();
		System.out.println(str);
		NodeList children = element.getChildNodes();
		for (int i=0; i<children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				parse((Element) node);
			}
		}
	}
	
}