package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReqIFWriterTest {

	@Test
	public void wrappRootElementInXml() {
		ReqIFWriter writer = new ReqIFWriter();
		ReqIF reqIF = new ReqIF();
		String expected = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
		  + reqIF.toString();
		assertThat(writer.write(reqIF), equalTo(expected));
	}
}
