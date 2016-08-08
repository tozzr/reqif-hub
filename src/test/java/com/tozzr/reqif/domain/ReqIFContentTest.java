package com.tozzr.reqif.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tozzr.reqif.domain.ReqIFContent;
import com.tozzr.reqif.domain.SpecObjects;
import com.tozzr.reqif.domain.SpecRelations;
import com.tozzr.reqif.domain.SpecTypes;
import com.tozzr.reqif.domain.Specifications;

public class ReqIFContentTest {

	@Test
	public void testToXml() throws Exception {
		ReqIFContent reqIFContent = new ReqIFContent();
		String expected = 
			"<CORE-CONTENT>\n"
		  + "  <REQ-IF-CONTENT>\n" 
		  + reqIFContent.dataTypes.toXml(4)
		  + new SpecTypes().toXml(4)
		  + new SpecObjects().toXml(4)
		  + new SpecRelations().toXml(4)
		  + new Specifications().toXml(4)
		  + "  </REQ-IF-CONTENT>\n"
		  + "</CORE-CONTENT>\n";
		assertEquals(expected, reqIFContent.toXml(0));
	}
}
