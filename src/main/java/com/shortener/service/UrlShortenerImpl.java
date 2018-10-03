package com.shortener.service;

import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
	private final String META_ENTRY_COUNT_KEY = "meta_entry_count_key";

	private long counter = 0;

	@Autowired
	UrlValidator urlValidator;

	@Autowired
	NumberSystem numberSystem;

	@Autowired
	UrlRepository urlRepository;

	@Autowired
	RedisTemplate<String, ShortenUrlInfo> template;

	@Autowired
	RedisTemplate<String, Long> templateCounter;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	private HashOperations<String, String, ShortenUrlInfo> hashOperations;

	private ValueOperations<String, Long> valueOperations;

	@PostConstruct
	private void initialize() {
		hashOperations = template.opsForHash();
		valueOperations = templateCounter.opsForValue();
		counter = urlRepository.getSize();
	}

	private ShortenUrlInfo cacheHit(String url) {
		Optional<Entry<String, ShortenUrlInfo>> result = hashOperations.entries(HASH_KEY).entrySet().stream()
				.filter(item -> item.getValue().getOriginalURL().equals(url)).findFirst();

		ShortenUrlInfo entry = null;

		if (result.orElse(null) != null)
			entry = result.get().getValue();

		return entry;
	}

	@Override
	public String shortenUrl(URL url) {
		String key = numberSystem.getConvertedValue(counter);

		ShortenUrlInfo cacheHit = cacheHit(url.toString());

		if (cacheHit == null) {
			ShortenUrlInfo match = urlRepository.findByoriginalURL(url.toString());
			if (match == null) {
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
			return match.getOriginalURL();
		} else {
			return match.getOriginalURL();
		}
	}

	public void reset() {
		urlRepository.clear();
		redisConnectionFactory.getConnection().flushAll();
		counter = 0;
	}
}
