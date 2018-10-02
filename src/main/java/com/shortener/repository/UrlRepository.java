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
		
	default void addNewUrl(ShortenUrlInfo data) {		
		this.save(data);
	}
		
	default void clear() {
		this.deleteAll();
	}
}
