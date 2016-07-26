package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReqIFHeaderTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new ReqIFHeader().toString(), equalTo("<REQ-IF-HEADER></REQ-IF-HEADER>"));
	}
	
}
