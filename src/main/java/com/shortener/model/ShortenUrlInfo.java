package com.shortener.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShortenUrlInfo extends UrlInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}		
	
}
