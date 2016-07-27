package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class DataTypeDefinitionEnumerationTest {

	@Test
	public void testToString() throws Exception {
		DataTypeDefinitionEnumeration sut = new DataTypeDefinitionEnumeration("myId", "last-change");
		String expected = 
			"<DATATYPE-DEFINITION-ENUMERATION "
		  + "IDENTIFIER=\"myId\" "
		  + "LAST-CHANGE=\"last-change\""
		  + ">"
		  + new SpecifiedValues()
		  + "</DATATYPE-DEFINITION-ENUMERATION>";
		assertThat(sut.toString(), equalTo(expected));
	}
	
}
