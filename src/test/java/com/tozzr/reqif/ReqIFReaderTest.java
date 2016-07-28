package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class ReqIFReaderTest {

	private ReqIFReader reader;
	private ReqIF reqIF;

	@Before
	public void setUp() throws Exception {
		reader = new ReqIFReader();
		reqIF = reader.read("src/test/resources/Test.reqif");
	}

	@Test
	public void read_header() throws Exception {
		assertThat(reqIF.theHeader.comment, equalTo("Created by: tozzr.com"));
		assertThat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(reqIF.theHeader.creationTime), equalTo("2016-07-15T06:50:18.224+02:00"));
		assertThat(reqIF.theHeader.identifier, equalTo("rmf-94fa9e02-2503-40a5-a129-3bf79216c65f"));
		assertThat(reqIF.theHeader.reqIFToolId, equalTo("fmStudio (http://formalmind.com/studio)"));
		assertThat(reqIF.theHeader.reqIFVersion, equalTo("1.0"));
		assertThat(reqIF.theHeader.sourceToolId, equalTo("fmStudio (http://formalmind.com/studio)"));
		assertThat(reqIF.theHeader.title, equalTo("My ReqIF file"));
	}
	
	@Test
	public void read_datatypes() throws Exception {
		assertThat(reqIF.coreContent.dataTypes.get(0).getType(), equalTo("STRING"));
		assertThat(reqIF.coreContent.dataTypes.get(1).getType(), equalTo("STRING"));
		assertThat(reqIF.coreContent.dataTypes.get(2).getType(), equalTo("XHTML"));
		assertThat(reqIF.coreContent.dataTypes.get(3).getType(), equalTo("XHTML"));
		assertThat(reqIF.coreContent.dataTypes.get(4).getType(), equalTo("XHTML"));
		assertThat(reqIF.coreContent.dataTypes.get(5).getType(), equalTo("XHTML"));
		assertThat(reqIF.coreContent.dataTypes.get(6).getType(), equalTo("STRING"));
	}
}
