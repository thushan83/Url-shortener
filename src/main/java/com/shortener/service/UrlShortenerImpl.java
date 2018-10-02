package com.shortener.service;

import java.net.URL;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.shortener.model.ShortenUrlInfo;
import com.shortener.repository.UrlRepository;
import com.shortener.util.NumberSystem;
import com.shortener.util.UrlValidator;

@Component
public class UrlShortenerImpl implements UrlShortener {

	private final String PROTOCOL = "http://";
	private final String DOMAIN = "shrt.lk/";
	private static final String HASH_KEY = "URLS";

	@Autowired
	UrlValidator urlValidator;

	@Autowired
	NumberSystem numberSystem;

	@Autowired
	UrlRepository urlRepository;
	
	@Autowired
	RedisTemplate<String, ShortenUrlInfo> template;
	
	private HashOperations<String, String, ShortenUrlInfo> hashOperations;
	
	@PostConstruct
	private void initialize() {
		hashOperations = template.opsForHash();
	}

	@Override
	public String shortenUrl(URL url) {
		String key = numberSystem.getConvertedValue(urlRepository.getSize());
		ShortenUrlInfo match =  urlRepository.findByoriginalURL(url.toString());

		if (match == null) {
			
			ShortenUrlInfo data = new ShortenUrlInfo();
			data.setKey(key);
			data.setOriginalURL(url.toString());
			
			urlRepository.addNewUrl(data);
			hashOperations.put(HASH_KEY, key, data);
		}else {
			key = match.getKey();
		}
		return PROTOCOL + DOMAIN + key;
	}

	@Override
	public String getOriginalUrl(String key) {
		ShortenUrlInfo match = hashOperations.get(HASH_KEY, key);
		if(match == null) {
			match = urlRepository.findBykey(key);
			return match.getOriginalURL();
		}else {
		    return match.getOriginalURL();
		}
	}

	public void reset() {
		urlRepository.clear();
	}
}
