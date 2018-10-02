package com.shortener.service;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shortener.util.UnitTestHelper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlShortenerImplTest {

	@Autowired
	private UrlShortener urlShortener;
	
	@AfterEach
	public void cleanData() {
		((UrlShortenerImpl)urlShortener).reset();
	}

	@Test
	public void testUrlShorten() {
		((UrlShortenerImpl)urlShortener).reset();
		String expected = "http://shrt.lk/a";
		URL url = null;
		try {
			url = new URL("https://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1794107");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String actual = urlShortener.shortenUrl(url);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testUrlShorten2() {
		((UrlShortenerImpl)urlShortener).reset();
		String expected = "http://shrt.lk/b";
		URL url1 = null, url2 = null;
		try {
			url1 = new URL("https://marketplace.eclipse.org/");
			url2 = new URL("https://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1794107");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		urlShortener.shortenUrl(url1);
		String actual = urlShortener.shortenUrl(url2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testUrlShorten3() {
		((UrlShortenerImpl)urlShortener).reset();
		String expected = "http://shrt.lk/c";
		URL url1 = null, url2 = null, url3 = null;
		try {
			url1 = new URL("https://marketplace.eclipse.org/");
			url2 = new URL("https://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1794107");
			url3 = new URL("https://marketplace.eclipse.org/marketplace-client-intro");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		urlShortener.shortenUrl(url1);
		urlShortener.shortenUrl(url2);
		String actual = urlShortener.shortenUrl(url3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testnSameShortenUrlForAUrlAlways() {
		((UrlShortenerImpl)urlShortener).reset();
		String expected = "http://shrt.lk/a";
		URL url1 = null;
		
		try {
			url1 = new URL("https://marketplace.eclipse.org/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		String actual1 = urlShortener.shortenUrl(url1);
		String actual2 = urlShortener.shortenUrl(url1);
		String actual3 = urlShortener.shortenUrl(url1);
				
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);		
	}
	
	@Test
	public void testGetOriginalUrl() {
		((UrlShortenerImpl)urlShortener).reset();
		String expected1 = "https://marketplace.eclipse.org/";
		String expected2 = "https://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1794107";
		String expected3 = "https://marketplace.eclipse.org/marketplace-client-intro";
		URL url1 = null, url2 = null, url3 = null;
		
		try {
			url1 = new URL("https://marketplace.eclipse.org/");
			url2 = new URL("https://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1794107");
			url3 = new URL("https://marketplace.eclipse.org/marketplace-client-intro");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		String shortenUrl1 = urlShortener.shortenUrl(url1);
		String shortenUrl2 = urlShortener.shortenUrl(url2);
		String shortenUrl3 = urlShortener.shortenUrl(url3);
		
		String actual1 = urlShortener
				.getActualUrl(UnitTestHelper.getInstance().getKeyFromShortenUrl(shortenUrl1));
		assertEquals(expected1, actual1);
		String actual2 = urlShortener
				.getActualUrl(UnitTestHelper.getInstance().getKeyFromShortenUrl(shortenUrl2));
		assertEquals(expected2, actual2);
		String actual3 = urlShortener
				.getActualUrl(UnitTestHelper.getInstance().getKeyFromShortenUrl(shortenUrl3));
		assertEquals(expected3, actual3);
	}	
}
