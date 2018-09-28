package com.shortener.test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shortener.util.UrlValidator;
import com.shortener.util.UrlValidatorImpl;

class UrlValidatorImplTest {

	
	UrlValidator urlValidator;
	
	@BeforeEach
	void setUp() throws Exception {
	  urlValidator = new UrlValidatorImpl();
	}

	@Test
	void testInvalidUrl() {
		URL expected = null;
    	URL actual = urlValidator.getURL("qwheugqwueguygqqye");			
	    assertEquals(expected, actual);
	}
	
	@Test
	void testValidUrl() {
		URL unexpected = null;
    	URL actual = urlValidator.getURL("https://www.google.lk");			
	    assertNotEquals(unexpected, actual);
	}

}
