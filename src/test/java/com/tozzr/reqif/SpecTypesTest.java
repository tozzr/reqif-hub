package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecTypesTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new SpecTypes().toString(), equalTo("<SPEC-TYPES></SPEC-TYPES>"));
	}
	
}
