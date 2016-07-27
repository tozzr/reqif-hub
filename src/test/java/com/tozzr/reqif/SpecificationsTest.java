package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecificationsTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new Specifications().toString(), equalTo("<SPECIFICATIONS></SPECIFICATIONS>"));
	}
	
}
