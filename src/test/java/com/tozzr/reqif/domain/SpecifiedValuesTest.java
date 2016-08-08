package com.tozzr.reqif.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.tozzr.reqif.domain.SpecifiedValues;

public class SpecifiedValuesTest {

	@Test
	public void testToXml() throws Exception {
		String expected = 
			"<SPECIFIED-VALUES>\n"
//		  + new ArrayList<EnumValue>()
		  + "</SPECIFIED-VALUES>\n";
		assertThat(new SpecifiedValues().toXml(0), equalTo(expected));
	}
	
}
