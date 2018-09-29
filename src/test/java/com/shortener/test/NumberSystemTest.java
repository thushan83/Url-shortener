package com.shortener.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shortener.util.Base70NumberSystem;
import com.shortener.util.NumberSystem;

class NumberSystemTest {
	
	NumberSystem numberSystem;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void base70NumberSystemTest1() {
		String expected = "b";
		numberSystem = new Base70NumberSystem();
		String actual = numberSystem.getConvertedValue(1);
		assertEquals(expected, actual);
	}
	
	@Test
	void base70NumberSystemTest2() {
		String expected = "ahv";
		numberSystem = new Base70NumberSystem();
		String actual = numberSystem.getConvertedValue(583);
		assertEquals(expected, actual);
	}

	
	@Test
	void base70NumberSystemTest3() {
		String expected = "b";
		numberSystem = new Base70NumberSystem();
		String actual = numberSystem.getConvertedValue(1);
		assertEquals(expected, actual);
	}


}
