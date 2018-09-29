package com.shortener.service.test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.shortener.service.UrlShortener;

@RunWith(SpringRunner.class)
@SpringBootTest
class UrlShortenerImplTest {
		
	@Autowired
	UrlShortener urlShortener;
		
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
