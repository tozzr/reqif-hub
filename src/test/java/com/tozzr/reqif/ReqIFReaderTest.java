package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;

import org.junit.Test;

public class ReqIFReaderTest {

	@Test
	public void read() throws Exception {
		ReqIFReader reader = new ReqIFReader();
		ReqIF reqIF = reader.read("src/test/resources/Test.reqif");
		assertThat(reqIF.getHeader().comment, equalTo("Created by: tozzr.com"));
		assertThat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(reqIF.getHeader().creationTime), equalTo("2016-07-15T06:50:18.224+02:00"));
		assertThat(reqIF.getHeader().identifier, equalTo("rmf-94fa9e02-2503-40a5-a129-3bf79216c65f"));
		assertThat(reqIF.getHeader().reqIFToolId, equalTo("fmStudio (http://formalmind.com/studio)"));
		assertThat(reqIF.getHeader().reqIFVersion, equalTo("1.0"));
		assertThat(reqIF.getHeader().sourceToolId, equalTo("fmStudio (http://formalmind.com/studio)"));
		assertThat(reqIF.getHeader().title, equalTo("My ReqIF file"));
	}
}
