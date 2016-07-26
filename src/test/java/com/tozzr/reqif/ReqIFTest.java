package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReqIFTest {

	@Test
	public void testToString() throws Exception {
		ReqIF reqIF = new ReqIF();
		String expected = 
			"<REQ-IF xmlns=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\"\n\t"
		  + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n\t"
		  + "xsi:schemaLocation=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\"\n\t"
		  + "xml:lang=\"en\">\n\t"
		  + reqIF.getHeader().toString()
		  + reqIF.getCoreContent().toString()
		  + "</REQ-IF>";
		assertThat(reqIF.toString(), equalTo(expected));
	}
	
	@Test
	public void hasHeader() throws Exception {
		assertThat(new ReqIF().getHeader().toString(), equalTo(new Header().toString()));
	}
	
	@Test
	public void hasCoreContent() throws Exception {
		assertThat(new ReqIF().getCoreContent().toString(), equalTo(new CoreContent().toString()));
	}
}
