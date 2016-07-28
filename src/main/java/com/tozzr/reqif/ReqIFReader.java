package com.tozzr.reqif;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
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
	
}