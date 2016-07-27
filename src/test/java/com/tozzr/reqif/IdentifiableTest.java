package com.tozzr.reqif;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class IdentifiableTest {

	private MyIdentifiable myId	;
	
	@Before
	public void setUp() throws Exception {
		myId = new MyIdentifiable();
	}
	
	@Test
	public void properties_desc() throws Exception {
		myId.setDesc("some description");
		assertThat(myId.getDesc(), equalTo("some description"));
	}
	
	@Test
	public void properties_identifier() throws Exception {
		myId.setIdentifier("some id");
		assertThat(myId.getIdentifier(), equalTo("some id"));
	}
	
	@Test
	public void properties_lastChange() throws Exception {
		Date date = new Date();
		myId.setLastChange(date);
		assertThat(myId.getLastChange(), equalTo(date));
	}
	
	@Test
	public void properties_longName() throws Exception {
		myId.setLongName("some long name");
		assertThat(myId.getLongName(), equalTo("some long name"));
	}
	
	class MyIdentifiable extends Identifiable {
	}
	
	
	abstract class Identifiable {
		
		private String desc;
		private String identifier;
		private Date lastChange;
		private String longName;
		
		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getIdentifier() {
			return identifier;
		}

		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}

		public Date getLastChange() {
			return lastChange;
		}

		public void setLastChange(Date lastChange) {
			this.lastChange = lastChange;
		}

		public String getLongName() {
			return longName;
		}

		public void setLongName(String longName) {
			this.longName = longName;
		}
		
	}
}
