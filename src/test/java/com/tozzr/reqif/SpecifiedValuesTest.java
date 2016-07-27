package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class SpecifiedValuesTest {

	@Test
	public void testToString() throws Exception {
		String expected = 
			"<SPECIFIED-VALUES>"
//		  + new ArrayList<EnumValue>()
		  + "</SPECIFIED-VALUES>";
		assertThat(new SpecifiedValues().toString(), equalTo(expected));
	}
	
}
