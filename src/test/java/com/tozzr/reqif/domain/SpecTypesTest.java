package com.tozzr.reqif.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.tozzr.reqif.domain.SpecTypes;

public class SpecTypesTest {

	@Test
	public void testToXml() throws Exception {
		assertThat(new SpecTypes().toXml(0), equalTo("<SPEC-TYPES>\n</SPEC-TYPES>\n"));
	}
	
}
