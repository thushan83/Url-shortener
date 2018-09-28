package com.shortener.service;

import java.net.URL;

public interface UrlShortener {
	String getActualUrl(String key);
    String shortenUrl(URL url);
}
