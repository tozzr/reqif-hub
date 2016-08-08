package com.tozzr.reqif.domain;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import com.tozzr.reqif.domain.ReqIF;
import com.tozzr.reqif.domain.ReqIFReader;
import com.tozzr.reqif.domain.ReqIFWriter;

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
	
}
