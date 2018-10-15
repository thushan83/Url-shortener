package com.shortener.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberSystemTest {
	

	@Autowired
	private Base70NumberSystem numberSystem;
	

	@Test
	public void base70NumberSystemTest1() {
		String expected = "b";
		String actual = numberSystem.getConvertedValue(1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void base70NumberSystemTest2() {
		String expected = "a";
		String actual = numberSystem.getConvertedValue(0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void base70NumberSystemTest3() {
		String expected = "ix";
		String actual = numberSystem.getConvertedValue(583);
		assertEquals(expected, actual);
	}
	
	@Test
	public void base70NumberSystemTest4() {
		String expected = "L+eu";
		String actual = numberSystem.getConvertedValue(13000000);
		assertEquals(expected, actual);
	}
}
