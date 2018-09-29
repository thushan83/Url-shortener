package com.shortener.service;

import java.net.URL;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shortener.util.NumberSystem;
import com.shortener.util.UrlValidator;

@Component
public class UrlShortenerImpl implements UrlShortener{

	private HashMap<String, URL> urlDictionary = new HashMap<>();
	
	private final String PROTOCOL = "http://";
	private final String DOMAIN = "shrt.lk/";
	
	@Autowired
	UrlValidator urlValidator;
	
	@Autowired
	NumberSystem numberSystem;

	@Override
	public String shortenUrl(URL url) {
		String key = numberSystem.getConvertedValue(urlDictionary.size());
		urlDictionary.put(key, url);
		return PROTOCOL+DOMAIN+key;
	}

	@Override
	public String getActualUrl(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
