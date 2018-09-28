package com.shortener.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class UrlValidatorImpl implements UrlValidator{

	@Override
	public URL getURL(String url){
		URL urlObj = null;
		try {
			urlObj = new URL(url);
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}
		return urlObj;
	}
}
