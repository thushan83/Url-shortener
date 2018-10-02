package com.shortener.repository;

import java.net.URL;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.shortener.model.ShortenUrlInfo;

public interface UrlRepository extends MongoRepository<ShortenUrlInfo, String> {
	
	default long getSize() {
		return this.count();		
	}
	
	ShortenUrlInfo findByoriginalURL(String originalURL);
	
	ShortenUrlInfo findBykey(String key);
		
	default void addNewUrl(String key, URL url) {
		ShortenUrlInfo data = new ShortenUrlInfo();
		data.setKey(key);
		data.setOriginalURL(url.toString());
		this.save(data);
	}
		
	default void clear() {
		this.deleteAll();
	}
}
