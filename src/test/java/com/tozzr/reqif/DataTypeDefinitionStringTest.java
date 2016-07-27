package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class DataTypeDefinitionStringTest {

	@Test
	public void testToString() throws Exception {
		DataTypeDefinitionString sut = new DataTypeDefinitionString("myId", "last-change", 1000);
		String expected = 
			"<DATATYPE-DEFINITION-STRING "
		  + "IDENTIFIER=\"myId\" "
		  + "LAST-CHANGE=\"last-change\" "
		  + "MAX-LENGTH=\"1000\""
		  + "></DATATYPE-DEFINITION-STRING>";
		assertThat(sut.toString(), equalTo(expected));
	}
	
}
