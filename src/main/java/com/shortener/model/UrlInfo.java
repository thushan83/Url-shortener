package com.shortener.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class UrlInfo {	

	@Field("ShortenedUrl")
	private String shortenedURL;
	
	@Field("OriginlUrl")
	private String originalURL;

	
	public String getShortenedURL() {
		return shortenedURL;
	}

	public void setShortenedURL(String shortenedURL) {
		this.shortenedURL = shortenedURL;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

}
