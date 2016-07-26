package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReqIFWriterTest {

	@Test
	public void test() {
		ReqIFWriter writer = new ReqIFWriter();
		assertThat(writer.write(new ReqIF()), equalTo("<REQ-IF></REQ-IF>"));
	}
}
