package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class DataTypesTest {

	@Test
	public void testToXml() throws Exception {
		assertThat(new DataTypes().toXml(1), equalTo(" <DATATYPES>\n </DATATYPES>\n"));
	}
	
	@Test
	public void canHaveDataTypeDefinitionString() throws Exception {
		DataTypes dataTypes = new DataTypes();
		dataTypes.types.add(new DatatypeDefinitionString("ID", 1000));
		String expected = 
			"<DATATYPES>\n"
		  + new DatatypeDefinitionString("ID", 1000).toXml(2)
		  + "</DATATYPES>\n";
		assertThat(dataTypes.toXml(0), equalTo(expected));
	}
	
	@Test
	public void canHaveDataTypeDefinitionEnumeration() throws Exception {
		DataTypes dataTypes = new DataTypes();
		dataTypes.types.add(new DataTypeDefinitionEnumeration("ID", "last-change"));
		String expected = 
			"<DATATYPES>\n"
		  + new DataTypeDefinitionEnumeration("ID", "last-change").toXml(2)
		  + "</DATATYPES>\n";
		assertThat(dataTypes.toXml(0), equalTo(expected));
	}
	
}
