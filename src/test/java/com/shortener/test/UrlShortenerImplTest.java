package com.shortener.test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.shortener.service.UrlShortener;
import com.shortener.service.UrlShortenerImpl;

class UrlShortenerImplTest {
	
	UrlShortener urlShortener;
	
	@BeforeEach
	void setUp() throws Exception {
		urlShortener = new UrlShortenerImpl();
	}

	@Test
	void testShortenUrlMethod() {
		String expected = "https://shrt.lk/1";
		URL url = null;
		try {
			url = new URL("https://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1794107");
		} catch (MalformedURLException e) {
			//do nothing
		}
		String actual = urlShortener.shortenUrl(url);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetActualUrl() {
		fail("Not yet implemented");
	}
	
}
