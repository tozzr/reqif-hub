package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReqIFTest {

	@Test
	public void testToXml() throws Exception {
		ReqIF reqIF = new ReqIF("myId");
		String expected = 
			"<REQ-IF xmlns=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\" "
		  + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
		  + "xsi:schemaLocation=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\" "
		  + "xml:lang=\"en\">\n"
		  + reqIF.theHeader.toXml(2)
		  + reqIF.coreContent.toXml(2)
		  + reqIF.toolExtension.toXml(2)
		  + "</REQ-IF>";
		assertEquals(expected, reqIF.toXml(0));
	}
	
	@Test
	public void hasHeader() throws Exception {
		assertEquals(new ReqIFHeader("myId").toXml(1), new ReqIF("myId").theHeader.toXml(1));
	}
	
	@Test
	public void hasContent() throws Exception {
		assertThat(new ReqIF("myId").coreContent.toXml(1), equalTo(new ReqIFContent().toXml(1)));
	}
}
