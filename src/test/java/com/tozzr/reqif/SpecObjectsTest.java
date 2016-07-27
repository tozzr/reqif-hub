package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecObjectsTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new SpecObjects().toString(), equalTo("<SPEC-OBJECTS></SPEC-OBJECTS>"));
	}
	
}
