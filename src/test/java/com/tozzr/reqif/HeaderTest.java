package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class HeaderTest {

	@Test
	public void hasReqIFHeader() throws Exception {
		assertThat(new Header("myId").getReqIFHeader().toString(), equalTo(new ReqIFHeader("myId").toString()));
	}

	@Test
	public void testToString() throws Exception {
		assertThat(new Header("myId").toString(), equalTo("<THE-HEADER>" + new Header("myId").getReqIFHeader().toString() + "</THE-HEADER>"));
	}
}
