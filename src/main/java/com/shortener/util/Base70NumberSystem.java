package com.shortener.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Base70NumberSystem implements NumberSystem {
	
	@Autowired
	Symbols symbols;
	
	public Base70NumberSystem(Symbols symbols) {
		
		for (char symbol = 'a'; symbol <= 'z'; symbol++) {
		   symbols.add(String.valueOf(symbol));
		}
		
		for (char symbol = 'A'; symbol <= 'Z'; symbol++) {
		   symbols.add(String.valueOf(symbol));
		}
		
		symbols.add("#");
		symbols.add("+");
		symbols.add("-");
		symbols.add("$");
		symbols.add(",");
		symbols.add("~");
		symbols.add("&");
		symbols.add("=");
	}
	
	
	private String devideBy70(int input) {
		int result = input/70;
		int mod = input%70;
		Symbols convertedValue = new Symbols();
		if(result == 0) {
			return convertedValue.reverse();
		}else {
			convertedValue.add(symbols.get(mod));
			return devideBy70(result);
		}
	}
		
	@Override
	public String getConvertedValue(int base10Number) {
		if(base10Number > 0) {
			return devideBy70(base10Number);
		}else {
			return null;
		}
	}

}
