package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class CoreContentTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new CoreContent().toString(), equalTo("<CORE-CONTENT>" + new ReqIFContent() + "</CORE-CONTENT>"));
	}
}
