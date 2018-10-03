package com.shortener.service;

import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.shortener.model.ShortenUrlInfo;
import com.shortener.repository.UrlRepository;

@Component
public class UrlShortenerMongoRedisImpl extends UrlShortenerBase implements UrlShortener {

	@Autowired
	UrlRepository urlRepository;

	@Override
	protected void initialize() {
		counter = urlRepository.getSize();
		super.initialize();
	}

	@Override
	public String shortenUrl(URL url) {
		String key = "";
		ShortenUrlInfo cacheHit = cacheHit(url.toString());

		if (cacheHit == null) {
			ShortenUrlInfo match = urlRepository.findByoriginalURL(url.toString());
			if (match == null) {
				key = numberSystem.getConvertedValue(counter);

				ShortenUrlInfo data = new ShortenUrlInfo();
				data.setKey(key);
				data.setOriginalURL(url.toString());

				urlRepository.addNewUrl(data);
				// push into Redis to make the next fetch fast
				hashOperations.put(HASH_KEY, key, data);
				counter++;
			} else {
				// push into Redis to make the next fetch fast
				hashOperations.put(HASH_KEY, key, match);
				key = match.getKey();
			}
		} else {
			key = cacheHit.getKey();
		}

		return PROTOCOL + DOMAIN + key;
	}

	@Override
	public String getOriginalUrl(String key) {
		// initial look up in Redis and if failed then try
		// persistance layer
		ShortenUrlInfo match = hashOperations.get(HASH_KEY, key);
		if (match == null) {
			match = urlRepository.findBykey(key);
		}
		
		return match.getOriginalURL();
	}

	@Override
	public void reset() {
		super.reset();
		urlRepository.clear();		
	}
}
