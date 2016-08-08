package com.tozzr.reqif.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.tozzr.reqif.domain.SpecRelations;

public class SpecRelationsTest {

	@Test
	public void testToXml() throws Exception {
		assertThat(new SpecRelations().toXml(1), equalTo(" <SPEC-RELATIONS>\n </SPEC-RELATIONS>\n"));
	}
	
}
