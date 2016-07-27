package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecRelationsTest {

	@Test
	public void testToXml() throws Exception {
		assertThat(new SpecRelations().toXml(1), equalTo(" <SPEC-RELATIONS>\n </SPEC-RELATIONS>\n"));
	}
	
}
