package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecRelationsTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new SpecRelations().toString(), equalTo("<SPEC-RELATIONS></SPEC-RELATIONS>"));
	}
	
}
