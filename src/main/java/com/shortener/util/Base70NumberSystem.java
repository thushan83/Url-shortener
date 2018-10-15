package com.shortener.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Base70NumberSystem implements NumberSystem {
	
	@Autowired
	private Symbols symbols;	
	
	public Base70NumberSystem(Symbols symbols) {
						
		for (char symbol = 'a'; symbol <= 'z'; symbol++) {
		   symbols.add(String.valueOf(symbol));
		}
		
		for (char symbol = 'A'; symbol <= 'Z'; symbol++) {
		   symbols.add(String.valueOf(symbol));
		}
		
		for (int symbol = 0; symbol <= 9; symbol++) {
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
		
	private String devideBy70(long input, Symbols convertedValues) {		
		long result = input/70;
		long mod = input%70;		
		convertedValues.add(symbols.get((int) mod));
		if(result == 0) {
			return convertedValues.reverse();
		}else {			
			return devideBy70(result,convertedValues);
		}
	}
	
	
	@Override
	public String getConvertedValue(long base10Number) {
		Symbols convertedValues = new Symbols();
		return devideBy70(base10Number, convertedValues);		
	}
	
}
