package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class CommentTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new Comment().toString(), equalTo("<COMMENT></COMMENT>"));
	}
	
	@Test
	public void withText() throws Exception {
		assertThat(new Comment("some text").toString(), equalTo("<COMMENT>some text</COMMENT>"));
	}
}
