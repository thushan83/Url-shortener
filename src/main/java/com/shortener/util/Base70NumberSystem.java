package com.shortener.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Base70NumberSystem implements NumberSystem {
	
	@Autowired
	private Symbols symbols;
	
	private Symbols convertedValues;
	
	public Base70NumberSystem(Symbols symbols) {
		
		convertedValues = new Symbols();
				
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
	
	
	
	private String devideBy70(int input) {
		int result = input/70;
		int mod = input%70;		
		convertedValues.add(symbols.get(mod));
		if(result == 0) {
			return convertedValues.reverse();
		}else {			
			return devideBy70(result);
		}
	}
	
	
	@Override
	public String getConvertedValue(int base10Number) {
		reset();
		return devideBy70(base10Number);		
	}
	
	public void reset() {
		convertedValues.clear();
	}

}
