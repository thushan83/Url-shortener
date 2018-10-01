package com.shortener.service;

import java.net.URL;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shortener.repository.UrlRepository;
import com.shortener.util.NumberSystem;
import com.shortener.util.UrlValidator;

@Component
public class UrlShortenerImpl implements UrlShortener {

	private final String PROTOCOL = "http://";
	private final String DOMAIN = "shrt.lk/";

	@Autowired
	UrlValidator urlValidator;

	@Autowired
	NumberSystem numberSystem;

	@Autowired
	UrlRepository urlRepository;

	@Override
	public String shortenUrl(URL url) {
		String key = numberSystem.getConvertedValue(urlRepository.getSize());
		String existingKey = urlRepository.exists(url.toString());
		if (existingKey == null) {
			urlRepository.addNewUrl(key, url);
		}else {
			key = existingKey;
		}
		return PROTOCOL + DOMAIN + key;
	}

	@Override
	public String getActualUrl(String key) {
		return urlRepository.getOriginalUrlByKey(key);
	}

	public void reset() {
		urlRepository.clear();
	}
}
