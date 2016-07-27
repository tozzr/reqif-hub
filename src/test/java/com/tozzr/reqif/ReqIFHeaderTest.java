package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReqIFHeaderTest {

	@Test
	public void testToString() throws Exception {
		ReqIFHeader reqIFHeader = new ReqIFHeader("myId");
		String expected = 
			"  <THE-HEADER>\n"
		  + "    <REQ-IF-HEADER IDENTIFIER=\"myId\">\n"
		  + "      <COMMENT>" + reqIFHeader.comment + "</COMMENT>\n"
		  + "      <CREATION-TIME>" + reqIFHeader.creationTime + "</CREATION-TIME>\n"
		  + "      <REQ-IF-TOOL-ID>" + reqIFHeader.reqIFToolId + "</REQ-IF-TOOL-ID>\n"
		  + "      <REQ-IF-VERSION>" + reqIFHeader.reqIFVersion + "</REQ-IF-VERSION>\n"
		  + "      <SOURCE-TOOL-ID>" + reqIFHeader.sourceToolId  + "</SOURCE-TOOL-ID>\n"
		  + "      <TITLE>" + reqIFHeader.title + "</TITLE>\n"
		  + "    </REQ-IF-HEADER>\n"
		  + "  </THE-HEADER>\n";
		assertThat(reqIFHeader.toXml(2), equalTo(expected));
	}
	
}
