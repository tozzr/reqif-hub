package com.tozzr.reqif;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReqIFContentTest {

	@Test
	public void testToXml() throws Exception {
		String expected = 
			"<CORE-CONTENT>\n"
		  + "  <REQ-IF-CONTENT>\n" 
		  + new DataTypes().toXml(4)
		  + new SpecTypes().toXml(4)
		  + new SpecObjects().toXml(4)
		  + new SpecRelations().toXml(4)
		  + new Specifications().toXml(4)
		  + "  </REQ-IF-CONTENT>\n"
		  + "</CORE-CONTENT>\n";
		assertEquals(expected, new ReqIFContent().toXml(0));
	}
}
