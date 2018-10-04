package com.shortener.service;

import java.util.Optional;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.shortener.model.ShortenUrlInfo;
import com.shortener.util.NumberSystem;
import com.shortener.util.UrlValidator;

public class UrlShortenerBase {
		
	protected static final String HASH_KEY = "URLS";
	protected final String META_ENTRY_COUNT_KEY = "meta_entry_count_key";
	protected long counter = 0;
	protected HashOperations<String, String, ShortenUrlInfo> hashOperations;
	protected String baseUrl;
	
	@Autowired
	UrlValidator urlValidator;

	@Autowired
	NumberSystem numberSystem;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;
	
	@Autowired
	RedisTemplate<String, ShortenUrlInfo> template;
	
	@PostConstruct
	protected void initialize() {
		hashOperations = template.opsForHash();
	}
	
	protected ShortenUrlInfo cacheHit(String url) {
		Optional<Entry<String, ShortenUrlInfo>> result = hashOperations.entries(HASH_KEY).entrySet().stream()
				.filter(item -> item.getValue().getOriginalURL().equals(url)).findFirst();

		ShortenUrlInfo entry = null;

		if (result.orElse(null) != null)
			entry = result.get().getValue();

		return entry;
	}
	
	public void reset() {
		redisConnectionFactory.getConnection().flushAll();
		counter = 0;
	}
}
