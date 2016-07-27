package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReqIFHeaderTest {

	@Test
	public void testToString() throws Exception {
		ReqIFHeader reqIFHeader = new ReqIFHeader("myId");
		String expected = 
			"<REQ-IF-HEADER IDENTIFIER=\"myId\">"
		  + "<COMMENT>" + reqIFHeader.getComment() + "</COMMENT>"
		  + "<CREATION-TIME>" + reqIFHeader.getCreationTime() + "</CREATION-TIME>"
		  + "<TITLE>" + reqIFHeader.getTitle() + "</TITLE>"
		  + "</REQ-IF-HEADER>";
		assertThat(reqIFHeader.toString(), equalTo(expected));
	}
	
}
