package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TitleTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new Title().toString(), equalTo("<TITLE></TITLE>"));
	}
	
	@Test
	public void withText() throws Exception {
		assertThat(new Title("some title").toString(), equalTo("<TITLE>some title</TITLE>"));
	}
}
