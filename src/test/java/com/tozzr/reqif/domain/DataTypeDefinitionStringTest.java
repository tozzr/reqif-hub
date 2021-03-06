package com.tozzr.reqif.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tozzr.reqif.domain.DatatypeDefinitionString;

public class DataTypeDefinitionStringTest {

	@Test
	public void testToXml() throws Exception {
		DatatypeDefinitionString sut = new DatatypeDefinitionString("myId", "last-change", "long-name", 1000);
		String expected = 
			"<DATATYPE-DEFINITION-STRING "
		  + "IDENTIFIER=\"myId\" "
		  + "LAST-CHANGE=\"last-change\" "
		  + "LONG-NAME=\"long-name\" "
		  + "MAX-LENGTH=\"1000\""
		  + "/>\n";
		assertEquals(expected, sut.toXml(0));
	}
	
}
