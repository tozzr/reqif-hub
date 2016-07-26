package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReqIFContentTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new ReqIFContent().toString(), equalTo("<REQ-IF-CONTENT></REQ-IF-CONTENT>"));
	}
	
}
