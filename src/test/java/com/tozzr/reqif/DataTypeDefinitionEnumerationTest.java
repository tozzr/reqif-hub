package com.tozzr.reqif;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataTypeDefinitionEnumerationTest {

	@Test
	public void testToXml() throws Exception {
		DataTypeDefinitionEnumeration sut = new DataTypeDefinitionEnumeration("myId", "last-change");
		String expected = 
			"<DATATYPE-DEFINITION-ENUMERATION "
		  + "IDENTIFIER=\"myId\" "
		  + "LAST-CHANGE=\"last-change\""
		  + ">\n"
		  + new SpecifiedValues().toXml(2)
		  + "</DATATYPE-DEFINITION-ENUMERATION>\n";
		assertEquals(expected, sut.toXml(0));
	}
	
}
