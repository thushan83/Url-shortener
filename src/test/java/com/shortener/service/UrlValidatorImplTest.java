package com.shortener.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shortener.util.UrlValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlValidatorImplTest {

	@Autowired
	UrlValidator urlValidator;

	@Test
	public void testInvalidUrl() {
		URL actual = urlValidator.getURL("sdfssfsfsdfsdfsdf");
		assertNull(actual);
	}
	
	@Test
	public void testValidUrl() {
		URL actual = urlValidator.getURL("https://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1794107");
		assertNotNull(actual);
	}

}
