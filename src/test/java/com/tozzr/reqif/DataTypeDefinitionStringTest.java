package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class DataTypeDefinitionStringTest {

	@Test
	public void testToXml() throws Exception {
		DataTypeDefinitionString sut = new DataTypeDefinitionString("myId", "last-change", 1000);
		String expected = 
			"<DATATYPE-DEFINITION-STRING "
		  + "IDENTIFIER=\"myId\" "
		  + "LAST-CHANGE=\"last-change\" "
		  + "MAX-LENGTH=\"1000\""
		  + ">\n"
		  + "</DATATYPE-DEFINITION-STRING>\n";
		assertThat(sut.toXml(0), equalTo(expected));
	}
	
}
