package com.shortener.service;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shortener.util.UrlValidator;

@Component
public class UrlShortenerImpl implements UrlShortener{
	
	@Autowired
	UrlValidator urlValidator;

	@Override
	public String shortenUrl(URL url) {
		// TODO Auto-generated method stub
		return null;
	}

}
