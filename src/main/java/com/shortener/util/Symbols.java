package com.shortener.util;

import java.util.ArrayList;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

@Component
public class Symbols<String> extends ArrayList<String> {

	private static final long serialVersionUID = 1L;

	public String reverse(){
		
		ListIterator<String> iterator = this.listIterator(size());
		StringBuilder stringBuilder = new StringBuilder();
		while(iterator.hasPrevious()){
			stringBuilder.append(iterator.previous());
		}
		return (String) stringBuilder.toString();		
	}
}
