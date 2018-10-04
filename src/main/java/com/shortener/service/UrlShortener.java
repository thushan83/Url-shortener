package com.shortener.service;

import java.net.URL;

public interface UrlShortener {
	String getOriginalUrl(String key);
    String shortenUrl(URL url);
	void setBaseUrl(String baseUrl) ;
	
}
