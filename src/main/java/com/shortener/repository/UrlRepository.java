package com.shortener.repository;

import java.net.URL;

public interface UrlRepository {
	
	void addNewUrl(String key,URL url);
	
	int getSize();
	
	String getOriginalUrlByKey(String key);
	
	void clear();

	String exists(String url);

}
