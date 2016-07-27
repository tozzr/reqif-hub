package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class DataTypesTest {

	@Test
	public void testToString() throws Exception {
		assertThat(new DataTypes().toString(), equalTo("<DATATYPES></DATATYPES>"));
	}
	
	@Test
	public void canHaveDataTypeDefinitionString() throws Exception {
		DataTypes dataTypes = new DataTypes();
		dataTypes.addElement(new DataTypeDefinitionString("ID", 1000));
		assertThat(dataTypes.toString(), equalTo("<DATATYPES>" + new DataTypeDefinitionString("ID", 1000) + "</DATATYPES>"));
	}
	
	@Test
	public void canHaveDataTypeDefinitionEnumeration() throws Exception {
		DataTypes dataTypes = new DataTypes();
		dataTypes.addElement(new DataTypeDefinitionEnumeration("ID", "last-change"));
		assertThat(dataTypes.toString(), equalTo("<DATATYPES>" + new DataTypeDefinitionEnumeration("ID", "last-change") + "</DATATYPES>"));
	}
	
}
