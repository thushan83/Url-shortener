package com.shortener.repository;

import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class UrlRepositoryImpl implements UrlRepository {
	private HashMap<String, URL> urlDictionary = null;
	
	public UrlRepositoryImpl() {
		urlDictionary = new HashMap<>();
	}	
	
	@Override
	public void addNewUrl(String key, URL url) {
		urlDictionary.put(key, url);
	}

	@Override
	public int getSize() {		
		return urlDictionary.size();
	}

	@Override
	public String getOriginalUrlByKey(String key) {
		return urlDictionary.get(key).toString();
	}

	@Override
	public void clear() {
		urlDictionary.clear();
	}
}
