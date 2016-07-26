package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class HeaderTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new Header().toString(), equalTo("<THE-HEADER></THE-HEADER>"));
	}
	
	@Test
	public void hasReqIFHeader() throws Exception {
		assertThat(new Header().getReqIFHeader().toString(), equalTo(new ReqIFHeader().toString()));
	}
}
