package com.shortener.model;

import java.io.Serializable;

public class UrlInfo implements Serializable{	

	private static final long serialVersionUID = 1L;


	private String shortenedURL;
	

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
