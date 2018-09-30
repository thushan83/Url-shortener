package com.shortener.service;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlShortenerImplTest {

	@Autowired
	private UrlShortener urlShortener;

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
	public void testGetOriginalUrl() {
		((UrlShortenerImpl)urlShortener).reset();
		String expected = "https://marketplace.eclipse.org/123";
		URL url = null;
		try {
			url = new URL(expected);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		urlShortener.shortenUrl(url);
		String actual = urlShortener.getActualUrl("a");
		assertEquals(expected, actual);
	}
	
	
}
