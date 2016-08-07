package com.tozzr.reqif;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

public class ReqIFIntegrationTest {

	@Test
	public void read_and_write_file() throws Exception {
		ReqIFReader reader = new ReqIFReader();
		String inputFilename = "src/test/resources/Test.reqif";
		ReqIF reqIF = reader.read(inputFilename);
		ReqIFWriter writer = new ReqIFWriter();
		assertEquals(getContent(inputFilename), writer.write(reqIF));
	}

	private String getContent(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return content;
	}
	
	@Test
	@Ignore
	public void parseXml() throws Exception {
		ReqIFReader reader = new ReqIFReader();
		String inputFilename = "src/test/resources/Test.reqif";
		reader.parse(inputFilename);
	}
}
