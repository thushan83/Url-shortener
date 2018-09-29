package com.shortener.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shortener.util.Symbols;

class SymbolsTest {
	
	Symbols<String> symbols;

	@BeforeEach
	void setUp() throws Exception {
		symbols= new Symbols<String>();
		symbols.add("a");
		symbols.add("b");
		symbols.add("c");
	}

	@Test
	void reverseTest() {
		String expected = "cba";
		String actual = symbols.reverse();
		assertEquals(expected, actual);
	}

}
 