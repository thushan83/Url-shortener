package com.shortener.util;

import java.util.ArrayList;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

@Component
public class Symbols  {
	
	ArrayList<String> symbols = new ArrayList<String>();		

	public String reverse(){		
		
		ListIterator<String> iterator = symbols.listIterator(symbols.size());
		StringBuilder stringBuilder = new StringBuilder();
		while(iterator.hasPrevious()){
			stringBuilder.append(iterator.previous());
		}
		return (String) stringBuilder.toString();		
	}

	public void add(String value) {
		symbols.add(value);
	}

	public String get(int index) {
		return symbols.get(index);
	}
}
