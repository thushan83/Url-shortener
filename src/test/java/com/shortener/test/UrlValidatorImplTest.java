package com.shortener.test;

import static org.junit.jupiter.api.Assertions.*;
import java.net.URL;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import com.shortener.util.UrlValidator;

@RunWith(SpringRunner.class)
class UrlValidatorImplTest {

	@Autowired
	UrlValidator urlValidator;

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
