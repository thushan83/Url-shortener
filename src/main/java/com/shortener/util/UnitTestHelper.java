package com.shortener.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UnitTestHelper{
	
	private static UnitTestHelper instance;
	
	static {
		instance = new UnitTestHelper();
	}
	
	private UnitTestHelper() {
		
	}
	
	public static UnitTestHelper getInstance() {
		return instance;
	}

	public String objToJSON(Object object) {				
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
