package com.shortener.service;

import java.net.URL;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shortener.model.ShortenUrlInfo;
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
		ShortenUrlInfo match =  urlRepository.findByoriginalURL(url.toString());

		if (match == null) {			 
			urlRepository.addNewUrl(key, url);
		}else {
			key = match.getKey();
		}
		return PROTOCOL + DOMAIN + key;
	}

	@Override
	public String getActualUrl(String key) {
		ShortenUrlInfo match = urlRepository.findBykey(key);
		if(match != null)
			return match.getOriginalURL();
		else
		    return null; 
	}

	public void reset() {
		urlRepository.clear();
	}
}
