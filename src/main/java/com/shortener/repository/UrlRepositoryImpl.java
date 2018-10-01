package com.shortener.repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import org.springframework.stereotype.Component;

@Component
public class UrlRepositoryImpl implements UrlRepository {
	private HashMap<String, URL> urlDictionary = null;

	public UrlRepositoryImpl() {
		urlDictionary = new HashMap<>();
	}

	private String searchKeyByUrl(String url) {
		Entry<String, URL> match = urlDictionary.entrySet().stream().filter(x -> x.getValue().toString().equals(url))
				.findFirst().get();
		return match.getKey();
	}

	@Override
	public String exists(String url) {
		try {
			if (urlDictionary.containsValue(new URL(url))) {
				return searchKeyByUrl(url);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
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
