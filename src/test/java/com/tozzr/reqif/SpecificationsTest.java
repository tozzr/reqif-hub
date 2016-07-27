package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecificationsTest {

	@Test
	public void testToXml() throws Exception {
		assertThat(new Specifications().toXml(0), equalTo("<SPECIFICATIONS>\n</SPECIFICATIONS>\n"));
	}
	
}
