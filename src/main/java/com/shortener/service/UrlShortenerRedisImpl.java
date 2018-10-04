package com.shortener.service;

import java.net.URL;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.shortener.model.ShortenUrlInfo;

@Component
@Primary
public class UrlShortenerRedisImpl extends UrlShortenerBase implements UrlShortener {

	@Override
	public String getOriginalUrl(String key) {
		ShortenUrlInfo match = hashOperations.get(HASH_KEY, key);
		return match.getOriginalURL();
	}

	@Override
	public String shortenUrl(URL url) {
		String key = "";
		ShortenUrlInfo cacheHit = cacheHit(url.toString());
		if (cacheHit == null) {
			key = numberSystem.getConvertedValue(counter);
			
			ShortenUrlInfo data = new ShortenUrlInfo();
			data.setKey(key);
			data.setOriginalURL(url.toString());

			hashOperations.put(HASH_KEY, key, data);
			counter++;
		} else {
			key = cacheHit.getKey();
		}

		return baseUrl + key;
	}

	@Override
	public void setBaseUrl(String baseUrl) {
		super.baseUrl = baseUrl;
	}

}
