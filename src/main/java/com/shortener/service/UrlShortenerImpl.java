package com.shortener.service;

import java.net.URL;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.shortener.util.UrlValidator;

@Component
public class UrlShortenerImpl implements UrlShortener{

	private HashMap<String, URL> urlDictionary = new HashMap<>();
	
	@Autowired
	UrlValidator urlValidator;

	@Override
	public String shortenUrl(URL url) {
		return "";
	}

	@Override
	public String getActualUrl(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
