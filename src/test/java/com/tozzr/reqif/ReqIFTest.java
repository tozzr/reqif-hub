package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReqIFTest {

	@Test
	public void hasHeader() throws Exception {
		assertThat(new ReqIF().getHeader().toString(), equalTo(new Header().toString()));
	}
	
	@Test
	public void hasCoreContent() throws Exception {
		assertThat(new ReqIF().getCoreContent().toString(), equalTo(new CoreContent().toString()));
	}
}
