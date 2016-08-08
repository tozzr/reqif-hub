package com.tozzr.reqif.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.tozzr.reqif.domain.SpecObjects;

public class SpecObjectsTest {

	@Test
	public void testToXml() throws Exception {
		assertThat(new SpecObjects().toXml(1), equalTo(" <SPEC-OBJECTS>\n </SPEC-OBJECTS>\n"));
	}
	
}
