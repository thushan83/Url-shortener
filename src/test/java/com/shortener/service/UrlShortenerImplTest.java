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
		String expected = "http://shrt.lk/b";
		URL url = null;
		try {
			url = new URL("https://marketplace.eclipse.org/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String actual = urlShortener.shortenUrl(url);
		assertEquals(expected, actual);
	}
	
}
