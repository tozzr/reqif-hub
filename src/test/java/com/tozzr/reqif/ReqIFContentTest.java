package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReqIFContentTest {

	@Test
	public void testToString() throws Exception {
		String expected = 
			"<REQ-IF-CONTENT>" 
		  + new DataTypes()
		  + new SpecTypes()
		  + new SpecObjects()
		  + new SpecRelations()
		  + new Specifications()
		  + "</REQ-IF-CONTENT>";
		assertThat(new ReqIFContent().toString(), equalTo(expected));
	}
}
