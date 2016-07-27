package com.tozzr.reqif;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReqIFWriterTest {

	@Test
	public void wrappRootElementInXml() {
		ReqIFWriter writer = new ReqIFWriter();
		ReqIF reqIF = new ReqIF("myId");
		String expected = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
		  + reqIF.toXml();
		assertEquals(expected, writer.write(reqIF));
//		System.out.print(writer.write(reqIF));
	}
}
