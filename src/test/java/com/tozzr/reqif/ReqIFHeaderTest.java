package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReqIFHeaderTest {

	@Test
	public void testToString() throws Exception {
		ReqIFHeader reqIFHeader = new ReqIFHeader();
		String expected = 
			"<REQ-IF-HEADER>"
		  + reqIFHeader.getComment().toString()
		  + reqIFHeader.getTitle().toString()
		  + "</REQ-IF-HEADER>";
		assertThat(reqIFHeader.toString(), equalTo(expected));
	}
	
	@Test
	public void hasComment() throws Exception {
		assertThat(new ReqIFHeader().getComment().toString(), equalTo(new Comment().toString()));
	}
	
	@Test
	public void hasTitle() throws Exception {
		assertThat(new ReqIFHeader().getTitle().toString(), equalTo(new Title().toString()));
	}
}
